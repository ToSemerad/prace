#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <string.h>
#include <tcinit\tcinit.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>
#include <tccore/aom.h>
#include <tccore/tctype.h>
#include <tc/folder.h>
#include <errno.h>
#include <time.h>
#include <tccore\grm.h>
#include <sa/person.h>
#include <sa/user.h>
#include <tccore/item.h>
#include <tccore/workspaceobject.h>
#include <tccore/uom.h>

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define CHUNK 1024 /* read 1024 bytes at a time */
char rel_repre_by[32 + 1] = "TC_Is_Represented_By";
char owner[129] ="tpv";
char ownerGroup[129] = "KONSTRUKCE.IN-EKO";


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
bool debug;
bool Inge;
bool InEko;
bool InEko_HCV;

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
int Existence(char hodnoty [20][1024],char* typ, int typ_pol_num);

void Inge_copy_atr(tag_t designRev, tag_t PartRev);

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

	sprintf(timestamp, "%04d-%02d-%02d %02d:%02d:%02d", tm->tm_year + 1900, tm->tm_mon + 1,
		tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);


	return timestamp;
}
static void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;
		char *time = time_stamp();
		EMH_ask_error_text(return_code, &error_message_string);
		//EMH_ask_errors(NULLTAG, return_code, &error_message_string);
		ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));

		LogErr(error_message_string, "report_error", line, time);

		if (error_message_string) MEM_free(error_message_string);
		//ECHO(("\nExiting program!\n <<<<<<<\n"));
		//exit(EXIT_FAILURE);
	}
}

tag_t create_relation(char relation_type[GRM_relationtype_name_size_c + 1], tag_t primary_object_tag, tag_t secondary_object_tag)
{
	tag_t relation_type_tag = NULLTAG;
	IFERR_REPORT(GRM_find_relation_type(relation_type, &relation_type_tag));
	printf("realtion type_%d \n -primary_object_tag %d \n -secondary_object_tag %d \n", relation_type_tag, primary_object_tag, secondary_object_tag);
	if (debug)
	{
		char* prim_name,
			*sec_name;

		AOM_ask_value_string(primary_object_tag, "object_name", &prim_name);
		AOM_ask_value_string(secondary_object_tag, "object_name", &sec_name);
		printf("L:%d pripojeni %s do s% \n", __LINE__, sec_name, prim_name);
		system("pause");
	}
	tag_t relation_tag = NULLTAG;
	IFERR_REPORT(GRM_create_relation(primary_object_tag, secondary_object_tag, relation_type_tag, NULLTAG, &relation_tag));

	IFERR_REPORT(GRM_save_relation(relation_tag));
	return relation_tag;
}

void Inge_connect_part_rev(tag_t rev,char * id_zalozene)
{
	tag_t query = NULLTAG;
	int n_item;
	tag_t * revs;
	QRY_find2("Cislo_vykresu", &query);
	
	// Find user's "Tasks to Perform" folder
	char *entries[1] = {"tpv4_cv"};
	
	char *values[1] = { id_zalozene };
	if (debug) printf("hodnota hledani %s delka %s ATTR %s\n", values[0], values[0], entries[0]);
	QRY_execute(query, 1, entries, values, &n_item, &revs);

	if (n_item==1)
		create_relation(rel_repre_by, rev, revs[0]);
	else if (n_item > 1)
	{
		for (int i = 0; i < n_item; i++)
		{

			//if 
			create_relation(rel_repre_by, rev, revs[i]);
		}
	}
}

void InEko_connect_part_rev(tag_t Partrev, int id_zalozene)
{
	tag_t query = NULLTAG;
	int n_item;
	tag_t * revs;
	QRY_find2("Cislo_tpv", &query);
	char charValue[10];

	sprintf(charValue, "%d", id_zalozene);
	// Find user's "Tasks to Perform" folder
	if (debug)printf("L:%d \n", __LINE__);
	char *entries[1] = { "KlicTPV" };

	char *values[1] = { charValue };
	if (debug)
	{
		printf(" hledani %d hodnota %s ATTR %s\n", query, values[0], entries[0]);
		system("pause");
	}
	QRY_execute(query, 1, entries, values, &n_item, &revs);
	if (debug)printf("L:%d nalezi %d \n",__LINE__, n_item), system("pause");

	if (n_item == 1)
	{
		create_relation(rel_repre_by, Partrev, revs[0]);
		Inge_copy_atr(revs[0], Partrev);
	}
	else if (n_item > 1)
	{
		for (int i = 0; i < n_item; i++)
		{

			//if 
			create_relation(rel_repre_by, Partrev, revs[i]);
			Inge_copy_atr(revs[i], Partrev);
		}
	}
	
		
}


int GetAttr(char* attr,int polozka_num)
{
	if (debug)printf("Get Attr %d \n attr %s %d\n",Attr_num, attr, polozka_num);
	int num=0;
	for (int i=1;i<Attr_num+1;i++)
	{
		if (debug)printf("%d ) attr %s =? attr_type pol %s|| %s \n",i,attr,Attr_type[polozka_num][i],Attr[polozka_num][i]);
		if (strcmp(Attr[polozka_num][i],attr)==0)
		{
			if(debug)printf("%d ) attr %s =? attr_type pol %s| %s \n",i,attr,Attr_type[polozka_num][i],Attr[polozka_num][i]);
			return i;
			
			/* if ((strcmp(Attr_type[polozka_num][i],attr)==0) || (strlen(Attr_type[polozka_num][i])==))
			{
				if (debug)printf("%d ) attr %s =? attr_type pol %s| %s \n",i,attr,Attr_type[polozka_num][i],Attr[polozka_num][i]);
				if (debug)system("pause");
				return i;
			}*/
		}
	}
	return -1;

}

