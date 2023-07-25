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

extern "C" DLLAPI int TPV_Targets2Refs_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Targets2Refs_TC11_init_module(int *decision, va_list args);
int TPV_Targets2Refs_TC11(EPM_action_message_t msg);
//EPM_decision_t RhTest(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask);
extern "C" DLLAPI int TPV_Targets2Refs_TC11_register_callbacks()
{
    printf("Registruji Handler-TPV_Targets2Refs_TC11.dll\n");
    CUSTOM_register_exit("TPV_Targets2Refs_TC11", "USER_init_module", TPV_Targets2Refs_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Targets2Refs_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Targets2Refs_TC11", "", TPV_Targets2Refs_TC11);
    if(Status == ITK_ok) printf("Handler pro pridani TP do targetu %s byl registrován\n", "TPV_Targets2Refs_TC11");

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


int ADD2Refs(tag_t RootTask,int Count,tag_t Object)
{
	const int type[1]={EPM_reference_attachment};
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
int TPV_Targets2Refs_TC11(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
  tag_t RootTask = NULLTAG;
int TargetsCount = 0;
tag_t *Targets = NULLTAG;
EPM_ask_root_task ( msg.task, &RootTask );//dostaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
//printf ("msg tag = %d\n", msg);

for( int i = 0; i < TargetsCount; i ++ )
{
	ADD2Refs(RootTask,1,Targets[i]);
	//RemoveAttachment(RootTask,1,Targets[i]);
	
}
    return ITK_ok;
}