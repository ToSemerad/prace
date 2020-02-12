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

extern "C" DLLAPI int TPV_Export_Dataset_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Export_Dataset_TC11_init_module(int *decision, va_list args);
int TPV_Export_Dataset(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);


extern "C" DLLAPI int TPV_Export_Dataset_TC11_register_callbacks()
{
    printf("Registruji TPV_Export_Dataset_TC11.dll\n");
    CUSTOM_register_exit("TPV_Export_Dataset_TC11", "USER_init_module", TPV_Export_Dataset_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Export_Dataset_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Export_Dataset", "", TPV_Export_Dataset);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Export_Dataset");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
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


void downloadDataset(tag_t rev,char* I_ID, char* typ, char** retCesta,char* cesta_in,char* ref_name,char* find_relation, char* find_typ_name) {
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
       strcpy(cesta,cesta_in);
	  // printf("I_ID %s \n",I_ID);
     /*  */

       AOM_ask_value_string(rev,"item_revision_id",&ID_Rev);

      // ifail = GRM_find_relation_type("IMAN_specification", &relation_type_tag);
	   ifail = GRM_find_relation_type(find_relation, &relation_type_tag);
	   
    if (ifail != ITK_ok) { /* your error logic here */ }

       ifail = GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs);
    if (ifail != ITK_ok) { /* your error logic here */ }
   // printf("pocet datasetu %d\n",n_specs);

	int pocet_vyskytu=1;
    
	for ( int ii = 0; ii < n_specs; ii++) {
        ifail = TCTYPE_ask_object_type (specs[ii], &type_tag);
        if (ifail != ITK_ok) { /* your error logic here */ }
        
        ifail = TCTYPE_ask_name(type_tag, type_name);
        if (ifail != ITK_ok) { /* your error logic here */ }
     //        printf("Typ polozky %s \n",type_name);
      
                    
            // if(strcmp(typ,"pdf")==0) {
				//if(strcmp(typ,find_typ)==0) {
                   // printf("-----typ ok\n");
                     // if (strcmp(type_name, "PDF") == 0)                    {
                        if (strcmp(type_name, find_typ_name) == 0)    {
                //         printf("-----typ_name ok\n");
                         //  ifail = AE_ask_all_dataset_named_refs(specs[ii], "PDF_Reference", &n_refs, &refs);
                          ifail = AE_ask_all_dataset_named_refs(specs[ii], ref_name, &n_refs, &refs);

						 printf("Reference %d \n",n_refs);

                           if (ifail != ITK_ok) { printf("chyba v dotazu na dataset\n"); }
                           else printf(" ok export\n");
							
						   
                           if (pocet_vyskytu++>1)
						   {
							   strcpy(cesta,cesta_in);
							   
							   char cislo [10];
							   sprintf(cislo,"%d",ii);
							   strcat(cesta,cislo);
							   strcat(cesta,"_");
							   
						   }
						   
							printf("id %s \n",I_ID);
						  
							   printf("odstran / \n");
							   for (int k =0;k<strlen(ID_new);k++)//odstranení white space
									if(ID_new[k]=='/')
										ID_new[k]='_';
							   strcat(cesta,ID_new);
						  
							   strcat(cesta,"_");
							   strcat(cesta,ID_Rev);
						   
                           strcat(cesta,".");
                           strcat(cesta,typ);
						   
                                               
                          // strcpy(*retCesta, cesta);

						  // printf("Cesta %s \n  ",cesta);
                           if(SouborExistuje(cesta)==1){
							   printf("ref_name %s \n",ref_name);
                                //  ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
							   ifail = AE_export_named_ref(specs[ii],ref_name, cesta);
                                  if (ifail != ITK_ok) {
									  printf("Nefunguje export \n");
								  EMH_clear_last_error(ifail);
														}
                           }
                    }
             else printf("-----typ bad %s x %s \n",type_name, find_typ_name);
						
       }
}
//downloadDataset(tag_t rev,char* I_ID, char* typ, char** retCesta,char* cesta_in,char* ref_name,char* find_relation, char* find_typ_name)
// downloadDataset(revs[j],item_id, File_type, &retCesta,Cesta,Typ_datasetu,Relace,Typ_datasetu);
//void ListBom (tag_t bomLine, int level,char* cesta_in,char* ref_name,char* find_typ,char* find_typ_name,char* file_type)
void ListBom (tag_t bomLine, int level,char* typ,char* cesta_in,char* ref_name,char* find_relation, char* find_typ_name, char* Typ_itemu)
{
//	printf ("---- First PDF function ---\n");
	  int attributeId;
      // double actualQuantity;
    tag_t rev = NULLTAG;
	if(level >0)
	{
    BOM_line_look_up_attribute("bl_revision", &attributeId);
//	printf("blrevision %d \n",attributeId);
    BOM_line_ask_attribute_tag(bomLine, attributeId, &rev);
//	printf("rev %d \n",rev);
	
    tag_t item = NULLTAG;
       tag_t revItem = NULLTAG;
    char id[ITEM_id_size_c + 1];
	char *cislo_vykresu;
    char itemType[ITEM_type_size_c];
    char revId[ITEM_id_size_c + 1];
    ITEM_ask_item_of_rev(rev, &item);
//	printf("item %d \n",item);
    ITEM_ask_id(item, id);
    
	//ITEM_ask_rev_id(rev, revId);
	
	
    ITEM_ask_type(item, itemType);
	printf("%s / %s itemType %s \n",id,revId,itemType);

		if(strcmp(itemType,Typ_itemu)==0)
		   {
			    AOM_ask_value_string(rev,"tpv4_cislo_vykresu",&cislo_vykresu);
		char* retCesta;
		//retCesta = (char*) malloc(255 * sizeof(char));
	
             downloadDataset(rev,cislo_vykresu, typ, &retCesta,cesta_in, ref_name, find_relation, find_typ_name);
			}else printf ("spatny typ %s x %s \n",itemType,Typ_itemu);
	}		
	   tag_t *lines;
     //  tag_t line;
       int childCount;
       BOM_line_ask_child_lines(bomLine, &childCount, &lines);
	  // printf("childCount %d lines %s bomline %d \n",childCount,lines,bomLine);
       for(int i = 0; i < childCount; i++) {
            // line = lines[i];
              ListBom (lines[i], level + 1,typ, cesta_in, ref_name,find_relation, find_typ_name,Typ_itemu);
       }
}

