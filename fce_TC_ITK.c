///////////////////////
// Knihovan C funkcí //
// Pro Teamcenter ITK//
///////////////////////

// nastav string
void SetString(tag_t object,char* value,char* attribut)
{
	AOM_lock(object);
	AOM_set_value_string(object,attribut,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno %s\n",value);
}

// vlastník
char* Owner(tag_t object)
{
	char* user_name;
	tag_t  owning_user;
	AOM_ask_owner(object,&owning_user);
	SA_ask_user_identifier2 ( owning_user, &user_name );
	return user_name; 
}

//add to ref or target 
void AddToTarget(tag_t RootTask, char* O_Name, tag_t Item)
{
	//printf("tak posilam do Targetu Roottask %d Item %d jmeno %s \n",RootTask,Item,O_Name);
	tag_t* Object = NULLTAG;
	int Count;
	const int AttachmentTypes[1] = { EPM_target_attachment };//EPM_reference_attachment
	const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
	const char *AttrValues[1] = { O_Name };
	FL_user_update_newstuff_folder(Item);

	ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	//printf("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames);
	EPM_add_attachments(RootTask, Count, Object, AttachmentTypes);
	//printf("nakonci ciklu\n");
}

//log file example
void Logfile(char * name, char* num,char* user, char* time_stamp)
{
	FILE *fs;

 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\Ciselne_rady\\");
 strcat(file,name);
 strcat(file,".log");
 
 fs=fopen(file,"a+");
 fprintf(fs,"user: %s; cislo: %s; cas:%s; \n",user,num,time_stamp);
  fclose(fs);
}

// Casova zanačka
#include <time.h>
char *time_stamp(){

char *timestamp = (char *)malloc(sizeof(char) * 16);
time_t ltime;
ltime=time(NULL);
struct tm *tm;
tm=localtime(&ltime);

sprintf(timestamp,"%04d-%02d-%02d_%02d:%02d:%02d", tm->tm_year+1900, tm->tm_mon+1, 
	tm->tm_mday, tm->tm_hour, tm->tm_min,tm->tm_sec);
return timestamp;
}

//existence souboru
#include <errno.h>

int SouborExistuje(char *nazev)
{
	printf("test existence souboru %s  \n",nazev);
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
 printf("nic se neděje \n");
    return 2;      /* soubor mozna existuje, ale nepodarilo se
                           jej otevrit (treba uz je otevreno prilis
                           mnoho souboru nebo nemate prava atp.) */
}

//vytvoření datasetu pdf
static void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset)
{
    char
        format_name[AE_io_format_size_c + 1] = "BINARY_REF";
    tag_t
        datasettype,
        tool;
    
    AE_find_datasettype(type_name, &datasettype);
    if (datasettype == NULLTAG)
    {
        //printf("Dataset Type %s not found!\n", type_name);
        exit (EXIT_FAILURE);
    }
    
    AE_ask_datasettype_def_tool(datasettype, &tool);
    
    //printf("Creating Dataset: %s\n", name);
    AE_create_dataset(datasettype, name, "", dataset);
    
    AE_set_dataset_tool(*dataset, tool);
    if (strcmp(type_name, "PDF")) strcpy(format_name, "PDF");
    
    AE_set_dataset_format(*dataset, format_name);
    //printf("Saving Dataset: %s\n", name);
    AOM_save(*dataset);
    
    /*attach dataset to item revision */
    ITEM_attach_rev_object(rev, *dataset, ITEM_specification_atth);
  //  ITEM_save_item(item);

}

//Odebrání statusu ve WF
int Remove_stat(tag_t obj,tag_t root_tag)
{
	int n_statuses = 0,
		TargetsCount;
   tag_t *statuses  = NULL,
		*Targets =NULL;
	int ifail = WSOM_ask_release_status_list(obj, &n_statuses , &statuses);
	if (ifail != ITK_ok) { /* your error logic here */ }
	for(int ii = 0; ii < n_statuses; ii++)
		{
			EPM_ask_attachments( root_tag,EPM_target_attachment, &TargetsCount, &Targets );
			for (int j=0;j<TargetsCount;j++)
				if(Targets[j]==obj)
				{
					EPM_remove_status_from_targets	(	statuses[ii],	root_tag);
				goto next;
				}
				const int AttachmentTypes[1] = {EPM_target_attachment};
				const tag_t *attach=&obj;						
				EPM_add_attachments(root_tag, 1, attach, AttachmentTypes);
				EPM_remove_status_from_targets	(	statuses[ii],	root_tag);
				next:;
	}
	if(statuses) MEM_free(statuses);
		 return ITK_ok;
}

