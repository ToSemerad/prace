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




#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))
#define deliver "\\"
#define ECHO(X)  printf X; TC_write_syslog X


extern "C" DLLAPI int TPV_Control_CSV_TC14_register_callbacks();
extern "C" DLLAPI int TPV_Control_CSV_TC14_init_module(int *decision, va_list args);
int TPV_Control_CSV(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);

//char *Nazvy[100][20];
char Nazvy[100000][20][128];

extern "C" DLLAPI int TPV_Control_CSV_TC14_register_callbacks()
{
    ECHO(("Registruji TPV_Control_CSV_TC14.dll\n"));
    CUSTOM_register_exit("TPV_Control_CSV_TC14", "USER_init_module", TPV_Control_CSV_TC14_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Control_CSV_TC14_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Control_CSV", "", TPV_Control_CSV);
    if(Status == ITK_ok) ECHO(("Action handler %s byl registrován\n", "TPV_Control_CSV"));

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

int SouborExistuje(char *nazev)
{ECHO(("test existence souboru %s  \n",nazev));
    FILE *soubor;
    if ((soubor = fopen(nazev, "rb")) != NULL) {
        fclose(soubor);
		ECHO(("nalezen \n"));
        return 0;       /* soubor existuje,
                           jinak by se jej nepodarilo otevrit */
    }
 
    if (errno == ENOENT) {
		ECHO(("nenalezen \n"));
        return 1;   /* soubor neexistuje */
    }
 ECHO(("nic se nedìje \n"));
    return 2;      /* soubor mozna existuje, ale nepodarilo se
                           jej otevrit (treba uz je otevreno prilis
                           mnoho souboru nebo nemate prava atp.) */
}

char *time_stamp(){

char *timestamp = (char *)malloc(sizeof(char) * 16);
time_t ltime;
ltime=time(NULL);
struct tm *tm;
tm=localtime(&ltime);

sprintf(timestamp,"%04d%02d%02d%02d%02d%02d", tm->tm_year+1900, tm->tm_mon+1, 
    tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);
return timestamp;
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

void create_marks_csv(char *filename,char *line, int zacatek){
 
ECHO(("\n %s file \n >> %s <<",filename,line));
 
FILE *fp;

//int i,j;
 char file[50];
 strcpy(file,"C:\\Temp\\Kontrola_polozek\\");
 strcat(file,filename);
  //if (SouborExistuje(file)==1)
	
//ECHO(("test1 \n");
 strcat(file,".csv");
 ECHO(("file %s \n",file));


 if(zacatek==0)
	fp=fopen(file,"a+");
 else
	{
		if(SouborExistuje(file)==0)
		{
			//ECHO((" 162 exisztuje \n");
			fp=fopen(file,"w");
		}
		else 
 
		{
			fp=fopen(file,"a+");
			  system("mkdir C:\\Temp\\Kontrola_polozek\\");
		}
 }
 strcpy(file,"\0");
// ECHO((" 168 test po zacatku zapisu %d \n",fp);
//fprintf(fp,attr);
 printf ("line >>>> %s \n",line);
 fprintf(fp,"%s \n",line);

fclose(fp);
 
ECHO(("\n 174 file created \n %s \n",file));

}
void SetString(tag_t object, char* attr,char* value)
{
	AOM_lock(object);
	AOM_set_value_string(object,attr,value);
	AOM_save_with_extensions(object);
	AOM_unlock(object);
	//AOM_unload(object);
	ECHO(("Vlozeno\n"));
}

void Get_Attr_NP(tag_t obj,char* file)
{
	//marks_csv(file,"cislo_erp\\nazev_erp\\tc_name\\rozmer\\norma\\material\\vyrobce\\odkaz\\poznamka\\hmotnost\\stav_polozky\\typ");

char* tmp,										
		new_name[1024];
	double tmp_d=0;
	AOM_ask_value_string(obj,"tpv4_cislo_erp",&tmp);
	strcpy(new_name,tmp);
	strcat(new_name,deliver);
		AOM_ask_value_string(obj,"tpv4_nazev_erp",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"object_name",&tmp);
	//if (strchr(tmp,'\\')!=NULL)
	//{
	//	ECHO(("207 \n");
	//	char old_name[128];
	//	strcpy(old_name,strtok(tmp,"\\"));
	//ECHO(("\n old_name %s \n",old_name);
	//strcat(new_name,old_name);
	//}
	//else
	strcat(new_name,tmp);
	strcat(new_name,deliver);

	AOM_ask_value_string(obj,"tpv4_rozmer",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_norma",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_material",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_vyrobce",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_odkaz",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_poznamka",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_double(obj,"tpv4_hmotnost",&tmp_d);
	sprintf(tmp,"%.4f",tmp_d);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_stav_polozky",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	strcat(new_name,"NAK_POLOZKA");


	ECHO(("232 name %s \n",new_name));
	create_marks_csv(file,new_name,0);
}

void Get_Attr_HM(tag_t obj,char* file)
{
//"cislo_erp\\nazev_erp\\tc_name\\typ_polotovaru\\rozmer1\\tolerance1\\rozmer2\\rozmer3\\norma_pol\\jakost\\TDP\\dalsi_specifikace\\stav_polozky\\typ");
	
char* tmp,										
		new_name[1024];
	double tmp_d=0;
	AOM_ask_value_string(obj,"tpv4_cislo_erp",&tmp);
	strcpy(new_name,tmp);
	strcat(new_name,deliver);
		AOM_ask_value_string(obj,"tpv4_nazev_erp",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
		AOM_ask_value_string(obj,"object_name",&tmp);
	//if (strchr(tmp,'\\')!=NULL)
	//{
	//	ECHO(("270\n");
	//	char old_name[128];
	//	strcpy(old_name,strtok(tmp,"\\"));
	//ECHO(("\n old_name %s \n",old_name);
	//strcat(new_name,old_name);
	//}
	//else
	strcat(new_name,tmp);
	strcat(new_name,deliver);

	AOM_ask_value_string(obj,"tpv4_typ_polotovaru",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_double(obj,"tpv4_rozmer1",&tmp_d);

	sprintf(tmp,"%.4f",tmp_d);
	strcat(new_name,tmp);
	
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_tolerance1",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_double(obj,"tpv4_rozmer2",&tmp_d);

		sprintf(tmp,"%.4f",tmp_d);
		strcat(new_name,tmp);
	
	strcat(new_name,deliver);
	AOM_ask_value_double(obj,"tpv4_rozmer3",&tmp_d);

		sprintf(tmp,"%.4f",tmp_d);
		strcat(new_name,tmp);
	
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_norma_pol",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_jakost",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_jak_norma",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_dalsi_specifikace",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	AOM_ask_value_string(obj,"tpv4_stav_polozky",&tmp);
	strcat(new_name,tmp);
	strcat(new_name,deliver);
	strcat(new_name,"HUT_MATERIAL");
	
	ECHO(("290 name %s \n",new_name));
	create_marks_csv(file,new_name,0);
}

int TPV_Control_CSV(EPM_action_message_t msg)
{

     int
        TargetsCount = 0,
        ii = 0;
		
    tag_t
        *Targets = NULL,
		job=NULL,
		*item_hm=NULL,
		*item_np=NULL,
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
	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;
	POM_set_env_info( POM_bypass_access_check, TRUE, 0, 0.0, NULLTAG, "" );
	EPM_ask_root_task ( msg.task, &RootTask );
	EPM_ask_job(RootTask,&job);
	//AOM_UIF_ask_value(job,"object_name",&job_name);

//ECHO(("test0 \n");		
		FILE *log;
	char logpath[30];
	strcpy(logpath,"C:\\Temp\\export");
	//strcat(logpath,job_name);
	strcat(logpath,".log");
	//ECHO(("log --- %s \n",logpath);
	log=fopen(logpath,"w");

    EPM_ask_attachments( RootTask,EPM_target_attachment, &TargetsCount, &Targets );// z knihovny epm.h "#define EPM_target_attachment               1        /**< Target attachment type */"

							tag_t query = NULLTAG;
							QRY_find2("STS_HUT_MATERIAL", &query);
							//ECHO(("tag foldru Qry General... je %d\n",query);
							// Find user's "Tasks to Perform" folder
							char *entries[1] = {"NAZEV"};
							char *values[1] =  {"*"};
							int n_count_hm = 0;
							char file[256];
							strcpy(file,"Kontrolni_CSV");
							//strcat(file,time_stamp());
							//printf ("file %s \n",file);

							//sprintf(day,"%d",tm.);
							//strcat(file,);
							//struct timespec tms;
							
							QRY_execute(query, 1, entries, values, &n_count_hm, &item_hm);
							//ECHO(("pocet nalezu %d\n",n_count_hm);

							create_marks_csv(file,"cislo_erp\\nazev_erp\\tc_name\\typ_polotovaru\\rozmer1\\tolerance1\\rozmer2\\rozmer3\\norma_pol\\jakost\\TDP\\dalsi_specifikace\\stav_polozky\\typ",1);

							for (int i=0;i<n_count_hm;i++)
							{
								char* nazev_erp;
								char* object_name;
								char* status;
								AOM_ask_value_string(item_hm[i],"tpv4_nazev_erp",&nazev_erp);
								AOM_ask_value_string(item_hm[i],"object_name",&object_name);
								AOM_ask_value_string(item_hm[i],"tpv4_stav_polozky",&status);
								if (strcmp(nazev_erp,object_name)!=0 && strcmp(status,"Opravena v TC")==0)
								{

									/*char csv[1024];
									strcpy(csv,"\0");*/
									Get_Attr_HM(item_hm[i],file);
									//strcpy(csv,Get_Attr_HM(item_hm[i]));
									/*ECHO(("375  strcat\n ");
									
									
									ECHO((" 418 csv line %s \n",csv);*/
									//create_marks_csv(file,csv,0);
								}
								else if(strcmp(status,"Opravena v TC")==0)
								{
									if (Is_Released(item_hm[i])!=0)// The value 0 indicates not released, while 1 indicates released
										Remove_stat(item_hm[i],RootTask);

									SetString(item_hm[i],"tpv4_stav_polozky","Platna");
																		tag_t release_stat = NULLTAG;
									int	ifail = RELSTAT_create_release_status( "Approved", &release_stat );
										if(ifail != ITK_ok) {/* add your error logic here */}
										
										//tag_t devDoc;
									    ifail = RELSTAT_add_release_status ( release_stat, 1, &item_hm[i], true );
									 if(ifail != ITK_ok) {/* add your error logic here */}
									 tag_t rev;
									 ITEM_ask_latest_rev(item_hm[i],&rev);
									//	 printf ("tag rev %d \n",rev);
									   ifail = RELSTAT_add_release_status ( release_stat, 1, &rev, true );
									 if(ifail != ITK_ok) {ECHO(("problem schvaleni rev \n"));}

								}
								//if(strcmp(status,"Zakaz pouziti")!=0 && strcmp(status,"Opravit v TC")!=0)
								//{

								//}
							}


							// Find user's "Tasks to Perform" folder
							/*char *entries_np[1] = {"Type"};
							char *values_np[1] =  {"TPV4_nak_pol"};*/
							QRY_find2("STS_NAK_POLOZKA", &query);
							int n_count_np = 0;
							
							strcpy(file,"Kontrolni_CSV");
							//strcat(file,time_stamp());
							//printf ("file %s \n",file);

							//sprintf(day,"%d",tm.);
							//strcat(file,);
							//struct timespec tms;
							
							QRY_execute(query, 1, entries, values, &n_count_np, &item_np);
							
							//ECHO(("pocet nalezu %d\n",n_count_np);

							create_marks_csv(file,"cislo_erp\\nazev_erp\\tc_name\\rozmer\\norma\\material\\vyrobce\\odkaz\\poznamka\\hmotnost\\stav_polozky\\typ",0);

							for (int i=0;i<n_count_np;i++)
							{
								char* nazev_erp;
								char* object_name;
								char* status;
								AOM_ask_value_string(item_np[i],"tpv4_nazev_erp",&nazev_erp);
								AOM_ask_value_string(item_np[i],"object_name",&object_name);
								AOM_ask_value_string(item_np[i],"tpv4_stav_polozky",&status);
								if (strcmp(nazev_erp,object_name)!=0 && strcmp(status,"Opravena v TC")==0)
								{
									char csv[1024],
										*tmp_hlp=NULLTAG;
									strcpy(csv,"\0");
									ECHO(("\n get_attr \n"));
									Get_Attr_NP(item_np[i],file);
									//strcat(csv,Get_Attr_NP(item_np[i]));
									/*
									ECHO(("csv line %s \n",csv);
									create_marks_csv(file,csv,0);*/
								}
								else if(strcmp(status,"Opravena v TC")==0)
								{
									printf (">>>>>>opravena Schval \n"); 
									if (Is_Released(item_np[i])!=0)// The value 0 indicates not released, while 1 indicates released
										Remove_stat(item_np[i],RootTask);
									
								SetString(item_np[i],"tpv4_stav_polozky","Platna");
											tag_t release_stat = NULLTAG;
										int	ifail = RELSTAT_create_release_status( "Approved", &release_stat );
										if(ifail != ITK_ok) {/* add your error logic here */}
										
										//tag_t devDoc;
									    ifail = RELSTAT_add_release_status ( release_stat, 1, &item_np[i], true );
										if(ifail != ITK_ok) {/* add your error logic here */}
										tag_t rev;
										ITEM_ask_latest_rev(item_np[i],&rev);
									   ifail = RELSTAT_add_release_status ( release_stat, 1, &rev, true );
										if(ifail != ITK_ok) {/* add your error logic here */}
									 

								}
								/*if(strcmp(status,"Zakaz pouziti")!=0 \\\\ strcmp(status,"Opravit v TC")!=0 \\\\strcmp(status,"Zalozena z TC")!=0)
								{
							
								}*/
							}
							
							
	fclose(log);
    return ITK_ok;
}
