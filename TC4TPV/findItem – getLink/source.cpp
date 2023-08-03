#include <stdio.h>
#include <tc/tc.h>
#include <tc/emh.h>
#include <tccore/item.h>
#include <string.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>
#include <tccore/aom.h>
#include <tccore/tctype.h>
#include <lov\lov.h>
#include <server_exits/user_server_exits.h>
#include <ict\ict_userservice.h>
#include <string.h>
#include <java\jni.h>
#include <java\jni_md.h>


//#include <jni.h>


#include <ae\ae.h>
#include <tccore\grm.h>

#include <server_exits/user_server_exits.h>

char Nazvy[100][20][128];
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
void downloadDataset(tag_t rev,char* I_ID, int poradi, char* typ)
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
	char cesta[50]="C:\\TC4TPV\\TCCom\\pdf_temp\\";
	printf("I_ID %s \n",I_ID);
	for (int k =0;k<strlen(I_ID);k++)
		if(I_ID[k]==' ')
			I_ID[k]='_';

	

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
				 /// printf("Typ polozky odpovida \n");
				  printf("-----typ_name ok\n");
				ifail = AE_ask_all_dataset_named_refs(specs[ii], "PDF_Reference", &n_refs, &refs);
				printf("Reference %d \n",n_refs);

				if (ifail != ITK_ok) { printf("chyba v dotazu na dataset\n"); }
				else printf(" ok export\n");
            
			strcat(cesta,I_ID);
			//printf("Cesta %s \n",cesta);
			strcat(cesta,".");
			//printf("Cesta %s \n",cesta);
			strcat(cesta,typ);
			//printf("Cesta %s \n",cesta);
			strcpy(Nazvy[poradi][5],cesta);
			printf("cesta %s poradi %d\n",Nazvy[poradi][5],poradi);
            ifail = AE_export_named_ref(specs[ii], "PDF_Reference", cesta);
            if (ifail != ITK_ok) { printf("Nefunguje export \n");}
			  }
			  }

}
}
void readAttr(tag_t BomLine,tag_t Rev, int poradi,char *I_ID_v){
	int AttributeId=0;
	char* tmp;
	char hm [20];
	double Hmotnost;

	//poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#h4_vykres_norma#h4_typ_dilce#h4_hmotnost
	

		//strcpy(Nazvy[poradi][0],I_ID_v);
		strcpy(Nazvy[poradi][0],I_ID_v);
		//printf("Parent %s %s\n",Nazvy[poradi][0],I_ID_v);

		printf("test100 \n");
				BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);
		strcpy(Nazvy[poradi][1],tmp);
		//printf("Item_id %s\n",Nazvy[poradi][1]);
		
		AOM_ask_value_string(Rev,"object_name",&tmp);
		strcpy(Nazvy[poradi][2],tmp);
		//printf("name %s \n",Nazvy[poradi][2]);
		
		BOM_line_look_up_attribute("bl_rev_item_revision_id", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);
		strcpy(Nazvy[poradi][3],tmp);
		//printf("item_rev %s \n",Nazvy[poradi][3]);
		
	
		BOM_line_look_up_attribute("bl_quantity", &AttributeId);
		BOM_line_ask_attribute_string(BomLine, AttributeId, &tmp);
		if (strcmp(tmp,"")==0)
			strcpy(Nazvy[poradi][4],"1");
		else
		strcpy(Nazvy[poradi][4],tmp);
		//printf("mnozstvi %s \n",Nazvy[poradi][4]);

		//typ dílce 
		tag_t *Boms;
		int BomsCount=0;
		ITEM_rev_list_bom_view_revs(Rev, &BomsCount, &Boms);
		if ( BomsCount==0)
			strcpy(Nazvy[poradi][7],"T");
		else
			strcpy(Nazvy[poradi][7],"S");

		AOM_ask_value_string(Rev,"h4_polotovar",&tmp);
		strcpy(Nazvy[poradi][6],tmp);

		AOM_ask_value_string(Rev,"h4_vykres_norma",&tmp);
		strcpy(Nazvy[poradi][8],tmp);
		//printf("vykres_norma %s \n",Nazvy[poradi][8]);

		AOM_ask_value_string(Rev,"h4_typ_dilce",&tmp);
		strcpy(Nazvy[poradi][9],tmp);
		//printf("typ_dilce %s \n",Nazvy[poradi][9]);

		AOM_get_value_double(Rev,"h4_hmotnost",&Hmotnost);
		sprintf(hm,"%.2f", Hmotnost);
		strcpy(Nazvy[poradi][10],hm);
		//printf("hmotnost %s\n", Nazvy[poradi][10]);
		

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
		BOM_line_look_up_attribute("bl_item_item_id", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &I_ID_v);
		
		printf (" tak Rev %d \n",Rev);
		
		//SE Assembly Reports
				BOM_line_look_up_attribute("SE Assembly Reports", &AttributeId);
		BOM_line_ask_attribute_string(pamet[Level], AttributeId, &SEAR);
				printf(" SE Assembly Reports %s \n",SEAR);
		double Hmotnost;
			
						//printf("hmotnost dilu %f \n",Hmotnost);
						char *tmp;
	if( Level==0)
	{
		readAttr(BomLine, Rev, poradi,"");
		//strcpy(Nazvy[poradi][7],tmp);
		downloadDataset(Rev,I_ID_v,poradi,"pdf");
	}
	

    // Potomci
	
    tag_t *Childs = NULLTAG;
    int ChildsCount;
    BOM_line_ask_child_lines(BomLine, &ChildsCount, &Childs);
	

	for(int t=0;t<ChildsCount;t++)
	{
			poradi=poradi+1;

		BOM_line_look_up_attribute("bl_revision", &AttributeId);
		BOM_line_ask_attribute_tag(Childs[t], AttributeId, &Rev);
		printf("test140 \n");
			readAttr(Childs[t], Rev, poradi,I_ID_v);

		//strcpy(Nazvy[poradi][7],tmp);
		
		downloadDataset(Rev,Nazvy[poradi-1][1],poradi-1,"pdf");
		printf("Poradi %d Vrchol %s Dil %s Rev %s \n",poradi,I_ID_v,I_ID,REV_ID);
		
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
 strcpy(file,"C:\\TC4TPV\\TCCom\\");
 strcat(file,filename);
//printf("test1 \n");
 strcat(file,".csv");
 //printf("file %s \n",file);
fp=fopen(file,"a");
 printf("test po zaèátku zápisu \n");
//fprintf(fp,attr);
 
for(i=0;i<m;i++)
{
	printf ("fprint %d \n",i);
	if(i==0)
		fprintf(fp,"poradi#idv#id#nazev#revize#mnozstvi#prilohy#material#typ#h4_vykres_norma#h4_typ_dilce#h4_hmotnost\n%d",i);
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

//void Calljar()
//{
//system (java
//}


//JNIEnv* create_vm() {
//	JavaVM* jvm;
//	JNIEnv* env;
//	JavaVMInitArgs args;
//	JavaVMOption options[1];
//	
//	/* There is a new JNI_VERSION_1_4, but it doesn't add anything for the purposes of our example. */
//	args.version = JNI_VERSION_1_2;
//	args.nOptions = 1;
//	options[0].optionString = "-Djava.class.path=c:\\projects\\local\\inonit\\classes";
//	args.options = options;
//	args.ignoreUnrecognized = JNI_FALSE;
//
//	JNI_CreateJavaVM(&jvm, (void **)&env, &args);
//	return env;
//}
//
//void invoke_class(JNIEnv* env) {
//	jclass helloWorldClass;
//	jmethodID mainMethod;
//	jobjectArray applicationArgs;
//	jstring applicationArg0;
//
//	helloWorldClass = (*env)->FindClass(env, "example/jni/InvocationHelloWorld");
//
//	mainMethod = (*env)->GetStaticMethodID(env, helloWorldClass, "main", "([Ljava/lang/String;)V");
//
//	applicationArgs = (*env)->NewObjectArray(env, 1, (*env)->FindClass(env, "java/lang/String"), NULL);
//	applicationArg0 = (*env)->NewStringUTF(env, "From-C-program");
//	(*env)->SetObjectArrayElement(env, applicationArgs, 0, applicationArg0);
//
//	(*env)->CallStaticVoidMethod(env, helloWorldClass, mainMethod, applicationArgs);
//}


//
//JNIEnv* create_vm(JavaVM ** jvm) {
//    
//    JNIEnv *env;
//    JavaVMInitArgs vm_args;
//
//    JavaVMOption options; 
//    //Path to the java source code     
//    options.optionString = "-Djava.class.path=D:\\Java Src\\TestStruct"; 
//    vm_args.version = JNI_VERSION_1_6; //JDK version. This indicates version 1.6
//    vm_args.nOptions = 1;
//    vm_args.options = &options;
//    vm_args.ignoreUnrecognized = 0;
//    
//    int ret = JNI_CreateJavaVM(jvm, (void**)&env, &vm_args);
//    if(ret < 0)
//        printf("\nUnable to Launch JVM\n");       
//    return env;
//}

void CallBridge(char* file)
{	char help [50];
	strcpy(help,file);
	printf("file %s \n",help);
	char ImportTPV[256]="TCCom.jar \"";
	//char ImportTPV[256]="C:\\TC4TPV\\TCCom\\TCCom.jar \"";
	strcat(ImportTPV,help);
	strcat(ImportTPV,".csv");
	strcat(ImportTPV,"\"");
	//printf("%s \n",ImportTPV);
	/*system("cd C:\\TC4TPV\\TCCom");
	system("pause");
	system(ImportTPV);*/
//	system("call C:\\TC4TPV\\TCCom\\run.bat");
	 printf("%s\n",ImportTPV);
}
void Cisteni()
{
	for (int i=0;i<100;i++)
		for(int j=0;j<20;j++)
			strcpy(Nazvy[i][j]," ");
}

void CreateLink2TC (tag_t* Targets,int num_targets)
{
	FILE* stream;
	char logpath[30];
	strcpy(logpath,"C:\\Temp\\odkaz");
	//strcat(logpath,job_name);
	strcat(logpath,".txt");
	//printf("log --- %s \n",logpath);
	stream=fopen(logpath,"a+");
	char link[128],
		*adresa="http://hestego:7001/tc/launchapp?-attach=true&-s=226TCSession&-o=",
		*append="AAAAAAAAAAAAAA";
	for (int i=0;i<num_targets;i++)
	{
	char *Uid;
	ITK__convert_tag_to_uid(Targets[i],&Uid);
	strcpy(link,adresa);
	strcat(link,Uid);
	strcat(link,append);
	fprintf(stream,"%s \n",link);
	}
}

//void VyplnLov(char* hodnota, tag_t cil,char* Lov,char* attr );
int main(int argc, char *argv[])
{
			tag_t RevisionClassTag = NULLTAG;
	
POM_class_id_of_class("ItemRevision", &RevisionClassTag);//najde



    // ITK initialization
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);

    // Login
    int ReturnCode = TC_init_module("konstrukter_se", "konstrukter_se", "");
    if(ReturnCode != ITK_ok)
    {
        char *Message;
        EMH_ask_error_text(ReturnCode, &Message);
        fprintf(stderr, "ERROR: %s\n", Message);
    }
    printf("Login OK\n");
	
		
	char *KP="DAA 000 272",
		*Uid;
    // Vyhledání položek
    const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
    const char *AttrValues[1] = {KP};
    int ItemsCount = 0;
    tag_t *Items = NULLTAG;
	tag_t Targets=NULLTAG;
    ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &ItemsCount, &Items);
	ITEM_ask_latest_rev(*Items,&Targets);

	char* file;
//printf ("msg tag = %d\n", msg);
	AOM_ask_value_string(Targets,"item_id",&file);
	tag_t cil [1];
	cil[0]=Targets;
	CreateLink2TC (cil,1);
	//printf("ItemId %s \n UID %s \n",file,Uid);

	//for (int k =0;k<strlen(file);k++)
	//{
	//	if(file[k]==' ')job_name[k]='_';

	//}
//for( int i = 0; i < TargetsCount; i ++ )
//{
//	tag_t TargetClassTag = NULLTAG;
//POM_class_of_instance(Targets, &TargetClassTag);
//
//logical IsRevision = false;
//POM_is_descendant(RevisionClassTag, TargetClassTag, &IsRevision);
//
////if(IsRevision == false) continue;
//	char *Type;
//	      
//			// BOM window
//			
//			tag_t pamet[100];
//            tag_t BomWindow = NULLTAG;
//            BOM_create_window(&BomWindow);
//            tag_t BomTopLine = NULLTAG;
//			int poradi=0,
//			 Strom[6000][4];
//
//
//		WSOM_ask_object_type2(Targets,&Type);//Returns the object type of the specified WorkspaceObject.
//		//printf ("%s\n",Type);
//		int BomsCount = 0;
//        tag_t *Boms = NULLTAG;
//        ITEM_rev_list_bom_view_revs(Targets, &BomsCount, &Boms);//This function will return all objects attached to the Item Revision.
//       for(int j = 0; j < BomsCount; j++)
//        {
//			printf ("-------------------------------------------\n");
//            // Výpis BOM line 
//            BOM_set_window_top_line(BomWindow, NULLTAG, Targets, Boms[j], &BomTopLine);
//			BOM_window_set_absocc_edit_mode(BomWindow,TRUE);
//		poradi= ListBomLine(BomTopLine, 0,pamet, poradi, BomWindow,Strom)+1;
//			
//			//BOM_refresh_window(BOM
//		}
//	   	for (int k =0;k<strlen(file);k++)
//	{
//		if(file[k]==' ')file[k]='_';
//
//	}
//
//	//	char*CsvFile=create_marks_csv(file,poradi,10);
//		CallBridge(file);
	
}

extern int functionName (void * returnValueType)
{
    int
        arraySize = 3,
        status = ITK_ok;
    char 
        *arg,   
        *string1 = NULL,
        *string2 = NULL,
        *string3 = NULL,
        **stringarray = NULL;
    USERSERVICE_array_t 
        arrayStruct;

    printf("functionName in\n");

    status = USERARG_get_string_argument(&arg);
    stringarray = (char **) MEM_alloc (arraySize * sizeof(char*));
    string1 = (char *) MEM_alloc ( 5 * sizeof(char));
    string2 = (char *) MEM_alloc ( 2 * sizeof(char));
    string3 = (char *) MEM_alloc ( 2 * sizeof(char));

    strcpy(string1,"Saab");
    strcpy(string2,"9");
    strcpy(string3,"3");

    stringarray[0] = string1;
    stringarray[1] = string2;
    stringarray[2] = string3;

    USERSERVICE_return_string_array((const char**)stringarray, arraySize,
        &arrayStruct);

    if (arrayStruct.length != 0)
     *((USERSERVICE_array_t*) returnValueType) = arrayStruct;

    printf("functionName out\n");
    return status;
}

