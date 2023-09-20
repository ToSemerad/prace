#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <epm/epm.h>
#include <ict/ict_userservice.h>
#include <tccore/aom_prop.h>
#include <user_exits/user_exits.h>
#include <tccore/aom.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>
#include <ae\ae.h>
#include <tccore\grm.h>
#include <unidefs.h>
#include <errno.h>
#include <sa\user.h>
#include <time.h>
#include <cfm/cfm.h>

#define HANDLER_ERROR 2010
#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))
#define ECHO(X)  printf X; TC_write_syslog X

extern "C" DLLAPI int TPV_TC2Mapos_TC14_register_callbacks();
extern "C" DLLAPI int TPV_TC2Mapos_TC14_init_module(int *decision, va_list args);
int TPV_TC2Mapos_TC14(EPM_action_message_t msg);

char prvotni_cesta[50] = "";
bool prvni_pruchod = true;

//char *Nazvy[100][20];
char Nazvy[100000][39][150];

int Type_num=0;
int Attr_num=0 ;
int Remove_line=0;
char Attr [10][32][128];
char Attr_type [10][32][128];
char EntryExistenece[10][128];
char AttryExistenece[10][128];
char attr_set[10][128];
char value_set[10][128];
char from_copy[20],
	to_copy[20];

bool debug=false;
bool export2Helios = true;
char status_exportu[3] = "1";

extern "C" DLLAPI int TPV_TC2Mapos_TC14_register_callbacks()
{
    ECHO(("Registruji TPV_TC2Mapos_TC14.dll\n"));
    CUSTOM_register_exit("TPV_TC2Mapos_TC14", "USER_init_module", TPV_TC2Mapos_TC14_init_module);

    return ITK_ok;
}
static void report_error_stack()
{
    int n_errors = 0;
    const int *severities = NULL;
    const int *error_code = NULL;
    const char **msg;
    int ii = 0;
    EMH_ask_errors(&n_errors, &severities, &error_code, &msg);
    ECHO(("\n n_errors: %d \n", n_errors));
    for (ii = n_errors - 1; ii >= 0  ; ii--)
    {
        if (severities[ii] == EMH_severity_information) 
            ECHO(("    Information - error_code[%d]: %d - msg[%d]: %s\n", 
                ii, error_code[ii],ii, msg[ii]));
        if (severities[ii] == EMH_severity_warning) 
            ECHO(("    Warning - error_code[%d]: %d - msg[%d]: %s\n", 
                ii, error_code[ii],ii, msg[ii]));                
        if (severities[ii] == EMH_severity_error) 
            ECHO(("    Error - error_code[%d]: %d - msg[%d]: %s\n", 
            ii, error_code[ii],ii, msg[ii]));
    }
}


size_t iso8859_1_to_utf8(char *content, size_t max_size)
{
    char *src, *dst;

    //first run to see if there's enough space for the new bytes
    for (src = dst = content; *src; src++, dst++)
    {
        if (*src & 0x80)
        {
            // If the high bit is set in the ISO-8859-1 representation, then
            // the UTF-8 representation requires two bytes (one more than usual).
            ++dst;
        }
    }

    if (dst - content + 1 > max_size)
    {
        // Inform caller of the space required
        return dst - content + 1;
    }

    *(dst + 1) = '\0';
    while (dst > src)
    {
        if (*src & 0x80)
        {
            *dst-- = 0x80 | (*src & 0x3f);                     // trailing byte
            *dst-- = 0xc0 | (*((unsigned char *)src--) >> 6);  // leading byte
        }
        else
        {
            *dst-- = *src--;
        }
    }
    return 0;  // SUCCESS
}

char *time_stamp() {

	char *timestamp = (char *)malloc(sizeof(char) * 16);
	//char timestamp[10];
	time_t ltime;
	ltime = time(NULL);
	struct tm *tm;
	tm = localtime(&ltime);

	sprintf(timestamp, "%04d-%02d-%02d %02d:%02d:%02d", tm->tm_year + 1900, tm->tm_mon + 1,
		tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);


	return timestamp;
}
char* replace_char(char* value,char source, char goal)
{
	char change_value[128];
	strcpy(change_value,value);
		for (int i=0;i<strlen(value);i++)
		{
			if(change_value[i]==',')
				change_value[i]='.';
		}
	return change_value;
}

/* removes the newline character from a string */
char* remove_enter(char *string)
{
	int i, len;
	len = strlen(string);
	char *newstring;

	newstring = (char *)malloc(len - 1);


	for (i = 0; i < strlen(string) - 1; i++)
	{
		newstring[i] = ' ';
		if (string[i] == '\n')
			newstring[i] = ' ';
		else
			newstring[i] = string[i];
		
	}

	/*ECHO(("len og newstring %d\n", strlen(newstring));
	ECHO(("string now .......... %s\n", newstring);*/

	return newstring;
}
/*
 AOM_ask_value_string(
	tag_t               object,        
const char*         prop_name,      
char**              value           
);
*/
int get_string(tag_t object, const char* prop_name, char** value)
{
	char * orig_string;
		int return_int=AOM_ask_value_string(object, prop_name, &orig_string);
		*value = orig_string;
		//*value=remove_enter(orig_string);
		return return_int;
}
int copy_string2varacha(char * orig_string,int poradi,int numAttr)
{

	int return_int = 0;
	strcpy(Nazvy[poradi][numAttr], "'");
	strcat(Nazvy[poradi][numAttr], orig_string);
	if(strlen(orig_string)==0)
		strcat(Nazvy[poradi][numAttr], " ");
	strcat(Nazvy[poradi][numAttr], "'");
	//*value=remove_enter(orig_string);
	return return_int;
}

void string2number(int poradi,int cislo_num, char* tmp)
{
	char* value = strtok(tmp, " ");
	char* unit = strtok(NULL, "\0");
	if (strcmp(tmp, "-") == 0 ||strlen(tmp)==0)
		strcpy(Nazvy[poradi][cislo_num], "0");
	else
		strcpy(Nazvy[poradi][cislo_num], replace_char(value, ',', '.'));
}

