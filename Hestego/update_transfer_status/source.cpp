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
#include <string>
#include <tccore\aom.h>
#include <tc\folder.h>
#include <time.h>
#include <epm\epm_task_template_itk.h>

/// reportovani by Gtac
#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_RETURN(X) if (IFERR_REPORT(X)) return
#define IFERR_RETURN_IT(X) if (IFERR_REPORT(X)) return X
#define ECHO(X)  printf X; TC_write_syslog X
#define EXIT_FAILURE 1 
#define EXIT_IF_NULL(X) (check_value(#X, (X)))

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

char *time_stamp(){

char *timestamp = (char *)malloc(sizeof(char) * 16);
time_t ltime;
ltime=time(NULL);
struct tm *tm;
tm=localtime(&ltime);

sprintf(timestamp,"%04d%02d%02d%02d%02d%02d", tm->tm_year+1900, tm->tm_mon+1, 
	tm->tm_mday, tm->tm_hour, tm->tm_min,tm->tm_sec);
return timestamp;
}

static void LogThis(char * text,char * filename)
{
	FILE* stream;
	char logpath[40];
	strcpy(logpath, "C:\\Temp\\");
	strcat(logpath,filename);
	strcat(logpath, ".txt");
	printf("log --- %s \n",logpath);
	stream = fopen(logpath, "a+");
	printf(" %s \n",text);

		fprintf(stream, "%s \n", text);
		printf("End Loging \n");
	fclose(stream);
}

static void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;
		char text [512];
		EMH_get_error_string(NULLTAG, return_code, &error_message_string);
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));
		if (error_message_string) MEM_free(error_message_string);
		//ECHO(("\nExiting program!\n"));
		sprintf(text,"ERROR:\n FUNCTION: %s\nFILE: %s LINE: %d",function, file, line);
		LogThis(text,"Update_Rev");
		//exit(EXIT_FAILURE);
	}
}

static void check_value(char *function, int value)
{
	if (value == 0)
	{
		printf("\t%s is NULL\n", function);
		printf("\nExiting program!\n");
		exit(EXIT_FAILURE);
	}
}

//Spuštìní WF 


static void strat_process(tag_t rev)
{
	int
		attach_types[1] = { 1 };
	tag_t
		//rev = NULLTAG,
		process_template = NULLTAG,
		process = NULLTAG;

	//ERROR_CHECK(ITEM_find_rev(obj_id, obj_rev, &rev));
	EXIT_IF_NULL(rev);

	ERROR_CHECK(EPM_find_process_template("Hestego_mazani_statusu", &process_template));
	printf("process template %d \n",process_template);
	EXIT_IF_NULL(process_template);


	ERROR_CHECK(EPM_create_process("remove_status", "automatic starting wf for remove status before updatetin transfer status", process_template, 1, &rev,
		attach_types, &process));
	printf("process %d \n",process);
	EXIT_IF_NULL(process);
}


void MoveTPToFolder(tag_t folder,tag_t object)
{ 
   //insert to folder
     IFERR_REPORT(AOM_refresh( folder, TRUE));
     IFERR_REPORT(FL_insert(folder, object, 0));
     IFERR_REPORT(AOM_save(folder));
     IFERR_REPORT(AOM_refresh( folder, TRUE));
	printf("vlozeno!!!!!!!!!!!\n");
}

