#include <iostream>

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

void ReadCSV(char* string,int nastavenyTyp,int Attr_num, int Remove_line)
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
		strcpy(hodnoty[i],strtok(NULL,"#"));
			printf(" %d Field  %s\n\n",i,hodnoty[i]);

		
	}
	    //free(tmp);
		//free(tmp_field);
		
		/*free(hodnoty);*/
}