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
#include <ae\ae.h>
#include <tccore\grm.h>
#include <unidefs.h>
#include <errno.h>
#include <string>
#include <tccore\aom.h>
#include <time.h>
#include <sa/person.h>
#include <list>
#include <algorithm>
#include <locale.h>


#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))


extern "C" DLLAPI int TPV_MAKE_PDF_TC11_register_callbacks();
extern "C" DLLAPI int TPV_MAKE_PDF_TC11_init_module(int *decision, va_list args);
int TPV_MAKE_PDF(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);

//char *Nazvy[100][20];
//char Nazvy[100000][20][128];
char *cisloZakazky;
int poradi_dokumentu=0;

extern "C" DLLAPI int TPV_MAKE_PDF_TC11_register_callbacks()
{
    printf("Registruji TPV_MAKE_PDF_TC11.dll\n");
    CUSTOM_register_exit("TPV_MAKE_PDF_TC11", "USER_init_module", TPV_MAKE_PDF_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_MAKE_PDF_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_MAKE_PDF", "", TPV_MAKE_PDF);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_MAKE_PDF");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}
int compareCharacters(char a,char b){
	if(a==b)
		return 0;
	else
		return -1;
}
char* Repalce_char(char *input,char x,  char n)
{
	char output [sizeof(input)];
	//printf ("vstup x=%c n=%c \n",x,n); 
	for (int i=0;i<sizeof(input);i++)
				{
					//printf(" -%d = |%c| x = |%c|\n",i, input[i],x);
					char porovnej=input[i];
					//printf("|%d| = |%d| \n",porovnej,x); 
					//if(compareCharacters(porovnej,x)==0)
					if(porovnej==0)
					{	
						//printf ("-	- replace |%c| -> |%c| \n",n,output[i]);
						output[i]=n;
					}
					else
					{
						//printf ("-	- copy |%c| -> |%c| \n",input[i],output[i]);
						output[i]=input[i];
					}
	}
	printf("replace %s \n",output);
	return output;
}


char* Get_position (tag_t rev)
{
	char* vyber;
	AOM_ask_value_string(rev,"tpv4_vyber_sou_tisku",&vyber);
	//printf("____get pozistion_____\n vyber %s \n",vyber);
	if (strcmp(vyber,"Nevybrano")==0)
	{
		char *pozice;
		AOM_ask_value_string(rev,"tpv4_zadej_sou_tisku",&pozice);
		
		if (strlen(pozice)>2)
		{
			//printf("........Position........\n%s\n",pozice);
			if (strchr(pozice,'x')==0 ||strchr(pozice,'X')==0)
			{
				//printf("obsahuje x \n");
				char out_pos[9];
				strcpy(out_pos,"P");
				strcat(out_pos,pozice);
				printf("-----return %s \n",out_pos);
				return out_pos;
			}else if(strchr(pozice,' ')==0)
			{

				//char oprav_pozic[7];
				//char* tmp=strtok(pozice," ");
				////strcpy(oprav_pozic,Repalce_char(pozice,' ',  'x'));
				//printf("neobsahuje x\n nahrazeno %s \n",oprav_pozic); 
				//return oprav_pozic;
			}
		}else printf("delka je mensi nez 2 \n ");
	}
	else
		{
			return vyber;
		}
			//printf("-----return PH_Roh \n");
			return "PH_Roh";
}

struct obsahuje{
	std::string id_polozky;
	std::string rev_polozka;
	char path[255];
	char tmp_poradi[ITEM_id_size_c + 1];
	int pocet;
};
 //std::list<obsahuje>seznam;
obsahuje *seznam= (obsahuje *)malloc(sizeof(obsahuje) * 1000);

char* Get_akctiveUser()
{
	char *user_name;
	tag_t user_tag,
		person_tag;

	POM_get_user(&user_name, &user_tag);
	printf("-----Jmeno %s tag %d-------\n",user_name,user_tag);
	SA_find_person2(user_name, &person_tag);
	return user_name;
} 

char* Odstran_new_line(char *input)
{
	char output[2048]="";

	char *token;
	token=strtok(input,"\n");
	//printf("token %s \n",token);
	
	while(token!=NULL)
	{
		
		printf("token %s \n",token);
		strcat(output,token);
		//strcat(output," ");
		token=strtok(NULL,"\n");
	}
	
	//printf("** output %s \n",output);
return	output;
}
void importDatates(tag_t dataset,char* way,char *ref,char *fileName)
{
    /*  AE_find_dataset finds latest revision of dataset */
    
    //IFERR_ABORT(AE_find_dataset("6667776-A", &dataset));
    //ECHO("\n dataset: %u \n", dataset);
	AOM_lock(dataset);
    AOM_refresh(dataset, TRUE);
  //  printf("\n dataset=%d) \n ref=%s) \n way=%s) \n filename=%s) \n",dataset, ref, way, fileName);
    /* the fourth argument must be a unique name in the volume */
   AE_import_named_ref(dataset, ref, way, fileName,  SS_BINARY);
  // AE_import_named_ref(dataset, "UG-QuickAccess-Binary", "W:\\images_preview.qaf", "6667776-A_binary.qaf",  SS_BINARY);

    AOM_save(dataset); 
    AOM_refresh(dataset, FALSE);
	AOM_unlock(dataset);
    AOM_unload(dataset);
}

char *time_stamp(){

char *timestamp = (char *)malloc(sizeof(char) * 16);
time_t ltime;
ltime=time(NULL);
struct tm *tm;
tm=localtime(&ltime);

//sprintf(timestamp,"%04d-%02d-%02d_%02d:%02d:%02d", tm->tm_year+1900, tm->tm_mon+1, 
	//tm->tm_mday, tm->tm_hour, tm->tm_min,tm->tm_sec);
sprintf(timestamp,"%02d.%02d.%04d",tm->tm_mday,tm->tm_mon+1,tm->tm_year+1900);
return timestamp;
}

