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
#include <time.h>

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
    //if(Status == ITK_ok) fprintf(log,"Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}

/// reportovani by Gtac
#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_RETURN(X) if (IFERR_REPORT(X)) return
#define IFERR_RETURN_IT(X) if (IFERR_REPORT(X)) return X
#define ECHO(X)  printf X; TC_write_syslog X

#define SAFE_MEM_FREE( a )   \
do                          \
{                           \
    if ( (a) != NULL )      \
    {                       \
        MEM_free( (a) );    \
        (a) = NULL;         \
    }                       \
}                           \
while ( 0 )

void LogErr(char * text, char *logfile, int line, char* time_stamp)
{
	FILE *fs;
	char *user_name_string = NULL;
	tag_t user_tag = NULLTAG;
	int ifail = POM_get_user(&user_name_string, &user_tag);
	if (ifail != ITK_ok) user_name_string = "Nenalezen";

	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	fprintf(fs, "user: %s;  cas:%s; line: %d text: %s \n", user_name_string, time_stamp, line, text);
	fclose(fs);
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

		EMH_get_error_string(NULLTAG, return_code, &error_message_string);
		ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));

		LogErr(error_message_string, "report_error", line, time);

		if (error_message_string) MEM_free(error_message_string);
		ECHO(("\nExiting program!\n <<<<<<<\n"));
		exit(EXIT_FAILURE);
	}
}

/////////////////////////////////////////


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

//FILE *log;
//log=fopen("C:\\Temp\\testy.log","a+");

EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_all_attachments( RootTask, &TargetsCount, &Targets,&Attachments_type );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
//fprintf(log,"TargetsCount %d Attachments_type %s ",TargetsCount,Attachments_type);
/*POM_get_user(&user_name, &user_tag);
fprintf(log,"-----Jmeno %s tag %d-------\n",user_name,user_tag);
SA_find_person2(user_name,&person_tag);
fprintf(log,"person tag %d \n",person_tag);
SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
fprintf(log,"organisation %s \n",P_organ);*/

		const int AttachmentTypes[1] = { EPM_reference_attachment  };

	
for(int j=0; j < TargetsCount; j ++ ){
	char* description;

	AOM_ask_value_string(Targets[j],"h4_attr1",&description);

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
	//printf (" popis %s \n",description);

//if(IsRevision == false) continue;

	if(strcmp("top_level",description)==0)
	{
		char *Type;
		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
		//printf ("%s\n",Type);
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
			SAFE_MEM_FREE(Type);
	}     
//const tag_t*   attachment=&Targets[i];
//EPM_remove_attachments(RootTask,1,attachment);
//		EPM_add_attachments(RootTask, 1, attachment, AttachmentTypes);
//		hop:;
	SAFE_MEM_FREE(description);
}
//fprintf(log,"test Prohledávání Referencí kvùli schválení  \n");
    
	char* RevId=NULL;
	EPM_ask_all_attachments( RootTask, &TargetsCount, &Targets,&Attachments_type );
	
	
	for(int j=0; j < TargetsCount; j ++ ){
		char* Id= NULL;
		int is_released=0;
	AOM_ask_value_string(Targets[j],"h4_attr1",&Id);
	//fprintf(log," id %s \n",Id);
	//fprintf(log,"targets count %d attchment type %d  \n",TargetsCount, Attachments_type[j]);
	
	if(Attachments_type[j]==3)
	{
		EPM_ask_if_released(Targets[j],&is_released);
		if(is_released==1)
		{ 
			const tag_t*   attachment=&Targets[j];
			EPM_remove_attachments(RootTask,1,attachment);
			
		}
		
	}
	
	SAFE_MEM_FREE(Id);	
}
	
	SAFE_MEM_FREE(Attachments_type);
	SAFE_MEM_FREE(Targets);
	SAFE_MEM_FREE(rootLine);

			return ITK_ok;

}
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow)
{
//	FILE *log;
//log=fopen("C:\\Temp\\testyBL.log","a+");
	 //fprintf(log," ...start..\n \n");
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
	//fprintf(log,"SEAR = %s  is released %d \n",SEAR,is_released);

	
	
	if (Level != 0) 
	{
		
		//fprintf(log,"%d %s/%s: %s, %s, %s, %s, poznamka: %s\n", Level, Id, RevId, povrch1, povrch2, povrch2, stredisko,poznamka);
		AOM_ask_value_string(Rev,"h4_vykres_norma",&V_N);
		AOM_ask_value_string(Rev,"h4_material",&Nakupovany);
		//fprintf(log,"%d %s/%s: %s \n", Level, Id, RevId, SEAR);
		const tag_t*   attachments=&Rev;
		const int AttachmentTypes[1] = { EPM_target_attachment };
		if((strcmp(SEAR,"0")==0)){
		
				//fprintf(log,"test SEAR \n");
				goto end;
		}
		//if(is_released!=1){

		//printf ("nakupovaný %s vykresnorma %s \n",Nakupovany,V_N);

		if ((strcmp(V_N,"0")==0)||(strcmp(Nakupovany,"ANO")==0)){
		//const int AttachmentTypes[1] = { EPM_reference_attachment  };
					//fprintf(log,"test nakupovany ANO || V_N 0\n");
			goto skoc;
		}
		//fprintf(log," add target \n");
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
	 SAFE_MEM_FREE(Childs);
	end:;
	 //fprintf(log," ...konec..\n \n");
		SAFE_MEM_FREE(folder);		
		SAFE_MEM_FREE(Lov );		
		SAFE_MEM_FREE(Childs);
		SAFE_MEM_FREE(Value);
		SAFE_MEM_FREE(SEAR);
		SAFE_MEM_FREE(V_N);
		SAFE_MEM_FREE(Nakupovany);
	//AddToTarget(RootTask,"V",TP);
	 //fclose(log);
}