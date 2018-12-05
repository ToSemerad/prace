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
#include <time.h>
#include <tccore\aom.h>

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Get_pos_num_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Get_pos_num_TC11_init_module(int *decision, va_list args);
int TPV_Get_pos_num(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,char* id_vrcholu,int number);

extern "C" DLLAPI int TPV_Get_pos_num_TC11_register_callbacks()
{
    printf("Registruji TPV_Get_pos_num_TC11.dll\n");
    CUSTOM_register_exit("TPV_Get_pos_num_TC11", "USER_init_module", TPV_Get_pos_num_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Get_pos_num_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Get_pos_num", "", TPV_Get_pos_num);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Get_pos_num");

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

void Logfile()
{

}

void SetString(tag_t object,char* value,char* attribut)
{
	AOM_lock(object);
	AOM_set_value_string(object,attribut,value);
	AOM_save(object);
	AOM_unlock(object);
	//AOM_unload(object);
	printf("Vlozeno %s\n",value);
}

int SaveLast_num(char *zapis,int c,char* filename)
{

		//char new_name[20];
		FILE *fw;

 char file[50];
 strcpy(file,"C:\\SPLM\\Apps\\Ciselne_rady\\");
 strcat(file,filename);
  //if (SouborExistuje(file)==1)
	
 strcat(file,".lun");//last use number
 printf("file %s \n",file);

 if(SouborExistuje(file)==0)
		{
			fw=fopen(file,"r+");
			//printf("otevren \n");
		}
// printf("zapis \n"); 
// fprintf(fw,"test");
 strtok(zapis,"|");
for (int i=0;i<=c;i++)
{
	//printf("cilkuls %d \n",i);
	//char line[50];
//	strcpy(line,strtok(NULL,"|"));
//	printf("line %s \n",line);
	fprintf(fw,"%s",strtok(NULL,"|"));
}

		
	fclose(fw);
	return ITK_ok;
}

int New_number(char* line,char *rada)
{
	int new_num=0;
	if(strcmp(strtok(line,";"),rada)==0)
	{
		//printf("rada %s \n",rada);
		char  *hodnota;
		hodnota=strtok(NULL,";");
		//printf ("hodnota old %s \n",hodnota); 
		new_num=atoi(hodnota);
	//	printf("1)new_num %d \n",new_num);
		new_num++;
		//printf("2)new_num %d \n",new_num);
	}

	return new_num;
}

char* GetName (char * predpona,char* filename, tag_t rev)
	{
		char last_name[10];
		char new_name[20];
		char number[5];
		FILE *fr;
	char zapis[2000];
 char file[50];
 int c=0;
 strcpy(file,"C:\\SPLM\\Apps\\Ciselne_rady\\");
 strcat(file,filename);
  //if (SouborExistuje(file)==1)
	
 strcat(file,".lun");//last use number
 printf("file %s \n",file);

 strcpy(zapis,"___|");
 if(SouborExistuje(file)==0)
		{
			fr=fopen(file,"r");
		}	    

    char line[1024];
	
    while (fgets(line, 1024, fr))
    {
		//printf("line %s \n",line);
		char cpy_line[50];
		strcpy(cpy_line,line);
		if(strchr(line,';')!=NULL)
		{
			int new_num=New_number(line,predpona);
			if (new_num>0)
			{
				
				sprintf(last_name,"%d",new_num);
				//printf("delka retezce %d \n",strlen(last_name));
				strcpy(new_name,predpona);
				/*for(int i =0;i<5-strlen(last_name);i++)
				{
					if(i==0)
					strcpy(number,"0");
					else
					strcat(number,"0");
				}*/
				//strcat(number,last_name);
				//strcat(new_name,number);
				strcat(new_name,"-");
				strcat(new_name,last_name);
			//	printf("last name %s \n",new_name);
					goto found;
			}
		
				
			
		}
	//	printf("else %s \n",cpy_line);
		
		strcat(zapis,cpy_line);
		strcat(zapis,"|");
		c++;
    }

found:;
	strcat(zapis,predpona);
	strcat(zapis,";");
	//strcat(zapis,number);
	strcat(zapis,last_name);
	strcat(zapis,";");
	strcat(zapis,"|");
	//printf(">>> %s <<< \n",zapis);
	SetString(rev,new_name,"tpv4_cislo_vykresu");
	SaveLast_num(zapis,c,filename);
	
	return new_name;
	}

int TPV_Get_pos_num(EPM_action_message_t msg)
{

    tag_t

		RootTask=NULLTAG;
	int TargetsCount = 0;
tag_t *Targets = NULLTAG;
tag_t TargetClassTag = NULLTAG;
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;

	EPM_ask_root_task ( msg.task, &RootTask );

    
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"

for( int i = 0; i < TargetsCount; i ++ )
{
	char *rada;
	POM_class_of_instance(Targets[i], &TargetClassTag);
	AOM_ask_value_string(Targets[i],"tpv4_typ_naradi",&rada);
	printf("rada %s \n",rada);
	char * new_name=GetName (rada,"naradi",Targets[i]);
	printf("%s = new_name \n",new_name);

				int BomsCount = 0;
				tag_t *Boms = NULLTAG;
				ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
				for(int j = 0; j < BomsCount; j++)
				{
					printf("pred bom line %d \n",BomsCount);
					 //BOM window
					tag_t BomWindow = NULLTAG;
					BOM_create_window(&BomWindow);
					tag_t BomTopLine = NULLTAG;

					 //Výpis BOM line 
					BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
				
					//nastaveni context bomline absolute occurrence edit mode			
					//BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
					printf("id_vrcholu %s \n",new_name);
					//ListBomLine(BomTopLine, 0, RootTask,BomWindow,new_name,0);
					BOM_refresh_window(BomWindow);
					BOM_close_window(BomWindow);
				
				}

}
    return ITK_ok;
}

void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,char* id_vrcholu,int number)
{
	printf("ListBomLine sid_vrcholu %s \n",id_vrcholu);
    // Revize
    int AttributeId;
    tag_t Rev = NULLTAG;
    BOM_line_look_up_attribute("bl_revision", &AttributeId);
    BOM_line_ask_attribute_tag(BomLine, AttributeId, &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
    char Id[ITEM_id_size_c + 1],
		RevId[ITEM_id_size_c + 1],
		*Type;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id(Item, Id);
    ITEM_ask_rev_id(Rev, RevId);

	printf("level %d item =%s/%s \n",Level,Id,RevId);
	printf("vykres %s_%d \n",id_vrcholu,++number);
    // Množství
	//long d_stredisko;//pocet znakù strediska
	//long d_povrch1;//pocet znaku povrch1
	//char *polotovar;
	//char *stredisko;
	//char* varianta;
	//char *Value = NULL;
	//int is_released=0;
	//EPM_ask_if_released(Rev,&is_released);
	//if (is_released==0 && Level!=0)
	//{
	//		WSOM_ask_object_type2(Rev,&Type);

	//	if(strcmp(Type,"TPV4_dilRevision")==0) 
	//	{	
	//				if( CountInRelation(Rev,"TPV4_tp_rel",RootTask)==0)
	//				{
	//					 newTP( Rev, user_name,RootTask );
	//					}else printf("nenalezen TP u %s/%s \n",Id,RevId);		
	//	}else printf ("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	//}else printf("schvaleno %s/%s \n",Id,RevId);	
	//

   //  Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	printf("childs %d \n",ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow,id_vrcholu,number);
	 MEM_free(Childs);
	printf("Konec \n");
	 //printf(" ...konec..\n \n");
		//MEM_free(povrch1);		
		//MEM_free(stredisko);		
		//MEM_free(varianta);
		//MEM_free(Value);
   
	//AddToTarget(RootTask,"V",TP);
}