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

#include "Gtac_err_reports.h"
#include "Global_var.h"
#include "Dataset.h"
#include "Item_to_folder.h"
#include "Log_file.h"



//tag_t Schval_Item=NULLTAG;

int Existence(char hodnoty [20][256],char* typ, int typ_pol_num);
int GetAttr(char* attr,int polozka_num);

//void Log_err_delka_atr (char *attr,char *id,int delka_je)
//{
//				 log_tc::out << "Error delka \n" ;
//				 log_tc::out << "Polozka %s Attribut %s\n",id,attr ;
//				 log_tc::out << "maximalni delka je %d \n\n",delka_je; 
//				 char* log_text=(char*)calloc((64+strlen(attr)+strlen(id)+15),(sizeof(char*)));
//				 sprintf(log_text,"Error delka \nPolozka %s Attribut %s\nmaximalni delka je %d \n\n",id,attr,delka_je);
//				 WriteLogFile("C:\\SPLM\\APP\\Import_excel\\Import_xlsx_20200415.log" ,log_text);
//}
char* Owner(tag_t object)
{
	char* user_name;
	tag_t  owning_user;
	AOM_ask_owner(object,&owning_user);
	SA_ask_user_identifier2 ( owning_user, &user_name );
	return user_name; 
}
char* remove_end_spaces(char* text)
{
   int last = strlen(text) - 1;

  while (last >= 0 && text[last] == ' ')
  {
	  text[last]='\0';
    --last;
  }
  return text;
}
char* CreateLink2TC(tag_t Targets, char* html_adres)
{
	
	char link[256],
		//*adresa = "http://hestego:7001/tc/launchapp?-attach=true&-s=226TCSession&-o=",
		*adresa = "http://stv-tc:7001/tc/launchapp?-attach=true&-s=226TCSession&-o=",
		*append = "AAAAAAAAAAAAAA";
	
		char *Uid;
		ITK__convert_tag_to_uid(Targets, &Uid);
		strcpy(link, adresa);
		strcat(link, Uid);
		strcat(link, append);
		printf(" link %s \n",link);
	//	system("pause");
		//fprintf(stream, "%s \n", link);
	
	return link;
}
tag_t FindRev(char* itemId,char* revId)
{
				tag_t query = NULLTAG,
				* revs=NULLTAG;
				QRY_find("Item Revision...", &query);
				printf("tag foldru Qry General je %d\n",query);
				//system("pause");
				// Find user's "Tasks to Perform" folder
				char *entries[2] = {"Item ID","Revision"};
				char *values[2] =  {itemId,revId};
				int n_objects = 0;
				//strcpy(values[0],folder);
				
				printf("%d \n",__LINE__);			
				IFERR_REPORT(QRY_execute(query, 2, entries, values, &n_objects, &revs));
				printf("%d \n",__LINE__);
				printf(" objs %d \n",n_objects);
				//system("pause");
	tag_t findRev=*revs;
	if(revs) MEM_free(revs);
	return findRev;
}

	
void SetProperty (int polozka_num,int num,tag_t item,char* value)
{
	printf("\n _____\n SetProperty >>>%s \n,polozky_num %d \n num %d \n ",Attr_type[polozka_num][num],polozka_num, num);
	tag_t object_type=item;
	tag_t rev =NULLTAG;
	char typ_polozky[20];
	strcpy(typ_polozky,Attr_type[polozka_num][num]);
	char* tmp=strtok(typ_polozky,":");
	char* id_item;
	ITEM_ask_id2(item,&id_item);
	printf ("tmp %s \n",tmp);
	if(strcmp(tmp,"Rev")==0)
	{
		
		//tag_t rev =NULLTAG;
		ITEM_ask_latest_rev(object_type,&rev);
		printf("je ren tag rev %d tag item %d \n",rev,object_type);
		object_type=rev;
		
		strcpy(typ_polozky,strtok(NULL," "));
		
		AOM_lock(rev);

	}
	else printf("neni rev \n");
	if(strcmp(typ_polozky,"<string")==0)
	{
		//value=OpravCz(value);
		printf ("string attr %s   |%s| \n",Attr[polozka_num][num],value);
		if(strcmp(value,"-")!=0 ||strcmp(value,"- ")!=0)
		{
			value=remove_end_spaces(value);
			printf("value %s \n",value);
			int delka_string=0;
			 AOM_ask_max_string_length(object_type,Attr[polozka_num][num],&delka_string);
			 printf("porovnani %d x %d \n",delka_string,strlen(value));
			 if(delka_string>=strlen(value))
			 {		
					ERROR_CHECK(AOM_set_value_string(object_type,Attr[polozka_num][num],value));
			 }else 
			 {
				 printf("%d\n",__LINE__);
				 char* zkraceny= (char *)calloc(delka_string+1,sizeof(char*));
				 strncpy(zkraceny,value,delka_string);
				 InfoLog(LogFileName,"Atribut ",Attr[polozka_num][num]," je prilis dlouhy");
					//Log_err_delka_atr (Attr[polozka_num][num],id_item,delka_string); //logovani 
				 InfoLog(LogFileName,"\t uprava delky ",zkraceny,"");
				 ERROR_CHECK(AOM_set_value_string(object_type,Attr[polozka_num][num],value));
				 if(zkraceny) free(zkraceny);
			 }
			// system("pause");
		}
	}
	//else if ()
	//{
	//		LOV_find(Lov, &n_lovs, &lov_tag);
	//		LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	//			for (int j = 0; j<n_values; j++)
	//			{

	//				//printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
	//				if (strcmp(values_dissplay[j], value) == 0)
	//				{
	//					//printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
	//					ERROR_CHECK(AOM_set_value_string(object_type,Attr[polozka_num][num],values[j]));

	//					j = n_values;
	//				}
	//			}
	//}
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
		if(strcpy(value," ")!=0)
			ERROR_CHECK(AOM_set_value_int(object_type,Attr[polozka_num][num],tmp_int));
	}
	else if(strcmp(typ_polozky,"<double")==0)
	{	
		for(int i=0;i<strlen(value);i++)
		{
			if(value[i]==',')
				value[i]='.';
		}
		double tmp_double=atof(value);
		printf ("double attr %s \n v= %s dv=%f\n",Attr[polozka_num][num],value,tmp_double );
		if(strcpy(value," ")!=0)
			ERROR_CHECK(AOM_set_value_double(object_type,Attr[polozka_num][num],tmp_double));
		printf ("line: \n",__LINE__);
	//	system("pause");
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
	{ char* tmp_text;

	ERROR_CHECK(AOM_ask_value_string(object_type,from_copy,&tmp_text));
	ERROR_CHECK(AOM_set_value_string(object_type,to_copy,tmp_text));

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
		//printf("<<<add_string %d\n",i_num);
		ERROR_CHECK(AOM_get_value_double(object_type,from_add[i_num],&tmp_double));
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
		
	}else if(strcmp(typ_polozky,"<variable")==0){
		printf("vyriable %d %d %s\n poradi %d \n",item,rev,value, poradi_seznam);
		char*itemId;
		char*revId;
		ITEM_ask_id2(item,&itemId);
		ITEM_ask_rev_id2(rev,&revId);
		strcpy(seznam[poradi_seznam].obj_id,itemId);
		strcat(seznam[poradi_seznam].obj_id,"\\");
		strcat(seznam[poradi_seznam].obj_id,revId);
		//system("pause");
		seznam[poradi_seznam].uzelItem=item;
		seznam[poradi_seznam].uzelRev=rev;
		strcpy(seznam[poradi_seznam].uzel_name,value);
		printf("vyriable %d %d %s\n poradi %d \n",seznam[poradi_seznam].uzelItem,seznam[poradi_seznam].uzelRev,seznam[poradi_seznam].uzel_name,value, poradi_seznam);
		//system("pause");
		poradi_seznam++;
	}
	else if(strcmp(typ_polozky,"<import_dataset")==0)
	{
		//system("pause");
		printf ("IMPORT DATASET %s   %s \n",Attr[polozka_num][num],value);
		InfoLog(LogFileName,"IMPORT DATASET ",Attr[polozka_num][num],value);
		
		//system("pause");
		if(strlen(value)>5)
		{
			//system("pause");
			char *id_item;
			char *id_rev;
			char dataset_name[20];
			tag_t dataset;
			AOM_ask_value_string(item,"item_id",&id_item);
			AOM_ask_value_string(rev,"item_revision_id",&id_rev);
			strcpy(dataset_name,id_item);
			strcat(dataset_name,"_");
			strcat(dataset_name,id_rev);
			create_dataset(Attr[polozka_num][num], dataset_name, item,  rev, &dataset);

			/*strcpy(way,"C:\\SPLM\\APP\\PDFCreate\\vystup\\");
			strcat(dataset_name,".pdf ");
			strcat(way,dataset_name);
		

			printf("\n  fileName= %s \n",fileName);*/
			if(strcmp(Attr[polozka_num][num],"PDF")==0)
			{	
				strcat(dataset_name,".pdf");
				importDatates(dataset,value,"PDF_Reference",dataset_name);
				
			}else if(strcmp(Attr[polozka_num][num],"DXF")==0)
			{
				strcat(dataset_name,".dxf");
				importDatates(dataset,value,"DXF",dataset_name);
			}

		}
	}

	AOM_save(object_type);
	AOM_unlock(object_type);
	
//printf("TypPolozky_num %d t %d IRev %d hodnoty [%d] %s \n Attr_type[%d][%d] %s \n Attr[%d][%d] %s \n \n",polozka_num,num,object_type,num,value,polozka_num,num,Attr_type[polozka_num][num],polozka_num,num,Attr[polozka_num][num]);
}

