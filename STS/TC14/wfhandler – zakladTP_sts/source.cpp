#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <epm/epm.h>
#include <ict/ict_userservice.h>

#include <user_exits/user_exits.h>
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


#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))
#define ECHO(X)  printf X; TC_write_syslog X

extern "C" DLLAPI int TPV_Create_I_TP_TC14_register_callbacks();
extern "C" DLLAPI int TPV_Create_I_TP_TC14_init_module(int *decision, va_list args);
int TPV_Create_I_TP(EPM_action_message_t msg);
EPM_decision_t A_TPV_Create_I_TP(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask,tag_t BomWindow,char* user_name);
void AddToTarget(tag_t RootTask,char* O_Name,tag_t Item);
void MoveTPToFolder(tag_t folder,tag_t object);
void removeTP(tag_t folder,tag_t object);
void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr);
void Add_S_ToTP(char* povrch1, char* povrch2, char* povrch3,tag_t TPrev, tag_t TP);
int Existence(char* povrch1, char* povrch2, char* povrch3, char* stredisko, char* poznamka,char* id, char* rev, char* var,tag_t BomLine,int AttributeId,tag_t BomWindow, tag_t revDil);
void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr);
int kontrolaLov(char* vstup, char* Lov,char* Zlovu );
void newTP(tag_t Rev, char* user_name ,tag_t RootTask);
int CountInRelation(tag_t Otec,char * Relation,tag_t RootTask);

extern "C" DLLAPI int TPV_Create_I_TP_TC14_register_callbacks()
{
    ECHO(("Registruji handler-TPV_Create_I_TP_TC14.dll\n"));
    CUSTOM_register_exit("TPV_Create_I_TP_TC14", "USER_init_module", TPV_Create_I_TP_TC14_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Create_I_TP_TC14_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Create_I_TP", "", TPV_Create_I_TP);
    if(Status == ITK_ok) ECHO(("Handler pro zalozeni TP s attributy z KV %s \n", "TPV_Create_I_TP"));


    return ITK_ok;
}
int Ask_BomView (tag_t Rev)
{
		int n_bvrs = 0;
	tag_t *bvrs = NULL;
	ITEM_rev_list_bom_view_revs(Rev, &n_bvrs, &bvrs);
return n_bvrs;
}

//void Add_latets_rev_TP_ToRef(tag_t RootTask,tag_t Item, int Count)
//{
//	ECHO(("74tak posilam do Targetu Roottask %d Item %d  \n",RootTask,Item);
//	const int AttachmentTypes[1] = {EPM_reference_attachment};
//	ECHO(("76test \n");
//	for(int i =0;i<Count;i++)
//	{
//		ECHO(("79\n");
//		tag_t Object_rev=NULLTAG;
//		ECHO(("81\n");
//		ITEM_ask_latest_rev(Item,&Object_rev);
//
//		ECHO(("Do referenci \n");
//		EPM_add_attachments(RootTask, Count, &Object_rev, AttachmentTypes);
//	}
//	//int Count;
//	
//
//	
//    ECHO(("nakonci ciklu\n");
//}

int TPV_Create_I_TP(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde
tag_t RootTask = NULLTAG;
int TargetsCount = 0;
tag_t *Targets = NULLTAG;
tag_t *rootLine = NULLTAG;
tag_t TargetClassTag = NULLTAG;
char* user_name;
tag_t user_tag;
//tag_t person_tag;
//char* P_organ;

EPM_ask_root_task ( msg.task, &RootTask );//dotaz na tag tasku ke kterému je handler pripojeny
EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"
ECHO(("TargetsCount %d ",TargetsCount));
POM_get_user(&user_name, &user_tag);
ECHO(("\n-----Jmeno %s tag %d-------\n",user_name,user_tag));
//SA_find_person2(user_name,&person_tag);
//ECHO(("person tag %d \n",person_tag);
//SA_ask_person_attribute2(person_tag,"PA6",&P_organ);
//ECHO(("organisation %s \n",P_organ);
for( int i = 0; i < TargetsCount; i ++ )
{
POM_class_of_instance(Targets[i], &TargetClassTag);


logical IsRevision = false;
POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);



if(IsRevision == false) continue;
	char *Type;
	WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
	ECHO(("%s\n",Type));
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
			ListBomLine(BomTopLine, 0, RootTask,BomWindow,user_name);
			BOM_refresh_window(BomWindow);
            BOM_close_window(BomWindow);
			
        }

			int is_released=0;
	EPM_ask_if_released(Targets[i],&is_released);
	if (is_released==0)
	{
			WSOM_ask_object_type2(Targets[i],&Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{	
					if( CountInRelation(Targets[i],"TPV4_tp_rel",RootTask)==0)
					{
						 newTP( Targets[i], user_name,RootTask );
						}//else ECHO(("nenalezen TP u %s/%s \n",Id,RevId);		
		}//else ECHO(("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId);
	}//else ECHO(("schvaleno %s/%s \n",Id,RevId);	
	
		// newTP(Targets[i], user_name );
}
	
    return ITK_ok;
}