void Report_import(EPM_action_message_t msg, tag_t condition_task)
{
	char info [2048];


	strcpy(info," ");
char* log="C:\\SPLM\\Apps\\Export\\log_imp.txt";
   FILE* stream = fopen(log, "r");
		ECHO(("Open %s\n",log));
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		//strcat(info,line); //toto následnì odkomentovat
		strcat(info,"import byl proveden \n");
	}
	
	//iso8859_1_to_utf8(info, 2048);
	ECHO(("info: %s \n ",info));
	//int ifail = EPM_set_task_result(msg.task, EPM_RESULT_True);
 //       if (ifail != ITK_ok) { /* your error logic here */ }
        
        //ifail = EPM_trigger_action(condition_task, EPM_complete_action, "");
        //if (ifail != ITK_ok) { /* your error logic here */ }
        	

        EMH_clear_errors();
      //  EMH_store_error_s1(EMH_severity_warning, 9500001, "Result is true");
		//EMH_store_error_s2(EMH_severity_warning, 9500001,"Info Import", "Result is true");
		 EMH_store_error_s1(EMH_severity_information, 919000, info);
        //if (ifail != ITK_ok) { /* your error logic here */ }
		report_error_stack();

	fclose(stream);
}
extern "C" DLLAPI int TPV_TC2Mapos_TC14_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_TC2Mapos_TC14", "", TPV_TC2Mapos_TC14);
    if(Status == ITK_ok) ECHO(("Action handler %s byl registrován\n", "TPV_TC2Mapos_TC14"));

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) ECHO(("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}


int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6][4]){
	int jetam=0;
	for(int j=0;j<=6;j++)
	{
	//	ECHO(("strom %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
		
		if((level==pole[j][0])&&(bomLine==pole[j][1])&&(Rev==pole[j][2]))
		{
			ECHO(("shoda %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]));
			jetam=1;
			break;
		}
	
	}

	return jetam;
}

int SouborExistuje(char *nazev)
{ECHO(("test existence souboru %s  \n",nazev));
    FILE *soubor;
    if ((soubor = fopen(nazev, "rb")) != NULL) {
        fclose(soubor);
		ECHO(("nalezen \n"));
        return 0;       /* soubor existuje,
                           jinak by se jej nepodarilo otevrit */
    }
 
    if (errno == ENOENT) {
		ECHO(("nenalezen \n"));
        return 1;   /* soubor neexistuje */
    }
 ECHO(("nic se nedìje \n"));
    return 2;      /* soubor mozna existuje, ale nepodarilo se
                           jej otevrit (treba uz je otevreno prilis
                           mnoho souboru nebo nemate prava atp.) */
}


int CountInRelation(tag_t Child, char * Relation,tag_t* primary_obj)
{
	int Count = 0;
	tag_t * primary_list=NULLTAG;
	tag_t relation_type;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { ECHO(("Problem err %d \n", err)); }
	//ECHO(("220 find relation %d \n",relation_type);
	err = GRM_list_primary_objects_only(Child, relation_type, &Count, &primary_list);
	ECHO(("count %d \n", Count));
	if (err != ITK_ok) { ECHO(("Problem err %d \n", err)); }
	//GetName_rev(primary_list[0]);
	if(Count==1)
		*primary_obj=primary_list[0];
	else if(Count>1)
		{
		for(int i=0;i<Count;i++)
				{
					logical latest=false;
					ITEM_rev_sequence_is_latest(primary_list[i],&latest);
					if(latest)
					{
						char *Type;
						WSOM_ask_object_type2(primary_list[i],&Type);//Returns the object type of the specified WorkspaceObject.


						return 1;//kdyz neni zakomentovaný blok níže toto smazat
						/*if (strcmp(Type,"H4_LAKRevision")==0 ||strcmp(Type,"H4_NPVDRevision")==0)
						{
						
							*primary_obj=primary_list[i];
							if(primary_list) MEM_free(primary_list);
							return 1;
						}*/
					}
				}
	}
	//printf ("secondary list [0] %d \n",*secondary_list);
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	if(primary_list) MEM_free(primary_list);
	return Count;
}

char* Owner(tag_t object)
{
	char* user_name;
	tag_t  owning_user;
	AOM_ask_owner(object, &owning_user);
	//SA_ask_user_person_name2(owning_user_tag, &person_name);
	SA_ask_user_identifier2(owning_user, &user_name);
	return user_name;
}

void GetProperty (int polozka_num,int num,tag_t object,char** value)
{
	if(strcmp(Attr_type[polozka_num][num],"<string")==0)
	{
		//value=OpravCz(value);
		int IERROR=get_string(object,Attr[polozka_num][num],&*value);
		printf ("\n Err %d string attr %s \n value %s \n",IERROR,Attr[polozka_num][num],*value);
	}else if(strcmp(Attr_type[polozka_num][num],"<item_string")==0)
	{
		tag_t Item;
		ITEM_ask_item_of_rev(object,&Item);
		//value=OpravCz(value);
		int IERROR=get_string(Item,Attr[polozka_num][num],&*value);
		printf ("\n Err %d string attr %s \n value %s \n",IERROR,Attr[polozka_num][num],*value);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<int")==0)
	{
		int tmp_int=0;
		AOM_ask_value_int(object,Attr[polozka_num][num],&tmp_int);
		sprintf(*value,"%s",tmp_int);
		printf ("int .....%d = %s \n",tmp_int,value);
		//printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		//if(strcpy(value," ")!=0)
			
	}
	else if(strcmp(Attr_type[polozka_num][num],"<double")==0)
	{
		double tmp_double=0;
		AOM_ask_value_double(object,Attr[polozka_num][num],&tmp_double);
		sprintf(*value,"%s",tmp_double);
		printf ("double.....%f = %s \n",tmp_double,value );
		//if(strcpy(value," ")!=0)
			
	}
	else if(strcmp(Attr_type[polozka_num][num],"<noread")==0)
		printf ("--nic\n");

	//}
	else if(strcmp(Attr_type[polozka_num][num],"<set_string")==0)
	{ 
		//char* tmp_text;
		
		int IERROR=AOM_set_value_string(object,attr_set[polozka_num],value_set[polozka_num]);
		printf ("Err %d string attr %s   %s \n",IERROR,attr_set[polozka_num],value_set[polozka_num]);
	}
}

static tag_t ask_item_revision_from_bom_line(tag_t bom_line)
{
    tag_t
        item_revision = NULLTAG;
    char 
        *item_id = NULL,
        *rev_id = NULL;
    
    get_string(bom_line, "bl_item_item_id", &item_id );
    get_string(bom_line, "bl_rev_item_revision_id", &rev_id);
    ITEM_find_rev(item_id, rev_id, &item_revision);
    
    if (item_id) MEM_free(item_id);
    if (rev_id) MEM_free(rev_id);
    return item_revision;
}
char* Create_folder(char* cesta, char* slozka)
{
	char mkdir[160] = "mkdir \"";

	char cesta_new[150]="";
	strcpy(cesta_new, cesta);
	for (int k = 0; k < strlen(slozka); k++)
		if (slozka[k] == ' ')
			slozka[k] = '_';
	strcat(cesta_new, slozka);

	strcat(mkdir, cesta_new);
	int remove_x = 0;
	for (int t = 2; t < strlen(mkdir); t++)
	{	//ECHO(("znak %c \n",mkdir[t]);
		//if (mkdir[t] == '\\' && mkdir[t - 1] == '\\' && (mkdir[t + 1] != '\\'))
		//{
		//	ECHO(("nalezeno escape %d \n", strlen(mkdir));
		//	for (int q = t; q <= strlen(mkdir); q++)
		//	{
		//		//ECHO(("copy %c -> %c \n",mkdir[q],mkdir[q-1]);
		//		mkdir[q - 1] = mkdir[q];
		//	}
		//}
	}
	strcat(mkdir, "\"");
	strcat(cesta_new, "\\");
	system(mkdir);

	ECHO(("system %s \n %s \n", mkdir, cesta_new));
	if (debug)ECHO(("L:%d \n ", __LINE__));
	return cesta_new;
}

void downloadDataset(tag_t rev,char* I_ID, int poradi, char* typ, char* ID_v,bool Image)
{
	ECHO(("----------download dataset >> %s------------- \n",typ));
	 int ifail = ITK_ok;
	  int ii = 0;
    tag_t root_task = NULLTAG;
    int n_attachs = 0;
    tag_t* attachs = NULL;
    tag_t rev_tag = NULLTAG;
    tag_t relation_type_tag = NULLTAG;
    int n_specs = 0;
    tag_t* specs = NULL;
    char *type_name;
    tag_t type_tag = NULLTAG;
    int n_refs = 0;
    tag_t* refs = NULL;
	char ID_new[30],
		*ID_Rev;
	strcpy(ID_new,I_ID);
	//char cesta[50]="\\\\10.1.1.8\\vymena_dat_free\\ComTC_TPV\\pdf_TC\\"; \\\\srv-file\\ProductFiles\\

	char cesta[250]="";
	strcpy(cesta, prvotni_cesta);
	if (debug)ECHO(("L:%d cesta %s \n ", __LINE__, cesta));

	ECHO(("I_ID %s \n",I_ID));
	for (int k =0;k<strlen(ID_new);k++)
		if((ID_new[k]==' ')||(ID_new[k]=='\\'))
			ID_new[k]='_';

	
	int err=get_string(rev,"item_revision_id",&ID_Rev);

	strcat(ID_new, "_");
	//	ECHO(("3Cesta %s delka %d\ %s n",cesta,strlen(cesta),ID_Rev);
	strcat(ID_new, ID_Rev);

	if (prvni_pruchod)
	{
		prvni_pruchod = false;
		strcpy(prvotni_cesta, Create_folder(cesta, ID_new));
		if (debug)ECHO(("L:%d prvotni cesta %s \n ", __LINE__, prvotni_cesta));
	}

	
	if (debug)ECHO(("L:%d cesta %s \n ", __LINE__, cesta));
	if (Image)
	{
		ifail = GRM_find_relation_type("IMAN_manifestation", &relation_type_tag);
		if (debug)ECHO(("L:%d IMAN_manifestation %d \n ", __LINE__, relation_type_tag));
	}
	else
		ifail = GRM_find_relation_type("IMAN_specification", &relation_type_tag); //IMAN_specification IMAN_Rendering

    if (ifail != ITK_ok) { /* your error logic here */ }
	
		
	//if (n_specs==0)
	//{
	//	ifail = GRM_find_relation_type("IMAN_specification", &relation_type_tag);
	//	if (ifail != ITK_ok) { /* your error logic here */ }
	//}
	ifail = GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs);
    if (ifail != ITK_ok) { /* your error logic here */ }
    ECHO(("pocet datasetu %d\n",n_specs));
	
	if(debug)system("pause");

    for (ii = 0; ii < n_specs; ii++)
    {

		strcpy(cesta, prvotni_cesta);

        ifail = TCTYPE_ask_object_type (specs[ii], &type_tag);
        if (ifail != ITK_ok) { /* your error logic here */ }
        
		
        ifail = TCTYPE_ask_name2(type_tag, &type_name);
        if (ifail != ITK_ok) { /* your error logic here */ }
		ECHO(("%d. dataset = %s \n",ii,type_name));
      
			
		if(strcmp(typ,"pdf")==0)
		{
			ECHO(("-----typ ok\n"));
			  if (strcmp(type_name, "PDF") == 0)
			  {
				//  strcat(cesta, ID_new);
				  //	ECHO(("2Cesta %s \n",cesta);
				  

				  

				  char* format_vykresu;
				  get_string(rev, "tpv4_format_vykresu", &format_vykresu);

				 // strcat(cesta, format_vykresu);
				  
				  //strcat(cesta, "\\");

			//	  ECHO(("-----typ_name ok\n");
				 
				ifail = AE_ask_all_dataset_named_refs2(specs[ii], "PDF_Reference", &n_refs, &refs);

			//	ECHO(("Reference %d \n",n_refs);
				if (n_refs != 0)
				{
					strcpy(cesta, Create_folder(cesta, "PDF"));
					strcpy(cesta, Create_folder(cesta, format_vykresu));
				}
				if (ifail != ITK_ok) { ECHO(("chyba v dotazu na dataset\n")); }
				else ECHO((" ok export\n"));
			//  ECHO(("1Cesta %s \n",cesta);
			strcat(cesta,ID_new);
			//	ECHO(("2Cesta %s \n",cesta);
			
			//	ECHO(("4Cesta %s \n",cesta);
			strcat(cesta,".");
			//	ECHO(("5Cesta %s \n",cesta);
			strcat(cesta,typ);
			//	ECHO(("6Cesta %s \n",cesta);
		//	strcpy(Nazvy[poradi][18],cesta);
			copy_string2varacha(cesta, poradi, 18);
			//	ECHO(("7cesta %s poradi %d\n",Nazvy[poradi][5],poradi);
			//if(SouborExistuje(cesta)==1)
			//{
				if(debug)
				{
					ECHO(("cesta %s \n",cesta));

				}
				ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
				if (ifail != ITK_ok) { ECHO(("Nefunguje export \n cesta %s \n",cesta ));}
			   }
			 // }
	    }
		else if (strcmp(typ, "dxf") == 0)
		{
			//strcat(cesta, ID_new);
			//	ECHO(("2Cesta %s \n",cesta);

			if (strcmp(type_name, "DXF") == 0)
			{

				strcpy(cesta, Create_folder(cesta, "DXF"));
				if (Image)
				{
					//ifail = AE_ask_all_dataset_named_refs(specs[ii], "Image", &n_refs, &refs);
					ifail = AE_ask_all_dataset_named_refs2(specs[ii], "DXF", &n_refs, &refs);
					ECHO(("DXF pocet referenci %d \n", n_refs));
				}
				else
				{
					ifail = AE_ask_all_dataset_named_refs2(specs[ii], "DXF", &n_refs, &refs);
					ECHO(("DXF pocet referenci %d \n", n_refs));
					if (n_refs == 0)
					{
						if(debug)ECHO(("L:%d ii=%d. dataset = %s \n",__LINE__, ii, type_name));
						//downloadDataset(rev, I_ID, poradi, typ, ID_v, true);

						return;
					}
				}


				if (ifail != ITK_ok) { ECHO(("chyba v dotazu na dataset\n")); }
				else ECHO((" ok export\n"));
				//  ECHO(("1Cesta %s \n",cesta);
				strcat(cesta, ID_new);
				//	ECHO(("2Cesta %s \n",cesta);

				//	ECHO(("4Cesta %s \n",cesta);
				strcat(cesta, ".");
				//	ECHO(("5Cesta %s \n",cesta);
				strcat(cesta, typ);
				//	ECHO(("6Cesta %s \n",cesta);
				//strcpy(Nazvy[poradi][20], cesta);
				copy_string2varacha(cesta, poradi, 19);

				if (debug)
				{
					ECHO(("L:%d cesta %s \n", __LINE__, cesta));
					system("pause");
				}
				if (Image)
				{
					ifail = AE_export_named_ref(specs[ii], "DXF", cesta);
					if (debug)ECHO(("L:%d export Image dxf \n ", __LINE__));
				}
				else
					ifail = AE_export_named_ref(specs[ii], "DXF", cesta);
				if (ifail != ITK_ok) { ECHO(("Nefunguje export \n cesta %s \n", cesta)); }

			}
		/*	else if (n_refs == 0)
			{
				if (debug)ECHO(("L:%d ii=%d. dataset = %s \n", __LINE__, ii, type_name);
				if (Image)
					return;
			
				
				downloadDataset(rev, I_ID, poradi, typ, ID_v, true);

				return;
			}*/
	
		}
		else if (strcmp(typ, "dwg") == 0)
		{
			//strcat(cesta, ID_new);
			//	ECHO(("2Cesta %s \n",cesta);
			if (debug)ECHO(("L:%d export Image dwg \n ", __LINE__));

			if (strcmp(type_name, "Image") == 0)	
			{
			
				strcpy(cesta, Create_folder(cesta, "DWG"));

			
				if (Image)
				{
					ifail = AE_ask_all_dataset_named_refs2(specs[ii], "Image", &n_refs, &refs);
					ECHO(("DWG pocet referenci %d \n", n_refs));
				}

				strcat(cesta, ID_new);
				//	ECHO(("2Cesta %s \n",cesta);

				//	ECHO(("4Cesta %s \n",cesta);
				strcat(cesta, ".");
				//	ECHO(("5Cesta %s \n",cesta);
				strcat(cesta, typ);

				if (debug)
				{
					ECHO(("cesta %s \n", cesta));
					system("pause");
				}
				ifail = AE_export_named_ref(specs[ii], "Image", cesta);
				if (ifail != ITK_ok) { ECHO(("Nefunguje export \n cesta %s \n", cesta)); }
			}
		}

	}
}
int  Add_material(char* id_polozky,int poradi,char* id_rodice,char* pozice)
{
		char  cislo[5];
		tag_t rev_pol;
		char *obj_name;
		char* tmp;
		char *typPolozky;
		int id_helios=0;
		tag_t item_polotovar;
		ECHO(("poradi %d \n",poradi));
		sprintf(cislo,"%d",poradi);
		ITEM_find_item	(id_polozky,&item_polotovar);
		ITEM_ask_latest_rev(item_polotovar,&rev_pol);

		if (debug) printf ("line: %d \n",__LINE__);
		//strcpy(Nazvy[poradi][7], id_polozky);
		copy_string2varacha(id_polozky, poradi, 7);
		get_string(rev_pol,"object_name",&obj_name);
	//ECHO(("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		ECHO(("-----------Pridni material--------- \n"));
		ECHO(("testy id_polozky %s;\n id_rodice %s;\n obj_name %s  \n",id_polozky,id_rodice,obj_name));

			AOM_ask_value_int(rev_pol,"tpv4_ID_Helios",&id_helios);
			if (debug) printf ("line: %d  klic materialu %d \n",__LINE__, id_helios);
			//if(id_helios!=0)
				//sprintf(Nazvy[poradi][24], "%d", id_helios);
			get_string(rev_pol, "tpv4_SZ", &tmp);
				//strcpy(Nazvy[poradi][5], tmp);
			copy_string2varacha(tmp, poradi, 5);
			

	return poradi;
}
int ReadAttr(tag_t Rev, int poradi, char* ID_v,char* REV_v, char* mnozstvi, char *pozice)
{

	ECHO(("------------------read Attr ------------------\n"));
	int AttributeId = 0;
	char* tmp;
	char id[32];
	//double Hmotnost;
	char* TypItemu;
	char* polotovar;


	//tag_t Item;
	/*
	ItemIDVyssi	ItemID	ItemRevisionID	TYP	mnozstvi	SZ	SkupinaZboz	RegCisCele	RegCis	Nazev	Nazev2	MaterialJakost	Poznamka	Objem	Plocha	Hmotnost	Hustota	Polotovar	MJ	StareCV	SkladovyProces	KodPrvotniOpearace	SkladMnozstvi1	SkladMnozstvi2	KlicTPV	Autor	Pozice	ItemIDMaterial	Dokument1	Dokuemnt2	Datum
	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15	16	17	18	19	20	21	22	23	24	25	26	27	28	29	30
					tpv4_SZ	tpv4_SkupinaZbozi	tpv4_RegCisCele 	tpv4_RegCis	object_name	tpv4_nazev2	tpv4_MaterialJakost	tpv4_poznamka	tpv4_objem	tpv4_plocha	tpv4_hmotnost2	tpv4_hustota	tpv4_polotovar	tpv4_MJ	tpv4_StareCV	tpv4_SkladovyProces	tpv4_KodPrvotniOperace	tpv4_SkladMnozstvi1	tpv4_SkladMnozstvi2	tpv4_KlicTPV	owning_user		cislo vstupniho materialu	pdf	dxf	date
																						double	double	int						DATETIME

	*/
	//strcpy(Nazvy[poradi][0],pozice);
	//strcpy(Nazvy[poradi][0], ID_v);
	copy_string2varacha(ID_v, poradi, 0);
	//revV
	//strcpy(Nazvy[poradi][17], REV_v);
	copy_string2varacha(REV_v, poradi, 17);
	ECHO(("Parent %s %s\n", Nazvy[poradi][0], ID_v));

	tag_t Item;
	ITEM_ask_item_of_rev(Rev, &Item);


	get_string(Rev, "object_name", &tmp);

	//GetProperty (0,2,Item,&tmp);
	//strcpy(Nazvy[poradi][9], tmp);//nazev
	copy_string2varacha(tmp, poradi, 9);
	get_string(Rev, "object_type", &TypItemu);
	ECHO(("Type %s \n", TypItemu));
	get_string(Item, "item_id", &tmp);
	if (debug) ECHO(("line: %d \n", __LINE__));
	strcpy(id, tmp);
	if (debug) ECHO(("line: %d \n", __LINE__));
	//strcpy(Nazvy[poradi][1], id);//ItemID
	copy_string2varacha(id, poradi, 1);
	//strcat(id,"/");
	if (debug) ECHO(("line: %d \n", __LINE__));

	get_string(Rev, "item_revision_id", &tmp);
	//strcpy(Nazvy[poradi][2], tmp);//ItemRevisionID
	copy_string2varacha(tmp, poradi, 2);
	
	if (strcmp(TypItemu, "TPV4_nak_dilRevision") == 0 || strcmp(TypItemu, "TPV4_dilecRevision") == 0|| strcmp(TypItemu, "TPV4_VyrobekRevision") == 0)
		{
			strcpy(Nazvy[poradi][4], mnozstvi);//mnozstvi


			
			//objem
			double objem;
			AOM_ask_value_double(Rev, "tpv4_objem", &objem);
			sprintf(Nazvy[poradi][5], "%.4f", objem);
			//plocha
			double plocha;
			AOM_ask_value_double(Rev, "tpv4_plocha", &plocha);
			sprintf(Nazvy[poradi][6], "%.4f", plocha);
			//hmotnst
			/*char* hmotnost;
			get_string(Rev, "tpv4_hmotnost2", &hmotnost);
			string2number(poradi, 7, hmotnost);*/


			char* merJednotka="ks";
		/*	double hustota;
			AOM_ask_value_double(Rev, "tpv4_hustota", &hustota);
			sprintf(Nazvy[poradi][8], "%.4f", hustota);*/

			//sprintf(Nazvy[poradi][8], "%s", merJednotka);
			copy_string2varacha(merJednotka, poradi, 8);

			get_string(Rev, "tpv4_poznamka", &tmp);
			//strcpy(Nazvy[poradi][9], tmp);
			copy_string2varacha(tmp, poradi, 9);
		

			//strcpy(Nazvy[poradi][10], Owner(Rev));
			copy_string2varacha(Owner(Rev), poradi, 10);

			//strcpy(Nazvy[poradi][11], pozice);
		//	copy_string2varacha(pozice, poradi, 11);

			//strcpy(Nazvy[poradi][12], time_stamp());
			copy_string2varacha(" ", poradi, 12);

			//strcpy(Nazvy[poradi][13], status_exportu);
			copy_string2varacha(status_exportu, poradi, 13);

			double rozmer1=0;
			double rozmer2=0;
			double rozmer3=0;

		/*	AOM_ask_value_double(Rev, "tpv4_rozmer1", &rozmer1);
			AOM_ask_value_double(Rev, "tpv4_rozmer2", &rozmer2);
			AOM_ask_value_double(Rev, "tpv4_rozmer3", &rozmer3);*/
			sprintf(Nazvy[poradi][14], "%.0f", rozmer1);
			sprintf(Nazvy[poradi][15], "%.0f", rozmer2);
			sprintf(Nazvy[poradi][16], "%.0f", rozmer3);
	

			int is_released = 0;
			EPM_ask_if_released(Rev, &is_released);
			if (is_released == 1)
			{

				//strcpy(Nazvy[poradi][18], "TRUE");
				copy_string2varacha("TRUE", poradi, 20);

			}else 
				copy_string2varacha("FALSE", poradi, 20);//strcpy(Nazvy[poradi][18], "FALSE");

			/*char *value_hm = strtok(hmotnost, " ");
			char *unit_hm = strtok(NULL, "\0");
			ECHO(("unit %s \n", unit_hm);
			strcpy(Nazvy[poradi][16], replace_char(value_hm, ',', '.'));
			ECHO(("hmotnost %s \n", Nazvy[poradi][16]);*/

			/*get_string(Rev,"tpv4_atribut_1",&tmp);
				strcpy(Nazvy[poradi][11],tmp);

			get_string(Rev,"tpv4_atribut_2",&tmp);
				strcpy(Nazvy[poradi][12],tmp);

			get_string(Rev,"tpv4_atribut_3",&tmp);
				strcpy(Nazvy[poradi][13],tmp);*/
			if (debug) printf ("line: %d \n",__LINE__);
		//	ECHO(("--------Type %s %d-------\n",TypItemu,strcmp(TypItemu,"TPV4_nakupRevision"));
		}
		if (strcmp(TypItemu, "TPV4_VyrobekRevision") == 0)
		{
			if (debug) ECHO(("line: %d \n", __LINE__));
			copy_string2varacha("V", poradi, 3);//strcpy(Nazvy[poradi][3], "V");
			if (debug) ECHO(("line: %d \n", __LINE__));
			return ++poradi;
		}
		else if(strcmp(TypItemu,"TPV4_dilecRevision")==0)
		{
				ECHO(("----dil ----\n"));
				if (debug) ECHO(("line: %d \n", __LINE__));
				copy_string2varacha("D", poradi, 3);	//	strcpy(Nazvy[poradi][3], "D");
				//strcpy(Nazvy[poradi][19],"Dil");
			//int id_polozky=0;
			//char* id_polozky_str;
				char* klic_tpv;
			tag_t obj_repre_by;

			

			if (debug) ECHO(("line: %d \n",__LINE__));
			int num_repre_by=CountInRelation(Rev,"TC_Is_Represented_By",&obj_repre_by);
				if(num_repre_by!=0 )
				{
					//doplnit cteni id hutniho materialu
					//get_string(obj_repre_by,"tpv4_klic_tpv",&klic_tpv);
				
				//strcpy(Nazvy[poradi][7],klic_tpv);
			
				}
				//else strcpy(Nazvy[poradi][7],"");
				//cv_zakaznik
			
				//zakaznik
		/*		char* zmena;
				get_string(Rev,"tpv4_cislo_zmeny",&zmena);
				if(strlen(zmena)>1)
				{
					strcpy(Nazvy[poradi][8],zmena);
					if (debug) printf ("zmena line: %d \n",__LINE__);
				}*/
			
				get_string(Rev,"tpv4_hut_mat",&polotovar);
				if (strlen(polotovar) > 7)
				{
					
					strtok(polotovar, "|");
					char*id_mat = strtok(NULL, "|");
				

					Add_material(id_mat, poradi, ID_v, pozice);

				}
					
					
				
				/*if (strcmp(polotovar,"-")==0)
					strcpy(Nazvy[poradi][27],"");
				else
					strcpy(Nazvy[poradi][27], polotovar);
				char* poznamka;*/
				//get_string(Rev,"tpv4_poznamka",&poznamka);
				//strcpy(Nazvy[poradi][10],poznamka);//poznamka
		
				if (debug) ECHO(("line: %d \n",__LINE__));

				
				//sprintf(Nazvy[poradi][16],"%.4f",hmotnost);

				//-------------------------rozmery------------------------//
				 
				

//------------------------------------------------------------//

				

		} 
		
		else  if (strcmp(TypItemu, "TPV4_nak_dilRevision") == 0)
		{
			if (debug) ECHO(("line: %d \n", __LINE__));
			//07.03.2023
			/*get_string(Rev, "tpv4_klic_tpv", &tmp);
			strcpy(Nazvy[poradi][27], tmp);*/

			if (debug) ECHO(("line: %d \n", __LINE__));
			copy_string2varacha("N", poradi, 3);//strcpy(Nazvy[poradi][3], "N");
			// if (strlen(polotovar)>1)
			   //{
			   // if (debug) ECHO(("line: %d \n", __LINE__);
			   //	if(debug) printf ("read polotovar \n");
			   //	//poradi++;
			   //	//strcpy(Nazvy[poradi][9],polotovar);
			   //	//Add_material(polotovar,poradi,id,"1");
			   //	//strcpy(Nazvy[poradi][19],"D");
			   //	
			   //}
		   /* else if (strcmp(TypItemu,"TPV4_dilecRevision")==0)
			{
				if (debug) printf ("line: %d \n",__LINE__);
				 strcpy(Nazvy[poradi][19],"S");
			}*/
			
		}
		else {
		
		}
		if (debug) printf ("line: %d \n",__LINE__);
		poradi++;
		prazdny:;
		ECHO(("konec\n ___________\n"));
	return poradi;
}

int ListBomLine(tag_t BomLine, int Level, tag_t pamet[], int poradi,tag_t BomWindow,int Strom [6][4])
{
	//double hm=0;
	int pole[50][10];
	pole[25][5]=255;
	int plus=0;
	char* I_ID,
		*REV_ID_v,
		*I_ID_v;
	ECHO(("--------- ListBomLine------------\n"));
	//int Strom[6][3];

	ECHO(("start Level = %d poradi %d \n", Level, poradi));
		
	pamet[Level]=BomLine;
	//printf (" tak bom line %d \n",BomLine);
	//char hm [20];
	int AttributeId;
	tag_t Rev = NULLTAG;
	char* SEAR = NULLTAG;
	char* kp_assembly_report="";

		BOM_line_look_up_attribute("bl_revision", &AttributeId);	

		//AOM_ask_value_tag(pamet[Level], "bl_revision", &Rev);
		BOM_line_ask_attribute_tag(pamet[Level], AttributeId, &Rev);
		if (debug)	ECHO(("L:%d rev bom line  %d \n",__LINE__, Rev));
		BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &I_ID_v);
		BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &REV_ID_v);
	
		char pomocID_v[32]="";
		strcat(pomocID_v,I_ID_v);
		I_ID_v=pomocID_v;
		ECHO((">>>%d>>>>Parent %s\n",__LINE__,I_ID_v));

		if(debug)	ECHO(("debug %d \n",Level));
					//ECHO(("hmotnost dilu %f \n",Hmotnost);
					//	char *tmp;
	//	if (strcmp(kp_assembly_report, "0") == 0)
	//		goto next;

	if( Level==0)
	{
		downloadDataset(Rev,I_ID_v,0,"pdf"," ",false);
		downloadDataset(Rev, I_ID_v, 0, "dxf", " ", true);
		//downloadDataset(Rev, I_ID_v, 0, "dwg", " ", true);
		poradi=ReadAttr(Rev,poradi,"-","-","1","0");
		if (debug) ECHO(("line: %d \n", __LINE__));
		//readAttr(BomLine, Rev, poradi,"");
		//strcpy(Nazvy[poradi][7],tmp);
		
		

			/*		char tmpName[128];
			strcpy(tmpName,I_ID_v);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi][0]);
			ECHO(("tmpName %s \n",tmpName);*/
	}
	
	char* cv_vrcholu = "";
	char* TypItemu;

	get_string(Rev, "object_type", &TypItemu);
	//07.03.2023
	/*if (strcmp(TypItemu, "TPV4_dilecRevision") == 0)
		get_string(Rev, "tpv4_cv", &cv_vrcholu);
	if (strlen(cv_vrcholu) > 1) get_string(Rev, "tpv4_cv", &I_ID_v);*/

    // Potomci
	//ECHO((">>>>>388>>Parent %s\n",I_ID_v);
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);

	if(debug) ECHO(("childs %d \n",ChildsCount));

	char* tmpQuant;
	char Quant[24];
	char* findNo;
	int poradi_nalezu=0;
	tag_t RevThisLine=NULLTAG,
		RevNew=NULLTAG;
	tag_t* pouzite_rev= (tag_t*)malloc(ChildsCount * sizeof(tag_t));
	int unikatni_rev = 0;
	for(int t=0;t<ChildsCount;t++)
	{
		bool jeden_vyskyt = true;
		//BOM_line_look_up_attribute("bl_revision", &AttributeId);
		AOM_ask_value_tag(Childs[t], "bl_revision", &RevThisLine);
		ECHO(("L:%d rev bom line  %d \n", __LINE__, RevThisLine));
		if (debug)ECHO(("unikatni_rev=%d \n", unikatni_rev));
		
		//potlaceni pozice v kusovniku
		//08.03.2023
		/*BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &kp_assembly_report);*/
		if (debug) ECHO(("line: %d \n", __LINE__));
		if (strcmp(kp_assembly_report, "0") == 0)
			goto next;

		//prvni vypocet mnozstvi
		if (debug) ECHO(("line: %d \n", __LINE__));
		BOM_line_look_up_attribute("bl_quantity", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &tmpQuant);
		if (debug)ECHO(("%d>>>>tmpQuant %s \n", poradi, tmpQuant));
		
		if (strcmp(tmpQuant, "") == 0)
			strcpy(Quant, "1");
		else strcpy(Quant, tmpQuant);

		if (debug)ECHO(("%d>>>>Quant %s  I_ID_v %s \n", poradi, Quant, I_ID_v));
		strcpy(Nazvy[poradi][4], Quant);
		///////////////

		if (unikatni_rev == 0)
		{
			if (debug)ECHO(("L: %d \n", __LINE__));

			if (debug)system("pause");
			pouzite_rev[unikatni_rev++] = RevThisLine;
			
		}
		else
		{
			for (int h = 0; h < unikatni_rev; h++)
			{
				if (debug)ECHO(("h=%d - %d == %d \n",h, pouzite_rev[h], RevThisLine));
				if (pouzite_rev[h] == RevThisLine)
				{
					if (debug)ECHO(("L: %d \n", __LINE__));
					
					goto next;

				}
			}
			pouzite_rev[unikatni_rev++] = RevThisLine;
			
		}
		for(int j= ChildsCount;j>t;j--)
		{

		AOM_ask_value_tag(Childs[j], "bl_revision", &RevNew);
		if (debug)ECHO(("j=%d - %d == %d \n", j, RevNew, RevThisLine));
		
		//scitani mnoystvi revize v jedne urovni jdouci po sobe
		/*
		if(RevThisLine==RevNew)
			{
				if (debug)ECHO(("Rev's se rovnaji\n");
				if (debug)ECHO(("poradi %d \n", poradi);
				char* rev_old_name,
					*rev_new_name;
				ITEM_ask_rev_name2(RevThisLine, &rev_old_name);
				ITEM_ask_rev_name2(RevThisLine, &rev_new_name);
				if (debug)ECHO(("t-old=%s == j-new=%s \n", rev_old_name, rev_new_name);
				if(debug) system("pause");
			//	char* tmpQuant;
				BOM_line_look_up_attribute("bl_quantity", &AttributeId);
				BOM_line_ask_attribute_string(Childs[j], AttributeId, &tmpQuant);
				if (strcmp(tmpQuant,"")==0)
					strcpy(Quant,"1");
				else strcpy(Quant,tmpQuant);

				
				//ECHO(("dif %d = t %d - j %d \n", dif, t, j);
				if (debug)ECHO((" scitam mnozstvi %s + %s \n", Quant, Nazvy[poradi][5]);
				int NewQuant =atoi(Quant)+atoi(Nazvy[poradi][5]);//mnozstvi
				if (debug)ECHO((" ukladani do %d  mnozstvi %d \n", (poradi ), NewQuant);
				sprintf(Nazvy[poradi][5],"%d", NewQuant);
				//sprintf(Nazvy[poradi - dif][10], "%d", NewQuant);
				if (debug)ECHO(("___________next________\n");
				if (debug)system("pause");
				//goto next;
				sprintf(Quant, "%d", NewQuant);
				jeden_vyskyt = false;
			}*/
		}


			//poradi=poradi+1;

		//AOM_ask_value_tag(Childs[t], "bl_revision", &Rev);

		//pridat podminku aby byl více univerzální
		BOM_line_look_up_attribute("bl_sequence_no", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &findNo);
		poradi_nalezu = poradi_nalezu + 10;
		sprintf(findNo, "%d", poradi_nalezu);
		
		
		if (debug)system("pause");
		poradi=ReadAttr(RevThisLine,poradi,I_ID_v, REV_ID_v,Quant,findNo);
		if (debug) printf ("line: %d \n",__LINE__);
		//strcpy(Nazvy[poradi][7],tmp);
			char tmpName[128];
			strcpy(tmpName,Nazvy[poradi-1][1]);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi-1][2]);
		//	ECHO(("tmpName %s \n",tmpName);
		
		downloadDataset(RevThisLine,Nazvy[poradi-1][1],poradi-1,"pdf"," ",false);
		downloadDataset(RevThisLine, Nazvy[poradi - 1][1], poradi - 1, "dxf", " ", true);
		//downloadDataset(Rev, Nazvy[poradi - 1][1], poradi - 1, "dwg", " ", true);
		if (debug) printf ("line: %d \n",__LINE__);
	//	ECHO(("Poradi %d Vrchol %s Dil %s Rev %s \n",poradi,I_ID_v,I_ID,REV_ID);
		next:;
	}
	if (pouzite_rev)free(pouzite_rev);
	//ECHO(("Count %d \n", ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)
	{	
	
		poradi=ListBomLine(Childs[k], Level + 1, pamet, poradi, BomWindow,Strom);
		
	}
	ECHO((" pred koncem poradi %d\n",poradi));
	
	return poradi;
}