int Equels_obsah (obsahuje element,int pocet,obsahuje porovnani[])
{
	printf ("********hledani %d ********\n",pocet);
	for (int i=0;i<pocet;i++)
	{
		printf(" Porovnani %s - %s \n  %s - %s \n",element.id_polozky,porovnani[i].id_polozky, element.rev_polozka, porovnani[i].rev_polozka);
		if(element.id_polozky==porovnani[i].id_polozky && element.rev_polozka==porovnani[i].rev_polozka)
		{
			printf ("NALEZO -------- \n");
			return i;
		}
	}
	printf ("NE-NALEZO -------- \n");
	return 1;

}

void TiskSestavy (char* id,int obrobna,int kooperace,int sestava,int prvni_laser_nuzky, int prvni_deleni, int prvni_kooperace,char* nazev_souboru,tag_t rev)
{
	  
				FILE *outup;
				char cesta[255] = "C:\\SPLM\\Apps\\PDFCreate\\vstup\\";
				strcat(cesta, nazev_souboru);
				strcat(cesta, ".tpv");
				outup = fopen(cesta, "a+");
					// printf("___\n___%s___\n___\n",cesta);
					fprintf(outup,"S#%s\n", Get_position (rev));
					fprintf(outup,"TS#1%d%d%d%d%d%d\n",obrobna,kooperace,sestava,prvni_laser_nuzky,prvni_deleni,prvni_kooperace);
					fclose(outup);
                           
}
void SadyDokumentu(int ChildsCount,tag_t *Childs, int sestava,char* id,char* nazev_souboru, tag_t rev)
{
	setlocale(LC_ALL, "cs_CZ.utf8");
	int prvni_laser_nuzky=0,
		kooperace=0,
		obrobna=0,
		prvni_deleni=0,
		prvni_kooperace=0;
	for (int i=0;i<ChildsCount;i++)
	{
		tag_t operation;
		int AttributeId;
		char* typOperace;				  
		//printf("id op %s \n",id);
		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[i], AttributeId, &operation);
		//printf("tag op_rev %d \n",operation);

		BOM_line_look_up_attribute("bl_TPV4_operace_pomRevision_tpv4_o_typ_operace", &AttributeId);
		BOM_line_ask_attribute_string(Childs[i], AttributeId, &typOperace);
		// char en_typ_op[sizeof(typOperace)+1];
		// strcpy(en_typ_op,OdstranCZ(typOperace));
		// printf("typOperace %s %d\n",en_typ_op,strlen(en_typ_op));
		// FILE *LOG;
		// char cesta[255] = "C:\\Temp\pdflog.txt";
		//					/* strcat(cesta, nazev_souboru);
		//					 strcat(cesta, ".tpv");*/
		//					 LOG = fopen(cesta, "a+");
		//					 fprintf(LOG,"Typ Operace %s \n", typOperace);//new_popis

					//printf(" %c %c %c %c \n compare: \n %d %d %d %d \n",typOperace[0],typOperace[3],typOperace[4],typOperace[5],compareCharacters(typOperace[0],'P'),compareCharacters(typOperace[3],'L'), compareCharacters(typOperace[4],'E'), compareCharacters(typOperace[5],'N'));
					//printf(" %c %c %c \n compare: \n %d %d %d %d \n",typOperace[0],typOperace[5],typOperace[6],compareCharacters(typOperace[0],'N'),compareCharacters(typOperace[5],'K'), compareCharacters(typOperace[6],'Y'));
		if (i==0)
		{
			if (strncmp(typOperace,"LASER",5)==0 
				|| strncmp(typOperace,"NUZKY",5)==0 
				|| strncmp(typOperace,"NÙŽKY",5)==0
				|| (compareCharacters(typOperace[0],'N')==0 && compareCharacters(typOperace[5],'K')==0 && compareCharacters(typOperace[6],'Y')==0 ))
			{
				//fprintf(LOG," OBSAHUJE PRVNI_LASER_NUZKY \n");
				 prvni_laser_nuzky=1;
			}else if( strncmp(typOperace,"DELENI",6)==0 
				|| (compareCharacters(typOperace[0],'D')==0 && compareCharacters(typOperace[3],'L')==0 && compareCharacters(typOperace[4],'E')==0 && compareCharacters(typOperace[5],'N')==0))
			{
				//fprintf(LOG," OBSAHUJE PRVNI_DELENI \n");
				prvni_deleni=1;
			}else if (strncmp(typOperace,"KOOP",4)==0 
				||strncmp(typOperace,"ZINEK",5)==0 
				||(compareCharacters(typOperace[0],'P')==0 && compareCharacters(typOperace[3],'L')==0 && compareCharacters(typOperace[4],'E')==0 && compareCharacters(typOperace[5],'N')==0) 
				|| strncmp(typOperace,"PALENI",5)==0)
			{
				//fprintf(LOG,"\n OBSAHUJE PRVNI_KOOP \n");
				prvni_kooperace=1;
			}
		}
		if  ((strncmp(typOperace,"OBR",3)==0 || strncmp(typOperace,"OBRÁBÌÈ",7)==0)
			&&(strncmp(typOperace,"NETOBR",6)!=0 || strncmp(typOperace,"NETOBRÁBÌÈFCNC",15)!=0))
			{
				//fprintf(LOG," OBSAHUJE OBRABEC \n");
				obrobna=1;
			}
		if (strncmp(typOperace,"KOOP",4)==0 
			|| strncmp(typOperace,"ZINEK",5)==0 
			|| (compareCharacters(typOperace[0],'P')==0 && compareCharacters(typOperace[3],'L')==0 && compareCharacters(typOperace[4],'E')==0 && compareCharacters(typOperace[5],'N')==0) 
			|| strncmp(typOperace,"PALENI",5)==0 
			||strncmp(typOperace,"NETOBR",6)==0 
			|| strncmp(typOperace,"NETOBRÁBÌÈFCNC",15)==0)
		{
				//fprintf(LOG," OBSAHUJE KOOP \n");
				kooperace=1;
		}
		//fclose(LOG);
	}
	
	TiskSestavy (id,obrobna,kooperace,sestava,prvni_laser_nuzky,prvni_deleni,prvni_kooperace,nazev_souboru,rev);
}
void tiskOperaci (char output [500],char * id,char* nazev_souboru)
{
					  FILE *outup;
				char cesta[255] = "C:\\SPLM\\Apps\\PDFCreate\\vstup\\";
				strcat(cesta, nazev_souboru);
				strcat(cesta, ".tpv");
				outup = fopen(cesta, "a+");
				  // printf("%s\n",out);
				fprintf(outup,"%s\n", output);
				    fclose(outup);
}
int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6][4]){
	int jetam=0;
	for(int j=0;j<=6;j++)
	{
	//	printf("strom %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
		
		if((level==pole[j][0])&&(bomLine==pole[j][1])&&(Rev==pole[j][2]))
		{
		//	printf("shoda %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
			jetam=1;
			break;
		}
	
	}

	return jetam;
}