void ReadProperty(char* fileOption)
{
		printf(" Read Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char Path[50]="C:\\SPLM\\Apps\\Import\\";
	printf (" %d fileOption %s \n",__LINE__,fileOption);
	strcat(Path,fileOption);
	printf (" read file %s \n",Path);
//	system ("pause");
	    FILE* stream = fopen(Path, "r");
		printf("Open %s\n",Path);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		
		tmp=strtok(line,">");
		
		printf("line pred %s> \n",tmp);
		//system("pause");
		//tmp=strtok(NULL,"<");
		if (strcmp(tmp,"<polozka")==0)
		{
			Add_d_num[Type_num]=0;
			Add_num[Type_num]=0;
			Attr_num=0;
			Remove_line=0;
			printf("polozka %d \n",Attr_num);
			//system("pause");
			goto nextLine;
			
		}
		else if (strcmp(tmp,"<ItemType")==0)
		{	strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("ItemType attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
			Remove_line++;
		}
		else if(strcmp(tmp,"<string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("string attr %s \n",tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num],tmp);
		}
		else if (strcmp(tmp, "<uom_string") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if (strcmp(tmp, "<uom") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if(strcmp(tmp,"Rev:<string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("string attr %s \n",tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num],tmp);
		}
		else if (strcmp(tmp, "Rev:<uom_string") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if(strcmp(tmp,"<int")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("int attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"Rev:<int")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("int attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<double")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"Rev:<double")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<date")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("date attr %s %d %d \n",tmp,Type_num,Attr_num);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"Rev:<date")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("date attr %s %d %d \n",tmp,Type_num,Attr_num);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<folder")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("folder attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			strcpy(Attr[Type_num][Attr_num],tmp);
			Remove_line++;
			//tmp=strtok(
		}else if(strcmp(tmp,"<copy_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(from_copy,strtok(tmp,"#"));
				printf("from %s \n",from_copy);
			strcpy(to_copy,strtok(NULL,"#"));
				printf("to %s \n",to_copy);
				Remove_line++;
			//tmp=strtok(
		}else if(strcmp(tmp,"ItemRev:<copy_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(from_copy,strtok(tmp,"#"));
				printf("from %s \n",from_copy);
			strcpy(to_copy,strtok(NULL,"#"));
				printf("to %s \n",to_copy);
			strcpy(Attr[Type_num][Attr_num],tmp);
				Remove_line++;
			//tmp=strtok(
		}
		else if(strcmp(tmp,"RevRev:<copy_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(from_copy,strtok(tmp,"#"));
				printf("from %s \n",from_copy);
			strcpy(to_copy,strtok(NULL,"#"));
				printf("to %s \n",to_copy);
			strcpy(Attr[Type_num][Attr_num],tmp);
				Remove_line++;
			//tmp=strtok(
		}
		else if(strcmp(tmp,"RevItem:<copy_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(from_copy,strtok(tmp,"#"));
				printf("from %s \n",from_copy);
			strcpy(to_copy,strtok(NULL,"#"));
				printf("to %s \n",to_copy);
			strcpy(Attr[Type_num][Attr_num],tmp);
				Remove_line++;
			//tmp=strtok(
		}

		else if(strcmp(tmp,"<add_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf(">>>copy_string attr %s - %d %d \n",tmp,Type_num, Add_num[Type_num]);
			
			//printf(">>>value %s \n",tmp);
			strcpy(to_add,strtok(tmp,"#"));
			//	printf(">>>to add %s \n",to_add);
			strcpy(from_add[Add_num[Type_num]++],strtok(NULL,"#"));
				//printf(">>>from add %d = %s \n",Add_num,to_copy);
				
				if(Add_num[Type_num]>1)
				{
					//printf(">>>goto num %d \n",Add_num[Type_num]);
					goto nextLine;
				}
				else
				{
					//printf(">>>Remove_line num %d \n",Add_num[Type_num]);
					Remove_line++;
				}
			//tmp=strtok(
		}else if(strcmp(tmp,"Rev:<add_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf(">>>copy_string attr %s - %d %d \n",tmp,Type_num, Add_num[Type_num]);
			
			//printf(">>>value %s \n",tmp);
			strcpy(to_add,strtok(tmp,"#"));
			//	printf(">>>to add %s \n",to_add);
			strcpy(from_add[Add_num[Type_num]++],strtok(NULL,"#"));
				//printf(">>>from add %d = %s \n",Add_num,to_copy);
				
				if(Add_num[Type_num]>1)
				{
					//printf(">>>goto num %d \n",Add_num[Type_num]);
					goto nextLine;
				}
				else
				{
					//printf(">>>Remove_line num %d \n",Add_num[Type_num]);
					Remove_line++;
				}
			//tmp=strtok(
		
		}else if(strcmp(tmp,"Rev:<add_value_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("string attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}
		else if(strcmp(tmp,"<add_double_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf(">>>copy_double_string attr %s - %d %d \n",tmp,Type_num, Add_d_num[Type_num]);
			
			printf(">>>value %s \n",tmp);
			strcpy(to_add,strtok(tmp,"#"));
				printf(">>>to add %s \n",to_add);
			strcpy(from_add[Add_d_num[Type_num]++],strtok(NULL,"#"));
				printf(">>>from add %d = %s \n",Add_d_num,to_copy);
				
				if(Add_d_num[Type_num]>1)
				{
					//printf(">>>goto num %d \n",Add_d_num[Type_num]);
					goto nextLine;
				}
				else
				{
					//printf(">>>Remove_line num %d \n",Add_d_num[Type_num]);
					Remove_line++;
				}
			//tmp=strtok(
		}
		else if(strcmp(tmp,"<set_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("set_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(attr_set[Type_num],strtok(tmp,"#"));
				printf("attr %s \n",attr_set);
			strcpy(value_set[Type_num],strtok(NULL,"#"));
				printf("value %s \n",value_set);
				printf ("\n SET String %s   %s \n \n",attr_set,value_set);
				Remove_line++;
			//tmp=strtok(
		}
		else if(strcmp(tmp,"Rev:<set_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("set_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(attr_set[Type_num],strtok(tmp,"#"));
				printf("attr %s \n",attr_set);
			strcpy(value_set[Type_num],strtok(NULL,"#"));
				printf("value %s \n",value_set);
				printf ("\n SET String %s   %s \n \n",attr_set,value_set);
				Remove_line++;
			//tmp=strtok(
		}
		else if(strcmp(tmp,"<exist")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("exist %s \n",tmp);
			strcpy(QueryExistenece[Type_num],strtok(tmp,"#"));
				printf("query %s \n",QueryExistenece[Type_num]);
			strcpy(EntryExistenece[Type_num],strtok(NULL,"#"));
				printf("entry %s \n",EntryExistenece[Type_num]);
			strcpy(AttryExistenece[Type_num],strtok(NULL,"#"));
				printf("attr query existence %s \n",AttryExistenece[Type_num]);
				Remove_line++;
			//tmp=strtok(
		}else if(strcmp(tmp,"<nowritte")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
		//	printf("noread \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}
				else if(strcmp(tmp,"<login")==0)
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
		else if(strcmp(tmp,"<importFolder")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("import file %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(import_file,tmp);

			goto nextLine;

		}
		//else if(strcmp(tmp,"<inside")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	tmp=strtok(NULL,"<");
		//	printf("inside \n",tmp);
		//	Attr_Typ_polozky=Attr_num;

		//}
		else if(strcmp(tmp,"</polozka")==0)
		{
			//printf("polozka konec \n");
			Type_num++;
			goto nextLine;
		}
		else goto nextLine;


		tmp=strtok(NULL,">");

		/*if( strcmp(tmp,"<TPV2000")==0)
		{
			tmp=strtok(NULL,"<");
			printf("TPV attr %s \n",tmp);
			strcpy(Attr_tpv[Type_num][Attr_num],tmp);

		}*/
		printf("konec %s %d\n",tmp,Attr_num);
		

	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//tmp=strtok(NULL,">");
		Attr_num++;
		nextLine:;
			}


//}
printf("-----Attr_num %d -----\n",Attr_num);
}
void changeOwnership(tag_t obj)
{
	if (debug)printf("L:%d changeOwnership \n",__LINE__),system("pause");
	tag_t user1Tag;
	int ifail = 0;
	tag_t owner_tag = NULLTAG;
	tag_t ownerGroup_tag = NULLTAG;
	ifail = AOM_ask_owner(obj, &user1Tag);
	printf("owning user is %d\n", user1Tag);
	AOM_refresh(obj, NULLTAG);
	if (debug)printf("L:%d owner %s group %s \n", __LINE__, owner,ownerGroup), system("pause");
	if (strlen(owner) > 1)
	{
		//POM_string_to_tag(owner, &owner_tag);
		SA_find_user2(owner, &owner_tag);
		SA_find_group(ownerGroup, &ownerGroup_tag);
		//POM_string_to_tag(ownerGroup, &ownerGroup_tag);
		//SA_ask_user_login_group(owner, &ownerGrup);
	}
	if (debug)printf("L:%d owner_tag %d group %d \n", __LINE__, owner_tag, ownerGroup_tag), system("pause");
	if (owner != NULLTAG && ownerGroup_tag != NULLTAG)
	{
		ITK_set_bypass(true);
		//printf("vlastneno %s \n", Owner(seznam[p].uzelRev));
		 IFERR_REPORT(AOM_set_ownership(obj, owner_tag, ownerGroup_tag));
		
		//AOM_set_ownership(IRev, owner_tag, ownerGroup_tag);
		//printf("vlastneno %s \n", Owner(seznam[p].uzelRev));
		AOM_save(obj);
		//AOM_save(IRev);
		ITK_set_bypass(false);

	}
	ifail = AOM_ask_owner(obj, &user1Tag);
	printf("owning user is %d\n", user1Tag);
	if (debug)system("pause");
			
				/*printf("\n PUID id is %s \n", iuid[i]);
				ifail = POM_string_to_tag(iuid[i], &uidTag);
				if (ifail != ITK_ok) return ifail;

				ifail = POM_class_of_instance(uidTag, &uidClassTag);
				if (ifail != ITK_ok) return ifail;


				ifail = POM_name_of_class(uidClassTag, &uidClassName);
				if (ifail != ITK_ok) return ifail;

				ifail = POM_attr_exists("object_name", uidClassName, &exists);
				if (ifail != ITK_ok) return ifail;
				if (exists == TRUE)

				{

					ifail = AOM_ask_value_string(uidTag, "item_id", &propVal);
					if (ifail != ITK_ok) return ifail;
					ifail = AOM_ask_value_string(uidTag, "object_name", &propVal1);
					printf("\n item id is %s object name is %s\n", propVal, propVal1);
				}

				ifail = AOM_ask_group(uidTag, &owning_groupTag);
				printf("owning group is %d\n", owning_groupTag);

				ifail = AOM_ask_owner(uidTag, &owning_userTag);
				printf("owning user is %d\n", owning_userTag);

				ifail = SA_find_user2("u3", &userTag);
				printf("user is %d\n", userTag);

				ifail = AOM_set_ownership(uidTag, userTag, owning_groupTag);
				if (ifail != ITK_ok) return ifail;

				ifail = AOM_ask_owner(uidTag, &user1Tag);
				printf("owning user is %d\n", user1Tag);

				if (propVal != NULL) MEM_free(propVal);
				if (propVal != NULL) MEM_free(propVal1);
			*/

		
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

static void SetMeasurment(char* uom_name, tag_t item)
{

	char
		*name;
	tag_t
		
		uom,
		*uom_list = NULL;

	UOM_find_by_symbol(uom_name, &uom);
//	ITEM_find_item(ITEM_ID, &item);
	if (debug)printf("L: %d item %d tag uom %d uom_name %s \n", __LINE__, item, uom, uom_name), system("pause");
	ITEM_set_unit_of_measure(item, uom);
	AOM_save(item);

	ITEM_ask_unit_of_measure(item, &uom);
	AOM_ask_name(uom, &name);
	printf("\nAfter ITEM_set_unit_of_measure - %s\n", name);
	if (debug)printf("L: %d  \n", __LINE__), system("pause");
	if (name) MEM_free(name);
}
void MoveTPToFolder(tag_t folder,tag_t object)
{ 
   //insert to folder
	if(debug)
	{
		printf ("vkladam do folderu %d folder objekt %d \n",folder,object);
		system("pause");
	}
    AOM_refresh( folder, TRUE);
    FL_insert(folder, object, 0);
	
	AOM_save_with_extensions(folder);
    AOM_refresh( folder, TRUE);
	if (debug) printf("vlozeno!!!!!!!!!!!\n");
}
void IntoFolder(char* folderName,tag_t Item)
{
					tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find2("General...", &query);
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
void copy_int(char* attr, tag_t zdroj, tag_t cil)
{
	int tmp_value;
	AOM_ask_value_int(zdroj, attr, &tmp_value);
	AOM_set_value_int(cil, attr, tmp_value);
	AOM_save_without_extensions(cil);
}
void copy_double(char* attr, tag_t zdroj, tag_t cil)
{
	double tmp_value;
	AOM_ask_value_double(zdroj, attr, &tmp_value);
	AOM_set_value_double(cil, attr, tmp_value);
	AOM_save_without_extensions(cil);
}

void copy_string(char* attr, tag_t zdroj, tag_t cil)
{
	char* tmp_value;
	ERROR_CHECK(AOM_ask_value_string(cil, attr, &tmp_value));
	if (debug)printf("L:%d cil tmp_value %s \n", __LINE__, tmp_value);
	ERROR_CHECK(AOM_ask_value_string(zdroj, attr, &tmp_value));
	if (debug)printf("L:%d zdroj tmp_value %s \n", __LINE__, tmp_value);
	ERROR_CHECK(AOM_set_value_string(cil, attr, tmp_value));
	//ERROR_CHECK(AOM_save_without_extensions(cil));
}
void copyObjectName(tag_t itemrevize)
{
	printf("L: %d change object_namen \n", __LINE__);
	tag_t revizion = NULLTAG;
	ERROR_CHECK(ITEM_ask_latest_rev(itemrevize, &revizion));
	ERROR_CHECK(AOM_lock(itemrevize));
	copy_string("object_name", itemrevize, revizion);
	ERROR_CHECK(AOM_save_with_extensions(itemrevize));
	ERROR_CHECK(AOM_unlock(itemrevize));
	

 }

void Inge_copy_atr(tag_t designRev,tag_t PartRev)
{
	AOM_lock(designRev);
	
	copy_string("tpv4_AutorSys", PartRev, designRev); // String
	copy_string("tpv4_KlicTPV", PartRev, designRev); // Integer
	copy_string("tpv4_MaterialJakost", PartRev, designRev); // String
	copy_string("tpv4_MJ", PartRev, designRev); // String
	copy_string("tpv4_nazev2", PartRev, designRev);  // String
	copy_string("tpv4_poznamka", PartRev, designRev); // String
	copy_double("tpv4_SkladMnozstvi1", PartRev, designRev); // Double
	copy_double("tpv4_SkladMnozstvi2", PartRev, designRev); // Double
	copy_string("tpv4_SkladovyProces", PartRev, designRev); // String
	copy_string("tpv4_SkupinaZbozi", PartRev, designRev); // String
	copy_string("tpv4_sortiment", PartRev, designRev); // String
	copy_string("tpv4_StareCV", PartRev, designRev); // String
	copy_string("tpv4_SZ", PartRev, designRev); // String
	copy_string("tpv4_polotovar", PartRev, designRev); // String
	copy_string("tpv4_RegCisCele", PartRev, designRev); // String)

	AOM_save_with_extensions(designRev);
			AOM_unlock(designRev);
			

}
void SetProperty (int polozka_num,int num,tag_t object_type,char* value)
{
	printf("\n _____\n SetProperty >>>%s \n %d %d \n",Attr_type[polozka_num][num],polozka_num,num);
	
	char typ_polozky[20];
	strcpy(typ_polozky,Attr_type[polozka_num][num]);
	tag_t object_item = object_type;
	char*type_imput_item;
	char* tmp=strtok(typ_polozky,":");
	printf ("tmp %s \n",tmp);
	printf("value %s \n",value);
	//printf("attr-1 %s \n",Attr[polozka_num][num-1]);
	printf("attr %s \n",Attr[polozka_num][num]);
	printf("typ_polozky %s \n",typ_polozky);
	ITEM_ask_type2(object_type, &type_imput_item);
	printf("L:%d typ itemu %s \n", __LINE__, type_imput_item);
	if (strcmp(tmp, "Rev") == 0)
	{

		tag_t rev = NULLTAG;
		int err=ITEM_ask_latest_rev(object_type, &rev);
		printf("je ren tag rev %d tag item %d \n", rev, object_type);
		if (rev == 0)
		{
			if (debug) printf("L:%d err ask rev %d \n", __LINE__, err),system("pause");
			return;
		}
		else
		 object_type=rev;
		
		strcpy(typ_polozky,strtok(NULL," "));
		
		AOM_lock(rev);

	}
	else {
		ERROR_CHECK(AOM_lock(object_type));
		printf("neni rev obj %d \n", object_type);
	}
	if(strcmp(typ_polozky,"<string")==0)
	{
		//value=OpravCz(value);
		if(debug) printf ("obj_type %d attr %s value %s \n",object_type,Attr[polozka_num][num],value);
		ERROR_CHECK(AOM_set_value_string(object_type,Attr[polozka_num][num],value));
		
	}
	else if (strcmp(typ_polozky, "<uom") == 0)
	{
		if (debug)printf("L: %d uom value %s \n", __LINE__, value), system("pause");
		//value=OpravCz(value);
		if (strcmp(value, "ks") != 0)
		{
			if (debug)printf("L: %d neni ks \n", __LINE__), system("pause");
			SetMeasurment(value, object_item);
		}
	}
	else if (strcmp(typ_polozky, "<uom_string") == 0)
	{
		if (debug)printf("L: %d uom_string value %s \n", __LINE__, value), system("pause");
		//value=OpravCz(value);
		if (strcmp(value,"ks")!=0)
		{ 
			if (debug)printf("L: %d neni ks \n", __LINE__), system("pause");
				SetMeasurment(value, object_item);
		}

		if (debug) printf("obj_type %d attr %s value %s \n", object_type, Attr[polozka_num][num], value);
		ERROR_CHECK(AOM_set_value_string(object_type, Attr[polozka_num][num], value));

	}
	else if(strcmp(typ_polozky,"<add_value_string")==0)
	{
		char *puvodni;
		ERROR_CHECK(AOM_ask_value_string(object_type,Attr[polozka_num][num],&puvodni));
		char vysledna[128];
		int delka=strlen(puvodni);
		if((strcmp(value,puvodni)>0 || delka <2) && strcmp(value,"null")!=0)
		{

			strcpy(vysledna,puvodni);
			if(strlen(puvodni)>2)
				strcat(vysledna,";");
			strcat(vysledna,value);
			ERROR_CHECK(AOM_set_value_string(object_type,Attr[polozka_num][num],vysledna));
		}//else// ERROR_CHECK(AOM_set_value_string(object_type,Attr[polozka_num][num],""));
	}
	else if(strcmp(typ_polozky,"<int")==0)
	{
		int tmp_int=atoi(value);
		printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		if(strcpy(value," ")!=0 && tmp_int>0)
			ERROR_CHECK(AOM_set_value_int(object_type,Attr[polozka_num][num],tmp_int));
	}
	else if(strcmp(typ_polozky,"<double")==0)
	{
		double tmp_double=atof(value);
		printf ("double attr %s \n v= %s dv=%f\n",Attr[polozka_num][num],value,tmp_double );
		if(strcpy(value," ")!=0)
			ERROR_CHECK(AOM_set_value_double(object_type,Attr[polozka_num][num],tmp_double));
	}
	else if(strcmp(typ_polozky,"<date")==0)
	{
		printf("date valeu %s \n",value);
		date_t datum;
		datum.year=atoi(strtok(value,"-"));
		datum.month=atoi(strtok(NULL,"-"));
		datum.day=atoi(strtok(NULL," "));
		datum.hour=atoi(strtok(NULL,":"));
		datum.minute=atoi(strtok(NULL,":"));
		datum.second=atoi(strtok(NULL,"."));
		
		printf("\n------\n %d-%d-%d %d:%d:%d \n----\n",datum.year,datum.month,datum.day,datum.hour,datum.minute,datum.second);
		ERROR_CHECK(AOM_set_value_date(object_type,Attr[polozka_num][num],datum));
	}
	else if(strcmp(typ_polozky,"<nowritte")==0)
		printf ("--nic\n");
	else if(strcmp(typ_polozky,"<folder")==0)
	{
		IntoFolder(Attr[polozka_num][num],object_type);
	}
	
	else if(strcmp(typ_polozky,"<copy_string")==0)
	{ 
		printf("from copy %s \n",tmp);
		char* tmp_text;
		tag_t rev =NULLTAG;
		ITEM_ask_latest_rev(object_type,&rev);
		if(strcmp(tmp,"RevRev")==0)
		{
			AOM_lock(rev);
			ERROR_CHECK(AOM_ask_value_string(rev,from_copy,&tmp_text));
			ERROR_CHECK(AOM_set_value_string(rev,to_copy,tmp_text));
			AOM_save_with_extensions(rev);
			AOM_unlock(rev);
		}else if (strcmp(tmp,"ItemRev")==0)
		{
			AOM_lock(rev);
			ERROR_CHECK(AOM_ask_value_string(object_type,from_copy,&tmp_text));
			printf ("from copy %s text %s \n",from_copy,tmp_text);
			ERROR_CHECK(AOM_set_value_string(rev,to_copy,tmp_text));
			AOM_save_with_extensions(rev);
			AOM_unlock(rev);
		}else if (strcmp(tmp,"RevItem")==0)
		{
			ERROR_CHECK(AOM_ask_value_string(rev,from_copy,&tmp_text));
			ERROR_CHECK(AOM_set_value_string(object_type,to_copy,tmp_text));
		}

	}
	else if(strcmp(typ_polozky,"<add_string")==0)
	{ char* tmp_text2,
			*tmp_text;
		char result [240];
		printf("<<<add_string %d\n",Add_num[polozka_num]);
		for(int i_num=0;i_num<Add_num[polozka_num];i_num++)
		{
			//printf("<<<add_string %d\n",i_num);
			ERROR_CHECK(AOM_ask_value_string(object_type,from_add[i_num],&tmp_text));
			//printf("<<<<read from %s \n",tmp_text);
			ERROR_CHECK(AOM_ask_value_string(object_type,to_add,&tmp_text2));
			strcpy (result,tmp_text2);
			strcat(result,"|");
			strcat(result,tmp_text);
			//printf("<<<<coping %s \n",result);
			ERROR_CHECK(AOM_set_value_string(object_type,to_copy,result));
			//printf("<<<<coped \n");
		}
	}
	else if(strcmp(typ_polozky,"<add_double_string")==0)
	{ char* tmp_text2,
			tmp_text[15];
		double	tmp_double;
		char result [240];
		printf("<<<add_double_string %d\n",Add_d_num[polozka_num]);
		for(int i_num=0;i_num<Add_d_num[polozka_num];i_num++)
		{
			//AOM_ask_value_double()
			//printf("<<<add_string %d\n",i_num);
			ERROR_CHECK(AOM_ask_value_double(object_type,from_add[i_num],&tmp_double));
			sprintf(tmp_text,"%.03f",tmp_double);
			printf("<<<<read from %s \n",tmp_text);
			ERROR_CHECK(AOM_ask_value_string(object_type,to_add,&tmp_text2));
			strcpy (result,tmp_text2);
			strcat(result,"|");
			strcat(result,tmp_text);
			printf("<<<<coping %s \n",result);
			ERROR_CHECK(AOM_set_value_string(object_type,to_copy,result));
			//printf("<<<<coped \n");
		}
	}
	else if(strcmp(typ_polozky,"<set_string")==0)
	{ 
		char* tmp_text;
		
		ERROR_CHECK(AOM_set_value_string(object_type,attr_set[polozka_num],value_set[polozka_num]));
		
	}else printf ("Neodpovida nicemu !!!!\n");

	ERROR_CHECK(AOM_save_with_extensions(object_type));
	ERROR_CHECK(AOM_unlock(object_type));
	
//printf("TypPolozky_num %d t %d IRev %d hodnoty [%d] %s \n Attr_type[%d][%d] %s \n Attr[%d][%d] %s \n \n",polozka_num,num,object_type,num,value,polozka_num,num,Attr_type[polozka_num][num],polozka_num,num,Attr[polozka_num][num]);
}

int test_white_space (char c)
{
	  int  result = isspace(c);
	  printf("char is = |%c| ", c);
	  if (result == 0)
	  {
		  printf("Not a white-space character.");
		  return 0;
	  }
	  else if (c == ' ')
	  {
		  printf("White-space character.");
		  return 1;
	  }
    else
    {
        printf("White-space character.");
		return 1;
    }

    return 0;
}

bool only_whitespace( char text[],int n)
{
	int test=0;
	
	for (int i =0;i<n;i++)
	{
		printf("i=%d \n", i);
		if (test_white_space(text[i])==0)
			return false;

	}
	return true;
}

tag_t Create(char hodnoty[50][1024],int TypPolozky_num){
	printf("---Create \n");
		tag_t Item = NULLTAG;
		tag_t IRev = NULLTAG;
		tag_t itemType = NULLTAG;
		tag_t revType = NULLTAG;
		tag_t createItem = NULLTAG;
		tag_t createRev = NULLTAG;
		char typRevize[20],
			typItem[20];
	//revise
		strcpy(typRevize,Attr[TypPolozky_num][0]);
		strcat(typRevize,"Revision");
		//strcpy(typItem,"H4_NakupovanyMat"),
		strcpy(typItem,Attr[TypPolozky_num][0]);

		TCTYPE_find_type(typRevize, NULL, &revType);
		if (revType == NULLTAG) {
			printf("Spatny typ revize");
		}
		printf("Tag rev itemu %d \n", revType);
		TCTYPE_construct_create_input(revType, &createRev);

		
		if (Existence(hodnoty, typRevize, TypPolozky_num) == 1)
		{
			tag_t KPRev = NULLTAG;
			printf("-------------Created__new __item-----------------\n");
			//itemy
			TCTYPE_find_type(typItem, NULL, &itemType);
			printf("Tag itemu %d \n", itemType);
			TCTYPE_construct_create_input(itemType, &createItem);

			//set attribute
			AOM_set_value_tag(createItem, "revision", createRev);
			if (debug) {
				printf("construkt item tag %d rev tag %d \n", createItem, createRev);
				system("pause");
			}
			int num_name = GetAttr("object_name", TypPolozky_num);
			if (num_name == -1)
			{
				printf("chyba pozadovaneho atributu \n");
				goto end;
			}
			else
				strncpy(hodnoty[num_name], hodnoty[num_name], 124);

			printf ("%d obj name %s \n",num_name,hodnoty[num_name]);
			ERROR_CHECK(AOM_set_value_string(createItem, "object_name",hodnoty[num_name]));
			int num_id=GetAttr("item_id",TypPolozky_num);
			if(debug)
			{
				printf( " %d id number %d hodnota %s \n",__LINE__,num_id,hodnoty[num_id]);
				system("pause");
			}
			if (InEko_HCV)
			{

			}
			if (num_id != 0)
			{
				
				if (num_id == -1)goto whitout_id;
				
				int delka = strlen(hodnoty[num_id]);
				printf("delka id %d \n hodnota %s \n", delka, hodnoty[num_id]);

				if (delka == 0)goto end;
				if (only_whitespace(hodnoty[num_id], delka))goto end;
				if (debug) system("pause");
				char* tmp_id = strtok(hodnoty[num_id], "  ");
				printf("delka id %d delka tmp_id\n", strlen(hodnoty[num_id]), strlen(tmp_id));
				
				ERROR_CHECK(AOM_set_value_string(createItem, "item_id", tmp_id));
				if (strlen(tmp_id) == 10 && (strncmp(hodnoty[num_id], "VD", 2) == 0) && Inge)
				{
					char *id_tok = strtok(tmp_id, "V");
					if (debug)
					{
						printf("tmp_id %s tmp_tok %s\n", tmp_id, id_tok);
						system("pause \n");
					}
					tag_t KPItem;
					ITEM_find_item(id_tok, &KPItem);
					ITEM_ask_latest_rev(KPItem, &KPRev);
					create_relation(rel_repre_by, createRev, KPRev);
					//	Inge_connect_part_rev(tag_t rev)
				}
				else if (Inge)
				{
					Inge_connect_part_rev(createRev, tmp_id);
					
				}
				
				else if (debug)
				{
					printf("nespojuji  %s - %d\n",tmp_id,delka);
					system("pause");
				}
			}
		whitout_id:;
			TCTYPE_create_object(createItem, &Item);
			TCTYPE_create_object(createRev, &IRev);
			int ReturnCode = AOM_save_with_extensions(Item);
			if (debug && ReturnCode) printf ("line %d chyba %d \n", __LINE__,ReturnCode);
			
			
			if (debug) 
			{
				printf (" Create item %d rev %d \n",Item,IRev);
				system("pause");

			}

			int num=GetAttr("<folder",TypPolozky_num);
			if(debug)printf ("%d folder %s\n",num,Attr[TypPolozky_num][num]);
			//SetProperty (TypPolozky_num,num,Item,hodnoty[num]);//pøesun do folderu
			AOM_save_with_extensions(Item);
			AOM_lock(Item);
			ITK_set_bypass(true);
			for (int i=1;i<Attr_num-1;i++)
			{
				if(i!=num_name)
				SetProperty(TypPolozky_num,i,Item,hodnoty[i]);//hodnota 1 se rovna vlastnosti 2
			}
			if (InEko)
			{
				//int klic_tpv;
				//ERROR_CHECK(AOM_ask_value_int(createItem, "tpv4_KlicTPV", &klic_tpv));
			//	InEko_connect_part_rev(createRev, klic_tpv);
			
			}
			ITK_set_bypass(false);
				//int IERROR=AOM_set_value_string(Item,"tpv4_stav_polozky","Neopravena z ERP");
				//printf ("Err %d string attr \n",IERROR);
			AOM_save_with_extensions(Item);
			AOM_unlock(Item);

			////change Owner
			//tag_t owner_tag= NULLTAG;
			//tag_t ownerGroup_tag= NULLTAG;
			//if (strlen(owner) > 1)
			//{
			//	POM_string_to_tag(owner, &owner_tag);
			//	POM_string_to_tag(ownerGroup, &ownerGroup_tag);
			//	//SA_ask_user_login_group(owner, &ownerGrup);
			//}
			//if (owner != NULLTAG && ownerGroup_tag != NULLTAG)
			//{
			//	ITK_set_bypass(true);
			//	//printf("vlastneno %s \n", Owner(seznam[p].uzelRev));
			//	AOM_set_ownership(Item, owner_tag, ownerGroup_tag);
			//	AOM_set_ownership(IRev, owner_tag, ownerGroup_tag);
			//	//printf("vlastneno %s \n", Owner(seznam[p].uzelRev));
			//	AOM_save(Item);
			//	AOM_save(IRev);
			//	ITK_set_bypass(false);

			//}
			if (debug)printf("L:%d changeOwnership\n", __LINE__), system("pause");
			changeOwnership(IRev);
			changeOwnership(Item);
			//changeOwnership(IRev);

			if(Inge && KPRev!=NULLTAG)
			{
				if (debug)
				{
					printf("spojuji  %d s %d  \n",IRev,KPRev);
					system("pause");
				}
				create_relation("TC_Is_Represented_By",IRev,KPRev);
			}
		}else 
		{
			if (debug)
			{
				printf("existuje polozka \n");
				system("pause");
			}
			
		}
			
	end:;
		return IRev;
}
const char* getfield(char* line, int num)
{
    const char* tok;
	for (tok = strtok(line, "#");
            tok && *tok;
			tok = strtok(NULL, "#\n"))
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
char* create_marks_csv(char *filename, int m, int n,char Nazvy[1][10][150]) {

	printf("\n Creating %s.csv file \n", filename);

	FILE *fp;

	int i, j;
	char file[50];
	strcpy(file, "C:\\SPLM\\Apps\\Import\\Update_HCV\\");
	strcat(file, filename);
	//printf("test1 \n");
	strcat(file, ".csv");
	//printf("file %s \n",file);



	fp = fopen(file, "w");
	printf("test po zaèátku zápisu %d \n", fp);
	//fprintf(fp,attr);

	for (i = 0; i < m; i++)
	{
		printf("fprint %d \n", i);
		if (i == 0)
			fprintf(fp, "Vyrobek#NazevVyrobku#DatZmeny#Status#ID\n");
		//"ItemID#ItemRevisionID#ID#SZ#SkupinaZboz#RegCisCele#RegCis#Nazev#Nazev2#MaterialJakost#RozmerNorma#Dodavatel#KatCisloDod#Poznamka#Atribut1#Atribut2#Atribut3#Objem#Plocha#Hmotnost#Hustota#PovOchrana#Polotovar#MJ#StareCV#SkladovyProces#KodPrvotniOpearace#SkladMnozstvi1#SkladMnozstvi2#KlicTPV#Autor#Pozice#Mnozstvi#ItemIDVyssi#ItemIDMaterial#Dokument1#Dokuemnt2#Datum"			
		else
		{
			fprintf(fp, "\n");
		}
		for (j = 0; j <= n; j++)
		{
			if (j == 0)
				fprintf(fp, "%s", Nazvy[i][j]);
			else
				fprintf(fp, "#%s", Nazvy[i][j]);
			printf("# %s", Nazvy[i][j]);
		}
		//	fprintf(fp,"#0000000");	
	}
	//fprintf(fp,"\n%d",i+1);
	fclose(fp);

	printf("\n file created - %s \n", file);
	return file;
}
void CallBridge(char* file)
{
	char help[50];
	strcpy(help, file);
	printf("file %s \n", help);
	//char ImportTPV[256]="C:\\TC4TPV\\TCCom\\TCCom.jar \"";
	char ImportTPV[256] = "call C:\\SPLM\\Apps\\Import\\TC2HCV.bat \"C:\\SPLM\\Apps\\Import\\Update_HCV\\";
	strcat(ImportTPV, help);
	strcat(ImportTPV, ".csv");
	strcat(ImportTPV, "\"");
	//printf("%s \n",ImportTPV);
	system(ImportTPV);

	//	system("call C:\\TC4TPV\\TCCom\\run.bat");
	printf("%s\n", ImportTPV);
	//system("call TC2TPV.bat");
	if (debug)system("pause");
}
void RepareOwership(char* string, int nastavenyTyp)
{
	char hodnoty[50][1024];
	int typ = nastavenyTyp;
	char ID_test[5];
	char typRevize[20];

	for (int i = 2; i <= Attr_num - Remove_line; i++)
	{
		
		strcpy(hodnoty[i], strtok(NULL, "#"));
		printf(" %d Field  %s\n\n", i, hodnoty[i]);
		if (InEko_HCV)
		{
			int num_id_HCV = GetAttr("tpv4_ID", nastavenyTyp);
			if (i == num_id_HCV)
				strcpy(ID_test, hodnoty[i]);
			printf("L:%d ID number %d hodnota %s \n", __LINE__, num_id_HCV, ID_test);
			//system("pause");
		}

	}
	strcpy(typRevize, Attr[nastavenyTyp][0]);
	strcat(typRevize, "Revision");
	Existence(hodnoty, typRevize, nastavenyTyp);
}

void ReadCSV(char* string, int nastavenyTyp)
{
	char *tmp;
	char ID_test[5];
	int typ = nastavenyTyp;
	//	char *tmp_field;
	
		

	char hodnoty[50][1024];
	//printf("string %s \n",string);
	printf("Attr_num %d Remove %d \n", Attr_num, Remove_line);
	for (int t = 0; t < 20; t++)
		strcpy(hodnoty[t], " ");
	//int i=1;
	tmp = strdup(string);
	strcpy(hodnoty[1], strtok(string, "#"));
	printf(" %d Field  %s\n\n", 1, hodnoty[1]);

	for (int i = 2; i <= Attr_num - Remove_line; i++)
	{
		
		strcpy(hodnoty[i], strtok(NULL, "#"));
		printf(" %d Field  %s\n\n", i, hodnoty[i]);
		if (InEko_HCV)
		{
			int num_id_HCV = GetAttr("tpv4_ID", nastavenyTyp);
			if (i == num_id_HCV)
				strcpy(ID_test, hodnoty[i]);
			printf("L:%d ID number %d hodnota %s \n", __LINE__, num_id_HCV, ID_test);
			//system("pause");
		}

	}
	tag_t zalozenaRev = Create(hodnoty, nastavenyTyp);
	if (InEko_HCV && zalozenaRev != NULLTAG)
	{
		//"Vyrobek#NazevVyrobku#DatZmeny#Status#ID
		tag_t zalozenItem=NULLTAG;
		char update_HCV [1][10][150];
		char* tmp;
		char* id_hcv;
		char* rev_hcv;
		ITEM_ask_item_of_rev(zalozenaRev, &zalozenItem);
		ITEM_ask_id2(zalozenItem, &id_hcv);
		AOM_ask_value_string(zalozenaRev, "item_revision_id", &rev_hcv);
		strcpy(update_HCV[0][0], "Vyrobek = \'");
		strcat(update_HCV[0][0], id_hcv);
		strcat(update_HCV[0][0], "\'");

		ITEM_ask_name2(zalozenItem, &tmp);
		strcpy(update_HCV[0][1],"NazevVyrobku = \'");
		strcat(update_HCV[0][1], tmp);
		strcat(update_HCV[0][1], "\'");
		
		strcpy(update_HCV[0][2], "DatZmeny = \'");
		strcat(update_HCV[0][2], time_stamp());
		strcat(update_HCV[0][2], "\'");


		strcpy(update_HCV[0][3], "Status = ");
		strcat(update_HCV[0][3], "1");

		int ID = 0;
		AOM_refresh(zalozenaRev, FALSE);
		ERROR_CHECK(AOM_ask_value_int(zalozenaRev, "tpv4_ID", &ID));
		printf("L:%d ID %d tag zalozene rev %d \n", __LINE__, ID, zalozenaRev);

	
		
		sprintf(update_HCV[0][4], "WHERE ID = %s \n", ID_test);
		//system("pause");

		char file_name[WSO_name_size_c + 2] = "";

		for (int k = 0; k < strlen(id_hcv); k++)
			if (id_hcv[k] == ' ')id_hcv[k] = '_';
		strcpy(file_name, id_hcv);
		strcat(file_name, "_");
		strcat(file_name, rev_hcv);
		printf("L:%d \n", __LINE__);
		create_marks_csv(file_name, 1, 4, update_HCV);
		CallBridge(file_name);
	}
	if (zalozenaRev != NULLTAG)
	{
		if (debug)printf("L:%d changeOwnership Rev\n", __LINE__), system("pause");
		changeOwnership(zalozenaRev);
		AOM_save_without_extensions(zalozenaRev);
	}
		

		
	    //free(tmp);
		//free(tmp_field);
		
		/*free(hodnoty);*/
}

int main(int argc, char *argv[])
{
	//ReadProperty();
   
    // ITK inicializace
	printf("1\n");
	debug=false;
	Inge=false;
	InEko = false;
	InEko_HCV = false;

   if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }
	printf("2\n");
    ITK_initialize_text_services(0);
	printf("3\n");
	int typpolozky = 0;
	char*mode = ITK_ask_cli_argument("-m=");
	char*CSV = ITK_ask_cli_argument("-s=");
	char*TypImportu = ITK_ask_cli_argument("-i=");
	char *nastaveni_import = ITK_ask_cli_argument("-o=");
	char *propojeni = ITK_ask_cli_argument("-c=");
	

	if (mode != NULL)
		if (strcmp(mode, "debug") == 0)
			debug = true;

	if (propojeni != NULL)
		if (strcmp(propojeni, "Inge") == 0)
			Inge = true;
	if (propojeni != NULL)
		if (strcmp(propojeni, "InEko") == 0)
			InEko = true;
	if (propojeni != NULL)
		if (strcmp(propojeni, "InEko_HCV") == 0)
			InEko_HCV = true;

	ReadProperty(nastaveni_import);

	printf("\n \n4- Read Property \n");

    // Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
        fprintf(stderr, "ERROR: Login failed\n");
        return 1;
    }
    printf("Login OK\n");
	

	typpolozky=1;
	printf(" %d %s \n",__LINE__,CSV);
	char CSVFile[50];
	strcpy(CSVFile,"");
	printf("impoort file %s \n",import_file);
	strcpy(CSVFile,import_file);
	strcat(CSVFile,CSV);
	strcat(CSVFile,".csv");
	printf("CSVFile: %s \n",CSVFile);
	if(SouborExistuje(CSVFile)!=0){
		printf("file neexistuje \n");
		goto end;
	}else printf("soubor existuje\n");
	    FILE* stream = fopen(CSVFile, "r");

    char line[2048];
	int c=0;
    while (fgets(line, 2048, stream))
    {
		if (strchr(line, '#') != NULL)
		{
			ReadCSV(line, typpolozky - 1);
			
		}
			
      
    }

	end:;
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




int Existence(char hodnoty [20][1024],char* typ, int typ_pol_num)
	{
			int Vytvor=0;
			char* hledany_x=NULL,
				//* hledany_y=NULL,
			
			 Idd[ITEM_id_size_c + 1],
			 Namee[ITEM_name_size_c + 1];
			tag_t query=NULLTAG;
			tag_t* item=NULLTAG;
			int n_item=NULLTAG;
			//int ItemsCountt = 0;
			tag_t *Itemss = NULLTAG;
			printf("__________test__hledani__________ \n");
			printf("test hledani %s %s typ pol %d\n",typ,QueryExistenece[typ_pol_num],typ_pol_num);
			const char *Names[1] = { "object_type"};
			int num_id = GetAttr("item_id", typ_pol_num);
			 
				
				QRY_find2(QueryExistenece[typ_pol_num], &query);
				if (debug)
					{
						printf("tag hledani %s  je %d\n",QueryExistenece[typ_pol_num],query);
						printf("existence %s, AttryExistenece %s \n typ_pol_num %d \n", EntryExistenece[typ_pol_num],AttryExistenece[typ_pol_num],typ_pol_num);
						system("pause");
				}
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {EntryExistenece[typ_pol_num]};
				int num=GetAttr(AttryExistenece[typ_pol_num],typ_pol_num);
				char *values[1] =  {hodnoty[num]};				
				if (debug) printf("hodnota hledani %s delka %s ATTR %s\n",values[0],values[0],entries[0]);						
				QRY_execute(query, 1, entries, values, &n_item, &item);
				if (debug) printf("%d pocet nalezu %d erp_id %s typ pol %d \n Attr_num %d \n",num,n_item,hodnoty[num],typ_pol_num,Attr_num);
				if(n_item == 0)
					return 1;
				else
				{
					ITK_set_bypass(true);
					if (debug) 
					{
						printf("update atributu \n");
						system("pause");
					}
					AOM_lock(*item);
					printf("Attr_num %d \n", Attr_num-1);
					int folder_num=GetAttr("<folder",typ_pol_num);
					
					for (int t=1;t<Attr_num-1;t++)
					{
						tag_t item_vaa = NULLTAG;
						int err= ITEM_ask_item_of_rev(*item, &item_vaa);
						if(err) if (debug) printf("L:%d err ask item  %d \n", __LINE__, err), system("pause");
						printf("\n >folder_num %d num_id %d int t= %d item_tag=%d \n",folder_num, num_id,t, item_vaa);
						if (t != folder_num || t != num_id)
						{
							if (debug) printf("L: %d num_nam=%d t=%d hodnoty[t]=%s \n", __LINE__, num_id, t, hodnoty[t]);
							//if (t != num_name)
							{
								if (debug) printf("L: %d  \n", __LINE__);
								
								SetProperty(typ_pol_num, t, *item, hodnoty[t]);
								if (debug) printf("L: %d  \n", __LINE__);
							}

							if (strcmp(Attr[typ_pol_num][t], "object_name") == 0)
								copyObjectName(*item);
							
						}
					}
					AOM_save_with_extensions(*item);
					//AOM_save(*item);
					AOM_unlock(*item);
					if (InEko)
					{
						tag_t PartRev;
						ITEM_ask_latest_rev(*item, &PartRev);
						if (debug)printf("L:%d start_propojovani\n", __LINE__), system("pause");
						int klic_tpv;
						ERROR_CHECK(AOM_ask_value_int(PartRev, "tpv4_KlicTPV", &klic_tpv));
						if (debug)printf("L:%d \n", __LINE__);
						//InEko_connect_part_rev(PartRev, klic_tpv);
						changeOwnership(PartRev);

					}
					if (InEko_HCV)
					{
						char* id_hcv;
						char* rev_hcv;
						char file_name[WSO_name_size_c + 2] = "";
						tag_t zalozenItem = NULLTAG;

						ITEM_ask_item_of_rev(*item, &zalozenItem);
						ITEM_ask_id2(zalozenItem, &id_hcv);
						AOM_ask_value_string(*item, "item_revision_id", &rev_hcv);

						for (int k = 0; k < strlen(id_hcv); k++)
							if (id_hcv[k] == ' ')id_hcv[k] = '_';
						strcpy(file_name, id_hcv);
						strcat(file_name, "_");
						strcat(file_name, rev_hcv);
						printf("L:%d \n", __LINE__);
						//create_marks_csv(file_name, 1, 4, update_HCV);
						CallBridge(file_name);
					}
					changeOwnership(*item);
					ITK_set_bypass(false);
					return 0;
				}
}