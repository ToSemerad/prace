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

logical Neschvalene=false;

extern "C" DLLAPI int TPV_Rozdel_schaval_zak_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Rozdel_schaval_zak_TC11_init_module(int *decision, va_list args);
int TPV_Rozdel_schaval_zak(EPM_action_message_t msg);
EPM_decision_t A_TPV_Rozdel_schaval_zak(EPM_rule_message_t msg);
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


extern "C" DLLAPI int TPV_Rozdel_schaval_zak_TC11_register_callbacks()
{
    printf("Registruji handler-TPV_Rozdel_schaval_zak_TC11.dll\n");
    CUSTOM_register_exit("TPV_Rozdel_schaval_zak_TC11", "USER_init_module", TPV_Rozdel_schaval_zak_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Rozdel_schaval_zak_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Rozdel_schaval_zak", "", TPV_Rozdel_schaval_zak);
    if(Status == ITK_ok) printf("Handler pro zalozeni TP s attributy z KV %s \n", "TPV_Rozdel_schaval_zak");


    return ITK_ok;
}
int Remove_stat(tag_t obj,tag_t root_tag)
{
	int n_statuses = 0,
		TargetsCount;
   tag_t *statuses  = NULL,
		*Targets =NULL;
	int ifail = WSOM_ask_release_status_list(obj, &n_statuses , &statuses);
	if (ifail != ITK_ok) { /* your error logic here */ }
	for(int ii = 0; ii < n_statuses; ii++)
		{
			EPM_ask_attachments( root_tag,EPM_target_attachment, &TargetsCount, &Targets );
			for (int j=0;j<TargetsCount;j++)
				if(Targets[j]==obj)
				{
					EPM_remove_status_from_targets	(	statuses[ii],	root_tag);
				goto next;
				}
				const int AttachmentTypes[1] = {EPM_target_attachment};
				const tag_t *attach=&obj;						
				EPM_add_attachments(root_tag, 1, attach, AttachmentTypes);
				EPM_remove_status_from_targets	(	statuses[ii],	root_tag);
				next:;
	}
	if(statuses) MEM_free(statuses);
	int err=EPM_remove_attachments(root_tag,1,&obj);
	if(err>0)
	{
		EMH_clear_last_error(err);
	printf ("_____________ \n err %d \n ___________\n ",err);
	}
	return ITK_ok;
}

int TPV_Rozdel_schaval_zak(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
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


EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
//printf("TargetsCount %d ",TargetsCount);
//POM_get_user(&user_name, &user_tag);
//printf("\n-----Jmeno %s tag %d-------\n",user_name,user_tag);
//SA_find_person2(user_name,&person_tag);
//printf("person tag %d \n",person_tag);
//SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
//printf("organisation %s \n",P_organ);
Neschvalene=false;
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

	
}
if(Neschvalene)
{
	//EMH_store_error_s1(EMH_severity_error,HANDLER_ERROR,error);
	//WSOM_set_description2(RootTask,error);
	
	return 1;

}else  
	//EPM_remove_task_hold	(RootTask);
	
	return ITK_ok;
}

void Vypis_error (char *err)
{
	EMH_store_error_s1(EMH_severity_error,HANDLER_ERROR,err);
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
int Kontrola_NP(char* id,tag_t RootTask,tag_t Rev)
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
}


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
	tag_t *Item;

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("Item ID", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"Item ID"};
				char *values[1] =  {id_obj};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Item);
				printf("pocet nalezu %d\n",n_folder);
				if(n_folder==0)
					return 0;

	return Item[0];
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
	if (is_released==0)// The value 0 indicates not released, while 1 indicates released
	{


		WSOM_ask_object_type2(Rev,&Type);
		printf("Type %s \n",Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{			printf ("Neschvaleny dilRev \n");
					AddToRef(RootTask,&Rev,1,NULLTAG);
					Neschvalene=true;
					

		} else if(strcmp(Type,"TPV4_nak_dilRevision")==0)
		{				printf ("Neschvaleny nak_dil \n");
						AddToRef(RootTask,&Rev,1,NULLTAG);
						Neschvalene=true;
						
		}else printf ("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	}else 
	{
		printf("schvaleno %s/%s \n",Id,RevId);	
		int Count;
		tag_t *bwr;
		ITEM_rev_list_bom_view_revs(Rev, &Count, &bwr);
		printf("procet schavlenych kusovniku %d \n",Count);
		for(int f=0;f<Count;f++)
		{
			EPM_ask_if_released(bwr[f],&is_released);
			if(is_released==1)
			{
				printf("Remove stat %d \n_______\n",bwr[f]);
				Remove_stat(bwr[f],RootTask);
			}
		}
	}

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




