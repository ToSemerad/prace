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
#include <tc\folder.h>

/// reportovani by Gtac
#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, (X)));
#define IFERR_RETURN(X) if (IFERR_REPORT(X)) return
#define IFERR_RETURN_IT(X) if (IFERR_REPORT(X)) return X

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
		exit(EXIT_FAILURE);
	}
}
void MoveTPToFolder(tag_t folder,tag_t object)
{ 
   //insert to folder
    AOM_refresh( folder, TRUE);
    FL_insert(folder, object, 0);
    AOM_save(folder);
    AOM_refresh( folder, TRUE);
	printf("vlozeno!!!!!!!!!!!\n");
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
				printf(" 62 pocet nalezu %d\n",n_folder);

				//vloženi do folder TPianty
				MoveTPToFolder(*folder,Item);
}
int CountInRelation(tag_t Child,char * Relation)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}
	printf("find relation %d \n",relation_type);
	 err=GRM_list_primary_objects_only(Child, relation_type, &Count, &secondary_list);
	if(err!=ITK_ok){printf("Problem err %d \n",err);}

	return Count;
}
 tag_t create_relation(char relation_type[GRM_relationtype_name_size_c + 1], tag_t primary_object_tag, tag_t secondary_object_tag)
{
    tag_t relation_type_tag = NULLTAG;
    IFERR_REPORT(GRM_find_relation_type(relation_type, &relation_type_tag));
	printf("realtion type_%d \n -primary_object_tag %d \n -secondary_object_tag %d \n",relation_type_tag,primary_object_tag, secondary_object_tag);
    tag_t relation_tag  = NULLTAG;
    IFERR_REPORT(GRM_create_relation(primary_object_tag, secondary_object_tag, relation_type_tag, NULLTAG, &relation_tag));

    IFERR_REPORT(GRM_save_relation(relation_tag));
    return relation_tag;
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
void Send2Folder(tag_t *Rev,int count_rev)
{
	tag_t tmp=NULLTAG;
	tag_t Item;
	for (int i=0;i<count_rev;i++)
	{
				ITEM_ask_item_of_rev(Rev[i],&Item);
						if(Item!=tmp)
						{
							tmp=Item;
							IntoFolder("Manual_connect",Item);
						}			
	}
}
int getTagItem2(char *cislo_vykresu, char* date_import_adres, tag_t Part)
{
	tag_t Item,
		*Rev;
	char d_aktualizace[10];
	int import_day,
		import_month,
		import_yaer;
      

	/*if(SouborExistuje(date_import_adres)!=0){
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
	*/

				tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("Hestego_search", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				printf("cislo vykresu %s \n",cislo_vykresu);
				char *entries[1] = {"vykres_norma"};
				char *values[1] =  {cislo_vykresu};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Rev);
				printf("pocet nalezu %d\n",n_folder);
				
				if(n_folder==0)
					return 0;
				else if (n_folder==1)
					return *Rev;
				else if (n_folder>1)
				{
					tag_t tmp=NULLTAG;
					ITEM_ask_item_of_rev(Rev[0],&tmp);
					for (int i=i;i<n_folder;i++)
					{
						
						ITEM_ask_item_of_rev(Rev[i],&Item);
						if(Item!=tmp)
						{
							 Send2Folder(Rev,n_folder);

							 IntoFolder("Manual_connect",Part);
							return -1;
						}
					}
					return Rev[0];
				}
				//for (int i =0;i<n_folder;i++)
				//{ 
				//	date_t last_mod;
				//	

				//	AOM_ask_value_date(Item[i],"last_mod_date",&last_mod);
				//	//sprintf("
				//	if (last_mod.year>=import_yaer && last_mod.month>=import_month && last_mod.day>=import_day)
				//	//if (last_mod.day>=import_day)
				//	{
				//		printf("true -hledany den %d.%d.%d last_mod %d.%d.%d \n",import_day,import_month,import_yaer,last_mod.day,last_mod.month,last_mod.year);
				//		return *Item;
				//	}
				//	else 
				//	{
				//		printf("false -hledany den %d.%d.%d last_mod %d.%d.%d \n",import_day,import_month,import_yaer,last_mod.day,last_mod.month,last_mod.year);
				//		return 0;
				//	}
				//}	
				
				//return Item[0];

	// ITEM_find_item	(	id_obj,&Item);	
	 return 0;
}
int getTagItem(char *cislo_vykresu)
{
	tag_t *Item,
		*Rev;

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
int getTagRev(char *id_obj)
{
	tag_t Item,
		Rev;

	//					tag_t query = NULLTAG,
	//			* folder=NULLTAG;
	//			QRY_find("Item ID", &query);
	//			printf("tag foldru Qry General je %d\n",query);
	//			// Find user's "Tasks to Perform" folder
	//			char *entries[1] = {"Item ID"};
	//			char *values[1] =  {id_obj};
	//			int n_folder = 0;		
	//						
	//			QRY_execute(query, 1, entries, values, &n_folder, &Item);
	//			printf("pocet nalezu %d\n",n_folder);
	//			if(n_folder==0)
	//				return 0;

	//return Item[0];

	 ITEM_find_item	(	id_obj,&Item);	
	 return Item;
}
void CopyAttr_NP(tag_t Rev_ND, tag_t I_np)
{
	char *c_nak_pol,
		*c_poznamka,
		*c_material,
		*c_nomenklatura,
		*c_polotovar,
		*c_name,
		*c_id,
		*nazev_klice,
		n_polotovar[80];
	int id_erp=0,
		tag_nak_pol;
	AOM_lock(Rev_ND);

					AOM_get_value_int(I_np,"tpv4_klic_tpv_np",&id_erp);
					AOM_ask_value_string(I_np,"tpv4_poznamka_tpv",&c_poznamka);
					AOM_ask_value_string(I_np,"object_name",&c_name);
					AOM_ask_value_string(I_np,"tpv4_material",&c_material);
					AOM_ask_value_string(I_np,"tpv4_nomenklatura",&c_nomenklatura);
					AOM_ask_value_string(I_np,"tpv4_polotovar",&c_polotovar);
					AOM_ask_value_string(I_np,"item_id",&c_id);
					AOM_ask_value_string(I_np,"tpv4_nazev_klice",&nazev_klice);
					
					
					printf("id Erp NP %d \n cislo ",id_erp);
					SetInt(Rev_ND,id_erp,"tpv4_klic_tpv_np");
					SetString(Rev_ND,c_id,"tpv4_nak_polozka");
					SetString(Rev_ND,c_name,"tpv4_nazev_np");
					SetString(Rev_ND,c_nomenklatura,"tpv4_cislo_vykresu_np");
					//strcpy(n_polotovar,c_name);
					//strcat(n_polotovar," - ");
					//strcat(n_polotovar,c_polotovar);
					SetString(Rev_ND,c_polotovar,"tpv4_polotovar");
					SetString(Rev_ND,c_material,"tpv4_material");
					SetString(Rev_ND,c_poznamka,"tpv4_poznamka_tpv");
					if(strcmp(nazev_klice,"NEUZIVAT")==0)
						SetString(Rev_ND,"NEUZIVAT","tpv4_status");
					else if (strcmp(nazev_klice,"UMRTVENO")==0)
						SetString(Rev_ND,"UMRTVENO","tpv4_status");
					else SetString(Rev_ND,"","tpv4_status");
				
		AOM_unlock(Rev_ND);
		AOM_save(Rev_ND);
				//}

		/*if(c_nak_pol)MEM_free(c_nak_pol);
		if(c_poznamka)MEM_free(c_poznamka);
		if(c_material)MEM_free(c_material);
		if(c_nomenklatura)MEM_free(c_nomenklatura);
		if(c_polotovar)MEM_free(c_polotovar);
		if(c_name)MEM_free(c_name);
		if(c_id)MEM_free(c_id);*/

			//}

}
void GetName_rev(tag_t Rev)
{
	tag_t Item;
	char* Id,
		* RevId,
		* obj_name;
	char *Type;
	//IFERR_REPORT(ITEM_ask_type2(Rev,&Type));
	//printf ("type = %s \n",Type);
	IFERR_REPORT(ITEM_ask_item_of_rev(Rev, &Item));
    IFERR_REPORT(ITEM_ask_id(Item, Id));
    IFERR_REPORT(ITEM_ask_rev_id(Rev, RevId));
	IFERR_REPORT(ITEM_ask_type2(Item,&Type));
	printf ("type = %s \n",Type);
	IFERR_REPORT(AOM_ask_value_string(Rev,"object_name",&obj_name));

	printf(" ->> %s \n",obj_name);
	//printf(" ->> %s /%s - %s \n",Id,RevId,obj_name); 
}
int main(int argc, char *argv[])
{
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
    int ReturnCode = TC_init_module("infodba", "infodba", "dba");
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
    const char *AttrNames[1] = {"object_type" };
    const char *AttrValues[1] = { "H4_NP"};
    int ItemsCount = 0;
    tag_t *Items = NULLTAG;
    ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &ItemsCount, &Items);

    if(Items==NULLTAG)
        printf("Nenalezena zadna polozka\n");
    else
        printf("Nalezeno %d polozek\n", ItemsCount);
		printf("Nalezeno %d tag: \n", Items);
	
    // Výpis položek
    char Id[ITEM_id_size_c + 1];
    char Name[ITEM_name_size_c + 1];
	tag_t Rev;
	char RevId[ITEM_id_size_c+1];
    for(int i = 0; i < ItemsCount; i++)
    {
		
		char* cislo_vykresu,
			*cislo_vykresu_np;
        ITEM_ask_id(Items[i], Id);
        ITEM_ask_name(Items[i], Name);
		ITEM_ask_latest_rev(Items[i],&Rev);
		ITEM_ask_rev_id(Rev,RevId);
        printf("%s %s/%s \n", Id, Name,RevId);
		AOM_ask_value_string(Rev,"h4_stare_cislo_mat",&cislo_vykresu);
		//AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_np",&cislo_vykresu_np);
		//printf("cislo vykresu %s li %s \n",cislo_vykresu,last_import);
	//	if(strlen(cislo_vykresu_np)<1 && strlen(cislo_vykresu)>1)
		int PocetRelaci=CountInRelation(Rev,"TC_Is_Represented_By");
		printf(" cislo_vykresu %s - %d \n PocetRelaci %d \n",cislo_vykresu,strlen(cislo_vykresu),PocetRelaci);
		if (strlen(cislo_vykresu)>1 && PocetRelaci==0)		
		{
			printf("test309 \n");
			//if(SouborExistuje(last_import)!=0)
		/*	if(last_import==NULLTAG)
			{				
				printf(" copy all\n");
				tag_t Item=getTagItem(cislo_vykresu);
				if (Item!=0)
				CopyAttr_NP(Rev, Item);

			}else if (strlen(cislo_vykresu)>1)
			{
				printf(" reda last import and copy \n");
				tag_t Item=getTagItem2(cislo_vykresu,last_import);
				if (Item!=0)
				CopyAttr_NP(Rev, Item);
			}*/
			tag_t KPRev=getTagItem2(cislo_vykresu,last_import,Items[i]);
			if (KPRev!= NULLTAG)
			{	
				//GetName_rev(KPRev);
			
				int KPrelation=CountInRelation(KPRev,"TC_Is_Represented_By");
				printf("pocet relaci KPRev %d \n",KPrelation);
				int is_released = 0;
				EPM_ask_if_released(Rev,&is_released);
				
				//neschvalene is_released == 0
				if((KPRev!=0 || KPRev != -1) && KPrelation==0 && is_released == 0)
				{
					create_relation("TC_Is_Represented_By",Rev,KPRev);
				//	create_relation("TC_Primary_Design_Representation",Rev,KPRev);
				}
				else if ( KPrelation>0)
				{
					IntoFolder("Manual_connect",Rev);
					IntoFolder("Manual_connect",KPRev);
				}
			}
		}
		//tag_t dataset=NULLTAG;
		//create_dataset("PDF", "test", Items[i], Rev, &dataset);
		// importDatates(dataset,"C:\\PDF\\1082731.pdf","PDF_Reference","1082731.pdf");
		printf ("konec ciklu %d \n\n",i);
		if(cislo_vykresu)MEM_free(cislo_vykresu);
    }
   if(Items) MEM_free(Items);
	
    // ITK exit
    ITK_exit_module(true);
    return 0;
}