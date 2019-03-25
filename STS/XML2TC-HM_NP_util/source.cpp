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


void ZpracujAttr (char buf[CHUNK],int num)
{
	 
   
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
			int IERROR=AOM_set_value_string(object_type,Attr[polozka_num][num],value);
			printf ("Err %d string attr %s   %s \n",IERROR,Attr[polozka_num][num],value);
		}
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
		printf("Spatny typ Materialu \n");
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
void ReadXML(char* string)
{
	
	char *tmp;
	char Rozmer[128];
	char hodnoty[20][256];
	for(int t=0;t<20;t++)
		strcpy(hodnoty[t]," ");
	
	printf("test red xml %s\n",string);

		tmp=strtok(string,">");
		//tmp=strtok(NULL,"<\QZBOZI_TPV>");
		
		for(int i=1;i<12;i++)
		{
		tmp=strtok(NULL,">");
		printf("Vlastnost = %s \n",tmp);
		if(strcmp("<TYP_ZBOZI",tmp)==0 || strcmp(tmp,"H</TYP_ZBOZI")==0 || strcmp(tmp,"N</TYP_ZBOZI")==0 ||strcmp("TYP_ZBOZI",tmp)==0 )
		{
			Attr_Typ_polozky=i;
			printf("typ %d \n",i);
			if(strcmp(tmp,"H</TYP_ZBOZI")==0)
			{	
			
			strcpy(hodnoty[i],"H");
			//goto next;
			}
			else if(strcmp(tmp,"N</TYP_ZBOZI")==0)
			{
			
			strcpy(hodnoty[i],"N");
			//goto next;
			}

		}
		
		
		else if (strcmp(tmp,"</QZBOZI_TPV")==0)
		{
			printf("shoda \n");
			break;
		}
		else if (strcmp(tmp,"<POPIS")==0)
		{
			printf("POPIS: \n");
			
			
			tmp=strtok(NULL,"<");
			
			if (strcmp(tmp,"/POPIS>")==0)
			{
				strcpy(hodnoty[i]," ");
				printf("hodnota %s \n",tmp);
				
			}else
			{
				
				strcpy(hodnoty[i],tmp);
				tmp=strtok(NULL,">");
			}

				goto next;
		}
		printf("token %s \n",tmp);
		
		
		tmp=strtok(NULL,"<");
		if (strcmp(tmp,"/NAZEV_ZBOZI>")==0)
			{
				strcpy(hodnoty[i]," ");
				printf("hodnota %s \n",tmp);
				goto next;
			}
		strcpy(hodnoty[i],tmp);
		
		tmp=strtok(NULL,">");
		next:;
		
		}
	
	//tmp=strtok(NULL,"<IDZBOZI>");
	//tmp=strtok(NULL,"</IDZBOZI>");
	//printf("tmp %s \n",tmp);
	//Docisti(tmp,Rozmer);
	//printf(" IDZBOZI	 %s \n",Rozmer);

	//tmp=strtok(NULL,"</IDZBOZI>");
	//printf("tmp %s \n",tmp);
	//Docisti(tmp,Rozmer);
	//printf(" CIS_ZBOZI	 %s \n",Rozmer);
	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[1],tmp);
	//tmp=strtok(NULL,">");
	
	
	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[2],tmp);
	//tmp=strtok(NULL,">");
	//
	////Docisti(tmp,Rozmer);
	////printf(" NAZEV_ZBOZI	 %s \n",Rozmer);

	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[3],tmp);
	//tmp=strtok(NULL,">");
	//
	////Docisti(tmp,Rozmer);
	////printf(" KOD_MJ	 %s \n",Rozmer);
	//
	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[4],tmp);
	//tmp=strtok(NULL,">");
	//
	////Docisti(tmp,Rozmer);
	////printf(" Rozmer 1	 %s \n",Rozmer);

	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[5],tmp);
	//tmp=strtok(NULL,">");
	//
	////Docisti(tmp,Rozmer);
	////printf(" Rozmer 2	 %s \n",Rozmer);
	//
	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[6],tmp);
	//tmp=strtok(NULL,">");
	//
	////Docisti(tmp,Rozmer);
	////printf(" Rozmer 3	 %s \n",Rozmer);

	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//strcpy(hodnoty[7],tmp);
	//tmp=strtok(NULL,">");
		
		printf("typ zapsany %s \n",hodnoty[Attr_Typ_polozky]);
		 Create(hodnoty[Attr_Typ_polozky],hodnoty);

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
	    FILE* stream = fopen(XMLFile, "r");
	
    char line[7000];
	char *token;
	int vysledek=0;
	
		ReadProperty();
		printf("681>>>>>>>>>>>>>>>>> %s <<<<<<<<<\n",Attr[0][0]);

		while (fgets(line, 7000, stream))
		{
			int delkaCopy=0,
				//delkaRetezce=700,
				konec=700,
				HelpPocet=0,
				start=0,
			    zaklad=0;
			//do
			//{	
									
				char attr[700];
				int Attr_num=0;
				printf("\n%d velikost %d  %d \n",vysledek++,strlen(line),sizeof(line));
				//delkaCopy=0;

				for(int i=0;i<7000;i++)
				{
				
					if(line[i-13]=='<'&& 
						line[i-12]=='/'&& 
						line[i-11]=='Q' && 
						line[i-10]=='Z'&&
						line[i-9]=='B'&&
						line[i-8]=='O'&&
						line[i-7]=='Z'&&
						line[i-6]=='I'&&
						line[i-5]=='_'&&
						line[i-4]=='T'&&
						line[i-3]=='P'&&
						line[i-2]=='V'&&
						line[i-1]=='>')
					{
						HelpPocet++;
						start=0;
						printf(" \n nalezeno %d \n pocet nalezu %d \n\n",i,HelpPocet);
						ReadXML(attr);
						Attr_num=0;
						for (int c=0;c<700;c++)
							attr[c]=' ';
					//break;
					}
				//	if(start==1)
					attr[Attr_num++]=line[i];
			
				}
				zaklad=zaklad+delkaCopy;
				konec=konec+delkaCopy;
				//strncpy(attr,line,delkaCopy);
				//printf("\n delkaCopy %d zaklad %d konec %d first %d \n\n",delkaCopy,zaklad,konec,first);
				//printf("vysledek  %s \n",attr);
			}
	//		while (delkaCopy==0 || HelpPocet!=2);
			//printf("Zacatek cyklu %s\n",line);
			//strcpy(I.I_Name,strtok(line, delimiter));
			//token=strtok(line,"<QZBOZI_TPV>");
			//token=strtok(NULL,"<\QZBOZI_TPV>");
			//printf("token %s \n",token);
			//ReadXML(line);


		//I.I_Name=strtok(line, delimiter);
			//puts(I.I_Name);
			//printf("%s\n", token);
			//strcpy(I.Attr_Matr, strtok(NULL, delimiter));
		//I.I_Popis=strtok(NULL, delimiter);
			//puts(I.I_Popis);
			//printf("%s\n", token);
			//strcpy(I.I_Popis, strtok(NULL, delimiter));
		//I.Attr_Matr=strtok(NULL, delimiter);
			//puts(I.Attr_Matr);
			//strcpy(I.Rozmer, strtok(NULL, delimiter));
		//I.Attr_Matr=strtok(NULL, delimiter);
			//puts(I.Rozmer);
			//strcpy(I.Attr3, strtok(NULL, delimiter));			
		//I.Attr3=strtok(NULL, delimiter);
			//puts(I.Attr3);
			//strcpy(I.Jednotka, strtok(NULL, delimiter));
		//I.Jednotka=strtok(NULL, delimiter);
			//puts(I.Jednotka);
			//strcpy(I.KlicTPV,strtok(NULL, delimiter));
		//I.KlicTPV=strtok(NULL, delimiter);
			//puts(I.KlicTPV);
			//strcpy(I.Typ,strtok(NULL, delimiter));
		//I.Typ=strtok(NULL, delimiter);
			//puts(I.Typ);
			//strcpy(I.Evid_cena,strtok(NULL, delimiter));
		//I.Evid_cena=strtok(NULL, delimiter);
			//puts(I.Evid_cena);
			//strcpy(I.Attr3, strtok(NULL, delimiter));
			//printf("%s\n", token);
			
			
			
			
			
			
			
			printf("pred importem \n");
			//(char* I_Name,char* I_popis, char* Attr_Matr,char* Velikost,char* Rozmer,char *Jednotka,char *KlicTPV,char *Typ,char *Evid_cena, char *Attr3)
			//Create(I.I_Name,I.I_Popis,I.Attr_Matr,I.Velikost,I.Rozmer,I.Jednotka,I.KlicTPV,I.Typ,I.Evid_cena,I.Attr3);
			printf("po importu \n");
		
			//Create(I.I_Name,I.Attr_Matr,I.I_Popis,I.Rozmer);

//	while(fgets(line, 1024, stream))
//{
//	fscanf(stream,"%[^,],%s",I.I_Name,I.Attr_Matr,I.Rozmer);
//	printf("tady : %s %s %s \n",I.I_Name,I.Attr_Matr,I.Rozmer);
//	//puts(I.I_Name);
//	//puts(I.Attr_Matr);
//	//puts(I.Rozmer);
//	Create(I.I_Name,I.Attr_Matr,I.I_Popis,I.Rozmer);
//}

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
			
			 Idd[ITEM_id_size_c + 1],
			 Namee[ITEM_name_size_c + 1];
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
				
				QRY_find("STS_NAK_POLOZKA", &query);
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
			 else if(strcmp(typ,"TPV4_h_material")==0)
			 {
				QRY_find("STS_HUT_MATERIAL", &query);
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
				if	(n_item == 1){
						printf("\n Nalezeno %d polozek\n", n_item);

			//		
			//			
						for(int i = 0; i < n_item; i++)
							{	
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