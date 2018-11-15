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


#define  item_id      "item_id"
#define  id_stredisko      "h4_V_stredisko"
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))


extern "C" DLLAPI int TPV_Vypocty_Hm_Plochy_Sestavy_TC10_register_callbacks();
extern "C" DLLAPI int TPV_Vypocty_Hm_Plochy_Sestavy_TC10_init_module(int *decision, va_list args);
int TPV_Vypocty_Hm_Plochy_Sestavy(EPM_action_message_t msg);
EPM_decision_t A_TPV_Vypocty_Hm_Plochy_Sestavy(EPM_rule_message_t msg);
int ListBomLine(tag_t BomLine, int Level, tag_t pamet[], int poradi,tag_t BomWindow,int Strom [6000][4]);
void SetDouble(tag_t object,double value,char *attr);
int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6000][4]);
void Odspodu(int Strom[6000][4], int poradi);
int MaxLVL(int Strom[6000][4], int poradi);

extern "C" DLLAPI int TPV_Vypocty_Hm_Plochy_Sestavy_TC10_register_callbacks()
{
    printf("Registruji handler-TPV_Vypocty_Hm_Plochy_Sestavy_TC10.dll\n");
    CUSTOM_register_exit("TPV_Vypocty_Hm_Plochy_Sestavy_TC10", "USER_init_module", TPV_Vypocty_Hm_Plochy_Sestavy_TC10_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Vypocty_Hm_Plochy_Sestavy_TC10_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Vypocty_Hm_Plochy_Sestavy", "", TPV_Vypocty_Hm_Plochy_Sestavy);
    if(Status == ITK_ok) printf("Handler pro zalozeni Variant s attributy z KV %s byl registrován 23\n", "TPV_Vypocty_Hm_Plochy_Sestavy");
    return ITK_ok;
}


int TPV_Vypocty_Hm_Plochy_Sestavy(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
  tag_t RootTask = NULLTAG;
int TargetsCount = 0;
 logical inContext=true;
tag_t *Targets = NULLTAG;
EPM_ask_root_task ( msg.task, &RootTask );//dostaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
//printf ("msg tag = %d\n", msg);
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
	for(int l=0;l<6000;l++){
		for (int p=0;p<3;p++){
			Strom [l][p]=0;
		}
	}

		WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
		//printf ("%s\n",Type);
		int BomsCount = 0;
        tag_t *Boms = NULLTAG;
        ITEM_rev_list_bom_view_revs(Targets[i], &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
        for(int j = 0; j < BomsCount; j++)
        {

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
		poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom);
			
			//BOM_refresh_window(BOM
        }
		Odspodu(Strom,poradi);
		BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
			printf("Konec \n");
}
    return ITK_ok;
}	 

void Odspodu(int Strom[6000][4], int poradi){
	int max=MaxLVL(Strom,poradi);
	for (int x=max;x>=0;x--)
	{printf("max level %d \n",x);
		for( int i =0;i<poradi;i++)
			{
				double HmS=0,
				PlochaSestavy=0;
				for( int y =0;y<poradi;y++)
					{
						if(Strom[i][2]==Strom[y][2]&&Strom[y][0]==x){
		
					

										// napoveda Strom[i][1] = tag bomline Strom[i][2] = tag parent boline Strom[i][0] = level
											int AttributeId,
												pocet=0;
											double Hmotnost=0,
													 Plocha=0;
												char *quantity=NULL,
														 * SEAR=NULL;
											tag_t Rev = NULLTAG;
											BOM_line_look_up_attribute("bl_revision", &AttributeId);
											BOM_line_ask_attribute_tag(Strom[y][1], AttributeId, &Rev);

											BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
											BOM_line_ask_attribute_string(Strom[y][1], AttributeId, &SEAR);

											BOM_line_look_up_attribute("bl_quantity", &AttributeId);
											BOM_line_ask_attribute_string(Strom[y][1], AttributeId, &quantity);
											pocet=atoi(quantity);
											if(pocet==0)pocet=1;
						
								

											logical inContext=true;
											//tag_t* folder=NULLTAG; 
											tag_t Item = NULLTAG;
											tag_t ItemParent = NULLTAG;
											tag_t* Lov = NULLTAG;
											char Id[ITEM_id_size_c + 1],
												IdOver[ITEM_id_size_c + 1],
												*Vykres_Norma=NULL,
												IdParent[ITEM_id_size_c + 1],
													RevId[ITEM_id_size_c + 1];
						
									
												//double mnozstvi=0;
											//AOM_ask_value_double(Rev,"h4_hmotnost",&Hmotnost);
											AOM_get_value_double(Rev,"h4_hmotnost",&Hmotnost);
											AOM_get_value_double(Rev,"h4_plocha",&Plocha);
											AOM_ask_value_string(Rev,"h4_vykres_norma",&Vykres_Norma);
											//printf("hmotnost dilu %f  VYKRES_NORMA %s quantity %d\n",Hmotnost,Vykres_Norma,pocet);
						
											//AOM_get_value_double(RevParent,"h4_hmotnost",&mnozstvi);
											if (strcmp(Vykres_Norma,"0")!=0 && strcmp(SEAR,"0")!=0)
											{
											HmS=(Hmotnost*pocet)+HmS;
											PlochaSestavy=(Plocha*pocet)+PlochaSestavy;
											}
											printf("hmotnost dilu %f Plocha %f  VYKRES_NORMA %s quantity %d hmotnost sestavy %f\n",Hmotnost,Plocha,Vykres_Norma,pocet,HmS);
											Strom[y][0]=max+1;
										
								}
							}
										char * SEAR=NULL;
								int AttributeId=0;
								tag_t RevParent = NULLTAG;
								BOM_line_look_up_attribute("bl_revision", &AttributeId);
								BOM_line_ask_attribute_tag(Strom[i][2], AttributeId, &RevParent);
						
							
						
								if(Strom[i][3]!=1 )
								{
									if((HmS >0))
									{
										printf("zapis hmotnosti.....%f \n",HmS);
										printf("max level %d \n",x);
										SetDouble(RevParent,HmS,"h4_hmotnost");
									}
									if((PlochaSestavy >0))
									{
										printf("zapis Plochy.....%f \n",PlochaSestavy);
										printf("max level %d \n",x);
										SetDouble(RevParent,PlochaSestavy,"h4_plocha");
									}
								}else printf("SE Asembly Report = 0 \n");
								
					
						}
					}
	printf("poradi = %d \n",poradi);
}