//stažení datasetu local serveru exaple
#include <tccore\grm.h>
#include <ae\ae.h>

void downloadDataset(tag_t rev,char* I_ID, char* typ, char** retCesta) {
       int ifail = ITK_ok;

    tag_t relation_type_tag = NULLTAG,
       * specs = NULL,
    type_tag = NULLTAG,
    * refs = NULL;
    
       int n_specs = 0,
           n_refs = 0;
    
    char type_name[TCTYPE_name_size_c+1] = "",
            ID_new[30],
        *ID_Rev;
    
       
             
       strcpy(ID_new,I_ID);
       char cesta[255]="C:\\Temp\\";
       //printf("I_ID %s \n",I_ID);
       for (int k =0;k<strlen(ID_new);k++)//odstranení white space
             if(ID_new[k]==' ')
                    ID_new[k]='_';

       AOM_ask_value_string(rev,"item_revision_id",&ID_Rev);

       ifail = GRM_find_relation_type("IMAN_specification", &relation_type_tag);
    if (ifail != ITK_ok) { /* your error logic here */ }

       ifail = GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs);
    if (ifail != ITK_ok) { /* your error logic here */ }
    //printf("pocet datasetu %d\n",n_specs);

    for ( int ii = 0; ii < n_specs; ii++) {
        ifail = TCTYPE_ask_object_type (specs[ii], &type_tag);
        if (ifail != ITK_ok) { /* your error logic here */ }
        
        ifail = TCTYPE_ask_name(type_tag, type_name);
        if (ifail != ITK_ok) { /* your error logic here */ }
             //printf("Typ polozky %s \n",type_name);
      
                    
             if(strcmp(typ,"pdf")==0) {
                    //printf("-----typ ok\n");
                      if (strcmp(type_name, "PDF") == 0)                    {
                           
                           //printf("-----typ_name ok\n");
                           ifail = AE_ask_all_dataset_named_refs(specs[ii], "PDF_Reference", &n_refs, &refs);
                           //printf("Reference %d \n",n_refs);

                           if (ifail != ITK_ok) { printf("chyba v dotazu na dataset\n"); }
                           else printf(" ok export\n");
            
                           strcat(cesta,ID_new);
                           strcat(cesta,"_");
                           strcat(cesta,ID_Rev);
                           strcat(cesta,".");
                           strcat(cesta,typ);
                           
                                               
                           strcpy(*retCesta, cesta);

						   printf("Cesta %s \n retCesta %s \n",cesta,retCesta);
                           if(SouborExistuje(cesta)==1){
                                  ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
                                  if (ifail != ITK_ok) { printf("Nefunguje export \n");}
                           }
                    }
             }
       }
}

//vložení datasetu do TC
void importDatates(tag_t dataset,char* way,char *ref,char *fileName)
{
    /*  AE_find_dataset finds latest revision of dataset */
    
    //IFERR_ABORT(AE_find_dataset("6667776-A", &dataset));
    //ECHO("\n dataset: %u \n", dataset);
	AOM_lock(dataset);
    AOM_refresh(dataset, TRUE);
    printf("\n dataset %d \n ref %s \n way %s \n filename %s \n",dataset, ref, way, fileName);
    /* the fourth argument must be a unique name in the volume */
   AE_import_named_ref(dataset, ref, way, fileName,  SS_BINARY);
  // AE_import_named_ref(dataset, "UG-QuickAccess-Binary", "W:\\images_preview.qaf", "6667776-A_binary.qaf",  SS_BINARY);

    AOM_save(dataset); 
    AOM_refresh(dataset, FALSE);
	AOM_unlock(dataset);
    AOM_unload(dataset);
}

