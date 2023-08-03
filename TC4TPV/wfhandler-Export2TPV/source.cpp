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

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_TC2TPV_TC10_register_callbacks();
extern "C" DLLAPI int TPV_TC2TPV_TC10_init_module(int *decision, va_list args);
int TPV_TC2TPV(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);

//char *Nazvy[100][20];
char Nazvy[100000][20][128];

int Type_num=0;
int Attr_num=0 ;
int Remove_line=0;
char Attr [10][20][128];
char Attr_type [10][20][128];
char EntryExistenece[10][128];
char AttryExistenece[10][128];
char attr_set[10][128];
char value_set[10][128];
char from_copy[20],
	to_copy[20];


extern "C" DLLAPI int TPV_TC2TPV_TC10_register_callbacks()
{
    printf("Registruji TPV_TC2TPV_TC10.dll\n");
    CUSTOM_register_exit("TPV_TC2TPV_TC10", "USER_init_module", TPV_TC2TPV_TC10_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_TC2TPV_TC10_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_TC2TPV", "", TPV_TC2TPV);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_TC2TPV");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}


int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6][4]){
	int jetam=0;
	for(int j=0;j<=6;j++)
	{
	//	printf("strom %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
		
		if((level==pole[j][0])&&(bomLine==pole[j][1])&&(Rev==pole[j][2]))
		{
			printf("shoda %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
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


	//else if(strcmp(Attr_type[polozka_num][num],"<copy_string")==0)
	//{ char* tmp_text;

	//AOM_ask_value_string(object_type,from_copy,&tmp_text);
	//AOM_set_value_string(object_type,to_copy,tmp_text);

	//}
	else if(strcmp(Attr_type[polozka_num][num],"<set_string")==0)
	{ 
		char* tmp_text;
		
		int IERROR=AOM_set_value_string(object,attr_set[polozka_num],value_set[polozka_num]);
		printf ("Err %d string attr %s   %s \n",IERROR,attr_set[polozka_num],value_set[polozka_num]);
	}
	//AOM_save(object_type);
//printf("TypPolozky_num %d t %d IRev %d hodnoty [%d] %s \n Attr_type[%d][%d] %s \n Attr[%d][%d] %s \n \n",polozka_num,num,object_type,num,value,polozka_num,num,Attr_type[polozka_num][num],polozka_num,num,Attr[polozka_num][num]);
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
	char cesta[50]="\\\\10.1.1.8\\vymena_dat_free\\ComTC_TPV\\pdf_TC\\";
	printf("I_ID %s \n",I_ID);
	for (int k =0;k<strlen(ID_new);k++)
		if(ID_new[k]==' ')
			ID_new[k]='_';

	//int err=AOM_ask_value_string(rev,"item_revision_id",&ID_Rev);

	ifail = GRM_find_relation_type("IMAN_specification", &relation_type_tag);
    if (ifail != ITK_ok) { /* your error logic here */ }

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
				 
				  printf("-----typ_name ok\n");
				ifail = AE_ask_all_dataset_named_refs(specs[ii], "PDF_Reference", &n_refs, &refs);
				printf("Reference %d \n",n_refs);

				if (ifail != ITK_ok) { printf("chyba v dotazu na dataset\n"); }
				else printf(" ok export\n");
            
			strcat(cesta,ID_new);
			strcat(cesta,"_");
			strcat(cesta,ID_Rev);
			//printf("Cesta %s \n",cesta);
			strcat(cesta,".");
			//printf("Cesta %s \n",cesta);
			strcat(cesta,typ);
			//printf("Cesta %s \n",cesta);
			strcpy(Nazvy[poradi][5],cesta);
			printf("cesta %s poradi %d\n",Nazvy[poradi][5],poradi);
			if(SouborExistuje(cesta)==1)
			{
				ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
				if (ifail != ITK_ok) { printf("Nefunguje export \n");}
			}
			  }
			  }

}
}
int  Add_material(char* id_polozky,int *poradi,char* id_rodice,char* obj_name )
{
		char  cislo[5];
		printf("poradi %d \n",*poradi);
		sprintf(cislo,"%d",*poradi);

	//	strcpy(Nazvy[*poradi][0],cislo);
		//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		printf("-----------Pridni hutni material--------- \n");
		printf("testy id_polozky %s;\n id_rodice %s;\n obj_name %s  \n",id_polozky,id_rodice,obj_name);
		//ITEM_ask_item_of_rev(Rev,&Item);
	
		
		//AOM_ask_value_string(Item,"object_name",&obj_name);
		//GetProperty (0,2,Item,&tmp);
		strcpy(Nazvy[*poradi][2],obj_name);//nazev
		printf("Type %s \n",Nazvy[*poradi][2]);
		
		//BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		//AOM_ask_value_string(Rev,"item_revision_id", &tmp);
		//GetProperty (0,3,Rev,&tmp);
		strcpy(Nazvy[*poradi][3]," ");//revize
		printf("item_rev %s \n",Nazvy[*poradi][3]);
				//AOM_ask_value_string(Item,"tpv4_nomenklatura",&tmp);
			strcpy(Nazvy[*poradi][0],id_rodice);
			printf("idv %s id_rodice %s \n",Nazvy[*poradi][0],id_rodice);
			strcpy(Nazvy[*poradi][1],id_polozky);//typ
			strcpy(Nazvy[*poradi][7],"N");//typ
			//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
			strcpy(Nazvy[*poradi][6]," ");//material
			strcpy(Nazvy[*poradi][8]," ");//tpv4_norma
			strcpy(Nazvy[*poradi][9]," ");//tpv4_typ_polozky
			strcpy(Nazvy[*poradi][10]," ");//tpv4_hmotnost
			

	return *poradi;
}
	int BezBomLine(tag_t Rev, int poradi,char* ID_v)
	{

		printf("------------------read Attr Bom Bez bom line ------------------\n");
		int AttributeId=0;
	char* tmp;
	char hm [20];
	double Hmotnost;
	char* TypItemu;
	tag_t Item;

	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_norma#tpv4_typ_polozky#tpv4_hmotnost
	
	printf ("test305 %s \n",ID_v);
		//strcpy(Nazvy[poradi][0],I_ID_v);
		strcpy(Nazvy[poradi][0],ID_v);
		//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		printf("test100 \n");
		ITEM_ask_item_of_rev(Rev,&Item);
		//AOM_ask_value_string(Item,"item_id",&tmp);
		//GetProperty (0,1,Item,&tmp);
		//printf("+++++ %s ++++++ \n",tmp);
		//BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		//BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);
		//strcpy(Nazvy[poradi][1],tmp);//id
		//printf("Item_id %s\n",Nazvy[poradi][1]);
		
		AOM_ask_value_string(Item,"object_name",&tmp);
		//GetProperty (0,2,Item,&tmp);
		strcpy(Nazvy[poradi][2],tmp);//nazev
		printf("Type %s \n",Nazvy[poradi][2]);
		
		//BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		AOM_ask_value_string(Rev,"item_revision_id", &tmp);
		//GetProperty (0,3,Rev,&tmp);
		strcpy(Nazvy[poradi][3],tmp);//revize
		printf("item_rev %s \n",Nazvy[poradi][3]);
		
	
	//	BOM_line_look_up_attribute("bl_quantity", &AttributeId);
	//	BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);//mnozstvi
	//	if (strcmp(tmp,"")==0)
			strcpy(Nazvy[poradi][4],"1");//mnozstvi
	//	else
	//	strcpy(Nazvy[poradi][4],tmp);
		printf("mnozstvi %s \n",Nazvy[poradi][4]);

		AOM_ask_value_string(Rev,"object_type",&TypItemu);
		if(strcpy(TypItemu,"TPV4_h_materialRevision")==0 || strcpy(TypItemu,"TPV4_nak_polRevision")==0){
			printf("-------Neni dilec--------\n");
			AOM_ask_value_string(Item,"tpv4_nomenklatura",&tmp);
			strcpy(Nazvy[poradi][1],tmp);//typ
			strcpy(Nazvy[poradi][7],"N");//typ
			AOM_ask_value_string(Rev,"tpv4_material",&tmp);
			strcpy(Nazvy[poradi][6],tmp);//material
			strcpy(Nazvy[poradi][8]," ");//tpv4_norma
			strcpy(Nazvy[poradi][9]," ");//tpv4_typ_polozky
			strcpy(Nazvy[poradi][10]," ");//tpv4_hmotnost

		}
		else if(strcpy(TypItemu,"TPV4_nak_dilRevision")==0)
		{
		char* id_polozky;
		char* obj_name;
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_np",&id_polozky);
			strcpy(Nazvy[poradi][6],id_polozky);
			AOM_ask_value_string(Rev,"tpv4_nazev_np",&obj_name);
		//	AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&tmp);
			strcpy(Nazvy[poradi][1],tmp);//typ
			printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		// poradi++;
		 Add_material(id_polozky,&poradi," ",obj_name);
			//AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&tmp);
			//strcpy(Nazvy[poradi][1],tmp);//typ
			//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
			//strcpy(Nazvy[poradi][7],"N");//typ
			//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
			//strcpy(Nazvy[poradi][6],tmp);//material
			//AOM_ask_value_string(Rev,"tpv4_polotovar",&tmp);
			//strcpy(Nazvy[poradi][8],tmp);//tpv4_norma
			//strcpy(Nazvy[poradi][9],"D");//tpv4_typ_polozky
			//AOM_ask_value_string(Rev,"tpv4_hmotnost",&tmp);
			//strcpy(Nazvy[poradi][10],tmp);//tpv4_hmotnost
		}
		else
		{
			printf("export dil \n");
		//typ dílce 
		tag_t *Boms;
		int BomsCount=0;
		ITEM_rev_list_bom_view_revs(Rev, &BomsCount, &Boms);
		if ( BomsCount==0)
			strcpy(Nazvy[poradi][7],"D");
		else
			strcpy(Nazvy[poradi][7],"S");

		printf("test359\n");
		//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
		////GetProperty (0,6,Rev,&tmp);
		//strcpy(Nazvy[poradi][6],tmp);
		//if(strcmp(tmp,"")==0)
		//{
		//	printf("prazdny_material_nakup \n");
		//	AOM_ask_value_string(Rev,"tpv4_material",&tmp);
		//	strcpy(Nazvy[poradi][6],tmp);
		//}
		//else if (strcmp(tmp,"")==0)
		//strcpy(Nazvy[poradi][6],"");

		printf("test372\n");
		AOM_ask_value_string(Rev,"tpv4_polotovar",&tmp);
		//GetProperty (0,8,Rev,&tmp);
		strcpy(Nazvy[poradi][8],tmp);
		//printf("vykres_norma %s \n",Nazvy[poradi][8]);
		printf("test377\n");
		AOM_ask_value_string(Rev,"tpv4_material",&tmp);
		//GetProperty (0,9,Rev,&tmp);
		//strcpy(Nazvy[poradi][9],tmp);
		strcpy(Nazvy[poradi][9],tmp);
		//printf("typ_dilce %s \n",Nazvy[poradi][9]);

		AOM_ask_value_string(Rev,"tpv4_hmotnost",&tmp);
		printf("test385\n");
		//sprintf(hm,"%.2f", Hmotnost);
		if(strcmp(tmp,"-")==0)
			strcpy(Nazvy[poradi][10]," ");
		else
			strcpy(Nazvy[poradi][10],tmp);
		//printf("hmotnost %s\n", Nazvy[poradi][10]);
		char* id_polozky;
		char* obj_name;
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_hm",&id_polozky);
			strcpy(Nazvy[poradi][6],id_polozky);
			AOM_ask_value_string(Rev,"tpv4_nazev_hm",&obj_name);
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&tmp);
			strcpy(Nazvy[poradi][1],tmp);//typ
			printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		// poradi++;
		 Add_material(id_polozky,&poradi,tmp,obj_name);
		}
		
		//for (int i=0;i<Attr_num;i++)
		//{
		//	printf(" %d _____________ \n",i);
		//	GetProperty (0,i,Rev,&tmp);
		//	printf("vystup %s %d \n _________ \n",tmp,tmp);
		//	if(tmp==0)
		//	{
		//		printf("null\n");
		//		strcpy(Nazvy[poradi][i]," ");
		//	}
		//	else
		//	strcpy(Nazvy[poradi][i],tmp);
		//}
		
		poradi++;
	return poradi;
}
void readAttr(tag_t BomLine,tag_t Rev, int poradi,char *I_ID_v){

	printf("------------------read Attr Bom line ------------------\n");
	int AttributeId=0;
	char* tmp;
	char hm [20];
	double Hmotnost;
	char* TypItemu; 
	tag_t tmp_tag;

	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_norma#tpv4_typ_polozky#tpv4_hmotnost
	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv
	

		//strcpy(Nazvy[poradi][0],I_ID_v);
		strcpy(Nazvy[poradi][0],I_ID_v);
		

		printf("test100 \n");
				/*BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);
		///
		strcpy(Nazvy[poradi][1],tmp);//id*/										//puvoni item id; 
		//printf("Item_id %s\n",Nazvy[poradi][1]);
		
		AOM_ask_value_string(Rev,"object_name",&tmp);
		strcpy(Nazvy[poradi][2],tmp);//nazev
		//printf("name %s \n",Nazvy[poradi][2]);
		
		BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);
		strcpy(Nazvy[poradi][3],tmp);//revize
		//printf("item_rev %s \n",Nazvy[poradi][3]);
		
	
		BOM_line_look_up_attribute("bl_quantity", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);//mnozstvi
		if (strcmp(tmp,"")==0)
			strcpy(Nazvy[poradi][4],"1");//mnozstvi
		else
		strcpy(Nazvy[poradi][4],tmp);
		//printf("mnozstvi %s \n",Nazvy[poradi][4]);

		AOM_ask_value_string(Rev,"object_type",&TypItemu);
		printf("Typ itemu %s %d\n delky: %d %d \n",TypItemu,strcmp(TypItemu,"TPV4_h_materialRevision"),strlen("TPV4_h_materialRevision"),strlen (TypItemu));
		if(strcmp(TypItemu,"TPV4_h_materialRevision")==0 || strcmp(TypItemu,"TPV4_nak_polRevision")==0 ){
			
			tag_t Item;
			ITEM_ask_item_of_rev(Rev,&Item);

			AOM_ask_value_string(Item,"tpv4_nomenklatura",&tmp);
			strcpy(Nazvy[poradi][1],tmp);

			
			strcpy(Nazvy[poradi][7],"N");//typ
			printf("Writte typ %s\n",Nazvy[poradi][7]);
			//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
			strcpy(Nazvy[poradi][6]," ");//id nak polozky 
			strcpy(Nazvy[poradi][8]," ");//tpv4_norma
			strcpy(Nazvy[poradi][9]," ");//tpv4_material
			strcpy(Nazvy[poradi][10]," ");//tpv4_hmotnost
			//strcpy(Nazvy[poradi][7],"D");

		}
		else if(strcmp(TypItemu,"TPV4_nak_dilRevision")==0)
		{
		char* id_polozky;
		char* obj_name;
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_np",&id_polozky);
			strcpy(Nazvy[poradi][6],id_polozky);
			AOM_ask_value_string(Rev,"tpv4_nazev_np",&obj_name);
		//	AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&tmp);
			strcpy(Nazvy[poradi][1],tmp);//typ
			printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		// poradi++;
		 Add_material(id_polozky,&poradi," ",obj_name);
		}
		else
		{
			printf("export dil \n");
		//typ dílce 
		tag_t *Boms;
		int BomsCount=0;
		ITEM_rev_list_bom_view_revs(Rev, &BomsCount, &Boms);
		if ( BomsCount==0)
			strcpy(Nazvy[poradi][7],"D");
		else
			strcpy(Nazvy[poradi][7],"S");

		printf("test359\n");
		//AOM_ask_value_string(Rev,"tpv4_material",&tmp);
		////GetProperty (0,6,Rev,&tmp);
		//strcpy(Nazvy[poradi][6],tmp);
		//if(strcmp(tmp,"")==0)
		//{
		//	printf("prazdny_material_nakup \n");
		//	AOM_ask_value_string(Rev,"tpv4_material",&tmp);
		//	strcpy(Nazvy[poradi][6],tmp);
		//}
		//else if (strcmp(tmp,"")==0)
		//strcpy(Nazvy[poradi][6],"");

		printf("test372\n");
		AOM_ask_value_string(Rev,"tpv4_polotovar",&tmp);
		//GetProperty (0,8,Rev,&tmp);
		strcpy(Nazvy[poradi][8],tmp);
		//printf("vykres_norma %s \n",Nazvy[poradi][8]);
		printf("test377\n");
		AOM_ask_value_string(Rev,"tpv4_material",&tmp);//material
		//GetProperty (0,9,Rev,&tmp);
		//strcpy(Nazvy[poradi][9],tmp);
		strcpy(Nazvy[poradi][9],tmp);
		//printf("typ_dilce %s \n",Nazvy[poradi][9]);
		char* poznamka;
		AOM_ask_value_string(Rev,"tpv4_poznamka_tpv",&poznamka);
		strcpy(Nazvy[poradi][10],poznamka);

		AOM_ask_value_string(Rev,"tpv4_hmotnost",&tmp);//hmotnost
		printf("test385\n");
		//sprintf(hm,"%.2f", Hmotnost);
		

		if(strcmp(tmp,"-")==0)
			strcpy(Nazvy[poradi][10]," ");
		else
			strcpy(Nazvy[poradi][10],tmp);
		//printf("hmotnost %s\n", Nazvy[poradi][10]);
		char* id_polozky;
		char* obj_name;
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu_hm",&id_polozky);
			strcpy(Nazvy[poradi][6],id_polozky);
			AOM_ask_value_string(Rev,"tpv4_nazev_hm",&obj_name);
			AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&tmp);
			strcpy(Nazvy[poradi][1],tmp);//typ
			printf("test398 cislo Vykresu %s \n",Nazvy[poradi][1]);
		// poradi++;
		 Add_material(id_polozky,&poradi,tmp,obj_name);
		}
		

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
	printf (" tak bom line %d \n",BomLine);
	char hm [20];
	int AttributeId;
	tag_t Rev = NULLTAG;
	char* SEAR = NULLTAG;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(pamet[Level], AttributeId, &Rev);
		BOM_line_look_up_attribute("bl_TPV4_itm_dil_pomRevision_tpv4_cislo_vykresu", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &I_ID_v);
		printf(">>>362>>>>Parent %s\n",I_ID_v);
		//printf (" tak Rev %d \n",Rev);
		
		//SE Assembly Reports
		//		BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
		//BOM_line_ask_attribute_string(pamet[Level], AttributeId, &SEAR);
		//		printf(" SE Assembly Reports %s \n",SEAR);
		//double Hmotnost;
		//	
						//printf("hmotnost dilu %f \n",Hmotnost);
						char *tmp;
	if( Level==0)
	{
		readAttr(BomLine, Rev, poradi,"");
		//strcpy(Nazvy[poradi][7],tmp);
		downloadDataset(Rev,I_ID_v,poradi,"pdf"," ");

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
				char* tmpQuant;
				BOM_line_look_up_attribute("bl_quantity", &AttributeId);
				BOM_line_ask_attribute_string(BomLine, AttributeId, &tmpQuant);
				if (strcmp(tmpQuant,"")==0)
					strcpy(tmpQuant,"1");
				int dif=t-j;

				int NewQuant =atoi(tmpQuant)+atoi(Nazvy[poradi-dif][4]);//mnozstvi
				sprintf(Nazvy[poradi-dif][4],"%d", NewQuant);
				goto next;
			}
		}


			poradi=poradi+1;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[t], AttributeId, &Rev);
		//printf(">>>>424>>>Parent %s\n",I_ID_v);
		//ask_item_revision_from_bom_line(
			//readAttr(Childs[t], Rev, poradi,I_ID_v);
		BezBomLine(Rev,poradi,I_ID_v);
		//strcpy(Nazvy[poradi][7],tmp);
			char tmpName[128];
			strcpy(tmpName,Nazvy[poradi-1][1]);
			strcat(tmpName,"_");
			strcat(tmpName,Nazvy[poradi-1][3]);
			printf("tmpName %s \n",tmpName);
		
		downloadDataset(Rev,tmpName,poradi-1,"pdf"," ");
		printf("Poradi %d Vrchol %s Dil %s Rev %s \n",poradi,I_ID_v,I_ID,REV_ID);
		next:;
	}

	//printf("Count %d \n", ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)
	{	
	
		poradi=ListBomLine(Childs[k], Level + 1, pamet, poradi, BomWindow,Strom);
		
	}
	printf(" pred koncem poradi %d\n",poradi);
	
	return poradi;
}

