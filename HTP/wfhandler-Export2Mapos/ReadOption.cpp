#include <stdio.h>
#include <string.h>


char Attr[10][30][128];
char Attr_type[10][30][128];
int Type_num = 0;
int Add_num[10];
int Add_d_num[10];
int Attr_num = 0;
int Remove_line = 0;
int Attr_Typ_polozky = 0;

char login[20],
password[30],
import_file[50],
group[20],
from_copy[20],
from_add[20][20],
to_add[20],
to_copy[20];


void ReadProperty(char* fileOption)
{
	printf(" Read Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char Path[50] = "C:\\SPLM\\Apps\\Export\\";
	printf(" %d fileOption %s \n", __LINE__, fileOption);
	strcat(Path, fileOption);
	printf(" read file %s \n", Path);
	//	system ("pause");
	FILE* stream = fopen(Path, "r");
	printf("Open %s\n", Path);
	char line[1024],
		*tmp;
	while (fgets(line, 1024, stream))
	{

		tmp = strtok(line, ">");

		printf("line pred %s> \n", tmp);
		//system("pause");
		//tmp=strtok(NULL,"<");
		if (strcmp(tmp, "<polozka") == 0)
		{
			Add_d_num[Type_num] = 0;
			Add_num[Type_num] = 0;
			Attr_num = 0;
			Remove_line = 0;
			printf("polozka %d \n", Attr_num);
			//system("pause");
			goto nextLine;

		}
		else if (strcmp(tmp, "<ItemType") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("ItemType attr %s \n", tmp);
			strcpy(Attr[Type_num][Attr_num], tmp);
			Remove_line++;
		}
		else if (strcmp(tmp, "<string") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if (strcmp(tmp, "<uom_string") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if (strcmp(tmp, "Rev:<string") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if (strcmp(tmp, "Rev:<uom_string") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("string attr %s \n", tmp);
			//system("pause");
			strcpy(Attr[Type_num][Attr_num], tmp);
		}
		else if (strcmp(tmp, "<int") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			//printf("int attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		else if (strcmp(tmp, "Rev:<int") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("int attr %s \n", tmp);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		else if (strcmp(tmp, "<double") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			//printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		else if (strcmp(tmp, "Rev:<double") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("double attr %s \n", tmp);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		else if (strcmp(tmp, "<date") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("date attr %s %d %d \n", tmp, Type_num, Attr_num);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		else if (strcmp(tmp, "Rev:<date") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("date attr %s %d %d \n", tmp, Type_num, Attr_num);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		else if (strcmp(tmp, "Rev:<bin_status") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			printf("date attr %s %d %d \n", tmp, Type_num, Attr_num);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}


		

	
				
		
		else if (strcmp(tmp, "<noread") == 0)
		{
			strcpy(Attr_type[Type_num][Attr_num], tmp);
			tmp = strtok(NULL, "<");
			//	printf("noread \n",tmp);
			strcpy(Attr[Type_num][Attr_num], tmp);

		}
		
		
		else if (strcmp(tmp, "</polozka") == 0)
		{
			//printf("polozka konec \n");
			Type_num++;
			goto nextLine;
		}
		else goto nextLine;


		tmp = strtok(NULL, ">");

		/*if( strcmp(tmp,"<TPV2000")==0)
		{
			tmp=strtok(NULL,"<");
			printf("TPV attr %s \n",tmp);
			strcpy(Attr_tpv[Type_num][Attr_num],tmp);

		}*/
		printf("konec %s %d\n", tmp, Attr_num);


		//tmp=strtok(NULL,">");
		//tmp=strtok(NULL,"<");
		//printf("tmp %s \n",tmp);
		//tmp=strtok(NULL,">");
		Attr_num++;
	nextLine:;
	}


	//}
	printf("-----Attr_num %d -----\n", Attr_num);
}