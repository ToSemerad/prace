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
#include <ae\ae.h>
#include <tccore\grm.h>
#include <unidefs.h>
#include <errno.h>
#include <time.h>

#define HANDLER_ERROR 2010
#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_TC2TPV_TC10_register_callbacks();
extern "C" DLLAPI int TPV_TC2TPV_TC10_init_module(int *decision, va_list args);
int TPV_TC2TPV(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);

//char *Nazvy[100][20];
char Nazvy[100000][20][150];

int Type_num=0;
int Attr_num=0 ;
int Remove_line=0;
char Attr [10][20][128];
char Attr_type [10][20][128];
char EntryExistenece[10][128];
char AttryExistenece[10][128];
char attr_set[10][128];
char value_set[10][128];
char from_copy[20],
	to_copy[20];


extern "C" DLLAPI int TPV_TC2TPV_TC10_register_callbacks()
{
    printf("Registruji TPV_TC2TPV_TC10.dll\n");
    CUSTOM_register_exit("TPV_TC2TPV_TC10", "USER_init_module", TPV_TC2TPV_TC10_init_module);

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
    printf("\n n_errors: %d \n", n_errors);
    for (ii = n_errors - 1; ii >= 0  ; ii--)
    {
        if (severities[ii] == EMH_severity_information) 
            printf("    Information - error_code[%d]: %d - msg[%d]: %s\n", 
                ii, error_code[ii],ii, msg[ii]);
        if (severities[ii] == EMH_severity_warning) 
            printf("    Warning - error_code[%d]: %d - msg[%d]: %s\n", 
                ii, error_code[ii],ii, msg[ii]);                
        if (severities[ii] == EMH_severity_error) 
            printf("    Error - error_code[%d]: %d - msg[%d]: %s\n", 
            ii, error_code[ii],ii, msg[ii]);
    }
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

////////////////////////////////////////

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

void Report_import(EPM_action_message_t msg, tag_t condition_task)
{
	char info [2048];


	strcpy(info," ");
char* log="C:\\SPLM\\Apps\\Export\\log_imp.txt";
   FILE* stream = fopen(log, "r");
		printf("Open %s\n",log);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		strcat(info,line);
		
	}
	
	//iso8859_1_to_utf8(info, 2048);
	printf("info: %s \n ",info);
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
extern "C" DLLAPI int TPV_TC2TPV_TC10_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_TC2TPV", "", TPV_TC2TPV);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_TC2TPV");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}
void Delprilohy (int pocetradku){
	char delpriloha [120];
	//strcpy(delpriloha,"del ");
	for (int i=0; i<pocetradku;i++)
	{	strcpy(delpriloha,"del ");
		strcat(delpriloha,Nazvy[i][5]);
		system(delpriloha);
	}

}

