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
<<<<<<< Updated upstream
#include <ae\ae.h>
#include <tccore\grm.h>
#include <unidefs.h>
#include <errno.h>
<<<<<<< Updated upstream
=======
#include <time.h>
=======
>>>>>>> Stashed changes
>>>>>>> Stashed changes

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Call_Exe_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Call_Exe_TC11_init_module(int *decision, va_list args);
int TPV_Call_Exe(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);
int ListBomLine(tag_t BomLine, int Level, int decision, char* ItemId);
extern "C" DLLAPI int TPV_Call_Exe_TC11_register_callbacks()
{
    printf("Registruji TPV_Call_Exe_TC11.dll\n");
    CUSTOM_register_exit("TPV_Call_Exe_TC11", "USER_init_module", TPV_Call_Exe_TC11_init_module);

    return ITK_ok;
}
<<<<<<< Updated upstream
static void report_error_stack()
{
    int n_errors = 0;
    const int *severities = NULL;
    const int *error_code = NULL;
    const char **msg;
    int ii = 0;
    EMH_ask_errors(&n_errors, &severities, &error_code, &msg);
    printf("\n n_errors: %d \n", n_errors);
    for (ii = n_errors - 1; ii >= 0  ; ii--)
    {
        if (severities[ii] == EMH_severity_information) 
            printf("    Information - error_code[%d]: %d - msg[%d]: %s\n", 
                ii, error_code[ii],ii, msg[ii]);
        if (severities[ii] == EMH_severity_warning) 
            printf("    Warning - error_code[%d]: %d - msg[%d]: %s\n", 
                ii, error_code[ii],ii, msg[ii]);                
        if (severities[ii] == EMH_severity_error) 
            printf("    Error - error_code[%d]: %d - msg[%d]: %s\n", 
            ii, error_code[ii],ii, msg[ii]);
    }
}

size_t iso8859_1_to_utf8(char *content, size_t max_size)
{
    char *src, *dst;

    //first run to see if there's enough space for the new bytes
    for (src = dst = content; *src; src++, dst++)
    {
        if (*src & 0x80)
        {
            // If the high bit is set in the ISO-8859-1 representation, then
            // the UTF-8 representation requires two bytes (one more than usual).
            ++dst;
        }
    }

    if (dst - content + 1 > max_size)
    {
        // Inform caller of the space required
        return dst - content + 1;
    }

    *(dst + 1) = '\0';
    while (dst > src)
    {
        if (*src & 0x80)
        {
            *dst-- = 0x80 | (*src & 0x3f);                     // trailing byte
            *dst-- = 0xc0 | (*((unsigned char *)src--) >> 6);  // leading byte
        }
        else
        {
            *dst-- = *src--;
        }
    }
    return 0;  // SUCCESS
}

void Report_import(EPM_action_message_t msg, tag_t condition_task)
{
	char info [2048];


	strcpy(info," ");
char* log="C:\\SPLM\\Apps\\Export\\log_imp.txt";
   FILE* stream = fopen(log, "r");
		printf("Open %s\n",log);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		strcat(info,line);
		
	}
	
	//iso8859_1_to_utf8(info, 2048);
	printf("info: %s \n ",info);
	//int ifail = EPM_set_task_result(msg.task, EPM_RESULT_True);
 //       if (ifail != ITK_ok) { /* your error logic here */ }
        
        //ifail = EPM_trigger_action(condition_task, EPM_complete_action, "");
        //if (ifail != ITK_ok) { /* your error logic here */ }
        	
=======
>>>>>>> Stashed changes

extern "C" DLLAPI int TPV_Call_Exe_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Call_Exe", "", TPV_Call_Exe);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Call_Exe");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}



int TPV_Call_Exe(EPM_action_message_t msg)
{

<<<<<<< Updated upstream
	return 0;
}

