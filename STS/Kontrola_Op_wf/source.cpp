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


#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))

extern "C" DLLAPI int TPV_Control_OP_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Control_OP_TC11_init_module(int *decision, va_list args);
int TPV_Control_OP(EPM_action_message_t msg);
EPM_decision_t A_TPV_Control_OP(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* user_name);
void AddToRef(tag_t RootTask,tag_t obj);

int CountInRelation(tag_t Otec,char * Relation,tag_t RootTask, tag_t **Objects);

int stopProcess=0;

extern "C" DLLAPI int TPV_Control_OP_TC11_register_callbacks()
{
    printf("Registruji handler-TPV_Control_OP_TC11.dll\n");
    CUSTOM_register_exit("TPV_Control_OP_TC11", "USER_init_module", TPV_Control_OP_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Control_OP_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Control_OP", "", TPV_Control_OP);
    if(Status == ITK_ok) printf("Handler pro zalozeni TP s attributy z KV %s \n", "TPV_Control_OP");


    return ITK_ok;
}
int Ask_BomView (tag_t Rev)
{
		int n_bvrs = 0;
	tag_t *bvrs = NULL;
	ITEM_rev_list_bom_view_revs(Rev, &n_bvrs, &bvrs);
return n_bvrs;
}

//void Add_latets_rev_TP_ToRef(tag_t RootTask,tag_t Item, int Count)
//{
//	printf("74tak posilam do Targetu Roottask %d Item %d  \n",RootTask,Item);
//	const int AttachmentTypes[1] = {EPM_reference_attachment};
//	printf("76test \n");
//	for(int i =0;i<Count;i++)
//	{
//		printf ("79\n");
//		tag_t Object_rev=NULLTAG;
//		printf("81\n");
//		ITEM_ask_latest_rev(Item,&Object_rev);
//
//		printf ("Do referenci \n");
//		EPM_add_attachments(RootTask, Count, &Object_rev, AttachmentTypes);
//	}
//	//int Count;
//	
//
//	
//    printf("nakonci ciklu\n");
//}

int Control_Op(tag_t Rev_TP)
{
	char* Type;
	
	WSOM_ask_object_type2(Rev_TP,&Type);//Returns the object type of the specified WorkspaceObject.
	printf (" %d  %s\n",__LINE__,Type);
	 int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Rev_TP, &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
		printf ("%d  %d \n",__LINE__,BomsCount);
		if (BomsCount==0) return 0;
        for(int j = 0; j < BomsCount; j++)
        {

            // BOM window
            tag_t BomWindow = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Rev_TP, Boms[j], &BomTopLine);
			 tag_t *Childs = NULLTAG;
			int ChildsCount;
			BOM_line_ask_child_lines(BomTopLine, &ChildsCount, &Childs);
			printf ("%d  %d \n",__LINE__,ChildsCount);
			if (ChildsCount==0) return 0;
			for (int j;j<ChildsCount;j++)
			{
				// Revize
				int AttributeId;
				tag_t Rev = NULLTAG;
				BOM_line_look_up_attribute("bl_revision", &AttributeId);
				BOM_line_ask_attribute_tag(Childs[j], AttributeId, &Rev);
				WSOM_ask_object_type2(Rev,&Type);
				printf ("%d type %s \n",__LINE__,Type);
				if (strcmp(Type,"TPV4_operaceRevision")==0) {
					printf ("ok operace nalezena \n");

						return 1;
				}
			}
			//nastaveni context bomline absolute occurrence edit mode			
			//BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			
			BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
			
        }
	return 0;
}

int TPV_Control_OP(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	stopProcess=0;
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0;
tag_t *Targets = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;
char* user_name;
tag_t user_tag;
tag_t person_tag;
char* P_organ;

EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
printf("TargetsCount %d ",TargetsCount);
POM_get_user(&user_name, &user_tag);
printf("\n-----Jmeno %s tag %d-------\n",user_name,user_tag);
//SA_find_person2(user_name,&person_tag);
//printf("person tag %d \n",person_tag);
//SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
//printf("organisation %s \n",P_organ);
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
		if(BomsCount==0)
		{
			int is_released=0;
	//EPM_ask_if_released(Targets[i],&is_released);
	//if (is_released==0 )
	//{
			WSOM_ask_object_type2(Targets[i],&Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{	
			tag_t* TP_item;
					if(int CountTP=CountInRelation(Targets[i],"TPV4_tp_rel",RootTask,&TP_item)==1)
					{
						tag_t TP_rev;
						for(int ii=0;ii<CountTP;ii++)
						{
							ITEM_ask_latest_rev(TP_item[ii],&TP_rev);
							int is_Op=Control_Op(TP_rev);

							if (is_Op==0)//nenalezena operace v kusovniku TP
							{
								AddToRef(RootTask,Targets[i]);
								stopProcess=1;
							}
						}
						
						

						}else printf("nenalezen TP \n");		
		}else printf ("Neni TPV4_dil je %s \n",Type);
	//}else printf("schvaleno \n");	
		}

}
	printf("%d stop processs %d \n",__LINE__,stopProcess);
    return stopProcess;
}
/*
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
*/
void ADD2Relation(tag_t Otec,tag_t Object,char * Relation)
{
			 tag_t relation_type,
			relation;
    GRM_find_relation_type(Relation, &relation_type);
	//printf("207 find relation %d %d %d \n",relation_type,Otec,Object);
	GRM_create_relation(Otec, Object, relation_type, NULLTAG,&relation);
	//printf("209\n");
	GRM_save_relation(relation);
	//printf("konec relace \n");
}
int CountInRelation(tag_t Otec,char * Relation,tag_t RootTask, tag_t **Objects)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	//printf("220 find relation %d \n",relation_type);
	 err=GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	 printf("count %d \n",Count);
	 if (Count>0)
	{
		*Objects = secondary_list;
		return Count;
	}
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	//printf ("secondary list [0] %d \n",*secondary_list);
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	return Count;
}

void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,char* user_name)
{
	
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


	//int is_released=0;
	//EPM_ask_if_released(Rev,&is_released);
	//if (is_released==0 && Level!=0)
	//{
			WSOM_ask_object_type2(Rev,&Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{	
			tag_t* TP_item;
					if(int CountTP=CountInRelation(Rev,"TPV4_tp_rel",RootTask,&TP_item)==1)
					{
						printf("%d pocet TP %d \n",__LINE__,CountTP);
						tag_t TP_rev;
						for(int ii=0;ii<CountTP;ii++)
						{
							ITEM_ask_latest_rev(TP_item[ii],&TP_rev);
							int is_Op=Control_Op(TP_rev);
							printf("%d is Op %d \n",__LINE__, is_Op);
							if (is_Op==0)//nenalezena operace v kusovniku TP
							{
								AddToRef(RootTask,Rev);
								stopProcess=1;
							}
						}
						
						

						}else {
							printf("nenalezen TP u %s/%s \n",Id,RevId);		
							AddToRef(RootTask,Rev);
					}
		}else printf ("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	//}else printf("schvaleno %s/%s \n",Id,RevId);	
	

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
void AddToRef(tag_t RootTask,tag_t obj)
{
	printf("tak posilam do Ref \n");
	tag_t* Object = &obj;
	int Count;
	const int AttachmentTypes[1] = {EPM_reference_attachment};
	
	EPM_add_attachments(RootTask, 1, Object, AttachmentTypes);
    printf("nakonci ciklu\n");
}


void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr)
{int AttrId=0;
BOM_line_look_up_attribute(Attr, &AttrId);
BOM_line_set_attribute_string(BomLine, AttrId, value);
BOM_save_window(BomWin);
}