void CreateView ( tag_t TPrev, tag_t TP)
{
	tag_t BomWindowTP = NULLTAG,
		bvr=NULLTAG;
	// BomView Type
	tag_t BomViewType= NULLTAG;
	PS_ask_default_view_type( &BomViewType);	
	PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
	AOM_save_with_extensions (BomWindowTP);
	ITEM_save_item(TP);

    PS_create_bvr (BomWindowTP, NULL, NULL,  true, TPrev, &bvr);
    AOM_save_with_extensions (bvr);
    AOM_save_with_extensions(TPrev);
	AOM_lock(bvr);
//int Status=PS_create_occurrences(bvr,*P1,NULLTAG,1,&Occ);
		tag_t *Occ;				
	int Status=PS_create_occurrences(bvr,NULLTAG,NULLTAG,0,&Occ);
	ECHO((" status %d \n",Status));
	if(Status ==ITK_ok)EMH_clear_last_error(Status);

	AOM_save_with_extensions(bvr);
	AOM_unlock(bvr);

	MEM_free(Occ);
}

void ADD2Relation(tag_t Otec,tag_t Object,char * Relation)
{
			 tag_t relation_type,
			relation;
    GRM_find_relation_type(Relation, &relation_type);
	//ECHO(("207 find relation %d %d %d \n",relation_type,Otec,Object);
	GRM_create_relation(Otec, Object, relation_type, NULLTAG,&relation);
	//ECHO(("209\n");
	GRM_save_relation(relation);
	//ECHO(("konec relace \n");
}
int CountInRelation(tag_t Otec,char * Relation,tag_t RootTask)
{
	int Count=0;
	tag_t * 	secondary_list;
			 tag_t relation_type;
    int err=GRM_find_relation_type(Relation, &relation_type);
	if(err!=ITK_ok){ECHO(("Problem err %d \n",err));}
	//ECHO(("220 find relation %d \n",relation_type);
	 err=GRM_list_secondary_objects_only(Otec, relation_type, &Count, &secondary_list);
	 ECHO(("count %d \n",Count));
	if(err!=ITK_ok){ECHO(("Problem err %d \n",err));}
	//ECHO(("secondary list [0] %d \n",*secondary_list);
	//if(Count>0)
	//Add_latets_rev_TP_ToRef( RootTask,secondary_list[0], Count);
	return Count;
}

