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

using namespace std;
//list<Bomline> *seznam=NULL;


int poradi=0;
struct obsahuje{
	char id_polozky[20];
	char rev_polozka[4];
	tag_t Rev;
	tag_t parentRev;
	char seq_no[16];

	
};
 //std::list<obsahuje>seznam;
obsahuje *seznam= (obsahuje *)malloc(sizeof(obsahuje) * 1000);


int Equels_obsah (obsahuje element,int pocet,obsahuje porovnani[],char **Use_seq_no)
{
	//printf ("********hledani %d ********\n",pocet);
	for (int i=1;i<pocet;i++)
	{
		//printf("i=%d Porovnani \n %s - %s \n  %s - %s \n",i,element.id_polozky,porovnani[i].id_polozky, element.rev_polozka, porovnani[i].rev_polozka);
		if(strcmp(element.id_polozky,porovnani[i].id_polozky)==0 
			&& strcmp(element.rev_polozka,porovnani[i].rev_polozka)==0 
			&& strcmp(element.seq_no,porovnani[i].seq_no)==0 
			&& element.parentRev==porovnani[i].parentRev)
		{
			printf ("NALEZO absolutne -------- \n");
			return 0;
		}
		else if(strcmp(element.id_polozky,porovnani[i].id_polozky)==0 
			&& strcmp(element.rev_polozka,porovnani[i].rev_polozka)==0 
			&& strcmp(element.seq_no,porovnani[i].seq_no)!=0 
			&& element.parentRev==porovnani[i].parentRev)
		{
			printf ("NALEZO shluknout -------- \n");
			printf("->> seq_no %s \n",porovnani[i].seq_no);
			*Use_seq_no=porovnani[i].seq_no;
			printf("->>> use_seq_no %s \n",*Use_seq_no);
			return -2;
		}
		else if(strcmp(element.id_polozky,porovnani[i].id_polozky)==0 && strcmp(element.rev_polozka,porovnani[i].rev_polozka)==0)
		{
			printf ("NALEZO -------- \n");
			return i;
		}
	}
	printf("NENALEZENO --------------\n");
	return -1;

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
 tag_t create_relation_ps(char relation_type[GRM_relationtype_name_size_c + 1], tag_t primary_object_tag, tag_t secondary_object_tag)
{
    tag_t relation_type_tag = NULLTAG;
    IFERR_REPORT(GCR_find_relation_type(relation_type, &relation_type_tag));
	printf("realtion type_%d \n -primary_object_tag %d \n -secondary_object_tag %d \n",relation_type_tag,primary_object_tag, secondary_object_tag);
    tag_t relation_tag  = NULLTAG;
    IFERR_REPORT(GCR_create_relation(primary_object_tag, secondary_object_tag, relation_type_tag, NULLTAG, &relation_tag));

    IFERR_REPORT(GCR_save_relation(relation_tag));
    return relation_tag;
}

static void create_relation_with_required_property(tag_t primary_object, 
        tag_t secondary_object, tag_t relation_type, char* relation_find,char* primary_property, char* secondary_property, char* relaton_type)
{
    tag_t grm_type = NULLTAG;
    IFERR_REPORT(TCTYPE_find_type(relation_find, NULL, &grm_type));

    tag_t grm_create_input = NULLTAG;
    IFERR_REPORT(TCTYPE_construct_create_input(grm_type, &grm_create_input));

    IFERR_REPORT(AOM_set_value_tag(grm_create_input, primary_property, primary_object));
   // IFERR_REPORT(AOM_set_value_tag(grm_create_input, secondary_property, secondary_object));
   // IFERR_REPORT(AOM_set_value_tag(grm_create_input, relaton_type,  relation_type));
 //   IFERR_REPORT(AOM_set_value_string(grm_create_input, "a2_required_prop", "some string"));

    tag_t relation = NULLTAG;
    IFERR_REPORT(TCTYPE_create_object(grm_create_input, &relation));
    IFERR_REPORT(AOM_save(relation));
}


tag_t create_item(char* typ_rev,char *typ_item, char *name)
{
    int ifail = ITK_ok;
    int rstat;
	char master_name[50];
	printf("copy %s \n",typ_rev);
	strcpy(master_name,"Part Revision");
	printf("cat %s \n",master_name);
	strcat(master_name," Master");
     printf("vysledek %s \n",master_name);

        tag_t type_tag = NULLTAG;
      //  rstat = TCTYPE_find_type (master_name,master_name, &type_tag);
	//	if(rstat) printf ("chyba %d \n", __LINE__);
                
        tag_t irmf_create_input_tag = NULLTAG;
       // rstat = TCTYPE_construct_create_input (type_tag, &irmf_create_input_tag);
                
        const char *form_name[1] = {"123456/A"};
        //rstat = TCTYPE_set_create_display_value( irmf_create_input_tag, "object_name", 1, form_name);
        
        const char *user_data_1[1] = {name};
      //  rstat = TCTYPE_set_create_display_value( irmf_create_input_tag, "user_data_1", 1, user_data_1);
        
        tag_t form_tag = NULLTAG;
     //   rstat = TCTYPE_create_object(irmf_create_input_tag, &form_tag );
       // rstat = AOM_save(form_tag);
        
        rstat = TCTYPE_find_type ( typ_rev, typ_rev, &type_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
		printf("type_tag %d \n",type_tag);

        tag_t rev_create_input_tag = NULLTAG;
        rstat = TCTYPE_construct_create_input (type_tag, &rev_create_input_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
		printf("create imput  %d \n",rev_create_input_tag);
        
       // rstat = AOM_set_value_tag(rev_create_input_tag, "item_master_tag", form_tag);
        
        const char *object_desc[] = {"Some Description "};
        rstat = TCTYPE_set_create_display_value(rev_create_input_tag, "object_desc", 1, object_desc );
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
    
        rstat = TCTYPE_find_type(typ_item,  typ_item, &type_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
        
        tag_t item_create_input_tag = NULLTAG;
        rstat = TCTYPE_construct_create_input (type_tag, &item_create_input_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
    
        //const char *item_id[1] = {"123456"};
        //rstat = TCTYPE_set_create_display_value( item_create_input_tag, "item_id", 1, item_id);

        const char *object_name[1] = {name};
        rstat = TCTYPE_set_create_display_value( item_create_input_tag, "object_name", 1, object_name);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
        
		IFERR_REPORT(AOM_set_value_tag(item_create_input_tag, "revision", rev_create_input_tag));
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
        
        tag_t item_tag = NULLTAG;
        IFERR_REPORT(TCTYPE_create_object(item_create_input_tag, &item_tag ));
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);

        rstat = ITEM_save_item(item_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
   
    
    return item_tag;
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
tag_t FindRev_NP(char* id_helios)
{tag_t Nalez;

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
				if (n_objects==1)
					return revs[0];
	return 0;
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
				printf("pocet nalezu %d\n",n_folder);

				//vloženi do folder TPianty
				MoveTPToFolder(*folder,Item);
}
//kopírovýní absolutní transformaèní matice

void SetString(tag_t object,char* value,char* attribut)
{
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
	tag_t Item;
	char* Id,
		* RevId,
		* obj_name;
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
	tag_t * 	primary_list;
	tag_t relation_type;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//printf("220 find relation %d \n",relation_type);
	err = GRM_list_primary_objects_only(Child, relation_type, &Count, &primary_list);
	printf("count %d \n", Count);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//GetName_rev(primary_list[0]);
	if(Count>0)
	*primary_obj=primary_list[0];
	//printf ("secondary list [0] %d \n",*secondary_list);
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	return Count;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////
void CopyAttr(tag_t KPRev, tag_t VPRev)
{  
	char* vykres_norma,
		* zak_rev,
		* cv_zakaznik;
	double hmotnost=0;
		
	AOM_ask_value_string(KPRev,"h4_vykres_norma",&vykres_norma);
	SetString(VPRev,vykres_norma,"h4_vykres_norma");
	AOM_ask_value_string(KPRev,"h4_zak_rev",&zak_rev);
	SetString(VPRev,zak_rev,"h4_zak_rev");
	AOM_ask_value_string(KPRev,"h4_cv_zakaznik",&cv_zakaznik);
	SetString(VPRev,cv_zakaznik,"h4_cv_zakaznik");
	AOM_ask_value_string(KPRev,"h4_oc_zakaznik",&cv_zakaznik);
	SetString(VPRev,cv_zakaznik,"h4_oc_zakaznik");
	AOM_ask_value_double(KPRev,"h4_hmotnost",&hmotnost);
	SetDouble(VPRev,hmotnost,"h4_hmotnost");
}

void  Add_occ(tag_t bvr,tag_t Child_rev,char* seq_no ,char* qnt )
{
	AOM_lock(bvr);
	AOM_lock(Child_rev);
	tag_t *Occ;
		printf ("vlozit dalsi radek\n");
	int Status;
	printf(">>>qnt %s \n",qnt);
	double quantity=atof(qnt);
	printf(">>>quattity %d \n",quantity);
		IFERR_REPORT(Status=PS_create_occurrences(bvr, Child_rev,NULLTAG,1,&Occ));
		//if(Status ==ITK_ok)EMH_clear_last_error(Status);
		
		IFERR_REPORT(PS_set_occurrence_qty( bvr, *Occ, quantity ));
		//Sets the sequence number of an occurrence.
		IFERR_REPORT(PS_set_seq_no( bvr, *Occ,seq_no));
		AOM_save(bvr);
		AOM_save(Child_rev);
		AOM_unlock(Child_rev);
		AOM_unlock(bvr);
		AOM_refresh(bvr,FALSE);

							
							 
}
int Crete_Tech_Kus(tag_t Parent, tag_t Parent_rev, tag_t Child_rev,char* seq_no,char* qnt)
{
		tag_t BomView = NULLTAG;
		tag_t TopBomLineTP =NULLTAG;

		tag_t query = NULLTAG;
		tag_t bvr =NULLTAG;


		char rev_id[ITEM_id_size_c+1];
		//tag_t BomViewType =NULLTAG;

		// BomView Type
	tag_t BomViewType= NULLTAG;
	PS_ask_default_view_type( &BomViewType);
	printf("BomViewType %d \n",BomViewType);			

	printf(" Parent %d \n Parent_re %d \n Child_Rev %d \n",Parent,Parent_rev,Child_rev);
	IFERR_REPORT(PS_create_bom_view (BomViewType, NULL, NULL, Parent, &BomView));
	printf("BomView %d \n",BomView);
	AOM_save (BomView);
	ITEM_save_item(Parent);
	
	ITEM_ask_rev_id( Parent_rev,rev_id);
	printf("\n rev_id %s \n", rev_id);
    
	IFERR_REPORT(PS_create_bvr (BomView, NULL, NULL,  true, Parent_rev, &bvr));
	printf("bvr %d \n",bvr);
    AOM_save (bvr);
    AOM_save(Parent_rev);


	//tag_t *Occ=NULLTAG;	
							
	ITEM_ask_rev_id( Child_rev,rev_id);
	printf("rev_id %s \n", rev_id);
	//	AOM_lock(bvr);
						
		Add_occ(bvr,Child_rev,seq_no,qnt);				
	//	int Status=PS_create_occurrences(bvr, Child_rev,NULLTAG,1,&Occ);
	//	printf(" status %d \n",Status);
					
	//	printf("tag Occ %d \n",*Occ);
	/*	AOM_save(bvr);
		AOM_save(Parent_rev);
		AOM_unlock(bvr);*/
		AOM_refresh(bvr,FALSE);
		//MEM_free(Occ);
return BomView;

}
void Make_View (tag_t Parent_rev,tag_t Parent, tag_t rev,tag_t design_view,tag_t design_bomline, tag_t *BomWindow_part, char* seq_no, char* qnt)
{
	printf("line=%d \n",__LINE__);
	int n_bvrs = 0;
								tag_t *bvrs = NULL;
								IFERR_REPORT(AOM_refresh(Parent_rev,TRUE));
								printf("Parent_rev %d \n",Parent_rev);
								int err=ITEM_rev_list_bom_view_revs(Parent_rev, &n_bvrs, &bvrs);
								if(err)printf("chyba %d na radku %d\n",err,__LINE__);
								printf(" n_bvrs %d \n bvrs %d\n",n_bvrs);
								if(n_bvrs==0)
								{
									printf("zadny kusovnik \n");
									tag_t bomline_target;
									tag_t tech_View=Crete_Tech_Kus( Parent, Parent_rev, rev,seq_no,qnt);
									//Vytvoø relace mezi kusovniky Link Associate 
									tag_t relation_type;
								//	GRM_find_relation_type("Fnd0DesignToBomLink", &relation_type);
									printf(" relation_type %d \n",relation_type);
									*BomWindow_part=tech_View;
									//create_relation_ps("Fnd0DesignToBomLink",tech_View,design_view);
									
								//	create_relation_with_required_property(tech_View,design_view,relation_type,"IMAN_METarget","IMAN_METarget","IMAN_METarget","IMAN_METarget");
								//	GRM_find_relation_type("Fnd0DesignToBomLink", &relation_type);
								//	create_relation_with_required_property(tech_View,design_view,relation_type);
									/*ADD2Relation(tech_View,design_view,"IMAN_METarget"); 
									ADD2Relation(tech_View,design_view,"Fnd0DesignToBomLink");*/
									
									
								}else if(n_bvrs==1)
								{
									printf("jeden kusovník %d \n",bvrs[0]);
									 Add_occ(bvrs[0],rev,seq_no,qnt);
								}
						/*		if(n_bvrs==1)
								{
									printf("jeden kusovník %d \n",bvrs[0]);
									 Add_occ(bvrs[0],PartRev);
								}
								else if(n_bvrs== NULLTAG)
								{
									printf("zadny kusovnik \n");
									Crete_Tech_Kus( Parent, Parent_rev, PartRev);
								}*/
}

void DruhMaterilu(tag_t designRev,tag_t revPart, tag_t stredisko_lak)
{
	printf("---set druh materialu---- \n");
	char* typ_dilce;
	char *Type;
	WSOM_ask_object_type2(revPart,&Type);//Returns the object type of the specified WorkspaceObject.
	IFERR_REPORT(AOM_ask_value_string(designRev,"h4_typ_dilce",&typ_dilce));
	if (strcmp(Type,"H4_NPVDRevision")==0)
		SetString(revPart,"ROH","h4_druh_mat");
	else if(strcmp(Type,"H4_KOOPRevision")==0)
		SetString(revPart,"UNBW","h4_druh_mat");
	else if (stredisko_lak!=0)
	{
		//IFERR_REPORT(AOM_ask_value_string(stredisko_lak,"h4_typ_dilce",&typ_dilce));
		if(strcmp(typ_dilce,"Finalni vyrobek")==0)
			SetString(revPart,"HALB","h4_druh_mat");
		else if(strcmp(typ_dilce,"Polotovar")==0)
			SetString(revPart,"HALB","h4_druh_mat");
	}
	else if(strcmp(typ_dilce,"Finalni vyrobek")==0)
		SetString(revPart,"FERT","h4_druh_mat");
	else if(strcmp(typ_dilce,"Polotovar")==0)
		SetString(revPart,"HALB","h4_druh_mat");

	CopyAttr(designRev, revPart);
}
int IsAssembly2(tag_t Otec, char * Relation, tag_t RootTask)
{
	printf("---IsAssembly--- \n");
	int Count = 0;
	char *Type;
	tag_t * 	secondary_list;
	tag_t relation_type;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	printf("107 find relation %d \n",relation_type);
	err = GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	printf("count %d \n", Count);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	for (int i=0;i<Count;i++)
	{
		WSOM_ask_object_type2(secondary_list[i],&Type);//Returns the object type of the specified WorkspaceObject.
	//printf ("secondary list [0] %d \n",*secondary_list);
	if(strcmp(Type,"SE Assembly")==0)
		return 1;
	}
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	printf("return 0 \n");
	return 0;
}

void CreateDM (tag_t DesignRev,tag_t PartRev, char* jmeno, tag_t design_view, tag_t design_bomline, tag_t *part_view,char *seq_no )
{
	tag_t PartItem;
	char* vykres_norma;
	char* dilec;
	int Assembly=IsAssembly2(DesignRev, "IMAN_specification",NULLTAG);// kdyz je hodnoty 1 tak je sestavou 
	AOM_ask_value_string(DesignRev,"h4_vykres_norma",&vykres_norma);
	AOM_ask_value_string(DesignRev,"h4_dilec",&dilec);

	ITEM_ask_item_of_rev(PartRev,&PartItem);
	printf("---IsAssembly--- \n");
	printf("____________\n>>> Crete DM  \n vykres_norma =%s \n Assembly=%d \n dilec=%s \n________\n",vykres_norma,Assembly,dilec);

	if( strcmp(vykres_norma,"0")!=0 && Assembly==0 && strcmp(dilec,"ANO")==0)
	{
		printf(">>> Crete DM  \n vykres_norma =%s \n Assembly=%d \n dilec=%s \n",vykres_norma,Assembly,dilec);
		tag_t VypRev;
		tag_t Vyp=create_item("H4_VYPRevision","H4_VYP", jmeno);
		AOM_save(Vyp);
		ITEM_ask_latest_rev(Vyp,&VypRev);
		AOM_save(VypRev);
		DruhMaterilu(DesignRev,VypRev,0);
		Make_View (PartRev,PartItem, VypRev,design_view,design_bomline,part_view ,seq_no,"1");
		IntoFolder("Part_auto",Vyp);
	}
}

tag_t CreateNVPD (tag_t DesignRev,tag_t PartRev, char* jmeno, tag_t design_view, tag_t design_bomline, tag_t *part_view,char *seq_no, char* qnt )
{
	/*
	Generování NPVD
Vykres_norma != “0”
H4_material = “ANO” or “ANO bez DM”
H4_skupina_zbozi_nakupovana = “Wxx”
*/
	tag_t PartItem;
	char* vykres_norma;
	char* dilec;
	char* s_zbozi_nak;
	//int Assembly=IsAssembly(DesignRev, "IMAN_specification",NULLTAG);// kdyz je hodnoty 1 tak je sestavou 
	AOM_ask_value_string(DesignRev,"h4_skupina_zbozi_nakupovana",&s_zbozi_nak);
	AOM_ask_value_string(DesignRev,"h4_vykres_norma",&vykres_norma);
	AOM_ask_value_string(DesignRev,"h4_dilec",&dilec);

	ITEM_ask_item_of_rev(PartRev,&PartItem);
	//printf("____________\n>>> Crete NPVD  \n vykres_norma =%s \n skupina=%c \n dilec=%s \n________\n",vykres_norma,s_zbozi_nak[0],dilec);

	if( strcmp(vykres_norma,"0")!=0 && s_zbozi_nak[0]=='W' && strcmp(dilec,"ANO")==0)
	{
		printf(">>> Crete NPVD  \n vykres_norma =%s \n skupina=%s \n dilec=%s \n",vykres_norma,s_zbozi_nak, dilec);
		tag_t NPVDRev;
		tag_t NPVD=create_item("H4_NPVDRevision","H4_NPVD", jmeno);
		AOM_save(NPVD);
		ITEM_ask_latest_rev(NPVD,&NPVDRev);
		AOM_save(NPVDRev);
		DruhMaterilu(DesignRev,NPVDRev,0);
		Make_View (PartRev,PartItem, NPVDRev,design_view,design_bomline,part_view ,seq_no,qnt);
		IntoFolder("Part_auto",NPVD);
		return NPVD;
	}
	return NULLTAG;
}

tag_t CreateLAK (tag_t DesignRev,tag_t PartRev, char* jmeno, tag_t design_view, tag_t design_bomline, tag_t *part_view,char *seq_no )
{
	/*
	Generování LAK
Vykres_norma != “0”
H4_dilec = “ANO” or “ANO bez DM”
H4_povrchova_uprava1 = (èíslo)
*/
	tag_t PartItem;
	char* vykres_norma;
	char* dilec;
	char* povrch1;
	//int Assembly=IsAssembly(DesignRev, "IMAN_specification",NULLTAG);// kdyz je hodnoty 1 tak je sestavou 
	AOM_ask_value_string(DesignRev,"h4_vykres_norma",&vykres_norma);
	AOM_ask_value_string(DesignRev,"h4_dilec",&dilec);
	AOM_ask_value_string(DesignRev,"h4_povrchova_uprava1",&povrch1);

	ITEM_ask_item_of_rev(PartRev,&PartItem);
	//printf("____________\n>>> Crete LAK  \n vykres_norma =%s \n povrch1=%c \n dilec=%s \n________\n",vykres_norma,povrch1[0],dilec);

	if( strcmp(vykres_norma,"0")!=0 
		&& (strcmp(dilec,"ANO")==0 || strcmp(dilec,"ANO bez DM")==0) 
		&& (povrch1[0]=='0' || povrch1[0]=='1'|| povrch1[0]=='2' || povrch1[0]=='4' || povrch1[0]=='5' || povrch1[0]=='6' || povrch1[0]=='7' || povrch1[0]=='8' || povrch1[0]=='9'))
	{
		printf(">>> Crete LAK  \n vykres_norma =%s \n povrch1=%c \n dilec=%s \n",vykres_norma,povrch1[0],dilec);
		tag_t LakRev;
		//tag_t Lak_view;
		tag_t Lak=create_item("H4_LAKRevision","H4_LAK", povrch1);
		AOM_save(Lak);
		ITEM_ask_latest_rev(Lak,&LakRev);
		AOM_save(LakRev);
		DruhMaterilu(DesignRev,LakRev,0);
		//printf("partrev %d \n",PartRev);
		if(PartRev!=NULLTAG)
			Make_View (PartRev,PartItem, LakRev,design_view,design_bomline,part_view ,seq_no,"1");
		else printf ("PartRev= NULLTAG \n"); 
		
		IntoFolder("Part_auto",Lak);
		return LakRev;
	}
	return NULLTAG;
}

tag_t CreateKOOP (tag_t DesignRev,tag_t PartRev, char* jmeno, tag_t design_view, tag_t design_bomline, tag_t *part_view)
{
	tag_t PartItem;
	char* vykres_norma;
	char* dilec;
	char* povrch1;
	char* seq_no;
	//int Assembly=IsAssembly(DesignRev, "IMAN_specification",NULLTAG);// kdyz je hodnoty 1 tak je sestavou 
	AOM_ask_value_string(DesignRev,"h4_vykres_norma",&vykres_norma);
	AOM_ask_value_string(DesignRev,"h4_dilec",&dilec);
	AOM_ask_value_string(DesignRev,"h4_povrchova_uprava1",&povrch1);

	ITEM_ask_item_of_rev(PartRev,&PartItem);
	//printf("____________\n>>> Crete KOOP  \n vykres_norma =%d \n povrch1=%d \n dilec=%d \n________\n",strcmp(vykres_norma,"0"),povrch1[0]=='M',strcmp(dilec,"ANO"));
	int max_seq=GetMaxSeqNum (design_bomline);
	
	//printf("seq_no1 %s \n",seq_no1);
	//sprintf(seq_no2,"%d",max_seq+20);
	//printf("seq_no1 %s \n",seq_no2);
	if( strcmp(vykres_norma,"0")!=0 
		&& (strcmp(dilec,"ANO")==0 || strcmp(dilec,"ANO bez DM")==0) 
		&& (povrch1[0]=='M' || povrch1[0]=='K')
		)
	{
		printf("CREATE KOOP____________\n>>> Crete KOOP  \n vykres_norma =%s \n povrch1=%c \n dilec=%s \n________\n",vykres_norma,povrch1[0],dilec);
		tag_t KoopRev;
		tag_t Koop=create_item("H4_KOOPRevision","H4_KOOP", povrch1);
		AOM_save(Koop);
		ITEM_ask_latest_rev(Koop,&KoopRev);
		AOM_save(KoopRev);

		DruhMaterilu(DesignRev,KoopRev,0);
		//printf ("seq1 %s seq2 %s \n", seq_no1,seq_no2);
		sprintf(seq_no,"%d",max_seq+10);
		Make_View (PartRev,PartItem, KoopRev,design_view,design_bomline,part_view ,seq_no,"1");
		sprintf(seq_no,"%d",max_seq+20);
		Make_View (PartRev,PartItem, KoopRev,design_view,design_bomline,part_view ,seq_no,"0");
		IntoFolder("Part_auto",Koop);
		return KoopRev;
	}
	return NULLTAG;
}

void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,tag_t Parent, tag_t Parent_rev, tag_t *Topline_PartRev,tag_t *BomWindow_part)
{
	
    // Revize
    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
		
    char Id[ITEM_id_size_c + 1];
    char RevId[ITEM_id_size_c + 1];
	char* obj_name;
	char* seq_no;
	char* qnt;
	char* kp_vykres_norma;
	char* kp_dilec;
	char* kp_material;
	char* kp_assembly_report;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);
	AOM_ask_value_string(Item,"object_name",&obj_name);
	BOM_line_look_up_attribute("bl_sequence_no", &AttributeId);
	BOM_line_ask_attribute_string(BomLine, AttributeId,&seq_no);
	BOM_line_look_up_attribute("bl_quantity", &AttributeId);
	BOM_line_ask_attribute_string(BomLine, AttributeId,&qnt);
	BOM_line_look_up_attribute("bl_H4_Dilec_POMRevision_h4_vykres_norma", &AttributeId);
	BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_vykres_norma);
	BOM_line_look_up_attribute("bl_H4_Dilec_POMRevision_h4_dilec", &AttributeId);
	BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_dilec);
	BOM_line_look_up_attribute("bl_H4_Dilec_POMRevision_h4_material", &AttributeId);
	BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_material);
	BOM_line_look_up_attribute("SE Assembly Report", &AttributeId);
	BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_assembly_report);
	
	if (strcmp(kp_vykres_norma,"0")==0 
		|| (strcmp( kp_dilec,"NE")==0 && strcmp(kp_material,"NE")==0)
		|| strcmp(kp_assembly_report,"0")==0)
			goto nextLine;

	printf(">>>>quantity %s \n",qnt); 
    // Množství
	long d_stredisko;//pocet znakù strediska
	long d_povrch1;//pocet znaku povrch1
    //char *povrch1;
	char *polotovar;
	char *Value = NULL;
	
	tag_t Part = NULLTAG;
	tag_t PartRev = NULLTAG;

		//printf("%d %s/%s: %s, %s, %s, %s, poznamka: %s\n", Level, Id, RevId, povrch1, povrch2, povrch2, stredisko,poznamka);
		
	printf("%d %s/%s - %s \n", Level, Id, RevId, obj_name);
		
		//	if( strlen(varianta)!=0)
			//		{

	 obsahuje tmp;
		   strcpy(tmp.id_polozky,Id);
		   strcpy(tmp.rev_polozka,RevId);
		   strcpy(tmp.seq_no,seq_no);
		   tmp.parentRev=Parent_rev;
		  char* material;
		 AOM_ask_value_string(Rev,"h4_material",&material);
		   
		 //  std::list<obsahuje>::iterator it;
		 char* use_seq_no;
		  int nalez=Equels_obsah(tmp,poradi,seznam,&use_seq_no);

		  tag_t rel_obj_rev;
			  int vazby_NP=  CountInRelation(Rev, "TC_Is_Represented_By",&rel_obj_rev);
		
		 //  it=std::find(seznam.begin(),seznam.end(),tmp);
		 //  printf("******nalez = %d \n",nalez);
		/*if( it!=seznam.end())*/

	   if(nalez==0)
			  {
				  printf("0 -exituje nic nedelej \n");
			  }	
	   else if( nalez==-2 && vazby_NP==1)// pro položku která již jednou byla použita v kusovníku se stejným rodièem ale jiným Find.no
		{
		
			printf("1- use_find_no %s \n",use_seq_no);
			if(Level>0)
					{	
						printf("501 obj v relaci %d\n",rel_obj_rev);
						PartRev=rel_obj_rev;
						ITEM_ask_item_of_rev(PartRev,&Part);
						GetName_rev(rel_obj_rev);
						ITEM_ask_item_of_rev(PartRev,&Part);
						Make_View (Parent_rev,Parent, rel_obj_rev,BomWindow,BomLine,BomWindow_part,use_seq_no,qnt);			
					}
			else 
					{
						*Topline_PartRev=PartRev;
					}
			
		}
		else if( nalez>0 && strcmp(material,"ANO")!=0)// pro položku která již jednou byla použita v kusovniku 
		{
			if(Level>0)
					{
					printf("2 nalez %s/%s\n",seznam[nalez].id_polozky,seznam[nalez].rev_polozka);
					PartRev=seznam[nalez].Rev;
					ITEM_ask_item_of_rev(PartRev,&Part);
					printf(" Parent_rev %d Parent %d BomWindow %d BomLine %d BomWindow_part %d seq_no %d \n",Parent_rev,Parent,BomWindow,BomLine,BomWindow_part,seq_no);
					Make_View (Parent_rev,Parent, seznam[nalez].Rev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
					seznam[poradi++]=tmp;
					}

		} 
	   
		else if(strcmp(material,"ANO")==0 && vazby_NP==1) // pro konstrukèní rev nakupované položky
		{
			

			printf("3--pocet rel obj %d \n",vazby_NP);
		
				if(Level>0)
					{	
						printf("obj v relaci \n");
						GetName_rev(rel_obj_rev);
						PartRev=rel_obj_rev;
						ITEM_ask_item_of_rev(PartRev,&Part);
						Make_View (Parent_rev,Parent, rel_obj_rev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);	
						seznam[poradi++]=tmp;
					}
				else 
					{
						*Topline_PartRev=PartRev;
					}
			
		}
		else if(strcmp(material,"ANO")==0 && vazby_NP!=1) // pro konstrukèní rev nakupované položky
		{
			char *vykres_norma;
			tag_t NP;
			printf("4 chyba MATERIAL nemá relaci \n");
			AOM_ask_value_string(Rev,"h4_vykres_norma",&vykres_norma);
			tag_t NPRev=FindRev_NP(vykres_norma);
			if (NPRev!=NULLTAG && Level>0)
				{
					ITEM_ask_item_of_rev(NPRev,&NP);
					Make_View (Parent_rev,Parent,NPRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
						seznam[poradi++]=tmp;
			}

		}
		else if(vazby_NP==1)// pro konstruèní revizi vyrábìné položky pro kterou už existuje relace s vyrabenou  
		{
			printf("5 exituje relace VP \n");
			if(Level>0)
					{	
						printf("obj v relaci \n");
						GetName_rev(rel_obj_rev);
						PartRev=rel_obj_rev;
						ITEM_ask_item_of_rev(PartRev,&Part);
						Make_View (Parent_rev,Parent, rel_obj_rev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
						seznam[poradi++]=tmp;
					}
			else 
					{
						*Topline_PartRev=PartRev;
					}
		}
		else // po konstrukèni ktera nemá zadny part v relaci 
		{
			tag_t NPVD= CreateNVPD (Rev, PartRev, obj_name, BomWindow,BomLine,BomWindow_part,seq_no, qnt);
			if(NPVD!=NULLTAG)
			{
				ITEM_ask_latest_rev(NPVD,&PartRev);
				*Topline_PartRev=PartRev;
				//Vytvoø relace
					create_relation("TC_Is_Represented_By",PartRev,Rev);
					create_relation("TC_Primary_Design_Representation",PartRev,Rev);

					tmp.Rev= PartRev;
					seznam[poradi++]=tmp;
			}
			else
			{
				tag_t Lak_view;
			tag_t Lak_rev=CreateLAK (Rev,Parent_rev, obj_name,BomWindow,BomLine,BomWindow_part,seq_no);
			if(Lak_rev!=NULLTAG)
				Parent_rev=Lak_rev;

			
				printf("6 Create Part \n");
				Part=create_item("H4_VPRevision","H4_VP", obj_name);
				
					AOM_save(Part);
					ITEM_ask_latest_rev(Part,&PartRev);
					AOM_save(PartRev);
					
					char* PartId,
							* PartRevId;
					ITEM_ask_id2(Part,&PartId);
					ITEM_ask_rev_id2(PartRev,&PartRevId);
					printf("tag Part rev %d %s/ %s \n",PartRev,PartId,PartRevId);
					//seznam=Pridej(BomLine,Rev);
					//kopirovani attributu
					
					//Vytvoø relace
					create_relation("TC_Is_Represented_By",PartRev,Rev);
					create_relation("TC_Primary_Design_Representation",PartRev,Rev);
					//printf(" pocet relaci coll %d \n",Add2RepresentationFor(Rev, "Collection", PartRev));
					//SetTag(Rev,PartRev,"representation_for");
					//create_relation("representation_for",Rev,PartRev);		
							
					printf("poradi %d tem part tag \n",poradi );
					//AddToTarget(RootTask,Value,TP);
					tmp.Rev= PartRev;		
							
					seznam[poradi++]=tmp;
					if(Lak_rev!=NULLTAG)
					{
						

						
						printf("parent rev %d \n BonView:part %d \n",Parent_rev,BomWindow_part);
						Parent_rev=Lak_rev;
						ITEM_ask_item_of_rev(Parent_rev,&Parent);
						if(Level ==0)
							*Topline_PartRev=PartRev;
						DruhMaterilu(Rev,PartRev,Parent_rev);
						Level++;
					}
					else 
						DruhMaterilu(Rev,PartRev,0);

					CreateKOOP (Rev,PartRev, obj_name,BomWindow,BomLine,BomWindow_part);
					if(Level>0)
					{
								
						Make_View (Parent_rev,Parent, PartRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);

						
								
						CreateDM (Rev,PartRev, obj_name,BomWindow,BomLine,BomWindow_part,seq_no );		
					}
					else 
					{
						*Topline_PartRev=PartRev;
					}
			}
					printf(" \n \n VKLADAM \n \n");
					IntoFolder("Part_auto",Part);
							
		}
	
		nextLine:;
    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow,Part,PartRev,Topline_PartRev, BomWindow_part);
	// MEM_free(Childs);
	
	 printf(" ...konec-rekurze..\n \n");
		//MEM_free(povrch1);		
		//MEM_free(stredisko);		
		//MEM_free(varianta);
		//MEM_free(Value);
   
	//AddToTarget(RootTask,"V",TP);
}
//void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr );
void CopyBomline(tag_t Rev,tag_t target)
{
	


}
int main(int argc, char *argv[])
{
			tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde



    // ITK initialization
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);

    // Login
    int ReturnCode = TC_init_module("konstrukter_se", "konstrukter_se", "");
    if(ReturnCode != ITK_ok)
    {
        char *Message;
        EMH_ask_error_text(ReturnCode, &Message);
        fprintf(stderr, "ERROR: %s\n", Message);
    }
    printf("Login OK\n");
	
	char *KP="DAA 000 446",	
	//char *KP="DAA 000 281",
	//char *KP="000551",
		*Uid;
    // Vyhledání položek
    const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
    const char *AttrValues[1] = {KP};
    int ItemsCount = 0;
    tag_t *Items = NULLTAG;
	tag_t Targets=NULLTAG;
    ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &ItemsCount, &Items);
	ITEM_ask_latest_rev(*Items,&Targets);


	char *Type;
	WSOM_ask_object_type2(Targets,&Type);//Returns the object type of the specified WorkspaceObject.
	printf ("%s\n",Type);
	 int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets, &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
        for(int j = 0; j < BomsCount; j++)
        {

            // BOM window
            tag_t BomWindow = NULLTAG;
			tag_t BomWindow_part = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;
			tag_t BomTopLine_part = NULLTAG;
			int count_part=0;
			tag_t *BVRS_part;


            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets, Boms[j], &BomTopLine);
			
			//nastaveni context bomline absolute occurrence edit mode			
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			ListBomLine(BomTopLine, 0, 0,BomWindow,NULLTAG,NULLTAG,&BomTopLine_part,&BomWindow_part);
			
			printf(" BomTopLine_part %d BomWindow_part %d \n",BomTopLine_part,BomWindow_part);
			
			//ITEM_rev_list_bom_view_revs(BomTopLine_part,&count_part,&BVRS_part);

			//BOM_refresh_window(BomWindow_part);
   //         BOM_close_window(BomWindow_part);
			//			

			//printf("count_part %d BVRS_part %d \n",count_part,BVRS_part[0]);
			////IFERR_REPORT(AOM_save(BVRS_part[0]));
			//printf(" %d \n",__LINE__);
			////IFERR_REPORT(AOM_refresh(BVRS_part[0],TRUE));

			//  // Výpis BOM line 
   //         BOM_set_window_top_line(BomWindow_part, NULLTAG, BomTopLine_part, BVRS_part[0], &BomTopLine_part);
			//BOM_window_set_absocc_edit_mode(BomWindow_part,TRUE);
			//List_two_bom(BomTopLine,0,BomTopLine_part,0,BomWindow,BVRS_part[0]);

			BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
			//create_relation_ps("Fnd0DesignToBomLink",BomWindow_part,design_view);
			
        }
	
}


