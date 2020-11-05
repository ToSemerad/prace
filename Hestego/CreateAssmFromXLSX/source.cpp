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
#include <tc/folder.h>
#include <tccore/aom.h>
#include <ctype.h>
#include <lov\lov.h>
#include <error.h>
#include <sa/person.h>
#include <tccore\grm.h>
#include <list>
#include <tccore/tctype.h>
#include <ps\gcr.h>
#include <ps\gcr_errors.h>
#include <iostream>
#include <time.h>

/*
#include "Item_to_folder.h"
#include "Gtac_err_reports.h"
#include "Dataset.h"*/
#include "Global_var.h"
#include "Obsluha_vstupni souboru.h"
#include "Polozka.h"
#include "TC_Mail.h"
#include "Dataset.h"
#include "Log_file.h"


 char QueryExistenece[10][128];
 char EntryExistenece[10][128];
 char AttryExistenece[10][128];
 char Attr [10][30][128];
 char Attr_type [10][30][128];
 char Attr_tpv [10][30][128];
 char attr_set[10][128];
 char value_set[10][128];
 char LogFileName[50];

 int Type_num=0;
 int Add_num[10];
 int Add_d_num[10];
 int Attr_num=0;
 int Remove_line=0;
 int Attr_Typ_polozky=0;
 tag_t Zalozeny[20];
//tag_t Schval_Item=NULLTAG;
 tag_t owner=NULLTAG;
 tag_t ownerGrup=NULLTAG;
 tag_t Schval_Rev=NULLTAG;
 tag_t Schval_Bwr=NULLTAG;
 tag_t Vrchol=NULLTAG;
 int zalozeny_num=0;

 char login[20],
	password[30],
	import_file[50],
	group[20],
	from_copy[20],
	from_add[20][20],
	to_add[20],
	to_copy[20];
int poradi_seznam=0;
Uzel *seznam;

void ListBomLine(tag_t BomLineTag, int Level);

char *time_Stamp(){

char *timeStamp = (char *)malloc(sizeof(char) * 16);
time_t ltime;
ltime=time(NULL);
struct tm *tm;
tm=localtime(&ltime);

sprintf(timeStamp,"%04d%02d%02d%02d%02d%02d", tm->tm_year+1900, tm->tm_mon+1, 
	tm->tm_mday, tm->tm_hour, tm->tm_min,tm->tm_sec);
return timeStamp;
}


void ReadProperty()
{
		printf(" Read Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	//char Path[50]="TPV2TC_property.xml";// puvodne C:\\SPLM\\APP\\Import_excel\\TPV2TC_property.xml
		char Path[50]="C:\\SPLM\\APP\\Import_excel\\TPV2TC_property.xml";

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
		}else if(strcmp(tmp,"Rev:<string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("string attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}else if(strcmp(tmp,"<int")==0)
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

		}else if(strcmp(tmp,"Rev:<import_dataset")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"Rev:<variable")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("double attr %s \n",tmp);
			//strcpy(Attr[Type_num][Attr_num],tmp);

		}
		else if(strcmp(tmp,"<date")==0)
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
		}else if(strcmp(tmp,"Rev:<copy_string")==0)
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


int main(int argc, char *argv[])
{
	
	Vrchol=NULLTAG;
   //system("pause");
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
    
	int typpolozky=0;
	
	char*CSV = ITK_ask_cli_argument( "-s=");
	char*kusovnik = ITK_ask_cli_argument( "-k=");
	char*TypImportu = ITK_ask_cli_argument( "-i=");
	char*DataOwner= ITK_ask_cli_argument( "-o=");
	char*SourceXLSX=ITK_ask_cli_argument( "-f=");
	char*VrcholKus=ITK_ask_cli_argument( "-v=");
	
	char*LogFile=ITK_ask_cli_argument( "-l=");
		printf("line: %d \n",__LINE__);
		printf("log %s \n",LogFile);

	if (LogFile==NULL)
		strcpy(LogFileName,"TC_log_no_exist");
	else
		strcpy(LogFileName,LogFile);
	printf("LogFileName %s \n",LogFileName);
			
	printf("line: %d \n",__LINE__);
	//strcat(LogFileName,".log");
		printf("line: %d \n",__LINE__);
		printf("logFile %s \n",LogFileName);
	Crete_InfoLog( LogFileName, time_Stamp());
		printf("line: %d \n",__LINE__);
	ReadProperty();
		printf("line: %d \n",__LINE__);
	InfoLog(LogFileName,"Read Property Compllete ","","");
	// Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
		char* mess;
		EMH_ask_error_text(ReturnCode,&mess);
        fprintf(stderr, "ERROR: Login failed %s \n",mess);
		InfoLog(LogFileName,"ERROR: Login failed ",mess,"");
        return 1;
    }
    printf("Login OK\n");

	InfoLog(LogFileName,"Prihlaseni do TC ","","");
	printf ("CXV = %s \n\n kusovnik = %s \n\n typImportu %s \n\n vlastnik = %s \n\n zdrojove XLSX = %s \n\n vrchol %s \n\n",CSV,kusovnik,TypImportu,DataOwner,SourceXLSX,VrcholKus);
	if(strcmp(TypImportu,"1")==0)
		typpolozky=1;//ob
	else if(strcmp(TypImportu,"2")==0)
		typpolozky=2;

	printf(" %d %s \n",__LINE__,CSV);
	char CSVFile[150];
	char kusovnikFile[150];
	printf("impoort file %s \n\n",import_file);
	strcpy(CSVFile,import_file);
	strcat(CSVFile,CSV);
	strcpy(kusovnikFile,import_file);
	strcat(kusovnikFile,kusovnik);
	//strcat(CSVFile,".csv");

	//-------------Zpracování Polozek------------//
	printf("CSVFile: %s \n\n",CSVFile);
	if(SouborExistuje(CSVFile)!=0){
		printf("file neexistuje \n");
		InfoLog(LogFileName,"Nelze najit zpracovana dat s polozakami z XLSX souboru ","","");
		goto end;
	}else printf("soubor existuje\n");
	int polozek=GetLineFile(CSVFile);
	
	seznam= (Uzel *)calloc(polozek,sizeof(Uzel));
	
	InfoLogInt(LogFileName,"Pocet nove zakladan položek je ",polozek,"");

	poradi_seznam=0;
	 owner=NULLTAG;
	 ownerGrup=NULLTAG;
	if (strlen(DataOwner)>1)
	{
		POM_string_to_tag(DataOwner,&owner);
		SA_ask_user_login_group	(owner,&ownerGrup);
	}
	    
		FILE* stream = fopen(CSVFile, "r");

    char line[1024];
	int c=0;
    while (fgets(line, 1024, stream))
    {
		printf(" line %s \n",line);
		if(strchr(line,'#')!=NULL && strlen(line)>45)
			ReadCSV(line,typpolozky-1,Attr_num,Remove_line,owner,ownerGrup);
      printf("navrat z ReadCSV \n");
    }
	fclose(stream);
	//------------Zpracováni kusovníku-----------//
	printf("kusovnikFile: %s \n",kusovnikFile);
