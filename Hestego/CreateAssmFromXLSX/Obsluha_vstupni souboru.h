#include <iostream>

#include "Polozka.h"
#include "Create_Bom_View.h"


struct Radek{
	
	Uzel tento;
	Uzel rodic;
	int level;
	char mnozstvi[5];
	char fnd_no[16];
	
};
Radek *excel_radek;

Uzel prazdny;
Uzel vrchol_uzel;
			
int GetLineFile(char* filePath)
{
		unsigned int number_of_lines = 0;
    FILE *infile = fopen(filePath, "r");
    int ch;

    while (EOF != (ch=getc(infile)))
        if ('\n' == ch)
            ++number_of_lines;
    printf("%u\n", number_of_lines);
	return number_of_lines;
}
int GetRodic(Radek *aktulani,int pozice,int level)
{
	printf("aktulanilevel %d==%d mensi i=%d\n",aktulani[pozice].level,(level-1),pozice);
	while((pozice)>0)
	{ 
		printf("aktulanilevel %s %d==%d mensi i=%d\n",aktulani[pozice].tento.obj_id,aktulani[pozice].level,level-1,pozice);
		//system("pause");;
		if(aktulani[pozice].level==(level-1))
		{
			printf("aktulanilevel %s %d==%d mensi i=%d\n",aktulani[pozice].tento.obj_id,aktulani[pozice].level,level-1,pozice);
		return pozice;
		}
		pozice--;
	}
	printf("return pozice %s %d \n",aktulani[pozice].tento.obj_id,pozice);
	return pozice;
}
Uzel GetUzel(char hledanyName[])
{	
	//char hledanyUzel[10];
	//sscanf(hledanyName,"%s ",hledanyUzel);
	printf("----GetUzel---\n seznam = %d \n",poradi_seznam);
	for(int i=0;i<poradi_seznam;i++)
	{
		printf("hledani %d = %s ? %s %d\ndelak retezcu %d = %d\n",i,seznam[i].uzel_name,hledanyName,strcmp(seznam[i].uzel_name,hledanyName),strlen(seznam[i].uzel_name),strlen(hledanyName));
		//system("pause");;
		if(strcmp(seznam[i].uzel_name,hledanyName)==0)
			{		
				printf("GetUzel %d / %d \n",seznam[i].uzelItem,seznam[i].uzelRev);
				return seznam[i];
			}
	}
	return prazdny;
}
Uzel NajdiUzel(char item_rev_id[])
{
	tag_t item=NULLTAG,rev=NULLTAG;
	char find_item_id [20];
	char find_rev_id [4];
	char * pch;
	//char* find_item_id_new;
	//sscanf(item_rev_id,"%*s/%s",find_item_id,find_rev_id);
	  pch=strchr(item_rev_id,'/');
  if (pch!=NULL)
  {
		printf("%d\n",__LINE__);
		strcpy(find_item_id,strtok(item_rev_id,"/"));
		printf("%d\n",__LINE__);
		strcpy(find_rev_id,strtok(NULL," "));
		printf("%d\n",__LINE__);
		printf("|%s| |%s| \n",find_item_id,find_rev_id);
  }else 
  {
	  int c=0;
	   while (item_rev_id[c] != '\0')
   {
      if ((item_rev_id[c] == ' ' && item_rev_id[c+1] == '\0')) 
        find_item_id[c] = item_rev_id[c+1];
     else    
        find_item_id[c] = item_rev_id[c];
      
      c++;
   }
	  printf("%d\n",__LINE__);
		printf("|%s| |%s| \n",find_item_id,find_rev_id);
  }
		char oddelovac[1];
		printf("%d\n",__LINE__);
		for (int i =0;i<20;i++)
		{
			if(find_item_id[i]==' ')
			{
				for(int f=0;f<20-i;f++)
					find_item_id[f]=find_item_id[f+1];
			}
			else break;
		}

  printf("|%s| |%s| \n",find_item_id,find_rev_id);
		int err=ITEM_find_item(find_item_id,&item);
		printf("%d pch %c \n",__LINE__,pch);
	if (pch!=NULL)
	{
		printf("%d\n",__LINE__);
		err=ITEM_find_revision(item,find_rev_id,&rev);
		printf(" %d / %d \n",item,rev);
	}else
	{
		int err=ITEM_find_item(find_item_id,&item);
		printf("%d\n",__LINE__);
		if (item !=NULLTAG) 
			ITEM_ask_latest_rev(item,&rev);
		
		printf(" %d / %d \n",item,rev);
		//system("pause");;
	}
	//system("pause");;

	Uzel nalezeny;
	nalezeny.uzelItem=item;
	nalezeny.uzelRev=rev;
	strcpy(nalezeny.uzel_name,item_rev_id);
	printf("%d\n",__LINE__);
	return nalezeny;
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

void ReadCSV(char* string,int nastavenyTyp,int Attr_num, int Remove_line, tag_t owner,tag_t ownerGroup)
{
	
	char *tmp;
	int typ=nastavenyTyp;
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
	
	for (int i =2;i<=Attr_num-Remove_line;i++)
	{
		printf ("i=%d \n",i);
		strcpy(hodnoty[i],strtok(NULL,"#"));
			printf(" %d Field  %s\n\n",i,hodnoty[i]);

		
	}
	printf("konec \n");
	//system("pause");;
	Create(hodnoty,nastavenyTyp,owner,ownerGroup);
	    //free(tmp);
		//free(tmp_field);
		
		/*free(hodnoty);*/
}
void VyplnRadek(int c,int level,char* mnozstvi,char* nazevUzlu,char* fnd_num)
{
	excel_radek[c].level=level;
			
			if (strcmp(mnozstvi," ")==0||strcmp(mnozstvi,"  ")==0)
				strcpy(excel_radek[c].mnozstvi,"1");
			else strcpy(excel_radek[c].mnozstvi,mnozstvi);
			strcpy(excel_radek[c].fnd_no,fnd_num);
			printf("Hledani rodièe %d :\n",c);
			if(c>0)
				excel_radek[c].rodic=excel_radek[GetRodic(excel_radek,c,level)].tento;
			else
				{
					excel_radek[c].rodic=vrchol_uzel;
					printf (" %d / %d \n",vrchol_uzel.uzelItem,vrchol_uzel.uzelRev);
				//	//system("pause");;
					//printf("%d  chyba vyplneni rodice \n",__LINE__);
				}
			printf ("nazevUzlu %s len %d \n",nazevUzlu,strlen(nazevUzlu));
			if(strlen(nazevUzlu)>6)
			{	char item_rev_id[20];
				strcpy(item_rev_id,nazevUzlu);
				excel_radek[c].tento=NajdiUzel(item_rev_id);
			}else
				excel_radek[c].tento=GetUzel(nazevUzlu);
}

void Readkusovnik(char* filePath)
{
	vrchol_uzel.uzelItem=NULLTAG;
	ITEM_ask_item_of_rev(Vrchol,&vrchol_uzel.uzelItem);
	vrchol_uzel.uzelRev=Vrchol;
	strcpy(vrchol_uzel.uzel_name,"Vrch");

	prazdny.uzelItem=NULLTAG;
	prazdny.uzelRev=NULLTAG;
	strcpy(prazdny.uzel_name,"NULL");

	excel_radek= (Radek *)calloc(GetLineFile(filePath),sizeof(Radek));
	char line[1024];
	int c=0;
	int seq_num=0;
	 FILE* stream = fopen(filePath, "r");
	 int level=0;
	 int sloupec=0;
    while (fgets(line, 1024, stream))
    {
		printf("line %d c = %d delka radku %d",__LINE__,c,strlen(line));
	if(strlen(line)>4)
		//system("pause");;
	if(strcmp(line," # # # # #")==0|| strlen(line)<12)
	{
		printf("\n	prazdny rade \n");
		printf(" line |%s| \n",line);
		//system("pause");;
	}
	else
		if(strchr(line,'#')!=NULL)
		{
			printf(" line |%s| \n",line);
			level=0;
		//	if(strchr(line,'#')!=NULL)
			char* tmp=strtok(line,"#");
			printf("%d %s \n",strlen(tmp), tmp);
			//system("pause");;
			if (strlen(tmp)==1)
				while (tmp!=NULL)
				{
				
					printf("%d %s \n level=%d \n",strlen(tmp), tmp,level);
				
					//printf ("i=%d \n",i);
					//strcpy(hodnoty[i],strtok(NULL,"#"));
						//printf(" %d Field  %s\n\n",i,hodnoty[i]);
					if (strlen(tmp)>1)
					{
						//if(c>0 && excel_radek[c-1].level) //dopsat vyplnení fnd
						char *mnozstvi=strtok(NULL,"#");
						//printf("fnd_num %s delka %d \n",mnozstvi,strlen(mnozstvi));
						//system("pause");;
						char seq_num_text[5];
						char nazevU [20];
						strcpy(nazevU,tmp);
						sprintf(seq_num_text,"%d",seq_num);
						printf("seq_num %d text %s mnozstvi |%s| \n",seq_num,seq_num_text,mnozstvi);
					//	//system("pause");;
						VyplnRadek(c, level, mnozstvi,nazevU,seq_num_text);
					}
					tmp=strtok(NULL,"#");
					printf("strtok %s \n",tmp);
					sloupec++;
					if(level==0 || sloupec%2!=0)
						{
							level++;
					}
				}
			else {
				printf("else \n");
				char *mnozstvi=strtok(NULL,"#");
				printf("mnozstvi %s \n",mnozstvi);
				char seq_num_text[5];
				char nazevU [20];
				strcpy(nazevU,tmp);
				sprintf(seq_num_text,"%d",seq_num);
				printf("%d %d %s %s %s\n",c, level,mnozstvi,nazevU,seq_num_text);
			
				VyplnRadek(c, level, mnozstvi,nazevU,seq_num_text);
			}
		
		
			printf("excel_radek: \n %s lvl %d qnt %s fnd s%\n_____________\n"
				,excel_radek[c].tento.uzel_name,excel_radek[c].level,excel_radek[c].mnozstvi,excel_radek[c].fnd_no);
		
			printf("rodic: \n %s \n",excel_radek[c].rodic.uzel_name);
			//system("pause");;
			printf("\n------------------------------------\n");
			c++;
		}
		printf("dalsi ciklus \n");
	}
	fclose(stream);
	printf("\n_______________\n Vypis kusovniku: \n");
	printf("Uzel	LVL	QNT	FND	PRNT\n");
	//system("pause");;
	tag_t BomWindow;
	for(int t=0;t<c;t++)
	{
		printf("radek importu %d %d \n",c,t);
		
		printf("%s	%d	%s	%s	\n ITEM=%d REV=%d\n"
			,excel_radek[t].tento.uzel_name
			,excel_radek[t].level
			,excel_radek[t].mnozstvi
			,excel_radek[t].fnd_no
			,excel_radek[t].tento.uzelItem
			,excel_radek[t].tento.uzelRev);
		printf("%s=RODIC ITEM=%d REV=%d\n",excel_radek[t].rodic.uzel_name,excel_radek[t].rodic.uzelItem,excel_radek[t].rodic.uzelRev);
		//system("pause");;
		
	//	if(excel_radek[t].level>0)
	//	{
		Make_View (excel_radek[t].rodic.uzelRev,excel_radek[t].rodic.uzelItem, excel_radek[t].tento.uzelRev, &BomWindow, excel_radek[t].fnd_no, excel_radek[t].mnozstvi);
		printf(" After create View %d \n",BomWindow);
		if(owner!=NULLTAG && BomWindow!=NULLTAG)
			{	
				ITK_set_bypass(true);
				printf("BW vlastneno %s \n",Owner(BomWindow));
				AOM_set_ownership(BomWindow,owner ,ownerGrup);			
				printf("BW vlastneno %s \n",Owner(BomWindow));
				AOM_save(BomWindow);
				//system ("pause");
				ITK_set_bypass(false);
				
			}
		//system("pause");;
		//}else printf("TOTO BYL VRCHOL \n");
	}
	if(excel_radek) free(excel_radek);
}