int MaxLVL(int Strom[6000][4], int poradi){
	int max=0;
	//printf ("size_t %d \n",size_t(Strom));
	for(int i=0;i<poradi;i++)
	{
		//printf(" %d > %d\n",Strom[i][0],Strom[i+1][0]);
		if(Strom[i][0]<=Strom[i+1][0])
		{
			printf("Max level %d \n",Strom[i+1][0]);
			max=Strom[i+1][0];
		}
	}
	printf("poradi = %d \n",poradi);
	return max;
}

int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6000][4]){
	int jetam=0;
	for(int j=0;j<=6000;j++)
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

int ListBomLine(tag_t BomLine, int Level, tag_t pamet[], int poradi,tag_t BomWindow,int Strom [6000][4])
{
	int pole[50][10];
	pole[25][5]=255;
	int plus=0;
	printf("--------- ListBomLine------------\n");
	//int Strom[6][3];

	printf("start Level = %d poradi %d \n", Level, poradi);
		
	pamet[Level]=BomLine;
	printf (" tak bom line %d \n",BomLine);
	int AttributeId;
		tag_t Rev = NULLTAG;
		char* SEAR = NULLTAG;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(pamet[Level], AttributeId, &Rev);
		printf (" tak Rev %d \n",Rev);
		
		//SE Assembly Reports
				BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &SEAR);
				printf(" SE Assembly Reports %s \n",SEAR);
	/*	double Hmotnost;
			AOM_get_value_double(Rev,"h4_hmotnost",&Hmotnost);
						printf("hmotnost dilu %f \n",Hmotnost);*/



    // Potomci
	//double hmotnost=0;
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);

	for(int t=0;t<ChildsCount;t++)
	{
			if((Shoda(Level, BomLine, Rev,poradi, Strom))==0){
				printf(" poradi %d \n ", poradi);
			Strom[poradi][0]=Level+1;
				printf(" poradi %d \n ", poradi);
			printf("level %d\n",Level);
			Strom [poradi][1]=Childs[t];
				printf(" poradi %d \n ", poradi);
			printf("bomline %d\n",Childs[t]);
			Strom [poradi][2]=BomLine;
			printf("Rev %d \n",Rev);
			if (strcmp(SEAR,"0")==0){
			Strom [poradi][3]=1;
			}
			poradi=poradi+1;
			}
	}

	//printf("Count %d \n", ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)
	{	
	
		poradi=ListBomLine(Childs[k], Level + 1, pamet, poradi, BomWindow,Strom);
		
	}
	printf(" pred koncem poradi %d\n",poradi);
	
	return poradi;
}
void SetDouble(tag_t object,double value,char *attr)
{
	//printf("set double \n");
	//ITK_set_bypass(true);
	//POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	AOM_lock(object);
	AOM_set_value_double(object,attr,value);
	AOM_save(object);
	AOM_unlock(object);
	//POM_set_env_info( POM_bypass_access_check, FALSE, 0, 0.0, NULLTAG, "" );
	//ITK_set_bypass(false);
	//AOM_unload(object);
	AOM_refresh(object,1);
	//printf("Vlozeno %f \n",value);
}