//Nastaveni hodnoty lovu v bom line
void SetBomLineStringLov(tag_t BomWin, tag_t BomLine, char* value, char* Attr, char* Lov)
{
	tag_t* lov_tag = NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;
	int AttrId;

	BOM_line_look_up_attribute(Attr, &AttrId);

	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for (int j = 0; j<n_values; j++)
	{

		//printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
		if (strcmp(values_dissplay[j], value) == 0)
		{
			//printf("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]);
			BOM_line_set_attribute_string(BomLine, AttrId, values[j]);

			j = n_values;
		}
	}
	BOM_save_window(BomWin);
}
char* Get_akctiveUser()
{
	char *user_name;
	tag_t user_tag,
		person_tag;

	POM_get_user(&user_name, &user_tag);
	//printf("-----Jmeno %s tag %d-------\n",user_name,user_tag);
	
	//SA_find_person2(user_name, &person_tag); //pro atributy personal
	//SA_ask_person_attribute2(person_tag, "PA6", &P_organ);
	return user_name;
}
//hledani revize podle Gtacu
#define ITEM_find_rev GTAC_find_rev
static int GTAC_find_rev(char *item_id, char *rev_id, tag_t *rev)
{
	int
		n = 0;
	tag_t
		*items;
	const char
		*names[1] = { "item_id" },
		*values[1] = { item_id };

	IFERR_REPORT(ITEM_find_item_revs_by_key_attributes(1, names, values, rev_id,
		&n, &items));
	if (n > 0) *rev = items[0];
	if (items) MEM_free(items);

	return 0;
}
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
#define SAFE_MEM_FREE( a )   \
do                          \
{                           \
    if ( (a) != NULL )      \
    {                       \
        MEM_free( (a) );    \
        (a) = NULL;         \
    }                       \
}                 
//konstrola hodnot TC
#define EXIT_FAILURE 1 
#define EXIT_IF_NULL(X) (check_value(#X, (X)))

static void check_value(char *function, int value)
{
	if (value == 0)
	{
		printf("\t%s is NULL\n", function);
		printf("\nExiting program!\n");
		exit(EXIT_FAILURE);
	}
}


//Spuštění WF 
#include <epm\epm_task_template_itk.h>

static void strat_process(void)
{
	int
		attach_types[1] = { 1 };
	tag_t
		rev = NULLTAG,
		process_template = NULLTAG,
		process = NULLTAG;

	ERROR_CHECK(ITEM_find_rev("NDAA 000 006", "001", &rev));
	EXIT_IF_NULL(rev);

	ERROR_CHECK(EPM_find_process_template("MAZANI_STATUSU", &process_template));
	EXIT_IF_NULL(process_template);


	ERROR_CHECK(EPM_create_process("5421377", "desc", process_template, 1, &rev,
		attach_types, &process));

	EXIT_IF_NULL(process);
}

//Pridání do relačního adresáře
#include <tccore\grm.h>
void ADD2Relation(tag_t Otec, tag_t Object, char * Relation)
{
	tag_t relation_type,
		relation;
	GRM_find_relation_type(Relation, &relation_type);
	//printf("207 find relation %d %d %d \n",relation_type,Otec,Object);
	GRM_create_relation(Otec, Object, relation_type, NULLTAG, &relation);
	//printf("209\n");
	GRM_save_relation(relation);
	//printf("konec relace \n");
}

//počet připojených onjektů relací
#include <tccore\grm.h>
int CountInRelation(tag_t Otec, char * Relation, tag_t RootTask)
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//printf("220 find relation %d \n",relation_type);
	err = GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	printf("count %d \n", Count);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//printf ("secondary list [0] %d \n",*secondary_list);
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	return Count;
}

//počet otcu objektů relací
#include <tccore\grm.h>
int CountInRelation(tag_t Child, char * Relation)
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("find relation %d \n", relation_type);
	err = GRM_list_primary_objects_only(Child, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }

	return Count;
}


// vyplnění bom line string attr 
void SetBomLineString(tag_t BomWin, tag_t BomLine, char* value, char* Attr)
{
	int AttrId = 0;
	BOM_line_look_up_attribute(Attr, &AttrId);
	BOM_line_set_attribute_string(BomLine, AttrId, value);
	BOM_save_window(BomWin);
}

//kopírovýní absolutní transformační matice
void CopyAbs_xform(tag_t BomWin_source, tag_t BomLine_source, tag_t BomWin_target, tag_t BomLine_target)
{
	int AttrId = 0;
	char matice[240];
	char *value;
	BOM_line_look_up_attribute("bl_plmxml_abs_xform", &AttrId);
	BOM_line_ask_attribute_string(BomLine_source, AttrId, &value);
	strcpy(matice, value);
	BOM_line_set_attribute_string(BomLine_target, AttrId, matice);
	BOM_save_window(BomWin_target);
}


//gtac nahrazení design 
#include <tccore/aom.h>
#include <tccore/grm.h>

