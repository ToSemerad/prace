#define  _CRT_SECURE_NO_WARNINGS 1

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
#include <tc\folder.h>
#include <lov\lov.h>
#include <error.h>
#include <sa/person.h>
#include <tccore\grm.h>
#include <list>
#include <tccore/tctype.h>
#include <ps\gcr.h>
#include <ps\gcr_errors.h>
#include <sa/person.h>
#include <math.h>
#include <time.h>



using namespace std;
//globalni pomene
tag_t folder4part;

///
extern "C" DLLAPI int TPV_CopyAttr_Part_TC11_register_callbacks();
extern "C" DLLAPI int TPV_CopyAttr_Part_TC11_init_module(int *decision, va_list args);
int TPV_CopyAttr_Part(EPM_action_message_t msg);
EPM_decision_t A_TPV_CopyAttr_Part(EPM_rule_message_t msg);


extern "C" DLLAPI int TPV_CopyAttr_Part_TC11_register_callbacks()
{
    printf("Registruji handler-TPV_CopyAttr_Part_TC11.dll\n");
    CUSTOM_register_exit("TPV_CopyAttr_Part_TC11", "USER_init_module", TPV_CopyAttr_Part_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_CopyAttr_Part_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_CopyAttr_Part", "", TPV_CopyAttr_Part);
    if(Status == ITK_ok) printf("Handler pro zalozeni VKV %s \n", "TPV_CopyAttr_Part");


    return ITK_ok;
}

/// reportovani by Gtac
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

void LogErr(char * text, char *logfile, int line, char* time_stamp)
{
	FILE *fs;
	char *user_name_string = NULL;
	tag_t user_tag = NULLTAG;
	int ifail = POM_get_user(&user_name_string, &user_tag);
	if (ifail != ITK_ok) user_name_string = "Nenalezen";

	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	fprintf(fs, "user: %s;  cas:%s; line: %d text: %s \n", user_name_string, time_stamp, line, text);
	fclose(fs);
}
char *time_stamp() {

	char *timestamp = (char *)malloc(sizeof(char) * 16);
	//char timestamp[10];
	time_t ltime;
	ltime = time(NULL);
	struct tm *tm;
	tm = localtime(&ltime);

	sprintf(timestamp, "%04d-%02d-%02d_%02d:%02d:%02d", tm->tm_year + 1900, tm->tm_mon + 1,
		tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);


	return timestamp;
}
static void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;
		char *time = time_stamp();

		EMH_get_error_string(NULLTAG, return_code, &error_message_string);
		ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));

		LogErr(error_message_string, "report_error", line, time);

		if (error_message_string) MEM_free(error_message_string);
		ECHO(("\nExiting program!\n <<<<<<<\n"));
		exit(EXIT_FAILURE);
	}
}

/////////////////////////////////////////


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
	printf ("count %d \n",Count);
	if(Count>0)
	{
		*Objects=secondary_list;
		return Count;
	}
		return 0;
}

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

	if(Count>0)
	{
		*Objects=secondary_list;
		return Count;
	}
		return 0;
}
/////////////////////////////////////////////////////////////


double Zaokrouhli(double vstup,int des_mista)
{	
	double posun=10*des_mista;
	double vystup=0;
	int tmp;
	vystup=(vstup*posun)+0,5;
	tmp=(int)vystup;
	vystup=tmp/posun;
	return vystup;
}


tag_t FindRev_NP(char* id_helios)
{
				tag_t query = NULLTAG,
				* revs=NULLTAG;
				QRY_find("Hestego_NP_search", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"Stare cislo materialu (Helios ID)"};
				char *values[1] =  {id_helios};
				int n_objects = 0;
				//strcpy(values[0],folder);
				
							
				QRY_execute(query, 2, entries, values, &n_objects, &revs);
	tag_t np=*revs;
	if(revs) MEM_free(revs);
	return np;
}