int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6][4]){
	int jetam=0;
	for(int j=0;j<=6;j++)
	{
	//	printf("strom %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
		
		if((level==pole[j][0])&&(bomLine==pole[j][1])&&(Rev==pole[j][2]))
		{
			printf("shoda %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
			jetam=1;
			break;
		}
	
	}

	return jetam;
}

int SouborExistuje(char *nazev)
{printf("test existence souboru %s  \n",nazev);
    FILE *soubor;
    if ((soubor = fopen(nazev, "rb")) != NULL) {
        fclose(soubor);
		printf("nalezen \n");
        return 0;       /* soubor existuje,
                           jinak by se jej nepodarilo otevrit */
    }
 
    if (errno == ENOENT) {
		printf("nenalezen \n");
        return 1;   /* soubor neexistuje */
    }
 printf("nic se nedìje \n");
    return 2;      /* soubor mozna existuje, ale nepodarilo se
                           jej otevrit (treba uz je otevreno prilis
                           mnoho souboru nebo nemate prava atp.) */
}


int IsTypeInRelation(tag_t Parent, char * Relation,char * Type )
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type,
		type_tag;
	char* type_name;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("find relation %d \n", relation_type);
	err = GRM_list_secondary_objects_only(Parent, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("Count %d \n",Count);
	for (int i=0;i<Count;i++)
	{
			printf(" line %d \n",__LINE__);
		err = TCTYPE_ask_object_type (secondary_list[i], &type_tag);
        if (err != ITK_ok) { printf("Problem err %d \n", err); }
			printf(" line %d - tag_type %d \n",__LINE__,type_tag);
        err = TCTYPE_ask_name2(type_tag,&type_name);
        if (err != ITK_ok) {  printf("Problem err %d \n", err); }
             //printf("Typ polozky %s \n",type_name);
		 printf("Porovnani %s = %s \n", type_name, Type);
		if (strcmp(type_name, Type) == 0)  
		{
			printf("shodne konec \n");
			return 1;
		}
	}

	return 0;
}

void GetProperty (int polozka_num,int num,tag_t object,char** value)
{
	if(strcmp(Attr_type[polozka_num][num],"<string")==0)
	{
		//value=OpravCz(value);
		int IERROR=AOM_ask_value_string(object,Attr[polozka_num][num],&*value);
		printf ("\n Err %d string attr %s \n value %s \n",IERROR,Attr[polozka_num][num],*value);
	}else if(strcmp(Attr_type[polozka_num][num],"<item_string")==0)
	{
		tag_t Item;
		ITEM_ask_item_of_rev(object,&Item);
		//value=OpravCz(value);
		int IERROR=AOM_ask_value_string(Item,Attr[polozka_num][num],&*value);
		printf ("\n Err %d string attr %s \n value %s \n",IERROR,Attr[polozka_num][num],*value);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<int")==0)
	{
		int tmp_int=0;
		IFERR_REPORT(AOM_get_value_int(object,Attr[polozka_num][num],&tmp_int));
		sprintf(*value,"%s",tmp_int);
		printf ("int .....%d = %s \n",tmp_int,value);
		//printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		//if(strcpy(value," ")!=0)
			
	}
	else if(strcmp(Attr_type[polozka_num][num],"<double")==0)
	{
		double tmp_double=0;
		IFERR_REPORT(AOM_get_value_double(object,Attr[polozka_num][num],&tmp_double));
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
    
    IFERR_REPORT(AOM_ask_value_string(bom_line, "bl_item_item_id", &item_id ));
    IFERR_REPORT(AOM_ask_value_string(bom_line, "bl_rev_item_revision_id", &rev_id));
    IFERR_REPORT(ITEM_find_rev(item_id, rev_id, &item_revision));
    
    SAFE_MEM_FREE((item_id));
    SAFE_MEM_FREE((rev_id));
    return item_revision;
}

static bool KontrolaNaradi (tag_t Rev)
{
	char* cisloVykresu,
		cisloNaradi[158][5]={"Eba","Eca","Efc","Efd","Efh","Efk","Eft","Efu","Efz","Eit","Eja","Ejb","Ejd","Ejl","Ejn","Ejo","Ejt","Eka","Ela","Ema","Emc","Emd","Emfc","Emfe","Emff","Emfh","Emfz","Emg","Emga","Emgb","Emgg","Emh","Emhp","Emhv","Emhv","Emi","Emj","Emk","Eml","Emm","Emma","Emn","Emnh","Emp","Emr","Ems","Emu","Emup","Emup","Emuz","Emuz","Emy","Emyo","Emz","Emz","Emzt","Emzt","Ena","Enh","Enk","Enn","Enp","Ent","Enu","Env","Enz","Eoa","Eobv","Eobn","Era","Erv","Esa","Esh","Esj","Ess","Est","Esz","Eoe","Eok","Eop","Eozk","Etn","Etp","Etr","Ets","Etu","Etz","Euh","Eum","Eun","Euo","Euoc","Eup","Eur","Eus","Eut","Euu","Euv","Euy","Euz","Eva","Evk","Evv","Evo","Evs","Eya","Eyc","Eyk","Eza","Eze","Ezz","Ezza","Ezzp","Exx","Ele","Epa","Lrb","Lrca","Lri","Lrj","Lrjd","Lrjs","Lrju","Lrl","Lrlv","Lrm","Lro","Lrp","Lrs","Lrt","Lru","Lrz","Oba","Oca","Ofa","Oha","Ohs","Oin","Oiv","Oja","Ojb","Ojh","Ojm","Oju","Oka","Okc","Ola","Oma","Ona","Ooa","Osa","Oua","Ouc","Oza","Ozza","Sjl","Sk","Vt"};
	IFERR_REPORT(AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&cisloVykresu));
	for (int i =0 ;i<158;i++)
	{
		int delka=strlen(cisloNaradi[i]);
		//printf("delka %d cislo vykresu %s \n",delka,cisloVykresu);
		if (strncmp(cisloVykresu,cisloNaradi[i],delka)==0)
		{
			printf ("shoda %s %s \n",cisloVykresu,cisloNaradi[i]);
			return true;
		}
	}
	SAFE_MEM_FREE(cisloVykresu);
	return false;

}


int downloadDataset(tag_t rev,char* I_ID, int poradi, char* typ, char* ID_v)
{
	 int ifail = ITK_ok;
	  int ii = 0;
    tag_t root_task = NULLTAG;
    int n_attachs = 0;
    
   
	tag_t item=NULLTAG;
    tag_t relation_type_tag = NULLTAG;
    int n_specs = 0;
    tag_t* specs = NULL;
    char type_name[TCTYPE_name_size_c+1] = "";
    tag_t type_tag = NULLTAG;
    int n_refs = 0;
    tag_t* refs = NULL;
	char ID_new[30],
		*ID_Rev;
	
	//char cesta[50]="\\\\10.1.1.8\\vymena_dat_free\\ComTC_TPV\\pdf_TC\\";
	char cesta[100]="\\\\files.pos.local\\prevodni_mustek_TPV_a_TC\\SRVTEST\\";
	IFERR_REPORT(ITEM_ask_item_of_rev(rev,&item));
	IFERR_REPORT(ITEM_ask_id2(item,&I_ID));
	strcpy(ID_new,I_ID);
	printf("I_ID %s \n",I_ID);
	for (int k =0;k<strlen(ID_new);k++)
		if(ID_new[k]==' ')
			ID_new[k]='_';

	int err=AOM_ask_value_string(rev,"item_revision_id",&ID_Rev);
	

	IFERR_REPORT (GRM_find_relation_type("IMAN_Rendering", &relation_type_tag));
	IFERR_REPORT(GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs));
    
    printf("pocet datasetu %d\n",n_specs);
    if (ifail != ITK_ok) { /* your error logic here */ }
	if (n_specs>0)
	{
		for (ii = 0; ii < n_specs; ii++)
		{
			IFERR_REPORT ( TCTYPE_ask_object_type (specs[ii], &type_tag));
       
        
        IFERR_REPORT ( TCTYPE_ask_name(type_tag, type_name));
        
		printf("Typ polozky %s \n",type_name);
      
			
		if(strcmp(typ,"pdf")==0)
			{
				printf("-----typ ok\n");
				  if (strcmp(type_name, "PDF") == 0)
				  {
					  goto PDF_rendering;
				  }
			}
		}

	}
	
		IFERR_REPORT ( GRM_find_relation_type("IMAN_specification", &relation_type_tag));
		
		IFERR_REPORT ( GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs));
		
		printf("pocet datasetu %d\n",n_specs);
	

	//ifail = GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs);
 //   if (ifail != ITK_ok) { /* your error logic here */ }
 //   printf("pocet datasetu %d\n",n_specs);
PDF_rendering:;

    for (ii = 0; ii < n_specs; ii++)
    {
        IFERR_REPORT ( TCTYPE_ask_object_type (specs[ii], &type_tag));     
        
        IFERR_REPORT ( TCTYPE_ask_name(type_tag, type_name));
       
		printf("Typ polozky %s \n",type_name);
      
			
	if(strcmp(typ,"pdf")==0)
		{
			printf("-----typ ok\n");
			  if (strcmp(type_name, "PDF") == 0)
			  {
				 
			//	  printf("-----typ_name ok\n");
				IFERR_REPORT (AE_ask_all_dataset_named_refs(specs[ii], "PDF_Reference", &n_refs, &refs));
			//	printf("Reference %d \n",n_refs);


        //  printf("1Cesta %s \n",cesta);
			strcat(cesta,ID_new);
		//	printf("2Cesta %s \n",cesta);
			strcat(cesta,"_");
		//	printf("3Cesta %s delka %d\ %s n",cesta,strlen(cesta),ID_Rev);
			strcat(cesta,ID_Rev);
		//	printf("4Cesta %s \n",cesta);
			strcat(cesta,".");
		//	printf("5Cesta %s \n",cesta);
			strcat(cesta,typ);
		//	printf("6Cesta %s \n",cesta);
			strcpy(Nazvy[poradi][5],cesta);
		//	printf("7cesta %s poradi %d\n",Nazvy[poradi][5],poradi);
			if(SouborExistuje(cesta)==1)
			{
				ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
				if (ifail != ITK_ok) 
				{ 
					ECHO(("Nefunguje export \n"));
						SAFE_MEM_FREE(ID_Rev);
						SAFE_MEM_FREE(refs);
						SAFE_MEM_FREE(specs);
					return 0;
				}
				
				
			}
		}
	}

}
	SAFE_MEM_FREE(ID_Rev);
	SAFE_MEM_FREE(refs);
	SAFE_MEM_FREE(specs);
	
	return ITK_ok;
}
int  Add_material(char* id_polozky,int *poradi,char* id_rodice,char* obj_name,char* pozice)
{
		char  cislo[5];
		printf("poradi %d \n",*poradi);
		sprintf(cislo,"%d",*poradi);

	//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		printf("-----------Pridni material--------- \n");
		printf("testy id_polozky %s;\n id_rodice %s;\n obj_name %s  \n",id_polozky,id_rodice,obj_name);
		//ITEM_ask_item_of_rev(Rev,&Item);
	
		
		//AOM_ask_value_string(Item,"object_name",&obj_name);
		//GetProperty (0,2,Item,&tmp);
		strcpy(Nazvy[*poradi][2],obj_name);//nazev
		printf("Type %s \n",Nazvy[*poradi][2]);
		
		//BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		//AOM_ask_value_string(Rev,"item_revision_id", &tmp);
		//GetProperty (0,3,Rev,&tmp);
		strcpy(Nazvy[*poradi][3]," ");//revize
		printf("item_rev %s \n",Nazvy[*poradi][3]);
				//AOM_ask_value_string(Item,"tpv4_nomenklatura",&tmp);
			strcpy(Nazvy[*poradi][0],id_rodice);
			printf("idv %s id_rodice %s \n",Nazvy[*poradi][0],id_rodice);
			strcpy(Nazvy[*poradi][1],id_polozky);//vyssi
			strcpy(Nazvy[*poradi][7],"N");//typ
			//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
			strcpy(Nazvy[*poradi][6]," ");//material
			strcpy(Nazvy[*poradi][8]," ");//klic
			strcpy(Nazvy[*poradi][9]," ");//zmena
			strcpy(Nazvy[*poradi][10],pozice);//pozice
			strcpy(Nazvy[*poradi][11]," ");//polotovar
			strcpy(Nazvy[*poradi][12]," ");//tpv4_hmotnost
			strcpy(Nazvy[*poradi][13]," ");//tpv4_poznamka_tpv
			

	return *poradi;
}
	int ReadAttr(tag_t Rev, int poradi,char* ID_v, char* mnozstvi,char *pozice)
	{

		printf("------------------read Attr ------------------\n");
		int AttributeId=0;
	char* tmp;
	char id [20];
	//double Hmotnost;
	char* TypItemu;
	//tag_t Item;

	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_norma#tpv4_typ_polozky#tpv4_hmotnost
	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv
	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#klic#zmena#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv#tpv4_stav#ID_TC
	
	//printf ("test305 %s \n",ID_v);
		//strcpy(Nazvy[poradi][0],I_ID_v);
		strcpy(Nazvy[poradi][0],ID_v);
		//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		tag_t Item;
		ITEM_ask_item_of_rev(Rev,&Item);

		
		AOM_ask_value_string(Item,"object_name",&tmp);
		
		//GetProperty (0,2,Item,&tmp);
		strcpy(Nazvy[poradi][2],tmp);//nazev
		printf("Type %s \n",Nazvy[poradi][2]);
		AOM_ask_value_string(Item,"item_id",&tmp);
		strcpy(id,tmp);
		strcat(id,"/");
		AOM_ask_value_string(Rev,"item_revision_id", &tmp);
		strcpy(Nazvy[poradi][3],tmp);//revize
		strcat(id,tmp);
		strcpy(Nazvy[poradi][16],id);//ID_TC
		

		printf("\\\n pozice %s \n\\",tmp);
		int tmp_pozice=atoi(pozice);
		if(tmp_pozice<3000)	tmp_pozice=tmp_pozice/10;
		printf("pozice %d \n",tmp_pozice);
		sprintf(Nazvy[poradi][10],"%d",tmp_pozice);
		//strcpy(Nazvy[poradi][10],pozice);//pozice

	
		
	
	
			strcpy(Nazvy[poradi][4],mnozstvi);//mnozstvi

		printf("mnozstvi %s \n",Nazvy[poradi][4]);

		AOM_ask_value_string(Rev,"object_type",&TypItemu);
	//	printf("--------Type %s %d-------\n",TypItemu,strcmp(TypItemu,"TPV4_nak_dilRevision"));

		 if(strcmp(TypItemu,"TPV4_nak_dilRevision")==0)
		{
			printf("----nak_dil ----\n");
					AOM_ask_value_string(Rev,"tpv4_skupina",&tmp);
					strcpy(Nazvy[poradi][17],tmp);//skupina

		//printf("item_rev %s \n",Nazvy[poradi][3]);
			strcpy(Nazvy[poradi][7],"N");
		//int id_polozky=0;
		//char* id_polozky_str;
		char* obj_name;
		char* cislo_vykresu;
		AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&cislo_vykresu);
		if(strlen(cislo_vykresu)>2)	strcpy(Nazvy[poradi][1],cislo_vykresu);//cislo vykresu
			else goto prazdny;
		//	AOM_get_value_int(Rev,"tpv4_klic_tpv_np",&id_polozky);
		//	sprintf(Nazvy[poradi][6],"%d",id_polozky);
			//strcpy(Nazvy[poradi][6],id_polozky_str);
			//if(id_polozky==0)
				//strcpy(Nazvy[poradi][6]," ");
			strcpy(Nazvy[poradi][15],"VYR");
			AOM_ask_value_string(Rev,"tpv4_nazev_np",&obj_name);
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_np",&cislo_vykresu);
			strcpy(Nazvy[poradi][6],cislo_vykresu);
			if(strlen(cislo_vykresu)==0)
				strcpy(Nazvy[poradi][6]," ");

			strcpy(Nazvy[poradi][1],tmp);//typ
			//printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		// poradi++;
		
			
		 Add_material(cislo_vykresu,&poradi,ID_v,obj_name,Nazvy[poradi][10]);

		 SAFE_MEM_FREE(obj_name);
		 SAFE_MEM_FREE(cislo_vykresu);
		
		}else if(strcmp(TypItemu,"TPV4_nak_polRevision")==0 || strcmp(TypItemu,"TPV4_h_materialRevision")==0)
		 {
			 printf("_____Nakupovana polozka_______\n");
			 
			 strcpy(Nazvy[poradi][15],"VYR");
			 char* id_polozky;
			 AOM_ask_value_string(Item,"tpv4_nomenklatura",&id_polozky);
			 strcpy(Nazvy[poradi][7],"N");
			 strcpy(Nazvy[poradi][1],id_polozky);//typ
			 SAFE_MEM_FREE(id_polozky);
		
		}
		else if(strcmp(TypItemu,"TPV4_dilRevision")==0)
		{
			printf("export dil \n");
		
		AOM_ask_value_string(Rev,"tpv4_zmena",&tmp);
		printf("\\\n zmena %s \n\\",tmp);
		strcpy(Nazvy[poradi][9],tmp);//zmena
		
		AOM_ask_value_string(Rev,"tpv4_skupina",&tmp);
		strcpy(Nazvy[poradi][17],tmp);//skupina
		//printf("item_rev %s \n",Nazvy[poradi][3]);
			
			//typ dílce 
		/*tag_t *Boms;
		int BomsCount=0;
		ITEM_rev_list_bom_view_revs(Rev, &BomsCount, &Boms);
		if ( BomsCount==0)
		{
			strcpy(Nazvy[poradi][7],"D");
			
		}else
			strcpy(Nazvy[poradi][7],"F");
		*/
		int sestava=IsTypeInRelation(Rev, "IMAN_specification","SWAsm");
		
		if(KontrolaNaradi (Rev))
		{
			printf("nastaveni 2 \n");
			strcpy(Nazvy[poradi][7],"2");
		}

		else if(sestava)
		{
			strcpy(Nazvy[poradi][7],"F");
		}
		else 
			strcpy(Nazvy[poradi][7],"D");
		//printf("test359\n");
	

		//printf("test372\n");
		AOM_ask_value_string(Rev,"tpv4_polotovar",&tmp);
		
		strncpy(Nazvy[poradi][11],tmp,20);
		
		//printf("test377\n");
		AOM_ask_value_string(Rev,"tpv4_material",&tmp);

		strcpy(Nazvy[poradi][12],tmp);

		//hmotnst
		char *hmotnost;
		char* stav;
		char* cislo_vykresu;
		char *poznamka;

		AOM_ask_value_string(Rev,"tpv4_hmotnost",&hmotnost);	
		if(strcmp(hmotnost,"-")==0)
			strcpy(Nazvy[poradi][13]," ");
		else
			strcpy(Nazvy[poradi][13],hmotnost);
		//poznamka
		
		AOM_ask_value_string(Rev,"tpv4_poznamka_tpv",&poznamka);
		strcpy(Nazvy[poradi][14],poznamka);
		
		
		AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&cislo_vykresu);
			if(strlen(cislo_vykresu)>2)	strcpy(Nazvy[poradi][1],cislo_vykresu);//cislo vykresu
			else 
			{
				SAFE_MEM_FREE(hmotnost);
				SAFE_MEM_FREE(cislo_vykresu);
				SAFE_MEM_FREE(poznamka);
				goto prazdny;
			}
		
		AOM_ask_value_string(Rev,"tpv4_stav",&stav);
		printf ("stav %s \n",stav);

		if(strcmp(stav,"OVEROVACI SERIE")==0||strcmp(stav,"OS")==0)
			strcpy(Nazvy[poradi][15],"OS");
		else if(strcmp(stav,"ZAKAZKA")==0||strcmp(stav,"ZAK")==0)
			strcpy(Nazvy[poradi][15],"ZAK");//tpv4_stav
		else
			strcpy(Nazvy[poradi][15],"VYR");//tpv4_stav
		
		if(strcmp(Nazvy[poradi][7],"D")==0)
			{
			int id_polozky=0;
			char* id_polozky_str;
			char* obj_name;
			char* cislo_vykresu_hm;
				AOM_get_value_int(Rev,"tpv4_klic_tpv_hm",&id_polozky);
				sprintf(Nazvy[poradi][8],"%d",id_polozky);
				//strcpy(Nazvy[poradi][6],id_polozky_str);
				//if(id_polozky==0)
					strcpy(Nazvy[poradi][6]," ");
				AOM_ask_value_string(Rev,"tpv4_nazev_hm",&obj_name);
				AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_hm",&cislo_vykresu_hm);
			
				if(strlen(cislo_vykresu)==0)
					strcpy(Nazvy[poradi][6]," ");
				if(strlen(cislo_vykresu_hm)>1)		
				{
					poradi++;
					Add_material(cislo_vykresu_hm,&poradi,cislo_vykresu,obj_name,"3000");
					strcpy(Nazvy[poradi][6],cislo_vykresu_hm);
				}
			SAFE_MEM_FREE(id_polozky_str);
			SAFE_MEM_FREE(obj_name);
			SAFE_MEM_FREE(cislo_vykresu_hm);
			
			}
		SAFE_MEM_FREE(hmotnost);
		SAFE_MEM_FREE(stav);
		SAFE_MEM_FREE(cislo_vykresu);
		SAFE_MEM_FREE(poznamka);
		}
		poradi++;
		prazdny:;
		printf("konec\n ___________\n");
		
		
		//SAFE_MEM_FREE(TypItemu);
		//SAFE_MEM_FREE(tmp);
	return poradi;
}