void GetProperty (int polozka_num,int num,tag_t object,char** value)
{
	if(strcmp(Attr_type[polozka_num][num],"<string")==0)
	{
		//value=OpravCz(value);
		int IERROR=AOM_ask_value_string(object,Attr[polozka_num][num],&*value);
		printf ("\n Err %d string attr %s \n value %s \n",IERROR,Attr[polozka_num][num],*value);
	}else if(strcmp(Attr_type[polozka_num][num],"<item_string")==0)
	{
		tag_t Item;
		ITEM_ask_item_of_rev(object,&Item);
		//value=OpravCz(value);
		int IERROR=AOM_ask_value_string(Item,Attr[polozka_num][num],&*value);
		printf ("\n Err %d string attr %s \n value %s \n",IERROR,Attr[polozka_num][num],*value);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<int")==0)
	{
		int tmp_int=0;
		AOM_get_value_int(object,Attr[polozka_num][num],&tmp_int);
		sprintf(*value,"%s",tmp_int);
		printf ("int .....%d = %s \n",tmp_int,value);
		//printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		//if(strcpy(value," ")!=0)
			
	}
	else if(strcmp(Attr_type[polozka_num][num],"<double")==0)
	{
		double tmp_double=0;
		AOM_get_value_double(object,Attr[polozka_num][num],&tmp_double);
		sprintf(*value,"%s",tmp_double);
		printf ("double.....%f = %s \n",tmp_double,value );
		//if(strcpy(value," ")!=0)
			
	}
	else if(strcmp(Attr_type[polozka_num][num],"<noread")==0)
		printf ("--nic\n");

	//}
	else if(strcmp(Attr_type[polozka_num][num],"<set_string")==0)
	{ 
		//char* tmp_text;
		
		int IERROR=AOM_set_value_string(object,attr_set[polozka_num],value_set[polozka_num]);
		printf ("Err %d string attr %s   %s \n",IERROR,attr_set[polozka_num],value_set[polozka_num]);
	}
}

static tag_t ask_item_revision_from_bom_line(tag_t bom_line)
{
    tag_t
        item_revision = NULLTAG;
    char 
        *item_id = NULL,
        *rev_id = NULL;
    
    AOM_ask_value_string(bom_line, "bl_item_item_id", &item_id );
    AOM_ask_value_string(bom_line, "bl_rev_item_revision_id", &rev_id);
    ITEM_find_rev(item_id, rev_id, &item_revision);
    
    if (item_id) MEM_free(item_id);
    if (rev_id) MEM_free(rev_id);
    return item_revision;
}


void downloadDataset(tag_t rev,char* I_ID, int poradi, char* typ, char* ID_v)
{
	 int ifail = ITK_ok;
	  int ii = 0;
    tag_t root_task = NULLTAG;
    int n_attachs = 0;
    tag_t* attachs = NULL;
    tag_t rev_tag = NULLTAG;
    tag_t relation_type_tag = NULLTAG;
    int n_specs = 0;
    tag_t* specs = NULL;
    char type_name[TCTYPE_name_size_c+1] = "";
    tag_t type_tag = NULLTAG;
    int n_refs = 0;
    tag_t* refs = NULL;
	char ID_new[30],
		*ID_Rev;
	strcpy(ID_new,I_ID);
	//char cesta[50]="\\\\10.1.1.8\\vymena_dat_free\\ComTC_TPV\\pdf_TC\\";
	char cesta[100]="\\\\files.pos.local\\prevodni_mustek_TPV_a_TC\\SRVTEST\\";
	printf("I_ID %s \n",I_ID);
	for (int k =0;k<strlen(ID_new);k++)
		if(ID_new[k]==' ')
			ID_new[k]='_';

	int err=AOM_ask_value_string(rev,"item_revision_id",&ID_Rev);

	ifail = GRM_find_relation_type("IMAN_Rendering", &relation_type_tag);	
    if (ifail != ITK_ok) { /* your error logic here */ }
	//if (n_specs==0)
	//{
	//	ifail = GRM_find_relation_type("IMAN_specification", &relation_type_tag);
	//	if (ifail != ITK_ok) { /* your error logic here */ }
	//}
	ifail = GRM_list_secondary_objects_only(rev, relation_type_tag, &n_specs, &specs);
    if (ifail != ITK_ok) { /* your error logic here */ }
    printf("pocet datasetu %d\n",n_specs);

    for (ii = 0; ii < n_specs; ii++)
    {
        ifail = TCTYPE_ask_object_type (specs[ii], &type_tag);
        if (ifail != ITK_ok) { /* your error logic here */ }
        
        ifail = TCTYPE_ask_name(type_tag, type_name);
        if (ifail != ITK_ok) { /* your error logic here */ }
		printf("Typ polozky %s \n",type_name);
      
			
		if(strcmp(typ,"pdf")==0)
		{
			printf("-----typ ok\n");
			  if (strcmp(type_name, "PDF") == 0)
			  {
				 
			//	  printf("-----typ_name ok\n");
				ifail = AE_ask_all_dataset_named_refs(specs[ii], "PDF_Reference", &n_refs, &refs);
			//	printf("Reference %d \n",n_refs);

				if (ifail != ITK_ok) { printf("chyba v dotazu na dataset\n"); }
				else printf(" ok export\n");
        //  printf("1Cesta %s \n",cesta);
			strcat(cesta,ID_new);
		//	printf("2Cesta %s \n",cesta);
			strcat(cesta,"_");
		//	printf("3Cesta %s delka %d\ %s n",cesta,strlen(cesta),ID_Rev);
			strcat(cesta,ID_Rev);
		//	printf("4Cesta %s \n",cesta);
			strcat(cesta,".");
		//	printf("5Cesta %s \n",cesta);
			strcat(cesta,typ);
		//	printf("6Cesta %s \n",cesta);
			strcpy(Nazvy[poradi][5],cesta);
		//	printf("7cesta %s poradi %d\n",Nazvy[poradi][5],poradi);
			if(SouborExistuje(cesta)==1)
			{
				ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
				if (ifail != ITK_ok) { printf("Nefunguje export \n");}
			}
			  }
			  }

}
}
int  Add_material(char* id_polozky,int *poradi,char* id_rodice,char* obj_name,char* pozice)
{
		char  cislo[5];
		printf("poradi %d \n",*poradi);
		sprintf(cislo,"%d",*poradi);

	//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);
=======
    tag_t

		RootTask=NULLTAG;
	char *Argument=nullptr;
	char*Flag = nullptr;
	char*Value = nullptr;
	char Vlastnost [20]; 
>>>>>>> Stashed changes

	int ArgumentCount=TC_number_of_arguments(msg.arguments);

	while (ArgumentCount --> 0)
	{
<<<<<<< Updated upstream

		printf("------------------read Attr ------------------\n");
		int AttributeId=0;
	char* tmp;
	char id [20];
	//double Hmotnost;
	char* TypItemu;
	//tag_t Item;

	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_norma#tpv4_typ_polozky#tpv4_hmotnost
	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv
	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#klic#zmena#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv#tpv4_stav#ID_TC
	
	//printf ("test305 %s \n",ID_v);
		//strcpy(Nazvy[poradi][0],I_ID_v);
		strcpy(Nazvy[poradi][0],ID_v);
		//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		tag_t Item;
		ITEM_ask_item_of_rev(Rev,&Item);

		
		AOM_ask_value_string(Item,"object_name",&tmp);
		
		//GetProperty (0,2,Item,&tmp);
		strcpy(Nazvy[poradi][2],tmp);//nazev
		printf("Type %s \n",Nazvy[poradi][2]);
		AOM_ask_value_string(Item,"item_id",&tmp);
		strcpy(id,tmp);
		strcat(id,"/");
		AOM_ask_value_string(Rev,"item_revision_id", &tmp);
		strcpy(Nazvy[poradi][3],tmp);//revize
		strcat(id,tmp);
		strcpy(Nazvy[poradi][16],id);//ID_TC
		AOM_ask_value_string(Rev,"tpv4_zmena",&tmp);

		printf("\\\n pozice %s \n\\",tmp);
		int tmp_pozice=atoi(pozice);
		if(tmp_pozice<3000)	tmp_pozice=tmp_pozice/10;
		printf("pozice %d \n",tmp_pozice);
		sprintf(Nazvy[poradi][10],"%d",tmp_pozice);
		//strcpy(Nazvy[poradi][10],pozice);//pozice

		printf("\\\n zmena %s \n\\",tmp);
		strcpy(Nazvy[poradi][9],tmp);//zmena
		
		AOM_ask_value_string(Rev,"tpv4_skupina",&tmp);
		strcpy(Nazvy[poradi][17],tmp);//skupina
		//printf("item_rev %s \n",Nazvy[poradi][3]);
		
	
	
			strcpy(Nazvy[poradi][4],mnozstvi);//mnozstvi

		printf("mnozstvi %s \n",Nazvy[poradi][4]);

		AOM_ask_value_string(Rev,"object_type",&TypItemu);
	//	printf("--------Type %s %d-------\n",TypItemu,strcmp(TypItemu,"TPV4_nak_dilRevision"));

		 if(strcmp(TypItemu,"TPV4_nak_dilRevision")==0)
		{
			printf("----nak_dil ----\n");
			strcpy(Nazvy[poradi][7],"N");
		//int id_polozky=0;
		//char* id_polozky_str;
		char* obj_name;
		char* cislo_vykresu;
		AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&cislo_vykresu);
		if(strlen(cislo_vykresu)>2)	strcpy(Nazvy[poradi][1],cislo_vykresu);//cislo vykresu
			else goto prazdny;
		//	AOM_get_value_int(Rev,"tpv4_klic_tpv_np",&id_polozky);
		//	sprintf(Nazvy[poradi][6],"%d",id_polozky);
			//strcpy(Nazvy[poradi][6],id_polozky_str);
			//if(id_polozky==0)
				//strcpy(Nazvy[poradi][6]," ");
			strcpy(Nazvy[poradi][15],"VYR");
			AOM_ask_value_string(Rev,"tpv4_nazev_np",&obj_name);
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_np",&cislo_vykresu);
			strcpy(Nazvy[poradi][6],cislo_vykresu);
			if(strlen(cislo_vykresu)==0)
				strcpy(Nazvy[poradi][6]," ");

			strcpy(Nazvy[poradi][1],tmp);//typ
			//printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		// poradi++;
		
			
		 Add_material(cislo_vykresu,&poradi,ID_v,obj_name,Nazvy[poradi][10]);
		
		}else if(strcmp(TypItemu,"TPV4_nak_polRevision")==0 || strcmp(TypItemu,"TPV4_h_materialRevision")==0)
		 {
			 printf("_____Nakupovana polozka_______\n");
			 
			 strcpy(Nazvy[poradi][15],"VYR");
			 char* id_polozky;
			 AOM_ask_value_string(Item,"tpv4_nomenklatura",&id_polozky);
			 strcpy(Nazvy[poradi][7],"N");
			 strcpy(Nazvy[poradi][1],id_polozky);//typ
		}
		else if(strcmp(TypItemu,"TPV4_dilRevision")==0)
		{
			printf("export dil \n");
		
			
			
			//typ dílce 
		/*tag_t *Boms;
		int BomsCount=0;
		ITEM_rev_list_bom_view_revs(Rev, &BomsCount, &Boms);
		if ( BomsCount==0)
		{
			strcpy(Nazvy[poradi][7],"D");
			
		}else
			strcpy(Nazvy[poradi][7],"F");
		*/
		int sestava=IsTypeInRelation(Rev, "IMAN_specification","SWAsm");
		if(sestava)
		{
			strcpy(Nazvy[poradi][7],"F");
		}
		else 
			strcpy(Nazvy[poradi][7],"D");
		//printf("test359\n");
	

		//printf("test372\n");
		AOM_ask_value_string(Rev,"tpv4_polotovar",&tmp);
		
		strncpy(Nazvy[poradi][11],tmp,20);
		
		//printf("test377\n");
		AOM_ask_value_string(Rev,"tpv4_material",&tmp);

		strcpy(Nazvy[poradi][12],tmp);

		//hmotnst
		char *hmotnost;
		AOM_ask_value_string(Rev,"tpv4_hmotnost",&hmotnost);	
		if(strcmp(hmotnost,"-")==0)
			strcpy(Nazvy[poradi][13]," ");
		else
			strcpy(Nazvy[poradi][13],hmotnost);
		//poznamka
		char *poznamka;
		AOM_ask_value_string(Rev,"tpv4_poznamka_tpv",&poznamka);
		strcpy(Nazvy[poradi][14],poznamka);
		//cislo vykresu//
		char* cislo_vykresu;
		AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&cislo_vykresu);
			if(strlen(cislo_vykresu)>2)	strcpy(Nazvy[poradi][1],cislo_vykresu);//cislo vykresu
			else goto prazdny;
			///STAV//
		char* stav;
		AOM_ask_value_string(Rev,"tpv4_stav",&stav);
		printf ("stav %s \n",stav);
		if(strcmp(stav,"OVEROVACI SERIE")==0||strcmp(stav,"OS")==0)
			strcpy(Nazvy[poradi][15],"OS");
		else if(strcmp(stav,"ZAKAZKA")==0||strcmp(stav,"ZAK")==0)
			strcpy(Nazvy[poradi][15],"ZAK");//tpv4_stav
		else
			strcpy(Nazvy[poradi][15],"VYR");//tpv4_stav
		
		if(strcmp(Nazvy[poradi][7],"D")==0)
		{
		int id_polozky=0;
		char* id_polozky_str;
		char* obj_name;
		char* cislo_vykresu_hm;
			AOM_get_value_int(Rev,"tpv4_klic_tpv_hm",&id_polozky);
			sprintf(Nazvy[poradi][8],"%d",id_polozky);
			//strcpy(Nazvy[poradi][6],id_polozky_str);
			//if(id_polozky==0)
				strcpy(Nazvy[poradi][6]," ");
			AOM_ask_value_string(Rev,"tpv4_nazev_hm",&obj_name);
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_hm",&cislo_vykresu_hm);
			
			if(strlen(cislo_vykresu)==0)
				strcpy(Nazvy[poradi][6]," ");
		if(strlen(cislo_vykresu_hm)>1)		
		{
			poradi++;
			Add_material(cislo_vykresu_hm,&poradi,cislo_vykresu,obj_name,"3000");
			strcpy(Nazvy[poradi][6],cislo_vykresu_hm);
		}
		//	printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		//poradi++;
		
		// Add_material(cislo_vykresu,&poradi,tmp,obj_name);
		}
		}
		poradi++;
		prazdny:;
		printf("konec\n ___________\n");
	return poradi;
}

