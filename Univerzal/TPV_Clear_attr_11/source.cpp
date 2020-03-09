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
#include <tc/emh.h>
#include <error.h>

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
	to_copy[20];

int Type_num=0;
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

static void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;
		EMH_get_error_string(NULLTAG, return_code, &error_message_string);
		printf("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string);
		printf("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line);
		if (error_message_string) MEM_free(error_message_string);
		printf("\nExiting program!\n");
	//	exit(EXIT_FAILURE);
	}
}


void ClearStringProperty (tag_t ItemRev, char* attr)
{
	ITK_set_bypass(TRUE);
	IFERR_REPORT(AOM_lock(ItemRev));
	printf (" rev %d attr %s \n",ItemRev,attr);
	IFERR_REPORT(AOM_set_value_string(ItemRev,attr,""));
	IFERR_REPORT(AOM_save(ItemRev));
	IFERR_REPORT(AOM_unlock(ItemRev));
	
	IFERR_REPORT(AOM_refresh(ItemRev,true));
	ITK_set_bypass(FALSE);
}

int main(int argc, char *argv[])
{

  
   if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }
	//printf("2\n");
    ITK_initialize_text_services(0);

   char*login = ITK_ask_cli_argument( "-u=");
   char*password = ITK_ask_cli_argument( "-p=");
   char*group = ITK_ask_cli_argument( "-g=");
   char*item = ITK_ask_cli_argument( "-i=");
   char*rev = ITK_ask_cli_argument( "-r=");
   char*atribut = ITK_ask_cli_argument( "-a=");
   tag_t itemRev;
    printf (" %s \n %s \n %s \n %s \n %s \n %s \n",login,password,group,item,rev,atribut);
//	printf("3\n");
    // Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
        fprintf(stderr, "ERROR: Login failed\n");
        return 1;
    }
    printf("Login OK\n");
	int err=ITEM_find_rev	(item,rev,&itemRev);
	printf ("err %d \n",err);
	if(strlen(item)!=0 || strlen(rev)!=0)
	{	printf("%s/%s \n",item,rev);
		IFERR_REPORT (ITEM_find_rev	(item,rev,&itemRev));
		printf("nalezena revize %d \n",itemRev);
		ClearStringProperty (itemRev,atribut);
		printf("smazan attribut\n");
	}
    return 0;
}