int ListBomLine(tag_t BomLine, int Level, tag_t pamet[], int poradi,tag_t BomWindow,int Strom [6][4])
{
	//double hm=0;
	int pole[50][10];
	pole[25][5]=255;
	int plus=0;
	char*I_ID_v;
	printf("--------- ListBomLine------------\n");
	//int Strom[6][3];

	printf("start Level = %d poradi %d \n", Level, poradi);
		
	pamet[Level]=BomLine;
	//printf (" tak bom line %d \n",BomLine);
	//char hm [20];
	int AttributeId;
	tag_t Rev = NULLTAG;
	

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(pamet[Level], AttributeId, &Rev);
		BOM_line_look_up_attribute("bl_TPV4_itm_dil_pomRevision_tpv4_cislo_vykresu", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &I_ID_v);
		printf(">>>362>>>>Parent %s\n",I_ID_v);

						//printf("hmotnost dilu %f \n",Hmotnost);
					//	char *tmp;
	if( Level==0)
	{
		downloadDataset(Rev,I_ID_v,0,"pdf"," ");
						char tmpName[128];
			strcpy(tmpName,I_ID_v);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi+1][3]);
			printf("tmpName %s \n",tmpName);
		poradi=ReadAttr(Rev,poradi,"","1","1");
		//readAttr(BomLine, Rev, poradi,"");
		//strcpy(Nazvy[poradi][7],tmp);
		
		

	
	}
	

    // Potomci
	//printf(">>>>>388>>Parent %s\n",I_ID_v);
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	char* tmpQuant;
	char Quant[24];
	char* findNo;
	tag_t RevOld=NULLTAG,
		RevNew=NULLTAG;

	for(int t=0;t<ChildsCount;t++)
	{
		for(int j=0;j<t;j++)
		{
		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[t], AttributeId, &RevOld);
		BOM_line_ask_attribute_tag(Childs[j], AttributeId, &RevNew);
			if(RevOld==RevNew)
			{
				printf("Rev's se rovnaji\n");
			//	char* tmpQuant;
				BOM_line_look_up_attribute("bl_quantity", &AttributeId);
				BOM_line_ask_attribute_string(BomLine, AttributeId, &tmpQuant);
				if (strcmp(tmpQuant,"")==0)
					strcpy(Quant,"1");
				else strcpy(Quant,tmpQuant);

				int dif=t-j;

				int NewQuant =atoi(tmpQuant)+atoi(Nazvy[poradi-dif][4]);//mnozstvi
				sprintf(Nazvy[poradi-dif][4],"%d", NewQuant);
				goto next;
			}
		}


			//poradi=poradi+1;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[t], AttributeId, &Rev);

		BOM_line_look_up_attribute("bl_sequence_no", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &findNo);

		BOM_line_look_up_attribute("bl_quantity", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &tmpQuant);
		printf("%d>>>>tmpQuant %s \n",poradi,tmpQuant);
				if (strcmp(tmpQuant,"")==0)
					strcpy(Quant,"1");
				else strcpy(Quant,tmpQuant);
		printf("%d>>>>Quant %s \n",poradi,Quant);

			char tmpName[128];
			strcpy(tmpName,Nazvy[poradi][1]);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi][3]);
		//	printf("tmpName %s \n",tmpName);
		
		downloadDataset(Rev,Nazvy[poradi][1],poradi,"pdf"," ");
		poradi=ReadAttr(Rev,poradi,I_ID_v,Quant,findNo);
		//strcpy(Nazvy[poradi][7],tmp);
		
	//	printf("Poradi %d Vrchol %s Dil %s Rev %s \n",poradi,I_ID_v,I_ID,REV_ID);
		next:;
	}

	//printf("Count %d \n", ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)
	{	
	
		poradi=ListBomLine(Childs[k], Level + 1, pamet, poradi, BomWindow,Strom);
		
	}
	printf(" pred koncem poradi %d\n",poradi);

	//SAFE_MEM_FREE(I_ID_v);
	//SAFE_MEM_FREE(Childs);
	//SAFE_MEM_FREE(tmpQuant);
	//SAFE_MEM_FREE(findNo);
	
	return poradi;
}

