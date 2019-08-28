#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <string.h>
#include <tc/tc.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>
#include <tccore/aom.h>
#include <tccore/tctype.h>
#include <tc/folder.h>
#include <errno.h>
#include <time.h>
#include <ae\ae.h>

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define CHUNK 1024 /* read 1024 bytes at a time */

char QueryExistenece[10][128];
char EntryExistenece[10][128];
char AttryExistenece[10][128];
char Attr [10][30][128];
char Attr_type [10][30][128];
char Attr_tpv [10][30][128];
char attr_set[10][128];
char value_set[10][128];
char login[20],
	password[30],
	import_file[50],
	group[20],
	from_copy[20],
	from_add[20][20],
	to_add[20],
	to_copy[20];

int Type_num=0;
int Add_num[10];
int Add_d_num[10];
int Attr_num=0 ;
int Remove_line=0;
int Attr_Typ_polozky=0;
tag_t Zalozeny[20];
//tag_t Schval_Item=NULLTAG;
tag_t Schval_Rev=NULLTAG;
tag_t Schval_Bwr=NULLTAG;
int zalozeny_num=0;

//struct Polozka{
//	char I_Name[128];
//	char I_Popis[128];
//	char* Attr1;
//	char* Attr2;
//	char* Attr3;
//};
//Polozka I;
int Existence(char hodnoty [20][256],char* typ, int typ_pol_num);
void ListBomLine(tag_t BomLineTag, int Level);

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
char* Linkfile(char * text, char *linkfile,char *time_stamp )
{
	
	FILE *fs;
	char *user_name_string = NULL;


	char file[100];
	char name[50];
	strcpy(file, "C:\\SPLM\\Apps\\Import_TC_trans\\");
	/*printf("%s\n",file);
	strcpy(name, linkfile);
	printf("%s\n",name);
	strcat(name, time_stamp);*/
	printf("%s\n",time_stamp);
	strcat(name, ".txt");
	strcat (file,name);
	printf("%s\n",file);
	fs = fopen(file, "a+");
	fprintf(fs, "%s", text);
	fclose(fs);
	return name;
}
char *time_stamp() {

	char *timestamp = (char *)malloc(sizeof(char) * 16);
	//char timestamp[10];
	time_t ltime;
	ltime = time(NULL);
	struct tm *tm;
	tm = localtime(&ltime);

	sprintf(timestamp, "%04d%02d%02d_%02d%02d%02d", tm->tm_year + 1900, tm->tm_mon + 1,
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
		//exit(EXIT_FAILURE);
	}
}
void ReadLogin()
{
		printf(" Read login Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char Path[50]="TPV2TC_property.xml";// puvodne C:\\SPLM\\Apps\\Import\\TPV2TC_property.xml


	    FILE* stream = fopen(Path, "r");
		printf("Open %s\n",Path);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		
		tmp=strtok(line,">");
	if(strcmp(tmp,"<login")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("login %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(login,tmp);
			goto nextLine;

		}
				else if(strcmp(tmp,"<psw")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("password %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(password,tmp);
			goto nextLine;

		}
			else if(strcmp(tmp,"<group")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("group %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(group,tmp);
			goto nextLine;

		}
		Attr_num++;
		nextLine:;
			}


//}
printf("-----Attr_num %d -----\n",Attr_num);
}
void ReturnPdf2TPV(char* dok_id,char* klic_tpv,char * odkaz)
{
	char answer[500];
	strcpy(answer,"call C:\\SPLM\\Apps\\Import_TC_trans\\run_update_link2TPV.bat \"-answerdPDF=");
	printf("%s \n",answer);
	strcat(answer,dok_id);
	strcat(answer,";");
	/*strcat(answer,klic_tpv);
	strcat(answer,";");*/
	printf("%s \n",answer);
	printf("strlen(odkaz) %d \n",strlen(odkaz));
	strcat(answer,odkaz);
	strcat(answer,";\"");
	printf("%s \n",answer);
	system(answer);
	//printf("%s \n",answer);
	//Linkfile(answer, "link",time_stamp());
	
}
void importDatates(tag_t dataset,char* way,char *ref,char *fileName)
{
    /*  AE_find_dataset finds latest revision of dataset */
    
    //IFERR_ABORT(AE_find_dataset("6667776-A", &dataset));
   printf("\n dataset: %d \n", dataset);
	AOM_lock(dataset);
    AOM_refresh(dataset, TRUE);
   printf("\n dataset=%d) \n ref=%s) \n way=%s) \n filename=%s) \n",dataset, ref, way, fileName);
    /* the fourth argument must be a unique name in the volume */
   AE_import_named_ref(dataset, ref, way, fileName,  SS_BINARY);
  // AE_import_named_ref(dataset, "UG-QuickAccess-Binary", "W:\\images_preview.qaf", "6667776-A_binary.qaf",  SS_BINARY);

    AOM_save(dataset); 
    AOM_refresh(dataset, FALSE);
	AOM_unlock(dataset);
    AOM_unload(dataset);
}

static void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset)
{
    char
        format_name[AE_io_format_size_c + 1] = "BINARY_REF";
    tag_t
        datasettype,
        tool;
    
    AE_find_datasettype(type_name, &datasettype);
    if (datasettype == NULLTAG)
    {
        printf("Dataset Type %s not found!\n", type_name);
        exit (EXIT_FAILURE);
    }
    
    AE_ask_datasettype_def_tool(datasettype, &tool);
    
    printf("Creating Dataset: %s\n", name);
    AE_create_dataset(datasettype, name, "", dataset);
    
    AE_set_dataset_tool(*dataset, tool);
    if (strcmp(type_name, "PDF")) strcpy(format_name, "PDF");
    
    AE_set_dataset_format(*dataset, format_name);
    printf("Saving Dataset: %s\n", name);
    AOM_save(*dataset);
    
    /*attach dataset to item revision */
    ITEM_attach_rev_object(rev, *dataset, ITEM_specification_atth);
  //  ITEM_save_item(item);
	
}

int GetAttr(char* attr,int polozka_num)
{
	//printf("Get Attr %d \n attr %s %d\n",Attr_num, attr, polozka_num);
	int num=0;
	for (int i=1;i<Attr_num+1;i++)
	{
		//printf("%d ) attr %s =? attr_type pol %s|| %s \n",i,attr,Attr_type[polozka_num][i],Attr[polozka_num][i]);
		if (strcmp(Attr[polozka_num][i],attr)==0)
		{
			//printf("%d ) attr %s =? attr_type pol %s| %s \n",i,attr,Attr_type[polozka_num][i],Attr[polozka_num][i]);
			return i;
		}
		else if (strcmp(Attr_type[polozka_num][i],attr)==0)
		{
			//printf("%d ) attr %s =? attr_type pol %s| %s \n",i,attr,Attr_type[polozka_num][i],Attr[polozka_num][i]);
			return i;
		}
	}
	return num;

}
void GetItemRev(char* id, tag_t **items,tag_t *rev,int *itemsCount)
{
	tag_t *item_f;
	int itemCount_f;
	printf("%d id %s\n",__LINE__,id);
	  const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
	  printf("line %d \n",__LINE__);
     const char *AttrValues[1] = {id};
     printf("line %d %s \n",__LINE__,AttrValues[1]);
   
		int err=ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, itemsCount, items);
		printf("err = %d \n",err);
		if(itemsCount!=0)
		{ printf("itemsCount %d items %d \n",itemsCount,*items);
		IFERR_REPORT(ITEM_ask_latest_rev(**items,rev));
		}else printf("pocet nalezu 0\n");
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

void MoveTPToFolder(tag_t folder,tag_t object)
{ 
   //insert to folder
    AOM_refresh( folder, TRUE);
    FL_insert(folder, object, 0);
    AOM_save(folder);
    AOM_refresh( folder, TRUE);
	//printf("vlozeno!!!!!!!!!!!\n");
}
void IntoFolder(char* folderName,tag_t Item)
{
					tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("General...", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[2] = {"Name","Type"};
				char *values[2] =  {folderName,"Folder"};
				int n_folder = 0;
				//strcpy(values[0],folder);
				
							
				QRY_execute(query, 2, entries, values, &n_folder, &folder);
				printf("pocet nalezu %d\n",n_folder);

				//vloženi do folder TPianty
				MoveTPToFolder(*folder,Item);
}

char* CreateLink2TC(tag_t Targets)
{
	FILE* stream;
	char logpath[30];

	char link[128],
		*adresa = "http://srvtc:7001/tc/launchapp?-attach=true&-s=226TCSession&-o=",
		*append = "AAAAAAAAAAAAAA";
	
		char *Uid;
		ITK__convert_tag_to_uid(Targets, &Uid);
		strcpy(link, adresa);
		strcat(link, Uid);
		strcat(link, append);

	
	return link;
}

const char* getfield(char* line, int num)
{
    const char* tok;
    for (tok = strtok(line, ";");
            tok && *tok;
            tok = strtok(NULL, ";\n"))
			//printf("tok %s num %d\n",tok,num);
    {
        if (!--num)
		{
     //    printf("tok %s \n",tok);
			return tok;
		}
    }
    return NULL;
}


void ReadCSV(char* string)
{
	char *tmp;
	//int typ=nastavenyTyp;
//	char *tmp_field;
	
	char hodnoty[50][256];
	//printf("string %s \n",string);
	printf("Attr_num %d Remove %d \n",Attr_num,Remove_line);
	for(int t=0;t<20;t++)
		strcpy(hodnoty[t],"");
	//int i=1;
	tmp=strdup(string);
	strcpy(hodnoty[0],strtok(string,";"));
	printf(" %d Field  %s\n\n",0,hodnoty[0]);
	
	//for (int i =2;i<=Attr_num-Remove_line;i++)
	int i=1;
	
	do
	{		
		
		char* tmp=strtok(NULL,";");;
			printf("%d %s\n",__LINE__,tmp);
		if(i>0)	strcpy(hodnoty[i],tmp);
			printf(" %d Field  %s\n\n",i,hodnoty[i]);
			i++;
			
			printf("%d %d\n",__LINE__,tmp);
		
	}while (i<5);
	printf("%d \n",__LINE__);
	 tag_t dataset;
	 tag_t *items;
		 tag_t rev;
		 int itemsCount;
		 printf("%d \n",__LINE__);
	 GetItemRev(hodnoty[0], &items, &rev, &itemsCount);
	 printf("items %d rev %d intemsCount %d \n",*items, rev,itemsCount);
	 if(itemsCount==0)
		 printf("%d \n",__LINE__);
	 else
		create_dataset("PDF", hodnoty[1], *items, rev, &dataset);
	 importDatates(dataset,hodnoty[2],"PDF_Reference",hodnoty[1]);
	
	 ReturnPdf2TPV(hodnoty[3],hodnoty[4],CreateLink2TC(dataset));
	    //free(tmp);
		//free(tmp_field);
		//if(typ!=-1);
			//Create(hodnoty,typ);
		/*free(hodnoty);*/
}

int main(int argc, char *argv[])
{
	ReadLogin();
   
    // ITK inicializace
	printf("1\n");
   if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }
	printf("2\n");
    ITK_initialize_text_services(0);
	printf("3\n");
	printf(" %s %s %s \n",login, password, group);
    // Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
        fprintf(stderr, "ERROR: Login failed\n");
        return 1;
    }
    printf("Login OK\n");
	int typpolozky=0;
	
	char*insert_pdf = ITK_ask_cli_argument( "-ins_pdf=");

	printf("pdf %s \n",insert_pdf);

	
    
		if(strchr(insert_pdf,';')!=NULL)
			ReadCSV(insert_pdf);
      
    


	//free(QueryExistenece);
	//free(EntryExistenece);
	//free(AttryExistenece);
	//free(Attr);
	//free(Attr_type);
	//free(Attr_tpv);
	//free(attr_set);
	//free(value_set);
	//free(login),
	//free(password),
	//free(import_file),
	//free(group),
	//free(from_copy),
	//free(to_copy);

	


//free(Zalozeny);
//tag_t Schval_Item=NULLTAG;

    return 0;
}



