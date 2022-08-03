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
#include <locale.h>
#include <tccore\grm.h>
#include <ae\ae.h>
#include <errno.h>
#include <tccore\aom.h>

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Control_Modify_TC12_register_callbacks();
extern "C" DLLAPI int TPV_Control_Modify_TC12_init_module(int *decision, va_list args);
int TPV_Control_Modify(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);


extern "C" DLLAPI int TPV_Control_Modify_TC12_register_callbacks()
{
    printf("Registruji TPV_Control_Modify_TC12.dll\n");
    CUSTOM_register_exit("TPV_Control_Modify_TC12", "USER_init_module", TPV_Control_Modify_TC12_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Control_Modify_TC12_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Control_Modify", "", TPV_Control_Modify);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Control_Modify");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}
void Add_Obj_to_Ref(tag_t RootTask,tag_t Rev, int Count)
{
	//printf("74tak posilam do Targetu Roottask %d Item %d  \n",RootTask,Item);
	const int AttachmentTypes[1] = {EPM_reference_attachment};
	printf("76test \n");
	for(int i =0;i<Count;i++)
	{
		

		printf ("Do referenci \n");
		EPM_add_attachments(RootTask, Count, &Rev, AttachmentTypes);
	}
	//int Count;
}

int CompareDate (date_t obj_last_date, date_t rev_last_date)
{
	printf("obj %d.%d. %d %d:%d:%d\n",obj_last_date.day,obj_last_date.month,obj_last_date.year,obj_last_date.hour,obj_last_date.minute,obj_last_date.second);
	printf("rev %d.%d. %d %d:%d:%d\n", rev_last_date.day, rev_last_date.month, rev_last_date.year, rev_last_date.hour, rev_last_date.minute, rev_last_date.second);
	/*if(obj_last_date.year==rev_last_date.year &&
		  obj_last_date.month== rev_last_date.month &&
		  obj_last_date.day== rev_last_date.day &&
		  obj_last_date.hour ==*/
	int obj_s=0;
	int rev_s=0;
	obj_s=obj_last_date.second+obj_last_date.minute*60+obj_last_date.hour*3600;
	rev_s=rev_last_date.second+rev_last_date.minute*60+rev_last_date.hour*3600;
	printf("obj_s %d - rev_s %d\n",obj_s,rev_s);
	if (obj_last_date.year==rev_last_date.year)
	{
		if(obj_last_date.month==rev_last_date.month)
		{
			if(obj_last_date.day==rev_last_date.day)
			{
				if(obj_s>rev_s) 
					return 1;//je novejší object
				else if (obj_s==rev_s)
					return 0;//stejné datum modifikace

			}else if(obj_last_date.day>rev_last_date.day)
			{
				return 1;
			}

		}else if(obj_last_date.month>rev_last_date.month)
		{
			return 1;
		}
	}else if (obj_last_date.year>rev_last_date.year)
	{
		printf ("novejsi object \n");
		return 1;
	}
	return -1;//novejši rev
}

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
 printf("nic se nedìje \n");
    return 2;      /* soubor mozna existuje, ale nepodarilo se
                           jej otevrit (treba uz je otevreno prilis
                           mnoho souboru nebo nemate prava atp.) */
}


bool CheckdDataset( tag_t rev, char* typ_datasetu,  char* relace, date_t *obj_last_date) {
       int ifail = ITK_ok;

    tag_t relation_type_tag = NULLTAG,
       * specs = NULL,
    type_tag = NULLTAG,
    * refs = NULL;
    
       int n_specs = 0,
           n_refs = 0;
	   char* id_rev,
		   *obj_type;
	   

	    AOM_ask_value_string(rev,"item_revision_id",&id_rev);
		
       ifail = GRM_find_relation_type(relace, &relation_type_tag);
    if (ifail != ITK_ok) { printf("Chyba hledani tagu relace %s \n",relace); }

       ifail = GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs);
    if (ifail != ITK_ok) {printf("Chyba hledani objektu v rev %s relaci %s \n",id_rev, relace); }
    printf("pocet datasetu %d\n",n_specs);

    for ( int ii = 0; ii < n_specs; ii++) {
        ifail = TCTYPE_ask_object_type (specs[ii], &type_tag);
        if (ifail != ITK_ok) { printf("chyba ziskaci tagu pripojeneho objektu \n"); }
        
		 ifail = AOM_ask_value_string(specs[ii],"object_type", &obj_type);
        if (ifail != ITK_ok) { printf("nelze zjisti object type \n");}
		printf ("object type %s \n",obj_type);

		
		
		if(strcmp(typ_datasetu,obj_type)==0) {
			printf("%s typ datasetu %s \n",id_rev,typ_datasetu);
			AOM_ask_value_date	(	specs[ii], "last_mod_date", obj_last_date);	
			printf("return true obj %d.%d. %d %d:%d:%d\n",obj_last_date->day,obj_last_date->month,obj_last_date->year,obj_last_date->hour,obj_last_date->minute,obj_last_date->second);
			return true;
			
		}else printf("neshoduje se %s x %s \n",typ_datasetu,obj_type);
             
       }
	printf("return false obj %d.%d. %d %d:%d:%d\n",obj_last_date->day,obj_last_date->month,obj_last_date->year,obj_last_date->hour,obj_last_date->minute,obj_last_date->second);
	return false;
}

