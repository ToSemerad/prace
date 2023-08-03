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


#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_TC2TPV_TC10_register_callbacks();
extern "C" DLLAPI int TPV_TC2TPV_TC10_init_module(int *decision, va_list args);
int TPV_TC2TPV(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);

char Nazvy[100][20][128];

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

int ListBomLine(tag_t BomLine, int Level, tag_t pamet[], int poradi,tag_t BomWindow,int Strom [6][4])
{
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
	int AttributeId;
		tag_t Rev = NULLTAG;
		char* SEAR = NULLTAG;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(pamet[Level], AttributeId, &Rev);
		BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &I_ID_v);
		
		printf (" tak Rev %d \n",Rev);
		
		//SE Assembly Reports
				BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &SEAR);
				printf(" SE Assembly Reports %s \n",SEAR);
		double Hmotnost;
			AOM_get_value_double(Rev,"h4_hmotnost",&Hmotnost);
						printf("hmotnost dilu %f \n",Hmotnost);
	if( Level==0)
	{
				BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &I_ID);

						BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &REV_ID);
		
		//strcpy(Nazvy[poradi][0],"-");
		strcpy(Nazvy[poradi][1],I_ID);
		strcpy(Nazvy[poradi][2],REV_ID);
	}
	

    // Potomci
	double hmotnost=0;
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	

	for(int t=0;t<ChildsCount;t++)
	{
		poradi=poradi+1;
				BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &I_ID);

						BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		BOM_line_ask_attribute_string(Childs[t], AttributeId, &REV_ID);
		
		strcpy(Nazvy[poradi][0],I_ID_v);
		strcpy(Nazvy[poradi][1],I_ID);
		strcpy(Nazvy[poradi][2],REV_ID);
		printf("Poradi %d Vrchol %s Dil %s Rev %s \n",poradi,I_ID_v,I_ID,REV_ID);
		//poradi=poradi+1;
			/*if((Shoda(Level, BomLine, Rev,poradi, Strom))==0){
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
			}*/
	}

	//printf("Count %d \n", ChildsCount);
    for(int k = 0; k < ChildsCount; k ++)
	{	
	
		poradi=ListBomLine(Childs[k], Level + 1, pamet, poradi, BomWindow,Strom);
		
	}
	printf(" pred koncem poradi %d\n",poradi);
	
	return poradi;
}
void create_marks_csv(char *filename,int m){
 
printf("\n Creating %s.csv file",filename);
 
FILE *fp;
 
int i,j;
 char file[50];
 strcpy(file,"C:\\TC4TPV\\csv\\");
 strcat(file,filename);
printf("test1 \n");
 strcat(file,".csv");
 printf("file %s \n",file);
fp=fopen(file,"a");
 printf("test po zaèátku zápisu \n");
//fprintf(fp,attr);
 
for(i=0;i<m;i++){
	printf ("fprint %d \n",i);
  
    for(j=0;j<=2;j++)
        fprintf(fp,",%s ",Nazvy[i][j]);

	fprintf(fp,"\n");
    }
    //fprintf(fp,"\n%d",i+1);
fclose(fp);
 
printf("\n %sfile created",filename);
 
}
void CallBridge(char* file)
{
	char ImportTPV[256]="C:\\TC4TPV\\TPV_Bridge_TC4TPV.jar ";
	strcat(ImportTPV,file);
	 system(ImportTPV);
}
 