int SouborExistuje(char *nazev)
{printf("test existence souboru %s  \n",nazev);
    FILE *soubor;
    if ((soubor = fopen(nazev, "rb")) != NULL) {
        fclose(soubor);
		printf("nalezen \n");
		printf("line %d \n",__LINE__);
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
						   printf(" %d \n",__LINE__);
                           if(SouborExistuje(cesta)==1){
							   //printf(" %d \n",__LINE__);
                                  ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
                                  if (ifail != ITK_ok) { printf("Nefunguje export \n");}
                           }else 
						   printf(" %d \n",__LINE__);
                    }
					  printf(" %d \n",__LINE__);
             }
			 printf(" %d \n",__LINE__);
       }
}

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

char* Get_OP( tag_t bvr, tag_t TPrev,int makeInput,char* id, int sestava, char* nazev_souboru, tag_t Dilrev)
{
	
	char out[128];
	strcpy(out,"");
        //ITEM_rev_list_bom_view_revs(TPrev, &BomsCount, &Boms);
	printf("----Prochazeni kusovniku TP------    \n");
	tag_t	BomWindow,
			BomTopLine = NULLTAG;
		// Výpis BOM line 
			
            BOM_create_window(&BomWindow);
            

            // Výpis BOM line 
            BOM_set_window_top_line_bvr(BomWindow, bvr, &BomTopLine);
			
			//nastaveni context bomline absolute occurrence edit mode			
			//BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
		// Potomci
//	printf("TopLine tag %d \n",BomTopLine);
	char typyTs[7][5];
	for (int ts=0;ts<7;ts++)
		sprintf(typyTs[ts],"%d#",ts);
		
	
	tag_t *Childs = NULLTAG;
	int ChildsCount=0;
		//ValueInt=100;
	char ValueString[15];
	BOM_line_ask_child_lines(BomTopLine, &ChildsCount, &Childs);
	//printf("nalezení vrcholu  potomkù %d \n",ChildsCount);
	//FILE *LOG;
	//						 char cesta[255] = "C:\\Temp\log.txt";
	//						/* strcat(cesta, nazev_souboru);
	//						 strcat(cesta, ".tpv");*/
	//						 LOG = fopen(cesta, "a+");
	//						 fprintf(LOG,"PØED SADY DOKUMENTU  count %d, tag %d, sestava %d , id %s ,nazev_souboru %s , tag rev %d\n", ChildsCount,Childs,sestava,id,nazev_souboru,Dilrev);//new_popis

	//						  fclose(LOG);
	SadyDokumentu(ChildsCount,Childs,sestava,id,nazev_souboru,Dilrev);
						 for(int ii=0;ii<ChildsCount;ii++)
					 {
						   tag_t operation;
						   int AttributeId;
						  
							//printf("id op %s \n",id);
							BOM_line_look_up_attribute("bl_revision", &AttributeId);
							BOM_line_ask_attribute_tag(Childs[ii], AttributeId, &operation);
						//	printf("tag op_rev %d \n",operation);
						tag_t item_op;
					 /*   char id_op[ITEM_id_size_c + 1];
						char itemType_op[ITEM_type_size_c+1];
						char revId_op[ITEM_id_size_c + 1];
						ITEM_ask_item_of_rev(operation, &item_op);
						ITEM_ask_id(item_op, id_op);
						ITEM_ask_rev_id(operation, revId_op);
						ITEM_ask_type2(item_op, &type);
						printf("\n >>>> %s/%s \n Typ %s \n ",id_op,revId_op,type);*/


						/* if(strcmp(itemType_op,"OPERACE")==0)
						 {*/
						   // ITEM_ask_type(item_tp, itemType_tp);
							char* Bom_num;
                           char* popisOperace;
                           char* pracoviste;
                           char* typOperace;
                           char* tac;
                           char* tbc;
						  double tac_num;
						  double tbc_num;

						   BOM_line_look_up_attribute("bl_TPV4_operace_pomRevision_tpv4_o_popis", &AttributeId);
						   BOM_line_ask_attribute_string(Childs[ii], AttributeId, &popisOperace);
						 
						   strcpy (popisOperace,Odstran_new_line(popisOperace));
						   //strcpy(str,popisOperace);
						  // char *token;
						  //char new_popis[2048]=" ";
						  // const char s[2] = "\n";
						  //
						   
						   //strcpy(popisOperace, );
							  // token = strtok(str, s);
							 //  strcpy(new_popis,token);
							 //  /* walk through other tokens */
							 //  while( token != NULL ) {
								//  strcat(new_popis,token);
								//  printf( " %s\n", token );
    
								//  token = strtok(NULL, s);
							 //  }
						  //printf("new_popis %s \n",new_popis);
						 // AOM_ask_value_string(operation,
						//   printf("popis %s \n",popisOperace);

						   BOM_line_look_up_attribute("bl_TPV4_operace_pomRevision_tpv4_o_typ_operace", &AttributeId);
						   BOM_line_ask_attribute_string(Childs[ii], AttributeId, &typOperace);
						 //  printf("typOperace %s %d\n",typOperace,strlen(typOperace));
						   if(strlen(typOperace)>5)
						   {
							   typOperace=strtok(typOperace,"~");
							 // printf("235 typOperace %s \n",typOperace);
						   }
						   BOM_line_look_up_attribute("bl_TPV4_operace_pomRevision_tpv4_o_pracoviste", &AttributeId);
						   BOM_line_ask_attribute_string(Childs[ii], AttributeId, &pracoviste);
						 //  printf("typOperace %s %d\n",pracoviste,strlen(pracoviste));
						    if(strlen(pracoviste)>5)
						   {
							   pracoviste=strtok(pracoviste,"~");
							 // printf("235 pracoviste %s \n",pracoviste);
						   }

						   BOM_line_look_up_attribute("bl_TPV4_operace_pomRevision_tpv4_o_tac", &AttributeId);
						   BOM_line_ask_attribute_string(Childs[ii], AttributeId, &tac);
						   if( strlen(tac)<1)
						   {
							//printf("247 tac %s %d\n",tac,strlen(tac));
							tac_num=0.00;
						   }
						   else
						   {
							//   printf("246 tac %s %d\n",tac,strlen(tac));
							  tac_num=strtod(tac,NULL);
							  
						   }
						 //  printf("tac =%f \n",tac_num);
						   BOM_line_look_up_attribute("bl_TPV4_operace_pomRevision_tpv4_o_tbc", &AttributeId);
						   BOM_line_ask_attribute_string(Childs[ii], AttributeId, &tbc);
						   //printf("tbc %s %d\n",tbc,strlen(tbc));
							 if( strlen(tbc)<1)
						   {
							// printf(" 255 tbc %s \n",tbc,strlen(tbc));
							tbc_num=0.00;
						   }
						  else
						   {
							  // printf("tbc %s \n",tbc,strlen(tbc));
							   tbc_num=strtod(tbc,NULL);
							   
						   }
								//printf("tbc =%f \n",tbc_num);
						   BOM_line_look_up_attribute("bl_sequence_no", &AttributeId);
						   BOM_line_ask_attribute_string(Childs[ii], AttributeId, &Bom_num);
						 //  printf("bum_num %s \n",Bom_num);
                         /*AOM_ask_value_string(operation, "tpv4_o_popis", &popisOperace);
                           AOM_ask_value_string(operation, "tpv4_o_typ_operace", &typOperace);
                           AOM_ask_value_string(operation, "tpv4_o_pracoviste", &pracoviste);*/
                          /* AOM_ask_value_double(operation, "tpv4_o_tac", &tac);
                           AOM_ask_value_double(operation, "tpv4_o_tbc", &tbc);*/
                           
                           if (makeInput == 1) {
							   char output [500];
							  // sprintf(output,"TO#%s#%s#%s#%.2f#%.2f\n", Bom_num, popisOperace, pracoviste, tac_num, tbc_num);
							   FILE *outup;
							 char cesta[255] = "C:\\SPLM\\Apps\\PDFCreate\\vstup\\";
							 strcat(cesta, nazev_souboru);
							 strcat(cesta, ".tpv");
							 outup = fopen(cesta, "a+");
								  // printf("%s\n",out);
							 fprintf(outup,"TO#%s#%s#%s#%.2f#%.2f\n", Bom_num, popisOperace, pracoviste, tac_num, tbc_num);//new_popis
								    fclose(outup);
                           }
						// }else printf("neni TPV4_operaceRevision je %s \n",itemType_op);
					 }
	//printf("konecprochazeni \n###############\n");
	return out;

}

