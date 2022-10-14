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
		
		
		//tmp=strtok(NULL,"<");
		if (strcmp(tmp,"<polozka")==0)
		{
			Add_d_num[Type_num]=0;
			Add_num[Type_num]=0;
			Attr_num=0;
			Remove_line=0;
			printf("polozka %d \n",Attr_num);
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
			//printf("string attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}else if(strcmp(tmp,"<int")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("int attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<double")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<date")==0)
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
void SetProperty (int polozka_num,int num,tag_t object_type,char* value)
{
	printf(">>>%s \n",Attr_type[polozka_num][num]);
	if(strcmp(Attr_type[polozka_num][num],"<string")==0)
	{
		//value=OpravCz(value);
		int IERROR=AOM_set_value_string(object_type,Attr[polozka_num][num],value);
		printf ("Err %d string attr %s   %s \n",IERROR,Attr[polozka_num][num],value);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<int")==0)
	{
		int tmp_int=atoi(value);
		printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		if(strcpy(value," ")!=0)
			AOM_set_value_int(object_type,Attr[polozka_num][num],tmp_int);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<double")==0)
	{
		double tmp_double=atof(value);
		printf ("double attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_double );
		if(strcpy(value," ")!=0)
			AOM_set_value_double(object_type,Attr[polozka_num][num],tmp_double);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<date")==0)
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
		AOM_set_value_date(object_type,Attr[polozka_num][num],datum);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<nowritte")==0)
		printf ("--nic\n");
	else if(strcmp(Attr_type[polozka_num][num],"<folder")==0)
	{
		IntoFolder(Attr[polozka_num][num],object_type);
	}
	
	else if(strcmp(Attr_type[polozka_num][num],"<copy_string")==0)
	{ char* tmp_text;

	AOM_ask_value_string(object_type,from_copy,&tmp_text);
	AOM_set_value_string(object_type,to_copy,tmp_text);

	}
	else if(strcmp(Attr_type[polozka_num][num],"<add_string")==0)
	{ char* tmp_text2,
			*tmp_text;
	char result [240];
	printf("<<<add_string %d\n",Add_num[polozka_num]);
	for(int i_num=0;i_num<Add_num[polozka_num];i_num++)
	{
		//printf("<<<add_string %d\n",i_num);
		AOM_ask_value_string(object_type,from_add[i_num],&tmp_text);
		//printf("<<<<read from %s \n",tmp_text);
		AOM_ask_value_string(object_type,to_add,&tmp_text2);
		strcpy (result,tmp_text2);
		strcat(result,"|");
		strcat(result,tmp_text);
		//printf("<<<<coping %s \n",result);
		AOM_set_value_string(object_type,to_copy,result);
		//printf("<<<<coped \n");
	}
	}
	else if(strcmp(Attr_type[polozka_num][num],"<add_double_string")==0)
	{ char* tmp_text2,
			tmp_text[15];
		double	tmp_double;
	char result [240];
	printf("<<<add_double_string %d\n",Add_d_num[polozka_num]);
	for(int i_num=0;i_num<Add_d_num[polozka_num];i_num++)
	{
		//printf("<<<add_string %d\n",i_num);
		AOM_get_value_double(object_type,from_add[i_num],&tmp_double);
		sprintf(tmp_text,"%.03f",tmp_double);
		printf("<<<<read from %s \n",tmp_text);
		AOM_ask_value_string(object_type,to_add,&tmp_text2);
		strcpy (result,tmp_text2);
		strcat(result,"|");
		strcat(result,tmp_text);
		printf("<<<<coping %s \n",result);
		AOM_set_value_string(object_type,to_copy,result);
		//printf("<<<<coped \n");
	}
	}
	else if(strcmp(Attr_type[polozka_num][num],"<set_string")==0)
	{ 
		char* tmp_text;
		
		int IERROR=AOM_set_value_string(object_type,attr_set[polozka_num],value_set[polozka_num]);
		printf ("Err %d string attr %s   %s \n",IERROR,attr_set[polozka_num],value_set[polozka_num]);
	}
	AOM_save(object_type);
//printf("TypPolozky_num %d t %d IRev %d hodnoty [%d] %s \n Attr_type[%d][%d] %s \n Attr[%d][%d] %s \n \n",polozka_num,num,object_type,num,value,polozka_num,num,Attr_type[polozka_num][num],polozka_num,num,Attr[polozka_num][num]);
}


void Create(char hodnoty[50][256],int TypPolozky_num){
	printf("---Create \n");
		tag_t TP = NULLTAG;
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

		
		if(Existence(hodnoty,typRevize, TypPolozky_num)==1)
		{
			printf("-------------Created__new __item-----------------\n");
			//itemy
			TCTYPE_find_type(typItem, NULL, &itemType);
			printf("Tag itemu %d \n", itemType);
			TCTYPE_construct_create_input(itemType, &createItem);

			//set attribute
			AOM_set_value_tag(createItem, "revision", createRev);
			int num_name=GetAttr("object_name",TypPolozky_num);
			printf ("%d obj name %s \n",num_name,hodnoty[num_name]);
			AOM_set_value_string(createItem, "object_name",hodnoty[num_name]);

		
			TCTYPE_create_object(createItem, &TP);
			TCTYPE_create_object(createRev, &IRev);
			int ReturnCode = AOM_save(TP);
			printf ("Save TP %d \n",ReturnCode);
			int num=GetAttr("<folder",TypPolozky_num);
			printf ("%d folder %s\n",num,Attr[TypPolozky_num][23]);
			SetProperty (TypPolozky_num,23,TP,hodnoty[23]);
			AOM_lock(TP);
			for (int i=0;i<Attr_num-1;i++)
			{
				if(i!=num_name)
				SetProperty(TypPolozky_num,i,TP,hodnoty[i]);
			}
				//int IERROR=AOM_set_value_string(TP,"tpv4_stav_polozky","Neopravena z ERP");
				//printf ("Err %d string attr \n",IERROR);
			AOM_save(TP);
			AOM_unlock(TP);
		}
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
	int typ=0;
//	char *tmp_field;
	
	char hodnoty[50][256];
	//printf("string %s \n",string);
	printf("Attr_num %d Remove %d \n",Attr_num,Remove_line);
	for(int t=0;t<20;t++)
		strcpy(hodnoty[t]," ");
	//int i=1;
	tmp=strdup(string);
	strcpy(hodnoty[1],strtok(string,"#"));
	printf(" %d Field  %s\n\n",1,hodnoty[1]);
	
	for (int i =2;i<Attr_num-Remove_line;i++)
	{
		strcpy(hodnoty[i],strtok(NULL,"#"));
			printf(" %d Field  %s\n\n",i,hodnoty[i]);
	
				if (strncmp(hodnoty[2],"425",3)==0 ||
					strncmp(hodnoty[2],"427",3)==0 ||
					strncmp(hodnoty[2],"500",3)==0 ||
					strncmp(hodnoty[2],"505",3)==0 ||
					strncmp(hodnoty[2],"506",3)==0 ||
					strncmp(hodnoty[2],"510",3)==0 ||
					strncmp(hodnoty[2],"514",3)==0 ||
					strncmp(hodnoty[2],"520",3)==0 ||
					strncmp(hodnoty[2],"522",3)==0 ||
					strncmp(hodnoty[2],"540",3)==0 ||//provìøit jestli nedoplnit strncmp(hodnoty[2],"540-550",7)==0
					strncmp(hodnoty[2],"550",3)==0 ||
					strncmp(hodnoty[2],"610",3)==0 ||
					strncmp(hodnoty[2],"615",3)==0 ||
					strncmp(hodnoty[2],"613",3)==0 ||//provìøit jestli nedoplnit strncmp(hodnoty[2],"613-615",7)==0
					strncmp(hodnoty[2],"372",3)==0 ||
					strncmp(hodnoty[2],"732",3)==0 ||
					strncmp(hodnoty[2],"790",3)==0 ||
					strncmp(hodnoty[2],"791",3)==0 ||
					strncmp(hodnoty[2],"793",3)==0 ||
					strncmp(hodnoty[2],"794",3)==0 ||
					strncmp(hodnoty[2],"795",3)==0 ||
					strncmp(hodnoty[2],"796",3)==0 ||
					strncmp(hodnoty[2],"797",3)==0 ||
					strncmp(hodnoty[2],"761",3)==0 ||
					strncmp(hodnoty[2],"737",3)==0 ||
					strncmp(hodnoty[2],"738",3)==0 ||
					strncmp(hodnoty[2],"740",3)==0 ||
					strncmp(hodnoty[2],"741",3)==0 ||
					strncmp(hodnoty[2],"755",3)==0 ||
					strncmp(hodnoty[2],"754",3)==0 ||
					strncmp(hodnoty[2],"756",3)==0 ||
					strncmp(hodnoty[2],"777",3)==0 ||
					strncmp(hodnoty[2],"788",3)==0 )
					typ=1;
			
		
	}
	    //free(tmp);
		//free(tmp_field);
		
		Create(hodnoty,typ);
		/*free(hodnoty);*/
}

int main(int argc, char *argv[])
{
	
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

	char *nastaveni_import = ITK_ask_cli_argument( "-o=");

	ReadProperty(nastaveni_import);
   // system("pause");
    // Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
        fprintf(stderr, "ERROR: Login failed\n");
        return 1;
    }
    printf("Login OK\n");

	
	char*CSV = ITK_ask_cli_argument( "-s=");
	char CSVFile[50];
	strcpy(CSVFile,import_file);
	strcat(CSVFile,CSV);
	strcat(CSVFile,".csv");
	printf("CSVFile: %s \n",CSVFile);
	if(SouborExistuje(CSVFile)!=0){
		printf("file neexistuje \n");
		goto end;
	}else printf("soubor existuje\n");
	    FILE* stream = fopen(CSVFile, "r");

    char line[1024];
	int c=0;

    while (fgets(line, 1024, stream))
    {
		if(strchr(line,'#')!=NULL)
			ReadCSV(line);
     // system("puase");
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



void ListBomLine(tag_t BomLine, int Level)
{
    // Revize
    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1];
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);

    // dotaz na BomLine attributy
	long d_stredisko;//pocet znakù strediska
	long d_povrch1;//pocet znaku povrch1
    char *povrch1;
	char *povrch2;
	char *povrch3;
	char *stredisko;
	tag_t TP = NULLTAG;
    BOM_line_look_up_attribute("H4_KV_Povrch1", &AttributeId);
    BOM_line_ask_attribute_string(BomLine, AttributeId, &povrch1);
	BOM_line_look_up_attribute("H4_KV_Povrch2", &AttributeId);
    BOM_line_ask_attribute_string(BomLine, AttributeId, &povrch2);
	BOM_line_look_up_attribute("H4_KV_Povrch3", &AttributeId);
    BOM_line_ask_attribute_string(BomLine, AttributeId, &povrch3);
	BOM_line_look_up_attribute("H4_KV_Stredisko", &AttributeId);
    BOM_line_ask_attribute_string(BomLine, AttributeId, &stredisko);
	d_stredisko=strlen(stredisko);
	d_povrch1=strlen(povrch1);
	if (Level != 0) {
		
		printf("%d %s/%s: %s, %s, %s, %s\n", Level, Id, RevId, povrch1, povrch2, povrch2, stredisko);
		if(d_stredisko!=0 && d_povrch1!=0)//dotaz na nutne vyplnena pole charu
		{
			printf("pocet znaku stredisko %d pocet znaku povrch1 %d \n",d_stredisko,d_povrch1);
		
		tag_t itemType = NULLTAG;
		tag_t revType = NULLTAG;
		tag_t createItem = NULLTAG;
		tag_t createRev = NULLTAG;

		printf("zareg tagy\n");

		//revise
		TCTYPE_find_type("H4_TPRevision", NULL, &revType);
		if (revType == NULLTAG) {
			printf("Spatny typ revize");
		}
		printf("Tag rev itemu %d \n", revType);
		TCTYPE_construct_create_input(revType, &createRev);
		/*TCTYPE_construct_create_input(revType, &createRev);
		AOM_set_value_string(createRev, "item_revision_id", "001");
		AOM_set_value_string(createRev, "object_name", "Revize");*/
		
	
		//itemy
		TCTYPE_find_type("H4_TP", NULL, &itemType);
		printf("Tag itemu %d \n", itemType);
		TCTYPE_construct_create_input(itemType, &createItem);

		//set attribute
		AOM_set_value_tag(createItem, "revision", createRev);
		AOM_set_value_string(createItem, "object_name", "TP");
		AOM_set_value_string(createRev, "h4_TP_povrch1", povrch1);
		//AOM_set_value_string(createItem, "h4_TP_povrch2", povrch2);
		//AOM_set_value_string(createItem, "h4_TP_povrch3", povrch3);
		AOM_set_value_string(createRev, "h4_TP_cislo_KP", Id);
		AOM_set_value_string(createRev, "h4_TP_stredisko", stredisko);
		
			    
		//FL_user_update_newstuff_folder(Item);
		/*
		TCTYPE_find_type("H4_Dilec", NULL, &itemType);
		TCTYPE_construct_create_input(itemType, &createItem);
		AOM_set_value_string(createItem, "object_name", "Nový dílec");
		AOM_set_value_tag(createItem, "revision", createRev);
		*/
		// Create Item
		
		TCTYPE_create_object(createItem, &TP);
		

		//AOM_ask_lov(TP,"h4_TP_povrch2",Lov);
		/*if(Lov==NULLTAG){
			printf("chyba NULLTAG na Lov");
		}
		else
		{	while(Lov!=NULLTAG){

		tag_t T_Lov=*Lov++;
		printf("tag lovu povrch2 %d\n",T_Lov);
		}
		}*/
		int ReturnCode = AOM_save(TP);

		 // Newstuff
		//
	
		char* message;

		EMH_ask_error_text(ReturnCode, &message);

		if (ReturnCode != ITK_ok) {
			fprintf(stderr, "Položka nemohla být založena. Chyba %s.\n", message);
		} else {
			printf("Založena položka s tagem %d\n", TP);
		}

		 // Ètení vlastnosti
    char *Value = NULL;
    AOM_ask_value_string(TP, id_stredisko, &Value);
    printf("%s=%s\n", id_stredisko, Value);
	AOM_ask_value_string(TP, item_id, &Value);
    printf("%s=%s\n",item_id, Value);
	
		//voleni funkce
	//AddToTarget(RootTask,Value,TP);

		//vyhodnocení pokud nejsou vyplnena nutna pole 
	}else if(d_stredisko==0 && d_povrch1==0)printf("!!!! u itemu %s nebyla vytvorena TP protoze nebyl vyplneny atributy -  povrch1 a stredisko\n",Id);
	else{
	if(d_stredisko==0)printf("!!!! u itemu %s nebyla vytvorena TP protoze nebyl vyplnen atribut -  stredisko\n",Id);
	else printf("!!!! u itemu %s nebyla vytvorena TP protoze nebyl vyplnen atribut -  povrch1\n",Id);
	} //else
	}
	
	

    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1);
	 MEM_free(Childs);
	 }

int Existence(char hodnoty [20][256],char* typ, int typ_pol_num)
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

			 
				
				QRY_find(QueryExistenece[typ_pol_num], &query);
				printf("tag hledani %s  je %d\n",QueryExistenece[typ_pol_num],query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {EntryExistenece[typ_pol_num]};
				int num=GetAttr(AttryExistenece[typ_pol_num],typ_pol_num);
				char *values[1] =  {hodnoty[num]};				
				printf("hodnota hledani %s delka %s ATTR %s\n",values[0],values[0],entries[0]);						
				QRY_execute(query, 1, entries, values, &n_item, &item);
				printf("%d pocet nalezu %d erp_id %s typ pol %d \n Attr_num %d \n",num,n_item,hodnoty[num],typ_pol_num,Attr_num);
				if(n_item == 0)
					return 1;
				else
				{
					AOM_lock(*item);
					printf("Attr_num %d \n", Attr_num-1);
					for (int i=0;i<Attr_num-1;i++)
					{
						if(i!=num)
						SetProperty(typ_pol_num,i,*item,hodnoty[i]);
					}
					AOM_save(*item);
					AOM_unlock(*item);
					return 0;
				}
}