void ListBomLine(tag_t BomLine, int Level, tag_t RootTask, tag_t BomWindow,char* user_name)
{
	
    // Revize
   // int AttributeId;
    tag_t Rev = NULLTAG;
   // BOM_line_look_up_attribute("bl_revision", &AttributeId);
	AOM_ask_value_tag(BomLine, "bl_revision", &Rev);

    tag_t* folder=NULLTAG; 
	tag_t Item = NULLTAG;
	tag_t* Lov = NULLTAG;
	
	
    char *Id = NULLTAG,
		*RevId = NULLTAG,
		*Type;
    ITEM_ask_item_of_rev(Rev, &Item);
    ITEM_ask_id2(Item, &Id);
    ITEM_ask_rev_id2(Rev, &RevId);

    // Množství
	//long d_stredisko;//pocet znakù strediska
	//long d_povrch1;//pocet znaku povrch1
	//char *polotovar;
	//char *stredisko;
	//char* varianta;
	//char *Value = NULL;
	int is_released=0;
	EPM_ask_if_released(Rev,&is_released);
	if (is_released==0 && Level!=0)
	{
			WSOM_ask_object_type2(Rev,&Type);

		if(strcmp(Type,"TPV4_dilRevision")==0) 
		{	
					if( CountInRelation(Rev,"TPV4_tp_rel",RootTask)==0)
					{
						 newTP( Rev, user_name,RootTask );
						}else ECHO(("nenalezen TP u %s/%s \n",Id,RevId));		
		}else ECHO(("Neni TPV4_dil je %s u %s/%s\n",Type,Id,RevId));
	}else ECHO(("schvaleno %s/%s \n",Id,RevId));	
	

   //  Potomci
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
    for(int k = 0; k < ChildsCount; k ++)ListBomLine(Childs[k], Level + 1,RootTask, BomWindow,user_name);
	 MEM_free(Childs);
	ECHO(("Konec \n"));
	 //ECHO((" ...konec..\n \n");
		//MEM_free(povrch1);		
		//MEM_free(stredisko);		
		//MEM_free(varianta);
		//MEM_free(Value);
   
	//AddToTarget(RootTask,"V",TP);
}
void AddToTarget(tag_t RootTask,char* O_Name,tag_t Item)
{
	ECHO(("tak posilam do Targetu Roottask %d Item %d jmeno %s \n",RootTask,Item,O_Name));
	tag_t* Object = NULLTAG;
	int Count;
	const int AttachmentTypes[1] = {EPM_target_attachment};
	const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
	const char *AttrValues[1] = {O_Name};
	FL_user_update_newstuff_folder(Item);

	ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &Count, &Object);
	ECHO(("nalezen object %s s tagem %d a poctem objectu %d AttrValues %s AttrName %s \n",O_Name,Object,Count,AttrValues,AttrNames));
	EPM_add_attachments(RootTask, Count, Object, AttachmentTypes);
    ECHO(("nakonci ciklu\n"));
}
void MoveTPToFolder(tag_t folder,tag_t object)
{ 
   //insert to folder
    AOM_refresh( folder, TRUE);
    FL_insert(folder, object, 0);
    AOM_save_with_extensions(folder);
    AOM_refresh( folder, TRUE);
	ECHO(("vlozeno!!!!!!!!!!!\n"));
}

void SetBomLineString( tag_t BomWin, tag_t BomLine, char* value, char* Attr)
{int AttrId=0;
//BOM_line_look_up_attribute(Attr, &AttrId);
AOM_UIF_set_value(BomLine, Attr, value);
BOM_save_window(BomWin);
}