void listBom(tag_t bomLine, int level, int qnt,char* termin,char* jmeno) {
      //printf ("--list bom line--- %d\n",bomline); 
       // Revize
    int attributeId;
	char *cislo_vykresu;
      // double actualQuantity;
    tag_t rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &attributeId);
	//printf("blrevision \n",attribiteId);
    BOM_line_ask_attribute_tag(bomLine, attributeId, &rev);
	//printf("rev %d \n",rev);
	BOM_line_look_up_attribute("bl_TPV4_dilRevision_tpv4_cislo_vykresu", &attributeId);
    BOM_line_ask_attribute_string(bomLine, attributeId, &cislo_vykresu);

    tag_t item = NULLTAG;
       tag_t revItem = NULLTAG;
    char id[ITEM_id_size_c + 1];
    char itemType[ITEM_type_size_c];
    char revId[ITEM_id_size_c + 1];
    ITEM_ask_item_of_rev(rev, &item);
    ITEM_ask_id(item, id);
    ITEM_ask_rev_id(rev, revId);
    ITEM_ask_type(item, itemType);
		char tmp_poradi[ITEM_id_size_c + 1];
		strcpy(tmp_poradi,"");
		if (poradi_dokumentu<10)
			sprintf(tmp_poradi,"00%d",poradi_dokumentu++);
		else if(poradi_dokumentu<100)
			sprintf(tmp_poradi,"0%d",poradi_dokumentu++);
		else
			sprintf(tmp_poradi,"%d",poradi_dokumentu++);
		strcat(tmp_poradi,"_");
		strcat(tmp_poradi,id);
	printf("\n %d  %s / %s \n",level,tmp_poradi,revId);
       // Zalozit soubor pro polozku
       FILE *out;
       int makeInput;

       if (strcmp(itemType, "TPV4_dil") == 0) {
             makeInput = 1;
       } else {
             makeInput = 0;
       }
       
    // Množství
       
       char* pocetKusuTC = NULL;
       char* souradniceTisku = NULL;
	  // char* jmeno=NULL;
       int attrId;
       int quantityTC;

       //AOM_ask_value_string(revItem, "TPV4_kv_pocet_kusu", &pocetKusu);
       //printf("%s - Kusu\n", pocetKusu);
	   	   if( level==1)
	   {
		BOM_line_look_up_attribute("TPV4_kv_pocet_kusu", &attrId);
       BOM_line_ask_attribute_string(bomLine, attrId, &pocetKusuTC);
	   
	   }else
		{   
       BOM_line_look_up_attribute("bl_quantity", &attrId);
       BOM_line_ask_attribute_string(bomLine, attrId, &pocetKusuTC);
	   }
       

       if (strcmp("", pocetKusuTC) == 0) {
             pocetKusuTC = "1";
       }
	   printf(">>Uroven %i, pocet kusu %s \n", level, pocetKusuTC);
       quantityTC = atoi(pocetKusuTC);
       quantityTC = quantityTC * qnt;   
	   qnt=quantityTC;
	   
	   
	   printf(" qnt %d \n",qnt);
	    if( level>1)
	   {
		   char set_qnt[10];
		  // set_qnt=atod();
		   sprintf(set_qnt,"%d",quantityTC);
		  // printf("set_qnt %s \n",set_qnt);
		BOM_line_look_up_attribute("TPV4_kv_pocet_kusu", &attrId);
		BOM_line_set_attribute_string(bomLine, attrId, set_qnt);
		//BOM_line_look_up_attribute("bl_quantity", &attrId);
		//BOM_line_set_attribute_string(bomLine, attrId, set_qnt);
	   }


       printf(" pocetkusu int %i \n", quantityTC);

       /*
       BOM_line_look_up_attribute("bl_TPV4_dilRevision_zadej_sou_tisku", &attrId);
       BOM_line_ask_attribute_string(bomLine, attrId, &souradniceTisku);
       */
		//quantityTC = atoi(pocetKusuTC);
		//quantityTC = (quantityTC == 0) ? 1 : quantityTC;
       printf("Qunatity: %i\n", quantityTC);
	    
	   // PDF Dokumenty
       char* retCesta;
       retCesta = (char*) malloc(255 * sizeof(char));
       downloadDataset(rev, id, "pdf", &retCesta);
	   printf("....Mnozstvi %d .....\n",quantityTC);
	   printf("makeInput %d \n",makeInput);
       // Zalozeni souboru
       if (makeInput == 1) 
	   {
               /* BOM_line_look_up_attribute("TPV4_kv_cis_zakazky", &attrId);
				//BOM_line_ask_attribute_string(bomLine, attrId, &cisloZakazky);*/
				//BOM_line_look_up_attribute("TPV4_kv_zadal", &attrId);
				//BOM_line_ask_attribute_string(bomLine, attrId, &jmeno);
		   jmeno=Get_akctiveUser();

		 
				//AOM_ask_value_string(rev, "tpv4_cislo_zakazky", &cisloZakazky);
             printf("%s - Zakazka \n jmeno %s \n ", cisloZakazky,jmeno);
		    char cesta[255] = "C:\\SPLM\\Apps\\PDFCreate\\vstup\\";
			strcat(cesta, tmp_poradi);
			strcat(cesta, ".tpv");
			printf(" puvodni - cesta \n %s \n",cesta);
		   obsahuje tmp;
		   tmp.id_polozky=id;
		   tmp.rev_polozka=revId;
		   strcpy(tmp.path,cesta);
		   strcpy(tmp.tmp_poradi,tmp_poradi);
		   printf ("ukladani mnozstvi %d \n",quantityTC);
		   tmp.pocet=quantityTC;
		   
		 //  std::list<obsahuje>::iterator it;
		   int nalez=0;
		   nalez=Equels_obsah(tmp,poradi_dokumentu,seznam);
		   printf("nalez %d \n",nalez);
		 //  it=std::find(seznam.begin(),seznam.end(),tmp);
		 //  printf("******nalez = %d \n",nalez);
		/*if( it!=seznam.end())*/
		if( nalez>1)
		{
			printf("soucet %d + %d  id pro %s\n",quantityTC,seznam[nalez].pocet,seznam[nalez].id_polozky);
			quantityTC=quantityTC+seznam[nalez].pocet;
			tmp.pocet=quantityTC;
			printf("uprava mnozstvi %d \n",quantityTC);
			seznam[nalez].pocet=quantityTC;
			strcpy(tmp_poradi,seznam[nalez].tmp_poradi);
			//seznam.remove(tmp);
			strcpy(cesta,seznam[nalez].path);
			//printf("nalezena cesta %s n",cesta);
			qnt=quantityTC;
			
			
		} 
		else
		{
			printf("poradi_dokumentu %d tmp %s\n",poradi_dokumentu,tmp.id_polozky);
			seznam[poradi_dokumentu]=tmp;
			printf(" \n \n VKLADAM \n \n");
		}
             
			// strcat(cesta,id);
             printf("konecna cesta \n %s \n",cesta);
             out = fopen(cesta, "w");
		
            // printf("%s \n", cesta);
			char*tmp_zakazka= strtok (cisloZakazky,"VZ");
             fprintf(out, "Z#%s\n", tmp_zakazka);
             fprintf(out, "K#%d\n", quantityTC);
			 char pozice[9]="";
			 strcpy(pozice,Get_position (rev));
			 //printf("____pozice %s \n_____",pozice);
             fprintf(out, "U#%s\n",pozice); 
			// printf("po zapisu 416 \n");
    
		
		 /*  obsahuje tmp;
		   strcpy(tmp.id_polozyk,id);
		   strcpy(tmp.rev_polozka,revId);
		   tmp.pocet=quantityTC;
		   std::list<obsahuje>::iterator it;
		   it=std::find(seznam.begin(),seznam.end(),tmp);
		if( it!=seznam.end())
		{
			quantityTC+=it->pocet;
			tmp.pocet=quantityTC;
			seznam.remove(tmp);
			
		}	 */
		
			//seznam.push_front(tmp);
		
             fprintf(out, "I#%s\n", retCesta);
             fprintf(out, "P#%s#%s#%d#%s#%s\n", tmp_zakazka, cislo_vykresu, quantityTC, jmeno, termin);
			 printf("Line %d \n",__LINE__);
             //printf("Ulozeno do v ifu %s\n", retCesta);
       }
       //printf("Ulozeno do %s\n", retCesta);
       //printf("Ulozeno do \n");

       // Tady mam cestu k vygenerovanemu PDF - musi byt zpsana do exportniho souboru

      // free(retCesta);
	   //printf ("po smazani cesty \n");
       // RELACE
       tag_t relation;
       tag_t *objects;
       tag_t object;
       int relationsCount;
       char objectType[ITEM_type_size_c + 1];

       GRM_find_relation_type("TPV4_tp_rel", &relation);
       GRM_list_secondary_objects_only(rev, relation, &relationsCount, &objects);
