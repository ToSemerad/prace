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
extern "C" DLLAPI int TPV_Create_Part_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Create_Part_TC11_init_module(int *decision, va_list args);
int TPV_Create_Part(EPM_action_message_t msg);
EPM_decision_t A_TPV_Create_Part(EPM_rule_message_t msg);


extern "C" DLLAPI int TPV_Create_Part_TC11_register_callbacks()
{
    printf("Registruji handler-TPV_Create_Part_TC11.dll\n");
    CUSTOM_register_exit("TPV_Create_Part_TC11", "USER_init_module", TPV_Create_Part_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Create_Part_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Create_Part", "", TPV_Create_Part);
    if(Status == ITK_ok) printf("Handler pro zalozeni VKV %s \n", "TPV_Create_Part");


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
		//ECHO(("\nExiting program!\n <<<<<<<\n"));
		//exit(EXIT_FAILURE);
	}
}

/////////////////////////////////////////
//////////////////////////////Struktury/////////////////////
int poradi=0;
struct obsahuje{
	char id_polozky[20];
	char rev_polozka[4];
	tag_t Rev;
	tag_t parentRev;
	char seq_no[16];
	

	
};
char Divize[10]="null";
 //std::list<obsahuje>seznam;
obsahuje *seznam=(struct obsahuje *) calloc(3000, sizeof(obsahuje));;



int Equels_obsah (obsahuje element,int pocet,obsahuje porovnani[],char **Use_seq_no, int parent_norma_null)
{
	printf ("********hledani %d ********\n",pocet);
	int out=-1;
	
	for (int i=1;i<pocet;i++)
	{
		//printf("i=%d Porovnani \n %s - %s \n  %s - %s \n",i,element.id_polozky,porovnani[i].id_polozky, element.rev_polozka, porovnani[i].rev_polozka);
		if(strcmp(element.id_polozky,porovnani[i].id_polozky)==0 
			&& strcmp(element.rev_polozka,porovnani[i].rev_polozka)==0 
			&& (strcmp(element.seq_no,porovnani[i].seq_no)!=0 || parent_norma_null==1)
			&& element.parentRev==porovnani[i].parentRev)
		{
			printf("i=%d Porovnani \n %s - %s \n  %s - %s \n seq_no %s - %s \n parent_norma_null %d \n______\n",i,element.id_polozky,porovnani[i].id_polozky, element.rev_polozka, porovnani[i].rev_polozka,element.seq_no,porovnani[i].seq_no,parent_norma_null);
			printf ("NALEZO shluknout -------- \n");
		//	printf("->> seq_no %s \n",porovnani[i].seq_no);
			*Use_seq_no=porovnani[i].seq_no;
		//	printf("->>> use_seq_no %s \n",*Use_seq_no);
			return -2;
		}
		
		else if(strcmp(element.id_polozky,porovnani[i].id_polozky)==0 
			&& strcmp(element.rev_polozka,porovnani[i].rev_polozka)==0 
			&& strcmp(element.seq_no,porovnani[i].seq_no)==0 
			&& element.parentRev==porovnani[i].parentRev)
		{
			printf("i=%d Porovnani \n %s - %s \n  %s - %s \n seq_no %s - %s \n parent_norma_null %d \n______\n",i,element.id_polozky,porovnani[i].id_polozky, element.rev_polozka, porovnani[i].rev_polozka,element.seq_no,porovnani[i].seq_no,parent_norma_null);
			printf ("NALEZO absolutne -------- \n");
			return 0;
		}
		else if(strcmp(element.id_polozky,porovnani[i].id_polozky)==0 && strcmp(element.rev_polozka,porovnani[i].rev_polozka)==0)
		{
			printf("i=%d Porovnani \n %s - %s \n  %s - %s \n seq_no %s - %s \n parent_norma_null %d \n tag parent %d - %d \n______\n",i,element.id_polozky,porovnani[i].id_polozky, element.rev_polozka, porovnani[i].rev_polozka,element.seq_no,porovnani[i].seq_no,parent_norma_null,element.parentRev,porovnani[i].parentRev);
			printf ("NALEZO -------- \n");
			out =i;
		}
	}
	printf("NENALEZENO --------------\n");
	return out;

}
///////////////////////Revize///////////////////////////////

static void add_int_to_int_array(int add_int, int *n_int_array, int **int_array)
{
    int count = *n_int_array;
    count++;
    if (count == 1)
    {
     (*int_array) = (int *) MEM_alloc(sizeof(int));
    }
    else
    {
     (*int_array) = (int *) MEM_realloc((*int_array), count * sizeof(int));
    }
    (*int_array)[count - 1] = add_int;
    *n_int_array = count;
}

static void add_tag_to_tag_array(tag_t add_tag, int *n_tag_array, tag_t **tag_array)
{
    int count = *n_tag_array;
    count++;
    if (count == 1)
    {
     (*tag_array) = (tag_t *) MEM_alloc(sizeof(tag_t));
    }
    else
    {
     (*tag_array) = (tag_t *) MEM_realloc((*tag_array), count * sizeof(tag_t));
    }
    (*tag_array)[count - 1] = add_tag;
    *n_tag_array = count;
}

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
	printf (" num_target_objs %d \n", num_target_objs);
	for (int ii = 0; ii < num_target_objs; ii++)
	{
		/*logical latest=false;
		ITEM_rev_sequence_is_latest(target_object_tags[ii],&latest);
		printf("ii %d latest %d \n",ii,latest);
		if (latest)
		{*/
		printf("tag %d \n",target_object_tags[ii]);
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
				add_int_to_int_array(attached_object_count, &n_ints_in_list, &all_attached_object_count);
				for (int jj = 0; jj < attached_object_count; jj++)
				{
					add_tag_to_tag_array(deepcopydata_tags[jj], &n_tags_in_list,&all_deepcopydata_tags);
				}
			}
			if (deepcopydata_tags) MEM_free(deepcopydata_tags);
		//}
	}

	TCTYPE_revise_objects(num_target_objs, target_object_tags, revise_input_tags, all_attached_object_count, all_deepcopydata_tags, &target_copy_tags, &ifails);

	printf("\nNew Revisions:\n");
	for (int ii = 0; ii < num_target_objs; ii++)
	{
	/*	logical latest=false;
		ITEM_rev_sequence_is_latest(target_object_tags[ii],&latest);
		printf("ii %d latest %d \n",ii,latest);
		if (latest)
		{*/
			WSOM_ask_object_id_string(target_copy_tags[ii], &id_string);
			TCTYPE_ask_object_type(target_copy_tags[ii], &type_tag);
			TCTYPE_ask_name(type_tag, type_name);

			if (ifails[ii] == ITK_ok) printf("   %s (%s)\n", id_string, type_name);
			else
			{
				char *error_message_string;
				EMH_get_error_string(NULLTAG, ifails[ii], &error_message_string);
				//printf("\t%d %s\n", ifails[ii], error_message_string);
				if (error_message_string) MEM_free(error_message_string);
			}
		//}
	}
//	printf("cisteni pameti \n");
	if (revise_input_tags) MEM_free(revise_input_tags);
	if (all_attached_object_count) MEM_free(all_attached_object_count);
	if (all_deepcopydata_tags) MEM_free(all_deepcopydata_tags);
	if (attached_objs_tags) MEM_free(attached_objs_tags);
	if (target_copy_tags) MEM_free(target_copy_tags);
	if (ifails) MEM_free(ifails);
	if (id_string) MEM_free(id_string);
}

static void replace_relation(tag_t partRevTag, tag_t oldTag, tag_t newTag,char* relation)
{
	printf("REPLACE RELATION %s !!! %d %d %d \n",relation,partRevTag, oldTag, newTag);
	

	tag_t TypeTag = NULLTAG;
	IFERR_REPORT(GRM_find_relation_type(relation, &TypeTag));
	 

	IFERR_REPORT(AOM_refresh(partRevTag, TRUE));
	 

	AOM_refresh(oldTag, TRUE);
	 

	AOM_refresh(newTag, TRUE);
	 

	tag_t relationTag = NULLTAG;
	IFERR_REPORT(GRM_find_relation(partRevTag, oldTag, TypeTag,	&relationTag));
	 

	GRM_delete_relation(relationTag);
	 

	relationTag = NULLTAG;
	IFERR_REPORT(GRM_create_relation(partRevTag, newTag, TypeTag,NULLTAG, &relationTag));
	GRM_save_relation(relationTag);

	IFERR_REPORT(AOM_save(partRevTag));
	 

	AOM_save(oldTag);
	 
	 ITK_set_bypass(TRUE);
	int err=AOM_save(newTag);
//	printf("%d - %d \n",__LINE__,err);

	IFERR_REPORT(AOM_refresh(partRevTag, FALSE));
	 

	IFERR_REPORT(AOM_refresh(oldTag, FALSE));
	 

	err=AOM_refresh(newTag, FALSE);
	//printf("%d - %d \n",__LINE__,err);
}

