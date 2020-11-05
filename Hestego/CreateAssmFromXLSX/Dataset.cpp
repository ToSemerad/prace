
#include <tccore\aom.h>
#include <ae\ae.h>
#include <tccore\grm.h>
#include <epm/epm.h>
#include <tccore/item.h>
#include <time.h>

#include "Gtac_err_reports.h"
#include "Log_file.h"
#include "Global_var.h"

char *file_from_path (char *pathname)
{
	char *fname = NULL;

	if (pathname)
	{
		fname = strrchr (pathname, '/') + 1;
	}

	return fname;
}

void waitFor (unsigned int secs) {
    unsigned int retTime = time(0) + secs;   // Get finishing time.
    while (time(0) < retTime);               // Loop until it arrives.
}
char* CopyFile( char* filePath,char *newFileName,char* newPath)
{
	char comand[400]="copy \"";
	char newFilePath[200]="";
	strcpy(newFilePath,newPath);
	strcat(newFilePath,"\\");
	strcat(newFilePath,newFileName);

	strcat(comand,filePath);
	strcat(comand,"\" \"");
	strcat(comand,newFilePath);
	strcat(comand,"\" ");
	printf("command :\n|%s|\n",comand);
	//system("pause");
	system(comand);
	//int delka =strlen(filePath-1);

	
	return newFilePath;
}

void datasetFileDel(char* filePath)
{
	char cmd_del[200]="del \"";
	strcat(cmd_del,filePath);
	strcat(cmd_del,"\"");
	system(cmd_del);

}


void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset)//create_dataset("PDF", dataset_name, Item,  Rev, &dataset);
{
    char
        format_name[AE_io_format_size_c + 1] = "BINARY_REF";
    tag_t
        datasettype,
        tool;
    
    IFERR_REPORT(AE_find_datasettype(type_name, &datasettype));
    if (datasettype == NULLTAG)
    {
        printf("Dataset Type %s not found!\n", type_name);
		InfoLog( LogFileName,"Dataset Type" ,type_name," nebyl nalezen v datazy");
        exit (EXIT_FAILURE);
    }
    
    IFERR_REPORT(AE_ask_datasettype_def_tool(datasettype, &tool));
    
    printf("Creating Dataset: %s\n", name);
    IFERR_REPORT(AE_create_dataset(datasettype, name, "", dataset));
    
    IFERR_REPORT(AE_set_dataset_tool(*dataset, tool));
    if (strcmp(type_name, "PDF")) strcpy(format_name, "PDF");
    
    IFERR_REPORT(AE_set_dataset_format(*dataset, format_name));
    printf("Saving Dataset: %s\n", name);
    AOM_save(*dataset);
    
    /*attach dataset to item revision */
   ITK_set_bypass(true);
	ITEM_attach_rev_object(rev, *dataset, ITEM_specification_atth);
    ITEM_save_item(rev);
	ITK_set_bypass(false);

	InfoLog( LogFileName,"Zalozeni datasetu " ,name,"");
	//system("pause");
}

void importDatates(tag_t dataset,char* way,char *ref,char *fileName) //importDatates(dataset,way,"PDF_Reference",fileName);
{
    /*  AE_find_dataset finds latest revision of dataset */
    
    //IFERR_ABORT(AE_find_dataset("6667776-A", &dataset));
    //ECHO("\n dataset: %u \n", dataset);
	char filePath[256];
	char soubor[20];
	//char*pripona;
	strcpy(soubor,fileName);
	if(strncmp(way,"K:\\",3)==0)
	{
		char* tmp;
		strcpy(filePath,"\\\\TERMINAL\\Kryty_terminal\\");
		tmp =strtok(way,":");
		tmp=strtok(NULL,"\0");
		strcat(filePath,tmp);
		/*printf("filePath %s \n",filePath);
		system("pause");*/

	}else if ( strcmp(way,"k:\\")==0)
	{
		char* tmp;
		strcpy(filePath,"\\TERMINAL\\Kryty_terminal\\");
		tmp =strtok(way,":");
		tmp=strtok(NULL,"\0");
		strcat(filePath,tmp);
		/*printf("filePath %s \n",filePath);
		system("pause");*/
	}
	else strcpy(filePath,way);
	
	strcpy(filePath, CopyFile( filePath,fileName,"C:\\SPLM\\App\\Import_excel"));
	
	AOM_lock(dataset);
    AOM_refresh(dataset, TRUE);
   printf("\n dataset=%d) \n ref=%s) \n way=%s) \n Refsname=%s) \n",dataset, ref, filePath, fileName);
   //system("pause");
    /* the fourth argument must be a unique name in the volume */
   InfoLog( LogFileName,"Vkladani prilohy " ,filePath, fileName);
   /*strtok(soubor,".");
   pripona=strtok(NULL,"\0");*/
  // printf(" pripona %s \n",pripona);
   waitFor (1);
   printf(" dataset %d ref %s filePath %s filename %s fileTypFlag %d \n",dataset, ref, filePath, fileName,  SS_BINARY);
  /* if(strcmp(pripona,"txt")==0 ||strcmp(pripona,"TXT")==0)
   {
		IFERR_REPORT( AE_import_named_ref(dataset, ref, filePath, fileName,  SS_TEXT));
   }else */
	   IFERR_REPORT( AE_import_named_ref(dataset, ref, filePath, fileName,  SS_BINARY));
   //AE_import_named_ref(ds_tag, "Text", os_path, auto_assign, SS_TEXT)
	
  // system("pause");

    AOM_save(dataset); 
    AOM_refresh(dataset, FALSE);
	AOM_unlock(dataset);
    AOM_unload(dataset);

	AOM_set_ownership(dataset,owner ,ownerGrup);
	
	 InfoLog( LogFileName,"Vlozeno a ulozeno " ,filePath, fileName);
	 datasetFileDel(filePath);
}

//
//#endif