<<<<<<< Updated upstream
      // printf("Nalezl jsem %i relaci\n", relationsCount);
	  
	   char* vydat_sklad;
		BOM_line_look_up_attribute("TPV4_vydat_sklad", &attrId);
		BOM_line_ask_attribute_string(bomLine, attrId, &vydat_sklad);
		if(strcmp(vydat_sklad,"ANO")==0) fprintf(out, "V#ANO\n");
=======
       printf("Nalezl jsem %i relaci\n", relationsCount);
	  
	   /* :::::::::::::: Vydat sklad :::::::::::::*/
	   //char* vydat_sklad;
		//BOM_line_look_up_attribute("TPV4_vydat_sklad", &attrId);
		//BOM_line_ask_attribute_string(bomLine, attrId, &vydat_sklad);
		//if(strcmp(vydat_sklad,"ANO")==0) fprintf(out, "V#ANO\n");
>>>>>>> Stashed changes

	   	if(makeInput == 1) {
             fclose(out);
			 //TiskSestavy (id);
			  }
		
		tag_t *lines;
       tag_t line;
       int childCount;
	   int sestava=0;

       BOM_line_ask_child_lines(bomLine, &childCount, &lines);
	   char *typ_dilce;
	   BOM_line_look_up_attribute("bl_TPV4_dilRevision_tpv4_typ_polozky", &attrId);
	   BOM_line_ask_attribute_string(bomLine, attrId, &typ_dilce);
	   if (childCount>0 || strcmp(typ_dilce,"SESTAVA")==0) sestava=1;

       for (int i = 0; i < relationsCount; i++) {
             object = objects[i];
             ITEM_ask_type(object, objectType);
            // printf("Typ relacniho objektu: %s \n", objectType);


             if (std::strcmp(objectType, "TPV4_tp") == 0) {
                    // Jedna se o technologickou polozku
					tag_t revTP;
                    tag_t *TP_bvr;
                    int TPCount_bvr;
					int operCount=0;

                    ITEM_ask_latest_rev(object, &revTP);
						//pro kontrolu možna smazat
			
						/////////////////////////////

                    ITEM_rev_list_bom_view_revs(revTP, &TPCount_bvr, &TP_bvr);
					
					//printf ("pocet bvr operaci %d \n",TPCount_bvr);
                    for (int j = 0; j < TPCount_bvr; j++)
					{   
					//	printf("---------line %d \n",op_lines);
					//	PS_list_occurrences_of_bvr(TP_bvr[j],&operCount,&operations);
					//	printf("--------nalezeno %d operaci \n",operCount);
					char out_op[130];
					strcpy(out_op,Get_OP( TP_bvr[j], revTP,makeInput,id,sestava,tmp_poradi,rev));//tmp_poradi
					
                    }
					////////Tisky sestav a id
					if(TPCount_bvr==0 && makeInput == 1) TiskSestavy (id,0,0,sestava,0,0,0,tmp_poradi,rev);//tmp_poradi
                    //printf("Nalezeno %i operaci \n", operCount);
             }
       }
	   /////tisk sestav
	   if(relationsCount==0 && makeInput == 1)  TiskSestavy (id,0,0,sestava,0,0,0,tmp_poradi,rev);//tmp_poradi
	   
	   //printf("------------po ciklu \n");
       MEM_free(objects);
	 //  printf("------------po smazani \n");

                    
       //printf("Uroven %i - Zakazka %s: %f ks / %f, typ: %s \n", level, cisloZakazky, quantity, quantityTC, itemType);
       
	   /* :::::::::::::: Vydat sklad :::::::::::::*/
       // Projit potomky rekurzivne