void SetString(tag_t object,char* value,char* attribut)
{
	
	printf("set string %s attr %s\n",value,attribut);
	IFERR_REPORT(AOM_lock(object));
	IFERR_REPORT(AOM_set_value_string(object,attribut,value));
	IFERR_REPORT(AOM_save(object));
	IFERR_REPORT(AOM_unlock(object));
	//AOM_unload(object);
	//IFERR_REPORT(printf("Vlozeno %s\n",value));
}
void SetDouble(tag_t object,double value,char* attribut)
{
	IFERR_REPORT(AOM_lock(object));
	IFERR_REPORT(AOM_set_value_double(object,attribut,value));
	IFERR_REPORT(AOM_save(object));
	IFERR_REPORT(AOM_unlock(object));
	//AOM_unload(object);
	//IFERR_REPORT(printf("Vlozeno %s\n",value));
}
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr)
{int AttrId=0;
		IFERR_REPORT(BOM_line_look_up_attribute(Attr, &AttrId));
		IFERR_REPORT(BOM_line_set_attribute_string(BomLine, AttrId, value));
		IFERR_REPORT(BOM_save_window(BomWin));
}
int GetMaxSeqNum (tag_t BomLine_parent)
{
	int max_seq_no =0;
	int found=0;
	tag_t *Childs = NULLTAG;
    int ChildsCount;
	int AttributeId;
	char* seq_no;
    BOM_line_ask_child_lines(BomLine_parent, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)
	{
		BOM_line_look_up_attribute("bl_sequence_no", &AttributeId);
		BOM_line_ask_attribute_string(Childs[k], AttributeId,&seq_no);
		found=atoi(seq_no);
		if(found>max_seq_no)
			max_seq_no=found;
	}
	if (ChildsCount==0)
		max_seq_no=10;

	printf("max_seq_no %d \n",max_seq_no);
	if(Childs) MEM_free(Childs);
	return max_seq_no;
}
void SetTag(tag_t object,tag_t value,char* attribut)
{
	IFERR_REPORT(AOM_lock(object));
	IFERR_REPORT(AOM_set_value_tag(object,attribut,value));
	IFERR_REPORT(AOM_save(object));
	IFERR_REPORT(AOM_unlock(object));
	//AOM_unload(object);
	printf("----Vlozen tag %d\n",value);
}
void GetName_rev(tag_t Rev)
{
	char* obj_name;
	char *Type;
	IFERR_REPORT(WSOM_ask_object_type2(Rev,&Type));
	printf ("type = %s \n",Type);
	//IFERR_REPORT(ITEM_ask_item_of_rev(Rev, &Item));
    //IFERR_REPORT(ITEM_ask_id(Item, Id));
    //IFERR_REPORT(ITEM_ask_rev_id(Rev, RevId));
	IFERR_REPORT(AOM_ask_value_string(Rev,"object_name",&obj_name));
	printf(" ->> %s \n",obj_name);
	//printf(" ->> %s /%s - %s \n",Id,RevId,obj_name); 
}
int CountInRelation(tag_t Child, char * Relation,tag_t* primary_obj)
{
	int Count = 0;
	tag_t * primary_list=NULLTAG;
	tag_t relation_type;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//printf("220 find relation %d \n",relation_type);
	err = GRM_list_primary_objects_only(Child, relation_type, &Count, &primary_list);
	printf("count %d \n", Count);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//GetName_rev(primary_list[0]);
	if(Count==1)
		*primary_obj=primary_list[0];
	else if(Count>1)
		{
		for(int i=0;i<Count;i++)
				{
					char *Type;
					WSOM_ask_object_type2(primary_list[i],&Type);//Returns the object type of the specified WorkspaceObject.
					if (strcmp(Type,"H4_LAKRevision")==0)
					{
						*primary_obj=primary_list[i];
						if(primary_list) MEM_free(primary_list);
						return 1;
					}
				}
	}
	//printf ("secondary list [0] %d \n",*secondary_list);
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	if(primary_list) MEM_free(primary_list);
	return Count;
}
tag_t GetRelationObj(tag_t Rev,char *find_relation,char *find_typ_name)
{
	int n_specs;
	tag_t *specs=NULLTAG,
		relation_type_tag,
		type_tag;
	char type_name[TCTYPE_name_size_c+1] = "";

	IFERR_REPORT(GRM_find_relation_type(find_relation, &relation_type_tag)); 
    IFERR_REPORT(GRM_list_secondary_objects_only(Rev, relation_type_tag, &n_specs, &specs));

	int pocet_vyskytu=1;
    
	for ( int ii = 0; ii < n_specs; ii++) {
        IFERR_REPORT(TCTYPE_ask_object_type (specs[ii], &type_tag));
        
        IFERR_REPORT(TCTYPE_ask_name(type_tag, type_name));
        
                    
            // if(strcmp(typ,"pdf")==0) {
				//if(strcmp(typ,find_typ)==0) {
                    printf("-----typ %s\n",type_name);
                     // if (strcmp(type_name, "PDF") == 0)                    {
                        if (strcmp(type_name, find_typ_name) == 0)  
						{
						printf("nalezeno \n");
							tag_t tmp =specs[ii];
							if(specs) MEM_free(specs);
							return tmp;
						}

	}
						if(specs) MEM_free(specs);
						return NULLTAG;
}
/////////////////////////////////////////////////////////PRO revize VK

