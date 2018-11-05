#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <epm/epm.h>
#include <ict/ict_userservice.h>
#include <tc/tc.h>
#include <user_exits/user_exits.h>
#include <tc/tc.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>
#include <tc/folder.h>
#include <tccore/aom.h>
#include <ctype.h>
#include <tc\folder.h>
#include <lov\lov.h>
#include <error.h>
#include <sa/person.h>
#include <tccore\grm.h>

int result=0;

/////////////////Ostry - Testovaci/////////////////////////

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))
int TPV_HZ_make_rev_op(EPM_action_message_t msg);
extern "C" DLLAPI int TPV_HZ_make_rev_op_TC10_register_callbacks();
extern "C" DLLAPI int TPV_HZ_make_rev_op_TC10_init_module(int *decision, va_list args);
EPM_decision_t A_TPV_HZ_make_rev_op(EPM_rule_message_t msg);
void ListBomLineDil(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow);
void ListBomLineTP(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* typ_operace,char* pracoviste,char* Op_name,char* text_operace,char* rada_kooperace,char* slucovat,double cas_TB,double cas_TA,date_t datum_m );
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr,char* Lov);
int Kontrola(tag_t Add,tag_t Roottask);
static void add_int_to_int_array(int add_int, int *n_int_array, int **int_array);
static void add_tag_to_tag_array(tag_t add_tag, int *n_tag_array, tag_t **tag_array);
static void ECHO(char *format, ...);
 void revise_item_revisions(int num_target_objs, tag_t *target_object_tags);
 static int report_error(char *file, int line, char *call, int status,logical exit_on_error);
 void ListBOMLine_TP(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,tag_t* zmeny_op,int OpCount,tag_t RevParent);
  void Zmeny_TP(tag_t  TP, tag_t RootTask,tag_t* zmeny_op,int OpCount,char *cislo_op_zmena, char* Op_num);
  int Comparee_tag(tag_t hledany,tag_t* pole,int pocet);
  int Kontroly_kusovnikuTP(tag_t Rev_TP,tag_t RootTask,char* Id,char* Rev);
  void KontrolaOP_TP  (tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* Id_kontrol, char* Rev_kontrol);