char* Create_folde(char* cesta,char* slozka)
{
	char mkdir[120]="mkdir \"";
	
	char cesta_new[100];
	strcpy(cesta_new,cesta);
	strcat(cesta_new,slozka);
	for (int k =0;k<strlen(cesta_new);k++)
		if(cesta_new[k]==' ')
			cesta_new[k]='_';
	strcat(mkdir,cesta_new);
	int remove_x=0;
	for (int t =0;t<strlen(mkdir);t++)
	{	//printf("znak %c \n",mkdir[t]);
		if(mkdir[t]=='\\' && mkdir[t-1]=='\\')
		{
			printf("nalezeno escape %d \n",strlen(mkdir));
				for (int q=t;q<=strlen(mkdir);q++)
				{
					//printf("copy %c -> %c \n",mkdir[q],mkdir[q-1]);
					mkdir[q-1]=mkdir[q];
				}
		}
	}
	strcat(mkdir,"\"");
	
	system(mkdir);
	strcat(cesta_new,"\\");

	return cesta_new;
}

int TPV_Export_Dataset(EPM_action_message_t msg)
{

char*Argument = nullptr;
char*Flag = nullptr;
char*Value = nullptr;
int ArgumentCount = TC_number_of_arguments(msg.arguments);
char Cesta[50];
char Relace[20];
char Typ_itemu[20];
char Typ_datasetu[20];
char File_type[20];
char Pripona[5];
logical vytvorit_slozku=false;


	while(ArgumentCount--> 0 )
{
	Argument = TC_next_argument( msg.arguments );
	ITK_ask_argument_named_value( Argument, &Flag, &Value );
	printf("Value %s Flag %s \n",Value, Flag);
	if( strcmp ( "Cesta", Flag ) == 0 && Value != nullptr)
	{
		//printf(" cesta %s \n",Value);
		strcpy(Cesta,Value);
	// …
	}
	else if( strcmp ( "Relace", Flag ) == 0 && Value != nullptr)
	{
	// …
		//printf(" relace %s \n",Value);
		strcpy(Relace,Value);
	}
	else if( strcmp ( "Typ_Itemu", Flag ) == 0 && Value != nullptr)
	{
	// …
		//printf(" typ %s \n",Value);
		strcpy(Typ_itemu,Value);
	}
	else if( strcmp ( "Typ_Datasetu", Flag ) == 0 && Value != nullptr)
	{
	// …
		printf(" typ %s \n",Value);
		strcpy(Typ_datasetu,Value);
	}
	else if( strcmp ( "File_type", Flag ) == 0 && Value != nullptr)
	{
	// …
		printf(" file_typ %s \n",Value);
		strcpy(File_type,Value);
	}
	else if( strcmp ( "Pripona", Flag ) == 0 && Value != nullptr)
	{
	// …
		//printf(" typ %s \n",Value);
		strcpy(Pripona,Value);
	}
		else if( strcmp("Slozka",Flag) == 0)
		vytvorit_slozku=true;

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
	if(vytvorit_slozku)
	{
		AOM_UIF_ask_value(job,"object_name",&job_name);
	
		char* id_slozky=strtok(job_name,"/");
		char* rev_slozky=strtok(NULL,";");
		char slozka_new [20];
		strcpy(slozka_new,id_slozky);
		strcat(slozka_new,"_");
		strcat(slozka_new,rev_slozky);

		strcpy(Cesta,Create_folde(Cesta,slozka_new));
		strcat(Cesta,"\\");
		printf("%d cesta \n%s\n",__LINE__,Cesta); 
		
	}
	//printf ("RootTask %d \n",RootTask);
	if(strlen(Cesta)==0)
	{
		
		strcpy(Cesta,"C:\\Temp\\DXF\\");
	/*	strncat(Cesta,job_name,12);
		strcat(Cesta,"*\\");*/
		printf("Cesta %s \n",Cesta);
		copy_DXF=1;
	}
	
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
		char itemType[ITEM_type_size_c];
		   ITEM_rev_list_bom_view_revs(revs[j], &bvrsCount, &bvrs);
		   ITEM_ask_item_of_rev(revs[j], &item);
		  
		  // ITEM_ask_id2(item,&item_id);
		   ITEM_ask_type(item, itemType);
		  // strcpy(cisloZakazky,item_id);//pro item_id
		 //  printf("S revizi je spojeno %i objektu \n", bvrsCount);

		   tag_t bomWindow;
		   tag_t bomTopLine;

		   // Prochazim pripojene objekty
		   // Kazdym objektem by mela byt vrcholova polozka zakazky
		   if(strcmp(itemType,Typ_itemu)==0)
		   {
			    AOM_ask_value_string(revs[j],"tpv4_cislo_vykresu",&item_id);
			 if(bvrsCount==0 )
			{
			   char* retCesta;
				//retCesta = (char*) malloc(255 * sizeof(char));
			   printf(" typ %s \n",Typ_datasetu);
			   printf(" file_typ %s \n",File_type);
			   downloadDataset(revs[j],item_id, Pripona, &retCesta,Cesta,File_type,Relace,Typ_datasetu);
//			   printf("navrat z downloadDataset \n");
			   
			}
			else {
	//		   printf("sestavy \n");
			   for (int i = 0; i < bvrsCount; i++) {
					 bvr = bvrs[i];
					 BOM_create_window(&bomWindow);
					 BOM_set_window_top_line(bomWindow, NULLTAG, revs[j], bvr, &bomTopLine);
             
					 //ListBomLine(BomTopLine, 0, RootTask,BomWindow,user_name);
					 ListBom (bomTopLine, 0, Pripona, Cesta,File_type,Relace,Typ_datasetu,Typ_itemu);
				printf("navrat z ListBom \n");
					// poradi_dokumentu=0;
				/*	 FirstPdf (bomTopLine,0);
					 poradi_dokumentu=0;*/
					// AOM_save(bomWindow);
			   }
		   }
		   }else printf(" typ %s \n",itemType);
		  
	}
	//if(copy_DXF==1)
//	system("move C:\Temp\DXF\*.dxf \\10.1.1.8\TC_Data\HESTEGO\DXF");
	//system("echo test  > test.txt");
	//system("move C:\\Temp\\DXF\\*.dxf \\");
	printf("konec \n");
    return ITK_ok;
}
