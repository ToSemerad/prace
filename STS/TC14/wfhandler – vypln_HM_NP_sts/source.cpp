#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <epm/epm.h>
#include <ict/ict_userservice.h>
#include <user_exits/user_exits.h>
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
#include <time.h>

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define HANDLER_ERROR 2010
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define ECHO(X)  printf X; TC_write_syslog X


char error[256];
int out=0;

extern "C" DLLAPI int TPV_Vypln_HM_NP_TC14_register_callbacks();
extern "C" DLLAPI int TPV_Vypln_HM_NP_TC14_init_module(int *decision, va_list args);
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
void CopyAttr_HM( tag_t Rev, tag_t RootTask);
void CopyAttr_NP( tag_t Rev, tag_t RootTask);


extern "C" DLLAPI int TPV_Vypln_HM_NP_TC14_register_callbacks()
{
    ECHO(("Registruji handler-TPV_Vypln_HM_NP_TC14.dll\n"));
    CUSTOM_register_exit("TPV_Vypln_HM_NP_TC14", "USER_init_module", TPV_Vypln_HM_NP_TC14_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Vypln_HM_NP_TC14_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Vypln_HM_NP", "", TPV_Vypln_HM_NP);
    if(Status == ITK_ok) ECHO(("Handler pro zalozeni TP s attributy z KV %s \n", "TPV_Vypln_HM_NP"));


    return ITK_ok;
}
char *time_stamp() {

	char *timestamp = (char *)malloc(sizeof(char) * 16);
	//char timestamp[10];
	time_t ltime;
	ltime = time(NULL);
	struct tm *tm;
	tm = localtime(&ltime);

	sprintf(timestamp, "%04d-%02d-%02d_%02d:%02d:%02d", tm->tm_year + 1900, tm->tm_mon + 1,
		tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);


	return timestamp;
}

static void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;
		char *time = time_stamp();
		
		EMH_ask_error_text(return_code, &error_message_string);
		ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));

		

		if (error_message_string) MEM_free(error_message_string);
		ECHO(("\nExiting program!\n <<<<<<<\n"));
		exit(EXIT_FAILURE);
	}
}

int TPV_Vypln_HM_NP(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	out=0;
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0;
tag_t *Targets = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;
char* user_name;
//tag_t user_tag;
//tag_t person_tag;
//char* P_organ;

strcpy(error,"\0");
EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
//ECHO(("TargetsCount %d ",TargetsCount);
//POM_get_user(&user_name, &user_tag);
//ECHO(("\n-----Jmeno %s tag %d-------\n",user_name,user_tag);
//SA_find_person2(user_name,&person_tag);
//ECHO(("person tag %d \n",person_tag);
//SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
//ECHO(("organisation %s \n",P_organ);
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
			 CopyAttr_HM( Targets[i],RootTask);
								
		}else if(strcmp(Type,"TPV4_nak_dilRevision")==0)
		{
			CopyAttr_NP( Targets[i],RootTask);
		}
	}//else ECHO(("schvaleno %s/%s \n",Id,RevId);
}
//if(strlen(error)>5)
//{
//	//EMH_store_error_s1(EMH_severity_error,HANDLER_ERROR,error);
//	//WSOM_set_description2(RootTask,error);
//	//report_error_stack();
//	return 1;
//
//}else  
	//EPM_remove_task_hold	(RootTask);
	
	return out;
}

void CreateView ( tag_t TPrev, tag_t TP)
{
	tag_t BomWindowTP = NULLTAG,
		bvr=NULLTAG;
	// BomView Type
	tag_t BomViewType= NULLTAG;
	PS_ask_default_view_type( &BomViewType);	
	PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
	AOM_save_with_extensions (BomWindowTP);
	ITEM_save_item(TP);

    PS_create_bvr (BomWindowTP, NULL, NULL,  true, TPrev, &bvr);
    AOM_save_with_extensions (bvr);
    AOM_save_with_extensions(TPrev);
	AOM_lock(bvr);
//int Status=PS_create_occurrences(bvr,*P1,NULLTAG,1,&Occ);
		tag_t *Occ;				
	int Status=PS_create_occurrences(bvr,NULLTAG,NULLTAG,0,&Occ);
	ECHO((" status %d \n",Status));
	if(Status ==ITK_ok)EMH_clear_last_error(Status);

	AOM_save_with_extensions(bvr);
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
	ECHO(("find relation %d \n",relation_type));
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
		ECHO(("Pridej do reference rt %d num %d obj %d AT %d \n",RootTask, num, &Object[i], AttachmentTypes[0]));
		EPM_add_attachments(RootTask, 1, &Object[i], AttachmentTypes);
		ECHO(("Pridano \n"));
		}else ECHO(("shoda s puvodni \n "));
	}
}
int Kontrola_NP(char* id,tag_t RootTask,tag_t Rev)
{
		tag_t *ItemRev=NULL;
		tag_t *Item=NULL;
		tag_t targetItem=NULLTAG;
		int output =0;
				tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find2("STS_NAK_DIL", &query);
				ECHO(("tag foldru Qry STS_NAK_DIL je %d\n",query));
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"ND_NAKUPOVANA POLOZKA"};
				char *values[1] =  {id};
				int n_obj = 0;		
							
				QRY_execute(query, 1, entries, values, &n_obj, &ItemRev);
				Item=(tag_t *)malloc(sizeof(tag_t) * n_obj);
				ECHO(("pocet nalezu %d\n",n_obj));
				if(n_obj==0 || n_obj==1)
					return 0;

				const int AttachmentTypes[1] = {EPM_reference_attachment};
				Item=(tag_t *)malloc(sizeof(tag_t) * n_obj);
				ITEM_ask_item_of_rev(Rev,&targetItem);
				
				for (int i =0; i<n_obj;i++)
					{
						ITEM_ask_item_of_rev(ItemRev[i],&Item[i]);
						printf ("item %d %d \n",i,Item[i]);
						
						
							printf (" %d. %d=%d %d\n",0,targetItem,Item[i],i);
							if (targetItem!=Item[i])
							{
								ECHO(("ADD to REF \n"));
								EPM_add_attachments(RootTask, 1, &ItemRev[i], AttachmentTypes);
								output++;
								out=1;
							}
						
				}
				//AddToRef(RootTask,ItemRev,n_obj,Rev);
				
				free(Item);
			//AddToRef(RootTask,ItemRev,n_obj,Rev);
				ECHO(("return %d \n",output));
	return output;
}


