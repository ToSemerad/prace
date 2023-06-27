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
#include <errno.h>
#include <tc/folder.h>
#include <MsXml.h>
#include <locale.h>


#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define CHUNK 1024 /* read 1024 bytes at a time */
#define delimiter  ";"

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_RETURN(X) if (IFERR_REPORT(X)) return
#define IFERR_RETURN_IT(X) if (IFERR_REPORT(X)) return X
#define ECHO(X)  printf X; TC_write_syslog X

struct Polozka{
	int Poradi_atr;
	char *I_Name;
	char *Velikost;
	char *I_Popis;
	char** Name_attrs;
	char *Attr_Matr;
	char *Rozmer;
	char *Attr3;
	char *Jednotka;
	char *KlicTPV;
	char *Typ;
	char *Evid_cena;
};



static void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;
		//char *time = time_stamp();

		EMH_ask_error_text(return_code, &error_message_string);
		//ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));



		if (error_message_string) MEM_free(error_message_string);
		ECHO(("\nExiting program!\n <<<<<<<\n"));
		exit(EXIT_FAILURE);
	}
}

char Attr [10][20][128];
char Attr_type [10][20][128];
char Attr_tpv [10][20][128];
int Type_num=0;
int Attr_num=0 ;
int Attr_Typ_polozky=0;
char login[20],
	password[30],
	//import_file[50],
	group[20];