bool is_release ( tag_t obj)
{

	int is_released = 0;
			EPM_ask_if_released(obj,&is_released);
			if (is_released == 0)
				return false;

			return true;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////

tag_t FindItemVyr( char* id_vyr)
{
tag_t Object=NULLTAG ,
	Rev_obj=NULLTAG,
	query = NULLTAG;
	int Count;
	printf("kod povrch %s \n",id_vyr);

			// Find user's "Tasks to Perform" folder
											
				ITEM_find_item	(id_vyr,&Object);	 
	//ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	printf("pocet_nalezu %d \n", Count);
	if (Object!=NULLTAG)
	{	
		ITEM_ask_latest_rev(Object,&Rev_obj);
		return Rev_obj;
	}
	
	return 0; 
}

tag_t FindItemPovrch( char* kod_povrch)
{
tag_t* Object = NULLTAG,
	query = NULLTAG;
	int Count;
	printf("kod povrch %s \n",kod_povrch);

				QRY_find("Hestego_S_search", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[1] = {"Name"};
				char *values[1] =  {kod_povrch};
				
							
				QRY_execute(query, 1, entries, values, &Count, &Object);
	//ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	printf("pocet_nalezu %d \n", Count);
	if (Count==1)
	{
		tag_t tmp =Object[0];
		if (Object) MEM_free(Object);
		return tmp;
	}
	else if (Count>1)
	{
		if (Object) MEM_free(Object);
		return -1;
	}
	if (Object) MEM_free(Object);
	return 0; 
}

void SetSkupinaZboziVyrabena (tag_t VPRev,char* SkupinaZbozi)
{
	printf("---SetSkupinaZboziVyrabena---%s -> %d\n",SkupinaZbozi,strlen(SkupinaZbozi));
		int n_lovs;
		tag_t *lov=NULLTAG;
		logical answer;

		LOV_find	(	"H4_skupina_mat",&n_lovs,&	lov	 );	
		printf(" n_lovs %d \n",n_lovs);
		for (int i=0;i<n_lovs;i++)
			LOV_is_value_valid_string	(lov[i],SkupinaZbozi,&answer);
		
		if (answer)
			SetString(VPRev,SkupinaZbozi,"h4_skupina_mat");
		else if(strcmp(SkupinaZbozi,"100")==0)
			SetString(VPRev,"20Z01","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi,"110")==0)
			SetString(VPRev,"20Z11","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi,"350")==0)
			SetString(VPRev,"20Z35","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "400")==0)
			SetString(VPRev,"20Z40","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "500")==0)
			SetString(VPRev,"h4_skupina_mat","20Z50");
		else if(strcmp(SkupinaZbozi, "Z00")==0)
			SetString(VPRev,"20Z00","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "Z10")==0)
			SetString(VPRev,"20Z10","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "Z20")==0)
			SetString(VPRev,"20Z20","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "Z30")==0)
			SetString(VPRev,"20Z30","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "Z40")==0)
			SetString(VPRev,"20Z40","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "Z50")==0)
			SetString(VPRev,"20Z50","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "990")==0)
			SetString(VPRev,"20W10","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "991")==0)
			SetString(VPRev,"20W10","h4_skupina_mat");
		else if(strcmp(SkupinaZbozi, "M00")==0)
			SetString(VPRev,"20Z35","h4_skupina_mat");
	
		else 
			SetString(VPRev,"20Z00","h4_skupina_mat");
		//else
			//SetString(VPRev,SkupinaZbozi,"h4_skupina_mat");
		if(lov) MEM_free(lov);
}
void SetZakaznikRev (tag_t VPRev,tag_t KPRev)
{
	printf("---SetZakaznikRev---\n");
	char *zakaznikRev;
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_zak_rev",&zakaznikRev));
	if(strlen(zakaznikRev)==0)
		SetString(VPRev,"01","h4_zak_rev");
	else
	SetString(VPRev,zakaznikRev,"h4_zak_rev");
}

void SetStredisko(tag_t VPRev)
{
	char *Type;
	WSOM_ask_object_type2(VPRev,&Type);//Returns the object type of the specified WorkspaceObject.
	if (strcmp(Type,"H4_LAKRevision")==0)
	{
		SetString(VPRev,"LAK","h4_divize");
	}
	else if (strcmp(Type,"H4_VYPRevision")==0)
	{
		SetString(VPRev,"DM","h4_divize");
	}
	else
	{

			printf("---SetStredisko---\n");
			 char *user_name,
					*P_organ;
			tag_t	user_tag,
				person_tag;
			POM_get_user(&user_name, &user_tag);
			//printf("-----Jmeno %s tag %d-------\n",user_name,user_tag);
			SA_find_person2(user_name,&person_tag);
			//printf("person tag %d \n",person_tag);
			SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
			printf("organisation %s \n",P_organ);
			//SetString(VPRev,P_organ,"h4_divize");
		  if ( strcmp(P_organ,"15 Kapotaze stroju") == 0 || strcmp(P_organ,"KAP") == 0 )
					   { 
					SetString(VPRev,"KAP","h4_divize");	   
				   }
			else if ( strcmp(P_organ,"12 Zakazkova vyroba") == 0 || strcmp(P_organ,"ZAV") == 0)
			{
				SetString(VPRev,"ZAV","h4_divize");
		  }
		  else if (strcmp(P_organ,"11 Teleskopicke kryty") == 0 || strcmp(P_organ,"TSK") == 0 )
			{
				SetString(VPRev,"TSK","h4_divize");
		  }
		  else if ( strcmp(P_organ,"MEC") == 0 )
			{
				SetString(VPRev,"MEC","h4_divize");
		  }
	}
}

void CopyAttrNPVD (tag_t KPRev, tag_t VPRev)
{  
		printf("------Copy Attr-----\n");
	char* vykres_norma,
		* zak_rev,
		* skup_vyr,
		kod_final_vyrobku[6]=" ";
	double hmotnost=0;
	int pocet_znaku=0,
		pocatecni_znak=0;
		
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_vykres_norma",&vykres_norma));
	SetString(VPRev,vykres_norma,"h4_vykres_norma");
	printf("h4_vykres_norma %s \n",vykres_norma);
	
	pocet_znaku=strlen(vykres_norma);
	pocatecni_znak=pocet_znaku-5;
	if(pocatecni_znak<0)
		pocatecni_znak=0;

	strncpy(kod_final_vyrobku,&vykres_norma[pocatecni_znak],5);
	printf("kod_final_vyrobku %s \n",kod_final_vyrobku);
	SetString(VPRev,kod_final_vyrobku,"h4_kod_fin_vyr");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_zak_rev",&zak_rev));
	SetString(VPRev,zak_rev,"h4_zak_rev");

	IFERR_REPORT(AOM_ask_value_double(KPRev,"h4_hmotnost",&hmotnost));
	SetDouble(VPRev,hmotnost,"h4_hmotnost");

	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_skupina_zbozi_nakupovana",&skup_vyr));
	
	SetSkupinaZboziVyrabena (VPRev,skup_vyr);
	SetStredisko( VPRev);
	SetZakaznikRev(VPRev,KPRev);
}

void CopyAttr(tag_t KPRev, tag_t VPRev)
{  
	printf("------Copy Attr-----\n");
	char* vykres_norma,
		* zak_rev,
		* cv_zakaznik,
		* skup_vyr,
		kod_final_vyrobku[5],
		jakost[18]=" ";
	double hmotnost=0;
	int pocet_znaku=0,
		pocatecni_znak=0;
		
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_vykres_norma",&vykres_norma));
	SetString(VPRev,vykres_norma,"h4_vykres_norma");
	printf("h4_vykres_norma %s \n",vykres_norma);
	
	pocet_znaku=strlen(vykres_norma);
	pocatecni_znak=pocet_znaku-5;
	if(pocatecni_znak<0)
		pocatecni_znak=0;

	strncpy(kod_final_vyrobku,&vykres_norma[pocatecni_znak],5);
	printf("kod_final_vyrobku %s \n",kod_final_vyrobku);
	SetString(VPRev,kod_final_vyrobku,"h4_kod_fin_vyr");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_zak_rev",&zak_rev));
	SetString(VPRev,zak_rev,"h4_zak_rev");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_cv_zakaznik",&cv_zakaznik));
	char tmp_cv [32];
	strncpy(tmp_cv,cv_zakaznik,32);
	SetString(VPRev,tmp_cv,"h4_cv_zakaznik");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_oc_zakaznik",&cv_zakaznik));
	char tmp_oc [32];
	strncpy(tmp_oc,cv_zakaznik,32);
	SetString(VPRev,tmp_oc,"h4_oc_zakaznik");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_material_se",&cv_zakaznik));
	printf("jakost %d \n",strlen(cv_zakaznik));
	strncpy(jakost,cv_zakaznik,17);
	SetString(VPRev,jakost,"h4_jakost");
	IFERR_REPORT(AOM_ask_value_double(KPRev,"h4_hmotnost",&hmotnost));
	SetDouble(VPRev,hmotnost,"h4_hmotnost");
	IFERR_REPORT(AOM_ask_value_double(KPRev,"h4_vyska",&hmotnost));
	SetDouble(VPRev,hmotnost,"h4_vyska");
	IFERR_REPORT(AOM_ask_value_double(KPRev,"h4_sirka",&hmotnost));
	SetDouble(VPRev,hmotnost,"h4_sirka");
	IFERR_REPORT(AOM_ask_value_double(KPRev,"h4_hloubka",&hmotnost));
	SetDouble(VPRev,hmotnost,"h4_hloubka");
	IFERR_REPORT(AOM_ask_value_double(KPRev,"h4_objem",&hmotnost));
	SetDouble(VPRev,hmotnost,"h4_objem");
	//printf("------Copy Attr end-----\n");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_skupina_zbozi_vyrabena",&skup_vyr));
	SetSkupinaZboziVyrabena (VPRev,skup_vyr);
	SetStredisko( VPRev);
	SetZakaznikRev(VPRev,KPRev);
}


void DruhMaterilu(tag_t designRev,tag_t revPart, tag_t stredisko_lak,bool previous_lak)
{
	printf("---set druh materialu---- \n");
	char* typ_dilce;
	char *Type;
	WSOM_ask_object_type2(revPart,&Type);//Returns the object type of the specified WorkspaceObject.
	
	if(strcmp(Type,"H4_NPVDRevision")!=0)
		CopyAttr(designRev, revPart);
	else
		CopyAttrNPVD(designRev, revPart);

	IFERR_REPORT(AOM_ask_value_string(designRev,"h4_typ_dilce",&typ_dilce));
	printf("typ dilce %s \n",typ_dilce);
	if (strcmp(Type,"H4_NPVDRevision")==0)
		SetString(revPart,"2026","h4_druh_mat");
	else if(strcmp(Type,"H4_KOOPRevision")==0)
		SetString(revPart,"2046","h4_druh_mat");
	else if(strcmp(Type,"H4_VYPRevision")==0)
		SetString(revPart,"2015","h4_druh_mat");
	else if (stredisko_lak!=0)
	{
		//IFERR_REPORT(AOM_ask_value_string(stredisko_lak,"h4_typ_dilce",&typ_dilce));
		if(strcmp(typ_dilce,"Finální výrobek")==0)
		{
			
			SetString(stredisko_lak,"2011","h4_druh_mat");
			//SetString(stredisko_lak,"20Z20","h4_skupina_mat");
			SetString(revPart,"2015","h4_druh_mat");
			SetString(revPart,"50","h4_zvlastni_porizeni");
		}
		else if(strcmp(typ_dilce,"Polotovar")==0)
		{
			SetString(stredisko_lak,"2015","h4_druh_mat");
			SetString(revPart,"2015","h4_druh_mat");
		}
	}
	else if(strcmp(typ_dilce,"Finální výrobek")==0)
	{
		SetString(revPart,"2015","h4_druh_mat");
	//	SetString(revPart,"20Z20","h4_skupina_mat");
		if(previous_lak==FALSE)
		{
			SetString(revPart,"50","h4_zvlastni_porizeni");
			SetString(revPart,"2011","h4_druh_mat");
		}
	}
	else if(strcmp(typ_dilce,"Polotovar")==0)
		SetString(revPart,"2015","h4_druh_mat");
}

int TPV_CopyAttr_Part(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0;
tag_t *Targets = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;


	char *Argument=nullptr;
	char*Flag = nullptr;
	char*Value = nullptr;




EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
ITK_set_bypass(TRUE);
for (int i=0;i<TargetsCount;i++)
{
	tag_t* Objects;
	char* type;
	WSOM_ask_object_type2(Targets[i],&type);
	if(strcmp(type,"H4_DilecRevision")==0)
	{
			char* typeVP;
			WSOM_ask_object_type2(Targets[i],&typeVP);
		int pocetObj=GetObjInRelation_primary(Targets[i], "TC_Is_Represented_By",  &Objects);
		for (int j =0;j<pocetObj;j++)

		if(strcmp(typeVP,"H4_LAKRevision")==0)
		{
			CopyAttr(Targets[i],Objects[j]);
		}
		else if(strcmp(typeVP,"H4_VPRevision")==0)
		{
			CopyAttr(Targets[i],Objects[j]);
		}
		else if(strcmp(typeVP,"H4_VYPRevision")==0)
		{
			CopyAttr(Targets[i],Objects[j]);
		}
		else if(strcmp(typeVP,"H4_NPVDRevision")==0)
		{
			CopyAttrNPVD (Targets[i],Objects[j]);
		}
		else if(strcmp(typeVP,"H4_KOOPRevision")==0)
		{
			CopyAttr(Targets[i],Objects[j]);
		}
	}

}
ITK_set_bypass(FALSE);
    return ITK_ok;
}
