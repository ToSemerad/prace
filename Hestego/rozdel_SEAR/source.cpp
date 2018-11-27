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

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Rozdel_SEAR_TC10_register_callbacks();
extern "C" DLLAPI int TPV_Rozdel_SEAR_TC10_init_module(int *decision, va_list args);
int TPV_Rozdel_SEAR(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow);
extern "C" DLLAPI int TPV_Rozdel_SEAR_TC10_register_callbacks()
{
    printf("Registruji TPV_Rozdel_SEAR_TC10.dll\n");
    CUSTOM_register_exit("TPV_Rozdel_SEAR_TC10", "USER_init_module", TPV_Rozdel_SEAR_TC10_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Rozdel_SEAR_TC10_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Rozdel_SEAR", "", TPV_Rozdel_SEAR);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Rozdel_SEAR");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}



int TPV_Rozdel_SEAR(EPM_action_message_t msg)
{
     tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0,
	*Attachments_type=0;
tag_t *Targets = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;



EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_all_attachments( RootTask, &TargetsCount, &Targets,&Attachments_type );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
printf("TargetsCount %d Attachments_type %s ",TargetsCount,Attachments_type);
/*POM_get_user(&user_name, &user_tag);
printf("-----Jmeno %s tag %d-------\n",user_name,user_tag);
SA_find_person2(user_name,&person_tag);
printf("person tag %d \n",person_tag);
SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
printf("organisation %s \n",P_organ);*/

		const int AttachmentTypes[1] = { EPM_reference_attachment  };

	
for(int j=0; j < TargetsCount; j ++ ){
	char* description;

	AOM_ask_value_string(Targets[j],"object_desc",&description);

	if(strcmp("top_level",description)==0)goto hop;

		const tag_t*   attachment=&Targets[j];
		EPM_remove_attachments(RootTask,1,attachment);
		EPM_add_attachments(RootTask, 1, attachment, AttachmentTypes);
		hop:;
}


for( int i = 0; i < TargetsCount; i ++ )
{
	POM_class_of_instance(Targets[i], &TargetClassTag);


	logical IsRevision = false;
	char* description=NULL;

	POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);
	AOM_ask_value_string(Targets[i],"object_desc",&description);
	printf (" popis %s \n",description);

//if(IsRevision == false) continue;

	if(strcmp("top_level",description)==0)
	{
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
			ListBomLine(BomTopLine, 0, RootTask,BomWindow);
			BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
		}
		/*goto hop;*/
}     
//const tag_t*   attachment=&Targets[i];
//EPM_remove_attachments(RootTask,1,attachment);
//		EPM_add_attachments(RootTask, 1, attachment, AttachmentTypes);
//		hop:;
}
printf("test Prohledávání Referencí kvùli schválení  \n");
    
	char* RevId=NULL;
	EPM_ask_all_attachments( RootTask, &TargetsCount, &Targets,&Attachments_type );
	
	
	for(int j=0; j < TargetsCount; j ++ ){
		char* Id= NULL;
		int is_released=0;
	AOM_ask_value_string(Targets[j],"object_name",&Id);
	printf(" id %s \n",Id);
	printf("targets count %d attchment type %d  \n",TargetsCount, Attachments_type[j]);
	
	if(Attachments_type[j]==3)
	{
		EPM_ask_if_released(Targets[j],&is_released);
		if(is_released==1)
		{ 
			const tag_t*   attachment=&Targets[j];
			EPM_remove_attachments(RootTask,1,attachment);
		}
		
	}
		
}


			return ITK_ok;
}
static void report_error( char *file, int line, char *function, int return_code)
{
    if (return_code != ITK_ok)
    {
        char *error_msg_string;

        EMH_get_error_string (NULLTAG, return_code, &error_msg_string);
        printf("ERROR: %d ERROR MSG: %s.\n", return_code, error_msg_string);
        TC_write_syslog("ERROR: %d ERROR MSG: %s.\n", return_code, 
            error_msg_string);
        printf ("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line);    
        TC_write_syslog("FUNCTION: %s\nFILE: %s LINE: %d\n", 
            function, file, line);
        if(error_msg_string) MEM_free(error_msg_string);
    }
}
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow)
{
	 //printf(" ...start..\n \n");
    // Revize
    int AttributeId,
		is_released=0;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
	//EPM_ask_if_released(Rev,&is_released);
				
	
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1];
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);

    // Množství

    char *SEAR;
	char *V_N;
	char *Value = NULL;
	char *Nakupovany=NULL;
	
	tag_t TP = NULLTAG;
	tag_t TPrev = NULLTAG;
	

    BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
    BOM_line_ask_attribute_string(BomLine, AttributeId, &SEAR);
	printf("SEAR = %s  is released %d \n",SEAR,is_released);

	
	
	if (Level != 0) 
	{
		
		//printf("%d %s/%s: %s, %s, %s, %s, poznamka: %s\n", Level, Id, RevId, povrch1, povrch2, povrch2, stredisko,poznamka);
		AOM_ask_value_string(Rev,"h4_vykres_norma",&V_N);
		AOM_ask_value_string(Rev,"h4_material",&Nakupovany);
		//printf("%d %s/%s: %s \n", Level, Id, RevId, SEAR);
		const tag_t*   attachments=&Rev;
		const int AttachmentTypes[1] = { EPM_target_attachment };
		if((strcmp(SEAR,"0")==0)){
		
				printf("test SEAR \n");
				goto end;
		}
		//if(is_released!=1){

		//printf ("nakupovaný %s vykresnorma %s \n",Nakupovany,V_N);

		if ((strcmp(V_N,"0")==0)||(strcmp(Nakupovany,"ANO")==0)){
		//const int AttachmentTypes[1] = { EPM_reference_attachment  };
					printf("test nakupovany ANO || V_N 0\n");
			goto skoc;
		}
		//printf(" add target \n");
		EPM_remove_attachments(RootTask,1,attachments);
		EPM_add_attachments(RootTask, 1, attachments, AttachmentTypes);
	skoc:;
	//}
	}

    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow);
	 MEM_free(Childs);
	end:;
	 //printf(" ...konec..\n \n");
		//MEM_free(povrch1);		
	/*	MEM_free(stredisko);		
		MEM_free(varianta);
		MEM_free(Value);*/
   
	//AddToTarget(RootTask,"V",TP);
}