int CountInRelation(tag_t Otec,char * Relation)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){ECHO(("Problem err %d \n",err));}
	ECHO(("find relation %d \n",relation_type));
	 err=GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	if(err!=ITK_ok){ECHO(("Problem err %d \n",err));}

	return Count;
}
void SetInt(tag_t object,int value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_int(object,prop,value);
	AOM_save_with_extensions(object);
	AOM_unlock(object);
	//AOM_unload(object);
	ECHO(("Vlozeno\n"));
}
void SetString(tag_t object,char* value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_string(object,prop,value);
	AOM_save_with_extensions(object);
	AOM_unlock(object);
	//AOM_unload(object);
	ECHO(("Vlozeno\n"));
}
int getTagRev(char *id_obj)
{
	logical	verdict;
	tag_t items;
	ECHO(("id obj %s \n",id_obj));
	ITEM_id_exists	(	id_obj,&verdict	);
	ECHO(("Line %d %d\n",__LINE__,verdict));
	if (verdict)
		{
			ECHO(("Existuje \n"));
				
			ITEM_find_item(id_obj,&items);
			return items;
	}
	ECHO(("Neexistuje \n"));
	return 0;
}
void CopyAttr_HM( tag_t Rev,tag_t RootTask)
{
		char *c_h_mat,
			*c_zbozi;
		int id_erp=0,
			tag_hm;
		tag_t I_hm;
		AOM_ask_value_string(Rev,"tpv4_hutni_material",&c_h_mat);
		if (strlen(c_h_mat)>6){

			ECHO(("Cislo hut mat %s  \n",c_h_mat));
			tag_hm=getTagRev(c_h_mat);
			if(tag_hm!=0)
			{	
				//ECHO(("257 \n");
				char* stav;
				I_hm= tag_hm;
				AOM_ask_value_string(I_hm,"tpv4_stav_polozky",&stav);
				if (strcmp(stav,"Zakaz pouziti")==0)
				{
					ECHO(("Zakaz pouziti \n"));
					strcat(error,"Zakaz pouziti ");
					strcat(error,c_h_mat);
					strcat(error,"\n");
					tag_t Object[1];
					Object[0]=I_hm;
					AddToRef(RootTask,Object,1,Rev);
				}
				else
				{
					
					//ECHO(("Najdi HM %d  \n",Rev_hm);
					AOM_ask_value_int(I_hm,"tpv4_id_erp",&id_erp);
					if(id_erp==0)
					{
						char tmp_err[100];
						sprintf(tmp_err,"Hutní material %s nemá vyplnení id erp \n Kontaktuejte administratora TC \n",c_h_mat);
						strcat(error,tmp_err);
						out=1;
					}
					else 
					{
						AOM_ask_value_string(I_hm,"tpv4_cislo_erp",&c_zbozi);
						ECHO(("id Erp HM %d \n",id_erp));
						SetInt(Rev,id_erp,"tpv4_id_erp_hm");
						SetString(Rev,c_zbozi,"tpv4_cislo_zbozi_hm");
					}
				}
			}else 
			{
				/*char tmp_err[100];
				sprintf(tmp_err,"Neexistuje hledana položka %s %d\n Kontaktuejte administratora TC \n",c_h_mat,tag_hm);
				strcat(error,tmp_err);*/
				out=1;
			}
		}else printf ("nevyplneny H_mat\n");
		
}

