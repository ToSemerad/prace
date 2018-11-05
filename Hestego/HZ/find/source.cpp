#define  _CRT_SECURE_NO_WARNINGS 1
////vyvojovy OLD version /////////////
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
#include <ae\ae.h>
#include <form/form.h>

#define ITK_CALL(x) {           \
    int stat;                     \
    char *err_string;             \
    if( (stat = (x)) != ITK_ok)   \
    {                             \
    EMH_get_error_string (NULLTAG, stat, &err_string);                 \
    printf ("ERROR: %d ERROR MSG: %s.\n", stat, err_string);           \
    printf ("FUNCTION: %s\nFILE: %s LINE: %d\n",#x, __FILE__, __LINE__); \
    if(err_string) MEM_free(err_string);                                \
    exit (EXIT_FAILURE);                                                   \
    }                                                                    \
}

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))
int TPV_HZ_find_op(EPM_action_message_t msg);
extern "C" DLLAPI int TPV_HZ_find_op_TC10_register_callbacks();
extern "C" DLLAPI int TPV_HZ_find_op_TC10_init_module(int *decision, va_list args);
EPM_decision_t A_TPV_HZ_find_op(EPM_rule_message_t msg);
void ListBomLineDil(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow);
void ListBomLineTP(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* typ_operace,
					char* pracoviste,char* Op_name,char* text_operace,char* rada_kooperace,
					char* slucovat,double cas_TB,double cas_TA,date_t datum_m,tag_t TPrev,
					tag_t* HZ, char *Op_num,char* interval_TA,char* interval_TB );
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr,char* Lov);
int Kontrola(tag_t Add,tag_t Roottask);
int Kontrola_target(tag_t Add,tag_t Roottask);
int InRelation( tag_t relation_type,tag_t Primary, tag_t Secondary);
int KontrolaTP( tag_t object);
int Kontrola_cila_op(char* OP_num,tag_t Op,tag_t TP,int Level);
void Vypis (tag_t Rev);
int test_interval(char * interval,double cas,double cas_op);
static void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset);
void KontrolaOP_TP (tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,tag_t Op);

int Kontroly_kusovnikuTP(tag_t Rev_TP,tag_t RootTask,tag_t Op_rev);

//
//tag_t  *TP = NULL,
//    
//    
//    
//	*Operace;
//int pocetTP=0;
int  static result=0;
static tag_t  *TP = NULL,   
	*Operace;
  int pocetTP=0;
	tag_t RevisionClassTag = NULLTAG;