void Zmeny_kusovniku(tag_t  parent,tag_t zmeny_rev,char *cislo_op_zmena, char *Op_num )
{printf("---ZMENY parent  \n");
	/*int CountBvr;
	tag_t *Bvrs;
	ITEM_rev_list_all_bom_view_revs(parent ,&CountBvr,&Bvrs);
	printf(" poèet Bvr %d tag %d \n",CountBvr,*Bvrs);*/
	//PS_create_occurrences	(	tag_t 	parent,tag_t 	child_item,tag_t 	child_bom_view,int 	n_occurrences,tag_t ** 	occurrences);		
			//printf(" parent  %d k %d",parent [k],k);
			// BomView Type
tag_t BomViewType= NULLTAG,
	BomWindowparent =NULLTAG;
PS_ask_default_view_type( &BomViewType);
printf("line 689 \n");
PS_create_bom_view (BomViewType, NULL, NULL, parent , &BomWindowparent );
printf("line 691 %d \n",BomWindowparent );
			 int BomsCountparent  = 0, CountOcc;
				tag_t *Boms_rev_parent  = NULLTAG,
					*Occ=NULLTAG;
				ITEM_rev_list_bom_view_revs(parent , &BomsCountparent , &Boms_rev_parent );//This function will return all objects attached to the Item Revision.
				printf(" Bomsparent  %d BomsCountparent  %d \n",*Boms_rev_parent ,BomsCountparent );
				PS_list_occurrences_of_bvr(*Boms_rev_parent ,&CountOcc,&Occ);
				printf("occ parent  %d \n",CountOcc);
				for(int i=0;i<CountOcc;i++)
				{
					tag_t child_item_rev, child_bom_view;
					PS_ask_occurrence_child(*Boms_rev_parent ,Occ[i],&child_item_rev,&child_bom_view);
					char Id[ITEM_id_size_c + 1];
					char RevId[ITEM_id_size_c + 1],
						*Type,
						*kv_parent ;
					tag_t Item = NULLTAG;
					ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s  \n",child_item_rev,Id,RevId);
					
						tag_t Meneny_Item;

					/*		ITEM_ask_item_of_rev(child_item_rev, &Item);
					ITEM_ask_id(Item, Id);
					ITEM_ask_rev_id(child_item_rev, RevId);
					printf("line %d item %s rev %s  \n",child_item_rev,Id,RevId);*/

						ITEM_ask_item_of_rev(zmeny_rev,&Meneny_Item);
						//printf("%d = %d \n",Meneny_Item,Item);
						if(Item==Meneny_Item)
						{
							tag_t *Occ_new;
							printf("shoda operace %s/%s \n",Id,RevId);
							char* seq_no;
							PS_ask_seq_no(*Boms_rev_parent ,Occ[i],&seq_no);
							printf("seq_no %s \n",seq_no);
							
							int Status=PS_create_occurrences(*Boms_rev_parent ,zmeny_rev,NULLTAG,1,&Occ_new);
								printf(" status %d \n",Status);
								printf("OCC [i] %d \n",Occ[i]);
							//	printf(" --------cislo_op %s=%d seq_no %s Op_num %s =>%d ---------\n",cislo_op_zmena,strlen(cislo_op_zmena),seq_no,Op_num,strcmp(seq_no,Op_num));
								int Del=PS_delete_occurrence(*Boms_rev_parent ,Occ[i]);
							printf("del %d\n",Del);
								if(Status ==ITK_ok)EMH_clear_last_error(Status);
								//const char* new_seq_no=seq_no;
								
							/*	if(strlen(cislo_op_zmena)!=0 && strcmp(seq_no,Op_num)==0 && strlen(Op_num)!=0)
								{
									printf(" -------->>>>>>>>>Menim <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_parent ,*Occ_new,cislo_op_zmena);
								}else if(strlen(cislo_op_zmena)!=0 && strlen(Op_num)==0){
									printf(" -------->>>>>>>>>Znovu hledam <<<<<<<<<< ---------\n");
									PS_set_seq_no(*Boms_rev_parent ,*Occ_new,cislo_op_zmena);
								}
								else {printf("*Boms_rev_parent  %d,*Occ_new %d,seq_no %\n",*Boms_rev_parent ,*Occ_new,seq_no);
									PS_set_seq_no(*Boms_rev_parent ,*Occ_new,seq_no);
									printf(" -------->>>>>>>>>NEMenim <<<<<<<<<< ---------\n");
								}*/
								AOM_save(*Boms_rev_parent );
						}
							
					
				tag_t*potomci_bvr,potomci_rev;
				int  potomci;
							/*PS_list_occurrences_of_bvr(*Boms_rev_parent ,&CountOcc,&Occ);
					PS_ask_occurrence_child(*Boms_rev_parent ,Occ[ii],&potomci_rev,&potomci);
					printf ("potomci %d \n",potomci);*/
				printf("hledam!!!\n");
				//PS_ask_occurrence_child(*Boms_rev_parent ,Occ[i],&potomci_rev,&potomci_rev);
				//printf ("potomci %d \n",potomci_rev);
					ITEM_rev_list_bom_view_revs(child_item_rev, &potomci, &potomci_bvr);
					printf ("potomci %d \n",potomci);
					//if(potomci>0)Zmeny_parent (child_item_rev,  RootTask,zmeny_rev, RevCount,cislo_op_zmena, Op_num );
				}
		if (Occ) MEM_free(Occ);
}


static void where_used_top_level(tag_t old_rev_tag,tag_t new_rev_tag)
{
    int n_parents = 0;
    int *levels = 0;
    tag_t *parents = NULL;   
	PS_where_used_all_levels;
	//printf("rev_tag %d \n",old_rev_tag);
    //IFERR_REPORT(PS_where_used_all(rev_tag, PS_where_used_all_levels, &n_parents, &levels, &parents)); 
    IFERR_REPORT(PS_where_used_precise(old_rev_tag, PS_where_used_all_levels, &n_parents, &levels, &parents)); 
    
   // printf("\n\n Top Level %d \n",n_parents); 
    for (int index = 0; index < n_parents; index++ )
    {
        if ((index == n_parents - 1  ||  levels[index] >= levels[index+1] ))
        {
            char *id_string = NULL;
            IFERR_REPORT(WSOM_ask_object_id_string(parents[index], &id_string)); 
          //  printf("==\t%s  level %d \n", id_string,levels[index]); 
			Zmeny_kusovniku(parents[index],new_rev_tag,"0", "0" );
            MEM_free(id_string); 
        }
    } 
    if(levels) MEM_free(levels); 
    if(parents) MEM_free(parents);     
}