int ListBomLine(tag_t BomLine, int Level, tag_t pamet[], int poradi,tag_t BomWindow,int Strom [6][4])
{
	//double hm=0;
	int pole[50][10];
	pole[25][5]=255;
	int plus=0;
	char* I_ID,
		*REV_ID,
		*I_ID_v;
	printf("--------- ListBomLine------------\n");
	//int Strom[6][3];

	printf("start Level = %d poradi %d \n", Level, poradi);
		
	pamet[Level]=BomLine;
	//printf (" tak bom line %d \n",BomLine);
	//char hm [20];
	int AttributeId;
	tag_t Rev = NULLTAG;
	char* SEAR = NULLTAG;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(pamet[Level], AttributeId, &Rev);
		BOM_line_look_up_attribute("bl_TPV4_itm_dil_pomRevision_tpv4_cislo_vykresu", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &I_ID_v);
		printf(">>>362>>>>Parent %s\n",I_ID_v);

						//printf("hmotnost dilu %f \n",Hmotnost);
					//	char *tmp;
	if( Level==0)
	{
		downloadDataset(Rev,I_ID_v,0,"pdf"," ");
		poradi=ReadAttr(Rev,poradi,"","1","1");
		//readAttr(BomLine, Rev, poradi,"");
		//strcpy(Nazvy[poradi][7],tmp);
		
		

					char tmpName[128];
			strcpy(tmpName,I_ID_v);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi][3]);
			printf("tmpName %s \n",tmpName);
	}
	

    // Potomci
	//printf(">>>>>388>>Parent %s\n",I_ID_v);
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	char* tmpQuant;
	char Quant[24];
	char* findNo;
	tag_t RevOld=NULLTAG,
		RevNew=NULLTAG;

	for(int t=0;t<ChildsCount;t++)
	{
		for(int j=0;j<t;j++)
		{
		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[t], AttributeId, &RevOld);
		BOM_line_ask_attribute_tag(Childs[j], AttributeId, &RevNew);
			if(RevOld==RevNew)
			{
				printf("Rev's se rovnaji\n");
			//	char* tmpQuant;
				BOM_line_look_up_attribute("bl_quantity", &AttributeId);
				BOM_line_ask_attribute_string(BomLine, AttributeId, &tmpQuant);
				if (strcmp(tmpQuant,"")==0)
					strcpy(Quant,"1");
				else strcpy(Quant,tmpQuant);

				int dif=t-j;

				int NewQuant =atoi(tmpQuant)+atoi(Nazvy[poradi-dif][4]);//mnozstvi
				sprintf(Nazvy[poradi-dif][4],"%d", NewQuant);
				goto next;
			}
		}


			//poradi=poradi+1;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[t], AttributeId, &Rev);

		BOM_line_look_up_attribute("bl_sequence_no", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &findNo);

		BOM_line_look_up_attribute("bl_quantity", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &tmpQuant);
		printf("%d>>>>tmpQuant %s \n",poradi,tmpQuant);
				if (strcmp(tmpQuant,"")==0)
					strcpy(Quant,"1");
				else strcpy(Quant,tmpQuant);
		printf("%d>>>>Quant %s \n",poradi,Quant);
		poradi=ReadAttr(Rev,poradi,I_ID_v,Quant,findNo);
		//strcpy(Nazvy[poradi][7],tmp);
			char tmpName[128];
			strcpy(tmpName,Nazvy[poradi-1][1]);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi-1][3]);
		//	printf("tmpName %s \n",tmpName);
		
		downloadDataset(Rev,Nazvy[poradi-1][1],poradi-1,"pdf"," ");
	//	printf("Poradi %d Vrchol %s Dil %s Rev %s \n",poradi,I_ID_v,I_ID,REV_ID);
		next:;