void CopyAttr_NP(tag_t Rev, tag_t RootTask)
{
	char *c_nak_pol,
		*c_zbozi;
	int id_erp=0,
		tag_nak_pol;
	tag_t I_np;
	AOM_ask_value_string(Rev,"tpv4_nak_polozka",&c_nak_pol);
	if(strlen(c_nak_pol)>6)
	{
		ECHO(("%d Cislo %s  \n",__LINE__,c_nak_pol));
		tag_nak_pol=getTagRev(c_nak_pol);
		ECHO(("%d tag_nak_pol %d \n",__LINE__,tag_nak_pol));
		if(tag_nak_pol!=0)
		{
			I_np= getTagRev(c_nak_pol);
			if(Kontrola_NP(c_nak_pol,RootTask,Rev)>1)
			{
				ECHO(("NP Pouzito ve vice ND \n"));
				strcat(error,"NP pouzito v vice ND ");
				strcat(error,"\n");
				//tag_t Object[1];
				///
			
			}
			//else{	
				ECHO(("Najdi NP %d  \n",I_np));
				char* stav;
				AOM_ask_value_string(I_np,"tpv4_stav_polozky",&stav);
				if (strcmp(stav,"Zakaz pouziti")==0)
					{
						ECHO(("Zakaz pouziti \n"));
						strcat(error,"Zakaz pouziti ");
						strcat(error,c_nak_pol);
						strcat(error,"\n");
						tag_t Object[1];
						Object[0]=I_np;
						AddToRef(RootTask,Object,1,Rev);
					}
				else
				{
					AOM_ask_value_int(I_np,"tpv4_id_erp",&id_erp);
					if(id_erp==0)
					{
						/*char tmp_err[100];
						sprintf(tmp_err,"Nakupovany material %s nemá vyplnení id erp \n Kontaktuejte administratora TC \n",c_nak_pol);
						strcat(error,tmp_err);*/
						out=1;
					}
					else 
					{
						AOM_ask_value_string(I_np,"tpv4_cislo_erp",&c_zbozi);
						ECHO(("id Erp NP %d \n cislo ",id_erp));
						SetInt(Rev,id_erp,"tpv4_id_erp_np");
						SetString(Rev,c_zbozi,"tpv4_cislo_zbozi");
					}
				}
			//}
		}else
		{
			/*char tmp_err[100];
			ECHO(("Line %d \n",__LINE__);
			sprintf(tmp_err,"Neexistuje hledana položka %s \nKontaktuejte administratora TC \n",c_nak_pol);
			ECHO(("Line %d \n",__LINE__);
			strcat(error,tmp_err);*/
			out=1;
		}
	}else printf ("nevyplneny nak_pol\n");
}
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,char* user_name)
{
	ECHO(("---ListBomLine-----\n")); 
    // Revize
    //int AttributeId;
    tag_t Rev = NULLTAG;
    //BOM_line_look_up_attribute("bl_revision", &AttributeId);
	AOM_ask_value_tag(BomLine, "bl_revision", &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
    char* Id = NULLTAG,
		*RevId = NULLTAG,
		*Type;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id2(Item, &Id);
    ITEM_ask_rev_id2(Rev, &RevId);
	ECHO(("ID %s/%s \n",Id,RevId));
    // Množství
	//long d_stredisko;//pocet znakù strediska
	//long d_povrch1;//pocet znaku povrch1
	//char *polotovar;
	//char *stredisko;
	//char* varianta;
	//char *Value = NULL;
	int is_released=0;
	EPM_ask_if_released(Rev,&is_released);
	ECHO(("Release %d \n",is_released));
	if (is_released==0)
	{

		WSOM_ask_object_type2(Rev,&Type);
		ECHO(("Type %s \n",Type));

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{			printf ("dilRev \n");
					CopyAttr_HM( Rev,RootTask);

		} else if(strcmp(Type,"TPV4_nak_dilRevision")==0)
		{				printf ("nak_dil \n");
						CopyAttr_NP( Rev, RootTask);
						
		}else printf ("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	}else ECHO(("schvaleno %s/%s \n",Id,RevId));	
	

   //  Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow,user_name);
	 MEM_free(Childs);
	ECHO(("Konec \n"));
	 //ECHO((" ...konec..\n \n");
		//MEM_free(povrch1);		
		//MEM_free(stredisko);		
		//MEM_free(varianta);
		//MEM_free(Value);
   
	//AddToTarget(RootTask,"V",TP);
}
void AddToTarget(tag_t RootTask,char* O_Name,tag_t Item)
{
	ECHO(("tak posilam do Targetu Roottask %d Item %d jmeno %s \n",RootTask,Item,O_Name));
	tag_t* Object = NULLTAG;
	int Count;
	const int AttachmentTypes[1] = {EPM_target_attachment};
	const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
	const char *AttrValues[1] = {O_Name};
	FL_user_update_newstuff_folder(Item);

	ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	ECHO(("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames));
	EPM_add_attachments(RootTask, Count, Object, AttachmentTypes);
    ECHO(("nakonci ciklu\n"));
}




void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr )
{
	ECHO(("vyplnovani \n"));
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	//tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;
	
	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		ECHO(("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]));
		if(strcmp(values_dissplay[j],hodnota)==0)
			{
				ECHO(("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]));
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
	//tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;

	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		ECHO(("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]));
		if(strcmp(values_dissplay[j],vstup)==0 && strcmp(values[j],Zlovu)==0)
			{
				vysledek=1;
				j=n_values;
			}
	}
	return vysledek;
}