static void replace_design_representation(tag_t partRevTag, tag_t oldDesignRevTag, tag_t newDesignRevTag)
{
	int ifail = ITK_ok;

	tag_t priDesRepTypeTag = NULLTAG;
	ifail = GRM_find_relation_type("TC_Primary_Design_Representation",
		&priDesRepTypeTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	tag_t isRepByTypeTag = NULLTAG;
	ifail = ifail = GRM_find_relation_type("TC_Is_Represented_By",
		&isRepByTypeTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_refresh(partRevTag, TRUE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_refresh(oldDesignRevTag, TRUE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_refresh(newDesignRevTag, TRUE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	tag_t relationTag = NULLTAG;
	ifail = GRM_find_relation(partRevTag, oldDesignRevTag, priDesRepTypeTag,
		&relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = GRM_delete_relation(relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	relationTag = NULLTAG;
	ifail = GRM_find_relation(partRevTag, oldDesignRevTag, isRepByTypeTag,
		&relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = GRM_delete_relation(relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	relationTag = NULLTAG;
	ifail = GRM_create_relation(partRevTag, newDesignRevTag, priDesRepTypeTag,
		NULLTAG, &relationTag);
	ifail = GRM_save_relation(relationTag);

	relationTag = NULLTAG;
	ifail = GRM_create_relation(partRevTag, newDesignRevTag, isRepByTypeTag,
		NULLTAG, &relationTag);
	ifail = GRM_save_relation(relationTag);

	ifail = ifail = AOM_save(partRevTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_save(oldDesignRevTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_save(newDesignRevTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_refresh(partRevTag, FALSE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_refresh(oldDesignRevTag, FALSE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_refresh(newDesignRevTag, FALSE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }
}

//nahradit design ve relacích
#include <tccore/aom.h>
#include <tccore/grm.h>

static void replace_design_representation(tag_t partRevTag, tag_t oldDesignRevTag, tag_t newDesignRevTag)
{
	int ifail = ITK_ok;

	tag_t priDesRepTypeTag = NULLTAG;
	ifail = GRM_find_relation_type("TC_Primary_Design_Representation",
		&priDesRepTypeTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	tag_t isRepByTypeTag = NULLTAG;
	ifail = ifail = GRM_find_relation_type("TC_Is_Represented_By",
		&isRepByTypeTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_refresh(partRevTag, TRUE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_refresh(oldDesignRevTag, TRUE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_refresh(newDesignRevTag, TRUE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	tag_t relationTag = NULLTAG;
	ifail = GRM_find_relation(partRevTag, oldDesignRevTag, priDesRepTypeTag,
		&relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = GRM_delete_relation(relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	relationTag = NULLTAG;
	ifail = GRM_find_relation(partRevTag, oldDesignRevTag, isRepByTypeTag,
		&relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = GRM_delete_relation(relationTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	relationTag = NULLTAG;
	ifail = GRM_create_relation(partRevTag, newDesignRevTag, priDesRepTypeTag,
		NULLTAG, &relationTag);
	ifail = GRM_save_relation(relationTag);

	relationTag = NULLTAG;
	ifail = GRM_create_relation(partRevTag, newDesignRevTag, isRepByTypeTag,
		NULLTAG, &relationTag);
	ifail = GRM_save_relation(relationTag);

	ifail = ifail = AOM_save(partRevTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_save(oldDesignRevTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_save(newDesignRevTag);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_refresh(partRevTag, FALSE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = AOM_refresh(oldDesignRevTag, FALSE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }

	ifail = ifail = AOM_refresh(newDesignRevTag, FALSE);
	if (ifail != ITK_ok) {/*  your error logic here  */ }
}

// spustení utility s argumentem

int main(int argc, char *argv[])
{
	ReadProperty();
	if (ITK_ok != ITK_init_from_cpp(argc, argv))
	{
		fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
		return 1;
	}

	ITK_initialize_text_services(0);

	// Login
	int ReturnCode = TC_init_module(login, password, group);
	if (ReturnCode != ITK_ok)
	{
		fprintf(stderr, "ERROR: Login failed\n");
		return 1;
	}
	printf("Login OK\n");
	Polozka I;
	I.Poradi_atr = 0;

	printf(" Pred XML \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char*arg = ITK_ask_cli_argument("-s=");

	printf("%s \n", arg);

	return ITK_ok;
}

// test jesli má object relaci s objectem daného type
int IsTypeInRelation(tag_t Child, char * Relation, char * Type)
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type,
		type_tag;
	char* type_name;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("find relation %d \n", relation_type);
	err = GRM_list_secondary_objects_only(Child, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }

	for (int i = 0; i<Count; i++)
	{
		err = TCTYPE_ask_object_type(secondary_list[i], &type_tag);
		if (err != ITK_ok) { /* your error logic here */ }

		err = TCTYPE_ask_name(type_tag, type_name);
		if (err != ITK_ok) { /* your error logic here */ }
		//printf("Typ polozky %s \n",type_name);

		if (strcmp(type_name, Type) == 0)
		{
			return 1;
		}
	}

	return 0;
}
//pro hledaní objektu který je do relace vložený
int GetObjInRelation_primary(tag_t Child, char * Relation, tag_t **Objects)
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type,
		type_tag;
	char* type_name;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("find relation %d \n", relation_type);
	err = GRM_list_primary_objects_only(Child, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }

	if (Count>0)
	{
		*Objects = secondary_list;
		return Count;
	}
	return 0;
}
//pro hledaní objektu pod kterým je vložený objekt
int GetObjInRelation_secondary(tag_t Child, char * Relation, tag_t **Objects)
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type,
		type_tag;
	char* type_name;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("find relation %d \n", relation_type);
	err = GRM_list_secondary_objects_only(Child, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }

	if (Count>0)
	{
		*Objects = secondary_list;
		return Count;
	}
	return 0;
}

//handler získání argumentu vlastnosti a hodnoty
int TPV_Divide_by_property(EPM_action_message_t msg)
{
	char *Argument = nullptr;
	char*Flag = nullptr;
	char*Value = nullptr;
	logical and = false;
	logical or = false;
	next_way = ITK_ok;

	int ArgumentCount = TC_number_of_arguments(msg.arguments);

	while (ArgumentCount-- > 0)
	{
		Argument = TC_next_argument(msg.arguments);
		ITK_ask_argument_named_value((const char*)Argument, &Flag, &Value);
		if (strcmp("vlastnost", Flag) == 0 && Value != nullptr)
		{
			// …
			printf("value property %s \n", Value);
			strcpy(Vlastnost, Value);
		}
		if (strcmp("hodnota", Flag) == 0 && Value != nullptr)
		{
			// …
			printf("value hodnota %s \n", Value);
			strcpy(hodnota, Value);
		}
		
	}
}

void Add_latets_rev_TP_ToRef(tag_t RootTask, tag_t Item, int Count)
{
	printf("74tak posilam do Targetu Roottask %d Item %d  \n", RootTask, Item);
	const int AttachmentTypes[1] = { EPM_reference_attachment };
	printf("76test \n");
	for (int i = 0; i<Count; i++)
	{
		printf("79\n");
		tag_t Object_rev = NULLTAG;
		printf("81\n");
		ITEM_ask_latest_rev(Item, &Object_rev);

		printf("Do referenci \n");
		EPM_add_attachments(RootTask, Count, &Object_rev, AttachmentTypes);
	}
	//int Count;



	printf("nakonci ciklu\n");
}

/// test schvelených polozek 
int is_released = 0;
EPM_ask_if_released(obj,&is_released)
if (is_released == 0)
	printf("neschvaleno \n");
///////////////////

////////////////// REVIDOVÁNÍ  

void revise_item_revisions(int num_target_objs, tag_t *target_object_tags)
{
	/* Pointer to an array of integers that stores the number of attached
	*  objects of each target revision.  For example, with the objects
	*  below the array would be {2,4,3}.

	*  ItemRevision
	*      ItemRevision Master
	*      UGMASTER
	*
	*  ItemRevision
	*      ItemRevision Master
	*      UGMASTER
	*      UPART
	*      DirectModel
	*
	*  ItemRevision)
	*      ItemRevision Master)
	*      UGMASTER
	*      UPART
	*/
	int *all_attached_object_count = NULL;

	/* Pointer to an array of attached object_tag tags of each target revision.
	* Normally this would be tag_t**.  Although tag_t* is unconventional
	* it is not incorrect.  Using the same example objects as above
	* the resulting array would be the tags of these objects
	*
	*      ItemRevision Master
	*      UGMASTER
	*      ItemRevision Master
	*      UGMASTER
	*      UPART
	*      DirectModel
	*      ItemRevision Master
	*      UGMASTER
	*      UPART
	*/
	tag_t *all_deepcopydata_tags;

	int n_ints_in_list = 0;
	int n_tags_in_list = 0;
	int *ifails = NULL;
	char *id_string = NULL;
	char type_name[TCTYPE_name_size_c + 1] = "";
	tag_t object_tag = NULLTAG;
	tag_t type_tag = NULLTAG;
	tag_t *attached_objs_tags = NULL;
	tag_t *target_copy_tags = NULL;
	tag_t *revise_input_tags = NULL;

	revise_input_tags = (tag_t *)MEM_alloc(num_target_objs * sizeof(tag_t));

	for (int ii = 0; ii < num_target_objs; ii++)
	{
		tag_t type_tag = NULLTAG;
		TCTYPE_ask_object_type(target_object_tags[ii], &type_tag);

		tag_t revise_input_tag = NULLTAG;
		TCTYPE_construct_operationinput(type_tag, TCTYPE_OPEARTIONINPUT_REVISE, &revise_input_tag);
		revise_input_tags[ii] = revise_input_tag;

		printf("\nTarget Objects::\n");
		int attached_object_count = 0;
		tag_t *deepcopydata_tags = NULL;
		TCTYPE_ask_deepcopydata(target_object_tags[ii], TCTYPE_OPEARTIONINPUT_REVISE, &attached_object_count, &deepcopydata_tags);
		tag_t last_object = NULLTAG;
		for (int jj = 0; jj < attached_object_count; jj++)
		{
			AOM_ask_value_tag(deepcopydata_tags[jj], "targetObject", &object_tag);
			if (object_tag != last_object)
			{
				WSOM_ask_object_id_string(object_tag, &id_string);
				TCTYPE_ask_object_type(object_tag, &type_tag);
				TCTYPE_ask_name(type_tag, type_name);
				printf("    %s (%s)\n", id_string, type_name);
			}
			last_object = object_tag;

			AOM_ask_value_tag(deepcopydata_tags[jj], "attachedObject", &object_tag);
			if (object_tag != NULLTAG)
			{
				WSOM_ask_object_id_string(object_tag, &id_string);
				TCTYPE_ask_object_type(object_tag, &type_tag);
				TCTYPE_ask_name(type_tag, type_name);
				printf("        attachedObject: %s (%s)\n", id_string, type_name);
			}
		}

		if (attached_object_count > 0)
		{
			add_int_to_int_array(attached_object_count, &n_ints_in_list,
				&all_attached_object_count);
			for (int jj = 0; jj < attached_object_count; jj++)
			{
				add_tag_to_tag_array(deepcopydata_tags[jj], &n_tags_in_list,
					&all_deepcopydata_tags);
			}
		}
		if (deepcopydata_tags) MEM_free(deepcopydata_tags);
	}

	TCTYPE_revise_objects(num_target_objs, target_object_tags, revise_input_tags, all_attached_object_count, all_deepcopydata_tags, &target_copy_tags, &ifails);

	printf("\nNew Revisions:\n");
	for (int ii = 0; ii < num_target_objs; ii++)
	{

		WSOM_ask_object_id_string(target_copy_tags[ii], &id_string);
		TCTYPE_ask_object_type(target_copy_tags[ii], &type_tag);
		TCTYPE_ask_name(type_tag, type_name);

		if (ifails[ii] == ITK_ok) printf("   %s (%s)\n", id_string, type_name);
		else
		{
			char *error_message_string;
			EMH_get_error_string(NULLTAG, ifails[ii], &error_message_string);
			printf("\t%d %s\n", ifails[ii], error_message_string);
			if (error_message_string) MEM_free(error_message_string);
		}
	}
	printf("cisteni pameti \n");
	if (revise_input_tags) MEM_free(revise_input_tags);
	if (all_attached_object_count) MEM_free(all_attached_object_count);
	if (all_deepcopydata_tags) MEM_free(all_deepcopydata_tags);
	if (attached_objs_tags) MEM_free(attached_objs_tags);
	if (target_copy_tags) MEM_free(target_copy_tags);
	if (ifails) MEM_free(ifails);
	if (id_string) MEM_free(id_string);
}

/////////////////////////////////////

void CreateLink2TC(tag_t* Targets, int num_targets)
{
	FILE* stream;
	char logpath[30];
	strcpy(logpath, "C:\\Temp\\odkaz");
	//strcat(logpath,job_name);
	strcat(logpath, ".txt");
	//printf("log --- %s \n",logpath);
	stream = fopen(logpath, "a+");
	char link[128],
		*adresa = "http://hestego:7001/tc/launchapp?-attach=true&-s=226TCSession&-o=",
		*append = "AAAAAAAAAAAAAA";
	for (int i = 0; i<num_targets; i++)
	{
		char *Uid;
		ITK__convert_tag_to_uid(Targets[i], &Uid);
		strcpy(link, adresa);
		strcat(link, Uid);
		strcat(link, append);
		fprintf(stream, "%s \n", link);
	}
}