void newTP(tag_t Rev, char* user_name ,tag_t RootTask)
{
	
char *c_vykres;
						AOM_ask_value_string(Rev,"tpv4_cislo_vykresu",&c_vykres);
						
								ECHO(("Zaloz novou TP \n"));
		
								tag_t itemType = NULLTAG;
								tag_t revType = NULLTAG;
								tag_t createItem = NULLTAG;
								tag_t createRev = NULLTAG;
								tag_t Lov=NULLTAG,
									TPrev=NULLTAG,
									TP=NULLTAG;

								//revise
								TCTYPE_find_type("TPV4_tpRevision", NULL, &revType);
								/*if (revType == NULLTAG) {
									ECHO(("Spatny typ revize");
								}*/
								ECHO(("Tag rev itemu %d \n", revType));
								TCTYPE_construct_create_input(revType, &createRev);

			
	
								//itemy
								TCTYPE_find_type("TPV4_tp", NULL, &itemType);
								ECHO(("Tag itemu %d \n", itemType));
								TCTYPE_construct_create_input(itemType, &createItem);
								//if(d_povrch1==0)strcpy(povrch1,"S00005");
									AOM_set_value_tag(createItem, "revision", createRev);
									AOM_set_value_string(createItem, "object_name", "TP");
									AOM_set_value_string(createRev, "tpv4_tp_cislo_vykresu", c_vykres);
									AOM_set_value_string(createRev, "tpv4_tp_autor_postupu", user_name);

									TCTYPE_create_object(createItem, &TP);
									AOM_save_with_extensions(TP);
								ADD2Relation(Rev,TP,"TPV4_tp_rel");

								//Add_latets_rev_TP_ToRef(RootTask,TP, 1);
								ITEM_ask_latest_rev(TP, &TPrev);
							//	CreateView (TPrev, TP);
								/*const int AttachmentTypes[1] = {EPM_target_attachment};
								EPM_add_attachments(RootTask, 1, &TP, AttachmentTypes);
		*/
}
int Existence(char* povrch1, char* povrch2, char* povrch3, char* stredisko, char* poznamka,char* id, char* rev, char* var,tag_t BomLine,int AttributeId,tag_t BomWindow, tag_t revDil)
	{
			int Vytvor=0;
			char* povrch1_x=NULL;
			char* povrch2_x=NULL;
			char* povrch3_x=NULL;
			char* stredisko_x=NULL;
			char* poznamka_x=NULL;
			char* TP=NULL;
			char* id_x=NULL;
			char *Idd = NULLTAG;
			char *Namee = NULLTAG;
			tag_t revItemu;
			
			 const char *Names[1] = { "object_type"};
			const char *Values[1] = { "H4_TP"};
			int ItemsCountt = 0;
			tag_t *Itemss = NULLTAG;
			ITEM_find_items_by_key_attributes(1, Names, Values, &ItemsCountt, &Itemss);

	
				if(ItemsCountt == 0)
				{
					ECHO(("\n Nenalezena žádná položka\n"));
				}
				else
					{ECHO(("\n Nalezeno %d položek\n", ItemsCountt));

						// Výpis položek
						
						for(int i = 0; i < ItemsCountt; i++)
							{	
								ITEM_ask_id2(Itemss[i], &Idd);
								ITEM_ask_name2(Itemss[i], &Namee);
								ITEM_ask_latest_rev(Itemss[i],&revItemu);
								ECHO(("Namee %s \n Idd %s \n tag TP %d \n",Namee,Idd,revItemu));
								

										char *Value = NULL;
								AOM_ask_value_string(revItemu, "h4_TP_povrch1", &povrch1_x);
								AOM_ask_value_string(revItemu, "h4_TP_povrch2", &povrch2_x);
								AOM_ask_value_string(revItemu, "h4_TP_povrch3", &povrch3_x);
								AOM_ask_value_string(revItemu, "h4_TP_stredisko", &stredisko_x);
								AOM_ask_value_string(revItemu, "h4_TP_poznamka", &poznamka_x);
								AOM_ask_value_string(revItemu, "h4_TP_cislo_KP", &id_x);
								ECHO(("-STREDISKA %s \n %s \n",stredisko,stredisko_x));

								ECHO(("%s %s, %s, %s, %s, poznamka : %s\n",id_x , povrch1_x, povrch2_x, povrch3_x, stredisko_x,poznamka_x));
		
								//if( strcmp(povrch1,povrch1_x)==0 && strcmp(povrch2,povrch2_x)==0 && strcmp(povrch3,povrch3_x)==0 && strcmp(poznamka,poznamka_x)==0 && strcmp(id,id_x)==0 ) 
									if( strcmp(povrch1,povrch1_x)==0 && strcmp(povrch2,povrch2_x)==0 && strcmp(povrch3,povrch3_x)==0 && kontrolaLov(stredisko, "H4_stredisko", stredisko_x)==1 && strcmp(poznamka,poznamka_x)==0 && strcmp(id,id_x)==0 ) 
									{
													ECHO(("polozka se shoduje Idd je %s \n",Idd));
																				//zapsani do Var cislo TP
																				ECHO((" %s \n %s \n",poznamka,poznamka_x));
																				const char *Vlastnost[1] = { ITEM_ITEM_ID_PROP };
																				const char *Values[1] = { var };
																				ECHO(("hledana var %s \n",var));
																				int VarCount = 0;
																				tag_t *Var = NULLTAG;
																				ITEM_find_items_by_key_attributes(1, Vlastnost, Values, &VarCount, &Var);
																				ECHO(("pocet nalezenych variant va radku %d \n",VarCount));
																				AOM_lock(*Var);
																				AOM_set_value_string(*Var,"h4_V_cislo_TP",Idd);
																				AOM_save_with_extensions(*Var);
																				AOM_unlock(*Var);

																			//pridani do BOMLine
													SetBomLineString(BomWindow, BomLine, Idd, "H4_KV_Cislo_TP");
													Vytvor=1;
													i=ItemsCountt;
																				
									}else 
										{
											TP="NULL";
											ECHO(("neshoduji se p1 a p1_xdelka1 je %zd delka je %zd tedy TP %s \n",strlen(id),strlen(id_x),TP));
										}
								//if(strlen(TP)==8)
							}
				}
			return Vytvor;
			
	}