int CountInRelation(tag_t Child,char * Relation)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	printf("find relation %d \n",relation_type);
	 err=GRM_list_primary_objects_only(Child, relation_type, &Count, &secondary_list);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	if (secondary_list) MEM_free(secondary_list);
	return Count;
}
 tag_t create_relation(char relation_type[GRM_relationtype_name_size_c + 1], tag_t primary_object_tag, tag_t secondary_object_tag)
{
    tag_t relation_type_tag = NULLTAG;
    IFERR_REPORT(GRM_find_relation_type(relation_type, &relation_type_tag));
	printf("realtion type_%d \n -primary_object_tag %d \n -secondary_object_tag %d \n",relation_type_tag,primary_object_tag, secondary_object_tag);
    tag_t relation_tag  = NULLTAG;
    IFERR_REPORT(GRM_create_relation(primary_object_tag, secondary_object_tag, relation_type_tag, NULLTAG, &relation_tag));

    IFERR_REPORT(GRM_save_relation(relation_tag));
    return relation_tag;
}
void SetInt(tag_t object,int value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_int(object,prop,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno %d\n",value);
}
void SetString(tag_t object,char* value,char *prop)
{
	 IFERR_REPORT(AOM_lock(object));
	 IFERR_REPORT(AOM_set_value_string(object,prop,value));
	 IFERR_REPORT(AOM_save(object));
	 IFERR_REPORT(AOM_unlock(object));
	//AOM_unload(object);
	printf("Vlozeno %s \n",value);
}
logical HaveBom(tag_t Rev)
{
	int BomsCount;
	tag_t *Boms;
	ITEM_rev_list_bom_view_revs(Rev, &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
	if(BomsCount==1)
	{
		tag_t BomWindow;
		tag_t BomTopLine;
		int ChildsCount;
		tag_t *Childs;
		BOM_create_window(&BomWindow);
		BOM_set_window_top_line(BomWindow, NULLTAG, Rev, Boms[0], &BomTopLine);
		BOM_line_ask_child_lines(BomTopLine, &ChildsCount, &Childs);
		if (ChildsCount>0)
			return true;
		 
	}
	return false;
}

void UpdateRev(char* datum,tag_t Rev,char* desc)
{
		int is_released=0;
		EPM_ask_if_released(Rev,&is_released);
	if(is_released	==1)
		strat_process(Rev);

	char  text [100];
	strcpy(text,desc);
	if(HaveBom(Rev))
		{
			SetString(Rev,"CREATEDBOM","h4_transfer_status");
			strcat(text,"; CREATEDBOM");
	}
	else
	{
		SetString(Rev,"CREATED","h4_transfer_status");
		strcat(text,"; CREATED");
	}
	char desc_sap[50];

	
	strcpy(desc_sap,desc);
	strcat(desc_sap,datum);
	
	SetString(Rev,desc_sap,"h4_transfer_desc");
	 LogThis(text,"Update_Rev");
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
void Send2Folder(tag_t *Rev,int count_rev)
{
	tag_t tmp=NULLTAG;
	tag_t Item;
	for (int i=0;i<count_rev;i++)
	{
				ITEM_ask_item_of_rev(Rev[i],&Item);
						if(Item!=tmp)
						{
							tmp=Item;
							//IntoFolder("Manual_connect",Item);
						}			
	}
}
int getTagItem2(char *cislo_vykresu, char* date_import_adres, tag_t Part)
{
	tag_t Item,
		*Rev;
	char d_aktualizace[10];
	int import_day,
		import_month,
		import_yaer;
      


				tag_t query = NULLTAG;
				QRY_find("Hestego_search", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				printf("cislo vykresu %s \n",cislo_vykresu);
				char *entries[1] = {"vykres_norma"};
				char *values[1] =  {cislo_vykresu};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Rev);
				printf("pocet nalezu %d\n",n_folder);
				
				if(n_folder==0)
					return 0;
				else if (n_folder==1)
					return *Rev;
				else if (n_folder>1)
				{
					tag_t tmp=NULLTAG;
					ITEM_ask_item_of_rev(Rev[0],&tmp);
					for (int i=i;i<n_folder;i++)
					{
						
						ITEM_ask_item_of_rev(Rev[i],&Item);
						if(Item!=tmp)
						{
							 Send2Folder(Rev,n_folder);

							// IntoFolder("Manual_connect",Part);
							return -1;
						}
					}
					tag_t tmp_rev=Rev[0];
					if(Rev) MEM_free(Rev);
					return tmp_rev;
				}

	if(Rev) MEM_free(Rev);
	 return 0;
}
int getTagItem(char *cislo_vykresu)
{
	tag_t *Item,
		*Rev;

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("PoS_NAK_POLOZKA", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				printf("cislo vykresu %s \n",cislo_vykresu);
				char *entries[1] = {"NOMENKLATURA"};
				char *values[1] =  {cislo_vykresu};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Item);
				printf("pocet nalezu %d\n",n_folder);
				if(n_folder==0)
					return 0;

	//return Item[0];

	// ITEM_find_item	(	id_obj,&Item);	
	 return *Item;
}
int getTagRev(char *id_obj,char* rev_id)
{
	tag_t Item,
		*Rev;

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("Item Revision...", &query);
				printf("tag foldru Qry General je %d\n",query);
				printf( "%s %s \n",id_obj,rev_id);
				// Find user's "Tasks to Perform" folder
				char *entries[2] = {"Item ID","Revision"};
				char *values[2] =  {id_obj,rev_id};
				for (int i =0;i<2;i++) printf (" |%s=%s| \n",entries[i],values[i]);
				int n_entries =2;
				int n_folder = 0;		
							
				QRY_execute(query, n_entries, entries, values, &n_folder, &Rev);
				printf("pocet nalezu %d\n",n_folder);
				/*for (int i =0;i<n_folder;i++)
				{
					char* obj_name;
					AOM_ask_value_string(Rev[i],"object_name",&obj_name);
					printf("name %s \n",obj_name);
				}*/
	if(n_folder==1)
		return Rev[0];

	 ITEM_find_item	(	id_obj,&Item);	
	 return 0;
}
void Helios2SAP()
{
	tag_t *item,
		*revs;

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("_Hestego_VP-Prenos_IS_NULL", &query);
				printf("tag Qry je %d\n",query);
				//printf( "%s %s \n",id_obj,rev_id);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"creation_date_before"};
				char *values[1] =  { "01-May-2019"};
				//for (int i =0;i<2;i++) printf (" |%s=%s| \n",entries[i],values[i]);
				int n_entries =1;
				int n_obj = 0;		
							
				QRY_execute(query, n_entries, entries, values, &n_obj, &revs);
				printf("pocet nalezu %d\n",n_obj);
				/*for (int i =0;i<n_folder;i++)
				{
					char* obj_name;
					AOM_ask_value_string(Rev[i],"object_name",&obj_name);
					printf("name %s \n",obj_name);
				}*/
	//if(n_obj==1)
		//return Rev[0];
				char *trans_status;
				char *item_id;
				char *rev_id;
				char *desc_automatic;
				char *obj_string;
	for (int i= 0;i<n_obj;i++)
	{
		printf("obj %d: \n",i);
		int n_rev=0;
		
			
			//ITEM_ask_id2(item[i],&item_id);
			AOM_ask_value_string(revs[i],"object_string",&obj_string);
			AOM_ask_value_string(revs[i],"h4_transfer_status",&trans_status);
			AOM_ask_value_string(revs[i],"h4_transfer_desc",&desc_automatic);
			printf(" tran_status = %d \n", strlen(trans_status));
			if (strcmp(desc_automatic,"update, automatic")>=0 && strlen(desc_automatic)>10)
			{
				char text[150];
				sprintf(text,"\nIs Updated transfer status %s",obj_string);
				LogThis(text,"Hel2SAP_Update_Rev");
			}
			else if (strlen(trans_status)==0)
			{
				
				char text[150];
				sprintf(text,"\n Update transfer status %s",obj_string);
				LogThis(text,"Hel2SAP_Update_Rev");
				UpdateRev(time_stamp(),revs[i],"update, automatic");
			}
		
	}
	 //return 0;

}
void FindUpdatedFile(char* typPolozky)
{
	tag_t *item,
		*revs;

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("General...", &query);
				printf("tag foldru Qry General je %d\n",query);
				//printf( "%s %s \n",id_obj,rev_id);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"Type"};
				char *values[1] =  { typPolozky};
				//for (int i =0;i<2;i++) printf (" |%s=%s| \n",entries[i],values[i]);
				int n_entries =1;
				int n_obj = 0;		
							
				QRY_execute(query, n_entries, entries, values, &n_obj, &item);
				printf("pocet nalezu %d\n",n_obj);
				/*for (int i =0;i<n_folder;i++)
				{
					char* obj_name;
					AOM_ask_value_string(Rev[i],"object_name",&obj_name);
					printf("name %s \n",obj_name);
				}*/
	//if(n_obj==1)
		//return Rev[0];
				char *trans_status;
				char *item_id;
				char *rev_id;
				char *desc_automatic;
	for (int i= 0;i<n_obj;i++)
	{
		int n_rev=0;
		ITEM_list_all_revs	(item[i],&n_rev,&revs);	
		for (int t=0;t<n_rev;t++)
		{
			ITEM_ask_id2(item[i],&item_id);
			ITEM_ask_rev_id2(revs[t],&rev_id);
			AOM_ask_value_string(revs[t],"h4_transfer_status",&trans_status);
			AOM_ask_value_string(revs[t],"h4_transfer_desc",&desc_automatic);
			if (strcmp(desc_automatic,"update, automatic")>=0)
			{
				char text[150];
				sprintf(text,"\nIs Updated transfer status %s/%s",item_id,rev_id);
				LogThis(text,"Update_Rev");
			}
			else if (strlen(trans_status)!=0 || strcmp(trans_status,"UPDATED")==0 || strcmp(trans_status,"CHANGED")==0 || strcmp(trans_status,"CREATED")==0 || strcmp(trans_status,"NULL")==0)
			{
				char text[150];
				sprintf(text,"\n Update transfer status %s/%s",item_id,rev_id);
				LogThis(text,"Update_Rev");
				UpdateRev(time_stamp(),revs[t],"update, automatic");
			}
		}
	}
	 //return 0;

}
int main(int argc, char *argv[])
{
	//if (ITK_init_from_cpp(argc,argv)!=ITK_ok)
	//{

    // ITK initialization
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);
	char*user = ITK_ask_cli_argument( "-u=");
	char*pass = ITK_ask_cli_argument( "-p=");
	char*group = ITK_ask_cli_argument( "-g=");
	

    // Login
    int ReturnCode = TC_init_module(user, pass, group);
    if(ReturnCode != ITK_ok)
    {
        char *Message;
        EMH_ask_error_text(ReturnCode, &Message);
        fprintf(stderr, "ERROR: %s\n", Message);
		return ITK_ok;
    }
    ECHO(("Login OK\n"));
	
	char*imtup_file = ITK_ask_cli_argument( "-d=");
	//char*goal_folder = ITK_ask_cli_argument( "-f=");
	printf(" delak nazvu souboru %d %s =%d\n ",strlen(imtup_file),imtup_file,strcmp(imtup_file,"0"));
	//char *TP="ZAA 000 000";
    // Vyhledání položek
	if(strlen(imtup_file)>4 )
	{
		if(SouborExistuje(imtup_file)!=0){
			ECHO(("file neexistuje \n"));
			goto end;
		}else ECHO(("soubor existuje\n"));
			FILE* stream = fopen(imtup_file, "r");
	
		char line[7000];
		char *token;
		int vysledek=0;
		tag_t item_revs=NULL;
	
			while (fgets(line, 7000, stream))
			{
				//printf ("%s - %d \n",line,strlen(line));
				char item_id[15],rev_id[3],kod_fin_vyrobku[20],zak_rev[3],vytvoreno[20],drma[4],cislo_mat[128],daa_id[17],rev_daa[3];
				char* tmp;
			

				sscanf(line,"%s%s%s%s%s%s%s%s%s",item_id,rev_id,kod_fin_vyrobku,zak_rev,vytvoreno,drma,cislo_mat,daa_id,rev_daa);
				//printf ("%s %s %s \n",item_id,rev_id,kod_fin_vyrobku);
				printf ("%s %s %s %s %s %s %s %s %s",item_id,rev_id,kod_fin_vyrobku,zak_rev,vytvoreno,drma,cislo_mat,daa_id,rev_daa);
				char text[150];
				sprintf(text,"\n Updated %s/%s : ",item_id,rev_id);
				 LogThis(text,"Update_Rev");
				
				//tmp=strtok(NULL,"\n");
				//ECHO(("rev %s \n",tmp));
				item_revs=getTagRev(item_id,rev_id);
				printf ("vysledky %d tag %d \n",vysledek,item_revs);
				if(item_revs!=0)
				 UpdateRev(vytvoreno,item_revs,"update, import to sap be export file");
			}
	}
	else if(strcmp(imtup_file,"LAK")==0)
	{
		FindUpdatedFile("LAK");
	}
	else if(strcmp(imtup_file,"VP")==0)
		{
			FindUpdatedFile("VP");
	}
	else if(strcmp(imtup_file,"KOOP")==0)
		{
			FindUpdatedFile("KOOP");
	}
	else if(strcmp(imtup_file,"VYP")==0)
		{
			FindUpdatedFile("VYP");
	}
	else if(strcmp(imtup_file,"H2S")==0)
		{
			Helios2SAP();
	}
	end:;
    ITK_exit_module(true);
    return 0;
}