int Existence(char hodnoty [20][256],char* typ, int typ_pol_num);
void copy_string(char *target, char *source) {
   while (*source) {
      *target = *source;
      source++;
      target++;
   }
   *target = '\0';
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
void ListBomLine(tag_t BomLineTag, int Level);


void Logfile(char * name, char* id, char* cislo_erp)
{
	FILE *fs;

 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\");
 strcat(file,name);
 strcat(file,".log");
 
 fs=fopen(file,"a+");
 fprintf(fs,"id %s cislo-erp %s \n",id,cislo_erp);
  fclose(fs);
}

void ZpracujAttr (char buf[CHUNK],int num)
{
	 
   
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



void SetProperty (int polozka_num,int num,tag_t object_type,char* value)
{
	if(strcmp(Attr_type[polozka_num][num],"<string")==0)
	{
		//value=OpravCz(value);
		
		if(strlen(value)>1)
		{
			printf ("string attr %s   %s \n",Attr[polozka_num][num],value);
			IFERR_REPORT(AOM_set_value_string(object_type,Attr[polozka_num][num],value));
			//printf ("Err %d string attr %s   %s \n",IERROR,Attr[polozka_num][num],value);
		}
	}
	else if(strcmp(Attr_type[polozka_num][num],"<int")==0)
	{
		int tmp_int=atoi(value);
		printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		if(strcpy(value," ")!=0)
			IFERR_REPORT(AOM_set_value_int(object_type,Attr[polozka_num][num],tmp_int));
	}
	else if(strcmp(Attr_type[polozka_num][num],"<double")==0)
	{
		double tmp_double=atof(value);
		printf ("double attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_double );
		if(strcpy(value," ")!=0)
			AOM_set_value_double(object_type,Attr[polozka_num][num],tmp_double);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<nowritte")==0)
		printf ("--nic\n");
	else if(strcmp(Attr_type[polozka_num][num],"<folder")==0)
	{
		IntoFolder(value,object_type);
	}
	AOM_save(object_type);
//printf("TypPolozky_num %d t %d IRev %d hodnoty [%d] %s \n Attr_type[%d][%d] %s \n Attr[%d][%d] %s \n \n",polozka_num,num,object_type,num,value,polozka_num,num,Attr_type[polozka_num][num],polozka_num,num,Attr[polozka_num][num]);
}
int GetAttr(char* attr,int polozka_num)
{
	int num=0;
	for (int i=0;i<Attr_num;i++)
	{
		if (strcmp(Attr[polozka_num][i],attr)==0)
			num=i;
	}
	printf("Cislo attr v poli %d \n",num);
	return num;

}

int Get_Type (char* Type_ATTR,int polozka_num)
{

	for (int i=0;i<20;i++)
		if (strcmp (Type_ATTR,Attr_type [polozka_num][i])==0)
			return i;

	return 0;
}


void Create(char *Typ,char hodnoty [20][256]){
		tag_t TP = NULLTAG;
		tag_t IRev = NULLTAG;
		tag_t itemType = NULLTAG;
		tag_t revType = NULLTAG;
		tag_t createItem = NULLTAG;
		tag_t createRev = NULLTAG;
	//revise
		printf("----Create TC polozku ----\n");
			printf("tady 74 :typ %s \n",Typ);
		//char *KP="DAA 000 272";
    // Vyhledání položek

	//ITEM_ask_latest_rev(*Items,&Targets);
	//printf("test po  hledani \n");
			char typRevize[60]=" ",
					typItem[60]=" ",
					folder[30]=" ";
			int TypPolozky_num=0;
			//for(int t=1;t<20;t++)
			//{

	if(strcmp(Typ,"N")==0)
	{	//strcpy(typRevize,"H4_NakupovanyMatRevision"),
		TypPolozky_num=0;
		
	}
	else if(strcmp(Typ,"H")==0)
	{
		TypPolozky_num=1;
		
	}
	else 
	{
		printf("Spatny typ Materialu = %s \n",Typ);
		goto end;
	}

	int num=Get_Type("<ItemType",TypPolozky_num);
	printf ("num %d \n",num);
		strcpy(typRevize,Attr[TypPolozky_num][num]);
		strcat(typRevize,"Revision");
		//strcpy(typItem,"H4_NakupovanyMat"),
		strcpy(typItem,Attr[TypPolozky_num][num]);
		for(int i=0;i<Attr_num;i++)
		{
			if(strcmp(Attr_type[TypPolozky_num][i],"<folder")==0)
				strcpy(folder,Attr[TypPolozky_num][i]);
		}

	printf("typ : %s \n %s\n",typItem,typRevize);
		TCTYPE_find_type(typRevize, NULL, &revType);


		if (revType == NULLTAG) {
			printf("Spatny typ revize \n");
			goto end;
		}
		
		if (Existence(hodnoty,typItem,TypPolozky_num)==1)//existence
		{
	
		TCTYPE_construct_create_input(revType, &createRev);
		
	
		//itemy
		TCTYPE_find_type(typItem, NULL, &itemType);

		TCTYPE_construct_create_input(itemType, &createItem);

		//set attribute
		
		AOM_set_value_tag(createItem,"revision", createRev);
		//strcpy(hodnoty[3],OpravCz(hodnoty[3]));
		num=GetAttr("tpv4_nazev_erp",TypPolozky_num);
		printf("---------SET PRoperty name %s \n",hodnoty [num]);
		//SetProperty (TypPolozky_num,3,createItem,hodnoty [3]);
		AOM_set_value_string(createItem,"object_name",hodnoty [num]);

		int ReturnCode=TCTYPE_create_object(createItem, &TP);
		if (ReturnCode!=ITK_ok) printf("Chyba vytvaøeni objectu \n");
		//TCTYPE_create_object(createRev, &IRev);
		ReturnCode = AOM_save(TP);
		//printf ("Save TP %d \n",ReturnCode);
		if (ReturnCode ==ITK_ok)puts("Ulozena Item");
		else puts("Neuložena Item");
							
		ITEM_ask_latest_rev(TP,&IRev);
		printf("tag rev %d \n",IRev);


		//AOM_set_value_string(IRev, "object_desc", I.I_Popis);

		int OK=AOM_lock(TP);
		printf("zapis attr %d \n",OK);

	/*	OK=AOM_set_value_string(IRev,"tpv4_cislo_erp","777");
		if(OK==ITK_ok) printf("vse ok \n");
		else printf("problem %d \n",OK);
*/
	/*	OK=AOM_set_value_string(IRev, "object_desc","7777");
		printf("object_desc %d \n",OK);*/
		for (int t=1;t<Attr_num-1;t++)
		{
			//if(t!=3)
			SetProperty (TypPolozky_num,t,TP,hodnoty [t]); //pro zápis do Itemu
			//	SetProperty (TypPolozky_num,t,IRev,hodnoty [t]); //pro zápis do ItemuRevision
			//printf (" Attr %s \n Attr_type %s \n \n",Attr[TypPolozky_num][t],Attr_type[TypPolozky_num][t]);
			
		}
		AOM_set_value_string(TP,"tpv4_stav_polozky","Neopravena z ERP");
		ReturnCode = AOM_save(TP);	
		if (ReturnCode ==ITK_ok)printf("Ulozena Item");
		else printf("Neuložena Item");

		AOM_unlock(TP);
		SetProperty (TypPolozky_num,Attr_num-1,TP,folder);

		//IntoFolder(folder,TP);

		char *new_id;
		AOM_ask_value_string(TP,"item_id",&new_id);

		//printf("id nove položky je %s \n",new_id);
	}else printf (" item s is %s uz existuje",hodnoty [3]);
		end:;
}


 char* getfield(char* line, int num)
{
     char* tok;
    for (tok = strtok(line, ";");
            tok && *tok;
            tok = strtok(NULL, ";\n"))
    {
        if (!--num)
            return tok;
    }
    return NULL;
}

void ReadProperty()
{
		printf(" Read Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char Path[50]="C:\\SPLM\\Apps\\Import\\XML2TC_property.xml";


	    FILE* stream = fopen(Path, "r");
	//	printf("CSVFile: %s \n",CSVFile);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		tmp=strtok(line,">");
		
		
		//tmp=strtok(NULL,"<");
		if (strcmp(tmp,"<polozka")==0)
		{
			Attr_num=0;
			printf("polozka \n");
			goto nextLine;
			
		}
		else if (strcmp(tmp,"<ItemType")==0)
		{	strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("ItemType attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}
		else if(strcmp(tmp,"<string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("string attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}else if(strcmp(tmp,"<int")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("int attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<double")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<folder")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("folder attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}else if(strcmp(tmp,"<nowritte")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("noread \n",tmp);
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
			printf("inport file %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			//strcpy(import_file,tmp);
			goto nextLine;

		}
		else if(strcmp(tmp,"</polozka")==0)
		{
			printf("polozka konec \n");
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
		printf("konec %s \n",tmp);
		

	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//tmp=strtok(NULL,">");
		Attr_num++;
		nextLine:;
			}


//}

}

int Docisti(char* string)
{
	char attr[700];
	int delkaCopy=0;
	for(int i=0;i<strlen(string);i++)
	{
		if(string[i-12]=='<'&& 
			string[i-11]=='/'&& 
			string[i-10]=='Q' && 
			string[i-9]=='Z'&&
			string[i-8]=='B'&&
			string[i-7]=='O'&&
			string[i-6]=='Z'&&
			string[i-5]=='I'&&
			string[i-4]=='_'&&
			string[i-3]=='T'&&
			string[i-2]=='P'&&
			string[i-1]=='V'&&
			string[i]=='>')
		{
			delkaCopy=i;
			printf("nalezeno \n");
			break;
		}
		//printf(" pocet %d \n",i);
			
	}
	
	strncpy(attr,string,delkaCopy);
	printf("delka copy retezce %d %s\n",delkaCopy,attr);	
	return delkaCopy;
}
void ReadXML(char * XMLfile) {
		//int pocetP=0;
		char line[7000];
		char hodnoty[20][256];
		char * token;
		int vysledek = 0;
		char pom[7000];
		logical stejnyRadek=false;
		FILE * stream = fopen(XMLfile, "r");
		printf(">>>>>>>>>>>>>>>>> %s <<<<<<<<<\n", Attr[0][0]);
		
  while (fgets(line, 7000, stream)) {

	  //pocetP++; Poèítá poèet prùchodù cyklem while
	  if(stejnyRadek)	//Pokud není na stejném øádku <QZBOZI_TPV> a </QZBOZI_TPV>, spoj tyto øádky
	  {
		printf("%d\n", __LINE__);
		strcat(pom, line);
		strcpy(line,pom);
		stejnyRadek=false;
	  }
		
		logical nekoncovyZnak=true;
		int delkaCopy = 0,
		konec = 700,
		HelpPocet = 0,
		start = 0,
		zaklad = 0;


		char attr[700];
		int Attr_num = 0;
		printf("\n%d velikost %d z maxima %d \n%s\n", vysledek++, strlen(line), sizeof(line), line);	//strlen(line): èíselný výpis poètu znakù na aktuálním øádku
																										//sizeof(line): èíselný výpis maximálního poètu znakù na øádku


    for (int i = 0; i < 7000; i++)		//Prochází znaky na øádku po jednom, jejich maximální poèet je 7000. 
	{
		
		if(line[i]=='\0'){	//Pokud je i na konci øetìzce(øádku), nastavit na jeho maximální hodnotu, aby se mohl provést další øádek
		i=7000;
		}

			if(line[i - 13] == '<' &&		//Pokud je na konci øádku obsažen øetìzec </QZBOZI_TPV>, nastavit nekoncovy znak na false(Øetìzec je obsažen na øádku)
				line[i - 12] == '/' &&		//Øetìzec se ète odzadu, proto se i-1 porovnává s '>' a ne s '<'
				line[i - 11] == 'Q' &&
				line[i - 10] == 'Z' &&
				line[i - 9] == 'B' &&
				line[i - 8] == 'O' &&
				line[i - 7] == 'Z' &&
				line[i - 6] == 'I' &&
				line[i - 5] == '_' &&
				line[i - 4] == 'T' &&
				line[i - 3] == 'P' &&
				line[i - 2] == 'V' &&
				line[i - 1] == '>' ) 
			{
							nekoncovyZnak=false;
							//printf("%d\n", __LINE__);
							HelpPocet++;
							start = 0;
							printf(" \n nalezeno %d \n pocet nalezu %d \n\n", i, HelpPocet);

					int nalez = 0;
					char * tmp;
					char Rozmer[128];
					
					for (int t = 0; t < 20; t++)
						strcpy(hodnoty[t], " ");

					//Pokud øádek zaèíná øetìzcem <QZBOZI_TPV>, proveï
				if(strncmp(line, "<QZBOZI_TPV>", 12) == 0) 
				{
					//printf("%d %d\n",__LINE__),strncmp(line, "<QZBOZI_TPV>", 12)) 	pro odladìní - výpis èísla øádku+jestli se splnila podmínka
					//system("pause");
					zpracuj:;
					tmp = strtok(line, ">");	//Oddìlí znak > z øetìzce, napø. místo <QZBOZI_TPV> bude <QZBOZI_TPV
					tmp = strtok(NULL, ">");
								//tmp = strtok(NULL, "<\QZBOZI_TPV>");
								//printf("%d\n %d\n", __LINE__,strncmp(line, "<QZBOZI_TPV>", 12));  pro odladìní - výpis èísla øádku+jestli se splnila podmínka
								int i = 0;
							
								while (strcmp("</QZBOZI_TPV", tmp) != 0)  {	//Každá nak. položka z xml souboru má 13 vlastností, proto i<13, po každém prùchodu se i zvìtší o 1, dokud se nedostane na 13. hodnotu, poté skonèí

									i++;
									
									//printf("%d\n", __LINE__);
									printf("L:%d i %d tmp %s \n ", __LINE__, i, tmp);

									if(tmp!=NULL)  //Pokud tmp obsahuje nìjakou hodnotu, vypiš ji								
										printf("L:%d Vlastnost = %s \n",__LINE__, tmp);

							   if (strcmp("<TYP_ZBOZI", tmp) == 0 || strcmp(tmp, "H</TYP_ZBOZI") == 0 || strcmp(tmp, "N</TYP_ZBOZI") == 0 || strcmp("TYP_ZBOZI", tmp) == 0) 
							   {	//Pokud se v øetìzci nacházejí všechny tyto vlastnosti, pøiøaï jim následující hodnoty ze souboru

										printf("%d\n", __LINE__);
										Attr_Typ_polozky = i;
										printf("typ %d \n", i);

									if (strcmp(tmp, "H</TYP_ZBOZI") == 0) {

										strcpy(hodnoty[i], "H");

								  } else if (strcmp(tmp, "N</TYP_ZBOZI") == 0) {

											strcpy(hodnoty[i], "N");
								  }

								} else if (strcmp(tmp, "</QZBOZI_TPV") == 0) {

										 nalez = 1;
										 printf("shoda \n");
										 goto next_line;

								} else if (strcmp(tmp, "<POPIS") == 0) {

										printf("POPIS: \n");
										tmp = strtok(NULL, "<");
										printf("%s\n",tmp);
								  if (strcmp(tmp, "/POPIS>") == 0) {

										 strcpy(hodnoty[i], tmp);
										 printf("hodnota %s \n", tmp);

								  } else {

										strcpy(hodnoty[i], tmp);
										tmp = strtok(NULL, ">");
								  }
									goto next;
					
							  if (nalez != 1) {
									printf("Konec nenalezen");
									goto next_line;
								  }

								}

								printf("L:%d token %s \n",__LINE__, tmp);

								//printf("Ted je v line: %s\n", line); odladìní - výpis hodnot v line 
								tmp = strtok(NULL, "<");

							  if (strcmp(tmp, "/NAZEV_ZBOZI>") == 0) {
									strcpy(hodnoty[i], " ");
									printf("L:%d hodnota %s \n",__LINE__, tmp);
									goto next;
								}

							   strcpy(hodnoty[i], tmp);
							   printf("%d hodnoty %s \n\n", i, hodnoty[i]);
							   tmp = strtok(NULL, ">");
							   next: ;
							   tmp = strtok(NULL, ">");
							  }
							  Attr_num = 0;
							  printf(" %d pred Create polozky \n:",__LINE__);
							  Create(hodnoty[Attr_Typ_polozky],hodnoty);
							for (int c = 0; c < 700; c++)
									attr[c] = ' ';
							  
							
					}  
				i=7000;
		}else 
      attr[Attr_num++] = line[i];

    }
	//printf("%d LINE: %s\n POM: %s\n %d %d\n",__LINE__,line,pom,nekoncovyZnak,(strncmp(line, "<QZBOZI_TPV>", 12))); odladìní-èíslo øádky, obsah line a pom, 
	if ((strncmp(line, "<QZBOZI_TPV>", 12) == 0)&& nekoncovyZnak)	//Pokud na zaèátku øádku není <QZBOZI_TPV> a zároveò na konci není </QZBOZI_TPV>, zkopíruj a ulož obsah do pom
		{
			printf("%d\n",__LINE__);
			strcpy(pom,line);
			nekoncovyZnak=true;
			stejnyRadek=true;
			goto next_line;
			
		}


  next_line: ;
}
printf("L: %d konec ciklu \n", __LINE__);
//for(int c=0;c<7000;c++){	//Po dokonèení práce, vymaž znaky z promìnných line a pom
//	line[c]='\0';
//	pom[c]='\0';
//}

}


int main(int argc, char *argv[])
{
	 ReadProperty();
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);

    // Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
        fprintf(stderr, "ERROR: Login failed\n");
        return 1;
    }
    printf("Login OK\n");
	Polozka I;
	I.Poradi_atr=0;
	
	printf(" Pred XML \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char*XML = ITK_ask_cli_argument( "-s=");
	//char CSVFile[50]="C:\\TC4TPV\\csv\\";
	char XMLFile[50]="C:\\SPLM\\Apps\\Import\\";
	//char XMLFile[50];
	printf("677>>>>>>>>>>>>>>>>> %s <<<<<<<<<\n",Attr[0][0]);
	strcat(XMLFile,XML);
	//strcat(XMLFile,".xml");
	printf("CSVFile: %s \n",XMLFile);
	printf("681>>>>>>>>>>>>>>>>> %s <<<<<<<<<\n",Attr[0][0]);
	if(SouborExistuje(XMLFile)!=0){
		printf("file neexistuje \n");
		goto end;
	}else printf("soubor existuje\n");
	ReadXML(XMLFile);



	end:;
    return 0;
}

void VyplnKlicTPV(tag_t Rev,char* KlicTPV)
{
		AOM_lock(Rev);
		int tmp_int=atoi(KlicTPV);
		printf ("Klic TPV %s %d\n",KlicTPV,tmp_int );
		if(strcpy(KlicTPV," ")!=0)
			AOM_set_value_int(Rev, "tpv4_id_erp",tmp_int);
			AOM_set_value_string(Rev,"tpv4_stav_polozky","Platna");
		AOM_save(Rev);
		AOM_unlock(Rev);


}

int Existence(char hodnoty [20][256],char* typ, int typ_pol_num)
	{
			int Vytvor=0;
			char* hledany_x=NULL,
				//* hledany_y=NULL,
			
			 *idd,
			 *cislo_erp;
			tag_t query=NULLTAG;
			tag_t* item=NULLTAG;
			int n_item=NULLTAG;
			//int ItemsCountt = 0;
			tag_t *Itemss = NULLTAG;
			printf("__________test__hledani__________ \n");
			printf("test hledani %s \n",typ);
			const char *Names[1] = { "object_type"};

			 if (strcmp(typ,"TPV4_nak_pol")==0)
			 {
				
				QRY_find2("STS_NAK_POLOZKA", &query);
				//printf("tag foldru STS_NAK_POLOZKA je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"ID ERP"};
				int num=GetAttr("tpv4_id_erp",typ_pol_num);
				char *values[1] =  {hodnoty[num]};				
				//printf("hodnota hledani %s delka %d \n",values[0],strlen(values[0]));						
				QRY_execute(query, 1, entries, values, &n_item, &item);

				printf("%d pocet nalezu %d erp_id %s typ pol %d \n",num,n_item,hodnoty[num],typ_pol_num);
				if(n_item == 0)
					return 1;
				//for (int t=1;t<Attr_num-1;t++)
				//{
				//	//if(t!=3)
				//	SetProperty (typ_pol_num,t,*item,hodnoty [t]); //pro zápis do Itemu
				//	//	SetProperty (TypPolozky_num,t,IRev,hodnoty [t]); //pro zápis do ItemuRevision
				//	//printf (" Attr %s \n Attr_type %s \n \n",Attr[TypPolozky_num][t],Attr_type[TypPolozky_num][t]);
			
				//}
				/*else
					return 0;*/
			 }
			 else if(strcmp(typ,"TPV4_h_material")==0)
			 {
				QRY_find2("STS_HUT_MATERIAL", &query);
				//printf("tag foldru STS_NAK_POLOZKA je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"ID ERP"};
				int num=GetAttr("tpv4_id_erp",typ_pol_num);
				char *values[1] =  {hodnoty[num]};				
				//printf("hodnota hledani %s delka %d \n",values[0],strlen(values[0]));						
				QRY_execute(query, 1, entries, values, &n_item, &item);
				printf("%d pocet nalezu %d erp_id %s typ pol %d \n",num,n_item,hodnoty[num],typ_pol_num);
				if(n_item == 0)
					return 1;
				/*else
					return 0;*/	

			 }
			/* else
				return 0;*/
	
			//	if(n_item == 0)
			//	{
			//		printf("\n Nenalezena zadna polozka\n");

			//			//	if (strcmp(typ,"TPV4_nak_pol")==0)
			//		 //{
			//	
			//			//QRY_find("STS_NAK_POLOZKA", &query);
			//			//printf("tag foldru STS_NAK_POLOZKA je %d\n",query);
			//			//// Find user's "Tasks to Perform" folder
			//			//char *entries[1] = {"CISLO ERP"};
			//			//int num=GetAttr("tpv4_cislo_erp",typ_pol_num);
			//			//char *values[1] =  {hodnoty[num]};				
			//			//printf("hodnota hledani %s \n",values[0]);						
			//			//QRY_execute(query, 1, entries, values, &n_item, &item);
			//			//printf("pocet nalezu %d erp_id %d \n",n_item,hodnoty[num]);		
			//		 //}
			//		 //else if(strcmp(typ,"TPV4_h_material")==0)
			//		 //{
			//			//QRY_find("STS_HUT_MATERIAL", &query);
			//			//printf("tag foldru STS_HUT_MATERIA je %d\n",query);
			//			//// Find user's "Tasks to Perform" folder
			//			//char *entries[1] = {"CISLO ERP"};
			//			//int num=GetAttr("tpv4_cislo_erp",typ_pol_num);
			//			//char *values[1] =  {hodnoty[num]};				
			//			////strcpy(values[0],folder);							
			//			//QRY_execute(query, 1, entries, values, &n_item, &item);
			//			//printf("pocet nalezu %d erp_id %d \n",n_item,hodnoty[num]);			
			//		 //}
			//				/*if(n_item == 0)
			//				return 1;
			//				else
			//				{*/
			//				//	for(int i = 0; i < n_item; i++)
			//				//	{	
			//				//		char* stav_polozky;
			//				//		AOM_ask_value_string(item[i],"tpv4_stav_polozky",&stav_polozky);
			//				//		printf("stav polozky %s cmp %d\n",stav_polozky,strcmp(stav_polozky,"Neopravena z ERP"));
			//				//		 if( strcmp(stav_polozky,"Opravena v TC")==0)
			//				//		{
			//				//			printf ("\n Shoda Opravene Polozky bez Id erp \n \n");
			//				//			

			//				//			int OK=AOM_lock(item[i]);
			//				//			printf("zapis attr %d \n",OK);

			//				//			int num=GetAttr("tpv4_id_erp",typ_pol_num);
			//				//			SetProperty (typ_pol_num,num,item[i],hodnoty [num]);
			//				//			num=GetAttr("tpv4_nazev_erp",typ_pol_num);
			//				//			SetProperty (typ_pol_num,num,item[i],hodnoty [num]);

			//				//			char *obj_name;
			//				//			
			//				//			AOM_ask_value_string(item[i],"object_name",&obj_name);
			//				//			if(strcmp(obj_name,hodnoty[num])==0)
			//				//				AOM_set_value_string(item[i],"tpv4_stav_polozky","Neopravena z ERP");

			//				//			OK = AOM_save(item[i]);	
			//				//			if (OK ==ITK_ok)printf("Ulozena Item");
			//				//			else printf("Neuložena Item");

			//				//			AOM_unlock(item[i]);

			//				//		}else if( strcmp(stav_polozky,"Opravit v TC")==0)
			//				//		 {
			//				//			 printf("zatim neopraveno \n");
			//				//		}else if ( strcmp(stav_polozky,"Neopravena z ERP")==0)
			//				//		{
			//				//			int id_erp=NULL;
			//				//			AOM_get_value_int(item[i],"tpv4_id_erp",&id_erp);
			//				//			if(id_erp==NULL || id_erp==0)
			//				//			{
			//				//			int OK=AOM_lock(item[i]);
			//				//			printf("zapis attr %d \n",OK);

			//				//			int num=GetAttr("tpv4_id_erp",typ_pol_num);
			//				//			SetProperty (typ_pol_num,num,item[i],hodnoty [num]);

			//				//			OK = AOM_save(item[i]);	
			//				//			if (OK ==ITK_ok)printf("Ulozena Item");
			//				//			else printf("Neuložena Item");

			//				//			AOM_unlock(item[i]);
			//				//			}
			//				//		}

			//				//		else
			//				//		 {
			//				//			printf("zaloz novou polozku\n _______________\n");
			//				//			 
			//				//		}
			//				//	}
			//				//}
			//				return 1;

			//	}
			//	else
				if	(n_item >= 1){
						printf("\n Nalezeno %d polozek\n", n_item);
						
			//		
			//			
						for(int i = 0; i < n_item; i++)
							{	
								AOM_ask_value_string(item[i],"item_id",&idd);
								AOM_ask_value_string(item[i],"tpv4_cislo_erp",&cislo_erp);
								if(n_item>1)
									{
										Logfile("duplicity", idd, cislo_erp);
										IntoFolder("oprava_id",item[i]);
								}

								char* stav_polozky;
								AOM_ask_value_string(item[i],"tpv4_stav_polozky",&stav_polozky);
								printf("stav polozky %s cmp %d\n",stav_polozky,strcmp(stav_polozky,"Neopravena z ERP"));
								//if(strcmp(stav_polozky,"Neopravena z ERP")==0)
								//{


									int OK=AOM_lock(item[i]);
									printf("zapis attr %d \n",OK);

									for (int t=1;t<Attr_num-1;t++)
									{
										//if(t!=3)
										SetProperty (typ_pol_num,t,item[i],hodnoty [t]);
										if (t==3)
										{	
											tag_t rev;
											ITEM_ask_latest_rev(item[i],&rev);
											AOM_lock(rev);
											int IERROR=AOM_set_value_string(rev,"object_name",hodnoty [t]);
											 IERROR=AOM_set_value_string(item[i],"object_name",hodnoty [t]);
											
											printf("set %s na %s %d\n",Attr[0][t],hodnoty[t],IERROR);
											AOM_save(rev);
											AOM_save(item[i]);
											AOM_unlock(rev);
											
										}
			
									}
									AOM_set_value_string(item[i],"tpv4_stav_polozky","Neopravena z ERP");
									OK = AOM_save(item[i]);	
									if (OK ==ITK_ok)printf("Ulozena Item");
									else printf("Neuložena Item");

									AOM_unlock(item[i]);


								//}
			//					else if( strcmp(stav_polozky,"Opravena v TC")==0)
			//					{

			//					}
			//					//printf("Namee %s \n Idd %s \n tag TP %d \n",Namee,Idd,revItemu);
			//					

			//							char *Value = NULL;
			//					AOM_ask_value_string(revItemu, "object_name", &hledany_x);
			//					

			//					if( strcmp(item_name_hledany,hledany_x)==0||strcmp(item_name_hledany,Idd)==0 )
			//					{ 
			//					
			//							Vytvor=1;
			//						int tmp_int=0;
			//							AOM_get_value_int(revItemu, "tpv4_id_erp",&tmp_int);
			//							
			//						if(tmp_int!=atoi(KlicTPV))
			//						{
			//							
			//							VyplnKlicTPV(revItemu, KlicTPV);
			//						}
			//					}	printf("Vytvor \n");
			//					//if(strlen(TP)==8)
							}
				}
				printf("-_______________________-\n");
			return 0;
}