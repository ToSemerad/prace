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
#include <ae\ae.h>
#include <tccore\grm.h>
#include <unidefs.h>
#include <errno.h>
#include <string>
#include <tccore\aom.h>

int Attr_num=0 ;
int Remove_line=0;
char Attr [10][30][128];
char Attr_type [10][30][128];
char* import_file[50];

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

int CountInRelation(tag_t Otec,char * Relation)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	printf("find relation %d \n",relation_type);
	 err=GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}

	return Count;
}
void SetInt(tag_t object,int value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_int(object,prop,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno %d\n",value);
}
void SetString(tag_t object,char* value,char *prop)
{
	AOM_lock(object);
	AOM_set_value_string(object,prop,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno %s \n",value);
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
int getTagItem2(char *cislo_vykresu, char* date_import_adres)
{
	tag_t *Item;
		
	//char d_aktualizace[10];
	int import_day,
		import_month,
		import_yaer;
      

	if(SouborExistuje(date_import_adres)!=0){
		printf("file neexistuje \n");
		return 0;
	}else printf("soubor existuje\n");
	    FILE* stream = fopen(date_import_adres, "r");

    char line[1024];
	int c=0;
    while (fgets(line, 1024, stream))
    {
		if (strlen(line)>6)
		{
			char* tmp;
			tmp=strtok(line,"-");
			import_yaer=atoi(tmp);
			tmp=strtok(NULL,"-");
			import_month=atoi(tmp);
			tmp=strtok(NULL,"\0");
			import_day=atoi(tmp);
		}
    }
	

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("PoS_NAK_POLOZKA", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				printf("cislo vykresu %s \n",cislo_vykresu);
				char *entries[1] = {"NOMENKLATURA"};
				char *values[1] =  {cislo_vykresu};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Item);
				printf("pocet nalezu %d\n",n_folder);
				
				if(n_folder==0)
					return 0;
				for (int i =0;i<n_folder;i++)
				{ 
					date_t last_mod;
					

					AOM_ask_value_date(Item[i],"last_mod_date",&last_mod);
					//sprintf("
					if (last_mod.year>=import_yaer && last_mod.month>=import_month && last_mod.day>=import_day)
					//if (last_mod.day>=import_day)
					{
						printf("true -hledany den %d.%d.%d last_mod %d.%d.%d \n",import_day,import_month,import_yaer,last_mod.day,last_mod.month,last_mod.year);
						return *Item;
					}
					else 
					{
						printf("false -hledany den %d.%d.%d last_mod %d.%d.%d \n",import_day,import_month,import_yaer,last_mod.day,last_mod.month,last_mod.year);
						return 0;
					}
				}	
				
				//return Item[0];

	// ITEM_find_item	(	id_obj,&Item);	
	 return *Item;
}
int getTagItem(char *cislo_vykresu)
{
	tag_t *Item;
		

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("PoS_NAK_POLOZKA", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				printf("cislo vykresu %s \n",cislo_vykresu);
				char *entries[1] = {"NOMENKLATURA"};
				char *values[1] =  {cislo_vykresu};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Item);
				printf("pocet nalezu %d\n",n_folder);
				if(n_folder==0)
					return 0;

	//return Item[0];

	// ITEM_find_item	(	id_obj,&Item);	
	 return *Item;
}
int getTag_VD(char *id_obj)
{
	tag_t *ItemRev,
		Item;
		

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("PoS_DIL", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"CISLO VYKRESU"};
				char *values[1] =  {id_obj};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &ItemRev);
				printf("pocet nalezu %d\n",n_folder);
				if(n_folder==0)
					return 0;
	ITEM_ask_item_of_rev(ItemRev[0],&Item);
	return Item;

	/* ITEM_find_item	(	id_obj,&Item);	
	 return Item;*/
}

int getTag_HM(char *id_obj)
{
	tag_t *Item;
		

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("PoS_HUT_MATERIAL", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"NOMENKLATURA"};
				char *values[1] =  {id_obj};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Item);
				printf("pocet nalezu %d\n",n_folder);
				if(n_folder==0)
					return 0;

	return Item[0];

	 //ITEM_find_item	(	id_obj,&Item);	
	// return Item;
}



void CopyAttr_HM( tag_t Item,char *c_h_mat)
{
	char 
		*c_nak_pol,
		*c_poznamka,
		*c_material,
		*c_nomenklatura,
		*c_polotovar,
		*c_name,
		*c_id,
		n_polotovar[80];
		int id_erp=0,
			tag_hm;
		tag_t I_hm;
		
		if (strlen(c_h_mat)>6){

			printf("Cislo hut mat %s  \n",c_h_mat);
			tag_hm=getTag_HM(c_h_mat);
			if(tag_hm!=0)
			{	
				//printf("257 \n");
				char* stav;
				I_hm= tag_hm;
			/*	AOM_ask_value_string(I_hm,"tpv4_stav_polozky",&stav);
				if (strcmp(stav,"Zakaz pouziti")==0)
				{
					printf("Zakaz pouziti \n");
					strcat(error,"Zakaz pouziti ");
					strcat(error,c_h_mat);
					strcat(error,"\n");
					tag_t Object[1];
					Object[0]=I_hm;
					AddToRef(RootTask,Object,1,Rev);
				}
				else
				{*/
					
					//printf("Najdi HM %d  \n",Rev_hm);
				
					AOM_get_value_int(I_hm,"tpv4_klic_tpv_hm",&id_erp);
					AOM_ask_value_string(I_hm,"tpv4_poznamka_tpv",&c_poznamka);
					AOM_ask_value_string(I_hm,"object_name",&c_name);
					AOM_ask_value_string(I_hm,"tpv4_material",&c_material);
					AOM_ask_value_string(I_hm,"tpv4_nomenklatura",&c_nomenklatura);
					AOM_ask_value_string(I_hm,"tpv4_polotovar",&c_polotovar);
					AOM_ask_value_string(I_hm,"item_id",&c_id);
					
					printf("id Erp HM %d \n",id_erp);
					int countRevs_VD=0;
					tag_t *Revs_VD;
					ITEM_list_all_revs(Item,&countRevs_VD,&Revs_VD);
					for(int i=0;i<countRevs_VD;i++)
					{
					SetInt(Revs_VD[i],id_erp,"tpv4_klic_tpv_hm");
					SetString(Revs_VD[i],c_nomenklatura,"tpv4_cislo_vykresu_hm");
					strcpy(n_polotovar,c_name);
					strcat(n_polotovar," ");
					strcat(n_polotovar,c_polotovar);
					SetString(Revs_VD[i],n_polotovar,"tpv4_polotovar");
					SetString(Revs_VD[i],c_material,"tpv4_material");
					SetString(Revs_VD[i],c_poznamka,"tpv4_poznamka_tpv");
					SetString(Revs_VD[i],c_id,"tpv4_hutni_material");
					SetString(Revs_VD[i],c_name,"tpv4_nazev_hm");
					}
			//	}
			}else printf("nula polozek nalezeno - neexistuje hledana položka %s %d\n",c_h_mat,tag_hm);
		}else printf ("nevyplneny H_mat\n");
		
}

void ReadProperty()
{
//		printf(" Read Property \n");
//	//char*CSV = ITK_ask_cli_argument( "-u=");
//	char Path[50]="C:\\SPLM\\Apps\\Import_zmeny\\TPV2TC_property.xml";
//
//
//	    FILE* stream = fopen(Path, "r");
//		printf("Open %s\n",Path);
//    char line[1024],
//		*tmp;
//    while (fgets(line, 1024, stream))
//    {
//		
//		tmp=strtok(line,">");
//		
//		
//		//tmp=strtok(NULL,"<");
//		if (strcmp(tmp,"<polozka")==0)
//		{
//			Add_d_num[Type_num]=0;
//			Add_num[Type_num]=0;
//			Attr_num=0;
//			Remove_line=0;
//			printf("polozka %d \n",Attr_num);
//			goto nextLine;
//			
//		}
//		else if (strcmp(tmp,"<ItemType")==0)
//		{	strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			printf("ItemType attr %s \n",tmp);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//			Remove_line++;
//		}
//		else if(strcmp(tmp,"<string")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			//printf("string attr %s \n",tmp);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//		}else if(strcmp(tmp,"<int")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			//printf("int attr %s \n",tmp);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//
//		}else if(strcmp(tmp,"<double")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			//printf("double attr %s \n",tmp);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//
//		}else if(strcmp(tmp,"<date")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			printf("date attr %s %d %d \n",tmp,Type_num,Attr_num);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//
//		}else if(strcmp(tmp,"<folder")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			printf("folder attr %s \n %d %d \n",tmp,Type_num, Attr_num);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//			Remove_line++;
//			//tmp=strtok(
//		}else if(strcmp(tmp,"<copy_string")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
//			//strcpy(Attr[Type_num][Attr_num],tmp);
//			printf("value %s \n",tmp);
//			strcpy(from_copy,strtok(tmp,"#"));
//				printf("from %s \n",from_copy);
//			strcpy(to_copy,strtok(NULL,"#"));
//				printf("to %s \n",to_copy);
//				Remove_line++;
//			//tmp=strtok(
//		}
//		else if(strcmp(tmp,"<add_string")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			//printf(">>>copy_string attr %s - %d %d \n",tmp,Type_num, Add_num[Type_num]);
//			
//			//printf(">>>value %s \n",tmp);
//			strcpy(to_add,strtok(tmp,"#"));
//			//	printf(">>>to add %s \n",to_add);
//			strcpy(from_add[Add_num[Type_num]++],strtok(NULL,"#"));
//				//printf(">>>from add %d = %s \n",Add_num,to_copy);
//				
//				if(Add_num[Type_num]>1)
//				{
//					//printf(">>>goto num %d \n",Add_num[Type_num]);
//					goto nextLine;
//				}
//				else
//				{
//					//printf(">>>Remove_line num %d \n",Add_num[Type_num]);
//					Remove_line++;
//				}
//			//tmp=strtok(
//		}
//		else if(strcmp(tmp,"<add_double_string")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			printf(">>>copy_double_string attr %s - %d %d \n",tmp,Type_num, Add_d_num[Type_num]);
//			
//			printf(">>>value %s \n",tmp);
//			strcpy(to_add,strtok(tmp,"#"));
//				printf(">>>to add %s \n",to_add);
//			strcpy(from_add[Add_d_num[Type_num]++],strtok(NULL,"#"));
//				printf(">>>from add %d = %s \n",Add_d_num,to_copy);
//				
//				if(Add_d_num[Type_num]>1)
//				{
//					//printf(">>>goto num %d \n",Add_d_num[Type_num]);
//					goto nextLine;
//				}
//				else
//				{
//					//printf(">>>Remove_line num %d \n",Add_d_num[Type_num]);
//					Remove_line++;
//				}
//			//tmp=strtok(
//		}
//		else if(strcmp(tmp,"<set_string")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			printf("set_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
//			//strcpy(Attr[Type_num][Attr_num],tmp);
//			printf("value %s \n",tmp);
//			strcpy(attr_set[Type_num],strtok(tmp,"#"));
//				printf("attr %s \n",attr_set);
//			strcpy(value_set[Type_num],strtok(NULL,"#"));
//				printf("value %s \n",value_set);
//				printf ("\n SET String %s   %s \n \n",attr_set,value_set);
//				Remove_line++;
//			//tmp=strtok(
//		}
//		else if(strcmp(tmp,"<exist")==0)
//		{
//			//strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//			//printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
//			//strcpy(Attr[Type_num][Attr_num],tmp);
//			printf("exist %s \n",tmp);
//			strcpy(QueryExistenece[Type_num],strtok(tmp,"#"));
//				printf("query %s \n",QueryExistenece[Type_num]);
//			strcpy(EntryExistenece[Type_num],strtok(NULL,"#"));
//				printf("entry %s \n",EntryExistenece[Type_num]);
//			strcpy(AttryExistenece[Type_num],strtok(NULL,"#"));
//				printf("attr query existence %s \n",AttryExistenece[Type_num]);
//				Remove_line++;
//			//tmp=strtok(
//		}else if(strcmp(tmp,"<nowritte")==0)
//		{
//			strcpy(Attr_type[Type_num][Attr_num],tmp);
//			tmp=strtok(NULL,"<");
//		//	printf("noread \n",tmp);
//			strcpy(Attr[Type_num][Attr_num],tmp);
//
//		}
//				else if(strcmp(tmp,"<login")==0)
//		{
//			//strcpy(Attr_type[Type_num][Attr_num],tmp);
//			//tmp=strtok(NULL,">");
//			tmp=strtok(NULL,"<");
//			printf("login %s\n",tmp);
//			Attr_Typ_polozky=Attr_num;
//			strcpy(login,tmp);
//			goto nextLine;
//
//		}
//				else if(strcmp(tmp,"<psw")==0)
//		{
//			//strcpy(Attr_type[Type_num][Attr_num],tmp);
//			//tmp=strtok(NULL,">");
//			tmp=strtok(NULL,"<");
//			printf("password %s\n",tmp);
//			Attr_Typ_polozky=Attr_num;
//			strcpy(password,tmp);
//			goto nextLine;
//
//		}
//			else if(strcmp(tmp,"<group")==0)
//		{
//			//strcpy(Attr_type[Type_num][Attr_num],tmp);
//			//tmp=strtok(NULL,">");
//			tmp=strtok(NULL,"<");
//			printf("group %s\n",tmp);
//			Attr_Typ_polozky=Attr_num;
//			strcpy(group,tmp);
//			goto nextLine;
//
//		}
//		else if(strcmp(tmp,"<importFolder")==0)
//		{
//			//strcpy(Attr_type[Type_num][Attr_num],tmp);
//			//tmp=strtok(NULL,">");
//			tmp=strtok(NULL,"<");
//			printf("import file %s\n",tmp);
//			Attr_Typ_polozky=Attr_num;
//			strcpy(import_file,tmp);
//
//			goto nextLine;
//
//		}
//		//else if(strcmp(tmp,"<inside")==0)
//		//{
//		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
//		//	tmp=strtok(NULL,"<");
//		//	printf("inside \n",tmp);
//		//	Attr_Typ_polozky=Attr_num;
//
//		//}
//		else if(strcmp(tmp,"</polozka")==0)
//		{
//			//printf("polozka konec \n");
//			Type_num++;
//			goto nextLine;
//		}
//		else goto nextLine;
//
//
//		tmp=strtok(NULL,">");
//
//		/*if( strcmp(tmp,"<TPV2000")==0)
//		{
//			tmp=strtok(NULL,"<");
//			printf("TPV attr %s \n",tmp);
//			strcpy(Attr_tpv[Type_num][Attr_num],tmp);
//
//		}*/
//		printf("konec %s %d\n",tmp,Attr_num);
//		
//
//	//tmp=strtok(NULL,">");
//	//tmp=strtok(NULL,"<");
//	//printf("tmp %s \n",tmp);
//	//tmp=strtok(NULL,">");
//		Attr_num++;
//		nextLine:;
//			}
//
//
////}
//			fclose(stream);
//printf("-----Attr_num %d -----\n",Attr_num);
}

 

void ReadCSV(char* string)
{
	char *tmp;
	int typ=0;
//	char *tmp_field;
	
	char hodnoty[50][256];
	//printf("string %s \n",string);
	//printf("Attr_num %d Remove %d \n",Attr_num,Remove_line);
	for(int t=0;t<3;t++)
		strcpy(hodnoty[t]," ");
	//int i=1;
	tmp=strdup(string);
	strcpy(hodnoty[1],strtok(string,";"));
	printf(" %d Field  %s\n\n",1,hodnoty[1]);
	
		for (int i =2;i<5;i++)
	{
			strcpy(hodnoty[i],strtok(NULL,";"));
			printf(" %d Field  %s\n\n",i,hodnoty[i]);
		}
		tag_t VD_rev=getTag_VD(hodnoty[3]);
	    //free(tmp);
		//free(tmp_field);
		if(VD_rev!=0)
			CopyAttr_HM(VD_rev,hodnoty[2]);
		else printf ("VD_rev %d \n",VD_rev);
		
		/*free(hodnoty);*/
}

int main(int argc, char *argv[])
{
	//ReadProperty();
	//if (ITK_init_from_cpp(argc,argv)!=ITK_ok)
	//{

    // ITK initialization
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);

    // Login
    int ReturnCode = TC_init_module("jindriska.slezakova", "tc", "ARCHIV TK.PoS");
    if(ReturnCode != ITK_ok)
    {
        char *Message;
        EMH_ask_error_text(ReturnCode, &Message);
        fprintf(stderr, "ERROR: %s\n", Message);
		return ITK_ok;
    }
    printf("Login OK\n");
	
	char*last_import = ITK_ask_cli_argument( "-d=");


	
	//char *TP="ZAA 000 000";
    // Vyhledání položek
	char*CSV = ITK_ask_cli_argument( "-s=");
	char CSVFile[50];
	strcpy(CSVFile,"C:\\SPLM\\Apps\\Spoj_HM\\cvs\\");
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
		if(strchr(line,';')!=NULL)
			ReadCSV(line);
      
    }
		//tag_t dataset=NULLTAG;
		//create_dataset("PDF", "test", Items[i], Rev, &dataset);
		// importDatates(dataset,"C:\\PDF\\1082731.pdf","PDF_Reference","1082731.pdf");
end:;
    // ITK exit
    ITK_exit_module(true);
    return 0;
}