extern "C" DLLAPI int TPV_HZ_make_rev_op_TC10_register_callbacks()
{
    printf("Registruji handler-TPV_HZ_make_rev_op_TC10.dll\n");
    CUSTOM_register_exit("TPV_HZ_make_rev_op_TC10", "USER_init_module", TPV_HZ_make_rev_op_TC10_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_HZ_make_rev_op_TC10_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_HZ_make_rev_op_TC10", "", TPV_HZ_make_rev_op);
    if(Status == ITK_ok) printf("Handler pro vyplneni kusovnik strediskem z Organization %s \n", "TPV_HZ_make_rev_op");


    return ITK_ok;
}

int TPV_HZ_make_rev_op(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int OpCount = 0,
	HZCount = 0,
	TPCount=0,
    n_ints_in_list = 0,
    n_tags_in_list = 0;
tag_t *Op = NULLTAG,
	*op_item=NULLTAG,
	tp_item=NULLTAG,
	*HZ = NULLTAG;

tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;
tag_t *all_deepcopydata_tags,
	*deepcopydata_tag;
tag_t relation;
tag_t type_tag,
	revType,
	*TP,
	TPnew,
	*HZ_hlavni,
	createRev,
	Opnew,
	object_tag;
tag_t *revise_input_tags = NULL;
tag_t relation_type,
	relation_type_TP;
tag_t *deepcopydata_tags = NULL;
int *all_attached_object_count = NULL,
	attached_object_count=NULL;
char
	* Obj_type; 


char *Type,
			* pracoviste_zmena,
			* typ_operace_zmena,
			* Op_name_zmena,
			* Op_num,
			* cislo_op_zmena,
			* slucovat_zmena,
			* text_operace_zmena,
			* cas_TB_stroj_zmena,
			* cas_TA_stroj_zmena,
			* datum_mereni,
			* vlozeni,
			* rada_kooperace_zmena;
		double
			cas_TA,
			cas_TB;
		date_t datum_m_zmena;
		int Num_query=0,
			*ifail;
//FILE *log;
//log=fopen("HZ_make_log","a+");


EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny

EPM_ask_attachments( RootTask,EPM_reference_attachment, &OpCount, &Op );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
EPM_ask_attachments( RootTask,EPM_target_attachment, &HZCount, &HZ );	
printf("\n-------Make Revision------\n \n");
  revise_input_tags = (tag_t *) MEM_alloc(OpCount * sizeof(tag_t));
  op_item = (tag_t *) MEM_alloc(OpCount * sizeof(tag_t));

  ////kontrola ze maji vsechny op v referencich aspon jednu vazbu na TP v targetech a obracenì 
int const TP_max_count=HZCount;
    tag_t *OP_menene=NULL,
		*TP_menene=NULL,
		*TP_menene_ns=NULL;
		TP_menene_ns=(tag_t *) MEM_alloc(HZCount*sizeof(*TP_menene));
		TP_menene=(tag_t *) MEM_alloc(HZCount*sizeof(*TP_menene));
		OP_menene=(tag_t *) MEM_alloc(OpCount*sizeof(*OP_menene));
  int TP_meneneCount=0,
	  TP_meneneCount_ns=0,
	  OP_meneneCount=0;
  printf("Op_count %d Hz_count %d \n",OpCount,HZCount);
 
  for(int ii=0;ii<OpCount;ii++)
  {
	  printf(" OpCount --- %d \n",OpCount);
	  int *levels=NULLTAG,n_parent=0;
	  tag_t *parent=NULLTAG,
		  Item=NULLTAG;
	 
		  char* Type2;
	 //Returns the object type of the specified WorkspaceObject.

				char Id[ITEM_id_size_c + 1];
				char RevId[ITEM_id_size_c + 1];
					
					 ITEM_ask_item_of_rev(Op[ii], &Item);
					 ITEM_ask_id(Item, Id);
					 ITEM_ask_rev_id(Op[ii], RevId);
					printf("ID/Rev %s/%s  \n",Id,RevId);
	  PS_where_used_precise(Op[ii],1,&n_parent,&levels,&parent);
	  /*printf("n_parent %d \n",n_parent);*/
	  if(n_parent==0)goto nedelej_zmeny;
	
	 
	  
	  
		  for(int iii=0;iii<HZCount;iii++)
		  {//printf("tp count %d \n",HZCount);
			  int is_released=0;
			   WSOM_ask_object_type2(HZ[iii],&Type2);

			 int Pouzito= Kontroly_kusovnikuTP(HZ[iii], RootTask,Id,RevId);
			 printf("pouzito %d \n",Pouzito);
			 if(Pouzito==1){
				if (strcmp(Type2,"H4_TPRevision")==0){
					 EPM_ask_if_released(HZ[iii],&is_released);

				 	if(Comparee_tag(HZ[iii],TP_menene,TP_meneneCount)==0  && is_released!=0){
						//printf("--Pridej do  TP %d == %d \n",parent[iii],HZ[j]);
						printf("174 ---------------------------------pridano \n");
						TP_menene[TP_meneneCount]=HZ[iii];
						
						TP_meneneCount++;
						
					}else if(Comparee_tag(HZ[iii],TP_menene_ns,TP_meneneCount_ns)==0 && is_released==0){
					printf("202 ---------------------------------pridano_ns \n");
						TP_menene_ns[TP_meneneCount_ns]=HZ[iii];
						TP_meneneCount_ns++;
						
					}
				}
					if(Comparee_tag(Op[ii],OP_menene,OP_meneneCount)==0){
						
						OP_menene[OP_meneneCount]=Op[ii];
						//printf("Pridej do Op %d = Op old %d \n",Op[ii],OP_menene[OP_meneneCount]);
						OP_meneneCount++;
					}
			 }
		  }

	nedelej_zmeny:;
  }
  
 revise_item_revisions(OP_meneneCount,OP_menene); 
 EPM_remove_attachments(RootTask,OpCount,Op);
 printf("-------remove ref - OP add %d\n",OP_meneneCount);
 for(int i=0;i<OP_meneneCount;i++)
		 {
		GRM_find_relation_type("H4_menene_op_rel", &relation_type);
		printf("find relation %d \n",relation_type);
		GRM_create_relation(*HZ, OP_menene[i], relation_type, NULLTAG,&relation);// Pridani do Relacnich adresaru
		GRM_save_relation(relation);
	
		 ITEM_ask_item_of_rev(OP_menene[i],&op_item[i]);
		 printf("item op \n");
		 ITEM_ask_latest_rev(op_item[i],&revise_input_tags[i]);
		 printf("latest rev \n");
		 const tag_t *attach=&revise_input_tags[i];
		 const int AttachmentTypes[1] = {EPM_reference_attachment};
								EPM_add_attachments(RootTask, 1,attach, AttachmentTypes);

		GRM_create_relation(*HZ, revise_input_tags[i], relation_type, NULLTAG,&relation);// Pridani do Relacnich adresaru nových revizí
		GRM_save_relation(relation);
		  printf("add to referece new op rev \n");
		 }
 ///Konec kontroly


  EPM_remove_attachments(RootTask,HZCount,HZ);
  for(int j=0;j<HZCount;j++){
WSOM_ask_object_type2(HZ[j],&Type);//Returns the object type of the specified WorkspaceObject.
		printf (" Type = %s %d \n",Type,strcmp(Type,"H4_HZRevision"));
		if(strcmp(Type,"H4_HZRevision")==0){
			//////////////PRIDANI DO RELACI

			 // for(int i=0;i<OP_meneneCount;i++)
			 // {
				//GRM_find_relation_type("H4_menene_op_rel", &relation_type);
				//printf("find relation %d \n",relation_type);
				//GRM_create_relation(HZ[j], OP_menene[i], relation_type, NULLTAG,&relation);// Pridani do Relacnich adresaru
				//GRM_save_relation(relation);
	
			 // ITEM_ask_item_of_rev(OP_menene[i],&op_item[i]);
			 // printf("item op \n");
			 // ITEM_ask_latest_rev(op_item[i],&revise_input_tags[i]);
			 // printf("latest rev \n");
			 // const tag_t *attach=&revise_input_tags[i];
			 // const int AttachmentTypes[1] = {EPM_reference_attachment};
				//						EPM_add_attachments(RootTask, 1,attach, AttachmentTypes);

			 //  printf("add to referece new op rev \n");
			 // }

			//////////PRACE S HZ
			HZ_hlavni=&HZ[j];
			const tag_t *attach_target=&HZ[j];	
			const int Target[1] = {EPM_target_attachment};
			EPM_add_attachments(RootTask, 1, attach_target, Target);
		 AOM_ask_value_string(HZ[j],"h4_HZ_cislo_operace",&Op_num);
		 AOM_ask_value_string(HZ[j],"h4_HZ_novy_typ_operace",&typ_operace_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_nazev_operace",&Op_name_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_cislo_operace",&cislo_op_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_pracoviste",&pracoviste_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_TB_stroj",&cas_TB_stroj_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_TA_stroj",&cas_TA_stroj_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_slucovat",&slucovat_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_text_operace",&text_operace_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_rada_kooperace",&rada_kooperace_zmena);
		AOM_ask_value_date(HZ[j],"h4_HZ_novy_datum_mereni",&datum_m_zmena);
		AOM_ask_value_string(HZ[j],"h4_HZ_novy_text_vlozeni",&vlozeni);
		printf("VLOZENI %s %d\n",vlozeni,strlen(vlozeni));
		printf(" nacteni zmeny attr \n");
		//break;
		}
		char *desc;
		AOM_ask_value_string(HZ[j],"object_desc",&desc);
		
		if(strlen(desc)>1) {
			
			 AOM_lock(HZ[j]);
			AOM_unlock(HZ[j]);AOM_set_value_string(HZ[j],"object_desc"," ");		
			AOM_save(HZ[j]);
		}
		
  }

  for(int jj=0;jj<TP_meneneCount;jj++){
 	WSOM_ask_object_type2(TP_menene[jj],&Type);//Returns the object type of the specified WorkspaceObject.
	if (strcmp(Type,"H4_TPRevision")==0){
			
		 tag_t relation_type,
			relation;
		GRM_find_relation_type("H4_dotcene_TP_rel", &relation_type);
		printf("find relation %d \n",relation_type);
		GRM_create_relation(*HZ_hlavni, TP_menene[jj], relation_type, NULLTAG,&relation);		
		GRM_save_relation(relation);
   }
  }
		for(int j=0;j<OP_meneneCount;j++)
{
	printf(" for j %d \n",j);
		if(strlen(typ_operace_zmena)!=0)
		{ 
			
							
							
			 ITEM_ask_latest_rev(op_item[j],&Opnew);
			 AOM_lock(Opnew);
			AOM_set_value_string(Opnew,"h4_O_typ_operace",typ_operace_zmena);
			printf(" %s   \n",typ_operace_zmena);
			//if(strcmp(typ_op_kus,typ_operace)!=0)goto next;
			
			AOM_save(Opnew);
			AOM_unlock(Opnew);
		}		
		if(strlen(pracoviste_zmena)!=0)
		{ 			
			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_set_value_string(Opnew,"h4_O_pracoviste",pracoviste_zmena);
			printf(" %s \n",pracoviste_zmena);
			AOM_save(Opnew);
			AOM_unlock(Opnew);
								
		}
		if(strlen(Op_name_zmena)!=0)
		{
			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_lock(Opnew);
			AOM_set_value_string(Opnew,"object_name",Op_name_zmena);
			/*if(strcmp(Op_name_kus,Op_name)!=0)goto next;*/
			AOM_save(Opnew);
			AOM_unlock(Opnew);
					
		}
		if(strlen(text_operace_zmena)!=0)
		{ 
		
		if(strcmp(vlozeni,"NAHRADIT")==0){
				ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_lock(Opnew);
			//H4_HZ_novy_text_vlozeni
			AOM_set_value_string(Opnew,"h4_O_text_operace",text_operace_zmena);
			//if(strcmp(text_operace_kus,text_operace)!=0)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);
		}
		else if(strcmp(vlozeni,"PRED TEXT")==0){
		
			char* oldText,pomoc[4000];
			
			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_ask_value_string(Opnew,"h4_O_text_operace",&oldText);
			strcpy(pomoc,text_operace_zmena);
			strcat(pomoc," ");
			strcat(pomoc,oldText);
			printf("PRED TEXT %s \n",pomoc);

			AOM_lock(Opnew);
			//H4_HZ_novy_text_vlozeni
			AOM_set_value_string(Opnew,"h4_O_text_operace",pomoc);
			//if(strcmp(text_operace_kus,text_operace)!=0)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);
		}
		else if(strcmp(vlozeni,"ZA TEXT")==0){
		
			char* pomoc;
			
			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_ask_value_string(Opnew,"h4_O_text_operace",&pomoc);
			strcat(pomoc," ");
			strcat(pomoc,text_operace_zmena);
			printf("ZA TEXT %s \n",pomoc);

			AOM_lock(Opnew);
			//H4_HZ_novy_text_vlozeni
			AOM_set_value_string(Opnew,"h4_O_text_operace",pomoc);
			//if(strcmp(text_operace_kus,text_operace)!=0)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);
		}else printf("NEVLOZENO %s %d\n",vlozeni,strlen(vlozeni));
		
		}
		if(strlen(rada_kooperace_zmena)!=0)
		{ 
			//char* rada_kooperace_kus;
			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_lock(Opnew);
			AOM_set_value_string(Opnew,"h4_O_rada_kooperace",rada_kooperace_zmena);
			//if(strcmp(rada_kooperace_kus,rada_kooperace)!=0)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);
					
		}
		//fprintf(log,"TB >> %d \n",strlen(cas_TB_stroj_zmena));
		if(strlen(cas_TB_stroj_zmena)!=0)
		{ 
			char cislo[sizeof(cas_TB_stroj_zmena)];
			double pomocCislo_TB;
			double cas_TB_old,
				cas_TB_new;
			strcpy(cislo," ");
			AOM_ask_value_double(OP_menene[j],"h4_O_TB_stroj",&cas_TB_old);
			//fprintf(log,"cas_TB_old %f \n",cas_TB_old);

			//ITEM_ask_latest_rev(op_item[j],&Opnew);
			//AOM_lock(Opnew);
			//AOM_set_value_double(Opnew,"h4_O_TB_stroj",cas_TB_new);
			////if(cas_TB_kus!=cas_TB)goto next;
			//AOM_save(Opnew);
			//AOM_unlock(Opnew);

		for(int i=1;i<strlen(cas_TB_stroj_zmena);i++)cislo[i-1]=cas_TB_stroj_zmena[i];

			if(memcmp(cas_TB_stroj_zmena,"+",1)==0){
				//fprintf(log,"+ \n");
				pomocCislo_TB=atof(cislo);
				cas_TB_new=cas_TB_old+pomocCislo_TB;
			}
			else if(memcmp(cas_TB_stroj_zmena,"-",1)==0){
				printf("- \n");
				pomocCislo_TB=atof(cislo);
				cas_TB_new=cas_TB_old-pomocCislo_TB;
				//fprintf(log,"cas TB %f=%f-%f \n",cas_TB_new,cas_TB_old,pomocCislo_TB);
			}
			else if(memcmp(cas_TB_stroj_zmena,"*",1)==0){
				//fprintf(log,"* \n");
				pomocCislo_TB=atof(cislo);
				//printf("cas TB stroj text %s double %f \n",cas_TB_stroj_zmena,pomocCislo_TB);
				cas_TB_new=cas_TB_old*pomocCislo_TB;
				//printf("cas TB %f=%f*%f \n",cas_TB_new,cas_TB_old,pomocCislo_TB);
			}
			else if(memcmp(cas_TB_stroj_zmena,"/",1)==0){
				//fprintf(log,"/ \n");
				pomocCislo_TB=atof(cislo);
				cas_TB_new=cas_TB_old/pomocCislo_TB;
				//printf("cas TB %f=%f/%f \n",cas_TB_new,cas_TB_old,pomocCislo_TB);
			}
			else if (memcmp(cas_TB_stroj_zmena,"=",1)==0){

				//fprintf(log,"= \n");
				pomocCislo_TB=atof(cislo);
				cas_TB_new=pomocCislo_TB;
				//fprintf(log,"cas TB %f=%f \n",cas_TB_new,pomocCislo_TB);
			}
			else if (memcmp(cas_TB_stroj_zmena,"0",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"1",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"2",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"3",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"4",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"5",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"6",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"7",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"8",1)==0 ||
					memcmp(cas_TB_stroj_zmena,"9",1)==0 ){

	//fprintf(log,"/ \n");
				pomocCislo_TB=atof(cas_TB_stroj_zmena);
				cas_TB_new=pomocCislo_TB;
				//fprintf(log,"cas TB %f=%f \n",cas_TB_new,pomocCislo_TB);
			}

			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_lock(Opnew);
			AOM_set_value_double(Opnew,"h4_O_TB_stroj",cas_TB_new);
			//if(cas_TB_kus!=cas_TB)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);
					
		}
		//fprintf(log," TA >> %d \n",strlen(cas_TA_stroj_zmena));
		if(strlen(cas_TA_stroj_zmena)!=0)
		{ 
			char cislo[sizeof(cas_TA_stroj_zmena)];
			double pomocCislo_TA;
					double cas_TA_old,
				cas_TA_new;
				AOM_ask_value_double(OP_menene[j],"h4_O_TA_stroj",&cas_TA_old);
				//for(int ii=0;i<sizeof(cas_TA_stroj_zmena);ii++)cislo[ii]=" ";
				strcpy(cislo," ");
					//fprintf(log,"cislo strin puvodni %s **********\n",cislo);
				for(int i=1;i<strlen(cas_TA_stroj_zmena);i++)cislo[i-1]=cas_TA_stroj_zmena[i];

				//fprintf(log,"cislo string upravene* %s **********\n",cislo);
					if(memcmp(cas_TA_stroj_zmena,"+",1)==0){
					printf("+ \n");
					pomocCislo_TA=atof(cislo);
					cas_TA_new=cas_TA_old+pomocCislo_TA;
					}
					else if(memcmp(cas_TA_stroj_zmena,"-",1)==0){
						//fprintf(log,"- \n");
						pomocCislo_TA=atof(cislo);
						cas_TA_new=cas_TA_old-pomocCislo_TA;
						//fprintf(log,"cas TA %f=%f-%f \n",cas_TA_new,cas_TA_old,pomocCislo_TA);
					}
					else if(memcmp(cas_TA_stroj_zmena,"*",1)==0){
						//fprintf(log,"* \n");
						pomocCislo_TA=atof(cislo);
						cas_TA_new=cas_TA_old*pomocCislo_TA;
						//fprintf(log,"cas TA %f=%f*%f \n",cas_TA_new,cas_TA_old,pomocCislo_TA);
					}
					else if(memcmp(cas_TA_stroj_zmena,"/",1)==0){
						//printf("/ \n");
						pomocCislo_TA=atof(cislo);
						cas_TA_new=cas_TA_old/pomocCislo_TA;
						//fprintf(log,"cas TA %f=%f/%f \n",cas_TA_new,cas_TA_old,pomocCislo_TA);

					}	
					else if (memcmp(cas_TA_stroj_zmena,"=",1)==0){

				//fprintf(log,"= \n");
				pomocCislo_TA=atof(cislo);
				cas_TA_new=pomocCislo_TA;
				//printf("cas TA %f=%f \n",cas_TA_new,pomocCislo_TA);
				}
				else if (memcmp(cas_TA_stroj_zmena,"0",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"1",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"2",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"3",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"4",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"5",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"6",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"7",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"8",1)==0 ||
						memcmp(cas_TA_stroj_zmena,"9",1)==0 ){

					//fprintf(log,"/ \n");
					pomocCislo_TA=atof(cas_TA_stroj_zmena);
					cas_TA_new=pomocCislo_TA;
					//fprintf(log,"cas TA %f=%f \n",cas_TA_new,pomocCislo_TA);
				}

				ITEM_ask_latest_rev(op_item[j],&Opnew);
				AOM_lock(Opnew);
				AOM_set_value_double(Opnew,"h4_O_TA_stroj",cas_TA_new);
			//if(cas_TA_kus!=cas_TA)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);

					
		}
		if (datum_m_zmena.year!=0)
		{
			printf("datum m %d \n",datum_m_zmena.year);
			date_t datum_m_op;
			ITEM_ask_latest_rev(op_item[j],&Opnew);
			AOM_lock(Opnew);
			AOM_set_value_date(Opnew,"h4_O_datum_mereni",datum_m_zmena);
			//if (datum_m_op.month!=datum_m.month && datum_m_op.year!=datum_m.year && datum_m_op.day!=datum_m.day)goto next;
			AOM_save(Opnew);
			AOM_unlock(Opnew);
		}
		/*const tag_t *attach=&target_copy_tags[j];
		const int AttachmentTypes[1] = {EPM_reference_attachment};
							EPM_add_attachments(RootTask, 1,attach, AttachmentTypes);*/

}
//end:;
//GRM_find_relation_type("H4_dotcene_TP_rel", &relation_type_TP);
//GRM_list_secondary_objects_only	(*HZ,relation_type_TP,&TPCount,&TP);
//printf("menene TP %d \n",TPCount);
revise_item_revisions(TP_meneneCount, TP_menene);
GRM_find_relation_type("H4_dotcene_TP_rel", &relation_type_TP);
for(int ii=0;ii<TP_meneneCount;ii++)
{
	ITEM_ask_item_of_rev(TP_menene[ii],&tp_item);
  printf("item op \n");
  ITEM_ask_latest_rev(tp_item,&TPnew);
  printf("latest rev  number of  \n");
 Zmeny_TP(TPnew,RootTask, revise_input_tags,OP_meneneCount,cislo_op_zmena,Op_num);

    const tag_t *attach=&TPnew;
const int AttachmentTypes[1] = {EPM_target_attachment};
					int Status=EPM_add_attachments(RootTask, 1,attach, AttachmentTypes);
					printf("STATUS %d \n",Status);
					if(Status !=ITK_ok)EMH_clear_last_error(Status);
					
					GRM_create_relation(*HZ_hlavni, TPnew, relation_type_TP, NULLTAG,&relation);		
					GRM_save_relation(relation);
}

for(int jj=0;jj<TP_meneneCount_ns;jj++) //pro neschvalene TP zmeny primo v kusovniku
{
	/*ITEM_ask_item_of_rev(TP_menene_ns[jj],&tp_item);
  printf("item op \n");
  ITEM_ask_latest_rev(tp_item,&TPnew);
  printf("latest rev  number of  \n");*/
 Zmeny_TP(TP_menene_ns[jj],RootTask, revise_input_tags,OP_meneneCount,cislo_op_zmena,Op_num);

 //   const tag_t *attach=&TP_menene_ns[jj];
	//const int AttachmentTypes[1] = {EPM_target_attachment};
	//				int Status=EPM_add_attachments(RootTask, 1,attach, AttachmentTypes);
	//				printf("STATUS %d \n",Status);
	//				if(Status !=ITK_ok)EMH_clear_last_error(Status);

					GRM_create_relation(*HZ_hlavni, TP_menene_ns[jj], relation_type_TP, NULLTAG,&relation);		
					GRM_save_relation(relation);
				
}
//fclose(log);
if(TP_meneneCount)MEM_free(TP_menene);
if(OP_menene)MEM_free(OP_menene);
return ITK_ok;
}

 void revise_item_revisions(int num_target_objs, tag_t *target_object_tags)
{
    /* Pointer to an array of integers that stores the number of attached 
     *  objects of each target revision.  For example, with the objects
     *  below the array would be {2,4,3}.
     
     *  ItemRevision
     *      ItemRevision Master
     *      UGMASTER
     *
     *  ItemRevision
     *      ItemRevision Master
     *      UGMASTER
     *      UPART
     *      DirectModel
     *      
     *  ItemRevision)
     *      ItemRevision Master)
     *      UGMASTER
     *      UPART
    */
    int *all_attached_object_count = NULL; 
    
    /* Pointer to an array of attached object_tag tags of each target revision. 
     * Normally this would be tag_t**.  Although tag_t* is unconventional 
     * it is not incorrect.  Using the same example objects as above 
     * the resulting array would be the tags of these objects
     *
     *      ItemRevision Master
     *      UGMASTER
     *      ItemRevision Master
     *      UGMASTER
     *      UPART
     *      DirectModel
     *      ItemRevision Master
     *      UGMASTER
     *      UPART
    */     
    tag_t *all_deepcopydata_tags;
    
    int n_ints_in_list = 0;
    int n_tags_in_list = 0;
    int *ifails = NULL;       
    char *id_string = NULL;
    char type_name[TCTYPE_name_size_c + 1] = "";
    tag_t object_tag = NULLTAG;
    tag_t type_tag = NULLTAG;     
    tag_t *attached_objs_tags = NULL;
    tag_t *target_copy_tags = NULL;        
    tag_t *revise_input_tags = NULL;
    
    revise_input_tags = (tag_t *) MEM_alloc(num_target_objs * sizeof(tag_t));
    
    for (int ii = 0; ii < num_target_objs; ii++)
    {  
        tag_t type_tag = NULLTAG;
        TCTYPE_ask_object_type(target_object_tags[ii], &type_tag);
        
        tag_t revise_input_tag = NULLTAG;
        TCTYPE_construct_operationinput(type_tag,TCTYPE_OPEARTIONINPUT_REVISE, &revise_input_tag); 
        revise_input_tags[ii] = revise_input_tag; 

        printf("\nTarget Objects::\n");
        int attached_object_count = 0;
        tag_t *deepcopydata_tags = NULL;
        TCTYPE_ask_deepcopydata(target_object_tags[ii],TCTYPE_OPEARTIONINPUT_REVISE, &attached_object_count, &deepcopydata_tags); 
        tag_t last_object = NULLTAG;
        for (int jj = 0; jj < attached_object_count; jj++)
        {   
            AOM_ask_value_tag(deepcopydata_tags[jj], "targetObject",&object_tag); 
            if(object_tag != last_object)
            {   WSOM_ask_object_id_string(object_tag,&id_string);                 
                TCTYPE_ask_object_type(object_tag, &type_tag);                
                TCTYPE_ask_name(type_tag, type_name);  
                printf("    %s (%s)\n", id_string, type_name);  
            }
            last_object = object_tag;
               
            AOM_ask_value_tag(deepcopydata_tags[jj], "attachedObject", &object_tag); 
            if(object_tag != NULLTAG)
            {    
                WSOM_ask_object_id_string(object_tag,&id_string);                 
                TCTYPE_ask_object_type(object_tag, &type_tag);                
                TCTYPE_ask_name(type_tag, type_name); 
                printf("        attachedObject: %s (%s)\n", id_string, type_name);  
            }
        }

        if (attached_object_count > 0)
        {
            add_int_to_int_array(attached_object_count, &n_ints_in_list, 
                &all_attached_object_count);           
            for(int jj = 0; jj < attached_object_count; jj++)
            {
                add_tag_to_tag_array(deepcopydata_tags[jj], &n_tags_in_list,
                    &all_deepcopydata_tags);
            }
        }       
        if(deepcopydata_tags) MEM_free(deepcopydata_tags);
    }
    
    TCTYPE_revise_objects(num_target_objs, target_object_tags,revise_input_tags, all_attached_object_count, all_deepcopydata_tags, &target_copy_tags,  &ifails);
        
    printf("\nNew Revisions:\n");   
    for(int ii = 0; ii < num_target_objs; ii++)
    {
        
        WSOM_ask_object_id_string(target_copy_tags[ii],&id_string);               
        TCTYPE_ask_object_type(target_copy_tags[ii], &type_tag);                
        TCTYPE_ask_name(type_tag, type_name);  
        
        if(ifails[ii] == ITK_ok) printf("   %s (%s)\n", id_string, type_name);
        else
        {  
            char *error_message_string;
            EMH_get_error_string (NULLTAG,  ifails[ii], &error_message_string);
            printf("\t%d %s\n", ifails[ii], error_message_string);
            if(error_message_string) MEM_free(error_message_string);
        }
    }
           printf("cisteni pameti \n"); 
    if(revise_input_tags) MEM_free(revise_input_tags);
    if(all_attached_object_count) MEM_free(all_attached_object_count);
    if(all_deepcopydata_tags) MEM_free(all_deepcopydata_tags);
    if(attached_objs_tags) MEM_free(attached_objs_tags);  
    if(target_copy_tags) MEM_free(target_copy_tags);
    if(ifails) MEM_free(ifails);
    if(id_string) MEM_free(id_string);
}


static void ECHO(char *format, ...)
{
    char msg[1000];
    va_list args;
    va_start(args, format);
    vsprintf(msg, format, args);
    va_end(args);
    printf(msg);
    TC_write_syslog(msg);
}

static int report_error(char *file, int line, char *call, int status,
    logical exit_on_error)
{
    if (status != ITK_ok)
    {
        int
            n_errors = 0;
        const int
            *severities = NULL,
            *statuses = NULL;
        const char
            **messages;

        EMH_ask_errors(&n_errors, &severities, &statuses, &messages);
        if (n_errors > 0)
        {
            ECHO("\n%s\n", messages[n_errors-1]);
            EMH_clear_errors();
        }
        else
        {
            char *error_message_string;
            EMH_get_error_string (NULLTAG, status, &error_message_string);
            ECHO("\n%s\n", error_message_string);
        }

        ECHO("error %d at line %d in %s\n", status, line, file);
        ECHO("%s\n", call);
        if (exit_on_error)
        {
            ECHO("%s", "Exiting program!\n");
            exit (status);
        }
    }
    return status;
}

static void add_int_to_int_array(int add_int, int *n_int_array, int **int_array)
{
    int count = *n_int_array;
    count++;
    if (count == 1)
    {
     (*int_array) = (int *) MEM_alloc(sizeof(int));
    }
    else
    {
     (*int_array) = (int *) MEM_realloc((*int_array), count * sizeof(int));
    }
    (*int_array)[count - 1] = add_int;
    *n_int_array = count;
}

static void add_tag_to_tag_array(tag_t add_tag, int *n_tag_array, tag_t **tag_array)
{
    int count = *n_tag_array;
    count++;
    if (count == 1)
    {
     (*tag_array) = (tag_t *) MEM_alloc(sizeof(tag_t));
    }
    else
    {
     (*tag_array) = (tag_t *) MEM_realloc((*tag_array), count * sizeof(tag_t));
    }
    (*tag_array)[count - 1] = add_tag;
    *n_tag_array = count;
}
void Zmeny_TP(tag_t  TP, tag_t RootTask,tag_t* zmeny_op,int OpCount,char *cislo_op_zmena, char *Op_num )
{printf("---ZMENY TP \n");

tag_t BomViewType= NULLTAG,
	BomWindowTP=NULLTAG;
PS_ask_default_view_type( &BomViewType);
printf("line 689 \n");
int Status=PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
if(Status !=ITK_ok)EMH_clear_last_error(Status);
printf("line 691 %d \n",BomWindowTP);
			 int BomsCountTP = 0, CountOcc;
				tag_t *Boms_rev_TP = NULLTAG,
					*Occ=NULLTAG;
				ITEM_rev_list_bom_view_revs(TP, &BomsCountTP, &Boms_rev_TP);//This function will return all objects attached to the Item Revision.
				printf(" BomsTp %d BomsCountTP %d \n",*Boms_rev_TP,BomsCountTP);
				PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
				printf("occ TP %d \n",CountOcc);
				for(int i=0;i<CountOcc;i++)
				{
					tag_t child_item_rev, child_bom_view;
					PS_ask_occurrence_child(*Boms_rev_TP,Occ[i],&child_item_rev,&child_bom_view);
					char Id[ITEM_id_size_c + 1];
					char RevId[ITEM_id_size_c + 1],
						*Type,
						*kv_TP;
					tag_t Item = NULLTAG;
					ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s opCont %d \n",child_item_rev,Id,RevId,OpCount);
					for( int ii=0;ii<OpCount;ii++)
					{
						tag_t Meneny_Item;

					/*		ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s  \n",child_item_rev,Id,RevId);*/

						ITEM_ask_item_of_rev(zmeny_op[ii],&Meneny_Item);
						//printf("%d = %d \n",Meneny_Item,Item);
						if(Item==Meneny_Item)
						{
							tag_t *Occ_new;
							printf("shoda operace %s/%s \n",Id,RevId);
							char* seq_no;
							PS_ask_seq_no(*Boms_rev_TP,Occ[i],&seq_no);
							printf("seq_no %s \n",seq_no);
							
							int Status=PS_create_occurrences(*Boms_rev_TP,zmeny_op[ii],NULLTAG,1,&Occ_new);
								printf(" status %d \n",Status);
								printf("OCC [i] %d \n",Occ[i]);
							//	printf(" --------cislo_op %s=%d seq_no %s Op_num %s =>%d ---------\n",cislo_op_zmena,strlen(cislo_op_zmena),seq_no,Op_num,strcmp(seq_no,Op_num));
								int Del=PS_delete_occurrence(*Boms_rev_TP,Occ[i]);
							printf("del %d\n",Del);
								if(Status ==ITK_ok)EMH_clear_last_error(Status);
								//const char* new_seq_no=seq_no;
								
								if(strlen(cislo_op_zmena)!=0 && strcmp(seq_no,Op_num)==0 && strlen(Op_num)!=0)
								{
									printf(" -------->>>>>>>>>Menim <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,cislo_op_zmena);
								}else if(strlen(cislo_op_zmena)!=0 && strlen(Op_num)==0){
									printf(" -------->>>>>>>>>Znovu hledam <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,cislo_op_zmena);
								}
								else {printf("*Boms_rev_TP %d,*Occ_new %d,seq_no %\n",*Boms_rev_TP,*Occ_new,seq_no);
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,seq_no);
									printf(" -------->>>>>>>>>NEMenim <<<<<<<<<< ---------\n");
								}
								AOM_save(*Boms_rev_TP);
						}
							
					}
				tag_t*potomci_bvr,potomci_rev;
				int  potomci;
							/*PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
					PS_ask_occurrence_child(*Boms_rev_TP,Occ[ii],&potomci_rev,&potomci);
					printf ("potomci %d \n",potomci);*/
				printf("hledam!!!\n");
				//PS_ask_occurrence_child(*Boms_rev_TP,Occ[i],&potomci_rev,&potomci_rev);
				//printf ("potomci %d \n",potomci_rev);
					ITEM_rev_list_bom_view_revs(child_item_rev, &potomci, &potomci_bvr);
					printf ("potomci %d \n",potomci);
					if(potomci>0)Zmeny_TP(child_item_rev,  RootTask,zmeny_op, OpCount,cislo_op_zmena, Op_num );
				}

	//			tag_t *Childs = NULLTAG;
 //   int ChildsCount;
 //   BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	//printf("childs %d \n",ChildsCount);
 //   for(int k = 0; k < ChildsCount; k ++)
	// MEM_free(Childs);
				//ListBOMLine_TP(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,tag_t* zmeny_op, int OpCount,tag_t RevParent)
				
				//for(int j = 0; j < BomsCountTP; j++)
				//{
				//	printf("pred bom line %d \n",BomsCountTP);
				//	 //BOM window
				//	tag_t BomWindowTP = NULLTAG;
				//	BOM_create_window(&BomWindowTP);
				//	tag_t BomTopLineTP = NULLTAG;

				//	 //Výpis BOM line 
				//	BOM_set_window_top_line(BomWindowTP, NULLTAG, TP, BomsTP[j], &BomTopLineTP);
				//
				//	//nastaveni context bomline absolute occurrence edit mode			
				//	//BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
				//	/*ListBomLineDil(BomTopLine, 0, RootTask,BomWindow);*/
				//	ListBOMLine_TP(BomTopLineTP,0,RootTask, BomWindowTP,zmeny_op,OpCount,TP);
				//	BOM_refresh_window(BomWindowTP);
				//	BOM_close_window(BomWindowTP);
				//	}

}
void ListBOMLine_TP(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,tag_t* zmeny_op, int OpCount,tag_t RevParent)
{
	//printf(" Hledani OP \n");
    // Revize
    int AttributeId,
		is_released;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
	
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);
	

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t Meneny_Item = NULLTAG;
	
	
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1],
		*Type,
		*kv_TP;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);
	//printf("line %d item %s rev %s level %d \n",Rev,Id,RevId,Level); 
	//printf("---pred nahrazením v TP %d  \n",OpCount);
	for(int i =0;i<OpCount;i++){
		ITEM_ask_item_of_rev(zmeny_op[i],&Meneny_Item);
		printf("ZMENA >>>>>>>>>>>>>%d = %d <<<<<<<\n",Meneny_Item,Item);
		if(Item==Meneny_Item){
			//printf("----------Zmenit Bomline %d za zmeny_op[i] %d \n",BomLine,zmeny_op[i]);
			//BOM_line_replace(BomLine,Meneny_Item,zmeny_op[i],BomWindow);
			//PS_change_to_replace(BomW
			int CountBvr;
	tag_t *Bvrs,*Occ;
	ITEM_rev_list_all_bom_view_revs(RevParent,&CountBvr,&Bvrs);
	//printf(" poèet Bvr %d tag %d \n",CountBvr,*Bvrs);
			//PS_create_occurrences(*Bvrs,zmeny_op[i],NULLTAG,1,&Occ);
			//ITEM_rev_list_all_bom_view_revs(Rev,&CountBvr,&Bvrs);
			//PS_delete_occurrence(Rev,
		}
	}
	
			
				
	
	next:;
    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	printf("childs %d \n",ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)ListBOMLine_TP( Childs[k], Level + 1,RootTask, BomWindow,zmeny_op,OpCount,Rev);
	 MEM_free(Childs);
	
	 //printf(" ...konec..\n \n");
				
		//MEM_free(stredisko);		
	
   
	//AddToTarget(RootTask,"V",TP);
}
int Comparee_tag(tag_t hledany,tag_t* pole,int pocet){
	int vysledek =0;
	printf("Porovnaváni \n");
	for (int i =0;i<pocet;i++){
		printf ("hledany %d pole [%d] %d \n",hledany,i,pole[i]);
		if (pole [i]==hledany) printf("porovnani %d = %d \n",pole[i],hledany),vysledek=1;
	}
	return vysledek;
}
void Zmeny_OP_OP(tag_t  OP_parent,tag_t TP, tag_t RootTask,tag_t* zmeny_op,int OpCount,char *cislo_op_zmena, char *Op_num )
{printf("---ZMENY OP \n");
	/*int CountBvr;
	tag_t *Bvrs;
	ITEM_rev_list_all_bom_view_revs(TP,&CountBvr,&Bvrs);
	printf(" poèet Bvr %d tag %d \n",CountBvr,*Bvrs);*/
	//PS_create_occurrences	(	tag_t 	parent,tag_t 	child_item,tag_t 	child_bom_view,int 	n_occurrences,tag_t ** 	occurrences);		
			//printf(" TP %d k %d",TP[k],k);
			// BomView Type
tag_t BomViewType= NULLTAG,
	BomWindowOP=NULLTAG;
PS_ask_default_view_type( &BomViewType);
printf("line 881 \n");
int test0=PS_create_bom_view (BomViewType, NULL, NULL, OP_parent, &BomWindowOP);
printf("line 883 %d test0_863=%d \n",BomWindowOP,test0);
if(test0 !=ITK_ok)EMH_clear_last_error(test0);
			 int BomsCountTP = 0, CountOcc;
				tag_t *Boms_rev_TP = NULLTAG,
					*Occ=NULLTAG;
				ITEM_rev_list_bom_view_revs(OP_parent, &BomsCountTP, &Boms_rev_TP);//This function will return all objects attached to the Item Revision.
				printf(" BomsTp %d BomsCountTP %d \n",*Boms_rev_TP,BomsCountTP);
				int test1=PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
				printf("occ TP %d TEST1_870=%d %d\n",CountOcc,test1);
			
				for(int i=0;i<CountOcc;i++)
				{
					tag_t child_item_rev, child_bom_view;
					int test4=PS_ask_occurrence_child(*Boms_rev_TP,Occ[i],&child_item_rev,&child_bom_view);
					printf("test4_876=%d \n",test4);
					char Id[ITEM_id_size_c + 1];
					char RevId[ITEM_id_size_c + 1],
						*Type,
						*kv_TP;
					tag_t Item = NULLTAG;
					ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s opCont %d \n",child_item_rev,Id,RevId,OpCount);
					for( int ii=0;ii<OpCount;ii++)
					{
						tag_t Meneny_Item;

					/*		ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s  \n",child_item_rev,Id,RevId);*/

						ITEM_ask_item_of_rev(zmeny_op[ii],&Meneny_Item);
						//printf("%d = %d \n",Meneny_Item,Item);
						if(Item==Meneny_Item)
						{
							tag_t NEW_OP;
							revise_item_revisions(1, &OP_parent);
							printf("MAKE REV\n");
							  ITEM_ask_latest_rev(OP_parent,&NEW_OP);
							  printf("TAG LAST REV \n");
						//	Zmeny_TP( TP,  RootTask,&NEW_OP,1,NULL, NULL );
							  printf("ZMENY KUSOVNIKU \n");
							tag_t *Occ_new;
							printf("shoda operace 923 %s/%s \n",Id,RevId);
							char* seq_no;
							int test2 =PS_ask_seq_no(*Boms_rev_TP,Occ[i],&seq_no);
							printf("test2_906= %d \n",test2);
							printf("seq_no %s \n",seq_no);
							
							int Status=PS_create_occurrences(*Boms_rev_TP,zmeny_op[ii],NULLTAG,1,&Occ_new);
								printf(" status %d \n",Status);
								printf("OCC [i] %d \n",Occ[i]);
							//	printf(" --------cislo_op %s=%d seq_no %s Op_num %s =>%d ---------\n",cislo_op_zmena,strlen(cislo_op_zmena),seq_no,Op_num,strcmp(seq_no,Op_num));
								int Del=PS_delete_occurrence(*Boms_rev_TP,Occ[i]);
							printf("del %d\n",Del);
								if(Status ==ITK_ok)EMH_clear_last_error(Status);
								if(Del==ITK_ok)EMH_clear_last_error(Del);
								//const char* new_seq_no=seq_no;
								
								if(strlen(cislo_op_zmena)!=0 && strcmp(seq_no,Op_num)==0 && strlen(Op_num)!=0)
								{
									printf(" -------->>>>>>>>>Menim 938<<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,cislo_op_zmena);
								}else if(strlen(cislo_op_zmena)!=0 && strlen(Op_num)==0){
									printf(" -------->>>>>>>>>Znovu hledam941 <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,cislo_op_zmena);
								}
								else {printf("*Boms_rev_TP %d,*Occ_new %d,seq_no %\n",*Boms_rev_TP,*Occ_new,seq_no);
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,seq_no);
									printf(" -------->>>>>>>>>NEMenim 946<<<<<<<<<< ---------\n");
								}
								AOM_save(*Boms_rev_TP);
						}
							
					}
				tag_t*potomci_bvr,potomci_rev;
				int  potomci;
							/*PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
					PS_ask_occurrence_child(*Boms_rev_TP,Occ[ii],&potomci_rev,&potomci);
					printf ("potomci %d \n",potomci);*/
				printf("hledam!!!\n");
				//PS_ask_occurrence_child(*Boms_rev_TP,Occ[i],&potomci_rev,&potomci_rev);
				//printf ("potomci %d \n",potomci_rev);
					//ITEM_rev_list_bom_view_revs(child_item_rev, &potomci, &potomci_bvr);
					printf ("potomci %d \n",potomci);
				//	if(potomci>0)Zmeny_TP(child_item_rev,  RootTask,zmeny_op, OpCount,cislo_op_zmena, Op_num );
				}

}
int Kontroly_kusovnikuTP(tag_t Rev_TP,tag_t RootTask,char* Id,char* Rev){
	 int BomsCount = 0;
	 result=0;
				tag_t *Boms = NULLTAG;
				ITEM_rev_list_bom_view_revs(Rev_TP, &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
				for(int j = 0; j < BomsCount; j++)
				{
			 		//printf("pred bom line %d \n",BomsCount);
					 //BOM window
					tag_t BomWindow = NULLTAG;
					BOM_create_window(&BomWindow);
					tag_t BomTopLine = NULLTAG;

					 //Výpis BOM line 
					BOM_set_window_top_line(BomWindow, NULLTAG, Rev_TP, Boms[j], &BomTopLine);
				
					//nastaveni context bomline absolute occurrence edit mode			
					//BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
					//ListBomLineDil(BomTopLine, 0, RootTask,BomWindow);
					//if (KontrolaOP_TP (BomTopLine, 0,RootTask, BomWindow, Op_rev,result )==0) result;
					KontrolaOP_TP (BomTopLine, 0,RootTask, BomWindow, Id, Rev);
					BOM_refresh_window(BomWindow);
					BOM_close_window(BomWindow);
				
				}
			 	//printf("===============Result %d \n",result);
return result;
}
void KontrolaOP_TP  (tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* Id_kontrol, char* Rev_kontrol){
	////printf(" Hledani OP \n");
    // Revize
	//int result=1;
    int AttributeId,
		is_released;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
	//char Id_Op[ITEM_id_size_c + 1];
    //char RevId_Op[ITEM_id_size_c + 1];
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1],
		*Type,
		//*Type2,
		*kv_TP;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);

	//printf("ID/Rev %s/%s  level %d",Id,RevId,Level);

	//ITEM_ask_item_of_rev(Op, &Item);
 //   ITEM_ask_id(Item, Id_Op);
 //   ITEM_ask_rev_id(Rev, RevId_Op);

	//printf(" = ID/Rev %s/%s  level %d\n",Id_Op,RevId_Op,Level);

	//BOM_line_look_up_attribute("H4_KV_Stredisko", &AttributeId);
    //BOM_line_ask_attribute_string(BomLine, AttributeId, &stredisko);
 	//printf("Procházení kusovníku TP ------------ \n ");
	

	////printf("stredisko %s \n",stredisko);
	////printf("KV_TP %s \n",kv_TP);
	EPM_ask_if_released(Rev,&is_released);
													/*//printf("is releasd %d \n",is_released);
														if (is_released!=0)
														{
													
														}*/

	WSOM_ask_object_type2(Rev,&Type);//Returns the object type of the specified WorkspaceObject.
	//WSOM_ask_object_type2(Op,&Type2);
	 	// printf (" Type = %s - Type2 = %s  \n",Type,Type2);

		if(strcmp(Rev_kontrol,RevId)==0 && strcmp(Id_kontrol,Id)==0)//if(Rev==Op)
		{
		 	printf("SHODA %s / %s = %s / %s \n", Id, RevId,Id_kontrol,Rev_kontrol);
			result=1;
			
			goto konec;
		}//else printf("NESHODA %d != %d \n",Rev,Op);
	
    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
 	//# //printf("childs %d \n",ChildsCount);
    for(int k = 0; k < ChildsCount; k ++) KontrolaOP_TP( Childs[k], Level + 1,RootTask, BomWindow,Id_kontrol,Rev_kontrol);
	 MEM_free(Childs);
	
	 ////printf(" ...konec..\n \n");
				
		//MEM_free(stredisko);		
	konec:;
 
	//AddToTarget(RootTask,"V",TP);
}
void Zmeny_TP_ns(tag_t  TP, tag_t RootTask,tag_t* zmeny_op,int OpCount,char *cislo_op_zmena, char *Op_num )
{printf("---ZMENY TP \n");
	/*int CountBvr;
	tag_t *Bvrs;
	ITEM_rev_list_all_bom_view_revs(TP,&CountBvr,&Bvrs);
	printf(" poèet Bvr %d tag %d \n",CountBvr,*Bvrs);*/
	//PS_create_occurrences	(	tag_t 	parent,tag_t 	child_item,tag_t 	child_bom_view,int 	n_occurrences,tag_t ** 	occurrences);		
			//printf(" TP %d k %d",TP[k],k);
			// BomView Type
tag_t BomViewType= NULLTAG,
	BomWindowTP=NULLTAG;
PS_ask_default_view_type( &BomViewType);
printf("line 689 \n");
PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
printf("line 691 %d \n",BomWindowTP);
			 int BomsCountTP = 0, CountOcc;
				tag_t *Boms_rev_TP = NULLTAG,
					*Occ=NULLTAG;
				ITEM_rev_list_bom_view_revs(TP, &BomsCountTP, &Boms_rev_TP);//This function will return all objects attached to the Item Revision.
				printf(" BomsTp %d BomsCountTP %d \n",*Boms_rev_TP,BomsCountTP);
				PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
				printf("occ TP %d \n",CountOcc);
				for(int i=0;i<CountOcc;i++)
				{
					tag_t child_item_rev, child_bom_view;
					PS_ask_occurrence_child(*Boms_rev_TP,Occ[i],&child_item_rev,&child_bom_view);
					char Id[ITEM_id_size_c + 1];
					char RevId[ITEM_id_size_c + 1],
						*Type,
						*kv_TP;
					tag_t Item = NULLTAG;
					ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s opCont %d \n",child_item_rev,Id,RevId,OpCount);
					for( int ii=0;ii<OpCount;ii++)
					{
						tag_t Meneny_Item;

					/*		ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s  \n",child_item_rev,Id,RevId);*/

						ITEM_ask_item_of_rev(zmeny_op[ii],&Meneny_Item);
						//printf("%d = %d \n",Meneny_Item,Item);
						if(Item==Meneny_Item)
						{
							tag_t *Occ_new;
							printf("shoda operace %s/%s \n",Id,RevId);
							char* seq_no;
							PS_ask_seq_no(*Boms_rev_TP,Occ[i],&seq_no);
							printf("seq_no %s \n",seq_no);
							
							int Status=PS_create_occurrences(*Boms_rev_TP,zmeny_op[ii],NULLTAG,1,&Occ_new);
								printf(" status %d \n",Status);
								printf("OCC [i] %d \n",Occ[i]);
							//	printf(" --------cislo_op %s=%d seq_no %s Op_num %s =>%d ---------\n",cislo_op_zmena,strlen(cislo_op_zmena),seq_no,Op_num,strcmp(seq_no,Op_num));
								int Del=PS_delete_occurrence(*Boms_rev_TP,Occ[i]);
							printf("del %d\n",Del);
								if(Status ==ITK_ok)EMH_clear_last_error(Status);
								//const char* new_seq_no=seq_no;
								
								if(strlen(cislo_op_zmena)!=0 && strcmp(seq_no,Op_num)==0 && strlen(Op_num)!=0)
								{
									printf(" -------->>>>>>>>>Menim <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,cislo_op_zmena);
								}else if(strlen(cislo_op_zmena)!=0 && strlen(Op_num)==0){
									printf(" -------->>>>>>>>>Znovu hledam <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,cislo_op_zmena);
								}
								else {printf("*Boms_rev_TP %d,*Occ_new %d,seq_no %\n",*Boms_rev_TP,*Occ_new,seq_no);
									PS_set_seq_no(*Boms_rev_TP,*Occ_new,seq_no);
									printf(" -------->>>>>>>>>NEMenim <<<<<<<<<< ---------\n");
								}
								AOM_save(*Boms_rev_TP);
						}
							
					}
				tag_t*potomci_bvr,potomci_rev;
				int  potomci;
							/*PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
					PS_ask_occurrence_child(*Boms_rev_TP,Occ[ii],&potomci_rev,&potomci);
					printf ("potomci %d \n",potomci);*/
				printf("hledam!!!\n");
				//PS_ask_occurrence_child(*Boms_rev_TP,Occ[i],&potomci_rev,&potomci_rev);
				//printf ("potomci %d \n",potomci_rev);
					ITEM_rev_list_bom_view_revs(child_item_rev, &potomci, &potomci_bvr);
					printf ("potomci %d \n",potomci);
					if(potomci>0)Zmeny_TP(child_item_rev,  RootTask,zmeny_op, OpCount,cislo_op_zmena, Op_num );
				}


}