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
#include <ae\ae.h>
#include <tccore\grm.h>
#include <unidefs.h>
#include <errno.h>
#include <time.h>
#include <tccore\aom.h>
#include <lov\lov.h>

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))
#define ECHO(X)  printf X; TC_write_syslog X

extern "C" DLLAPI int TPV_CreateName_HM_NP_TC14_register_callbacks();
extern "C" DLLAPI int TPV_CreateName_HM_NP_TC14_init_module(int *decision, va_list args);
int TPV_CreateName_HM_NP(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);

//char *Nazvy[100][20];
char Nazvy[100000][20][128];

extern "C" DLLAPI int TPV_CreateName_HM_NP_TC14_register_callbacks()
{
    ECHO(("Registruji TPV_CreateName_HM_NP_TC14.dll\n"));
    CUSTOM_register_exit("TPV_CreateName_HM_NP_TC14", "USER_init_module", TPV_CreateName_HM_NP_TC14_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_CreateName_HM_NP_TC14_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_CreateName_HM_NP", "", TPV_CreateName_HM_NP);
    if(Status == ITK_ok) ECHO(("Action handler %s byl registrován\n", "TPV_CreateName_HM_NP"));

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) ECHO(("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}


int Shoda (int level, int bomLine, int Rev,int poradi, int pole[6][4]){
	int jetam=0;
	for(int j=0;j<=6;j++)
	{
	//	ECHO(("strom %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]);
		
		if((level==pole[j][0])&&(bomLine==pole[j][1])&&(Rev==pole[j][2]))
		{
			ECHO(("shoda %d  %d  %d \n",pole[j][0],pole[j][1],pole[j][2]));
			jetam=1;
			break;
		}
	
	}

	return jetam;
}

int Is_Released(tag_t obj)
{
		int is_released=0;
	EPM_ask_if_released(obj,&is_released);// The value 0 indicates not released, while 1 indicates released
	ECHO(("Release %d \n",is_released));
return is_released;
}
int Remove_stat(tag_t obj,tag_t root_tag)
{
	int n_statuses = 0,
		TargetsCount;
   tag_t *statuses  = NULL,
		*Targets =NULL;
	int ifail = WSOM_ask_release_status_list(obj, &n_statuses , &statuses);
	if (ifail != ITK_ok) { /* your error logic here */ }
	ECHO(("pocet statusu %d \n",statuses));
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
				EPM_remove_attachments(root_tag, 1, attach);
				next:;
	}
	ECHO(("ok \n"));
	if(statuses) MEM_free(statuses);
	ECHO(("return \n"));
		 return ITK_ok;
}

void SetString(tag_t object,char* value, char* attr)
{
	POM_set_env_info(POM_bypass_attr_update,TRUE,0,0,NULLTAG,NULL);
	POM_set_env_info(POM_bypass_access_check,TRUE,0,0,NULLTAG,NULL);
	AOM_lock(object);
	AOM_set_value_string(object,attr,value);
	AOM_save_with_extensions(object);
	AOM_unlock(object);
	//AOM_unload(object);
	ECHO(("Vlozeno %s\n",value));
							POM_set_env_info(POM_bypass_attr_update,FALSE,0,0,NULLTAG,NULL);
						POM_set_env_info(POM_bypass_access_check,FALSE,0,0,NULLTAG,NULL);	
}

int GetStatus(tag_t wso_tag)
{
	ECHO(("get_statusses \n"));
		int n_statuses = 0;
		tag_t *statuses  = NULL;
		int  ifail = WSOM_ask_release_status_list(wso_tag, &n_statuses , &statuses);
		if (ifail != ITK_ok) { /* your error logic here */ }
	 return n_statuses; 
}
char* Get_Lov(char* hodnota,char* Lov )
{
	ECHO(("vyplnovani \n"));
	tag_t* lov_tag=NULLTAG;
	int n_lovs;
	int n_values;
	char** values;
	
	LOV_usage_t usage;
	char** values_dissplay;
	
	LOV_find(Lov, &n_lovs, &lov_tag);
	ECHO((" lov tag %d \n",*lov_tag));
	LOV_ask_values_display_string(*lov_tag, &usage, &n_values, &values_dissplay, &values);
	for(int j=0; j<n_values;j++)
	{
		
		ECHO(("cislo %d hodnoty %s vstup %s popis %s \n",j,values[j],hodnota,values_dissplay[j]));
		if(strcmp(values[j],hodnota)==0)
			{
				ECHO(("return %s \n",values_dissplay[j]));
			return values_dissplay[j];
			}
	}
	return hodnota;
}

char* Get_newName_HM(tag_t obj)
{
char* tmp,										
		new_name[124];
	double tmp_d=0;
	AOM_ask_value_string(obj,"tpv4_cislo_erp",&tmp);
	strcpy(new_name,tmp);
	strcat(new_name,"|");
	ECHO(("delka %zd \n",strlen(new_name)));
	AOM_ask_value_string(obj,"tpv4_typ_polotovaru",&tmp);
	if(strlen (tmp)>1)
	{
	ECHO(("Polotovar tmp %s \n",tmp));
	//ECHO(("Get polotovar %s \n",Get_Lov(tmp,"TPV4_TYP_POLOTOVARU"));

	//ECHO(("polotovar get%s \n",tmp);
	strcat(new_name,Get_Lov(tmp,"TPV4_TYP_POLOTOVARU"));
	}
	strcat(new_name,"|");
	AOM_ask_value_double(obj,"tpv4_rozmer1",&tmp_d);
	if(tmp_d!=0)
	{
	sprintf(tmp,"%.2f",tmp_d);
	strcat(new_name,tmp);
	}
	ECHO(("delka %zd \n",strlen(new_name)));
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_tolerance1",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
	ECHO(("delka %d \n",strlen(new_name)));
	AOM_ask_value_double(obj,"tpv4_rozmer2",&tmp_d);
	if(tmp_d!=0)
	{
		sprintf(tmp,"%.2f",tmp_d);
		strcat(new_name,tmp);
		ECHO(("159 cislo %d \n",strlen(tmp)));
	}
	strcat(new_name,"|");
	ECHO((" 200 delka %d \n",strlen(new_name)));
	AOM_ask_value_double(obj,"tpv4_rozmer3",&tmp_d);
	if(tmp_d!=0)
	{
		sprintf(tmp,"%.2f",tmp_d);
		strcat(new_name,tmp);
	}
	strcat(new_name,"|");
	ECHO((" 209 delka %d \n",strlen(new_name)));
	AOM_ask_value_string(obj,"tpv4_norma_pol",&tmp);
	if (strlen(tmp)>1)
	{
	tmp=strtok(tmp,"-");
	strcat(new_name,tmp);
	}
	ECHO(("213 delka %d \n",strlen(new_name)));
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_jakost",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_jak_norma",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_dalsi_specifikace",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");								

	ECHO(("name %s \n",new_name));
	return new_name;
}


char* Get_newName_NP(tag_t obj)
{
char* tmp,										
		new_name[124];
	double tmp_d=0;
	AOM_ask_value_string(obj,"tpv4_cislo_erp",&tmp);
	strcpy(new_name,tmp);
	strcat(new_name,"|");

	AOM_ask_value_string(obj,"tpv4_rozmer",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_material",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_vyrobce",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
	AOM_ask_value_string(obj,"tpv4_norma",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,"|");
							

	ECHO(("name %s %d\n",new_name,strlen(new_name)));
	return new_name;
}

int TPV_CreateName_HM_NP(EPM_action_message_t msg)
{
	POM_set_env_info(POM_bypass_attr_update,TRUE,0,0,NULLTAG,NULL);
	POM_set_env_info(POM_bypass_access_check,TRUE,0,0,NULLTAG,NULL);
     int
        TargetsCount = 0,
        ii = 0;
		
    tag_t
        *Targets = NULL,
		job=NULL,
		*obj_hm=NULL,
		*obj_np=NULL,
		RootTask=NULLTAG;
    char  
        file_name[WSO_name_size_c+2] = "",
        *class_name = NULL,
		*Id=NULL,
		*RevId=NULL,
		//*Process_name,
		
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

//ECHO(("test0 \n");		
	//	FILE *log;
	//char logpath[30];
	//strcpy(logpath,"C:\\Temp\\export");
	//strcat(logpath,job_name);
	//strcat(logpath,".log");
	//ECHO(("log --- %s \n",logpath);
	//log=fopen(logpath,"a+");

    EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"


							tag_t query = NULLTAG;
							QRY_find2("STS_HUT_MATERIAL", &query);
							ECHO(("tag Query STS_HUT_MATERIAL je %d\n",query));

							char *entries[1] = {"STAV POLOZKY"};
							char *values_hm[1] =  {"Opravit v TC"};
							int n_count_hm = 0;
							QRY_execute(query, 1, entries, values_hm, &n_count_hm, &obj_hm);
							ECHO(("pocet nalezu %d\n",n_count_hm));
							

							for (int i=0;i<n_count_hm;i++)
							{
								//WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
								//ECHO(("%s\n",Type);
								ECHO(("pocet statusu %d \n",GetStatus(obj_hm[i])));
								if (Is_Released(obj_hm[i])!=0)
									Remove_stat(obj_hm[i],RootTask);
								ECHO(("276 return \n"));
								char new_name[128];
								char* object_name;
								//char* status;
							//	AOM_ask_value_string(rev[i],"tpv4_nazev_erp",&nazev_erp);
								AOM_ask_value_string(obj_hm[i],"object_name",&object_name);
								//AOM_ask_value_string(obj[i],"tpv4_stav_polozky",&status);
								//if(strcmp(status,"Opravit v TC")==0){
								ECHO(("pred get string \n"));
									strncpy(new_name,Get_newName_HM(obj_hm[i]),126);
									ECHO((" new_name %s \n delka %d \n",new_name,strlen(new_name))); 
									//if(strcmp(Type,"TPV4_h_material")==0 )
										SetString(obj_hm[i],new_name, "object_name");
										tag_t rev;
										ITEM_ask_latest_rev(obj_hm[i],&rev);
										SetString(rev,new_name, "object_name");
										SetString(obj_hm[i],"Opravena v TC", "tpv4_stav_polozky");
										ECHO((" new_name %s \n delka %d \n",new_name,strlen(new_name))); 
								//}
							}


							QRY_find2("STS_NAK_POLOZKA", &query);
							ECHO(("tag Query STS_NAK_POLOZKA je %d\n",query));
							//char *entries_np[1] = {"Type"};
							char *values_np[1] =  {"Opravit v TC"};
							int n_count_np = 0;
							QRY_execute(query, 1, entries, values_np, &n_count_np, &obj_np);
							ECHO(("pocet nalezu %d\n",n_count_np));
							

							for (int i=0;i<n_count_np;i++)
							{
								//WSOM_ask_object_type2(Targets[i],&Type);//Returns the object type of the specified WorkspaceObject.
								//ECHO(("%s\n",Type);
								if (Is_Released(obj_np[i])!=0)
									Remove_stat(obj_np[i],RootTask);
								ECHO(("313 return \n"));
								
								//char* new_name;
								char* object_name;
								//char* status;
							//	AOM_ask_value_string(rev[i],"tpv4_nazev_erp",&nazev_erp);
								AOM_ask_value_string(obj_np[i],"object_name",&object_name);
								//AOM_ask_value_string(obj[i],"tpv4_stav_polozky",&status);

								//if(strcmp(status,"Opravit v TC")==0){
									//strncpy(new_name,Get_newName_NP(obj_np[i]),126);
									//if(strcmp(Type,"TPV4_h_material")==0 )
									//	SetString(obj[i],new_name, "object_name");

										char name [128];
										if (strchr(object_name,'|')!=NULL)
											strcpy(name,strtok(object_name,"|"));
										ECHO(("\n -----obj_name %s \n",name));
										strncpy(name,object_name,128);
										strcat(name,"|");
										strcat (name,Get_newName_NP(obj_np[i]));
										SetString(obj_np[i],name, "object_name");
										tag_t rev;
										ITEM_ask_latest_rev(obj_np[i],&rev);
										SetString(rev,name, "object_name");
										SetString(obj_np[i],"Opravena v TC", "tpv4_stav_polozky");
										ECHO((" name %s \n delka %d \n",name,strlen(name))); 
							//	}

							}
										tag_t release_stat = NULLTAG;
										int	ifail = RELSTAT_create_release_status( "Kontrola OK", &release_stat );
										if(ifail != ITK_ok) {/* add your error logic here */}
										
										//tag_t devDoc;
									    ifail = RELSTAT_add_release_status ( release_stat, n_count_np, obj_np, true );
									 if(ifail != ITK_ok) {/* add your error logic here */}
							
	//fclose(log);
						POM_set_env_info(POM_bypass_attr_update,FALSE,0,0,NULLTAG,NULL);
						POM_set_env_info(POM_bypass_access_check,FALSE,0,0,NULLTAG,NULL);	
    return ITK_ok;
}