int TPV_TC2TPV(EPM_action_message_t msg)
{
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
        task_name[WSO_name_size_c+2] = "",
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

			
		
		AOM_UIF_ask_value(job,"object_name",&job_name);
	for (int k =0;k<strlen(job_name);k++)
	{
		if(job_name[k]=='/')job_name[k]='_';

	}
		
	//	printf("\n \n source folder %s \n",Input);
		
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
			int poradi,
			 Strom[6000][4];
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
        for(int j = 0; j < BomsCount; j++)
        {

            // Výpis BOM line 
            BOM_set_window_top_line(BomWindow, NULLTAG, Targets[i], Boms[j], &BomTopLine);
			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
		poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom)+1;
			
			//BOM_refresh_window(BOM
        }
		create_marks_csv("CSV4TPV",poradi);

	//for (int i=0;i<n_attachments;i++){
	//tag_t dataset=NULLTAG, class_id=NULLTAG, Item=NULLTAG, *plech=NULLTAG;
	//AE_reference_type_t typ ;
	//char* class_name = NULL,*Name,*Name_plech,*Name_ref;
	//	ITEM_ask_item_of_rev(attachments[i],&Item);
	//   POM_class_of_instance(attachments[i], &class_id);
 //      
 //      POM_name_of_class(class_id, &class_name);
	// //  printf("classname %s \n",class_name);


	//   if (strcmp(class_name,"Dataset")==0 )
	//   {
	//	 AOM_UIF_ask_value(attachments[i],"dataset_type",&Name_ref);
	//	// printf( "Ref_name %s \n",Name_ref);
	//	 
	//	 if (strcmp(Name_ref,"SE SheetMetal")==0)
	//	 {
	//		 int ref_count=0, named_ref_count =0;
	//		 char text[1024]="C:\\SPLM\\APP\\SEST8\\Program\\SolidEdgeTranslationServices.exe -i=C:\\test",Input_file[258],xcopy[512]="xcopy \"C:\\Temp\\",
	//			 	typ_prekladu[8]=" -t=dxf",
	//				Output[32]=" -o=C:\\test\\",
	//				Citelnost[9]=" -v=true",	
	//				Input[258]="C:\\Temp\\";

	//		 strcpy(Input_file,Input);
	//			
	//		 printf("\n attach tag %d \n",attachments[i]);
	//			AOM_ask_value_string(attachments[i],"object_name",&Name);
	//			printf( "Name %s \n",Name);
	//	
	//			 AOM_UIF_ask_value(attachments[i],"dataset_type",&Name_ref);
	//			 printf( "Ref_name %s \n",Name_ref);

	//			AE_find_dataset2(Name,&dataset);
	//			printf("dataset tag %d \n",dataset);

	//			AE_ask_dataset_ref_count(dataset,&ref_count);
	//			printf("ref count %d \n ", ref_count);
	//	
	//			AE_ask_dataset_named_refs(dataset,&named_ref_count , &plech);
	//			printf("count %d plech %d \n",named_ref_count,*plech);

	//		

	//			AOM_ask_value_string(*plech,"original_file_name",&Name_plech);
	//			printf( "Orig File Name plechu %s \n",Name_plech);
	//				strcat(Input,job_name);
	//				

	//			/*strcat(Input_file,"/");
	//			strcat(Input_file,Name_plech);
	//			strcat(Input, "\"");*/
	//				
	//			strcat(xcopy,job_name);
	//			strcat(xcopy,"\\");
	//			strcat(xcopy,Name_plech);
	//			strcat(xcopy,"\"");
	//			strcat(xcopy,"  C:\\test /Y");
	//			printf(" xcopy: %s \n ", xcopy);
	//			system(xcopy);
	//			
	//			//printf("source file %s \n",Input_file);
	//			strncat(Output,Name_plech,strlen(Name_plech)-3);
	//			strcat(Output,"dxf");
	//			strcat(text,"\\");
	//			strcat(text,Name_plech);
	//			strcat(text,typ_prekladu);
	//			strcat(text,Output);
	//			////strcat(text,Citelnost);

	//			printf("\n %s \n",text);
	//			 system(text);

	//	 }
	//   }


	//}
	//
	////	if(strstr(job_name,"~")!=NULL || strstr(job_name,";")!=NULL)
	////	{
	////		
	////		

	////				strcat(text,job_name);
	////				//printf(" text: %d \n",text);
	////		
	////		
	////	}
	////	else{
	////		
	////		//printf("vkladam nakonec \n");
	////		strcat(job_name,Output);
	////		
	////	
	////	}
	////	
	//////strcat(job_name,Output);
	////	for(int i=0;i<strlen(text);i++)
	////		{

	////			//printf (" %d \n",i);
	////			if(text[i]=='/')text[i]='_';
	////			
	////			}
	////	strcat(text,".plmxml\"");

	////	for(int i=0;i<strlen(job_name);i++)
	////		{

	////			//printf (" %d \n",i);
	////			if(job_name[i]=='/')job_name[i]='_';
	////			if(job_name[i]=='-')prepinac=i;
	////			if(prepinac>=6)
	////			{
	////				//printf("prepinac %d delka %d \n",prepinac,strlen(job_name));
	////			job_name[i]=Output[i-prepinac];
	////			//printf("%c  %d \n",job_name[i],(prepinac-i));
	////			}
	////	}
	////	strcat(text, " \"");
	////	strcat(text,job_name);
	////	strcat(text, "N.plmxml\"");
	////printf("%s \n",text);
	//////POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );//bypass nefunuje
	//////AOM_UIF_set_value(job,"object_name",job_name);
 ////      
 //// system("cmd /c \"date /t \"");
 ////
 //// system(text);
}
    return ITK_ok;
}