=======
		Argument = TC_next_argument( msg.arguments );
		ITK_ask_argument_named_value( ( const char* ) Argument, &Flag, &Value );
		printf("%s \n %s \n %s \n",Argument, &Flag, &Value );
		if( strcmp ( "cesta", Flag ) == 0 && Value != nullptr) //"C:\\SPLM\\TC\\bin\\VyplnND.exe"
		{
// …
			printf("value property %s \n",Value);
			strcpy(Vlastnost,Value);
		}
		if( strcmp ( "call_bat", Flag ) == 0 && Value != nullptr) //"C:\\SPLM\\TC\\bin\\VyplnND.exe"
		{
// …
			printf("value property %s \n",Value);
			strcpy(Vlastnost,"call ");
			strcat(Vlastnost,Value);
		}
>>>>>>> Stashed changes
	}
	printf("%s \n",Vlastnost);

<<<<<<< Updated upstream
	//printf("Count %d \n", ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)
	{	
	
		poradi=ListBomLine(Childs[k], Level + 1, pamet, poradi, BomWindow,Strom);
		
	}
	printf(" pred koncem poradi %d\n",poradi);
	
	return poradi;
}

char* create_marks_csv(char *filename,int m,int n){
 
printf("\n Creating %s.csv file \n",filename);
 
FILE *fp;
 
int i,j;
 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\Export\\csv\\");
 strcat(file,filename);
//printf("test1 \n");
 strcat(file,".csv");
 //printf("file %s \n",file);



fp=fopen(file,"w");
 printf("test po zaèátku zápisu %d \n",fp);
//fprintf(fp,attr);
 
for(i=0;i<m;i++)
{
	printf ("fprint %d \n",i);
	if(i==0)
		fprintf(fp,"poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#klic#zmena#pozice#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv#tpv4_stav#ID_TC#tpv4_skupina#klic_maxu\n%d",i);
					
	else
	{
		fprintf(fp,"\n%d",i);
	}
			for(j=0;j<=n;j++)
			{
				fprintf(fp,"#%s",Nazvy[i][j]);	
				printf("# %s",Nazvy[i][j]);
			}
			fprintf(fp,"#0000000");	
}
    //fprintf(fp,"\n%d",i+1);
fclose(fp);
 
printf("\n file created - %s \n",file);
 return file;
}
void CallBridge(char* file)
{	char help [50];
	strcpy(help,file);
	printf("file %s \n",help);
	//char ImportTPV[256]="C:\\TC4TPV\\TCCom\\TCCom.jar \"";
	char ImportTPV[256]="call C:\\SPLM\\Apps\\Export\\TC2TPV.bat \"C:\\SPLM\\Apps\\Export\\csv\\";
	strcat(ImportTPV,help);
	strcat(ImportTPV,".csv");
	strcat(ImportTPV,"\"");
	//printf("%s \n",ImportTPV);
	system(ImportTPV);

//	system("call C:\\TC4TPV\\TCCom\\run.bat");
	 printf("%s\n",ImportTPV);
	//system("call TC2TPV.bat");
}
void Cisteni()
{
	for (int i=0;i<100;i++)
		for(int j=0;j<20;j++)
			strcpy(Nazvy[i][j],"");
}


