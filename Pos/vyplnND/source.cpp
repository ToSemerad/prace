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
#include <epm\epm_task_template_itk.h>
#include <tccore/releasestatus.h>
#include <sa/person.h>

char* Owner(tag_t object)
{
	char* user_name;
	tag_t  owning_user;
	AOM_ask_owner(object,&owning_user);
	SA_ask_user_identifier2 ( owning_user, &user_name );
	return user_name; 
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
	printf("Vlozeno  %s do %s\n",value,prop);
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
static void strat_process(tag_t rev)
{
	int
		attach_types[1] = { 1 };
	tag_t
		
		process_template = NULLTAG,
		process = NULLTAG;

	

	EPM_find_process_template("TPV_COM_REM_STAT", &process_template);
	printf(" process_template %d \n",process_template);

	EPM_create_process("Auto_remove_stat", "desc", process_template, 1, &rev,
		attach_types, &process);
	printf(" process %d \n\n",process);
	
}



int getTagItem2(char *cislo_vykresu, char* date_import_adres,int import_day,int import_month,int import_yaer)
{
	tag_t *Item,
		*Rev;
	char d_aktualizace[10];
	/*int import_day,
		import_month,
		import_yaer;
      
	if (strlen(date_import_adres)>6)
		{
			char* tmp;
			tmp=strtok(date_import_adres,"-");
			import_yaer=atoi(tmp);
			tmp=strtok(NULL,"-");
			import_month=atoi(tmp);
			tmp=strtok(NULL,"\0");
			import_day=atoi(tmp);
		}
	/*if(SouborExistuje(date_import_adres)!=0){
		printf("file neexistuje \n");
		return 0;
	}else printf("soubor existuje\n");
	    FILE* stream = fopen(date_import_adres, "r");

    char line[1024];
	int c=0;
    while (fgets(line, 1024, stream))
    {
		if (strlen(date_import_adres)>6)
		{
			char* tmp;
			tmp=strtok(date_import_adres,"-");
			import_yaer=atoi(tmp);
			tmp=strtok(NULL,"-");
			import_month=atoi(tmp);
			tmp=strtok(NULL,"\0");
			import_day=atoi(tmp);
		}
    }*/
	

						tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("PoS_NAK_POLOZKA", &query);
				printf("tag foldru Qry PoS_NAK_POLOZKA je %d\n",query);
				// Find user's "Tasks to Perform" folder
				printf("cislo vykresu %s \n",cislo_vykresu);
				char *entries[1] = {"NOMENKLATURA"};
				char *values[1] =  {cislo_vykresu};
				int n_folder = 0;		
							
				QRY_execute(query, 1, entries, values, &n_folder, &Item);
				printf("%d pocet nalezu %d\n",__LINE__,n_folder);
				
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
				//system("pause");
				//return Item[0];

	// ITEM_find_item	(	id_obj,&Item);	
	 return *Item;
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
				printf("%d pocet nalezu %d\n",__LINE__,n_folder);
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
void CopyAttr_NP(tag_t Rev, tag_t Item,char* c_nak_pol,char* DataOwner)
{
	 ITK_set_bypass(true);
	char 
		*c_poznamka,
		*c_material,
		*c_nomenklatura,
		*c_polotovar,
		*c_name,
		*c_id,
		*c_nazev_klice,
		n_polotovar[80],
		* obj_type;
	int id_erp=0,
		tag_nak_pol;
	
	//AOM_ask_value_string(Rev,"tpv4_nak_polozka",&c_nak_pol);
	AOM_ask_value_string(Rev,"object_type",&obj_type);
	if(strlen(c_nak_pol)>6)
	{
		printf("Cislo %s  \n",c_nak_pol);
		tag_nak_pol= getTagItem(c_nak_pol);
		if(tag_nak_pol!=0)
		{
			int ma_status=0;
			//I_np= getTagRev(c_nak_pol);
			/*if(Kontrola_NP(c_nak_pol,RootTask,Rev)>1)
			{
				printf("NP Pouzito ve vice ND \n");
				strcat(error,"NP pouzito v vice ND ");
				strcat(error,"\n");
				tag_t Object[1];
				///
			
			}*/
			//else{	
				printf("Najdi NP %d  \n",tag_nak_pol);
				/*char* stav;
				AOM_ask_value_string(tag_nak_pol,"tpv4_stav_polozky",&stav);
				if (strcmp(stav,"Zakaz pouziti")==0)
					{
						printf("Zakaz pouziti \n");
						strcat(error,"Zakaz pouziti ");
						strcat(error,c_nak_pol);
						strcat(error,"\n");
						tag_t Object[1];
						Object[0]=tag_nak_pol;
						AddToRef(RootTask,Object,1,Rev);
					}
				else
				{*/
					AOM_get_value_int(tag_nak_pol,"tpv4_klic_tpv_np",&id_erp);
					AOM_ask_value_string(tag_nak_pol,"tpv4_poznamka_tpv",&c_poznamka);
					AOM_ask_value_string(tag_nak_pol,"object_name",&c_name);
					AOM_ask_value_string(tag_nak_pol,"item_id",&c_id);
					//ITEM_ask_id2(tag_nak_pol,&c_id);
					printf("C ID %s \n",&c_id);
					AOM_ask_value_string(tag_nak_pol,"tpv4_material",&c_material);
					AOM_ask_value_string(tag_nak_pol,"tpv4_nomenklatura",&c_nomenklatura);
					AOM_ask_value_string(tag_nak_pol,"tpv4_polotovar",&c_polotovar);
					AOM_ask_value_string(tag_nak_pol,"tpv4_nazev_klice",&c_nazev_klice);
					
					printf("id Erp NP %d \n cislo ",id_erp);
					//
					if( strcmp(obj_type,"TPV4_dilRevision")==0)
					{
						
					EPM_ask_if_released(Rev,&ma_status);
					printf("!!!ma status %d !!!\n",ma_status);
					
					if (ma_status > 0)
					//	system("pause");//strat_process(Rev);
						/*strcpy(n_polotovar,c_name);
						strcat(n_polotovar," ");*/
						strcpy(n_polotovar,c_polotovar);
						SetString(Rev,n_polotovar,"tpv4_polotovar");
						SetInt(Rev,id_erp,"tpv4_klic_tpv_hm");
						SetString(Rev,c_nomenklatura,"tpv4_cislo_vykresu_hm");
						SetString(Rev,c_id,"tpv4_nak_polozka");
					}else
					{
						EPM_ask_if_released(Rev,&ma_status);
						printf("!!!ma status %d !!!\n",ma_status);
						//if (ma_status > 0)
							//system("pause");//strat_process(Rev);
						SetInt(Rev,id_erp,"tpv4_klic_tpv_np");
						SetString(Rev,c_nomenklatura,"tpv4_cislo_vykresu_np");
						SetString(Rev,c_polotovar,"tpv4_polotovar");
						SetString(Rev,c_id,"tpv4_nak_polozka");
					}
					SetString(Rev,c_material,"tpv4_material");
					SetString(Rev,c_poznamka,"tpv4_poznamka_tpv");
					SetString(Rev,c_nazev_klice,"tpv4_nazev_klic");
					
					if(strcmp(c_nazev_klice,"NEUZIVAT")==0)	SetString(Rev,"NEUZIVAT","tpv4_status");
					else if(strcmp(c_nazev_klice,"UMRTVENO")==0) SetString(Rev,"UMRTVENO","tpv4_status");
					else {
					
						//SetString(Rev,"","tpv4_status");
					}
				//}
			//}
					if(ma_status>0)
					{
						tag_t release_stat = NULLTAG;
					//	RELSTAT_create_release_status("Approved", &release_stat);
						//RELSTAT_add_release_status(release_stat, 1, &Rev, true);
					}

		}else printf("nula polozek nalezeno - neexistuje hledana položka %s %d \n",c_nak_pol,tag_nak_pol);
	}else printf ("nevyplneny nak_pol\n");

	tag_t owner;
	tag_t ownerGroup;
	
	if (strlen(DataOwner)>1)
	{
		POM_string_to_tag(DataOwner,&owner);
		SA_ask_user_login_group	(owner,&ownerGroup);
	}
	
	if(owner!=NULLTAG)
			{	
				ITK_set_bypass(true);
				printf("REV vlastneno %s \n",Owner(Rev));
				AOM_set_ownership(Rev,owner ,ownerGroup);			
				printf("REV vlastneno %s \n",Owner(Rev));
				AOM_save(Rev);
				//system ("pause");
				ITK_set_bypass(false);
				
			}
	 ITK_set_bypass(false);
	// system("pause");
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
//	printf("jindriska.slezakova ; tc ; SERVIS.PoS \n");
    if(ReturnCode != ITK_ok)
    {
        char *Message;
        EMH_ask_error_text(ReturnCode, &Message);
        fprintf(stderr, "ERROR: %s\n", Message);
		return ITK_ok;
    }
    printf("Login OK\n");
	
	char*last_import = ITK_ask_cli_argument( "-d=");
	char*DataOwner= ITK_ask_cli_argument( "-o=");
	
		int import_day,
		import_month,
		import_yaer;
      
	if (strlen(last_import)>6)
		{
			char* tmp;
			tmp=strtok(last_import,"-");
			import_yaer=atoi(tmp);
			tmp=strtok(NULL,"-");
			import_month=atoi(tmp);
			tmp=strtok(NULL,"\0");
			import_day=atoi(tmp);
			printf(" y=%d m=%d d=%d \n",import_yaer,import_month,import_day);
		}
	printf(" last import %s \n ",last_import);
	//system ("pause");
	
	//char *TP="ZAA 000 000";

    // Vyhledání položek
	const char *AttrNames[1] = {"object_type" };
    const char *AttrValues[1] = { "TPV4_nak_dil"};
    int ItemsCount = 0;
    tag_t *Items = NULLTAG;
    ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &ItemsCount, &Items);
	printf(" Count %d \n",ItemsCount);
	//system("pause");

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
	ITK_set_bypass(true);
    for(int i = 0; i < ItemsCount; i++)
    {
		
		char* cislo_vykresu,
			*cislo_vykresu_np;
        ITEM_ask_id(Items[i], Id);
        ITEM_ask_name(Items[i], Name);
		ITEM_ask_latest_rev(Items[i],&Rev);
		ITEM_ask_rev_id(Rev,RevId);
        printf("%s %s/%s \n", Id, Name,RevId);
		AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&cislo_vykresu);
		AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_np",&cislo_vykresu_np);
		printf("cislo vykresu %s li %s \n",cislo_vykresu,last_import);
	//	if(strlen(cislo_vykresu_np)<1 && strlen(cislo_vykresu)>1)
		if (strlen(cislo_vykresu)>1)		{
			printf("test309 \n");
			//if(SouborExistuje(last_import)!=0)
			if(strlen(last_import)==0)
			{				
				printf(" copy all\n");
				//system ("pause");
				tag_t Item=getTagItem(cislo_vykresu);
				if (Item!=0)
				CopyAttr_NP(Rev, Item,cislo_vykresu,DataOwner);

			}else if (strlen(cislo_vykresu)>1)
			{
				printf(" reda last import and copy \n");
				//system ("pause");
				tag_t Item=getTagItem2(cislo_vykresu,last_import,import_day, import_month, import_yaer);
				if (Item!=0)
				CopyAttr_NP(Rev, Item,cislo_vykresu,DataOwner);
			}
		}
		//tag_t dataset=NULLTAG;
		//create_dataset("PDF", "test", Items[i], Rev, &dataset);
		// importDatates(dataset,"C:\\PDF\\1082731.pdf","PDF_Reference","1082731.pdf");
		printf ("test \n");
		if(cislo_vykresu)MEM_free(cislo_vykresu);
    }
	ITK_set_bypass(false);
   if(Items) MEM_free(Items);
	
    // ITK exit
    ITK_exit_module(true);
    return 0;
}