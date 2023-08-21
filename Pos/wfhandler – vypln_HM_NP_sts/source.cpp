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
#include <tc\emh.h>

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define HANDLER_ERROR 2010
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))

char error[256];

extern "C" DLLAPI int TPV_Vypln_HM_NP_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Vypln_HM_NP_TC11_init_module(int *decision, va_list args);
int TPV_Vypln_HM_NP(EPM_action_message_t msg);
EPM_decision_t A_TPV_Vypln_HM_NP(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* user_name);
void AddToTarget(tag_t RootTask,char* O_Name,tag_t Item);
void MoveTPToFolder(tag_t folder,tag_t object);
void removeTP(tag_t folder,tag_t object);
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr);
void Add_S_ToTP(char* povrch1, char* povrch2, char* povrch3,tag_t TPrev, tag_t TP);
int Existence(char* povrch1, char* povrch2, char* povrch3, char* stredisko, char* poznamka,char* id, char* rev, char* var,tag_t BomLine,int AttributeId,tag_t BomWindow, tag_t revDil);
void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr);
int kontrolaLov(char* vstup, char* Lov,char* Zlovu );
void CopyAttr_HM( tag_t Rev,tag_t RootTask, char* c_h_mat);
void CopyAttr_NP(tag_t Rev, tag_t RootTask,char* c_nak_pol);