extern "C" DLLAPI int TPV_HZ_find_op_TC10_register_callbacks()
{
    //printf("Registruji handler-TPV_HZ_find_op_TC10.dll\n");
    CUSTOM_register_exit("TPV_HZ_find_op_TC10", "USER_init_module", TPV_HZ_find_op_TC10_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_HZ_find_op_TC10_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_HZ_find_op_TC10", "", TPV_HZ_find_op);
    if(Status == ITK_ok) //printf("Handler pro vyplneni kusovnik strediskem z Organization %s \n", "TPV_HZ_find_op");


    return ITK_ok;
}

int TPV_HZ_find_op(EPM_action_message_t msg)
{
	

	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0,
	ReferenceCount = 0;
tag_t *Targets = NULLTAG,
	*Reference = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;
char* user_name;
tag_t user_tag;
tag_t person_tag;
char
	* Obj_type; 

char *Type,
			* pracoviste,
			* typ_operace,
			* Op_name,
			* Op_num,
			* slucovat,
			* text_operace,
			* cas_TB_stroj,
			* cas_TA_stroj,
			* datum_mereni,
			* interval_TA,
			* interval_TB,
			* rada_kooperace;

		 char* znovuHledat;
		double
			cas_TA,
			cas_TB;
		date_t datum_m;
		int Num_query=0;

		FILE *log;

EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny

EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
	////printf("TargetsCount %d ",TargetsCount);
	//POM_get_user(&user_name, &user_tag);
	////printf("-----Jmeno %s tag %d-------\n",user_name,user_tag);
	//SA_find_person2(user_name,&person_tag);
	////printf("person tag %d \n",person_tag);
	//SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
TP=(tag_t *) MEM_alloc(1000 * sizeof(tag_t));

	for( int i = 0; i < TargetsCount; i ++ )
	{
		//WSOM_ask_object_id_string(Targets[i],&Obj_type);
		////printf("obj=%s \n",Obj_type);
		POM_class_of_instance(Targets[i], &TargetClassTag);


	logical IsRevision = false;
	POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);

//////////********CTENI ATRIBUTU HZ****///////////////////

	if(IsRevision == false) continue;
	
		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
	 	printf (" Type = %s %d %d %d\n",Type,strcmp(Type,"H4_HZRevision"),strlen(Type),strlen("H4_HZRevision"));
		if(strcmp(Type,"H4_HZRevision")==0)
		{
			AOM_ask_value_string(Targets[i],"h4_HZ_typ_operace",&typ_operace);
		 	//printf("hledane typ operace %s \n",typ_operace);
			if (strlen(typ_operace)!=0)Num_query=Num_query+1;
			//else strcpy(typ_operace,"*");

			AOM_ask_value_string(Targets[i],"h4_HZ_pracoviste",&pracoviste);
		 	printf("hledane pracoviste %s \n",pracoviste);
			if (strlen(pracoviste)!=0)Num_query=Num_query+2;
			//else strcpy(pracoviste,"");

			AOM_ask_value_string(Targets[i],"h4_HZ_cislo_operace",&Op_num);
		 	//printf("hledane Op_num %s \n",Op_num);
			//if (strlen(Op_name)!=0)Num_query=Num_query+4;

			AOM_ask_value_string(Targets[i],"h4_HZ_nazev_operace",&Op_name);
		 	//printf("hledane Op_name %s \n",Op_name);
			if (strlen(Op_name)!=0)Num_query=Num_query+4;
			//else strcpy(Op_name,"");

			AOM_ask_value_string(Targets[i],"h4_HZ_text_operace",&text_operace);
		 	//printf("hledane text %s \n",text_operace);
			if (strlen(text_operace)!=0)Num_query=Num_query+8;
			//else strcpy(text_operace,"");

			AOM_ask_value_string(Targets[i],"h4_HZ_rada_kooperace",&rada_kooperace);
		 	//printf("hledane rada_kooperace %s \n",rada_kooperace);
			if (strlen(rada_kooperace)!=0)Num_query=Num_query+16;
			//else strcpy(rada_kooperace,"");

			AOM_ask_value_string(Targets[i],"h4_HZ_slucovat",&slucovat);
		 	//printf("hledane slucovat %s \n",slucovat);
		

			AOM_ask_value_double(Targets[i],"h4_HZ_TB_stroj",&cas_TB);
			if(cas_TB!=0)
				{
					//s//printf(cas_TB_stroj, "%f", cas_TB);    // Správnì
					Num_query=Num_query+100;
					AOM_ask_value_string(Targets[i],"h4_HZ_TB_stroj_interval",&interval_TB);
				}

			//else(strcpy(cas_TB_stroj,""));
			////printf("hledane cas TB stroj %s \n",cas_TB_stroj);

			AOM_ask_value_double(Targets[i],"h4_HZ_TA_stroj",&cas_TA);
			if(cas_TA!=0)
				{
					//s//printf(cas_TA_stroj, "%f", cas_TA);    // Správnì
					Num_query=Num_query+1000;
					AOM_ask_value_string(Targets[i],"h4_HZ_TA_stroj_interval",&interval_TA);
				}
			//else(strcpy(cas_TA_stroj,""));
			////printf("hledane vas TA stroj %s \n",cas_TA_stroj);
		
			AOM_ask_value_date(Targets[i],"h4_HZ_datum_mereni",&datum_m);
		 	//printf("datum mereni %d %d %d\n",datum_m.year,datum_m.month,datum_m.day);
			if (datum_m.year!=0){
				Num_query=Num_query+10000;
			}

			AOM_ask_value_string(Targets[i],"object_desc",&znovuHledat);
		 	//printf("znovu hledat %s \n",znovuHledat);
			printf("num_query %d \n",Num_query);
			HledejZnovu:

//EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_reference_attachment, &ReferenceCount, &Reference );		
	 	//printf("test pred Ref \n");
/////////////////****************ZACETEK PROCHAZENI REFERENCI*********//////////////////////////////	
if(ReferenceCount!=0)
{
		char desc_string[240];
		strcpy(desc_string,"");
	  //printf("test pred ciklem \n");

	//char *desc_string="~";
	////s//printf(desc_string,"%i",ReferenceCount);
	
	
		for (int ii=0;ii<ReferenceCount;ii++)
		{
			WSOM_ask_object_type2(Reference[ii],&Type);//Returns the object type of the specified WorkspaceObject.
		 	printf (" Type = %s %d \n",Type,strcmp(Type,"H4_DilecRevision"));
			//AOM_ask_value_string(Targets[i],"object_desc_string",&znovuHledat);
			if(strcmp(Type,"H4_DilecRevision")==0)
			{
				//strcat(desc_string,"~");
				char * pomoc;
				tag_t Item;
				//ITEM_ask_item_of_rev(Reference[ii],&Item);
				AOM_ask_value_string(Reference[ii],"item_id",&pomoc);
			 	//printf("%s \n",pomoc);
				strcat(desc_string,pomoc);
				strcat(desc_string,"/");
				AOM_ask_value_string(Reference[ii],"item_revision_id",&pomoc);
				//s//printf(pomoc,"%i",Reference[ii]);
				strcat(desc_string,pomoc);
				strcat(desc_string,";;");
			 int BomsCount = 0;
				tag_t *Boms = NULLTAG;
				ITEM_rev_list_bom_view_revs(Reference[ii], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
				for(int j = 0; j < BomsCount; j++)
				{
				 	//printf("pred bom line %d \n",BomsCount);
					 //BOM window
					tag_t BomWindow = NULLTAG;
					BOM_create_window(&BomWindow);
					tag_t BomTopLine = NULLTAG;

					 //Výpis BOM line 
					BOM_set_window_top_line(BomWindow, NULLTAG, Reference[ii], Boms[j], &BomTopLine);
				
					//nastaveni context bomline absolute occurrence edit mode			
					//BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
					ListBomLineDil(BomTopLine, 0, RootTask,BomWindow);
					BOM_refresh_window(BomWindow);
					BOM_close_window(BomWindow);
				
				}
			}
			else if(strcmp(Type,"H4_TPRevision")==0)
			{
				//strcat(desc_string,"~");
				char * pomoc;
				tag_t Item;
				//ITEM_ask_item_of_rev(Reference[ii],&Item);
				AOM_ask_value_string(Reference[ii],"item_id",&pomoc);
				strcat(desc_string,pomoc);
				strcat(desc_string,"/");
				AOM_ask_value_string(Reference[ii],"item_revision_id",&pomoc);
				//s//printf(pomoc,"%i",Reference[ii]);
				strcat(desc_string,pomoc);
				strcat(desc_string,";;");

				if(KontrolaTP( Reference[ii])==0)
				{
					/*//printf("²²²²²²test²²²²²\n");*/
					TP[pocetTP]=Reference[ii];
					pocetTP++;
				}else printf("kontrola existece TP tag TP %d v ref %d \n",Reference[i],KontrolaTP( Reference[i]));
			}
			const tag_t*   attachment=&Reference[ii];
			EPM_remove_attachments(RootTask,1,attachment);
		 	//printf(" pred for pocet TP %d \n",pocetTP);
		}
		for(int k=0;k<pocetTP;k++)
		{	
	
				WSOM_ask_object_type2(Reference[i],&Type);//Returns the object type of the specified WorkspaceObject.
			 	printf (" Type = %s %d \n",Type,strcmp(Type,"H4_DilecRevision"));
				
			/*if(strcmp(Type,"H4_DilecRevision")==0)
				{*/
				
				 int BomsCountTP = 0;
					tag_t *BomsTP = NULLTAG;
					ITEM_rev_list_bom_view_revs(TP[k], &BomsCountTP, &BomsTP);//This function will return all objects attached to the Item Revision.
				 	//printf(" TP %d k %d BomsCount %d \n",TP[k],k,BomsCountTP);
					for(int j = 0; j < BomsCountTP; j++)
					{
					 	//printf("pred bom line %d \n",BomsCountTP);
						 //BOM window
						tag_t BomWindowTP = NULLTAG;
						BOM_create_window(&BomWindowTP);
						tag_t BomTopLineTP = NULLTAG;

						 //Výpis BOM line 
						BOM_set_window_top_line(BomWindowTP, NULLTAG, TP[k], BomsTP[j], &BomTopLineTP);
				
				
						ListBomLineTP(BomTopLineTP,0,RootTask, BomWindowTP, 
										typ_operace, pracoviste, Op_name, text_operace,
										rada_kooperace, slucovat,cas_TB,cas_TA,
										datum_m,TP[k],Targets,Op_num,interval_TA,interval_TB);
						BOM_refresh_window(BomWindowTP);
							BOM_close_window(BomWindowTP);
				
				}
		
		}
		AOM_lock(Targets[i]);
AOM_set_value_string(Targets[i],"object_desc",desc_string);
AOM_save(Targets[i]);
//if(desc_string) MEM_free(desc_string);
}

////*****POKUD JSOU ZAPSENE ITEMY TP V POPISU A NENI NIC V REFERENCICH PROHLEDAJI SE ***////
else if(strlen(znovuHledat)>1)
{
	//printf("-----znovu hledat %d-----\n\n");
	char Id[12]="",
		 rev[4]="";
	
	int prepinac=0;
	int pomoc=0;
	for(int znak=0;znak <strlen(znovuHledat);znak++){
		//printf("znak %d \n",znak);
		
		if(znovuHledat[znak]=='~'){
			prepinac=0;
			pomoc=znak;
			//printf("ted ~ \n");
			goto preskoc;
		}
		else if(znovuHledat[znak]=='/')
			{
				//printf("index %d \n",znak);//potreba
				prepinac=znak+1;
				//printf("preskoc \n");
				goto preskoc;
		}
			else if (znovuHledat[znak]==';' && znovuHledat[znak-1]==';'){
			tag_t object;
			//printf(" -----%s/%s-----\n",Id,rev);
			ITEM_find_rev(Id,rev,&object);

			const int AttachmentTypes[1] = {EPM_reference_attachment};
			const tag_t *attach=&object;						
			EPM_add_attachments(RootTask, 1, attach, AttachmentTypes);
			prepinac=0;
			pomoc=znak+1;
			strcpy(Id,"           ");
			strcpy(rev,"    ");
		}
		else if(znovuHledat[znak]==';')
			{
				//printf("index %d \n",znak); // potreba
			//goto preskoc;
		}
		else if (prepinac==0){
			int tt=znak-pomoc;
			//printf("index %d pomoc %d znak %c \n",znak,pomoc,znovuHledat[znak]);
			Id[tt]=znovuHledat[znak];
			goto preskoc;
		}
	
		

		else if(prepinac!=0)
			{
				pomoc=znak-prepinac;
				printf (" pomoc %d znak %c \n",pomoc,znovuHledat[znak]);//zmena
					rev[pomoc]=znovuHledat[znak];
		}
		//printf("konec \n");
		preskoc:;
	}
	EPM_ask_attachments( RootTask,EPM_reference_attachment, &ReferenceCount, &Reference );	
	//printf("reference %d \n",ReferenceCount);
	if(ReferenceCount!=0)goto HledejZnovu;
		
	
}
/////////////////****************KONEC PROCHAZENI REFERENCI*********//////////////////////////////

////*********************HLEDANI V CELE DATABAZI OPERACI**********///////////////////////////////
else
{

									tag_t query = NULLTAG,
											*result_op;	
									QRY_find("Hestego_OP_search", &query);
								
									int n_operace = 0;
								//printf("query number %d \n",Num_query);
								
								if(query==0)printf(" spanty nazev query \n");
						

								else if(Num_query==1 ||Num_query==101||Num_query==1001||Num_query==10001||Num_query==1101||Num_query==11101){
										 	//printf("query number %d \n",Num_query);
											char *entries[1] = {"O_TYP_OPERACE"};
											char *values[1] =  {typ_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 1, entries, values, &n_operace, &result_op);
											//printf(" pocet vysledkù %d \n",n_operace);
									}
								else if(Num_query==2||Num_query==102||Num_query==1002||Num_query==10002||Num_query==1102||Num_query==11102){
										 	//printf("query number %d \n",Num_query);
											char *entries[1] = {"O_PRACOVISTE"};
											char *values[1] =  {pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 1, entries, values, &n_operace, &result_op);
											//printf(" pocet vysledkù %d \n",n_operace);
									}
								else if(Num_query==4||Num_query==104||Num_query==1004||Num_query==10004||Num_query==1104||Num_query==11104){
										 	//printf("query number %d \n",Num_query);
											char *entries[1] = {"Name"};
											char *values[1] =  {Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 1, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
								
								else if(Num_query==8||Num_query==108||Num_query==1008||Num_query==10008||Num_query==1108||Num_query==11108){
										 	//printf("query number %d \n",Num_query);
											char *entries[1] = {"O_TEXT_OPERACE"};
											char *values[1] =  {text_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 1, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù  TEXT OPERACE %d \n",n_operace);
									}
									else if(Num_query==16||Num_query==116||Num_query==1016||Num_query==10016||Num_query==1116||Num_query==11116){
										 	//printf("query number %d \n",Num_query);
											char *entries[1] = {"O_RADA_KOOPERACE"};
											char *values[1] =  {rada_kooperace};
											/*int n_operace = 0;*/
											QRY_execute(query, 1, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==0||Num_query==1100||Num_query==100||Num_query==1000||Num_query==10000||Num_query==1100||Num_query==11000||Num_query==11100||Num_query==10100){
										 	//printf("query number %d \n",Num_query);
											char *entries[1] = {"Name"};
											char *values[1] =  {"*"};
											/*int n_operace = 0;*/
											QRY_execute(query, 1, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									
									
										///////////////////////////////////////////////////////2 parametry//////////////////////////////////////////////////
									else if(Num_query==3||Num_query==103||Num_query==1003||Num_query==10003||Num_query==1103||Num_query==11103){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_TYP_OPERACE","O_PRACOVISTE"};
											char *values[2] =  {typ_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==5||Num_query==105||Num_query==1005||Num_query==10005||Num_query==1105||Num_query==11105){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_TYP_OPERACE","Name"};
											char *values[2] =  {typ_operace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==6||Num_query==106||Num_query==1006||Num_query==10006||Num_query==1106||Num_query==11106){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"Name","O_PRACOVISTE"};
											char *values[2] =  {Op_name,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==9||Num_query==109||Num_query==1009||Num_query==10009||Num_query==1109||Num_query==11109){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_TYP_OPERACE","O_TEXT_OPERACE"};
											char *values[2] =  {typ_operace,text_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==10||Num_query==110||Num_query==1010||Num_query==10010||Num_query==1110||Num_query==11110){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_TEXT_OPERACE","O_PRACOVISTE"};
											char *values[2] =  {text_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==12||Num_query==112||Num_query==1012||Num_query==10012||Num_query==1112||Num_query==11112){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_TEXT_OPERACE","Name"};
											char *values[2] =  {text_operace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
										else if(Num_query==17||Num_query==117||Num_query==1017||Num_query==10017||Num_query==1117||Num_query==11117){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_RADA_KOOPERACE","O_TYP_OPERACE"};
											char *values[2] =  {rada_kooperace,text_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
											else if(Num_query==18||Num_query==118||Num_query==1018||Num_query==10018||Num_query==1118||Num_query==11118){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_RADA_KOOPERACE","O_PRACOVISTE"};
											char *values[2] =  {rada_kooperace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
											else if(Num_query==20||Num_query==120||Num_query==1020||Num_query==10020||Num_query==1120||Num_query==11120){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_RADA_KOOPERACE","Name"};
											char *values[2] =  {rada_kooperace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
											else if(Num_query==24||Num_query==124||Num_query==1024||Num_query==10024||Num_query==1124||Num_query==11124){
										 	//printf("query number %d \n",Num_query);
											char *entries[2] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE"};
											char *values[2] =  {rada_kooperace,text_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 2, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
								
	////////////////////////////////////////////////////// 3 attrybuty ///////////////////////////////////////////////////////////

									else if(Num_query==7||Num_query==107||Num_query==1007||Num_query==10007||Num_query==1107||Num_query==11107){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"Name","O_TYP_OPERACE","O_PRACOVISTE"};
											char *values[3] =  {Op_name,typ_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==11||Num_query==111||Num_query==1011||Num_query==10011||Num_query==1111||Num_query==11111){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_TEXT_OPERACE","O_TYP_OPERACE","Name"};
											char *values[3] =  {text_operace,typ_operace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==13||Num_query==113||Num_query==1013||Num_query==10013||Num_query==1113||Num_query==11113){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"Name","O_TEXT_OPERACE","O_TYP_OPERACE"};
											char *values[3] =  {Op_name,text_operace,typ_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==14||Num_query==114||Num_query==1014||Num_query==10014||Num_query==1114||Num_query==11114){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"Name","O_TEXT_OPERACE","O_PRACOVISTE"};
											char *values[3] =  {Op_name,text_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==19||Num_query==119||Num_query==1019||Num_query==10019||Num_query==1119||Num_query==11119){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_RADA_KOOPERACE","O_TYP_OPERACE","O_PRACOVISTE"};
											char *values[3] =  {rada_kooperace,typ_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==21||Num_query==141||Num_query==1021||Num_query==10021||Num_query==1121||Num_query==11121){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_RADA_KOOPERACE","O_TYP_OPERACE","Name"};
											char *values[3] =  {rada_kooperace,typ_operace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
										else if(Num_query==22||Num_query==122||Num_query==1022||Num_query==10022||Num_query==1122||Num_query==11122){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_RADA_KOOPERACE","O_PRACOVISTE","Name"};
											char *values[3] =  {rada_kooperace,pracoviste,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
											else if(Num_query==25||Num_query==125||Num_query==1025||Num_query==10025||Num_query==1125||Num_query==11125){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","O_TYP_OPERACE"};
											char *values[3] =  {rada_kooperace,text_operace,typ_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
											else if(Num_query==26||Num_query==126||Num_query==1026||Num_query==10026||Num_query==1126||Num_query==11126){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","O_PRACOVISTE"};
											char *values[3] =  {rada_kooperace,text_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
											else if(Num_query==28||Num_query==128||Num_query==1028||Num_query==10028||Num_query==1128||Num_query==11128){
										 	//printf("query number %d \n",Num_query);
											char *entries[3] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","Name"};
											char *values[3] =  {rada_kooperace,text_operace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 3, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
	////////////////////////////////////////////////4 attributy /////////////////////////////////////////////////////////////////////////////////////

									else if(Num_query==15||Num_query==115||Num_query==1015||Num_query==10015||Num_query==1115||Num_query==11115){
										 	//printf("query number %d \n",Num_query);
											char *entries[4] = {"O_TEXT_OPERACE","Name","O_TYP_OPERACE","O_PRACOVISTE"};
											char *values[4] =  {text_operace,Op_name,typ_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 4, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==23||Num_query==123||Num_query==1023||Num_query==10023||Num_query==1123||Num_query==11123){
										 	//printf("query number %d \n",Num_query);
											char *entries[4] = {"O_RADA_KOOPERACE","Name","O_TYP_OPERACE","O_PRACOVISTE"};
											char *values[4] =  {rada_kooperace,Op_name,typ_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 4, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==27||Num_query==127||Num_query==1027||Num_query==10027||Num_query==1127||Num_query==11127){
										 	//printf("query number %d \n",Num_query);
											char *entries[4] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","O_TYP_OPERACE","O_PRACOVISTE"};
											char *values[4] =  {rada_kooperace,text_operace,typ_operace,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 4, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==29||Num_query==129||Num_query==1029||Num_query==10029||Num_query==1129||Num_query==11129){
										 	//printf("query number %d \n",Num_query);
											char *entries[4] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","O_TYP_OPERACE","Name"};
											char *values[4] =  {rada_kooperace,text_operace,typ_operace,Op_name};
											/*int n_operace = 0;*/
											QRY_execute(query, 4, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									else if(Num_query==30||Num_query==130||Num_query==1030||Num_query==10030||Num_query==1130||Num_query==11130){
										 	//printf("query number %d \n",Num_query);
											char *entries[4] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","Name","O_PRACOVISTE"};
											char *values[4] =  {rada_kooperace,text_operace,Op_name,pracoviste};
											/*int n_operace = 0;*/
											QRY_execute(query, 4, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
	////////////////////////////////////////////5 attributu////////////////////////////////////////////////////////////////////////////////////////////
									else if(Num_query==31||Num_query==131||Num_query==1031||Num_query==10031||Num_query==1131||Num_query==11131){
										 	//printf("query number %d \n",Num_query);
											char *entries[5] = {"O_RADA_KOOPERACE","O_TEXT_OPERACE","Name","O_PRACOVISTE","O_TYP_OPERACE"};
											char *values[5] =  {rada_kooperace,text_operace,Op_name,pracoviste,typ_operace};
											/*int n_operace = 0;*/
											QRY_execute(query, 5, entries, values, &n_operace, &result_op);
										 	//printf(" pocet vysledkù %d \n",n_operace);
									}
									

							
								
											const int AttachmentTypes[1] = {EPM_reference_attachment};
											const int Target[1] = {EPM_target_attachment};
											int is_released;
											////printf( "pred pridanim %d objectu \n",n_operace);


												tag_t job;
												char *job_name;

												////printf("pred ask job \n");
												EPM_ask_job(RootTask,&job);
												////printf("job %d \n",job);
												AOM_UIF_ask_value(job,"object_name",&job_name);
												////printf("job_name %s \n",job_name);
													for (int k =0;k<strlen(job_name);k++)
														{
															if(job_name[k]=='/')job_name[k]='_';

														}
													////printf("job_name %s \n",job_name);
												log=fopen(job_name,"a+");
												////printf("po vytvoreni \n");

											//////PROCHAZENI VYSLEDKU A HLEDANI PODLE DALSICH ATTRIBUTU//////
												printf(" %d \n ", n_operace);

											for(int j=0;j<n_operace;j++)
											{
												 if (100<=Num_query && Num_query<1000){
													 ////printf("%d num_query 100-1 000 \n",j);
													 double cas_TB_op;
													AOM_ask_value_double(result_op[j],"h4_O_TB_stroj",&cas_TB_op);
													if(test_interval(interval_TB,cas_TB,cas_TB_op)==0) goto nepridavat;
													//if(cas_TB_op!=cas_TB)goto nepridavat;
												 }
												 else if (1000<=Num_query && Num_query<1100){
													////printf(" %d num_query 1000-1 100 \n",j);
													double cas_TA_op;
													AOM_ask_value_double(result_op[j],"h4_O_TA_stroj",&cas_TA_op);
													if(test_interval(interval_TA,cas_TA,cas_TA_op)==0) goto nepridavat;
													
												 }
												 else if (1100<=Num_query && Num_query<10000){

													 double cas_TB_op=0;
													AOM_ask_value_double(result_op[j],"h4_O_TB_stroj",&cas_TB_op);
													if(test_interval(interval_TB,cas_TB,cas_TB_op)==0) goto nepridavat;
													double cas_TA_op=0;
													AOM_ask_value_double(result_op[j],"h4_O_TA_stroj",&cas_TA_op);
													if(test_interval(interval_TA,cas_TA,cas_TA_op)==0) goto nepridavat;
													////printf("num_query 1100-10 000");
													/* double cas_TB_op=0;
													 double cas_TA_op=0;
													AOM_ask_value_double(result_op[j],"h4_O_TB_stroj",&cas_TB_op);
													AOM_ask_value_double(result_op[j],"h4_O_TA_stroj",&cas_TA_op);
													if(test_interval(interval_TA,cas_TA,cas_TA_op)==0)
														if (test_interval(interval_TB,cas_TB,cas_TB_op)==0) goto nepridavat;*/
													//if(cas_TB_op!=cas_TB && cas_TA_op!=cas_TA)goto nepridavat;
											
									
												 }else if (10000<=Num_query && Num_query<10100){
													////printf("%d num_query 10 000-10 100 \n",j);
													 date_t datum_mer_op;
													AOM_ask_value_date(result_op[j],"h4_O_datum_mereni",&datum_mer_op);
													if(datum_mer_op.month==datum_m.month && datum_mer_op.year==datum_m.year && datum_mer_op.day==datum_m.day );
													else goto nepridavat;
									
												 }else if (10099<=Num_query && Num_query<11000){
													 ////printf("%d num_query 10 100-11 000 \n",j);
													date_t datum_mer_op;
													double cas_TB_op;
													AOM_ask_value_double(result_op[j],"h4_O_TB_stroj",&cas_TB_op);
													AOM_ask_value_date(result_op[j],"h4_O_datum_mereni",&datum_mer_op);
													if(test_interval(interval_TB,cas_TB,cas_TB_op)==0 && datum_mer_op.month!=datum_m.month && datum_mer_op.year!=datum_m.year && datum_mer_op.day!=datum_m.day)goto nepridavat;
													else printf("O_TB %f=%f %d=%d %d=%d %d=%d \n",cas_TB_op,cas_TB,datum_mer_op.year,datum_m.year,datum_mer_op.month,datum_m.month,datum_mer_op.day,datum_m.day);
													//if(cas_TB_op!=cas_TB )goto nepridavat;
									
												 }else if (11000<=Num_query && Num_query<11100){
													printf("%d num_query 11 000-11 10 \n",j);
													date_t datum_mer_op;
													double cas_TA_op;
													AOM_ask_value_double(result_op[j],"h4_O_TA_stroj",&cas_TA_op);
													AOM_ask_value_date(result_op[j],"h4_O_datum_mereni",&datum_mer_op);
													if(test_interval(interval_TA,cas_TA,cas_TA_op)==0 && datum_mer_op.month!=datum_m.month && datum_mer_op.year!=datum_m.year && datum_mer_op.day!=datum_m.day)goto nepridavat;
													else printf(" %d=%d %d=%d %d=%d \n",datum_mer_op.year,datum_m.year,datum_mer_op.month,datum_m.month,datum_mer_op.day,datum_m.day);

												 }else if (11100<=Num_query){
													// //printf("%d num_query 11 100- \n",j);
													double cas_TB_op;
													double cas_TA_op;
													date_t datum_mer_op;
													AOM_ask_value_date(result_op[j],"h4_O_datum_mereni",&datum_mer_op);
													AOM_ask_value_double(result_op[j],"h4_O_TB_stroj",&cas_TB_op);
													AOM_ask_value_double(result_op[j],"h4_O_TA_stroj",&cas_TA_op);
													if(test_interval(interval_TA,cas_TA,cas_TA_op)==0 && test_interval(interval_TB,cas_TB,cas_TB_op)==0
														&& datum_mer_op.month!=datum_m.month 
														&& datum_mer_op.year!=datum_m.year 
														&& datum_mer_op.day!=datum_m.day)goto nepridavat;
									
												 }
												
												 int	n_parent,
														*levels;
												tag_t	*parent;
												EPM_ask_if_released(result_op[j],&is_released);	
												Vypis (result_op[j]);
												////printf(" j %d rele \n",j);
												//if (is_released!=0)
												PS_where_used_precise(result_op[j],1,&n_parent,&levels,&parent);
												 znovu:;
											 	//printf("pocet Parent %d \n",n_parent);
												
											
												for(int f=0;f<n_parent;f++)
												{
													////printf("po vytvoreni \n");
													char *object_type,
														*TP_slucovat;
													logical is_latest;
													////printf("po vytvoreni \n");
													ITEM_rev_sequence_is_latest(parent[f],&is_latest);
													////printf("po vytvoreni \n");
													WSOM_ask_object_type2(parent[f],&object_type);//Returns the object type of the specified WorkspaceObject.
																//printf (" Type = %s %d \n",object_type,strcmp(object_type,"H4_TPRevision"));
																if(strcmp(object_type,"H4_TPRevision")==0 && is_latest)
																{
																	tag_t relation_type,
																	relation;
																	
																	////printf("hledaní operace f= %d n_parent %d  type %s \n",f,n_parent,object_type);

																		tag_t itemTP,
																				revTP;

																			ITEM_ask_item_of_rev(parent[f],&itemTP);
																			ITEM_ask_latest_rev(itemTP,&revTP);
																	
																	if (strlen(Op_num)!=0)
																		{
																			////printf("hledaní operace f= %d n_parent %d \n",f,n_parent);
																			//Vypis (result_op[j]);
																			if(Kontrola_cila_op(Op_num,result_op[j],revTP,0)==0)goto nepridavat_TP;
																
																		}
																	//printf ("slucovat = %d \n",strlen(slucovat));
																	if (strlen(slucovat)!=0)
																	{
												
																		//AOM_ask_value_string(parent[f],"h4_TP_slucovat",&TP_slucovat);
																		////printf("TP slocovat %s HZ slucovat %s \n",TP_slucovat,slucovat);
																		if(strcmp(TP_slucovat,slucovat)==0 && is_released!=0)
																		{
															

																	 		//printf(" Pred kontrolou !!!!!!! 922\n");
																			if (Kontrola(result_op[j],RootTask)==0 )
																			{
																				if(Kontroly_kusovnikuTP(revTP,RootTask,result_op[j])==1)
																				{
																				const tag_t *attach=&result_op[j];						
																				EPM_add_attachments(RootTask, 1, attach, AttachmentTypes);
																				}
																			
																				////printf("find relation %d \n",relation_type);
																				}
																			else{
																					char
																								* ID,
																								* REV,
																								* NAME;
																					int SEQ;
																							//AOM_ask_value_string(result_op[j],"DisplayName",&DN);

																							AOM_ask_value_string(result_op[j],"item_id",&ID);
																							AOM_ask_value_string(result_op[j],"item_revision_id",&REV);
																							AOM_ask_value_int(result_op[j],"sequence_id",&SEQ);
																							AOM_ask_value_string(result_op[j],"object_name",&NAME);

																						//	//printf("%s\n",DN);
																							//printf(log," Operace které nemají schválenou rev  : %s/%s;%d-%s (slucovat ano)\n",ID,REV,SEQ,NAME);

																				
																			}


																		 	//printf(" Pred kontrolou !!!!!!! 962\n");
																			if (Kontrola_target(revTP,RootTask)==0 && is_released!=0 ){
																			 		//printf("pridat TP \n");
																				if(Kontroly_kusovnikuTP(revTP,RootTask,result_op[j])==1){
																			 		//printf("pridat TP \n");
																					const tag_t *attach_target=&revTP;						
																					EPM_add_attachments(RootTask, 1, attach_target, Target);
																				}
																				//EPM_add_attachments(RootTask, 1, attach_target, AttachmentTypes);
																			}
																			else {
																				char
																								* ID,
																								* REV,
																								* NAME;
																					int SEQ;
																							//AOM_ask_value_string(result_op[j],"DisplayName",&DN);

																							AOM_ask_value_string(result_op[j],"item_id",&ID);
																							AOM_ask_value_string(result_op[j],"item_revision_id",&REV);
																							AOM_ask_value_int(result_op[j],"sequence_id",&SEQ);
																							AOM_ask_value_string(result_op[j],"object_name",&NAME);

																							
																							//fprintf(log," Operace které nemají schválenou rev : %s/%s;%d-%s (sluc2 TP) \n",ID,REV,SEQ,NAME);
																		
																				}
																			
																			

																	
																			
																		}
														
																	}else																	
																	{
																		
																	if (is_released!=0)
																	{
																			if (Kontrola(result_op[j],RootTask)==0 && is_latest)
																			{
																			 	//printf("Pridat Op \n");
																			if(Kontroly_kusovnikuTP(revTP,RootTask,result_op[j])==1){
																			 	//printf("Pridat Op \n");
																				const tag_t *attach=&result_op[j];						
																				EPM_add_attachments(RootTask, 1, attach, AttachmentTypes);
																			}
																			 	//printf(" po pøidaní operace 929 \n");
																				}else {
																					char
																								* ID,
																								* REV,
																								* NAME;
																					int SEQ;
																							//AOM_ask_value_string(result_op[j],"DisplayName",&DN);

																							AOM_ask_value_string(result_op[j],"item_id",&ID);
																							AOM_ask_value_string(result_op[j],"item_revision_id",&REV);
																							AOM_ask_value_int(result_op[j],"sequence_id",&SEQ);
																							AOM_ask_value_string(result_op[j],"object_name",&NAME);

																							////printf("%s\n",DN);
																							//fprintf(log," Operace které nemají schválenou rev : %s/%s;%d-%s (slucovat ne 1023)\n",ID,REV,SEQ,NAME);
																			}

																					/*tag_t itemTP,
																						  revTP;
																					char * object_type_tp;
																					
																					ITEM_ask_item_of_rev(parent[f],&itemTP);
																					ITEM_ask_latest_rev(itemTP,&revTP);*/
																		 	//printf(" Pred kontrolou !!!!!!! 1050\n");
																			if (Kontrola_target(revTP,RootTask)==0 ){
																							if(is_released!=0 && is_latest){
																						 	//printf("pridat TP \n");
																								if( Kontroly_kusovnikuTP(revTP,RootTask,result_op[j])==1)
																								{
																							 		//printf("----------pridat TP \n");
																									const tag_t *attach_target=&revTP;						
																									EPM_add_attachments(RootTask, 1, attach_target, Target);
																								}
																							//EPM_add_attachments(RootTask, 1, attach_target, AttachmentTypes);
																							}else {																			
																				
																						char
																								* ID,
																								* REV,
																								* NAME;
																					int SEQ;
																							//AOM_ask_value_string(result_op[j],"DisplayName",&DN);

																							AOM_ask_value_string(result_op[j],"item_id",&ID);
																							AOM_ask_value_string(result_op[j],"item_revision_id",&REV);
																							AOM_ask_value_int(result_op[j],"sequence_id",&SEQ);
																							AOM_ask_value_string(result_op[j],"object_name",&NAME);
																							//fprintf(log," Operace které nemají schválenou rev : %s/%s;%d-%s (slucovat ne TP 1056)\n",ID,REV,SEQ,NAME);
																							//$item_id+"/"+$item_revision_id+";"+$sequence_id+"-"+$object_name
																							}
																			}
																			
																			
																		}
													
																	} 

																	
																}else if(strcmp(object_type,"H4_OperaceRevision")==0)

																{
																
												
												EPM_ask_if_released(result_op[j],&is_released);	
												Vypis (result_op[j]);
												////printf(" j %d rele \n",j);
												//if (is_released!=0)
												//result_pomoc=parent[f];
												PS_where_used_precise(parent[f],1,&n_parent,&levels,&parent);
																	//printf("--------------------Nalezene Operace revizion \n");
																	
																	goto znovu;

																}
																

													nepridavat_TP:;
												}
											

												nepridavat:;
											}
												fclose(log);
												//tag_t dataset;
												//create_dataset("Text", "novy", NULL, Targets[i], &dataset);
											//	add_data(Targets[i], job_name);
   		}	
	
	}
}

//MEM_free(Operace);
if(pocetTP!=0)
	{  //printf(">>>>>>>>> mazaní lobalní promené <<<<<<<<<<<<<<\n");
	MEM_free(TP);
}
pocetTP=0;
    return ITK_ok;
}

int test_interval(char * interval,double cas,double cas_op)
{printf("HLEDAM INTERVALY %s delka %d\n",interval,strlen(interval));
	int vysledek=0;
	if(strcmp(interval,"=")==0){
		if(cas_op!=cas)goto nepridavat;
	}else if(strcmp(interval,">")==0){
			if(cas_op>cas)printf("Cas hledany > cas zadany \n");
				else goto nepridavat;
	}else if(strcmp(interval,"<")==0){
		if(cas_op<cas)printf("Cas hledany < cas zadany \n");
				else goto nepridavat;
	}else if(strcmp(interval,"<=")==0){
		if(cas_op<=cas)printf("Cas hledany <= cas zadany \n");
				else goto nepridavat;
	}
	else if(strcmp(interval,">=")==0){
		if(cas_op>=cas)printf("Cas hledany >= cas zadany \n");
				else goto nepridavat;
	}
	vysledek=1;
nepridavat:
	return vysledek;
}

void ListBomLineDil(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow)
{
	//TP=(tag_t *) MEM_alloc(1000 * sizeof(tag_t));
 	//printf(" Hledani TP \n");
    // Revize
    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1],
		*kv_TP;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);
	
	//BOM_line_look_up_attribute("H4_KV_Stredisko", &AttributeId);
    //BOM_line_ask_attribute_string(BomLine, AttributeId, &stredisko);
	////printf("H4_KV_Poznamka \n ");
	

	////printf("stredisko %s \n",stredisko);
 	//printf("ID/Rev %s/%s  level %d\n",Id,RevId,Level);
	
	if (Level != 0) {
		
					BOM_line_look_up_attribute("H4_KV_Cislo_TP", &AttributeId);
					BOM_line_ask_attribute_string(BomLine, AttributeId, &kv_TP);
				 	//printf("TP %s  delka %d\n",kv_TP,strlen(kv_TP));
					if(strlen(kv_TP)!=0)
					{
				 		//printf("=====existuje TP\n");
						tag_t TP_item,
								TP_rev;
						ITEM_find_item(kv_TP,&TP_item);
						ITEM_ask_latest_rev(TP_item,&TP_rev);
						if( KontrolaTP( TP_rev)==0)
						{
				 			//printf("----Pridat TP -----\n");
							TP[pocetTP]=TP_rev;		
							pocetTP++;
						}
				 		//printf("linst Dil pocet TP %d \n",pocetTP);

					}
		//pridani do BOMLine
		//SetBomLineString(BomWindow, BomLine, stredisko, "H4_KV_Stredisko","H4_stredisko");
				}
	

    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLineDil(Childs[k], Level + 1,RootTask, BomWindow);
	 MEM_free(Childs);
	
	 ////printf(" ...konec..\n \n");
				
		//MEM_free(stredisko);		
	
   
	//AddToTarget(RootTask,"V",TP);
}
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr,char* Lov)
{
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;
	int AttrId;

	BOM_line_look_up_attribute(Attr, &AttrId);
	
	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		////printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
		if(strcmp(values_dissplay[j],value)==0)
			{
				////printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
				BOM_line_set_attribute_string(BomLine, AttrId, values[j]);

				j=n_values;
			}
	}
BOM_save_window(BomWin);
}

void ListBomLineTP(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* typ_operace,
					char* pracoviste,char* Op_name,char* text_operace,char* rada_kooperace,
					char* slucovat,double cas_TB,double cas_TA,date_t datum_m,tag_t TPrev,
					tag_t* HZ, char *Op_num,char* interval_TA,char* interval_TB ){
	////printf(" Hledani OP \n");
    // Revize
    int AttributeId,
		is_released;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1],
		*Type,
		*kv_TP;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);
	
	//BOM_line_look_up_attribute("H4_KV_Stredisko", &AttributeId);
    //BOM_line_ask_attribute_string(BomLine, AttributeId, &stredisko);
	////printf("H4_KV_Poznamka \n ");
	

	////printf("stredisko %s \n",stredisko);
	////printf("KV_TP %s \n",kv_TP);
	EPM_ask_if_released(Rev,&is_released);
													/*//printf("is releasd %d \n",is_released);
														if (is_released!=0)
														{
													
														}*/



 	//printf("ID/Rev %s/%s  level %d\n",Id,RevId,Level);
	WSOM_ask_object_type2(Rev,&Type);//Returns the object type of the specified WorkspaceObject.
 		printf (" Type = %s %d \n",Type,strcmp(Type,"H4_OperaceRevision"));

	if (Level != 0 && strcmp(Type,"H4_OperaceRevision")==0 && is_released!=0) {
 		//printf("ID/Rev %s/%s  level %d\n",Id,RevId,Level);
		if(strlen(typ_operace)!=0)
		{ 
			char* typ_op_kus;
			AOM_ask_value_string(Rev,"h4_O_typ_operace",&typ_op_kus);
	 		//printf("%s %s shoda %d \n",typ_op_kus,typ_operace,strcmp(typ_op_kus,typ_operace));
			if(strcmp(typ_op_kus,typ_operace)!=0)goto next;
					
		}		
		if(strlen(pracoviste)!=0)
		{ 
			char* pracoviste_op_kus;
			AOM_ask_value_string(Rev,"h4_O_pracoviste",&pracoviste_op_kus);
	 		printf("%s %s \n",pracoviste_op_kus,pracoviste);
			if(strcmp(pracoviste_op_kus,pracoviste)!=0)goto next;
					
		}
		if(strlen(Op_name)!=0)
		{ 
			char* Op_name_kus;
			AOM_ask_value_string(Rev,"object_name",&Op_name_kus);
			if(strcmp(Op_name_kus,Op_name)!=0)goto next;
					
		}
		if(strlen(text_operace)!=0)
		{ 
			char* text_operace_kus;
			AOM_ask_value_string(Rev,"h4_O_text_operace",&text_operace_kus);
			if(strcmp(text_operace_kus,text_operace)!=0)goto next;
					
		}
		if(strlen(rada_kooperace)!=0)
		{ 
			char* rada_kooperace_kus;
			AOM_ask_value_string(Rev,"h4_O_rada_kooperace",&rada_kooperace_kus);
			if(strcmp(rada_kooperace_kus,rada_kooperace)!=0)goto next;
					
		}
		if(cas_TB!=0)
		{ 
			double cas_TB_kus;
			AOM_ask_value_double(Rev,"h4_O_TB_stroj",&cas_TB_kus);
			if(test_interval(interval_TB,cas_TB,cas_TB_kus)==0) goto next;
			//if(cas_TB_kus!=cas_TB)goto next;
					
		}
		if(cas_TA!=0)
		{ 
			double cas_TA_kus;
			AOM_ask_value_double(Rev,"h4_O_TA_stroj",&cas_TA_kus);
			if(test_interval(interval_TA,cas_TA,cas_TA_kus)==0) goto next;
			//if(cas_TA_kus!=cas_TA)goto next;
					
		}
		if (datum_m.year!=0)
		{
			date_t datum_m_op;
			AOM_ask_value_date(Rev,"h4_O_datum_mereni",&datum_m_op);
			if (datum_m_op.month!=datum_m.month && datum_m_op.year!=datum_m.year && datum_m_op.day!=datum_m.day)goto next;
		}
		if (strlen(Op_num)!=0)
		{
			
			if(Kontrola_cila_op(Op_num,Rev,TPrev, Level)==0)goto next;
		}
		
				
			 			//printf("existuje Operace souhlasí\n");
						if (Kontrola( Rev,RootTask)==0)
						{
							const tag_t *attach=&Rev;
							const int AttachmentTypes[1] = {EPM_reference_attachment};
							EPM_add_attachments(RootTask, 1, attach, AttachmentTypes);
							
						}

						logical is_latest;
								ITEM_rev_sequence_is_latest(TPrev,&is_latest);
						if (Kontrola_target(TPrev,RootTask)==0 && is_latest){
							const tag_t *attach_target=&TPrev;	
							const int Target[1] = {EPM_target_attachment};
							//const int Target[1] = {EPM_reference_attachment};
							EPM_add_attachments(RootTask, 1, attach_target, Target);
												}

				}
	
	next:;
    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
 	//printf("childs %d \n",ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)ListBomLineTP( Childs[k], Level + 1,RootTask, BomWindow, typ_operace, pracoviste, Op_name, text_operace, rada_kooperace, slucovat, cas_TB, cas_TA, datum_m, TPrev, HZ, Op_num ,interval_TA,interval_TB);
	 MEM_free(Childs);
	
	 ////printf(" ...konec..\n \n");
				
		//MEM_free(stredisko);		
	
   
	//AddToTarget(RootTask,"V",TP);
}
int Kontrola(tag_t Add,tag_t Roottask)
{	
	////printf("Kontrola Add tag je %d\n",Add);
	////printf("RootTask %d \n",Roottask);
	int odpoved=0;
	char* value;
	int count;
	tag_t* prilohy;
	EPM_ask_attachments(Roottask,EPM_reference_attachment,&count,&prilohy);
	////printf("count = %d \n",count);
	for(int i=0;i<count;i++)
	{
		/*AOM_ask_value_char(*(prilohy+i),ITEM_ITEM_ID_PROP,value);
		//printf("Jmeno prilohy %d je %s \n",i,*value);*/
		if(*(prilohy+i)==Add)
		{
			odpoved=1;
			i=count;
		}
		
	}
	////printf("count = %d \n",count);

	return odpoved;

}

int Kontrola_target(tag_t Add,tag_t Roottask)
{	
	////printf("Kontrola Add tag je %d\n",Add);
	////printf("RootTask %d \n",Roottask);
	int odpoved=0;
	char* value;
	int count;
	tag_t* prilohy;
	EPM_ask_attachments(Roottask,EPM_target_attachment,&count,&prilohy);
	////printf("count = %d \n",count);
	for(int i=0;i<count;i++)
	{
		/*AOM_ask_value_char(*(prilohy+i),ITEM_ITEM_ID_PROP,value);
		//printf("Jmeno prilohy %d je %s tag add %d \n",i,*value,Add);*/
		
		////printf(" prilohy %d = add %d \n",*(prilohy+i),Add);
		if(*(prilohy+i)==Add)
		{
			////printf("----shoda----\n"); 
			odpoved=1;
			i=count;
		}
		
	}
	////printf("count = %d \n",count);

	return odpoved;

}

int InRelation( tag_t relation_type,tag_t Primary, tag_t Secondary)
{
	int Exist =0,
		count=0;
	tag_t *SecondaryObj;
	

	GRM_list_secondary_objects_only	(Primary,relation_type,&count,&SecondaryObj);
	for(int i = 0; i < count;i++)
	{
		if (SecondaryObj[i]==Secondary)
			{
				Exist=1;
			 	printf ("------------nalezeno stejné TP ----------\n");
				break;
		}
	}
	
	return Exist;
}
int KontrolaTP( tag_t object){
	int Exist =0;
 	//printf("KontrolaTP poct TP %d \n",pocetTP);
	for(int i=0;i<pocetTP;i++)
	{
		
		if(TP[i]==object)
		{
	 		//printf("-----stejné tp-----\n");
			Exist=1;
		}
	}

	return Exist;
}

int Kontrola_cila_op(char* OP_num,tag_t Op,tag_t TP,int Level){

	 int AttributeId,
		 Shoda_cisla=0,
		is_released; int BomsCountTP = 0, CountOcc;
				tag_t *Boms_rev_TP = NULLTAG,
					*Occ=NULLTAG;
				ITEM_rev_list_bom_view_revs(TP, &BomsCountTP, &Boms_rev_TP);//This function will return all objects attached to the Item Revision.
	 			//printf(" BomsTp %d BomsCountTP %d \n",*Boms_rev_TP,BomsCountTP);
				PS_list_occurrences_of_bvr(*Boms_rev_TP,&CountOcc,&Occ);
				////printf("occ TP %d \n",CountOcc);

	

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
					////printf("line %d item %s rev %s  \n",child_item_rev,Id,RevId);
					/*for( int ii=0;ii<OpCount;ii++)
					{*/
						tag_t Meneny_Item;
						ITEM_ask_item_of_rev(Op,&Meneny_Item);
						////printf("%d = %d \n",Meneny_Item,Item);
						if(child_item_rev==Op)
						{
							//tag_t *Occ_new;
				 			//printf("shoda operace %s/%s \n",Id,RevId);
							char* seq_no;
							PS_ask_seq_no(*Boms_rev_TP,Occ[i],&seq_no);
				 			//printf("seq_no %s  Op num %s\n",seq_no,OP_num);
							if(strcmp(seq_no,OP_num)==0)
							{
				 				//printf("shoda.....\n");
								Shoda_cisla=1;
							}
							
						}
					//}

				}
	 return Shoda_cisla;
}
void Vypis (tag_t Rev){
	char Id[ITEM_id_size_c + 1];
					char RevId[ITEM_id_size_c + 1],
						*Type,
						*kv_TP;
					tag_t Item = NULLTAG;
					ITEM_ask_item_of_rev(Rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(Rev, RevId);
			 		//printf(" object : %s / %s \n",Id,RevId);
}
static void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset)
{
    char
        format_name[AE_io_format_size_c + 1] = "BINARY_REF";
    tag_t
        datasettype,
        tool;
    
    ITK_CALL(AE_find_datasettype(type_name, &datasettype));
    if (datasettype == NULLTAG)
    {
         //printf("Dataset Type %s not found!\n", type_name);
        exit (EXIT_FAILURE);
    }
    
    ITK_CALL(AE_ask_datasettype_def_tool(datasettype, &tool));
    
     //printf("Creating Dataset: %s\n", name);
    ITK_CALL(AE_create_dataset(datasettype, name, "", dataset));
    
    ITK_CALL(AE_set_dataset_tool(*dataset, tool));
    if (strcmp(type_name, "Text")) strcpy(format_name, "TEXT_REF");
    
    ITK_CALL(AE_set_dataset_format(*dataset, format_name));
     //printf("Saving Dataset: %s\n", name);
    ITK_CALL(AOM_save(*dataset));
    
    /*attach dataset to item revision */
    ITK_CALL(ITEM_attach_rev_object(rev, *dataset, ITEM_specification_atth));
  //  ITK_CALL(ITEM_save_item(item));

}
void KontrolaOP_TP (tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,tag_t Op){
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
	
	
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1],
		*Type,
		*kv_TP;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);
	
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

 	//# //printf("ID/Rev %s/%s  level %d\n",Id,RevId,Level);
	WSOM_ask_object_type2(Rev,&Type);//Returns the object type of the specified WorkspaceObject.
	 	//# printf (" Type = %s %d \n",Type,strcmp(Type,"H4_OperaceRevision"));

		if(Rev==Op)
		{
		 	//# //printf("SHODA %d = %d \n",Rev,Op);
			result=1;
			
			goto konec;
		}//else printf("NESHODA %d != %d \n",Rev,Op);
	
    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
 	//# //printf("childs %d \n",ChildsCount);
    for(int k = 0; k < ChildsCount; k ++) KontrolaOP_TP( Childs[k], Level + 1,RootTask, BomWindow,Op);
	 MEM_free(Childs);
	
	 ////printf(" ...konec..\n \n");
				
		//MEM_free(stredisko);		
	konec:;
 
	//AddToTarget(RootTask,"V",TP);
}
int Kontroly_kusovnikuTP(tag_t Rev_TP,tag_t RootTask,tag_t Op_rev){
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
					ListBomLineDil(BomTopLine, 0, RootTask,BomWindow);
					//if (KontrolaOP_TP (BomTopLine, 0,RootTask, BomWindow, Op_rev,result )==0) result;
					KontrolaOP_TP (BomTopLine, 0,RootTask, BomWindow, Op_rev);
					BOM_refresh_window(BomWindow);
					BOM_close_window(BomWindow);
				
				}
			 	//printf("===============Result %d \n",result);
return result;
}