//	system("pause");

	if(SouborExistuje(kusovnikFile)!=0){
		printf("file neexistuje \n");
		InfoLog(LogFileName,"Nelze najit zpracovana dat s kusovnikem z XLSX souboru ","","");
		goto end;
	}else printf("soubor existuje\n");

	if(strlen(VrcholKus)>1)
		POM_string_to_tag(VrcholKus,&Vrchol);
	    
		printf("%d \n",__LINE__);
		Readkusovnik(kusovnikFile);

    char *callUpdate=(char*)calloc(polozek*20+100,sizeof(char*));
	strcpy(callUpdate,"C:\\SPLM\\APP\\Import_excel\\Excel_read.exe -p=");
	strcat(callUpdate,SourceXLSX);
	strcat(callUpdate," -f=2 -u=\"");
	InfoLog(LogFileName,"Update Id nove vzniklich poozek do XLSX","","");
	for(int p=0;p<polozek;p++)
	{
		strcat(callUpdate,seznam[p].uzel_name);
		strcat(callUpdate,"#");
		strcat(callUpdate,seznam[p].obj_id);
		strcat(callUpdate,";");
			if(owner!=NULLTAG)
			{	
				ITK_set_bypass(true);
				printf("vlastneno %s \n",Owner(seznam[p].uzelRev));
				AOM_set_ownership(seznam[p].uzelItem,owner ,ownerGrup);
				AOM_set_ownership(seznam[p].uzelRev,owner ,ownerGrup);
				printf("vlastneno %s \n",Owner(seznam[p].uzelRev));
				AOM_save(seznam[p].uzelItem);
				AOM_save(seznam[p].uzelRev);
				ITK_set_bypass(false);
				
			}
	}
	strcat(callUpdate,"\"");

		//char callUpdate[GetLineFile(CSVFile)*3];
	if(seznam) free(seznam);
	printf("%s \n",callUpdate);
	//sprintf(callUpdate,"echo \"%s \"> C:\\SPLM\\APP\\Import_excel\\ren_update.txt",callUpdate);
	system(callUpdate);
	if(callUpdate) free(callUpdate);
end:;
	//system("pause");
	tag_t updatedExcel;
	char datasetFileName[30];
	strcpy(datasetFileName,"Updated_Excel");
	strcat(datasetFileName,time_Stamp());
	strcat(datasetFileName,".xlsx");



	create_dataset("MSExcelX","UpdateAfterImport",NULLTAG,Vrchol,&updatedExcel);
	importDatates(updatedExcel,SourceXLSX,"excel",datasetFileName);
	InfoLog(LogFileName,"Import updatovaneho XLSX pod vrchol","","");
	AOM_save(Vrchol);
	char email_text [512];
	strcpy(email_text,"Polozky dle xlsx souboru byli vytvoøeny : Vrchol: ");
	strcat(email_text,CreateLink2TC(Vrchol, " "));
	create_envelope_and_send_mail( owner, "ImportXLSX","Polozky byli vytvoøeny, kusovnik byl vytvoren");
	InfoLog(LogFileName,"Odeslani Emailu ","","");

	//Import_infoLog(Vrchol,LogFileName,time_Stamp());

/*
	//
	//------Mazani Priloh -------//
	char delDocasnyFile[400];
	//char cd_command[100]="cd \"";
	//strcat(cd_command,

	strcpy(delDocasnyFile,"del /F \"");
	strcat(delDocasnyFile,kusovnikFile);
	strcat(delDocasnyFile,"\" \"");
	strcat(delDocasnyFile,import_file);
	strcat(delDocasnyFile,CSV);
	strcat(delDocasnyFile,"\"");
	printf(" %s \n",delDocasnyFile);
	int p=0;
	for(int i=0;i<400;i++)
	{
		delDocasnyFile[i-p]=delDocasnyFile[i];
		printf(" %d %c %c\n",i,delDocasnyFile[i-p],delDocasnyFile[i]);
		if(delDocasnyFile[i]=='\\' && delDocasnyFile[i+1]=='\\')
		{	p++;
		printf(" p=%d \n",p);
		}
		if(delDocasnyFile[i]=='\0') break;
	}
	printf("po uprave: \n %s \n",delDocasnyFile);
	//system("pasuse");
	system(delDocasnyFile);
	*/



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
	Konec_infoLog( LogFileName, time_Stamp());

    return 0;
}