<<<<<<< Updated upstream
      if(strcmp(vydat_sklad,"ANO")==0)
	  {
		  printf("Vydat skald -ANO \n");
		  
	  }else{

			for(int i = 0; i < childCount; i++) {
				line = lines[i];
				listBom(line, level + 1, qnt,termin,jmeno);
			}
	  }
=======
      // if(strcmp(vydat_sklad,"ANO")==0)
	 // {
	 //	  printf("Vydat skald -ANO \n");
		  
	 // }else{

			for(int i = 0; i < childCount; i++) {
				line = lines[i];
				listBom(line, level + 1, qnt,termin,jmeno);
			}
	 // }

>>>>>>> Stashed changes
	   int bvrsCount;
	   tag_t* bvrs; 
	   ITEM_rev_list_bom_view_revs(rev, &bvrsCount, &bvrs);
	   int is_released;
	   for (int i=0;i<bvrsCount;i++)
	   {
		   
		if(EPM_ask_if_released(bvrs[i],&is_released)==0)// The value 0 indicates not released, while 1 indicates released
	   	{
			tag_t release_stat = NULLTAG;
			int	ifail = RELSTAT_create_release_status( "Approved", &release_stat );
				if(ifail != ITK_ok) {/* add your error logic here */}
							
		//tag_t devDoc;
			ifail = RELSTAT_add_release_status ( release_stat, 1, &bvrs[i], true );
				if(ifail != ITK_ok) {/* add your error logic here */}
		}
		}
}

