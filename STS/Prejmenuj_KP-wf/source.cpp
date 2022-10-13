#define  _CRT_SECURE_NO_WARNINGS 1

#include <string.h>
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
#include <locale.h>


#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Copy_Export_KP_TC12_register_callbacks();
extern "C" DLLAPI int TPV_Copy_Export_KP_TC12_init_module(int *decision, va_list args);
int TPV_Copy_Export_KP(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);


extern "C" DLLAPI int TPV_Copy_Export_KP_TC12_register_callbacks()
{
    printf("Registruji TPV_Copy_Export_KP_TC12.dll\n");
    CUSTOM_register_exit("TPV_Copy_Export_KP_TC12", "USER_init_module", TPV_Copy_Export_KP_TC12_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Copy_Export_KP_TC12_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Copy_Export_KP", "", TPV_Copy_Export_KP);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Copy_Export_KP");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}




int TPV_Copy_Export_KP(EPM_action_message_t msg)
{
     int
        n_attachments = 0,
		countBVR = 0,
		n_parent=0,
		nejvetsi=0,
		otec=0,
		//* levels,
		//countProcess,
		BomsCount = 0,
		prepinac=0,
        ii = 0;
		
    tag_t
        *attachments = NULL,
		Rev=NULLTAG,
        class_tag = NULLTAG,
		*bvrs=NULL,
		BomWindowStredisko=NULLTAG,
		*Boms = NULLTAG,
		job=NULLTAG,
		parents=NULLTAG,
		parents_rev=NULLTAG,
		Item=NULLTAG,
	
		
		RootTask=NULLTAG;
    char  
        task_name[WSO_name_size_c+2] = "",
        *class_name = NULL,
		*Id=NULL,
		//*Process_name,
		*job_name,
		text[124]="copy \"C:\\Temp\\",
		//Vrchol_rev[2],
		//* type,
		//*ItemId,
		*Output="~KP",
		*Pname="copy ",
        description[WSO_desc_size_c+1]  = "";
	logical on;
    EPM_decision_t
        //decision=EPM_undecided ;
		decision=EPM_nogo ;
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;
	POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);

		//sprintf(cmd, "%s %s %s -uid=", util, login, xml_file);
		AOM_UIF_ask_value(job,"object_name",&job_name);
		//printf(" %s \n",job_name);
		// setlocale(LC_ALL, "");
		

		 /* deliver */
		const char s[2] = ":";
		const char k[2] = ";";
		const char needle[2] = ":";
		

		
		

	
		if(strstr(job_name,"~")!=NULL || strstr(job_name,";")!=NULL)
		
		{
			if (strstr(job_name, needle) != NULL) {
				char rename[256] = "rename \"C:\\Temp\\*";




				/* get the first job name = name of workflow tamplate is new for TC 12 */
				job_name = strtok(job_name, s);
				/* get the second job_name */

				job_name = strtok(NULL, k);

				for (int i = 0;i < strlen(job_name);i++)
				{

					//printf (" %d \n",i);
					if (job_name[i] == '/')job_name[i] = '_';

				}
				strcat(rename, job_name);
				strcat(rename, "*\" \"");
				strcat(rename, job_name);
				strcat(rename, ";.plmxml\"");
				printf(" job_name %s \n", job_name);
				printf("%s \n", rename);
				//system("pause");
				system(rename);
			}


			char file[20];
			strcpy(file, "*");
			strncat(file,job_name,15);
			strcat(file,"*");
			
			

					strcat(text,file);
					printf(" text: %d \n",text);
			strcat(job_name,Output);
			
		}
		else{
			
			printf("vkladam nakonec \n");
		//	strcat(job_name,Output);
			
		
		}
		
	//strcat(job_name,Output);
		for(int i=0;i<strlen(text);i++)
			{

				//printf (" %d \n",i);
				if(text[i]=='/')text[i]='_';
				
				}
		strcat(text,".plmxml\"");

		//for(int i=0;i<strlen(job_name);i++)
		//	{

		//		//printf (" %d \n",i);
		//		if(job_name[i]=='/')job_name[i]='_';
		//		if(job_name[i]=='-')prepinac=i;
		//		if(prepinac>=6)
		//		{
		//			//printf("prepinac %d delka %d \n",prepinac,strlen(job_name));
		//	    //job_name[i]=Output[i-prepinac];
		//		//printf("%c  %d \n",job_name[i],(prepinac-i));
		//		}
		//}
		//strcat(text, " \"\\\\SRVTCBASE\\TcESO_vymena\\TC_Export\\");
		int ArgumentCount = TC_number_of_arguments(msg.arguments);
		char *Argument = nullptr;
		char*Flag = nullptr;
		char*Value = nullptr;

		while (ArgumentCount-- > 0)
		{
			Argument = TC_next_argument(msg.arguments);
			ITK_ask_argument_named_value((const char*)Argument, &Flag, &Value);
			
			if (strcmp("Test", Flag) == 0) strcat(text, " \"\\\\SRVTCBASE\\TcESO_vymena\\Test\\");
			else if (strcmp("Prod", Flag) == 0)  strcat(text, " \"\\\\SRVTCBASE\\TcESO_vymena\\TC_Export\\");
		}
		//strcat(text, " \"\\\\SRVTCBASE\\TcESO_vymena\\TC_Export\\");
		
		//strcat(text,job_name);
		//strcat(text, ".plmxml\"");
	//	strcat(text, "N.plmxml\"");
	printf("L:%d test: %s \n",__LINE__,text);
	//POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );//bypass nefunuje
	//AOM_UIF_set_value(job,"object_name",job_name);
		//setlocale(LC_ALL, "en_US.utf8");
	 //  printf("Locale: %s\n \n",setlocale(LC_ALL, NULL));
  //     setlocale(LC_ALL, "cs_CZ.utf8");
	 //  printf("Locale: %s\n \n",setlocale(LC_ALL, NULL));
	char * text2;
	//utf8_to_latin9(text2,text,strlen(text));

  system("cmd /c \"date /t \"");
 //system("cd C:\\Temp");
   printf("system %s \n",text);
  printf("system2 %s \n",text2);
  system(text);
 // system(text2);

    return ITK_ok;
}
