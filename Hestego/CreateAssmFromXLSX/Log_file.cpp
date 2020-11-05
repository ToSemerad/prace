

#include <stdio.h>
#include <iostream>
#include <time.h>
#include<tc\tc.h>

#include "Dataset.h"

char* getMess( char* part1,char* part2, char* part3)
{
	char *mess=(char*)calloc(strlen(part1)+strlen(part2)+strlen(part3),sizeof(char*));
	sprintf(mess,"%s %s %s",part1,part2,part3);
	return mess;
}
void InfoLog(char *logfile,char * text1,char * text2,char * text3)
{
	FILE *fs;
	char *user_name_string = NULL;
	char* text=getMess(text1,text2,text3);


	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	
		fprintf(fs, "\t %s \n", text);
	fclose(fs);
	if(text)free(text);
}
void InfoLogInt(char *logfile,char * text1,int print_int,char * text3)
{
		FILE *fs;
	//char *user_name_string = NULL;
	//char* text=getMess(text1,text2,text3);


	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	
		fprintf(fs, "\t %s %d %s\n", text1,print_int,text3 );
	fclose(fs);
	//if(text)free(text);
}

void Crete_InfoLog( char *logfile, char* time_stamp)
{
	FILE *fs;

	
	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	fprintf(fs, " -------------Start programu stazeni datasetu typu XLSX \n cas:%s \n \n", time_stamp);
	fclose(fs);
}
void Konec_infoLog( char *logfile, char* time_stamp)
{
		FILE *fs;
	char *user_name_string = NULL;


	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	fprintf(fs, " Konec programu ------------- \n cas:%s \n \n",  time_stamp);
	fclose(fs);

}
void Import_infoLog(tag_t Vrchol,char *logfile,char* time_stamp)
{//import log
	tag_t updatedLog;
	char logFilePath[100]="C:\\Temp\\";
	char logName[100]="log_import_";
	strcat(logFilePath,logfile);
	strcat(logFilePath, ".log");
	strcat(logName,time_stamp);
	strcat(logName, ".txt");
	create_dataset("Text","Import_log",NULLTAG,Vrchol,&updatedLog);
	importDatates(updatedLog,logFilePath,"Text",logName);
}
void Delete_infoLog(char *logfile)
{
	char delFile[70];
	strcpy(delFile, "DEL C:\\Temp\\");
	strcat(delFile, logfile);
	strcat(delFile, ".log");

	//system("pause");
	system(delFile);
}

