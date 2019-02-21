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
#include <tccore\grm.h>

extern "C" DLLAPI int TPV_Refs2Targets_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Refs2Targets_TC11_init_module(int *decision, va_list args);
int TPV_Refs2Targets_TC11(EPM_action_message_t msg);
//EPM_decision_t RhTest(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask);
extern "C" DLLAPI int TPV_Refs2Targets_TC11_register_callbacks()
{
    printf("Registruji Handler-TPV_Refs2Targets_TC11.dll\n");
    CUSTOM_register_exit("TPV_Refs2Targets_TC11", "USER_init_module", TPV_Refs2Targets_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Refs2Targets_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Refs2Targets_TC11", "", TPV_Refs2Targets_TC11);
    if(Status == ITK_ok) printf("Handler pro pridani TP do targetu %s byl registrován\n", "TPV_Refs2Targets_TC11");

    // Registrace rule handleru
    /*Status = EPM_register_rule_handler("RhTest", "", RhTest);
    if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");
	*/
    return ITK_ok;
}

void Add_latets_rev_TP_ToRef(tag_t RootTask,tag_t Item, int Count)
{
	printf("74tak posilam do Targetu Roottask %d Item %d  \n",RootTask,Item);
	const int AttachmentTypes[1] = {EPM_reference_attachment};
	printf("76test \n");
	for(int i =0;i<Count;i++)
	{
		printf ("79\n");
		tag_t Object_rev=NULLTAG;
		printf("81\n");
		ITEM_ask_latest_rev(Item,&Object_rev);

		printf ("Do referenci \n");
		EPM_add_attachments(RootTask, Count, &Object_rev, AttachmentTypes);
	}
	//int Count;
	

	
    printf("nakonci ciklu\n");
}


int ADD2Target(tag_t RootTask,int Count,tag_t Object)
{
	const int type[1]={EPM_target_attachment};
	//printf("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames);
	EPM_add_attachments(RootTask, Count, &Object, type);
    //printf("nakonci ciklu\n");
	return 0;
}
int RemoveAttachment(tag_t RootTask,int Count,tag_t Object)
{	
	//printf("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames);	
	EPM_remove_attachments(RootTask,Count,&Object);
    //printf("nakonci ciklu\n");
	return 0;
}
int TPV_Refs2Targets_TC11(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
  tag_t RootTask = NULLTAG;
int RefsCount = 0;
tag_t *Refs = NULLTAG;
EPM_ask_root_task ( msg.task, &RootTask );//dostaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_reference_attachment, &RefsCount, &Refs );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
//printf ("msg tag = %d\n", msg);

for( int i = 0; i < RefsCount; i ++ )
{
	RemoveAttachment(RootTask,1,Refs[i]);
	ADD2Target(RootTask,1,Refs[i]);
}
    return ITK_ok;
}


void ListBomLine(tag_t BomLine, int Level, tag_t RootTask)
{
    // Revize

    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);
	

    tag_t Item = NULLTAG;
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1];
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);

    // Množství
    char *Quantity;
    BOM_line_look_up_attribute("bl_quantity", &AttributeId);
    BOM_line_ask_attribute_string(BomLine, AttributeId, &Quantity);
    if(strcmp(Quantity, "") == 0) strcpy(Quantity, "1");

	    // TP
     char *TP;
	int TPCount =0;
	const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
    BOM_line_look_up_attribute("H4_KV_Cislo_TP", &AttributeId);//omezit dotazi do databaze 
    BOM_line_ask_attribute_string(BomLine, AttributeId, &TP);
	//ITEM_find_item(TP,&ItemTP);
	const char *AttrValues[1] = {TP};
    tag_t *TP_tag = NULLTAG;

    ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &TPCount, &TP_tag);

	if(TP_tag!=NULLTAG)
	{
		/*printf("Revize = %d\n", Rev);
		printf("Item = %d\n", Item);
		printf("ItemId = %s\n", Id);
		printf("ItemIdRev = %s\n", RevId);
		printf ("Rev = %d\n",Rev);
		printf ("TP jm = %s\n",TP);
		printf("Level=%d Id=%s/%s:Quantity%s \n", Level, Id, RevId, Quantity);
		printf("\n");*/
		int AttachmentCount = 1;
//const tag_t AttachmentTags[1] = {Rev};

//EPM_add_attachments(RootTask, AttachmentCount, AttachmentTags,AttachmentTypes);
		/*printf("Tag bez uprav  = %d\n",TP_tag);
		printf("pocet tagu = %d\n",TPCount);*/
		const tag_t*   attachments=TP_tag;
		const int AttachmentTypes[1] = {EPM_target_attachment};
		EPM_add_attachments(RootTask, TPCount, attachments, AttachmentTypes);
		while(TPCount-- > 0)
		{
			ITEM_ask_id(*TP_tag++, TP);
			printf ("Tag TP je %s\n",TP);
			//TPCount--;
		}

	}
	else{ //printf("TP nenalezeno \n");
	}

    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++) ListBomLine(Childs[k], Level + 1,RootTask);
    MEM_free(Childs);
}