int TPV_TC2TPV(EPM_action_message_t msg)
{
	Cisteni();
	//ReadProperty();
     int
        TargetsCount = 0,
		countBVR = 0,
		n_parent=0,
		nejvetsi=0,
		otec=0,		
		BomsCount = 0,
		prepinac=0,
        ii = 0;
		
    tag_t
        *Targets = NULL,
		Rev=NULLTAG,
        class_tag = NULLTAG,
		*bvrs=NULL,
		BomWindowStredisko=NULLTAG,
		*Boms = NULLTAG,
		job=NULLTAG,
		parents=NULLTAG,
		parents_rev=NULLTAG,
		
	
		
		RootTask=NULLTAG;
    char  
        file_name[WSO_name_size_c+2] = "",
        *class_name = NULL,
		*Id=NULL,
		*RevId=NULL,
		//*Process_name,
		//*job_name,		
		
		*Pname="ren ",
        description[WSO_desc_size_c+1]  = "";
		tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
	
    EPM_decision_t
        //decision=EPM_undecided ;
		decision=EPM_nogo ;
=======
>>>>>>> Stashed changes
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;

<<<<<<< Updated upstream
printf("test0 \n");		
		//FILE *log;
	char logpath[30];
	//strcpy(logpath,"C:\\Temp\\export");
	//strcat(logpath,job_name);
	strcat(logpath,".log");
	//printf("log --- %s \n",logpath);
	//log=fopen(logpath,"a+");
	
		
	//	AOM_UIF_ask_value(job,"object_name",&job_name);
	//for (int k =0;k<strlen(job_name);k++)
	//{
	//	if(job_name[k]=='/')job_name[k]='_';

	//}
		
	//	printf("\n \n source folder %s \n",Input);
		
    EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
	char* file;
		printf ("target count %d\n", TargetsCount);
	AOM_ask_value_string(Targets[0],"item_id",&file);
	AOM_ask_value_string(Targets[0],"item_revision_id",&RevId);
		
	//fprintf(log,"Ziskany id vrcholu \n");	
	//for (int k =0;k<strlen(file);k++)
	//{
	//	if(file[k]==' ')job_name[k]='_';

	//}
	printf("count %d \n",TargetsCount);
for( int i = 0; i < TargetsCount; i ++ )
{
	tag_t TargetClassTag = NULLTAG;
	POM_class_of_instance(Targets[i], &TargetClassTag);
	printf("test1 \n");	
	logical IsRevision = false;
	POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);
	printf("test2 \n");	
	if(IsRevision == false) continue;
		char *Type;
	      
			// BOM window
			
			tag_t pamet[100];
            tag_t BomWindow = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;
			int poradi=0,
			 Strom[6000][4];
				
			//fprintf(log,"Otevreni kusovniku \n");
			printf("Otevreni kusovniku \n");	
	for(int l=0;l<6;l++){
		for (int p=0;p<3;p++){
			Strom [l][p]=0;
		}
	}

		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
		
		printf ("%s\n",Type);
		int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
			
		//fprintf(log,"pocet kusovniku %d\n",BomsCount);	
		if (BomsCount==0)
		{
			
			poradi =ReadAttr(Targets[i], i," ","1","10");
			printf("Nazvy 1 %s Rev %d poradi %d\n",Nazvy[i][1],Targets[i],poradi);
			downloadDataset(Targets[i],Nazvy[i][1],poradi-1,"pdf"," ");
			
		//	fprintf(log,"stazeny datasety pouze pro tento dilec\n");
		}
        for(int j = 0; j < BomsCount; j++)
        {

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom);
			
			//BOM_refresh_window(BOM
        }
		
		//fprintf(log,"Zpracovano kusovniku \n");
		for (int k =0;k<strlen(file);k++)
			if(file[k]==' ')file[k]='_';
		strcpy(file_name,file);
		strcat(file_name,"_");
		strcat(file_name,RevId);
		create_marks_csv(file_name,poradi,17);
		//fprintf(log,"Spusteni importu do TPV \n");
		//CallBridge(file_name);
		CallBridge(file_name);
		//fprintf(log,"Dokonceno \n \n");
		//Delprilohy (poradi);
}