char* create_marks_csv(char *filename,int m,int n){
 
printf("\n Creating %s.csv file \n",filename);
 
FILE *fp;
 
int i,j;
 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\Export\\csv\\");
 strcat(file,filename);
//printf("test1 \n");
 strcat(file,".csv");
 //printf("file %s \n",file);



fp=fopen(file,"w");
 printf("test po zaèátku zápisu %d \n",fp);
//fprintf(fp,attr);
 
for(i=0;i<m;i++)
{
	printf ("fprint %d \n",i);
	if(i==0)
		fprintf(fp,"poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#klic#zmena#pozice#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv#tpv4_stav#ID_TC#tpv4_skupina#klic_maxu\n%d",i);
					
	else
	{
		fprintf(fp,"\n%d",i);
	}
			for(j=0;j<=n;j++)
			{
				fprintf(fp,"#%s",Nazvy[i][j]);	
				printf("# %s",Nazvy[i][j]);
			}
			fprintf(fp,"#0000000");	
}
    //fprintf(fp,"\n%d",i+1);
fclose(fp);
 
printf("\n file created - %s \n",file);
 return file;
}
void CallBridge(char* file)
{	char help [50];
	strcpy(help,file);
	printf("file %s \n",help);
	//char ImportTPV[256]="C:\\TC4TPV\\TCCom\\TCCom.jar \"";
	char ImportTPV[256]="call C:\\SPLM\\Apps\\Export\\TC2TPV.bat \"C:\\SPLM\\Apps\\Export\\csv\\";
	strcat(ImportTPV,help);
	strcat(ImportTPV,".csv");
	strcat(ImportTPV,"\"");
	//printf("%s \n",ImportTPV);
	system(ImportTPV);

//	system("call C:\\TC4TPV\\TCCom\\run.bat");
	 printf("%s\n",ImportTPV);
	//system("call TC2TPV.bat");
}
void Cisteni()
{
	for (int i=0;i<100;i++)
		for(int j=0;j<20;j++)
			strcpy(Nazvy[i][j],"");
}


