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
#include <locale.h>


#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Rename_Export_TC12_register_callbacks();
extern "C" DLLAPI int TPV_Rename_Export_TC12_init_module(int *decision, va_list args);
int TPV_Rename_Export(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);


extern "C" DLLAPI int TPV_Rename_Export_TC12_register_callbacks()
{
    printf("Registruji TPV_Rename_Export_TC12.dll\n");
    CUSTOM_register_exit("TPV_Rename_Export_TC12", "USER_init_module", TPV_Rename_Export_TC12_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Rename_Export_TC12_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Rename_Export", "", TPV_Rename_Export);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Rename_Export");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}

static inline unsigned int to_latin9(const unsigned int code)
{
    /* Code points 0 to U+00FF are the same in both. */
    if (code < 256U)
        return code;
    switch (code) {
    case 0x0152U: return 188U; /* U+0152 = 0xBC: OE ligature */
    case 0x0153U: return 189U; /* U+0153 = 0xBD: oe ligature */
    case 0x0160U: return 166U; /* U+0160 = 0xA6: S with caron */
    case 0x0161U: return 168U; /* U+0161 = 0xA8: s with caron */
    case 0x0178U: return 190U; /* U+0178 = 0xBE: Y with diaresis */
    case 0x017DU: return 180U; /* U+017D = 0xB4: Z with caron */
    case 0x017EU: return 184U; /* U+017E = 0xB8: z with caron */
    case 0x20ACU: return 164U; /* U+20AC = 0xA4: Euro */
    default:      return 256U;
    }
}
size_t utf8_to_latin9(char *const output, const char *const input, const size_t length)
{
    unsigned char             *out = (unsigned char *)output;
    const unsigned char       *in  = (const unsigned char *)input;
    const unsigned char *const end = (const unsigned char *)input + length;
    unsigned int               c;

    while (in < end)
        if (*in < 128)
            *(out++) = *(in++); /* Valid codepoint */
        else
        if (*in < 192)
            in++;               /* 10000000 .. 10111111 are invalid */
        else
        if (*in < 224) {        /* 110xxxxx 10xxxxxx */
            if (in + 1 >= end)
                break;
            if ((in[1] & 192U) == 128U) {
                c = to_latin9( (((unsigned int)(in[0] & 0x1FU)) << 6U)
                             |  ((unsigned int)(in[1] & 0x3FU)) );
                if (c < 256)
                    *(out++) = c;
            }
            in += 2;

        } else
        if (*in < 240) {        /* 1110xxxx 10xxxxxx 10xxxxxx */
            if (in + 2 >= end)
                break;
            if ((in[1] & 192U) == 128U &&
                (in[2] & 192U) == 128U) {
                c = to_latin9( (((unsigned int)(in[0] & 0x0FU)) << 12U)
                             | (((unsigned int)(in[1] & 0x3FU)) << 6U)
                             |  ((unsigned int)(in[2] & 0x3FU)) );
                if (c < 256)
                    *(out++) = c;
            }
            in += 3;

        } else
        if (*in < 248) {        /* 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx */
            if (in + 3 >= end)
                break;
            if ((in[1] & 192U) == 128U &&
                (in[2] & 192U) == 128U &&
                (in[3] & 192U) == 128U) {
                c = to_latin9( (((unsigned int)(in[0] & 0x07U)) << 18U)
                             | (((unsigned int)(in[1] & 0x3FU)) << 12U)
                             | (((unsigned int)(in[2] & 0x3FU)) << 6U)
                             |  ((unsigned int)(in[3] & 0x3FU)) );
                if (c < 256)
                    *(out++) = c;
            }
            in += 4;

        } else
        if (*in < 252) {        /* 111110xx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx */
            if (in + 4 >= end)
                break;
            if ((in[1] & 192U) == 128U &&
                (in[2] & 192U) == 128U &&
                (in[3] & 192U) == 128U &&
                (in[4] & 192U) == 128U) {
                c = to_latin9( (((unsigned int)(in[0] & 0x03U)) << 24U)
                             | (((unsigned int)(in[1] & 0x3FU)) << 18U)
                             | (((unsigned int)(in[2] & 0x3FU)) << 12U)
                             | (((unsigned int)(in[3] & 0x3FU)) << 6U)
                             |  ((unsigned int)(in[4] & 0x3FU)) );
                if (c < 256)
                    *(out++) = c;
            }
            in += 5;

        } else
        if (*in < 254) {        /* 1111110x 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx 10xxxxxx */
            if (in + 5 >= end)
                break;
            if ((in[1] & 192U) == 128U &&
                (in[2] & 192U) == 128U &&
                (in[3] & 192U) == 128U &&
                (in[4] & 192U) == 128U &&
                (in[5] & 192U) == 128U) {
                c = to_latin9( (((unsigned int)(in[0] & 0x01U)) << 30U)
                             | (((unsigned int)(in[1] & 0x3FU)) << 24U)
                             | (((unsigned int)(in[2] & 0x3FU)) << 18U)
                             | (((unsigned int)(in[3] & 0x3FU)) << 12U)
                             | (((unsigned int)(in[4] & 0x3FU)) << 6U)
                             |  ((unsigned int)(in[5] & 0x3FU)) );
                if (c < 256)
                    *(out++) = c;
            }
            in += 6;

        } else
            in++;               /* 11111110 and 11111111 are invalid */

    /* Terminate the output string. */
    *out = '\0';

    return (size_t)(out - (unsigned char *)output);
}