extern "C" DLLAPI int TPV_Vypln_HM_NP_TC11_register_callbacks()
{
    printf("Registruji handler-TPV_Vypln_HM_NP_TC11.dll\n");
    CUSTOM_register_exit("TPV_Vypln_HM_NP_TC11", "USER_init_module", TPV_Vypln_HM_NP_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Vypln_HM_NP_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Vypln_HM_NP", "", TPV_Vypln_HM_NP);
    if(Status == ITK_ok) printf("Handler pro zalozeni TP s attributy z KV %s \n", "TPV_Vypln_HM_NP");


    return ITK_ok;
}
bool cad;

int TPV_Vypln_HM_NP(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0;
tag_t *Targets = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;
char* user_name;
char *Argument = nullptr;
char*Flag = nullptr;
char*Value = nullptr;
cad=false;


strcpy(error,"\0");
EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"

int ArgumentCount = TC_number_of_arguments(msg.arguments);

	while (ArgumentCount-- > 0)
	{
		Argument = TC_next_argument(msg.arguments);
		ITK_ask_argument_named_value((const char*)Argument, &Flag, &Value);
		if (strcmp("prop_cad", Flag) == 0)
		{
			// …
			printf("value property \n");
			cad=true;
		}else
			printf("no cad property \n");
		
	}

for( int i = 0; i < TargetsCount; i ++ )
{
POM_class_of_instance(Targets[i], &TargetClassTag);


logical IsRevision = false;
POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);



if(IsRevision == false) continue;
	char *Type;
	WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
	printf ("%s\n",Type);
	 int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
        for(int j = 0; j < BomsCount; j++)
        {

            // BOM window
            tag_t BomWindow = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			
			//nastaveni context bomline absolute occurrence edit mode			
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			ListBomLine(BomTopLine, 0, RootTask,BomWindow,user_name);
			BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
			
        }
					int is_released=0;
	EPM_ask_if_released(Targets[i],&is_released);
	if (is_released==0)
	{
			WSOM_ask_object_type2(Targets[i],&Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{		
			char *c_h_mat;
					AOM_ask_value_string(Targets[i],"tpv4_hutni_material",&c_h_mat);
					if (strncmp(c_h_mat,"HM",2)==0)
						CopyAttr_HM( Targets[i],RootTask,c_h_mat);
					else if (strncmp(c_h_mat,"NP",2)==0)
						CopyAttr_NP( Targets[i], RootTask,c_h_mat);
			 //CopyAttr_HM( Targets[i],RootTask);
								
		}else if(strcmp(Type,"TPV4_nak_dilRevision")==0)
		{
			char* c_nak_pol;
			AOM_ask_value_string(Targets[i],"tpv4_nak_polozka",&c_nak_pol);
			CopyAttr_NP(Targets[i], RootTask,c_nak_pol);
			//CopyAttr_NP( Targets[i],RootTask);
		}
	}//else printf("schvaleno %s/%s \n",Id,RevId);
}
if(strlen(error)>5)
{
	EMH_store_error_s1(EMH_severity_error,HANDLER_ERROR,error);
	//WSOM_set_description2(RootTask,error);
	
	return 1;

}else  
	EPM_remove_task_hold	(RootTask);
	
	return ITK_ok;
}

void CreateView ( tag_t TPrev, tag_t TP)
{
	tag_t BomWindowTP = NULLTAG,
		bvr=NULLTAG;
	// BomView Type
	tag_t BomViewType= NULLTAG;
	PS_ask_default_view_type( &BomViewType);	
	PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
	AOM_save (BomWindowTP);
	ITEM_save_item(TP);

    PS_create_bvr (BomWindowTP, NULL, NULL,  true, TPrev, &bvr);
    AOM_save (bvr);
    AOM_save(TPrev);
	AOM_lock(bvr);
//int Status=PS_create_occurrences(bvr,*P1,NULLTAG,1,&Occ);
		tag_t *Occ;				
	int Status=PS_create_occurrences(bvr,NULLTAG,NULLTAG,0,&Occ);
	printf(" status %d \n",Status);
	if(Status ==ITK_ok)EMH_clear_last_error(Status);

	AOM_save(bvr);
	AOM_unlock(bvr);

	MEM_free(Occ);
}
void Vypis_error (char *err)
{
	EMH_store_error_s1(EMH_severity_error,HANDLER_ERROR,err);
}

void ADD2Relation(tag_t Otec,tag_t Object,char * Relation)
{
			 tag_t relation_type,
			relation;
    GRM_find_relation_type(Relation, &relation_type);
	printf("find relation %d \n",relation_type);
	GRM_create_relation(Otec, Object, relation_type, NULLTAG,&relation);
	GRM_save_relation(relation);
}
void AddToRef(tag_t RootTask,tag_t *Object,int num,tag_t puvodni)
{
	for (int i =0;i<num;i++)
	{
		const int AttachmentTypes[1] = {EPM_reference_attachment};
		if(puvodni!=Object[i])
		{
		printf("Pridej do reference rt %d num %d obj %d AT %d \n",RootTask, num, &Object[i], AttachmentTypes[0]);
		EPM_add_attachments(RootTask, 1, &Object[i], AttachmentTypes);
		printf("Pridano \n");
		}else printf("shoda s puvodni \n ");
	}
}
/*int Kontrola_NP(char* id,tag_t RootTask,tag_t Rev)
{
		tag_t *Item;

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("STS_NAK_DIL", &query);
				printf("tag foldru Qry STS_NAK_DIL je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"ND_NAKUPOVANA POLOZKA"};
				char *values[1] =  {id};
				int n_obj = 0;		
							
				QRY_execute(query, 1, entries, values, &n_obj, &Item);
			//	printf("pocet nalezu %d\n",n_obj);
				if(n_obj==0 || n_obj==1)
					return 0;
			AddToRef(RootTask,Item,n_obj,Rev);
	return n_obj;
}*/


int CountInRelation(tag_t Otec,char * Relation)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	printf("find relation %d \n",relation_type);
	 err=GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}

	return Count;
}
void SetInt(tag_t object,int value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_int(object,prop,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno\n");
}
void SetString(tag_t object,char* value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_string(object,prop,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno\n");
}
int getTagRev(char *id_obj)
{
	tag_t Item,
		Rev;

	//					tag_t query = NULLTAG,
	//			* folder=NULLTAG;
	//			QRY_find("Item ID", &query);
	//			printf("tag foldru Qry General je %d\n",query);
	//			// Find user's "Tasks to Perform" folder
	//			char *entries[1] = {"Item ID"};
	//			char *values[1] =  {id_obj};
	//			int n_folder = 0;		
	//						
	//			QRY_execute(query, 1, entries, values, &n_folder, &Item);
	//			printf("pocet nalezu %d\n",n_folder);
	//			if(n_folder==0)
	//				return 0;

	//return Item[0];

	 ITEM_find_item	(	id_obj,&Item);	
	 return Item;
}
void CopyAttr_HM( tag_t Rev,tag_t RootTask, char* c_h_mat)
{
	char 
		*c_nak_pol,
		*c_poznamka,
		*c_material,
		*c_nomenklatura,
		*c_polotovar,
		*c_name,
		*c_nazev_klice,
		n_polotovar[80];
		int id_erp=0,
			tag_hm;
		tag_t I_hm;
	//	AOM_ask_value_string(Rev,"tpv4_hutni_material",&c_h_mat);
		if (strlen(c_h_mat)>6){

			printf("Cislo hut mat %s  \n",c_h_mat);
			tag_hm=getTagRev(c_h_mat);
			if(tag_hm!=0)
			{	
				//printf("257 \n");
				char* stav;
				I_hm= tag_hm;
			/*	AOM_ask_value_string(I_hm,"tpv4_stav_polozky",&stav);
				if (strcmp(stav,"Zakaz pouziti")==0)
				{
					printf("Zakaz pouziti \n");
					strcat(error,"Zakaz pouziti ");
					strcat(error,c_h_mat);
					strcat(error,"\n");
					tag_t Object[1];
					Object[0]=I_hm;
					AddToRef(RootTask,Object,1,Rev);
				}
				else
				{*/
					
					//printf("Najdi HM %d  \n",Rev_hm);
				
					AOM_get_value_int(I_hm,"tpv4_klic_tpv_hm",&id_erp);
					AOM_ask_value_string(I_hm,"tpv4_poznamka_tpv",&c_poznamka);
					AOM_ask_value_string(I_hm,"object_name",&c_name);
					AOM_ask_value_string(I_hm,"tpv4_material",&c_material);
					AOM_ask_value_string(I_hm,"tpv4_nomenklatura",&c_nomenklatura);
					AOM_ask_value_string(I_hm,"tpv4_polotovar",&c_polotovar);
					AOM_ask_value_string(I_hm,"tpv4_nazev_klice",&c_nazev_klice);
					
					
					printf("id Erp HM %d nom %s \n",id_erp,c_nomenklatura);
					SetInt(Rev,id_erp,"tpv4_klic_tpv_hm");
					SetString(Rev,c_nomenklatura,"tpv4_cislo_vykresu_hm");
					/*strcpy(n_polotovar,c_name);
					strcat(n_polotovar," ");*/
					strcpy(n_polotovar,c_polotovar);
					SetString(Rev,n_polotovar,"tpv4_polotovar");
					SetString(Rev,c_material,"tpv4_material");
					SetString(Rev,c_poznamka,"tpv4_poznamka_tpv");
					if(cad)
					{
						//SetString(Rev,n_polotovar,"tpv4_polotovar_cad");
						//SetString(Rev,c_material,"tpv4_material_cad");
					}
					else
					{
						SetString(Rev,c_nomenklatura,"tpv4_nomenklatura");
					}
					//SetString(Rev,c_nazev_klice,"tpv4_nazev_klic");
					if(strcmp(c_nazev_klice,"NEUZIVAT")==0) SetString(Rev,"NEUZIVAT","tpv4_status");
					else if(strcmp(c_nazev_klice,"UMRTVENO")==0) SetString(Rev,"UMRTVENO","tpv4_status");
					else {
						printf("vkladam hodnotu - \n");
						SetString(Rev,"","tpv4_status");
					}
			//	}
			}else printf("nula polozek nalezeno - neexistuje hledana položka %s %d\n",c_h_mat,tag_hm);
		}else printf ("nevyplneny H_mat\n");
		
}

void CopyAttr_NP(tag_t Rev, tag_t RootTask,char* c_nak_pol)
{
	char 
		*c_poznamka,
		*c_material,
		*c_nomenklatura,
		*c_polotovar,
		*c_name,
		*c_nazev_klice,
		n_polotovar[80],
		* obj_type;
	int id_erp=0,
		tag_nak_pol;
	tag_t I_np;
	//AOM_ask_value_string(Rev,"tpv4_nak_polozka",&c_nak_pol);
	AOM_ask_value_string(Rev,"object_type",&obj_type);
	if(strlen(c_nak_pol)>6)
	{
		printf("Cislo %s  \n",c_nak_pol);
		tag_nak_pol=getTagRev(c_nak_pol);
		if(tag_nak_pol!=0)
		{
			I_np= getTagRev(c_nak_pol);
			/*if(Kontrola_NP(c_nak_pol,RootTask,Rev)>1)
			{
				printf("NP Pouzito ve vice ND \n");
				strcat(error,"NP pouzito v vice ND ");
				strcat(error,"\n");
				tag_t Object[1];
				///
			
			}*/
			//else{	
				printf("Najdi NP %d  \n",I_np);
				/*char* stav;
				AOM_ask_value_string(I_np,"tpv4_stav_polozky",&stav);
				if (strcmp(stav,"Zakaz pouziti")==0)
					{
						printf("Zakaz pouziti \n");
						strcat(error,"Zakaz pouziti ");
						strcat(error,c_nak_pol);
						strcat(error,"\n");
						tag_t Object[1];
						Object[0]=I_np;
						AddToRef(RootTask,Object,1,Rev);
					}
				else
				{*/
					AOM_get_value_int(I_np,"tpv4_klic_tpv_np",&id_erp);
					AOM_ask_value_string(I_np,"tpv4_poznamka_tpv",&c_poznamka);
					AOM_ask_value_string(I_np,"object_name",&c_name);
					AOM_ask_value_string(I_np,"tpv4_material",&c_material);
					AOM_ask_value_string(I_np,"tpv4_nomenklatura",&c_nomenklatura);
					AOM_ask_value_string(I_np,"tpv4_polotovar",&c_polotovar);
					AOM_ask_value_string(I_np,"tpv4_nazev_klice",&c_nazev_klice);

					printf("id Erp NP %d \n cislo ",id_erp);
					
					if( strcmp(obj_type,"TPV4_dilRevision")==0)
					{
						/*strcpy(n_polotovar,c_name);
						strcat(n_polotovar," ");*/
						strcpy(n_polotovar,c_polotovar);
						SetString(Rev,n_polotovar,"tpv4_polotovar");
						SetInt(Rev,id_erp,"tpv4_klic_tpv_hm");
						SetString(Rev,c_nomenklatura,"tpv4_cislo_vykresu_hm");
						if(cad)
						{
						//	SetString(Rev,n_polotovar,"tpv4_polotovar_cad");
						//	SetString(Rev,c_material,"tpv4_material_cad");
						}
						else
						{
							SetString(Rev,c_nomenklatura,"tpv4_nomenklatura");
						}
					}else if( strcmp(obj_type,"TPV4_nak_dilRevision")==0)
					{
						SetInt(Rev,id_erp,"tpv4_klic_tpv_np");
						SetString(Rev,c_nomenklatura,"tpv4_cislo_vykresu_np");
						SetString(Rev,c_polotovar,"tpv4_polotovar");					
					}
					SetString(Rev,c_material,"tpv4_material");
					SetString(Rev,c_poznamka,"tpv4_poznamka_tpv");
					//SetString(Rev,c_nazev_klice,"tpv4_nazev_klic");
					if(strcmp(c_nazev_klice,"NEUZIVAT")==0) SetString(Rev,"NEUZIVAT","tpv4_status");
					else if(strcmp(c_nazev_klice,"UMRTVENO")==0) SetString(Rev,"UMRTVENO","tpv4_status");
					else {
						printf("vkladam hodnotu - \n");
						SetString(Rev,"","tpv4_status");
					}
				//}
			//}
		}else printf("nula polozek nalezeno - neexistuje hledana položka %s %d \n",c_nak_pol,tag_nak_pol);
	}else printf ("nevyplneny nak_pol\n");
}
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,char* user_name)
{
	printf("---ListBomLine-----\n"); 
    // Revize
    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
    char Id[ITEM_id_size_c + 1],
		RevId[ITEM_id_size_c + 1],
		*Type;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);
	printf("ID %s/%s \n",Id,RevId);
    // Množství
	//long d_stredisko;//pocet znakù strediska
	//long d_povrch1;//pocet znaku povrch1
	//char *polotovar;
	//char *stredisko;
	//char* varianta;
	//char *Value = NULL;
	int is_released=0;
	EPM_ask_if_released(Rev,&is_released);
	printf("Release %d \n",is_released);
	if (is_released==0)
	{

		WSOM_ask_object_type2(Rev,&Type);
		printf("Type %s \n",Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{			printf ("dilRev \n");
					char *c_h_mat;
					AOM_ask_value_string(Rev,"tpv4_hutni_material",&c_h_mat);
					if (strncmp(c_h_mat,"HM",2)==0)
						CopyAttr_HM( Rev,RootTask,c_h_mat);
					else if (strncmp(c_h_mat,"NP",2)==0)
						CopyAttr_NP( Rev, RootTask,c_h_mat);

		} else if(strcmp(Type,"TPV4_nak_dilRevision")==0)
		{				printf ("nak_dil \n");
						char* c_nak_pol;
						AOM_ask_value_string(Rev,"tpv4_nak_polozka",&c_nak_pol);
						CopyAttr_NP( Rev, RootTask,c_nak_pol);
						
		}else printf ("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	}else printf("schvaleno %s/%s \n",Id,RevId);	
	

   //  Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow,user_name);
	 MEM_free(Childs);
	printf("Konec \n");
	 //printf(" ...konec..\n \n");
		//MEM_free(povrch1);		
		//MEM_free(stredisko);		
		//MEM_free(varianta);
		//MEM_free(Value);
   
	//AddToTarget(RootTask,"V",TP);
}
void AddToTarget(tag_t RootTask,char* O_Name,tag_t Item)
{
	printf("tak posilam do Targetu Roottask %d Item %d jmeno %s \n",RootTask,Item,O_Name);
	tag_t* Object = NULLTAG;
	int Count;
	const int AttachmentTypes[1] = {EPM_target_attachment};
	const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
	const char *AttrValues[1] = {O_Name};
	FL_user_update_newstuff_folder(Item);

	ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	printf("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames);
	EPM_add_attachments(RootTask, Count, Object, AttachmentTypes);
    printf("nakonci ciklu\n");
}

void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr )
{
	printf("vyplnovani \n");
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;
	
	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
		if(strcmp(values_dissplay[j],hodnota)==0)
			{
				printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
				AOM_set_value_string(cil, attr, values[j]);
				j=n_values;
			}
	}

}
int kontrolaLov(char* vstup, char* Lov,char* Zlovu )
{
	int vysledek=0;
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;

	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
		if(strcmp(values_dissplay[j],vstup)==0 && strcmp(values[j],Zlovu)==0)
			{
				vysledek=1;
				j=n_values;
			}
	}
	return vysledek;
}