int TPV_TC2TPV(EPM_action_message_t msg)
{
	Cisteni();
	//ReadProperty();
     int
        TargetsCount = 0,	
		BomsCount = 0;
		
    tag_t
        *Targets = NULL,
		Rev=NULLTAG,
        class_tag = NULLTAG,
		*Boms = NULLTAG,
		job=NULLTAG,
		RootTask=NULLTAG;
    char  
        file_name[WSO_name_size_c+2] = "",
		*RevId=NULL,
        description[WSO_desc_size_c+1]  = "";

		tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
	
    EPM_decision_t
        //decision=EPM_undecided ;
		decision=EPM_nogo ;
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;
	POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);
	//AOM_UIF_ask_value(job,"object_name",&job_name);

printf("test0 \n");		
		//FILE *log;
	char logpath[30];

	strcat(logpath,".log");

		
    EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
	char* file;
		printf ("target count %d\n", TargetsCount);
	AOM_ask_value_string(Targets[0],"item_id",&file);
	AOM_ask_value_string(Targets[0],"item_revision_id",&RevId);
		

	printf("count %d \n",TargetsCount);
for( int i = 0; i < TargetsCount; i ++ )
{
	tag_t TargetClassTag = NULLTAG;
	POM_class_of_instance(Targets[i], &TargetClassTag);
	printf("test1 \n");	
	logical IsRevision = false;
	POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);
	printf("test2 \n");	
	if(IsRevision == false) continue;
		char *Type;
	      
			// BOM window
			
			tag_t pamet[100];
            tag_t BomWindow = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;
			int poradi=0,
			 Strom[6000][4];
				
			//fprintf(log,"Otevreni kusovniku \n");
			printf("Otevreni kusovniku \n");	
	for(int l=0;l<6;l++){
		for (int p=0;p<3;p++){
			Strom [l][p]=0;
		}
	}

		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
		
		printf ("%s\n",Type);
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
			
		//fprintf(log,"pocet kusovniku %d\n",BomsCount);	
		if (BomsCount==0)
		{
			downloadDataset(Targets[i],Nazvy[i][1],poradi,"pdf"," ");
			poradi =ReadAttr(Targets[i], i," ","1","10");
			printf("Nazvy 1 %s Rev %d poradi %d\n",Nazvy[i][1],Targets[i],poradi);
			
			
		//	fprintf(log,"stazeny datasety pouze pro tento dilec\n");
		}
        for(int j = 0; j < BomsCount; j++)
        {

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom);
			
			//BOM_refresh_window(BOM
        }
		
		//fprintf(log,"Zpracovano kusovniku \n");
		for (int k =0;k<strlen(file);k++)
			if(file[k]==' ')file[k]='_';
		strcpy(file_name,file);
		strcat(file_name,"_");
		strcat(file_name,RevId);
		create_marks_csv(file_name,poradi,17);
		//fprintf(log,"Spusteni importu do TPV \n");
		//CallBridge(file_name);
		CallBridge(file_name);
		//fprintf(log,"Dokonceno \n \n");
		//Delprilohy (poradi);
}

//	fclose(log);
	Report_import( msg,RootTask);

	SAFE_MEM_FREE(Targets);
	SAFE_MEM_FREE(Boms);
	SAFE_MEM_FREE(RevId);

    return ITK_ok;
}
