#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <string.h>
#include <tc/tc.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>
#include <tccore/aom.h>
#include <tccore/tctype.h>
#include <errno.h>
#include <tc/folder.h>
#include <tccore\releasestatus.h>
#include <MsXml.h>


#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define CHUNK 1024 /* read 1024 bytes at a time */
#define delimiter  ";"

struct Polozka{
	int Poradi_atr;
	char *I_Name;
	char *Velikost;
	char *I_Popis;
	char** Name_attrs;
	char *Attr_Matr;
	char *Rozmer;
	char *Attr3;
	char *Jednotka;
	char *KlicTPV;
	char *Typ;
	char *Evid_cena;
};


char Attr [10][20][128];
char Attr_type [10][20][128];
char Attr_tpv [10][20][128];
char login[20],
	password[30],
	import_file[50],
	group[20];

int Type_num=0;
int Attr_num=0 ;
int Attr_Typ_polozky=0;
tag_t Zalozeny[20];
//tag_t Schval_Item=NULLTAG;
tag_t Schval_Rev=NULLTAG;
tag_t Schval_Bwr=NULLTAG;
int zalozeny_num=0;
int Existence(char* item_name_hledany,char* typ,char* KlicTPV);
void copy_string(char *target, char *source) {
   while (*source) {
      *target = *source;
      source++;
      target++;
   }
   *target = '\0';
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
void ListBomLine(tag_t BomLineTag, int Level);


void ZpracujAttr (char buf[CHUNK],int num)
{
	 
   
}
void IntoFolder(char* folderName,tag_t Item)
{
					tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find2("General...", &query);
				printf("tag foldru je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[2] = {"Name","Type"};
				char *values[2] =  {folderName,"Folder"};
				int n_folder = 0;
				//strcpy(values[0],folder);
				printf(" \n \n Folder %s \n \n ",folderName);
							
				QRY_execute(query, 2, entries, values, &n_folder, &folder);
				printf("pocet nalezu %d\n",n_folder);
				if(n_folder!=0)
					MoveTPToFolder(*folder,Item);
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



void SetProperty (int polozka_num,int num,tag_t object_type,char* value)
{
	if(strcmp(Attr_type[polozka_num][num],"<string")==0)
	{
		//value=OpravCz(value);
		int IERROR=AOM_set_value_string(object_type,Attr[polozka_num][num],value);
		printf ("Err %d string attr %s   %s \n",IERROR,Attr[polozka_num][num],value);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<int")==0)
	{
		int tmp_int=atoi(value);
		printf ("int attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_int );
		if(strcpy(value," ")!=0)
			AOM_set_value_int(object_type,Attr[polozka_num][num],tmp_int);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<double")==0)
	{
		double tmp_double=atof(value);
		printf ("double attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_double );
		if(strcpy(value," ")!=0)
			AOM_set_value_double(object_type,Attr[polozka_num][num],tmp_double);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<date")==0)
	{
		printf ("date %d \n num %d %d \n hodnota %s \n",strlen(value),polozka_num,num,value);
		//double tmp_double=atof(value);
		if(strlen(Attr[polozka_num][num])>6)
		{
			date_t ukonceni;
			char *yer=strtok(value,"-");
			int tmp_int=atoi(yer);
			ukonceni.year=tmp_int;
			char *moths=strtok(NULL,"-");
			tmp_int=atoi(moths);
			ukonceni.month=tmp_int;
			char *day=strtok(NULL," ");
			tmp_int=atoi(day);
			ukonceni.day=tmp_int;
			printf("---\n \n yer %s \n months %s \n day %s\n",yer,moths,day);
			AOM_set_value_date(object_type,Attr[polozka_num][num],ukonceni);

		}
		//printf ("date attr %s   %s %d\n",Attr[polozka_num][num],value,tmp_double );
		//if(strcpy(value," ")!=0)
		//	AOM_set_value_double(object_type,Attr[polozka_num][num],tmp_double);
	}
	else if(strcmp(Attr_type[polozka_num][num],"<nowritte")==0)
		printf ("--nic\n");
	else if(strcmp(Attr_type[polozka_num][num],"<folder")==0)
	{
		printf ("\n Folder value %s \n",Attr[polozka_num][num]);
		tag_t Item;
		ITEM_ask_item_of_rev(object_type,&Item);
		IntoFolder(Attr[polozka_num][num],Item);
	}
	AOM_save(object_type);
//printf("TypPolozky_num %d t %d IRev %d hodnoty [%d] %s \n Attr_type[%d][%d] %s \n Attr[%d][%d] %s \n \n",polozka_num,num,object_type,num,value,polozka_num,num,Attr_type[polozka_num][num],polozka_num,num,Attr[polozka_num][num]);
}

//int Get_Attr (char hodnoty [20][256],char* Name_ATTR,int polozka_num)
//{
//
//	for (int i=0;i<20;i++)
//		if (strcpy (Name_ATTR,Attr[polozka_num][i])==0)
//			return i;
//
//	return 0;
//}

int GetAttr(char* attr,int polozka_num)
{
	int num=0;
	for (int i=0;i<Attr_num;i++)
	{
		if (strcmp(Attr[polozka_num][i],attr)==0)
			num=i;
	}
	printf("Cislo attr v poli %d \n",num);
	return num;

}
int getTagRev_Dil(char *obj_name)
{
	printf("obj_name %s \n",obj_name);
	tag_t *Item,
		Rev;

	tag_t query = NULLTAG,
		* folder=NULLTAG;
	int n_dil = 0;
	//char tmp[40];
	//strcpy(tmp,obj_name);
	
	if (strchr(obj_name,'/')!=NULL)
	{
		
		char* tmp=strtok(obj_name,"/");
		char* tmprev=strtok(NULL,"");

		QRY_find2("STS_DIL", &query);
		printf("tag foldru STS_DIL je %d\n",query);
		printf("rev %s \n",tmprev);
// Find user's "Tasks to Perform" folder
//char *entries[2] = {"CISLO POLOZKY TC","CISLO REVIZE TC"};
		char *entries[1] = {"D_CISLO VYKRESU"};


		char *values[1] =  {tmp};
		printf("value %s \n",values[0]);
		QRY_execute(query, 1, entries, values, &n_dil, &Item);
		printf(">>>pocet nalezu dilu %d\n",n_dil);
		//ITEM_ask_rev_id2(Item[i],&Rev);
		if(n_dil==0 )
			return 0;
		else if (tmprev!=NULL) {
			char *rev_id;
			for (int i=0;i<n_dil;i++)
			{
				printf("231 položka %d \n",i);
				ITEM_ask_rev_id2(Item[i],&rev_id);
				printf("id rev %s hledana % s\n",rev_id,tmprev);
				if(strcmp(tmprev,rev_id)==0)
					return Item[i];
			}

		}else
		{
			
			return 0;	
		}
}else printf(" ---- neobsahuje / \n"); 

	//
//printf("value %s \n",values[0]);
		
							
//QRY_execute(query, 1, entries, values, &n_dil, &Item);
//printf(">>>pocet nalezu dilu %d\n",n_dil);
//if(n_dil==0)
//	return 0;

	return 0;
}

int getTagRev_zak(char *obj_name)
{
	printf("-----getTagRev_zak-----\n");
	tag_t *Item,
		Rev;

		tag_t query = NULLTAG,
* folder=NULLTAG;
QRY_find2("General...", &query);
printf("tag foldru Qry General je %d\n",query);
// Find user's "Tasks to Perform" folder
char *entries[2] = {"Name","Type"};
char *values[2] =  {obj_name,"TPV4_Zakazka"};
int n_folder = 0;		
							
QRY_execute(query, 2, entries, values, &n_folder, &Item);
printf("pocet nalezu zak %d\n",n_folder);
if(n_folder==0)
	return 0;

	return *Item;
//return 0;
}
char *Get_kusy(int polozka_num,char* value)
{


}
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr)
{int AttrId=0;
BOM_line_look_up_attribute(Attr, &AttrId);
int err =BOM_line_set_attribute_string(BomLine, AttrId, value);
if (err!=ITK_ok) printf ("chyba %d \n",err);
BOM_save_window(BomWin);
}

void SetBomLineINT( tag_t BomWin, tag_t BomLine, int value, char* Attr)
{int AttrId=0;
BOM_line_look_up_attribute(Attr, &AttrId);
int err =BOM_line_set_attribute_int(BomLine, AttrId, value);
if (err!=ITK_ok) printf ("chyba %d \n",err);
BOM_save_window(BomWin);
}
void SeAttr_BomLine(tag_t assy_rev,tag_t Occ,char* kv_cis_zakazky, char* kv_pocet_kusu )
{
	printf("-----SeAttr_BomLine-----\n");
	 tag_t window = NULLTAG;
	  BOM_create_window (&window);

    tag_t rule = NULLTAG;
    //CFM_find("Latest Working", &rule);
    BOM_set_window_config_rule(window, rule);
    BOM_set_window_pack_all(window, TRUE);

    tag_t top_line = NULLTAG;
    BOM_set_window_top_line(window, NULLTAG, assy_rev, NULLTAG, &top_line);
	
	int n_children=0;
	tag_t *children=NULL;
	BOM_line_ask_child_lines(top_line, &n_children, &children);
	
	int bl_occurrence = 0;
	tag_t bl_occ = NULLTAG;
	
	for(int i=0;i<n_children;i++)
	{
		
    BOM_line_look_up_attribute( "bl_occurrence", &bl_occurrence);
    BOM_line_ask_attribute_tag(children[i], bl_occurrence, &bl_occ);
	 printf ("\n bl_occ %d = %d Occ \n",bl_occ,Occ);
		if (bl_occ==Occ)
		{
			printf(">>>>nalezen Bom line \n");
			SetBomLineString(window,children[i],kv_cis_zakazky , "TPV4_kv_cis_zakazky");
			SetBomLineString(window,children[i],kv_pocet_kusu , "TPV4_kv_pocet_kusu");
			printf("\n \n Pocet kusu = %s \n",kv_pocet_kusu);
			char *quantity=strtok(kv_pocet_kusu,".");
			
			SetBomLineString(window,children[i],quantity , "bl_quantity");
			int count=atoi(quantity);
			SetBomLineINT(window,children[i],count , "bl_pack_count");

		}
	}
	BOM_save_window(window);
    BOM_close_window(window);

}
void Add_to_PS (tag_t bvr,tag_t Target_rev,char* seq_no,tag_t assy_rev,char* kv_cis_zakazky, char* kv_pocet_kusu )
{
	printf("-----Add_to_PS-----\n");
	tag_t * Occ;
	int Status=PS_create_occurrences(bvr,Target_rev,NULLTAG,1,&Occ);
			printf(" status %d \n",Status);
			if(Status ==ITK_ok)EMH_clear_last_error(Status);
			AOM_lock(bvr);
			PS_set_seq_no(bvr,*Occ,seq_no);
						
			printf("tag Occ %d \n",*Occ);
			AOM_save(bvr);
			AOM_unlock(bvr);

			SeAttr_BomLine(assy_rev,*Occ,kv_cis_zakazky,kv_pocet_kusu );	
			MEM_free(Occ);

}

int Create_View(tag_t ZRev, tag_t ZItem,tag_t Target_rev, char* seq_no,char* kv_cis_zakazky, char* kv_pocet_kusu){
	printf("----- Create_View-----\n");
		tag_t BomWindowTP = NULLTAG;
		tag_t TopBomLineTP =NULLTAG;
		tag_t* P1 = NULLTAG;
		tag_t* P2 = NULLTAG;
		tag_t* P3 = NULLTAG;
		tag_t query = NULLTAG;
		tag_t bvr =NULLTAG;


		char *rev_id = NULL;
		//tag_t BomViewType =NULLTAG;

		// BomView Type
tag_t BomViewType= NULLTAG;
PS_ask_default_view_type( &BomViewType);
		

						
	PS_create_bom_view (BomViewType, NULL, NULL, ZItem, &BomWindowTP);
	AOM_save (BomWindowTP);
	ITEM_save_item(ZItem);

    PS_create_bvr (BomWindowTP, NULL, NULL,  true, ZRev, &bvr);
    AOM_save (bvr);
    AOM_save(ZRev);	

	tag_t *Occ=NULLTAG;	
			// printf("tag BW %d tag bvr %d \n",BomWindowTP,bvr);
			ITEM_ask_rev_id2(Target_rev,&rev_id);
			printf("rev_id %s \n", rev_id);
				AOM_lock(bvr);
			Add_to_PS ( bvr, Target_rev, seq_no, ZRev,kv_cis_zakazky,kv_pocet_kusu );
	printf ("bvr %d \n",bvr);									
return bvr;
}
int Create_Obj(tag_t revType, char* type_name,char *obj_name,int typ_num )
{
	printf("\n----Create Obj string %s -----\n",obj_name);
			tag_t createItem = NULLTAG;
			tag_t createRev = NULLTAG,
				Item= NULLTAG,
				itemType= NULLTAG;
			TCTYPE_construct_create_input(revType, &createRev);
	
		//itemy
	
				TCTYPE_find_type(type_name, NULL, &itemType);
		TCTYPE_construct_create_input(itemType, &createItem);

		//set attribute
		
		AOM_set_value_tag(createItem,"revision", createRev);
		//strcpy(hodnoty[3],OpravCz(hodnoty[3]));
		int num= GetAttr("object_name",typ_num);
		printf("---------SET PRoperty name %s \n",obj_name);
		SetProperty (typ_num,num,createItem,obj_name);
		

		int ReturnCode=TCTYPE_create_object(createItem, &Item);
		if (ReturnCode!=ITK_ok) printf("Chyba vytvaøeni objectu \n");
		//TCTYPE_create_object(createRev, &IRev);
		ReturnCode = AOM_save(Item);
		//printf ("Save TP %d \n",ReturnCode);
		if (ReturnCode ==ITK_ok)printf("Ulozena Item 340 \n");
		else printf("Neuložena Item");
							
		return Item;
}
void Create_Sklad(char *Typ,char hodnoty [20][256], tag_t ZRev, tag_t ZItem){
	printf("----Create_Sklad-----\n");
		tag_t TP = NULLTAG;
		tag_t IRev = NULLTAG;
		//tag_t I=NULLTAG;
		tag_t itemType = NULLTAG;
		tag_t revType = NULLTAG;
		tag_t createItem = NULLTAG;
		tag_t createRev = NULLTAG;
	//revise
		printf("\n----Create TC polozku Sklad Karta ----\n");
			printf("tady 74 :typ %s \n",Typ);
		//char *KP="DAA 000 272";
    // Vyhledání položek

	//ITEM_ask_latest_rev(*Items,&Targets);
	//printf("test po  hledani \n");

			strcat(hodnoty[5],"0");
			char typRevize[60]=" ",
					typItem[60]=" ",
					folder[30]=" ";
			int TypPolozky_num=0;

		strcpy(typRevize,Attr[1][0]);
		strcat(typRevize,"Revision \n");
		printf("Typ pro zalozeni %s %s \n",typRevize);
		strcpy(typItem,Attr[1][0]);

		char name [128];
			
			if(strlen(hodnoty[14])>1)
			
				strcpy(name,hodnoty[14]);
			else
				strcpy(name," - ");

		
			printf("\n____\n cislo vykresu %s\n____\n",hodnoty[14]);
			IRev=getTagRev_Dil(hodnoty[14]);
		//}
		printf ("rev dil %d \n",IRev);
		//ITEM_ask_item_of_rev(IRev,&I);
		if (IRev==0)//existence
		{
			
				strcat(name,"~");
				
				strcat(name,hodnoty[8]);
		 TP=Create_Obj(revType, typItem,name,1 );
	
		ITEM_ask_latest_rev(TP,&IRev);
		
		
		int ReturnCode = AOM_save(TP);	
		if (ReturnCode ==ITK_ok)printf("Ulozena Item 379 \n");
		else printf("Neuložena Item\n ");

		//SetProperty (0,Attr_num-1,TP,folder);
		//printf(" \n \n Folder %s \n \n ",folder);
		//IntoFolder(folder,TP);

		char *new_id;
		AOM_ask_value_string(TP,"item_id",&new_id);
		printf("zalozena %d \n",new_id);
		

		printf("id nove položky je %s \n",new_id);
	}else {
		printf ("---------------------\n item s is %s uz existuje \n",hodnoty [2]);
		
		
		//ITEM_ask_latest_rev(I,&IRev);
				
		}
	Schval_Rev=ZRev;
	int n_bvrs = 0;
	tag_t *bvrs = NULL;
	ITEM_rev_list_bom_view_revs(ZRev, &n_bvrs, &bvrs);
	printf("pocet brv %d \n",n_bvrs);	
	if (n_bvrs == 0) 
	{ 
		//char* kusy=Get_kusy();
		printf("Assy Revision BVR not found!\n"); 
		//exit (0);
		Schval_Bwr=Create_View( ZRev, ZItem,IRev,hodnoty[5],hodnoty[2],hodnoty[12]);
		//Schval_Bwr=Create_View( ZRev, ZItem,IRev,hodnoty[5],hodnoty[2],"1");
		//Add_Target_ToView( ZRev,  ZItem,IRev);
	}else
	{
		
		Add_to_PS (*bvrs,IRev,hodnoty[5],ZRev,hodnoty[2],hodnoty[12]);
		//Add_to_PS (*bvrs,IRev,hodnoty[5],ZRev,hodnoty[2],"1");
		Schval_Bwr=*bvrs;

	}

		printf("421 schval   %d %d \n", Schval_Rev, Schval_Bwr);
}

void Create_zak(char *Typ,char hodnoty [20][256]){
		printf("----Vreate_zak----\n");
		tag_t Item = NULLTAG;
		tag_t IRev = NULLTAG;
		tag_t itemType = NULLTAG;
		tag_t revType = NULLTAG;
		tag_t createItem = NULLTAG;
		tag_t createRev = NULLTAG;
	//revise
	//	printf("----Create TC polozku ZAK----\n");
	//		printf("tady 74 :typ %s \n",Typ);
		//char *KP="DAA 000 272";
    // Vyhledání položek

	//ITEM_ask_latest_rev(*Items,&Targets);
	//printf("test po  hledani \n");
			char typRevize[60]=" ",
					typItem[60]=" ",
					folder[30]=" ";
			int TypPolozky_num=0;

		strcpy(typRevize,Attr[0][0]);
		strcat(typRevize,"Revision");
	//	printf("\n hodnoty %s \n",hodnoty[3]);
		strcpy(typItem,Attr[0][0]);
		int num= GetAttr("object_name",0);
		Item =getTagRev_zak(hodnoty[num]);
	if (Item==0)//existence
	{
		
		Item=Create_Obj(revType, typItem,hodnoty[num],0);
		//printf ("OBJNAME %s \n",hodnoty[num]);
		ITEM_ask_latest_rev(Item,&IRev);
		int OK=AOM_lock(IRev);
	//	printf("zapis attr %d attr_num %d\n",OK,Attr_num-1);
		
		for (int t=1;t<Attr_num;t++)
		{
			printf("%d = %s \n",t,hodnoty[t]);
			if(t!=num)
			SetProperty (0,t,IRev,hodnoty [t]); //pro zápis do Itemu
			
		}
		//AOM_set_value_string(TP,"tpv4_stav_polozky","Neopravena z ERP");
		int ReturnCode = AOM_save(IRev);	
		if (ReturnCode ==ITK_ok)printf("Ulozena Item 450\n");
		else printf("Neuložena Item \n");

		if (Schval_Rev!=NULLTAG && Schval_Bwr!=NULLTAG)
		{
			printf(">>>>>>>>>>>>\n schval  %d %d \n<<<<<<<<<<<<<<<\n", Schval_Rev, Schval_Bwr);
			tag_t release_stat;
			int	ifail = RELSTAT_create_release_status( "Approved", &release_stat );
			if(ifail != ITK_ok) {/* add your error logic here */}
										
			//tag_t devDoc;

			ifail = RELSTAT_add_release_status ( release_stat, 1, &Schval_Rev, true );
			 if(ifail != ITK_ok) {/* add your error logic here */}
				ifail = RELSTAT_add_release_status ( release_stat, 1, &Schval_Bwr, true );
			 if(ifail != ITK_ok) {/* add your error logic here */}
			 Schval_Rev=NULLTAG;
			 Schval_Bwr=NULLTAG;
									
		}

		AOM_unlock(IRev);
		//printf("---schval %d %s \n",Attr_num,hodnota);
		SetProperty (0,Attr_num,Item,Attr[0][12]);
		//SetProperty (0,Attr_num,Item,"1");
		//IntoFolder(folder,I);

		char *new_id;
		AOM_ask_value_string(Item,"item_id",&new_id);
		Zalozeny[zalozeny_num]=Item;
		zalozeny_num++;
		//printf("id nove položky je %s \n",new_id);
		Create_Sklad(Typ, hodnoty , IRev, Item);
	}else 
		{
		//	printf (" item s is %s uz existuje tag %d \n",hodnoty [2],Item);
			for (int j=0;j<zalozeny_num;j++)
			{
				printf(" %d = %d \n",Zalozeny[j],Item);
				if (Zalozeny[j]==Item)
				{	ITEM_ask_latest_rev(Item,&IRev);
					Create_Sklad(Typ, hodnoty , IRev, Item);
				}
			}
		}
		
}


 char* getfield(char* line, int num)
{
     char* tok;
    for (tok = strtok(line, ";");
            tok && *tok;
            tok = strtok(NULL, ";\n"))
    {
        if (!--num)
            return tok;
    }
    return NULL;
}

void ReadProperty()
{
		printf(" Read Property \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char Path[50]="C:\\SPLM\\Apps\\Import\\XML2TC_propertyZak.xml";


	    FILE* stream = fopen(Path, "r");
		printf("Open %s\n",Path);
    char line[1024],
		*tmp;
    while (fgets(line, 1024, stream))
    {
		
		tmp=strtok(line,">");
		
		
		//tmp=strtok(NULL,"<");
		if (strcmp(tmp,"<polozka")==0)
		{
			Attr_num=0;
			printf("polozka \n");
			goto nextLine;
			
		}
		else if (strcmp(tmp,"<ItemType")==0)
		{	strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("ItemType attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}
		else if(strcmp(tmp,"<string")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			//printf("string attr %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);
		}
		else if(strcmp(tmp,"<bl_string")==0)
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
			//tmp=strtok(
		}else if(strcmp(tmp,"<nowritte")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("noread %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}
		else if(strcmp(tmp,"<find")==0)
		{
			strcpy(Attr_type[Type_num][Attr_num],tmp);
			tmp=strtok(NULL,"<");
			printf("find %s \n",tmp);
			strcpy(Attr[Type_num][Attr_num],tmp);

		}
		else if(strcmp(tmp,"<login")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("login %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(login,tmp);
			goto nextLine;

		}
				else if(strcmp(tmp,"<psw")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("password %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(password,tmp);
			goto nextLine;

		}
			else if(strcmp(tmp,"<group")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("group %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(group,tmp);
			goto nextLine;

		}
		else if(strcmp(tmp,"<importFolder")==0)
		{
			//strcpy(Attr_type[Type_num][Attr_num],tmp);
			//tmp=strtok(NULL,">");
			tmp=strtok(NULL,"<");
			printf("import file %s\n",tmp);
			Attr_Typ_polozky=Attr_num;
			strcpy(import_file,tmp);

			goto nextLine;

		}
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

}
void GetAttr(char line[1024],char oddelovac){
	//char string[3][128];
	//int j=0;
	//for (int i=0;i<1024;i++)
	//{
	//	if (line[i]==oddelovac)
	//	{
	//		printf("oddelovac %c \n",line[i]);
	//		j++;
	//	}
	//	else 
	//	{
	//		if (line[i]=='|' && line[i+1]=='|')
	//			break;
	//		string[j][i]==line[i];
	//	}
	//}
	//printf("vypys %s %s %s \n",string[0],string[1],string[2]);
	//strcpy(I.I_Name,string[0]);
	//strcpy(I.Attr_Matr,string[1]);
	//strcpy(I.Rozmer,string[2]);
	
}
int Docisti(char* string)
{
	//printf("%s \n");
	char attr[700];
	int delkaCopy=0;
	for(int i=0;i<strlen(string);i++)
	{
		if(string[i-12]=='<'&& 
			string[i-11]=='/'&& 
			string[i-10]=='Q' && 
			string[i-9]=='Z'&&
			string[i-8]=='B'&&
			string[i-7]=='O'&&
			string[i-6]=='Z'&&
			string[i-5]=='I'&&
			string[i-4]=='_'&&
			string[i-3]=='T'&&
			string[i-2]=='P'&&
			string[i-1]=='V'&&
			string[i]=='>')
		{
			delkaCopy=i;
			printf("nalezeno \n");
			break;
		}
		//printf(" pocet %d \n",i);
			
	}
	
	strncpy(attr,string,delkaCopy);
	printf("delka copy retezce %d %s\n",delkaCopy,attr);	
	return delkaCopy;
}
void ReadXML(char* string)
{
	
	char *tmp;
	char Rozmer[128];
	char hodnoty[20][256];
	for(int t=0;t<20;t++)
		strcpy(hodnoty[t]," ");
	
	//printf("test red xml %s\n",string);

		tmp=strtok(string,">");
		//tmp=strtok(NULL,"<\QZBOZI_TPV>");
		
		for(int i=1;i<15;i++)
		{
		tmp=strtok(NULL,">");
		printf("%d Vlastnost = %s \n",i,tmp);
		if(strcmp("<TYP_ZBOZI",tmp)==0)
		{
			Attr_Typ_polozky=i;
		//	printf("typ %d \n",i);
		}
		else if (strcmp(tmp,"</QZBOZI_TPV")==0)
		{
		//	printf("shoda \n");
			break;
		}
		//printf("token %s \n",tmp);
		
		tmp=strtok(NULL,"<");

		printf("attr %d = %s \n",i,tmp);
		strcpy(hodnoty[i],tmp);
		tmp=strtok(NULL,">");
	//	printf("konec \n");
		}

	 Create_zak(hodnoty[Attr_Typ_polozky],hodnoty);
	 

}


int main(int argc, char *argv[])
{
   
	ReadProperty();
    // ITK inicializace
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);

    // Login
    int ReturnCode = TC_init_module(login, password, group);
    if(ReturnCode != ITK_ok)
    {
        fprintf(stderr, "ERROR: Login failed\n");
        return 1;
    }
    printf("Login OK\n");
	Polozka I;
	I.Poradi_atr=0;
	
	//printf(" Pred XML \n");
	//char*CSV = ITK_ask_cli_argument( "-u=");
	char*XML = ITK_ask_cli_argument( "-s=");
	//char CSVFile[50]="C:\\TC4TPV\\csv\\";
	//char XMLFile[50]="C:\\TC4TPV\\xml\\";
	char XMLFile[50]="";
	strcpy(XMLFile,import_file);
	strcat(XMLFile,XML);
	//strcat(XMLFile,".xml");
	//printf("CSVFile: %s \n",XMLFile);
	if(SouborExistuje(XMLFile)!=0){
		printf("file neexistuje \n");
		goto end;
	}else printf("soubor existuje\n");
	    FILE* stream = fopen(XMLFile, "r");
	printf("test\n");
    char line[7000];
	char *token;
	int vysledek=0;

		while (fgets(line, 7000, stream))
		{
			int delkaCopy=0,
				//delkaRetezce=700,
				konec=700,
				HelpPocet=0,
				start=0,
			    zaklad=0;
			//do
			//{	
									
				char attr[500];
				int Attr_num=0;
				printf("\n%d velikost %d  %d  \n %s\n",vysledek++,strlen(line),sizeof(line),line);
				//delkaCopy=0;

				for(int i=0;i<strlen(line);i++)
				{
	
					
						if(line[i-15]=='<'&& 
						line[i-14]=='/'&& 
						line[i-13]=='Q' && 
						line[i-12]=='Z' &&
						line[i-11]=='A' &&
						line[i-10]=='K'&&
						line[i-9]=='A'&&
						line[i-8]=='Z'&&
						line[i-7]=='K'&&
						line[i-6]=='A'&&
						line[i-5]=='_'&&
						line[i-4]=='T'&&
						line[i-3]=='P'&&
						line[i-2]=='V'&&
						line[i-1]=='>')
					{
						HelpPocet++;
						start=0;
						printf(" \n nalezeno %d \n pocet nalezu %d \n\n",i,HelpPocet);
						ReadXML(attr);
						Attr_num=0;
						for (int c=0;c<700;c++)
							attr[c]=' ';
					//break;
					}
				//	if(start==1)
					attr[Attr_num++]=line[i];
			
				}
				zaklad=zaklad+delkaCopy;
				konec=konec+delkaCopy;

			}
		
		if (Schval_Rev!=NULLTAG && Schval_Bwr!=NULLTAG)
		{
			
			tag_t release_stat;
			int	ifail = RELSTAT_create_release_status( "Approved", &release_stat );
			if(ifail != ITK_ok) {/* add your error logic here */}
										
			//tag_t devDoc;

			ifail = RELSTAT_add_release_status ( release_stat, 1, &Schval_Rev, true );
			 if(ifail != ITK_ok) {/* add your error logic here */}
				ifail = RELSTAT_add_release_status ( release_stat, 1, &Schval_Bwr, true );
			 if(ifail != ITK_ok) {/* add your error logic here */}
			 Schval_Rev=NULLTAG;
			 Schval_Bwr=NULLTAG;
									
		}

			//printf("pred importem \n");
			//(char* I_Name,char* I_popis, char* Attr_Matr,char* Velikost,char* Rozmer,char *Jednotka,char *KlicTPV,char *Typ,char *Evid_cena, char *Attr3)
			//Create(I.I_Name,I.I_Popis,I.Attr_Matr,I.Velikost,I.Rozmer,I.Jednotka,I.KlicTPV,I.Typ,I.Evid_cena,I.Attr3);
			printf("po importu \n");


	end:;
    return 0;
}

void VyplnKlicTPV(tag_t Rev,char* KlicTPV)
{
		AOM_lock(Rev);
		int tmp_int=atoi(KlicTPV);
		printf ("Klic TPV %s %d\n",KlicTPV,tmp_int );
		if(strcpy(KlicTPV," ")!=0)
			AOM_set_value_int(Rev, "tpv4_id_erp",tmp_int);
			AOM_set_value_string(Rev,"tpv4_stav_polozky","Platna");
		AOM_save(Rev);
		AOM_unlock(Rev);


}


int Existence(char* item_name_hledany,char* typ,char* KlicTPV)
	{
			int Vytvor=0;
			char* hledany_x=NULL,
				//* hledany_y=NULL,
			* povrch2_x=NULL,
			* povrch3_x=NULL,
			* stredisko_x=NULL,
			* poznamka_x=NULL,
			* TP=NULL,
			* material_se=NULL,
			* id_x=NULL,
			 Idd[ITEM_id_size_c + 1],
			 Namee[ITEM_name_size_c + 1];
			tag_t revItemu;
			int ItemsCountt = 0;
			tag_t *Itemss = NULLTAG;
			printf("test hledani \n");
			printf("test hledani %s \n",typ);
			 const char *Names[1] = { "object_type"};
			 if (strcmp(typ,"N")==0)
			 {
				 const char *Values[1] = {"TPV4_nak_dil"};
				 ITEM_find_items_by_key_attributes(1, Names, Values, &ItemsCountt, &Itemss);
				 printf(" Count %d \n",ItemsCountt);
			 }
			 else if(strcmp(typ,"H")==0)
			 {
				const char *Values[1] = {"TPV4_h_material"};
				ITEM_find_items_by_key_attributes(1, Names, Values, &ItemsCountt, &Itemss);
				
			 }
			 else
				 return 1;
	
				if(ItemsCountt == 0)
				{
					printf("\n Nenalezena žádná položka\n");
				}
				else
					{
						printf("\n Nalezeno %d položek\n", ItemsCountt);

					
						
						for(int i = 0; i < ItemsCountt; i++)
							{	
							
								ITEM_ask_latest_rev(Itemss[i],&revItemu);
								//printf("Namee %s \n Idd %s \n tag TP %d \n",Namee,Idd,revItemu);
								

										char *Value = NULL;
								AOM_ask_value_string(revItemu, "object_name", &hledany_x);
								

								if( strcmp(item_name_hledany,hledany_x)==0||strcmp(item_name_hledany,Idd)==0 )
								{ 
								
										Vytvor=1;
									int tmp_int=0;
										AOM_get_value_int(revItemu, "tpv4_id_erp",&tmp_int);
										
									if(tmp_int!=atoi(KlicTPV))
									{
										
										VyplnKlicTPV(revItemu, KlicTPV);
									}
								}	printf("Vytvor \n");
								//if(strlen(TP)==8)
							}
				}
			return Vytvor;
}