int GetObjInRelation_secondary(tag_t Child, char * Relation, tag_t **Objects)
{
	int Count = 0;
	tag_t * 	secondary_list;
	tag_t relation_type,
		type_tag;
	char* type_name;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//printf("find relation %d \n", relation_type);
	err = GRM_list_secondary_objects_only(Child, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	//printf ("count %d \n",Count);
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
	tag_t * secondary_list;
	tag_t relation_type,
		type_tag;
	char* type_name;
	int err = GRM_find_relation_type(Relation, &relation_type);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }
	///printf("find relation %d \n", relation_type);
	err = GRM_list_primary_objects_only(Child, relation_type, &Count, &secondary_list);
	if (err != ITK_ok) { printf("Problem err %d \n", err); }

	if(Count>0)
	{	int i=Count;
		tag_t *latest_obj=new tag_t [3];
		Count=0;
		do
		{
			i--;
			logical latest=false;
			ITEM_rev_sequence_is_latest(secondary_list[i],&latest);
			printf("i %d latest %d tag %d\n",i,latest,secondary_list[i]);
			if (latest)
				{
					///printf("count %d \n",Count);
					latest_obj[Count++]=secondary_list[i];
					//*(Objects + (Count++))=&latest_obj;
					printf("%d obj %d \n",Count-1,latest_obj[Count-1]);
					//*Objects=secondary_list;
				}
			
		}
		while (i>0);
		*Objects=latest_obj;

		return Count;
	}
		return 0;
}
/////////////////////////////////////////////////////////////
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
void AddToRef(tag_t RootTask, int count, tag_t ItemRev)
{
	//printf("tak posilam do Targetu Roottask %d Item %d jmeno %s \n",RootTask,Item,O_Name);
	tag_t* Object = &ItemRev;
	//int Count;
	const int AttachmentTypes[1] = { EPM_reference_attachment};//EPM_reference_attachment ||EPM_target_attachment
	//const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
	//const char *AttrValues[1] = { O_Name };
	//FL_user_update_newstuff_folder(Item);

	//ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	//printf("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames);
	EPM_add_attachments(RootTask, count, Object, AttachmentTypes);
	//printf("nakonci ciklu\n");
}
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
tag_t create_item(char* typ_rev,char *typ_item, char *name, char* set_id)
{
    int ifail = ITK_ok;
    int rstat;
	char master_name[50];
	char obj_name[40];
	strncpy(obj_name,name,39);
	printf("-----Create info ------\n");
	printf("typrev %s \n typ item %s \n name %s - %d \n set_id %s \n",typ_rev,typ_item,obj_name,strlen(obj_name),set_id);
	strcpy(master_name,"Part Revision");
	//printf("cat %s \n",master_name);
	strcat(master_name," Master");
    // printf("vysledek %s \n",master_name);

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
		//printf("create imput  %d \n",rev_create_input_tag);
        
       // rstat = AOM_set_value_tag(rev_create_input_tag, "item_master_tag", form_tag);
        
      /*  const char *object_desc[] = {"Some Description "};
        rstat = TCTYPE_set_create_display_value(rev_create_input_tag, "object_desc", 1, object_desc );
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);*/
    
        rstat = TCTYPE_find_type(typ_item,  typ_item, &type_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
        
        tag_t item_create_input_tag = NULLTAG;
        rstat = TCTYPE_construct_create_input (type_tag, &item_create_input_tag);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);
		
		//printf("Create %d \n",item_create_input_tag);

        //const char *item_id[1] = {"123456"};
        //rstat = TCTYPE_set_create_display_value( item_create_input_tag, "item_id", 1, item_id);

        const char *object_name[1] = {obj_name};
		printf("------object_name %s %d \n",object_name[0],strlen(object_name[0]));
        rstat = TCTYPE_set_create_display_value( item_create_input_tag, "object_name", 1, object_name);
		if(rstat) printf ("chyba %d line %d \n",rstat, __LINE__);


		if(strcmp(set_id,"0")!=0)
		IFERR_REPORT( AOM_set_value_string(item_create_input_tag, "item_id", set_id));
        

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
  //  IFERR_REPORT(AOM_refresh( folder, TRUE));
	AOM_refresh( folder, TRUE);
    FL_insert(folder, object, 0);
	AOM_save(folder);
    //IFERR_REPORT(AOM_save(folder));
    //IFERR_REPORT(AOM_refresh( folder, TRUE));
	//printf("vlozeno!!!!!!!!!!!\n");
}
tag_t FindRev_NP(char* id_helios)
{
				tag_t query = NULLTAG,
				* revs=NULLTAG;
				QRY_find("Hestego_NP_search", &query);
				//printf("tag foldru Qry General je %d\n",query);
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
void IntoFolder(char* folderName,tag_t Item)
{
				tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("General...", &query);
				//printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[2] = {"Name","Type"};
				char *values[2] =  {folderName,"Folder"};
				int n_folder = 0;
				//strcpy(values[0],folder);
				
							
				QRY_execute(query, 2, entries, values, &n_folder, &folder);
				//printf("pocet nalezu %d\n",n_folder);

				//vloženi do folder TPianty			
				MoveTPToFolder(*folder,Item);
				if(folder) MEM_free(folder);
}
tag_t CreateFolder(char* name)
{
	tag_t type,
		input,
		new_folder;
	IFERR_REPORT(TCTYPE_find_type("Folder",NULL,&type));
	IFERR_REPORT(TCTYPE_construct_create_input(type,&input));
	IFERR_REPORT(AOM_set_value_string ( input, "object_name", name));
	IFERR_REPORT(TCTYPE_create_object(input,&new_folder));
//	FL_create(name,"zalozeno_test",&new_folder);
	IFERR_REPORT(AOM_save(new_folder));
	IFERR_REPORT(FL_user_update_newstuff_folder (new_folder));
	
	return new_folder;

}
void SetString(tag_t object,char* value,char* attribut)
{
	//ECHO(("set string %s attr %s delka %d \n",value,attribut,strlen(value)));
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

int Previous_rev_test(tag_t use_rev, tag_t * OldRelease_Rev)
{
	tag_t item;
	char* use_rev_id;
	ITEM_ask_item_of_rev(use_rev, &item);
	ITEM_ask_rev_id2(use_rev,&use_rev_id);
	int num_rev=atoi(use_rev_id);
	printf("%s - %d \n",use_rev_id,num_rev);
	
		for (int i =num_rev-1;i>0;i--)
		{	bool trojmistna_rev=false;
			char  	rev_id_found[3];
			int	n_found_revs;
			tag_t * 	found_rev_tags;
			printf(" i = %d \n",i);
			if (strlen(use_rev_id)==3)
			{
				trojmistna_rev=true;
				if( i<10)
					sprintf(rev_id_found,"00%d",i);
				else if(i<100)
					sprintf(rev_id_found,"0%d",i);
				else
					sprintf(rev_id_found,"%d",i);
			}else if (strlen(use_rev_id)==2)
			{
				if( i<10)
					sprintf(rev_id_found,"0%d",i);
				else
					sprintf(rev_id_found,"%d",i);
			
			}
			test2:;
			printf(" rev_id = %s \n",rev_id_found);
			ITEM_find_revisions	(item,rev_id_found ,&n_found_revs , &found_rev_tags);	
		
			printf("count revs %d \n", n_found_revs);
		
	//		ITEM_ask_item_of_rev(found_rev_tags[0], &item);
			if (n_found_revs==1)
			{
				ITEM_ask_rev_id2(found_rev_tags[0],&use_rev_id);
				printf("%s - %d \n",use_rev_id,i);
			

				if (is_release ( found_rev_tags[0]))
				{
					printf(" -> revize schválená \n");
				
					*OldRelease_Rev=found_rev_tags[0];
				//	if(found_rev_tags)MEM_free(found_rev_tags);	
					tag_t rel_obj_rev_NP,
						rel_obj_rev_VP;
					int existence=  CountInRelation(found_rev_tags[0], "TC_Is_Represented_By",&rel_obj_rev_NP);
					int primary_repre=  CountInRelation(found_rev_tags[0], "TC_Primary_Design_Representation",&rel_obj_rev_VP);
					if (existence >0 && primary_repre ==1)
					return 1;
				}
				else 
					printf(" -> revize NEschválená \n");
			}else 
			{
				printf(" -> revize nenalezene test 2 \n");
				if (trojmistna_rev)
				{
					printf(" -> test dvojmistni rev \n");
				if( i<10)
					sprintf(rev_id_found,"0%d",i);
				else
					sprintf(rev_id_found,"%d",i);
				trojmistna_rev=false;
				goto test2;
				}
			}
		}
	

	
	//ITEM_list_all_revs	(	item, 	count, tag_t ** 	rev_list);	
	// ITEM_find_revisions	(	tag_t 	item, const char * 	rev_id, int * 	n_revs, tag_t ** 	rev_tags);	
	return 0;
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
	else if (strcmp(Divize,"null")!=0)
	{
		SetString(VPRev,Divize,"h4_divize");
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

void AttachDataset (tag_t KPRev, tag_t VPRev)
{
	printf("---attach datset ---\n");
	char *Type;
	WSOM_ask_object_type2(VPRev,&Type);//Returns the object type of the specified WorkspaceObject.
	
	tag_t PDFDataset=GetRelationObj(KPRev,"IMAN_specification","PDF");
	
	if(PDFDataset!=NULLTAG)
		create_relation("IMAN_specification",VPRev,PDFDataset);
	
	
	tag_t DXFDataset=GetRelationObj(KPRev,"IMAN_specification","DXF");
	
	if(DXFDataset!=NULLTAG && strcmp(Type,"H4_VYPRevision")==0)
		create_relation("IMAN_specification",VPRev,DXFDataset);
	printf("line %d \n",__LINE__);
}
void ClearAttrPrenos(tag_t PartRev)
{
	SetString(PartRev,"","h4_transfer_desc");
	SetString(PartRev,"","h4_transfer_status");
}
void Create_Satere_Cis_mat(tag_t VPRev,char* vykres_norma,tag_t KPRev){
	
	char 	* pozice,
			* pozice2,
		old_num_mat [18];
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_pozice",&pozice));
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_pozice2",&pozice2));
	strcpy(old_num_mat,vykres_norma);
	strcat(old_num_mat,"-");
	strcat(old_num_mat,pozice);
	strcat(old_num_mat,pozice2);
	SetString(VPRev,old_num_mat,"h4_stare_cislo_mat");
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
	Create_Satere_Cis_mat(VPRev,vykres_norma,KPRev);
}

void CopyAttr(tag_t KPRev, tag_t VPRev)
{  
	printf("------Copy Attr-----\n");
	char* vykres_norma,
		* zak_rev,
		* cv_zakaznik,
		* skup_vyr,
		* name,
		* Type,

		kod_final_vyrobku[5]="",
		jakost[18]=" ";
	double hmotnost=0;
	int pocet_znaku=0,
		pocatecni_znak=0;
	WSOM_ask_object_type2(VPRev,&Type);//Returns the object type of the specified WorkspaceObject.
	
	if(strcmp(Type,"H4_VYPRevision")!=0)
	{
		IFERR_REPORT(AOM_ask_value_string(KPRev,"object_name",&name));
		SetString(VPRev,name,"object_name");
	}
		
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_vykres_norma",&vykres_norma));
	SetString(VPRev,vykres_norma,"h4_vykres_norma");
	printf("h4_vykres_norma %s \n",vykres_norma);
	
	pocet_znaku=strlen(vykres_norma);
	pocatecni_znak=pocet_znaku-5;
	if(pocatecni_znak<0)
		pocatecni_znak=0;
	if(strlen(&vykres_norma[pocatecni_znak])>5)
		strncpy(kod_final_vyrobku,&vykres_norma[pocatecni_znak],5);
	else
		strcpy(kod_final_vyrobku,&vykres_norma[pocatecni_znak]);
	printf("kod_final_vyrobku %s \n",kod_final_vyrobku);
	SetString(VPRev,kod_final_vyrobku,"h4_kod_fin_vyr");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_zak_rev",&zak_rev));
	SetString(VPRev,zak_rev,"h4_zak_rev");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_cv_zakaznik",&cv_zakaznik));
	char tmp_cv [32];
	strncpy(tmp_cv,cv_zakaznik,31);
	SetString(VPRev,tmp_cv,"h4_cv_zakaznik");
	IFERR_REPORT(AOM_ask_value_string(KPRev,"h4_oc_zakaznik",&cv_zakaznik));
	char tmp_oc [32];
	strncpy(tmp_oc,cv_zakaznik,31);
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
	Create_Satere_Cis_mat(VPRev,vykres_norma,KPRev);
}
void  Add_qty(tag_t bvr,tag_t Child_rev,char* seq_no ,char* qnt,tag_t parent,tag_t occ )
{
	AOM_lock(bvr);
	AOM_lock(Child_rev);
	tag_t *Occ;
		printf ("vlozit dalsi radek\n");
	int Status;
	printf(">>>qnt %s \n",qnt);
	double quantity;
	double add_qnt=atof(qnt);
	printf(">>>quattity %d \n",quantity);
	printf("bvr %d, Child_rev %d \n",bvr, Child_rev);
	PS_ask_occurrence_qty(parent,occ,&quantity);
	quantity=quantity+add_qnt;
		PS_set_occurrence_qty(parent,occ,quantity);
	//	if(Status ==ITK_ok)EMH_clear_last_error(Status);
		
		IFERR_REPORT(PS_set_occurrence_qty( bvr, *Occ, quantity ));
		//Sets the sequence number of an occurrence.
		IFERR_REPORT(PS_set_seq_no( bvr, *Occ,seq_no));
		IFERR_REPORT(AOM_save(bvr));
		//IFERR_REPORT(AOM_save(Child_rev));
		//IFERR_REPORT(AOM_unlock(Child_rev));
		IFERR_REPORT(AOM_unlock(bvr));
		IFERR_REPORT(AOM_refresh(bvr,FALSE));

							
							 
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
	printf("bvr %d, Child_rev %d \n",bvr, Child_rev);
		Status=PS_create_occurrences(bvr, Child_rev,NULLTAG,1,&Occ);
		if(Status ==ITK_ok)EMH_clear_last_error(Status);
		
		IFERR_REPORT(PS_set_occurrence_qty( bvr, *Occ, quantity ));
		//Sets the sequence number of an occurrence.
		IFERR_REPORT(PS_set_seq_no( bvr, *Occ,seq_no));
		IFERR_REPORT(AOM_save(bvr));
		//IFERR_REPORT(AOM_save(Child_rev));
		//IFERR_REPORT(AOM_unlock(Child_rev));
		IFERR_REPORT(AOM_unlock(bvr));
		IFERR_REPORT(AOM_refresh(bvr,FALSE));

							
							 
}
int Crete_Tech_Kus(tag_t Parent, tag_t Parent_rev, tag_t Child_rev,char* seq_no,char* qnt)
{
		tag_t BomView = NULLTAG;
		tag_t TopBomLineTP =NULLTAG;

		tag_t query = NULLTAG;
		tag_t bvr =NULLTAG;

		int n_bv=0;
		tag_t * bv;


		char rev_id[ITEM_id_size_c+1];
		//tag_t BomViewType =NULLTAG;

		// BomView Type
	tag_t BomViewType= NULLTAG;
	PS_ask_default_view_type( &BomViewType);
	printf("BomViewType %d \n",BomViewType);	

	ITEM_list_bom_views	(	Parent,&n_bv,&bv);


	printf(" Parent %d \n Parent_re %d \n Child_Rev %d \n n_bv %d \n",Parent,Parent_rev,Child_rev,n_bv);
	if(n_bv==0)
	{
	IFERR_REPORT(PS_create_bom_view (BomViewType, NULL, NULL, Parent, &BomView));
	printf("BomView %d \n",BomView);
	AOM_save (BomView);
	ITEM_save_item(Parent);
	}
	else if(n_bv==1) BomView=bv[0];
	tag_t item;
	char* item_id;
	ITEM_ask_rev_id( Parent_rev,rev_id);
	ITEM_ask_item_of_rev (Parent_rev,&item);
	ITEM_ask_id2(item,&item_id);
	
	printf("\n rev_id %s/%s \n BomView %d \n Parent_rev %d  \n",item_id, rev_id,BomView,Parent_rev);
      AOM_save(Parent_rev);
	IFERR_REPORT(AOM_refresh(Parent_rev,TRUE));
	IFERR_REPORT(PS_create_bvr (BomView, NULL, NULL, true, Parent_rev, &bvr));
	printf("bvr %d \n",bvr);
    AOM_save (bvr);
    AOM_save(Parent_rev);


	//tag_t *Occ=NULLTAG;	
							
	ITEM_ask_rev_id( Child_rev,rev_id);
	printf("rev_id %s \n", rev_id);
	//	AOM_lock(bvr);
		printf("line %d \n",__LINE__);				
		Add_occ(bvr,Child_rev,seq_no,qnt);				
	//	int Status=PS_create_occurrences(bvr, Child_rev,NULLTAG,1,&Occ);
	//	printf(" status %d \n",Status);
					
	//	printf("tag Occ %d \n",*Occ);
		AOM_save(bvr);
		AOM_save(Parent_rev);
		AOM_unlock(bvr);
		AOM_refresh(bvr,FALSE);
		//MEM_free(Occ);
		printf("line %d \n",__LINE__);
		printf(" BomView %d \n",BomView);
return BomView;

}
void Make_View (tag_t Parent_rev,tag_t Parent, tag_t rev,tag_t design_view,tag_t design_bomline, tag_t *BomWindow_part, char* seq_no, char* qnt)
{
	
							
	printf("line=%d \n",__LINE__);
	printf("tag_t Parent_rev %d   rev %d \n",Parent_rev, rev);
	tag_t item;
	char *id_item;
	ITEM_ask_item_of_rev (Parent_rev,&item);
	ITEM_ask_id2(item,&id_item);
	printf(" item %d %s \n",item,id_item);
	
	ITEM_ask_item_of_rev (rev,&item);
	ITEM_ask_id2(item,&id_item);
	printf(" item %d %s \n",item,id_item);
	//printf("tag_t Parent_rev %d,tag_t Parent %d, tag_t rev %d,tag_t design_view %d,tag_t design_bomline %d, tag_t *BomWindow_part %d, char* seq_no %s, char* qnt  %s\n",Parent_rev, Parent, rev, design_view, design_bomline, *BomWindow_part, seq_no, qnt);
	int n_bvrs = 0;
								tag_t *bvrs = NULLTAG;
								IFERR_REPORT(AOM_refresh(Parent_rev,TRUE));
								printf("Parent_rev %d \n",Parent_rev);
								int err=ITEM_rev_list_bom_view_revs(Parent_rev, &n_bvrs, &bvrs);
								if(err)printf("chyba %d na radku %d\n",err,__LINE__);
								printf(" n_bvrs %d \n bvrs %d\n",n_bvrs,bvrs);
								if(n_bvrs==0)
								{
									printf("zadny kusovnik \n");
									tag_t tech_View=Crete_Tech_Kus( Parent, Parent_rev, rev,seq_no,qnt);
									//Vytvoø relace mezi kusovniky Link Associate 
									tag_t relation_type;
								//	GRM_find_relation_type("Fnd0DesignToBomLink", &relation_type);
									
									
									printf(" relation_type %d tech_View %d\n",relation_type,tech_View);
									*BomWindow_part=tech_View;
									printf("line %d \n",__LINE__);
								
									
									
								}else if(n_bvrs==1)
								{
									printf("jeden kusovník %d \n",bvrs[0]);
									 Add_occ(bvrs[0],rev,seq_no,qnt);
								}
								if(bvrs)MEM_free(bvrs);
						
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
			
			//SetString(stredisko_lak,"2011","h4_druh_mat");
			//SetString(stredisko_lak,"20Z20","h4_skupina_mat");
			SetString(revPart,"2015","h4_druh_mat");
			//SetString(revPart,"50","h4_zvlastni_porizeni");
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
		/*if(previous_lak==FALSE)
		{
			SetString(revPart,"50","h4_zvlastni_porizeni");
			SetString(revPart,"2011","h4_druh_mat");
		}*/
	}
	else if(strcmp(typ_dilce,"Polotovar")==0)
		SetString(revPart,"2015","h4_druh_mat");
	


	AttachDataset(designRev, revPart);
	
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
	if(secondary_list) MEM_free(secondary_list);
	return 0;
}

tag_t VKV_rev (tag_t OldRelease_Rev,tag_t Targets, tag_t Parent_rev,tag_t Parent,tag_t design_view,tag_t design_bomline, tag_t* BomWindow_part,char* seq_no, char* qnt,int Level)
{
	tag_t *Objects=NULLTAG;
	tag_t returnRev=NULLTAG;
						char *old_rev_id; 
						ITEM_ask_rev_id2(OldRelease_Rev,&old_rev_id);
						printf ("EXISTUJE PREDCHOZI REVIZE CO JE SCHVALENA  %s tag  %d\n",old_rev_id,OldRelease_Rev);
						
						tag_t item, 
						latestRev,
						* Refs;
					int pocetObj=GetObjInRelation_primary(OldRelease_Rev, "TC_Is_Represented_By",  &Objects);
					//int   pocetObj= GetObjInRelation_secondary(OldRelease_Rev, "TC_Is_Represented_By",  &Objects);
						printf ("POCET SEC_OBJ %d \n",pocetObj);
						for(int i=0;i<pocetObj;i++)
							printf(" PRIMARY_OBJ %d \n",Objects[i]);

						revise_item_revisions(pocetObj, Objects);
						
						for(int i = 0; i < pocetObj - 1; i++)
						{

							for(int j = 0; j < pocetObj- i - 1; j++)
							{
								

								char * type1,* type2;
								ITEM_ask_rev_type2(Objects[j],&type1);
								ITEM_ask_rev_type2(Objects[j+1],&type2);
								printf ("type1 %s type2 %s \n",type1,type2);
								if((strcmp(type1,"H4_VPRevision")==0 && strcmp(type2,"H4_LAKRevision")==0) ||
								(strcmp(type1,"H4_VYPRevision")==0 && strcmp(type2,"H4_LAKRevision")==0) ||
								(strcmp(type1,"H4_VYPRevision")==0 && strcmp(type2,"H4_VPRevision")==0) ||	
								(strcmp(type1,"H4_VYPRevision")==0 && strcmp(type2,"H4_KOOPRevision")==0) ||	
								(strcmp(type1,"H4_KOOPRevision")==0 && strcmp(type2,"H4_VPRevision")==0) ||	
								(strcmp(type1,"H4_VPRevision")==0 && strcmp(type2,"H4_NPVDRevision")==0) )
								{
								printf ("razení %s <-> %s \n",type2,type1);
								tag_t tmp = Objects[j];

								Objects[j] = Objects[j+1];

								Objects[j+1] = tmp;

								}  

							}  

						}  
						printf("%d konnec razeni \n",__LINE__);
						

						for (int ii=0;ii<pocetObj;ii++)
						{
							/*logical latest=false;
								ITEM_rev_sequence_is_latest(Objects[ii],&latest);
								printf("latest %d \n",latest);
								if (latest)
								{*/
							after_KOOP:;
										char *item_id,
										*rev_id;
										tag_t PDFDataset_old=NULLTAG;
										tag_t PDFDataset_new=NULLTAG;
										tag_t DXFDataset_old=NULLTAG;
										tag_t DXFDataset_new=NULLTAG;

										printf("%\n",__LINE__);
									ITEM_ask_item_of_rev (Objects[ii],&item);
									ITEM_ask_latest_rev	(item,&latestRev);
									ITEM_ask_id2(item, &item_id);
									ITEM_ask_rev_id2(latestRev,&rev_id);
									ECHO(("PART_obj %s / %s \n",item_id,rev_id));
									replace_relation(latestRev, OldRelease_Rev, Targets,"TC_Is_Represented_By");

									ClearAttrPrenos(latestRev);
							

									 PDFDataset_old=GetRelationObj(Objects[ii],"IMAN_specification","PDF");
									 PDFDataset_new=GetRelationObj(Targets,"IMAN_specification","PDF");
									//printf(" nulltag %d %d %d \n",NULLTAG,PDFDataset_old, PDFDataset_new);
									if ((PDFDataset_new!=NULLTAG) && (PDFDataset_old!=NULLTAG))
									{
										replace_relation(latestRev, PDFDataset_old, PDFDataset_new,"IMAN_specification");
									}else printf ("pùvodní neobsahuje pdf \n");

									 DXFDataset_old=GetRelationObj(Objects[ii],"IMAN_specification","DXF");
									 DXFDataset_new=GetRelationObj(Targets,"IMAN_specification","DXF");
								//	printf("DXF nulltag %d \n",NULLTAG);
									if ((DXFDataset_new!=NULLTAG) && (DXFDataset_old !=NULLTAG))
									{
										replace_relation(latestRev, DXFDataset_old, DXFDataset_new,"IMAN_specification");
									}else printf ("puvodni neobsahuje dxf \n");

							
										//where_used_top_level(Objects[ii],latestRev);
								tag_t *bvrs = NULL;
								int n_bvrs=0;
								char
									*name = NULL;
	
								ERROR_CHECK(AOM_lock(latestRev));

								ERROR_CHECK(ITEM_rev_list_bom_view_revs(latestRev, &n_bvrs, &bvrs));
								for (int iii = 0; iii < n_bvrs; iii++)
								{
        
									ERROR_CHECK(AOM_ask_value_string(latestRev, "object_name", &name));
								//	printf("Deleting %s\n", name);
									ERROR_CHECK(ITEM_rev_delete_bvr(latestRev, bvrs[iii]));
									SAFE_MEM_FREE(name);
								}
	
								ERROR_CHECK(AOM_unlock(latestRev));
								AOM_save(latestRev);
								SAFE_MEM_FREE(bvrs);
								printf ("**** seq_no %s qnt %s parent_rev %d level %d \n",seq_no,qnt,Parent_rev,Level);
								tag_t BVR_Part=NULLTAG;
								char* type;
								if(Level>0)
									{
			
								ITEM_ask_rev_type2(latestRev,&type);
							//printf("make view  - Parent_rev %d, Parent %d, PartRev %d, BomWindow %d, BomLine %d, BomWindow_part %d, seq_no %d, qnt %d \n",Parent_rev,Parent, PartRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt); 
								printf("<< %d type %s\n",__LINE__,type);
								if (strcmp(type,"H4_KOOPRevision")==0)
									{
										
										char* Koop_seq_no;
										int max_seq=GetMaxSeqNum (design_bomline);
										
										sprintf(Koop_seq_no,"%d",max_seq+10);
									
										Make_View (Parent_rev, Parent, latestRev , design_view, design_bomline, &BVR_Part ,Koop_seq_no,"1");
										sprintf(Koop_seq_no,"%d",max_seq+20);
										Make_View (Parent_rev, Parent, latestRev , design_view, design_bomline, &BVR_Part ,Koop_seq_no,"0");
										printf("%d ii =%d pocet obj=%d \n",__LINE__,ii,pocetObj);
										if (ii+1<pocetObj)
										{
											ii++;
											
											goto after_KOOP;
										}
										else goto konec_KOOP;
									}
								else if(strcmp(type,"H4_VYPRevision")==0)
									Make_View (Parent_rev, Parent, latestRev , design_view, design_bomline, BomWindow_part, "10","1");
								else if (strcmp(type,"H4_LAKRevision")==0)
									{
									 Make_View (Parent_rev, Parent, latestRev , design_view, design_bomline, BomWindow_part, seq_no,qnt);
									char* povrch1;
									char kod_povrch[6];

									 ERROR_CHECK(AOM_ask_value_string(Targets,"h4_povrchova_uprava1",&povrch1));
									strcpy(kod_povrch,"*-");
									strncat(kod_povrch,povrch1,3);
									printf("kod povrch %s \n",kod_povrch);
									tag_t PovrchItem=FindItemPovrch(kod_povrch);
									tag_t PovrchRev=NULLTAG;

									if(PovrchItem>1)
										{
											printf("line  %d povrchItem %d \n",__LINE__,PovrchItem);
											ITEM_ask_latest_rev(PovrchItem,&PovrchRev);
											Make_View (latestRev,item, PovrchRev,design_view,design_bomline,BomWindow_part ,"20","1");
											seq_no="10";
										}

												SAFE_MEM_FREE(povrch1);
									}
									
									else
									{
										Make_View (Parent_rev, Parent, latestRev , design_view, design_bomline, &BVR_Part, seq_no,qnt);
										char* kp_dilec,
											* kp_vykres_norma;
										AOM_ask_value_string(Targets,"h4_dilec",&kp_dilec);
										//AOM_ask_value_string(Targets,"h4_vykres_norma",&kp_vykres_norma);
										if (strcmp( kp_dilec,"ANO bez DM")==0 )
											{
					
												char* tmp_polotovar,
													* token,
													quant_find[16]=" ";
												tag_t Item_find,
														latest_Rev_find=NULLTAG;
					
												AOM_ask_value_string(Targets,"h4_polotovar",&tmp_polotovar);
												token=strtok(tmp_polotovar," ");
												printf("Token %s \n",token);
												
												if(token != NULL)//token[0]=='V'
												{
						
													IFERR_REPORT(ITEM_find_item(token,&Item_find));
						
													printf("Item_find %d \n",Item_find);
													if(Item_find!=NULLTAG)
													{
														IFERR_REPORT(ITEM_ask_latest_rev(Item_find,&latest_Rev_find));
														double tmp_double;
														AOM_get_value_double(Targets,"h4_vyska",&tmp_double);
														//tmp_double=tmp_double+0.5;
						
														char* find_type;
														ITEM_ask_type2(Item_find,&find_type);
														if (strcmp (find_type,"H4_NP")==0)
														{
															double round_d= tmp_double+0.0099;
															double qnt_old=atof(qnt);
															round_d=(round_d*qnt_old)/1000;
															sprintf(quant_find,"%.2f",round_d);			
								
														}
														else {

																			double round_d= ((tmp_double/1000)+0.0009);
																		sprintf(quant_find,"%.3f",round_d);			
								
															}
													
														Make_View (latestRev,item, latest_Rev_find,design_view,design_bomline,BomWindow_part,seq_no,quant_find);
														//goto nextLine;
													}
												}
					
											}
										DruhMaterilu(Targets,latestRev, 0,FALSE);		
										returnRev=latestRev;
										*BomWindow_part=BVR_Part;
									}
								
			
								
								}else
									{
										ITEM_ask_rev_type2(latestRev,&type);
										printf("<< %d type %s\n",__LINE__,type);
										returnRev=latestRev;
									if (strcmp(type,"H4_LAKRevision")==0)
									{
										char* povrch1;
										char kod_povrch[6];
										ERROR_CHECK(AOM_ask_value_string(Targets,"h4_povrchova_uprava1",&povrch1));
									strcpy(kod_povrch,"*-");
									strncat(kod_povrch,povrch1,3);
									printf("kod povrch %s \n",kod_povrch);
									tag_t PovrchItem=FindItemPovrch(kod_povrch);
									tag_t PovrchRev=NULLTAG;

									if(PovrchItem>1)
										{
											printf("line  %d povrchItem %d \n",__LINE__,PovrchItem);
											ITEM_ask_latest_rev(PovrchItem,&PovrchRev);
											Make_View (latestRev,item, PovrchRev,design_view,design_bomline,BomWindow_part ,"20","1");
											seq_no="10";
										}

												SAFE_MEM_FREE(povrch1);
									}
								}
			
	
						Parent_rev=latestRev;
						Parent=item;
		
			Level++;


									tag_t *Objects_replace;		
									
									int primaryObj=GetObjInRelation_secondary(latestRev, "TC_Primary_Design_Representation",  &Objects_replace );
									printf(">>> primary %d \n",primaryObj);
							
									tag_t tmp_obj=Objects[ii];
									printf(" line %d \n",__LINE__);
							
							
									if(primaryObj ==1 )
									{
									printf ("objects[0] %d = %d Objects[ii] \n",Objects_replace[0],tmp_obj);
							
									 ERROR_CHECK(ITEM_ask_item_of_rev (Objects_replace[0],&item));
							
									 ERROR_CHECK(ITEM_ask_id2(item, &item_id));
									 ERROR_CHECK(ITEM_ask_rev_id2(Objects_replace[0],&rev_id));
									printf("%d obj %s / %s \n",ii,item_id,rev_id);
										//ITEM_ask_item_of_rev (Objects[0],&item);
										//ITEM_ask_latest_rev	(item,&latestRev);
										replace_relation(latestRev, Objects_replace[0], Targets,"TC_Primary_Design_Representation");
										printf("replace end \n");
									}
									if (strcmp(type,"H4_NPVDRevision")==0)
									{
										CopyAttrNPVD(Targets, latestRev);
									}
									else
										CopyAttr(Targets, latestRev);
									konec_KOOP:;
							//}
									printf("konec ciklu %d \n",ii);
						}
		//SAFE_MEM_FREE(Objects);
		//if (Objects)MEM_free(Objects);
		printf ("::::: returnRev %d \n",returnRev);
		return returnRev;
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
		double vyska;
		char* material_se,
			vyska_text[20],
			vyp_name[200]="V";
		IFERR_REPORT(AOM_ask_value_double(DesignRev,"h4_vyska",&vyska));
		IFERR_REPORT(AOM_ask_value_string(DesignRev,"h4_material_se",&material_se));
		vyska=Zaokrouhli(vyska,2);
		if(vyska>0)
		{
			sprintf(vyska_text,"%.2f",vyska);
			strcat(vyp_name,vyska_text);
		}
		else
			{
				strcat(vyp_name,"-");
		}
		
		strcat(vyp_name,";");

		if(strlen(material_se)!=0)
			strcat(vyp_name,material_se);
		else
			strcat(vyp_name,"-");
		strcat(vyp_name,";");
		strcat(vyp_name,jmeno);
		printf(">>> Crete DM  \n vykres_norma =%s \n Assembly=%d \n dilec=%s \n",vykres_norma,Assembly,dilec);
		tag_t VypRev;
		tag_t Vyp=create_item("H4_VYPRevision","H4_VYP", vyp_name,"0");
		AOM_save(Vyp);
		ITEM_ask_latest_rev(Vyp,&VypRev);
		AOM_save(VypRev);
		DruhMaterilu(DesignRev,VypRev,0,FALSE);
		printf("line %d \n",__LINE__);
		Make_View (PartRev,PartItem, VypRev,design_view,design_bomline,part_view ,seq_no,"1");
		//IntoFolder("Part_auto",Vyp);
		MoveTPToFolder(folder4part,Vyp);
		create_relation("TC_Is_Represented_By",VypRev,DesignRev);
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
	char* material;
	char* s_zbozi_nak;
	//int Assembly=IsAssembly(DesignRev, "IMAN_specification",NULLTAG);// kdyz je hodnoty 1 tak je sestavou 
	AOM_ask_value_string(DesignRev,"h4_skupina_zbozi_nakupovana",&s_zbozi_nak);
	AOM_ask_value_string(DesignRev,"h4_vykres_norma",&vykres_norma);
	AOM_ask_value_string(DesignRev,"h4_material",&material);

	ITEM_ask_item_of_rev(PartRev,&PartItem);
	//printf("____________\n>>> Crete NPVD  \n vykres_norma =%s \n skupina=%c \n dilec=%s \n________\n",vykres_norma,s_zbozi_nak[0],dilec);

	if( strcmp(vykres_norma,"0")!=0 
		&& ( s_zbozi_nak[0]=='W' || strncmp(s_zbozi_nak,"990",3)==0 || strncmp(s_zbozi_nak,"990",3)==0 ) 
		&& (strcmp(material,"ANO")==0 || strcmp(material,"ANO bez DM")==0))
	{
		printf(">>> Crete NPVD  \n vykres_norma =%s \n skupina=%s \n material=%s \n",vykres_norma,s_zbozi_nak, material);
		tag_t NPVDRev;
		tag_t NPVD=create_item("H4_NPVDRevision","H4_NPVD", jmeno,"0");
		AOM_save(NPVD);
		ITEM_ask_latest_rev(NPVD,&NPVDRev);
		AOM_save(NPVDRev);
		DruhMaterilu(DesignRev,NPVDRev,0,FALSE);
		printf("line %d \n",__LINE__);
		Make_View (PartRev,PartItem, NPVDRev,design_view,design_bomline,part_view ,seq_no,qnt);
		//IntoFolder("Part_auto",NPVD);
		MoveTPToFolder(folder4part,NPVD);
		return NPVD;
	}
	return NULLTAG;
}

tag_t CreateLAK (tag_t DesignRev,tag_t PartRev, char* jmeno, tag_t design_view, tag_t design_bomline, tag_t *part_view,char *seq_no, char* qnt )
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
		&& (strncmp(povrch1,"000",3)!=0)
		&& ((povrch1[0]=='0' || povrch1[0]=='1'|| povrch1[0]=='2' || povrch1[0]=='3' || povrch1[0]=='4' || povrch1[0]=='5' || povrch1[0]=='6' || povrch1[0]=='7' || povrch1[0]=='8' || povrch1[0]=='9' )
		/*&& (povrch1[1]=='0' || povrch1[1]=='1'|| povrch1[1]=='2' || povrch1[1]=='3' || povrch1[1]=='4' || povrch1[1]=='5' || povrch1[1]=='6' || povrch1[1]=='7' || povrch1[1]=='8' || povrch1[1]=='9')&&
		( povrch1[2]=='1'|| povrch1[2]=='2' || povrch1[2]=='3' ||  povrch1[2]=='4' || povrch1[2]=='5' || povrch1[2]=='6' || povrch1[2]=='7' || povrch1[2]=='8' || povrch1[2]=='9')*/))
	{
		char kod_povrch[6];
		strcpy(kod_povrch,"*-");
		strncat(kod_povrch,povrch1,3);
		printf("kod povrch %s \n",kod_povrch);
		tag_t PovrchItem=FindItemPovrch(kod_povrch);
		tag_t PovrchRev;
		
		printf("item_povrch %d rev_povrch %d  \n",PovrchItem,PovrchRev);
		
		char* PovrchObjName,
			povrch_name[255]="L";
		if(PovrchItem>1)
		{
			ITEM_ask_latest_rev(PovrchItem,&PovrchRev);
			IFERR_REPORT(AOM_ask_value_string(PovrchRev,"object_name",&PovrchObjName));
			strncat(povrch_name,&PovrchObjName[5],4);
		}else 
			strcat(povrch_name,"-");

		strcat(povrch_name,";");

		strcat(povrch_name,jmeno);

		printf(">>> Crete LAK  \n vykres_norma =%s \n povrch1=%s \n dilec=%s \n povrch_name %s \n",vykres_norma,povrch1,dilec,povrch_name);
		tag_t LakRev;
		//tag_t Lak_view;
		tag_t Lak=create_item("H4_LAKRevision","H4_LAK", povrch_name,"0");
		AOM_save(Lak);
		ITEM_ask_latest_rev(Lak,&LakRev);
		AOM_save(LakRev);
		DruhMaterilu(DesignRev,LakRev,0,FALSE);
		printf("line %d \n",__LINE__);
		if(PartRev!=NULLTAG)
			Make_View (PartRev,PartItem, LakRev,design_view,design_bomline,part_view ,seq_no,qnt);
		else printf ("PartRev= NULLTAG \n"); 
		
		if(PovrchItem>1)
		{
			printf("line  %d povrchItem %d \n",__LINE__,PovrchItem);
		/*	int tmp_seq_no=0;
			if(strlen(seq_no)==0)
				tmp_seq_no=0;
			else
			tmp_seq_no=	atoi(seq_no);
			
			tmp_seq_no=tmp_seq_no+10;
			printf (" tmp_seq %d line %d \n", tmp_seq_no,__LINE__);
			sprintf(seq_no,"%d",tmp_seq_no);*/

			Make_View (LakRev,Lak, PovrchRev,design_view,design_bomline,part_view ,"20","1");
		}
		//IntoFolder("Part_auto",Lak);
		MoveTPToFolder(folder4part,Lak);
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
	char* id_parent_part;
	char id_kooperace[10]="K";
	char tmp[10]=" ";
	//int Assembly=IsAssembly(DesignRev, "IMAN_specification",NULLTAG);// kdyz je hodnoty 1 tak je sestavou 
	AOM_ask_value_string(DesignRev,"h4_vykres_norma",&vykres_norma);
	AOM_ask_value_string(DesignRev,"h4_dilec",&dilec);
	AOM_ask_value_string(DesignRev,"h4_povrchova_uprava1",&povrch1);
	AOM_ask_value_string(PartRev,"item_id",&id_parent_part);
	strncpy(tmp,&id_parent_part[1],8);
	printf("tmp %s \n",tmp);
	strcpy(id_kooperace,"K");
	strcat(id_kooperace,tmp);
	strcat(id_kooperace,"\0");
	printf("id_kooperace %s \n",id_kooperace);
	
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
		printf("CREATE KOOP____________\n>>> Crete KOOP  \n vykres_norma =%s \n povrch1=%c \n dilec=%s \n id_koop %s ________\n",vykres_norma,povrch1[0],dilec,id_kooperace);
		tag_t KoopRev;
		tag_t Koop=create_item("H4_KOOPRevision","H4_KOOP", povrch1,id_kooperace);
		AOM_save(Koop);
		ITEM_ask_latest_rev(Koop,&KoopRev);
		AOM_save(KoopRev);
		DruhMaterilu(DesignRev,KoopRev,0,FALSE);
		printf("line %d \n",__LINE__);
		printf("max_seq_no %d \n",max_seq+10);
		sprintf(seq_no,"%d",max_seq+10);
		//seq_no="20";
		printf("line %d \n",__LINE__);
		Make_View (PartRev,PartItem, KoopRev,design_view,design_bomline,part_view ,seq_no,"1");
		sprintf(seq_no,"%d",max_seq+20);
		Make_View (PartRev,PartItem, KoopRev,design_view,design_bomline,part_view ,seq_no,"0");
		create_relation("TC_Is_Represented_By",KoopRev,DesignRev);
		//IntoFolder("Part_auto",Koop);
		MoveTPToFolder(folder4part,Koop);
		return KoopRev;
	}
	return NULLTAG;
}


void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,tag_t Parent, tag_t Parent_rev, tag_t *Topline_PartRev,tag_t *BomWindow_part,int parent_vykres_norma_null)
{//Make_View (Parent_rev,Parent, rel_obj_rev_VP,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
	
    // Revize
    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

  
	tag_t Item = NULLTAG;
	
		
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
	AOM_ask_value_string(Rev,"object_name",&obj_name);
	ECHO(("obj_name %s \n",obj_name));
	  tag_t rel_obj_rev_NP,
	  rel_obj_rev_VP;
	  int vazby_NP=  CountInRelation(Rev, "TC_Is_Represented_By",&rel_obj_rev_NP);
	  int vazby_VP=  CountInRelation(Rev, "TC_Primary_Design_Representation",&rel_obj_rev_VP);


	IFERR_REPORT(BOM_line_look_up_attribute("bl_sequence_no", &AttributeId));
	IFERR_REPORT(BOM_line_ask_attribute_string(BomLine, AttributeId,&seq_no));
	IFERR_REPORT(BOM_line_look_up_attribute("bl_quantity", &AttributeId));
	IFERR_REPORT(BOM_line_ask_attribute_string(BomLine, AttributeId,&qnt));
	IFERR_REPORT(BOM_line_look_up_attribute("bl_H4_Dilec_POMRevision_h4_vykres_norma", &AttributeId));
	IFERR_REPORT(BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_vykres_norma));
	IFERR_REPORT(BOM_line_look_up_attribute("bl_H4_Dilec_POMRevision_h4_dilec", &AttributeId));
	IFERR_REPORT(BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_dilec));
	IFERR_REPORT(BOM_line_look_up_attribute("bl_H4_Dilec_POMRevision_h4_material", &AttributeId));
	IFERR_REPORT(BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_material));
	IFERR_REPORT(BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId));
	IFERR_REPORT(BOM_line_ask_attribute_string(BomLine, AttributeId,&kp_assembly_report));
	printf(">>>>quantity %s \n",qnt); 
			if (strlen(qnt)==0)
				strcpy(qnt,"1");

	printf ("__________\n VN %s ; dilec %s ; material %s ; SEAR %s ; parent_VN %d\n",kp_vykres_norma,kp_dilec,kp_material,kp_assembly_report,parent_vykres_norma_null);
		
			
    // Množství
	
	char *Value = NULL;
	
	tag_t Part = NULLTAG;
	tag_t PartRev = NULLTAG;

			  //	int is_released = 0;
			//EPM_ask_if_released(Rev,&is_released);
			//if (is_released == 0)
			//{
				//neschvalene 
						
		//	}

		//printf("%d %s/%s: %s, %s, %s, %s, poznamka: %s\n", Level, Id, RevId, povrch1, povrch2, povrch2, stredisko,poznamka);
		printf("%d %s/%s - %s \n", Level, Id, RevId, obj_name);

		if (vazby_NP==0 ||vazby_VP==0)
				{
					//má relaci relaci
					tag_t OldRelease_Rev=NULLTAG;
					//test pøedchozích revizí a jejich schválení
					if (Previous_rev_test(Rev,&OldRelease_Rev)==1) 
					{ 
						printf (" %d EXISTUJE PREDCHOZI REVIZE CO JE SCHVALENA  Parent rev %d parent %d \n",__LINE__,Parent_rev,Parent);

						PartRev=VKV_rev (OldRelease_Rev,Rev,Parent_rev,Parent,BomWindow,BomLine,BomWindow_part,seq_no,qnt,Level);
						ITEM_ask_item_of_rev(PartRev,&Part);
						if (Level==0) *Topline_PartRev=PartRev;

						printf ("::::BomWindow_part %d Part %d Parent_rev %d \n",BomWindow_part,Part,Parent_rev);
						goto nextLine;
						//goto InTheEnd;
					}printf ("\n NEEXISTUJE PREDCHOZI REVIZE KTERA JE SCHVALENA\n___\n") ;
					//testna pøipojený object a typ objectu
				}
	
	if	((strcmp( kp_dilec,"NE")==0 && strcmp(kp_material,"NE")==0)
		|| strcmp(kp_assembly_report,"0")==0)
	{

		printf(" NE-GENEROVAT VAA ani poddily\n");
		/* obsahuje tmp;
		   strcpy(tmp.id_polozky,Id);
		   strcpy(tmp.rev_polozka,RevId);
		   strcpy(tmp.seq_no,seq_no);
		   tmp.parentRev=Parent_rev;
		   seznam[poradi++]=tmp;*/
		
			goto InTheEnd;
			
	}else if (strcmp(kp_vykres_norma,"0")==0 )
	{
		printf("\n!!!!!!!!!\n NE-GENEROVAT pouze toto VAA\n");
		Part=Parent;
		PartRev=Parent_rev;
		parent_vykres_norma_null=1;
		if (strcmp( kp_dilec,"ANO bez DM")==0)
				{
					
					char* tmp_polotovar,
						* token,
						quant_find[16]=" ";
					tag_t Item_find,
							latest_Rev_find=NULLTAG;
					
					AOM_ask_value_string(Rev,"h4_polotovar",&tmp_polotovar);
					token=strtok(tmp_polotovar," ");
					printf("Token %s \n",token);
					if(token != NULL)//token[0]=='V'
					{
						
						IFERR_REPORT(ITEM_find_item(token,&Item_find));
						
						printf("Item_find %d \n",Item_find);
						if(Item_find!=NULLTAG)
						{
							IFERR_REPORT(ITEM_ask_latest_rev(Item_find,&latest_Rev_find));
							double tmp_double;
							AOM_get_value_double(Rev,"h4_vyska",&tmp_double);
							//tmp_double=tmp_double+0.5;
						
							char* find_type;
							ITEM_ask_type2(Item_find,&find_type);
							if (strcmp (find_type,"H4_NP")==0)
							{
								double round_d= tmp_double+0.0099;
								double qnt_old=atof(qnt);
								round_d=(round_d*qnt_old)/1000;
								sprintf(quant_find,"%.2f",round_d);			
								
							}
							else {

									 double round_d= ((tmp_double/1000)+0.0009);
									 sprintf(quant_find,"%.3f",round_d);			
								
								}
													
							Make_View (Parent_rev,Parent, latest_Rev_find,BomWindow,BomLine,BomWindow_part,seq_no,quant_find);
							goto nextLine;
						}
					}
					
				}
		goto nextLine;
	} 
		
		
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
		  int nalez=Equels_obsah(tmp,poradi,seznam,&use_seq_no,parent_vykres_norma_null);

			  parent_vykres_norma_null=0;
		 //  it=std::find(seznam.begin(),seznam.end(),tmp);
		 //  printf("******nalez = %d \n",nalez);
		/*if( it!=seznam.end())*/
			  printf("pro rozohodovani nalez - %d ; vazby_VP - %d ; vazby_NP - %d ; material - %s \n",nalez,vazby_VP,vazby_NP,material);
	   if(nalez==0)
			  {
				  printf("0 -exituje nic nedelej \n");
				  if(Level==0)
				  {
					  *Topline_PartRev=NULLTAG;
				  }

				  goto InTheEnd;
			  }	
	   else if( nalez==-2)// pro položku která již jednou byla použita v kusovníku se stejným rodièem ale jiným Find.no
		{
			if (vazby_VP==1)
			{
				printf("1- use_find_no NP %s \n",use_seq_no);
					if(Level>0)
					{	
						printf("501 obj v relaci %d\n",rel_obj_rev_VP);
						PartRev=rel_obj_rev_VP;
						ITEM_ask_item_of_rev(PartRev,&Part);
						GetName_rev(rel_obj_rev_VP);
						ITEM_ask_item_of_rev(PartRev,&Part);
						Make_View (Parent_rev,Parent, rel_obj_rev_VP,BomWindow,BomLine,BomWindow_part,use_seq_no,qnt);	
						//seznam[poradi++]=tmp;
					}
			else 
					{
						*Topline_PartRev=PartRev;
					}

			}
			else if(vazby_NP==1)
			{
			printf("1- use_find_no NP %s \n",use_seq_no);
			if(Level>0)
					{	
						printf("501 obj v relaci %d\n",rel_obj_rev_NP);
						PartRev=rel_obj_rev_NP;
						ITEM_ask_item_of_rev(PartRev,&Part);
						GetName_rev(rel_obj_rev_NP);
						ITEM_ask_item_of_rev(PartRev,&Part);
						Make_View (Parent_rev,Parent, rel_obj_rev_NP,BomWindow,BomLine,BomWindow_part,use_seq_no,qnt);	
						//seznam[poradi++]=tmp;
					}
			else 
					{
						*Topline_PartRev=PartRev;
					}
			}
			goto InTheEnd;
			
		}
		else if( nalez>0 && strcmp(material,"ANO")!=0 )// pro položku která již jednou byla použita v kusovniku 
		{

			if (vazby_VP==1)
			{
				if(Level>0)
				{
					printf("2 nalez %s/%s Revtag %d\n",seznam[nalez].id_polozky,seznam[nalez].rev_polozka,seznam[nalez].Rev);
					PartRev=seznam[nalez].Rev;
					ITEM_ask_item_of_rev(PartRev,&Part);
					printf(" Parent_rev %d Parent %d BomWindow %d BomLine %d BomWindow_part %d seq_no %d \n",Parent_rev,Parent,BomWindow,BomLine,BomWindow_part,seq_no);
					Make_View (Parent_rev,Parent, rel_obj_rev_VP,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
					seznam[poradi++]=tmp;
					}
			}

			else if(vazby_NP==1)
			{
			if(Level>0)
				{
					printf("2 nalez %s/%s Revtag %d\n",seznam[nalez].id_polozky,seznam[nalez].rev_polozka,seznam[nalez].Rev);
					PartRev=seznam[nalez].Rev;
					ITEM_ask_item_of_rev(PartRev,&Part);
					printf(" Parent_rev %d Parent %d BomWindow %d BomLine %d BomWindow_part %d seq_no %d \n",Parent_rev,Parent,BomWindow,BomLine,BomWindow_part,seq_no);
					Make_View (Parent_rev,Parent, rel_obj_rev_NP,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
					seznam[poradi++]=tmp;
					}
		}
			goto InTheEnd;
		} 
	   
		else if(strcmp(material,"ANO")==0 && vazby_NP==1) // pro konstrukèní rev nakupované položky
		{
			

			printf("3--pocet rel obj %d \n",vazby_NP);
		
				if(Level>0)
					{	
						printf("obj v relaci \n");
						GetName_rev(rel_obj_rev_NP);
						PartRev=rel_obj_rev_NP;
						ITEM_ask_item_of_rev(PartRev,&Part);
						Make_View (Parent_rev,Parent, rel_obj_rev_NP,BomWindow,BomLine,BomWindow_part,seq_no,qnt);	
						seznam[poradi++]=tmp;
					}
				else 
					{
						*Topline_PartRev=PartRev;
					}
				goto InTheEnd;
			
		}
		else if((strcmp(material,"ANO")==0 || strcmp(material,"ANO bez DM")==0) && vazby_NP!=1) // pro konstrukèní rev nakupované položky
		{

			/*	char *vykres_norma;
			tag_t NP;
			printf("4 chyba MATERIAL nemá relaci \n");
			AOM_ask_value_string(Rev,"h4_vykres_norma",&vykres_norma);
			tag_t NPRev=FindRev_NP(vykres_norma);
			if (NPRev!=NULLTAG && Level>0)
				{
					ITEM_ask_item_of_rev(NPRev,&NP);
					Make_View (Parent_rev,Parent,NPRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
						seznam[poradi++]=tmp;
			}else*/ printf("4 chyba MATERIAL nemá relaci \n");
		tag_t NPVD= CreateNVPD (Rev, Parent_rev, obj_name, BomWindow,BomLine,BomWindow_part,seq_no, qnt);
			if(NPVD!=NULLTAG)
			{
				ITEM_ask_latest_rev(NPVD,&PartRev);
				//*Topline_PartRev=PartRev;
				//Vytvoø relace
					create_relation("TC_Is_Represented_By",PartRev,Rev);
					create_relation("TC_Primary_Design_Representation",PartRev,Rev);

					tmp.Rev= PartRev;
					seznam[poradi++]=tmp;
					goto InTheEnd;
			}
			else
				goto InTheEnd;
		}
			else if(vazby_VP==1)// pro konstruèní revizi vyrábìné položky pro kterou už existuje relace s vyrabenou  
		{
			
				printf("5 exituje relace VP \n");
				if(Level>0)
						{	
							printf("obj v relaci \n");
							GetName_rev(rel_obj_rev_VP);
							PartRev=rel_obj_rev_VP;
							ITEM_ask_item_of_rev(PartRev,&Part);
							Make_View (Parent_rev,Parent, rel_obj_rev_VP,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
							seznam[poradi++]=tmp;
						}
				else 
						{
							*Topline_PartRev=PartRev;
						}
			
					
			goto InTheEnd;
		}
		else if(vazby_NP==1)// pro konstruèní revizi vyrábìné položky pro kterou už existuje relace s vyrabenou  
		{
			
				printf("5 exituje relace NP \n");
				if(Level>0)
						{	
							printf("obj v relaci \n");
							GetName_rev(rel_obj_rev_NP);
							PartRev=rel_obj_rev_NP;
							ITEM_ask_item_of_rev(PartRev,&Part);
							Make_View (Parent_rev,Parent, rel_obj_rev_NP,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
							seznam[poradi++]=tmp;
						}
				else 
						{
							*Topline_PartRev=PartRev;
						}
			
					
			goto InTheEnd;
		}
		else // po konstrukèni ktera nemá zadny part v relaci 
		{
			bool previousLak=FALSE;
			tag_t Lak_rev=CreateLAK (Rev,Parent_rev, obj_name,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
			printf ("Line %d \n",__LINE__);
			if(Lak_rev!=NULLTAG)
			{
				
				create_relation("TC_Is_Represented_By",Lak_rev,Rev);
				create_relation("TC_Primary_Design_Representation",Lak_rev,Rev);
				Parent_rev=Lak_rev;
				tmp.Rev= PartRev;
				seznam[poradi++]=tmp;
				qnt="1";
				previousLak=TRUE;
				if(Level ==0)
				{
					*Topline_PartRev=PartRev;
				}
			}
			
				printf("6 Create Part \n");
				Part=create_item("H4_VPRevision","H4_VP", obj_name,"0");
				
					AOM_save(Part);
					ITEM_ask_latest_rev(Part,&PartRev);
					AOM_save(PartRev);
					
					char* PartId,
							* PartRevId;
					ITEM_ask_id2(Part,&PartId);
					ITEM_ask_rev_id2(PartRev,&PartRevId);
					printf("tag Part rev %d %s/ %s \n",PartRev,PartId,PartRevId);
					//seznam=Pridej(BomLine,Rev);

					//Vytvoø relace
					create_relation("TC_Is_Represented_By",PartRev,Rev);
					
					//printf(" pocet relaci coll %d \n",Add2RepresentationFor(Rev, "Collection", PartRev));
					//SetTag(Rev,PartRev,"representation_for");
					//create_relation("representation_for",Rev,PartRev);		
							
					//printf("poradi %d tem part tag \n",poradi );
					//AddToTarget(RootTask,Value,TP);
					tmp.Rev= PartRev;		
							
					seznam[poradi++]=tmp;
					if(Lak_rev!=NULLTAG)
					{					
						//printf("parent rev %d \n BonView:part %d \n",Parent_rev,BomWindow_part);
						//create_relation("TC_Primary_Design_Representation",Lak_rev,Rev);
						Parent_rev=Lak_rev;
						ITEM_ask_item_of_rev(Parent_rev,&Parent);
						
						printf("____________\n Set druh mat %d \n ----------------\n", Parent_rev);
						DruhMaterilu(Rev,PartRev,0,TRUE);
						printf("line %d \n",__LINE__);
						if(Level==0)
							*Topline_PartRev=Lak_rev;

						Level++;
						
					}
					else {
						create_relation("TC_Primary_Design_Representation",PartRev,Rev);
						DruhMaterilu(Rev,PartRev,0,FALSE);
					}
					CreateKOOP (Rev,PartRev, obj_name,BomWindow,BomLine,BomWindow_part);
					if(Level>0)
					{
					printf("make view  - Parent_rev %d, Parent %d, PartRev %d, BomWindow %d, BomLine %d, BomWindow_part %d, seq_no %d, qnt %d \n",Parent_rev,Parent, PartRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt); 			
						Make_View (Parent_rev,Parent, PartRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);								
						CreateDM (Rev,PartRev, obj_name,BomWindow,BomLine,BomWindow_part,seq_no );		
					}
					else 
					{

						if(Lak_rev!=NULLTAG)
							*Topline_PartRev=Lak_rev;
						else
							*Topline_PartRev=PartRev;
					}
			
					printf(" \n \n VKLADAM \n \n");
					//IntoFolder("Part_auto",Part);
					MoveTPToFolder(folder4part,Part);
					///////////////////////////uprava 16.10
							
				if (strcmp( kp_dilec,"ANO bez DM")==0)
				{
					
					char* tmp_polotovar,
						* token,
						quant_find[16]=" ";
					tag_t Item_find,
							latest_Rev_find=NULLTAG;
					
					AOM_ask_value_string(Rev,"h4_polotovar",&tmp_polotovar);
					token=strtok(tmp_polotovar," ");
					printf("Token %s \n",token);
					if(token != NULL)//token[0]=='V'
					{
						
						IFERR_REPORT(ITEM_find_item(token,&Item_find));
						
						printf("Item_find %d \n",Item_find);
						if(Item_find!=NULLTAG)
						{
							IFERR_REPORT(ITEM_ask_latest_rev(Item_find,&latest_Rev_find));
							double tmp_double;
							AOM_get_value_double(Rev,"h4_vyska",&tmp_double);
							//tmp_double=tmp_double+0.5;
							char* find_type;
							ITEM_ask_type2(Item_find,&find_type);
							if (strcmp (find_type,"H4_NP")==0)
							{
								double round_d= tmp_double+0.0099;
								sprintf(quant_find,"%.2f",round_d);			
								
							}
							else {

								 double round_d= ((tmp_double/1000)+0.0009);
								sprintf(quant_find,"%.3f",round_d);			
								
							}
							Make_View (PartRev,Part, latest_Rev_find,BomWindow,BomLine,BomWindow_part,seq_no,quant_find);
							goto nextLine;
						}
					}
					
				}///konec uprava 16.10
		}
	
nextLine:;
		printf("partRev %d Part %d \n",PartRev,Part);
    // Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
	printf("\n____\n");
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow,Part,PartRev,Topline_PartRev, BomWindow_part,parent_vykres_norma_null);
								//void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,tag_t Parent, tag_t Parent_rev, tag_t *Topline_PartRev,tag_t *BomWindow_part,int parent_vykres_norma_null)
	if(Childs) MEM_free(Childs);
	InTheEnd:;
	 printf(" ...konec-rekurze..\n \n");
		//MEM_free(povrch1);		
		//MEM_free(stredisko);		
		//MEM_free(varianta);
		//MEM_free(Value);
   
	//AddToTarget(RootTask,"V",TP);
}
void CreateVKV_one(tag_t Rev, tag_t *Topline_PartRev,tag_t *BomWindow_part)
{
	int Level=0;
	char* vykres_norma,
		* kp_dilec,
		* kp_material,
		* obj_name,
		* seq_no="10",
		* qnt="1";
	tag_t BomLine=NULLTAG,
		
		Parent_rev=NULLTAG,
		Parent=NULLTAG,
		BomWindow=NULLTAG,
		PartRev=NULLTAG,
		Part=NULLTAG;

	IFERR_REPORT(AOM_ask_value_string(Rev,"h4_vykres_norma", &vykres_norma));
	IFERR_REPORT(AOM_ask_value_string(Rev,"h4_dilec", &kp_dilec));
	IFERR_REPORT(AOM_ask_value_string(Rev,"h4_material", &kp_material));
	IFERR_REPORT(AOM_ask_value_string(Rev,"object_name",&obj_name));

	 if	(strcmp( kp_dilec,"NE")==0 && strcmp(kp_material,"NE")==0)
		 goto end_CreateVKV_one;

	 tag_t rel_obj_rev_NP,
		   rel_obj_rev_VP;
			  int vazby_NP=  CountInRelation(Rev, "TC_Is_Represented_By",&rel_obj_rev_NP);
			  int vazby_VP=  CountInRelation(Rev, "TC_Primary_Design_Representation",&rel_obj_rev_VP);


			  	if (vazby_NP==0 ||vazby_VP==0)
				{
					//má relaci relaci
					tag_t OldRelease_Rev=NULLTAG;
					//test pøedchozích revizí a jejich schválení
					if (Previous_rev_test(Rev,&OldRelease_Rev)==1) 
					{ 
						printf (" %d EXISTUJE PREDCHOZI REVIZE CO JE SCHVALENA  Parent rev %d parent %d \n",__LINE__,Parent_rev,Parent);

						PartRev=VKV_rev (OldRelease_Rev,Rev,Parent_rev,Parent,BomWindow,BomLine,BomWindow_part,seq_no,qnt,Level);
						ITEM_ask_item_of_rev(PartRev,&Part);
						if (Level==0) *Topline_PartRev=PartRev;

						printf ("::::BomWindow_part %d Part %d Parent_rev %d \n",BomWindow_part,Part,Parent_rev);
						goto end_CreateVKV_one;
						//goto InTheEnd;
					}printf ("\n NEEXISTUJE PREDCHOZI REVIZE KTERA JE SCHVALENA\n___\n") ;
					//testna pøipojený object a typ objectu
				}			


		if (vazby_VP==1)
		{
			
		}
		else if(vazby_NP>0)
		{

		}
		else // po konstrukèni ktera nemá zadny part v relaci 
		{
			
			tag_t Lak_rev=CreateLAK (Rev,Parent_rev, obj_name,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
			printf ("Line %d \n",__LINE__);
			if(Lak_rev!=NULLTAG)
			{
				
				create_relation("TC_Is_Represented_By",Lak_rev,Rev);
				create_relation("TC_Primary_Design_Representation",Lak_rev,Rev);
				Parent_rev=Lak_rev;
				
				
				qnt="1";
				if(Level ==0)
				{
					*Topline_PartRev=PartRev;
				}
			}
			
				printf("6 Create Part \n");
				Part=create_item("H4_VPRevision","H4_VP", obj_name,"0");
				
					AOM_save(Part);
					ITEM_ask_latest_rev(Part,&PartRev);
					AOM_save(PartRev);
					
					char* PartId,
							* PartRevId;
					ITEM_ask_id2(Part,&PartId);
					ITEM_ask_rev_id2(PartRev,&PartRevId);
					printf("tag Part rev %d %s/ %s \n",PartRev,PartId,PartRevId);
					//seznam=Pridej(BomLine,Rev);

					//Vytvoø relace
					create_relation("TC_Is_Represented_By",PartRev,Rev);
					
					//printf(" pocet relaci coll %d \n",Add2RepresentationFor(Rev, "Collection", PartRev));
					//SetTag(Rev,PartRev,"representation_for");
					//create_relation("representation_for",Rev,PartRev);		
							
					//printf("poradi %d tem part tag \n",poradi );
					//AddToTarget(RootTask,Value,TP);
					
					if(Lak_rev!=NULLTAG)
					{					
						//printf("parent rev %d \n BonView:part %d \n",Parent_rev,BomWindow_part);
						//create_relation("TC_Primary_Design_Representation",Lak_rev,Rev);
						Parent_rev=Lak_rev;
						ITEM_ask_item_of_rev(Parent_rev,&Parent);
						
						printf("____________\n Set druh mat %d \n ----------------\n", Parent_rev);
						DruhMaterilu(Rev,PartRev,0,TRUE);
						if(Level==0)
							*Topline_PartRev=Lak_rev;

						Level++;
						
					}
					else {
						create_relation("TC_Primary_Design_Representation",PartRev,Rev);
						DruhMaterilu(Rev,PartRev,0,FALSE);
					}
					CreateKOOP (Rev,PartRev, obj_name,BomWindow,BomLine,BomWindow_part);
					
					if(Level>0)
					{
						printf("make view  - Parent_rev %d, Parent %d, PartRev %d, BomWindow %d, BomLine %d, BomWindow_part %d, seq_no %d, qnt %d \n",Parent_rev,Parent, PartRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt); 			
						Make_View (Parent_rev,Parent, PartRev,BomWindow,BomLine,BomWindow_part,seq_no,qnt);
														
						printf("line %d \n",__LINE__);
								
					}
					else 
					{

						if(Lak_rev!=NULLTAG)
							*Topline_PartRev=Lak_rev;
						else
							*Topline_PartRev=PartRev;
					}
					CreateDM (Rev,PartRev, obj_name,BomWindow,BomLine,BomWindow_part,seq_no );
					printf(" \n \n VKLADAM \n \n");
					//IntoFolder("Part_auto",Part);
					MoveTPToFolder(folder4part,Part);
							
		}

	 end_CreateVKV_one:;
}

int TPV_Create_Part(EPM_action_message_t msg)
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
	strcpy(Divize,"null");

	int ArgumentCount=TC_number_of_arguments(msg.arguments);

	while (ArgumentCount --> 0)
	{
		Argument = TC_next_argument( msg.arguments );
		ITK_ask_argument_named_value( ( const char* ) Argument, &Flag, &Value );
		if( strcmp ( "Divize", Flag ) == 0 && Value != nullptr)
		{
// …
			printf("value property %s \n",Value);
			strcpy(Divize,Value);
		}
	}

EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
printf("TargetsCount %d ",TargetsCount);

//seznam= (obsahuje *)malloc(sizeof(obsahuje) * 1500);
seznam= (obsahuje *)calloc(1500,sizeof(obsahuje));
/*POM_get_user(&user_name, &user_tag);
printf("-----Jmeno %s tag %d-------\n",user_name,user_tag);
SA_find_person2(user_name,&person_tag);
printf("person tag %d \n",person_tag);
SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
printf("organisation %s \n",P_organ);*/
printf ("targets %d \n",TargetsCount);
for( int i = 0; i < TargetsCount; i ++ )
{
POM_class_of_instance(Targets[i], &TargetClassTag);


logical IsRevision = false;
POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);

tag_t BomTopLine_partrev = NULLTAG;
tag_t BomWindow_part = NULLTAG;

if(IsRevision == false) continue;
	char *Type;
	WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
	printf ("%s\n",Type);
	tag_t Item;
	char Id [20],
		RevId[4];
	IFERR_REPORT(ITEM_ask_item_of_rev(Targets[i], &Item));
    IFERR_REPORT(ITEM_ask_id(Item, Id));
    IFERR_REPORT(ITEM_ask_rev_id(Targets[i], RevId));
	strcat(Id,"-");
	strcat(Id,RevId);
	folder4part= CreateFolder(Id);
	 int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
        for(int j = 0; j < BomsCount; j++)
        {

            // BOM window
            tag_t BomWindow = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			
			//nastaveni context bomline absolute occurrence edit mode			
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			ListBomLine(BomTopLine, 0, RootTask,BomWindow,NULLTAG,NULLTAG,&BomTopLine_partrev,&BomWindow_part,0);
			BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
			if(BomTopLine_partrev!=NULLTAG)
				AddToRef(RootTask, 1, BomTopLine_partrev);
        }
		if(BomsCount==0)
		{
			CreateVKV_one(Targets[i], &BomTopLine_partrev,&BomWindow_part);
			if(BomTopLine_partrev!=NULLTAG)
				AddToRef(RootTask, 1, BomTopLine_partrev);

		}
		if(Boms)MEM_free(Boms);
}
printf("--konec--\n");
//if(seznam) MEM_free(seznam);
IntoFolder("Part_auto", folder4part);
free(seznam);
printf ("free %d\n",seznam[0].seq_no);
if(Targets) MEM_free(Targets);
if(rootLine) MEM_free(rootLine);
    return ITK_ok;
}