char* create_marks_csv(char *filename,int m,int n){
 
ECHO(("\n Creating %s.csv file \n",filename));
 
FILE *fp;
 
int i,j;
 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\Export\\csv\\");
 strcat(file,filename);
//ECHO(("test1 \n");
 strcat(file,".csv");
 //ECHO(("file %s \n",file);



fp=fopen(file,"w");
 ECHO(("test po zaèátku zápisu %d \n",fp));
//fprintf(fp,attr);
 
for(i=0;i<m;i++)
{
	printf ("fprint %d \n",i);
	if(i==0)
		fprintf(fp, "ItemIDVyssi#ItemID#ItemRevisionID#TYP#Mnozstvi#Objem#Plocha#Hmotnost#MJ#Poznamka#Autor#Pozice#DatPorizeni#Status#Atribut1#Atribut2#Atribut3#ItemRevisionIDVyssi#Dokument1#Dokument2#Schvaleno\n");
				 // "ItemIDVyssi#ItemID#ItemRevisionID#TYP#mnozstvi#SZ#SkupinaZbozi#RegCisCele#RegCis#Nazev#Nazev2#MaterialJakost#Poznamka#Objem#Plocha#Hmotnost#MJ#Polotovar#MJ#StareCV#SkladovyProces#KodPrvotniOpearace#SkladMnozstvi1#SkladMnozstvi2#KlicTPV#Autor#Pozice#ItemIDMaterial#Dokument1#Dokument2#DatPorizeni#Status#Atribut1#Atribut2#Atribut3#ItemRevisionIDVyssi#Schvaleno\n"
	//"ItemID#ItemRevisionID#ID#SZ#SkupinaZboz#RegCisCele#RegCis#Nazev#Nazev2#MaterialJakost#RozmerNorma#Dodavatel#KatCisloDod#Poznamka#Atribut1#Atribut2#Atribut3#Objem#Plocha#Hmotnost#MJ#PovOchrana#Polotovar#MJ#StareCV#SkladovyProces#KodPrvotniOpearace#SkladMnozstvi1#SkladMnozstvi2#KlicTPV#Autor#Pozice#Mnozstvi#ItemIDVyssi#ItemIDMaterial#Dokument1#Dokuemnt2#Datum"			
	else
	{
				
		fprintf(fp,"\n");
	}
			for(j=0;j<=n;j++)
			{
				if(j == 0)
					fprintf(fp,"%s",Nazvy[i][j]);
				else
					if(strlen(Nazvy[i][j])==0)
						fprintf(fp, "# ", Nazvy[i][j]);
					else
						fprintf(fp,"#%s",Nazvy[i][j]);	
				ECHO(("# %s",Nazvy[i][j]));
			}
		//	fprintf(fp,"#0000000");	
}
    //fprintf(fp,"\n%d",i+1);
fclose(fp);
 
ECHO(("\n file created - %s \n",file));
 return file;
}
void CallBridge(char* file)
{	char help [50];
	strcpy(help,file);
	ECHO(("file %s \n",help));
	//char ImportTPV[256]="C:\\TC4TPV\\TCCom\\TCCom.jar \"";
	char ImportTPV[256]="call C:\\SPLM\\Apps\\Export\\TC2ERP.bat \"C:\\SPLM\\Apps\\Export\\csv\\";
	strcat(ImportTPV,help);
	strcat(ImportTPV,".csv");
	strcat(ImportTPV,"\"");
	//ECHO(("%s \n",ImportTPV);
	system(ImportTPV);

//	system("call C:\\TC4TPV\\TCCom\\run.bat");
	 ECHO(("%s\n",ImportTPV));
	//system("call TC2TPV.bat");
}
void Cisteni()
{
	for (int i=0;i<100;i++)
		for(int j=0;j<36;j++)
			strcpy(Nazvy[i][j],"");
	strcpy(prvotni_cesta, "C:\\Temp\\ProductFiles\\");//"\\\\srv-file\\ProductFiles\\"
	prvni_pruchod = true;
	strcpy(status_exportu, "1");
	if (debug)ECHO(("cisteni !!"));
}