void Create(char hodnoty[50][256],int TypPolozky_num, tag_t owner, tag_t ownerGroup){
	printf("---Create \n");
		tag_t Item = NULLTAG;
		tag_t IRev = NULLTAG;
		tag_t itemType = NULLTAG;
		tag_t revType = NULLTAG;
		tag_t createItem = NULLTAG;
		tag_t createRev = NULLTAG;
		char typRevize[20],
			typItem[20];
		char* zalozenyItemID;

	//revise
		strcpy(typRevize,Attr[TypPolozky_num][0]);
		strcat(typRevize,"Revision");
		//strcpy(typItem,"H4_NakupovanyMat"),
		strcpy(typItem,Attr[TypPolozky_num][0]);

		TCTYPE_find_type(typRevize, NULL, &revType);
		if (revType == NULLTAG) {
			printf("Spatny typ revize");
			InfoLog(LogFileName,"Spatny typ revize ","","");
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
			char obj_name[41];
			strncpy(obj_name,hodnoty[num_name],40);
			AOM_set_value_string(createItem, "object_name",obj_name);
			int num_id=GetAttr("item_id",TypPolozky_num);
			if(num_id!=0)
				AOM_set_value_string(createItem, "item_id",hodnoty[num_id]);
		
			TCTYPE_create_object(createItem, &Item);
			TCTYPE_create_object(createRev, &IRev);
			int ReturnCode = AOM_save(Item);
			printf ("Save Item %d \n",ReturnCode);
			int num=GetAttr("<folder",TypPolozky_num);
			printf ("%d folder %s\n",num,Attr[TypPolozky_num][23]);
			/*SetProperty (TypPolozky_num,23,Item,hodnoty[23]);*/
			AOM_lock(Item);
			for (int i=0;i<Attr_num-1;i++)
			{
				if(i!=num_name)
				SetProperty(TypPolozky_num,i,Item,hodnoty[i]);
			}
			//printf(" vlastnik  %d group %d \n",owner ,ownerGroup);
			
			//int IERROR=AOM_set_value_string(Item,"tpv4_stav_polozky","Neopravena z ERP");
				//printf ("Err %d string attr \n",IERROR);
		
			AOM_save(Item);
			AOM_unlock(Item);
			ITEM_ask_id2(Item,&zalozenyItemID);
			InfoLog(LogFileName,"Zalozena polozka ",zalozenyItemID,"");
		}
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
int Existence(char hodnoty [20][256],char* typ, int typ_pol_num)
	{
			int Vytvor=0;
			char* hledany_x=NULL;
				//* hledany_y=NULL,
			

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
					InfoLogInt(LogFileName,"Nalezenych objektu se stejnym dle vyhledavacich kriteri ",n_item," ");
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