//	fclose(log);
	Report_import( msg,RootTask);
<<<<<<< Updated upstream
=======

	SAFE_MEM_FREE(Targets);
	SAFE_MEM_FREE(Boms);
	SAFE_MEM_FREE(RevId);

=======
//	EPM_ask_root_task ( msg.task, &RootTask );

        system(Vlastnost);



>>>>>>> Stashed changes
>>>>>>> Stashed changes
    return ITK_ok;
<<<<<<< Updated upstream
}
//zmena jednotek 
static void modify_unit_of_measure_of_item(tag_t item_tag, tag_t uom_tag)
{
	tag_t attr_id_tag = NULLTAG;
	IFERR_ABORT(POM_attr_id_of_attr("uom_tag", "Item", &attr_id_tag));
	IFERR_ABORT(POM_refresh_instances(1, &item_tag, NULLTAG, POM_modify_lock));
	IFERR_ABORT(POM_set_attr_tag(1, &item_tag, attr_id_tag, uom_tag));
	IFERR_ABORT(POM_save_instances(1, &item_tag, true));

	int n_occs = 0;
	tag_t *occs = NULL;
	get_PSOccurrences_of_item(item_tag, uom_tag, &n_occs, &occs);
	if (n_occs == 0)
	{
		IFERR_ABORT(ITEM_set_unit_of_measure(item_tag, uom_tag));
		IFERR_ABORT(AOM_save(item));
	}
	else
	{
		IFERR_ABORT(POM_attr_id_of_attr("uom_tag", "Item", &attr_id_tag));
		IFERR_ABORT(POM_refresh_instances(n_occs, occs, NULLTAG, POM_modify_lock));
		IFERR_ABORT(POM_set_attr_tag(n_occs, occs, attr_id_tag, uom_tag));
		IFERR_ABORT(POM_save_instances(n_occs, occs, true));
	}
	if (occs) MEM_free(occs);
=======
}
>>>>>>> Stashed changes