bool ListBomLine(tag_t BomLine, tag_t RootTask, tag_t BomWindow, char* relace,char* typ_datasetu,date_t datset_asm_date_mod)
{
	printf("---ListBomLine-----\n"); 
	int AttributeId;
	tag_t Vrchol;
	BOM_line_look_up_attribute("bl_revision", &AttributeId);
	BOM_line_ask_attribute_tag(BomLine, AttributeId, &Vrchol);

	   //  Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)//prochazeni prvni urovne
	{
		// Hledani revizi v kusovniku		
		tag_t Rev = NULLTAG;
		BOM_line_ask_attribute_tag(Childs[k], AttributeId, &Rev);//hledani revize

		tag_t Item = NULLTAG;	
	
		char *Id,
			*RevId,
			*Type;
		ITEM_ask_item_of_rev(Rev, &Item);
		ITEM_ask_id2(Item, &Id);
		ITEM_ask_rev_id2(Rev, &RevId);
		printf("ID %s/%s \n",Id,RevId);
    
			WSOM_ask_object_type2(Rev,&Type);
			printf("Type %s \n",Type);

			if(strcmp(Type,"TPV4_dilRevision")==0) 
			{			printf ("dilRev \n");
			date_t obj_last_date;
					if(CheckdDataset( Rev, typ_datasetu, relace, &obj_last_date))
					{
						
						int vysledek=	 CompareDate (datset_asm_date_mod, obj_last_date);
						
						if(vysledek==-1)// je novìjší compare dataset než výkres
							{
							
							Add_Obj_to_Ref(RootTask,Rev, 1);
							return true;
							}
					}else printf("false CheckdDataset \n");
					

			} else if(strcmp(Type,"TPV4_nak_dilRevision")==0)
			{				printf ("nak_dil \n");
						
						
			}else printf ("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	
	}
	 MEM_free(Childs);
	printf("Konec \n");
	return ITK_ok;
}
int TPV_Control_Modify(EPM_action_message_t msg)
{

char*Argument = nullptr;
char*Flag = nullptr;
char*Value = nullptr;
int ArgumentCount = TC_number_of_arguments(msg.arguments);
int return_value=ITK_ok;
char Relace[20];
char Typ_itemu[20];
char Typ_datasetu[20];
char Dataset_sestavy[20];
char Dataset_sestavy_rel[20];
char Compare_dataset[3][20];
char Compare_rel[3][20];
bool is_compare_dataset=false;
bool is_compare_rel=false;
bool is_compare_asm=false;
bool is_compare_asm_rel=false;
int n_com=0;


	while(ArgumentCount--> 0 )
{
	Argument = TC_next_argument( msg.arguments );
	ITK_ask_argument_named_value( Argument, &Flag, &Value );
	printf("Value %s Flag %s \n",Value, Flag);
	
 if( strcmp ( "Relace", Flag ) == 0 && Value != nullptr)
	{
	// …
		//printf(" relace %s \n",Value);
		strcpy(Relace,Value);
	}
	else if( strcmp ( "Type_Itemu", Flag ) == 0 && Value != nullptr)
	{
	// …
		//printf(" typ %s \n",Value);
		strcpy(Typ_itemu,Value);
	}
	else if( strcmp ( "Type_Datasetu", Flag ) == 0 && Value != nullptr)
	{
	// …
		printf(" typ %s \n",Value);
		strcpy(Typ_datasetu,Value);
	}else if (strcmp("Compare_dataset", Flag)==0 && Value != nullptr)
	{
		char * token;
		token=strtok(Value,",");
		
		while (token!=NULL)
		{
			n_com++;
			printf("token %s \n",token);
			strcpy(Compare_dataset[n_com],token);
			token =strtok (NULL,",");		
		}
		printf("%d \n",__LINE__);
		//strcpy(Compare_dataset[n_com],token);
		printf("compare dataset %d %s \n",n_com,Compare_dataset[n_com]);
		is_compare_dataset=true;
	}
	else if (strcmp("Compare_rel", Flag)==0 && Value != nullptr)
	{
		int n_rel=0;
		char * token;
		token=strtok(Value,",");
		while (token!=NULL)
		{
			printf("token %s \n",token);
			strcpy(Compare_rel[n_rel],Value);
			token =strtok (NULL,",");
			n_rel++;
		}
		strcpy(Compare_rel[n_rel],Value);
		printf("compare dataset %d %s \n",n_rel,Compare_dataset[n_rel]);
		is_compare_rel=true;
	}
	else if (strcmp("Check_Asm",Flag)==0&& Value != nullptr)
	{
		strcpy(Dataset_sestavy,Value);
		is_compare_asm=true;
	}
		else if (strcmp("Check_Asm_rel",Flag)==0&& Value != nullptr)
	{
		strcpy(Dataset_sestavy_rel,Value);
		is_compare_asm_rel=true;
	}
	
}
		tag_t *revs,
		   item;
       int itemCount,
		   copy_DXF=0;  
	   tag_t RootTask,
		   job;
	   char* job_name;
		   

	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);
	AOM_UIF_ask_value(job,"object_name",&job_name);
	//printf ("RootTask %d \n",RootTask);

	//	FILE *log;
	//char logpath[30];
	//strcpy(logpath,"C:\\Temp\\pdf_make");
	//strcat(logpath,".log");
	//log=fopen(logpath,"a+");
	
		
    EPM_ask_attachments( RootTask,EPM_target_attachment, &itemCount, &revs );// z knihovny epm.h "#define EPM_target_attachment   

	      tag_t *bvrs;
       tag_t bvr;
       int bvrsCount;
	   

//	   printf ("Count %d \n",itemCount);
	for( int j = 0; j < itemCount; j ++ )
	{
		char *item_id;
		char *itemType_rev;
		date_t rev_last_date,
			dataset_asm_date_mod,
			datset_date_mod;
		   ITEM_rev_list_bom_view_revs(revs[j], &bvrsCount, &bvrs);
		   ITEM_ask_item_of_rev(revs[j], &item);
		   ITEM_ask_id2(item,&item_id);
		   ITEM_ask_type2(item, &itemType_rev);
	  
	   AOM_ask_value_date	(revs[j], "last_mod_date", &rev_last_date);
		  // strcpy(cisloZakazky,item_id);//pro item_id
		 //  printf("S revizi je spojeno %i objektu \n", bvrsCount);
		   printf(" typ %s \n",itemType_rev);
		

		   // Prochazim pripojene objekty
		   // Kazdym objektem by mela byt vrcholova polozka zakazky
		   printf("comare %s %s =%d \n",itemType_rev,Typ_itemu,strcmp(itemType_rev,Typ_itemu));
		   if (is_compare_asm && is_compare_asm_rel)
		   {
			   CheckdDataset(revs[j], Dataset_sestavy, Dataset_sestavy_rel,&dataset_asm_date_mod);
			   int BomsCount;
			   tag_t* Boms;
				ITEM_rev_list_bom_view_revs(revs[j], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
				for(int l = 0; l < BomsCount; l++)
					{
					// BOM window
					tag_t BomWindow = NULLTAG;
					BOM_create_window(&BomWindow);
					tag_t BomTopLine = NULLTAG;
					// Výpis BOM line 
					BOM_set_window_top_line(BomWindow, NULLTAG, revs[j], Boms[l], &BomTopLine);			
					//nastaveni context bomline absolute occurrence edit mode			
					BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
					
					if(ListBomLine(BomTopLine, RootTask,BomWindow, Dataset_sestavy_rel,Dataset_sestavy,dataset_asm_date_mod))
						return_value=1;
					
					BOM_refresh_window(BomWindow);
					BOM_close_window(BomWindow);
					}
		   }
		   if(strcmp(itemType_rev,Typ_itemu)==0)
		   {
			 
			  CheckdDataset(revs[j], Typ_datasetu, Relace,&datset_date_mod);//porovnavany dataset 
			 printf(" int %d \n",strlen(Compare_dataset[0]));
			 if (is_compare_dataset && is_compare_rel)
				 {
					for(int i=0;i<n_com;i++)
						{
						date_t compare_datset_date_mod;  
						if( CheckdDataset(revs[j], Compare_dataset[i], Compare_rel[i],&compare_datset_date_mod))//srovnavane datasety které nesmý byt novìjší
							{
							int vysledek=	 CompareDate (datset_date_mod, compare_datset_date_mod);
							if(vysledek==-1)// je novìjší compare dataset než výkres
								{
								printf("je novejdi compare dataset nez vykres \n");
								Add_Obj_to_Ref(RootTask,revs[j], 1);
								return_value=1;
								}
							}
						}
					}
			 else 
			 {
				int vysledek=	 CompareDate (datset_date_mod, rev_last_date);
					printf ("porovnani %d \n",vysledek);
					if(vysledek==-1)// je novìjší revize než výkres
						{
							printf("je novejsi revize nez vykres \n");
							Add_Obj_to_Ref(RootTask,revs[j], 1);
						return_value=1;
						}	
			 }

		   }
		  
	}

	printf("konec \n");
	if (revs) MEM_free(revs);
    return return_value;
}