int TPV_Rename_Export(EPM_action_message_t msg)
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
		del_xml[124]="DEL \"C:\\Temp\\",
		Pripona[5],
		//* type,
		//*ItemId,
		//*Output="~TP",
		//*Pname="copy ",
        description[WSO_desc_size_c+1]  = "";
	logical copy_tp=false;
	logical copy_kp=false;
    EPM_decision_t
        //decision=EPM_undecided ;
		decision=EPM_nogo ;
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;
	char*Argument = nullptr;
	char*Flag = nullptr;
	char*Value = nullptr;
	int ArgumentCount = TC_number_of_arguments(msg.arguments);

	while(ArgumentCount--> 0 )
{
	Argument = TC_next_argument( msg.arguments );
	ITK_ask_argument_named_value( Argument, &Flag, &Value );
	printf("Value %s Flag %s \n",Value, Flag);
	if( strcmp ( "Pripona", Flag ) == 0 && Value != nullptr)
	{
		//printf(" cesta %s \n",Value);
		if(strcmp(Value,"TP")==0)
		{
			copy_tp=true;
		}else if(strcmp(Value,"KP")==0)
		{
			copy_kp=true;
		}
	// …
	}
}

	POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);

		//sprintf(cmd, "%s %s %s -uid=", util, login, xml_file);
		AOM_UIF_ask_value(job,"object_name",&job_name);
		//printf(" %s \n",job_name);
		// setlocale(LC_ALL, "");
	
		if(strstr(job_name,"~")!=NULL || strstr(job_name,";")!=NULL)
		
		{
			char file[20];
			strncpy(file,job_name,15);
			strcat(file,"*");
			
			

					strcat(text,file);
					strcat(del_xml,file);
					printf(" text: %d \n",text);
			strcat(job_name,Pripona);
			
		}
		/*else{
			
			printf("vkladam nakonec \n");
			strcat(job_name,Pripona);
			strcat(del_xml,Pripona);
		
		}*/
		
	//strcat(job_name,Output);
		for(int i=0;i<strlen(text);i++)
			{

				//printf (" %d \n",i);
				if(text[i]=='/')text[i]='_';
				if(del_xml[i]=='/')del_xml[i]='_';
				}
		strcat(text,".plmxml\"");
		strcat(del_xml,".plmxml\"");
		for(int i=0;i<strlen(job_name);i++)
			{

				//printf (" %d \n",i);
				if(job_name[i]=='/')job_name[i]='_';
				if(job_name[i]=='-')prepinac=i;
				/*if(prepinac>=6)
				{
					//printf("prepinac %d delka %d \n",prepinac,strlen(job_name));
				job_name[i]=Output[i-prepinac];
				//printf("%c  %d \n",job_name[i],(prepinac-i));
				}*/
		}
		//strcat(text, " \"\\\\SRVTCBASE\\TcESO_vymena\\TC_Export\\");
		strcat(text, " \"\\\\SRVTCBASE\\TcESO_vymena\\TC_Export\\");
		
		if(copy_tp)
		{
			strncat(text,job_name,15);
			strcat(text, "~TP");
			strcat(text, ".plmxml\"");
		}
		if(copy_kp)
		{
			//strcat(text,job_name);
		//	strcat(text, "~KP");
		}
		
	//	strcat(text, "N.plmxml\"");
	printf("150 %s \n",text);
	//POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );//bypass nefunuje
	//AOM_UIF_set_value(job,"object_name",job_name);
		//setlocale(LC_ALL, "en_US.utf8");
	 //  printf("Locale: %s\n \n",setlocale(LC_ALL, NULL));
  //     setlocale(LC_ALL, "cs_CZ.utf8");
	 //  printf("Locale: %s\n \n",setlocale(LC_ALL, NULL));

	//utf8_to_latin9(text2,text,strlen(text));

  system("cmd /c \"date /t \"");
 //system("cd C:\\Temp");
   printf("system %s \n",text);

  system(text);
  printf("del_xml :\n %s \n",del_xml);
  system(del_xml);

    return ITK_ok;
}