void FirstPdf (tag_t bomLine, int level)
{
	printf ("---- First PDF function ---\n");
	  int attributeId;
      // double actualQuantity;
    tag_t rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &attributeId);
	//printf("blrevision \n",attribiteId);
    BOM_line_ask_attribute_tag(bomLine, attributeId, &rev);
	//printf("rev %d \n",rev);

    tag_t item = NULLTAG;
       tag_t revItem = NULLTAG;
    char id[ITEM_id_size_c + 1];
    char itemType[ITEM_type_size_c];
    char revId[ITEM_id_size_c + 1];
    ITEM_ask_item_of_rev(rev, &item);
    ITEM_ask_id(item, id);
    ITEM_ask_rev_id(rev, revId);
    ITEM_ask_type(item, itemType);
		char tmp_poradi[ITEM_id_size_c + 1];
		strcpy(tmp_poradi,"");
		if (poradi_dokumentu<10)
			sprintf(tmp_poradi,"00%d",poradi_dokumentu++);
		else if(poradi_dokumentu<100)
			sprintf(tmp_poradi,"0%d",poradi_dokumentu++);
		else
			sprintf(tmp_poradi,"%d",poradi_dokumentu++);
		strcat(tmp_poradi,"_");
		strcat(tmp_poradi,id);
	//printf("\n %d  %s / %s \n %s ",level,tmp_poradi,revId,itemType);
       // Zalozit soubor pro polozku
       FILE *out;
       int makeInput;

       if (strcmp(itemType, "TPV4_dil") == 0) {
             makeInput = 1;
       } else {
             makeInput = 0;
       }
       if (makeInput == 1) {
   
		  
             char cesta[255] = "C:\\SPLM\\Apps\\PDFCreate\\vstup\\";
			 //printf (" poradi%d \n",poradi_dokumentu);
             strcat(cesta, tmp_poradi);
			// strcat(cesta,id);//
             strcat(cesta, ".tpv");
             out = fopen(cesta, "a+");
			 fprintf(out,"poradi %s \n",tmp_poradi);
			 fclose(out);
     
       }
             
				
	   tag_t *lines;
       tag_t line;
       int childCount;
       BOM_line_ask_child_lines(bomLine, &childCount, &lines);

       for(int i = 0; i < childCount; i++) {
             line = lines[i];
             FirstPdf(line, level + 1);
       }
}



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


char* ConvertInt2String(byte i)
{
	char str[5];
	//memcpy(str,i,sizeof(i));
	int tmp_i;
	//tmp_i=(int)i;
	//sprintf(str,"%d",i);
	//memcpy(str,i,sizeof(i));
	//printf("str %s \n",str);
	return str;
}

void pdf2TC (char * cisloZakazky,char *Id,tag_t Item,tag_t Rev)
{
	
	char fileName[20]=" ";
	char way [100]=" ";
	char* revize;
	char dataset_name[30]=" ";
	
	tag_t dataset;
	AOM_ask_value_string(Rev,"item_revision_id",&revize);
	//strcat(way,fileName);	
	system ("ren C:\\SPLM\\Apps\\PDFCreate\\vystup\\*.* *.");
	char rename [100]="ren C:\\SPLM\\Apps\\PDFCreate\\vystup\\*. *_";
	strcat(rename,revize);
	strcat(rename,".pdf");
	system(rename);
	system ("copy C:\\SPLM\\Apps\\PDFCreate\\vystup\\* \\\\srvtcbase\\TcESO_vymena\\PDF\\*");
	for(int i=1;i<8;i++)
	{
			
		AOM_ask_value_string(Rev,"item_revision_id",&revize);
		strcpy(fileName,cisloZakazky);
		
		char xcopy_pdf[50];
		char ycopy_pdf[50];
		strcpy(xcopy_pdf,"copy ");
		strcpy(ycopy_pdf,"copy ");
	
		char num [2]="";
		//char pdfName [20];
		char pdf_dir[50];
		switch(i)
		{
		
			
		case 2:
			sprintf(num,"-Info");
			break;
		case 3:
			sprintf(num,"-Kooperace");
			break;
		case 4:
			sprintf(num,"-Sestavy");
			break;
		case 5:
			sprintf(num,"-Laser");
			break;
		case 6:
			sprintf(num,"-Deleni");
			break;
		case 7:
			sprintf(num,"-KooK2");
			break;
		}

		strcat(fileName,num);
		strcpy(dataset_name,fileName);
		strcat(dataset_name,"_");
		strcat(dataset_name,revize);

		

	/*	strcat(xcopy_pdf,"C:\\SPLM\\Apps\\PDFCreate\\vystup\\");
		strcat(xcopy_pdf,fileName);
		strcat(xcopy_pdf," ");

		strcat(ycopy_pdf,"C:\\SPLM\\Apps\\PDFCreate\\vystup\\");
		strcat(ycopy_pdf,fileName);
		strcat(ycopy_pdf," ");

		strcpy(pdf_dir,"\\\\srvtcbase\\TcESO_vymena\\PDF\\");
		strcat(pdf_dir,cisloZakazky);	
		strcat(pdf_dir,num);
		strcat(pdf_dir,".pdf");

		strcat(xcopy_pdf,pdf_dir);
		printf("xcopy_pdf:\n %s \n_____\n",xcopy_pdf);
		system(xcopy_pdf);
	
		strcat(ycopy_pdf,"C:\\PDF\\");
		strcat(ycopy_pdf,fileName);
		system(ycopy_pdf);
		printf("ycopy_pdf:\n %s \n_____\n",ycopy_pdf);*/
		//printf("630 file %s \n way %s \n",fileName,way);
		//strcpy (pdfName,fileName);
		//strcat(pdfName,num);
		create_dataset("PDF", dataset_name, Item,  Rev, &dataset);

		strcpy(way,"C:\\SPLM\\Apps\\PDFCreate\\vystup\\");
		strcat(dataset_name,".pdf ");
		strcat(way,dataset_name);

		printf("\n  fileName= %s \n",fileName);
		importDatates(dataset,way,"PDF_Reference",dataset_name);
		//printf("end import dataset num %s\n",num);
		//printf("rmdir C:\\SPLM\\Apps\\PDFCreate\\vstup /S /Q\n");
		/*char rename [100]="ren C:\\SPLM\\Apps\\PDFCreate\\vystup\\";
		strcat(rename,fileName);
		strcat(rename," C:\\SPLM\\Apps\\PDFCreate\\vystup\\");
		strcat(rename,dataset_name);
		strcat(rename,".pdf");*/

	}
	printf("end import \n");
	system ("copy C:\\SPLM\\Apps\\PDFCreate\\vystup\\* C:\\PDF\\*");
	//printf("end pdf2TC \n");

	//if (dataset)MEM_free(dataset);
}
void CallTranslate(char *zakazka)
{

	char call [50]="call C:\\SPLM\\Apps\\PDFCreate\\run.bat ";
	strcat(call,zakazka);
	  // printf("Call JAVA \n");
	   system(call);
	   
	   //system(" oz2");

}
int TPV_MAKE_PDF(EPM_action_message_t msg) //Main 
{
	printf("---------Preklad PDF ---------\n");
       // Prolistovat itemy - zjistit ID a typ

       tag_t *revs,
		   item;
       int itemCount;
	   date_t datum;
       char itemId[ITEM_id_size_c + 1];
	   char termin[20];
	   tag_t RootTask,
		   RevisionClassTag,
		   job;

	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
	
	//system("rmdir C:\\SPLM\\Apps\\PDFCreate\\vstup /S /Q");
	//system("rmdir C:\\SPLM\\Apps\\PDFCreate\\vystup /S /Q");
	system("mkdir C:\\PDF");
	system("mkdir C:\\SPLM\\Apps\\PDFCreate\\vstup");
	system("mkdir C:\\SPLM\\Apps\\PDFCreate\\vystup");
	system("copy \"C:\\SPLM\\Apps\\PDFCreate\\pa3.pdf\" \"C:\\SPLM\\Apps\\PDFCreate\\vstup\\pa3.pdf\"");
	system("copy \"C:\\SPLM\\Apps\\PDFCreate\\pa4.pdf\" \"C:\\SPLM\\Apps\\PDFCreate\\vstup\\pa4.pdf\"");
	POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);
	
	//	FILE *log;
	//char logpath[30];
	//strcpy(logpath,"C:\\Temp\\pdf_make");

	//strcat(logpath,".log");

	//log=fopen(logpath,"a+");
	
		
    EPM_ask_attachments( RootTask,EPM_target_attachment, &itemCount, &revs );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"


	//AOM_ask_value_string(items[0],"item_id",&file);
	//AOM_ask_value_string(items[0],"item_revision_id",&RevId);
		
