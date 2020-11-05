
#include <epm/epm.h>
#include <error.h>
#include <tc/tc.h>
#include <time.h>

#include "Log_file.h"
#include "Global_var.h"

#define ECHO(X)  printf X; TC_write_syslog X

#define SAFE_MEM_FREE( a )   \
do                          \
{                           \
    if ( (a) != NULL )      \
    {                       \
        MEM_free( (a) );    \
        (a) = NULL;         \
    }                       \
}                           \
while ( 0 )

void LogErr(char * text, char *logfile, int line, char* time_stamp)
{
	FILE *fs;
	char *user_name_string = NULL;
	tag_t user_tag = NULLTAG;
	int ifail = POM_get_user(&user_name_string, &user_tag);
	if (ifail != ITK_ok) user_name_string = "Nenalezen";

	char file[50];
	strcpy(file, "C:\\Temp\\");
	strcat(file, logfile);
	strcat(file, ".log");

	fs = fopen(file, "a+");
	fprintf(fs, "user: %s;  cas:%s; line: %d text: %s \n", user_name_string, time_stamp, line, text);
	InfoLog(LogFileName,"Err:",text,"");
	fclose(fs);
}
char *time_stamp() {

	char *timestamp = (char *)malloc(sizeof(char) * 16);
	//char timestamp[10];
	time_t ltime;
	ltime = time(NULL);
	struct tm *tm;
	tm = localtime(&ltime);

	sprintf(timestamp, "%04d-%02d-%02d_%02d:%02d:%02d", tm->tm_year + 1900, tm->tm_mon + 1,
		tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);


	return timestamp;
}

 void report_error(char *file, int line, char *function, int return_code)
{
	if (return_code != ITK_ok)
	{
		
		char *time = time_stamp();
		char *error_message_string;
		EMH_get_error_string(NULLTAG, return_code, &error_message_string);
		printf("%s line: %d \n",__FILE__,__LINE__);
		ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));

		LogErr(error_message_string, "report_error", line, time);

		if (error_message_string) MEM_free(error_message_string);
		ECHO(("\nExiting program!\n <<<<<<<\n"));
		//system("pause");
		//exit(EXIT_FAILURE);
	}
}