int TPV_TC2Mapos_TC14(EPM_action_message_t msg)
{
	Cisteni();
	//ReadProperty();
     int
        TargetsCount = 0,	
		BomsCount = 0;
		
    tag_t
        *Targets = NULL,
		*Boms = NULLTAG,
		job=NULLTAG,
		RootTask=NULLTAG;
    char  
        file_name[WSO_name_size_c+2] = "",
        *class_name = NULL,
		*Id=NULL,
		*RevId=NULL,
		//*Process_name,
		//*job_name,		
		
		*Pname="ren ",
        description[WSO_desc_size_c+1]  = "";
		tag_t RevisionClassTag = NULLTAG;

		char*Argument = nullptr;
		char*Flag = nullptr;
		char*Value = nullptr;

		debug=false;
		export2Helios = true;
		int ArgumentCount = TC_number_of_arguments(msg.arguments);

		while (ArgumentCount-- > 0)
		{
			Argument = TC_next_argument(msg.arguments);
			ITK_ask_argument_named_value(Argument, &Flag, &Value);
			ECHO(("Value %s Flag %s \n", Value, Flag));
			if (strcmp("Debug", Flag) == 0)
			{
				ECHO((" Debug Mode \n"));
				debug = true;
				system("pause");
				// …
			}
			if (strcmp("Status", Flag) == 0)
			{
				ECHO(("Statsu is %s \n", Value));
				strcpy(status_exportu, Value);
			}
			if (strcmp("NoExport", Flag) == 0)
			{
				ECHO((" Neexportovat do Heliosi \n"));
				export2Helios = false;
			}
	}
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
	
    EPM_decision_t
        //decision=EPM_undecided ;
		decision=EPM_nogo ;
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;
	//POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);
	//AOM_UIF_ask_value(job,"object_name",&job_name);

ECHO(("test0 \n"));		
		//FILE *log;
	char logpath[30];
	//strcpy(logpath,"C:\\Temp\\export");
	//strcat(logpath,job_name);
	strcat(logpath,".log");

		
    EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
	char* file;
		printf ("target count %d\n", TargetsCount);
	//get_string(Targets[0],"item_id",&file);
		AOM_ask_value_string(Targets[0], "item_id", &file);
	if (debug)ECHO(("L: %d file_name %s !\n", __LINE__, file));
	//get_string(Targets[0],"item_revision_id",&RevId);
	AOM_ask_value_string(Targets[0], "item_revision_id", &RevId);
	if (debug)ECHO(("L: %d item_revision_id %s ! \n", __LINE__, RevId));
		
	//fprintf(log,"Ziskany id vrcholu \n");	
	//for (int k =0;k<strlen(file);k++)
	//{
	//	if(file[k]==' ')job_name[k]='_';

	//}
	ECHO(("count %d \n",TargetsCount));
for( int i = 0; i < TargetsCount; i ++ )
{
	tag_t TargetClassTag = NULLTAG;
	POM_class_of_instance(Targets[i], &TargetClassTag);
	ECHO(("test1 \n"));	
	logical IsRevision = false;
	POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);
	ECHO(("test2 \n"));	
	if(IsRevision == false) continue;
		char *Type;
	      
			// BOM window
			
			tag_t pamet[100];
            tag_t BomWindow = NULLTAG;
			tag_t rule = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;
			int poradi=0,
			 Strom[12000][4];

			
			
				
			//fprintf(log,"Otevreni kusovniku \n");
			ECHO(("Otevreni kusovniku \n"));	
	for(int l=0;l<6;l++){
		for (int p=0;p<3;p++){
			Strom [l][p]=0;
		}
	}

		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
		
		printf ("%s\n",Type);
		int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
			
		//fprintf(log,"pocet kusovniku %d\n",BomsCount);	
		if (BomsCount==0)
		{
			if (debug) printf ("line: %d \n",__LINE__);
			poradi =ReadAttr(Targets[i], i," ", " ", "1","10");
			ECHO(("Nazvy 1 %s Rev %d poradi %d\n",Nazvy[i][1],Targets[i],poradi));
			//downloadDataset(Targets[i],Nazvy[i][2],poradi-1,"pdf"," ",false);
			//downloadDataset(Targets[i], Nazvy[i][2], poradi - 1, "dxf", " ", true);
			//downloadDataset(Targets[i], Nazvy[i][2], poradi - 1, "dwg", " ", true);
			
		//	fprintf(log,"stazeny datasety pouze pro tento dilec\n");
		}
        for(int j = 0; j < BomsCount; j++)
        {

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			CFM_find("Latest Working", &rule);
			BOM_set_window_config_rule(BomWindow, rule);
			ECHO(("L: %d rule %d \n", __LINE__, rule));
			//BOM_set_window_pack_all(BomWindow, TRUE);
			poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom);
			
			//BOM_refresh_window(BOM
        }
		
		//fprintf(log,"Zpracovano kusovniku \n");
		if (export2Helios)
		{
			for (int k = 0;k < strlen(file);k++)
				if (file[k] == ' ')file[k] = '_';
			strcpy(file_name, file);
			strcat(file_name, "_");
			strcat(file_name, RevId);
			if (debug)ECHO(("L: %d file_name %s \n", __LINE__, file_name));
			create_marks_csv(file_name, poradi, 20);
			//fprintf(log,"Spusteni importu do TPV \n");
			//CallBridge(file_name);
			Sleep(5000);
			CallBridge(file_name);
		}
		//fprintf(log,"Dokonceno \n \n");
		//Delprilohy (poradi);
}

//	fclose(log);
	//Report_import( msg,RootTask);
    return ITK_ok;
}