//	fprintf(log,"Ziskany id vrcholu \n");	//pro logovani
	//printf("Zakazka %d  \n",itemCount);

	      // Mame zakazku - zjistit posledni revizi
       tag_t *bvrs;
       tag_t bvr;
       int bvrsCount;
	   char *type;

	  // printf ("Count %d \n",itemCount);
for( int j = 0; j < itemCount; j ++ )
{
	
	AOM_ask_value_string(revs[j],"object_type",&type);
	if(strcmp (type,"TPV4_zakazkaRevision")==0)
	{
		//AOM_ask_value_date(revs[j],"tpv4_termin_zadani",&datum);
		//sprintf(termin,"%d.%d.%d",datum.day,datum.month,datum.year);
		strcpy(termin,time_stamp());
		AOM_ask_value_string(revs[j],"object_name",&cisloZakazky);
		
		//
		//byte test;
		//ConvertInt2String(datum.day);
		//strcpy(termin,datum.day);
		//strcat(termin,"\.");
	//	strcat(termin,ConvertInt2String(datum.month));
		//strcat(termin,"\.");
		//strcat(termin,ConvertInt2String(datum.year));
		//printf("termin %s \n",termin);
		char *item_id;
		   ITEM_rev_list_bom_view_revs(revs[j], &bvrsCount, &bvrs);
		   ITEM_ask_item_of_rev(revs[j], &item);
		   ITEM_ask_id2(item,&item_id);
		  // strcpy(cisloZakazky,item_id);//pro item_id
		 //  printf("S revizi je spojeno %i objektu \n", bvrsCount);

		   tag_t bomWindow;
		   tag_t bomTopLine;

		   // Prochazim pripojene objekty
		   // Kazdym objektem by mela byt vrcholova polozka zakazky
		   for (int i = 0; i < bvrsCount; i++) {
				 bvr = bvrs[i];
				 BOM_create_window(&bomWindow);
				 BOM_set_window_top_line(bomWindow, NULLTAG, revs[j], bvr, &bomTopLine);
             
				 listBom(bomTopLine, 0, 1,termin,"nevyplneno");
				 poradi_dokumentu=0;
			/*	 FirstPdf (bomTopLine,0);
				 poradi_dokumentu=0;*/
				 AOM_save(bomWindow);
		   }

		   CallTranslate(cisloZakazky);
		   pdf2TC (cisloZakazky, item_id, item,  revs[j]);
		//system("C:\\SPLM\\Apps\\PDFCreate\\STSGenVyrDok.jar 10");
		//fclose(log);
		printf(" End of prekladPDF \n");
	
	}
  }
   // if(item) MEM_free(item);
	if(revs) MEM_free(revs);
		printf("%d \n",__LINE__);
	if(bvrs) MEM_free(bvrs);      
		printf("%d \n",__LINE__);
	system("rmdir C:\\SPLM\\Apps\\PDFCreate\\vstup /S /Q");
	system("rmdir C:\\SPLM\\Apps\\PDFCreate\\vystup /S /Q");
    return ITK_ok;
}