void Add_S_ToTP(char* povrch1, char* povrch2, char* povrch3, tag_t TPrev, tag_t TP)
{
		tag_t BomWindowTP = NULLTAG;
		tag_t TopBomLineTP =NULLTAG;
		tag_t* P1 = NULLTAG;
		tag_t* P2 = NULLTAG;
		tag_t* P3 = NULLTAG;
		tag_t query = NULLTAG;
		tag_t bvr =NULLTAG;
		tag_t P1rev=NULLTAG;
		tag_t P2rev=NULLTAG;
		tag_t P3rev=NULLTAG;

		char* rev_id = NULLTAG;
		//tag_t BomViewType =NULLTAG;

		// BomView Type
tag_t BomViewType= NULLTAG;
PS_ask_default_view_type( &BomViewType);
		
							const char *entries1[1] = {ITEM_ITEM_ID_PROP};
							const char *values1[1] =  {povrch1};
							int n_folder1 = 0;
   
							ITEM_find_items_by_key_attributes(1, entries1, values1, &n_folder1, &P1);
							
							ITEM_ask_latest_rev(*P1,&P1rev);
							

							const char *entries2[1] = {ITEM_ITEM_ID_PROP};
							const char *values2[1] =  {povrch2};
							int n_folder2 = 0;
   
							ITEM_find_items_by_key_attributes(1, entries2, values2, &n_folder2, &P2);
							

							const char *entries3[1] = {ITEM_ITEM_ID_PROP};
							const char *values3[1] =  {povrch3};
							int n_folder3 = 0;
   
							ITEM_find_items_by_key_attributes(1, entries3, values3, &n_folder3, &P3);
							


							PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
	AOM_save_with_extensions (BomWindowTP);
	ITEM_save_item(TP);

    PS_create_bvr (BomWindowTP, NULL, NULL,  true, TPrev, &bvr);
    AOM_save_with_extensions (bvr);
    AOM_save_with_extensions(TPrev);	
	//PS_set_bvr_imprecise(bvr);
	//PS_set_bvr_precise(bvr);
	//pridani potomku do kusovniku
	tag_t *Occ=NULLTAG;	
							// ECHO(("tag BW %d tag bvr %d \n",BomWindowTP,bvr);
							ITEM_ask_rev_id2(P1rev,&rev_id);
							ECHO(("rev_id %s \n", rev_id));
							 AOM_lock(bvr);
							//int Status=PS_create_occurrences(bvr,*P1,NULLTAG,1,&Occ);
						
								int Status=PS_create_occurrences(bvr,P1rev,NULLTAG,1,&Occ);
								ECHO((" status %d \n",Status));
								if(Status ==ITK_ok)EMH_clear_last_error(Status);
							 if (n_folder2 !=0)
							 {
								 ECHO(("povrch2 vlozit \n"));
								ITEM_ask_latest_rev(*P2,&P2rev);
									Status=PS_create_occurrences(bvr,P2rev,NULLTAG,1,&Occ);
									if(Status ==ITK_ok)EMH_clear_last_error(Status);
							 }
							 if (n_folder3 !=0)
							 {
								 ECHO(("povrch3 vlozit \n"));
								 ITEM_ask_latest_rev(*P3,&P3rev);
									Status=PS_create_occurrences(bvr,P3rev,NULLTAG,1,&Occ);
									if(Status ==ITK_ok)EMH_clear_last_error(Status);
							 }
							 ECHO(("tag Occ %d \n",*Occ));
							 AOM_save_with_extensions(bvr);
							 AOM_unlock(bvr);

							 MEM_free(Occ);


}
void SetString(tag_t object,char* value)
{
	AOM_lock(object);
	AOM_set_value_string(object,"h4_V_cislo_TP",value);
	AOM_save_with_extensions(object);
	AOM_unlock(object);
	//AOM_unload(object);
	ECHO(("Vlozeno\n"));
}
void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr )
{
	ECHO(("vyplnovani \n"));
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	//tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;
	
	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		ECHO(("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]));
		if(strcmp(values_dissplay[j],hodnota)==0)
			{
				ECHO(("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]));
				AOM_set_value_string(cil, attr, values[j]);
				j=n_values;
			}
	}

}
int kontrolaLov(char* vstup, char* Lov,char* Zlovu )
{
	int vysledek=0;
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	//tag_t* tagy;
	LOV_usage_t usage;
	char** values_dissplay;

	LOV_find(Lov, &n_lovs, &lov_tag);
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		ECHO(("cislo %d hodnoty %s popis %s \n",j,values[j],values_dissplay[j]));
		if(strcmp(values_dissplay[j],vstup)==0 && strcmp(values[j],Zlovu)==0)
			{
				vysledek=1;
				j=n_values;
			}
	}
	return vysledek;
}