char* create_marks_csv(char *filename,int m,int n){
 
printf("\n Creating %s.csv file",filename);
 
FILE *fp;
 
int i,j;
 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\Export\\csv\\");
 strcat(file,filename);
//printf("test1 \n");
 strcat(file,".csv");
 //printf("file %s \n",file);



fp=fopen(file,"a");
 printf("test po zaèátku zápisu %d \n",fp);
//fprintf(fp,attr);
 
for(i=0;i<m;i++)
{
	printf ("fprint %d \n",i);
	if(i==0)
		fprintf(fp,"poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#tpv4_polotovar#tpv4_material#tpv4_hmotnost#tpv4_poznamka_tpv\n%d",i);
	else
	{
		fprintf(fp,"\n%d",i);
	}
			for(j=0;j<=n;j++)
			{
				fprintf(fp,"#%s",Nazvy[i][j]);	
				printf("# %s",Nazvy[i][j]);
			}
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
void ReadProperty()
{
		printf(" Read Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char Path[50]="C:\\SPLM\\Apps\\Export\\TC2TPV_property.xml";


	    FILE* stream = fopen(Path, "r");
		printf("Open %s\n",Path);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		printf("----------READLINE---------\n");
		tmp=strtok(line,">");
		
		
		//tmp=strtok(NULL,"<");
		if (strcmp(tmp,"<polozka")==0)
		{
			Attr_num=0;
			Remove_line=0;
			printf("polozka \n");
			goto nextLine;
			
		}
		else if (strcmp(tmp,"<ItemType")==0)
		{	strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("ItemType attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
			Remove_line++;
		}
		else if(strcmp(tmp,"<string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("string attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}else if(strcmp(tmp,"<int")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("int attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<double")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("double attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<date")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("date attr %s %d %d \n",tmp,Type_num,Attr_num);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}else if(strcmp(tmp,"<folder")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("folder attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			strcpy(Attr[Type_num][Attr_num],tmp);
			Remove_line++;
			//tmp=strtok(
		}else if(strcmp(tmp,"<copy_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(from_copy,strtok(tmp,"#"));
				printf("from %s \n",from_copy);
			strcpy(to_copy,strtok(NULL,"#"));
				printf("to %s \n",to_copy);
				Remove_line++;
			//tmp=strtok(
		}
		else if(strcmp(tmp,"<set_string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("set_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
			//strcpy(Attr[Type_num][Attr_num],tmp);
			printf("value %s \n",tmp);
			strcpy(attr_set[Type_num],strtok(tmp,"#"));
				printf("attr %s \n",attr_set);
			strcpy(value_set[Type_num],strtok(NULL,"#"));
				printf("value %s \n",value_set);
				printf ("\n SET String %s   %s \n \n",attr_set,value_set);
				Remove_line++;
			//tmp=strtok(
		}
		//else if(strcmp(tmp,"<exist")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	tmp=strtok(NULL,"<");
		//	printf("copy_string attr %s \n %d %d \n",tmp,Type_num, Attr_num);
		//	//strcpy(Attr[Type_num][Attr_num],tmp);
		//	printf("value %s \n",tmp);
		//	strcpy(QueryExistenece[Type_num],strtok(tmp,"#"));
		//		printf("query %s \n",QueryExistenece[Type_num]);
		//	strcpy(EntryExistenece[Type_num],strtok(NULL,"#"));
		//		printf("entry %s \n",EntryExistenece[Type_num]);
		//	strcpy(AttryExistenece[Type_num],strtok(NULL,"#"));
		//		printf("attr query existence %s \n",AttryExistenece[Type_num]);
		//		Remove_line++;
		//	//tmp=strtok(
		//}
		else if(strcmp(tmp,"<nowritte")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
		//	printf("noread \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}
		//		else if(strcmp(tmp,"<login")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	//tmp=strtok(NULL,">");
		//	tmp=strtok(NULL,"<");
		//	printf("login %s\n",tmp);
		//	Attr_Typ_polozky=Attr_num;
		//	strcpy(login,tmp);
		//	goto nextLine;

		//}
		//		else if(strcmp(tmp,"<psw")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	//tmp=strtok(NULL,">");
		//	tmp=strtok(NULL,"<");
		//	printf("password %s\n",tmp);
		//	Attr_Typ_polozky=Attr_num;
		//	strcpy(password,tmp);
		//	goto nextLine;

		//}
		//	else if(strcmp(tmp,"<group")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	//tmp=strtok(NULL,">");
		//	tmp=strtok(NULL,"<");
		//	printf("group %s\n",tmp);
		//	Attr_Typ_polozky=Attr_num;
		//	strcpy(group,tmp);
		//	goto nextLine;

		//}
		//else if(strcmp(tmp,"<importFolder")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	//tmp=strtok(NULL,">");
		//	tmp=strtok(NULL,"<");
		//	printf("import file %s\n",tmp);
		//	Attr_Typ_polozky=Attr_num;
		//	strcpy(import_file,tmp);

		//	goto nextLine;

		//}
		//else if(strcmp(tmp,"<inside")==0)
		//{
		//	//strcpy(Attr_type[Type_num][Attr_num],tmp);
		//	tmp=strtok(NULL,"<");
		//	printf("inside \n",tmp);
		//	Attr_Typ_polozky=Attr_num;

		//}
		else if(strcmp(tmp,"</polozka")==0)
		{
			//printf("polozka konec \n");
			Type_num++;
			goto nextLine;
		}
		else goto nextLine;


		tmp=strtok(NULL,">");

		/*if( strcmp(tmp,"<TPV2000")==0)
		{
			tmp=strtok(NULL,"<");
			printf("TPV attr %s \n",tmp);
			strcpy(Attr_tpv[Type_num][Attr_num],tmp);

		}*/
		printf("konec %s \n",tmp);
		

	//tmp=strtok(NULL,">");
	//tmp=strtok(NULL,"<");
	//printf("tmp %s \n",tmp);
	//tmp=strtok(NULL,">");
		Attr_num++;
		nextLine:;
			}


//}
printf("-----Attr_num %d -----\n",Attr_num);
for (int i=0;i<Type_num;i++)
{
	for (int j=0;j<Attr_num;j++)
	{
		printf(" Attr %d %d = %s \n",i,j,Attr[i][j]);

	}
}
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
		*job_name,		
		
		*Pname="ren ",
        description[WSO_desc_size_c+1]  = "";
		tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
	
    EPM_decision_t
        //decision=EPM_undecided ;
		decision=EPM_nogo ;
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;
	POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);
	//AOM_UIF_ask_value(job,"object_name",&job_name);

//printf("test0 \n");		
		FILE *log;
	char logpath[30];
	strcpy(logpath,"C:\\Temp\\export");
	//strcat(logpath,job_name);
	strcat(logpath,".log");
	//printf("log --- %s \n",logpath);
	log=fopen(logpath,"a+");
	
		
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
		
	fprintf(log,"Ziskany id vrcholu \n");	
	//for (int k =0;k<strlen(file);k++)
	//{
	//	if(file[k]==' ')job_name[k]='_';

	//}
	
for( int i = 0; i < TargetsCount; i ++ )
{
	tag_t TargetClassTag = NULLTAG;
POM_class_of_instance(Targets[i], &TargetClassTag);

logical IsRevision = false;
POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);

if(IsRevision == false) continue;
	char *Type;
	      
			// BOM window
			
			tag_t pamet[100];
            tag_t BomWindow = NULLTAG;
            BOM_create_window(&BomWindow);
            tag_t BomTopLine = NULLTAG;
			int poradi=0,
			 Strom[6000][4];
				
			fprintf(log,"Otevreni kusovniku \n");	
	for(int l=0;l<6;l++){
		for (int p=0;p<3;p++){
			Strom [l][p]=0;
		}
	}

		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
		//printf ("%s\n",Type);
		int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
			
		fprintf(log,"pocet kusovniku %d\n",BomsCount);	
		if (BomsCount==0)
		{
			poradi =BezBomLine(Targets[i], i," ");
			downloadDataset(Rev,Nazvy[i][1],poradi,"pdf"," ");
			
			fprintf(log,"stazeny datasety pouze pro tento dilec\n");
		}
        for(int j = 0; j < BomsCount; j++)
        {

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
			poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom)+1;
			
			//BOM_refresh_window(BOM
        }
		
		fprintf(log,"Zpracovano kusovniku \n");
		for (int k =0;k<strlen(file);k++)
			if(file[k]==' ')file[k]='_';
		strcpy(file_name,file);
		strcat(file_name,"_");
		strcat(file_name,RevId);
		create_marks_csv(file_name,poradi,10);
		fprintf(log,"Spusteni importu do TPV \n");
		CallBridge(file_name);
		fprintf(log,"Dokonceno \n \n");
}

	fclose(log);
    return ITK_ok;
}
