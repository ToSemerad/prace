#include <errno.h>
#include <time.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <string.h>
#include <stdio.h>
#include <tccore/workspaceobject.h>
#include <epm/epm.h>
char *time_stamp();

void LogErr(char * text, char *logfile, int line)
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
	fprintf(fs, "user: %s;  cas:%s; line: %d text: %s \n", user_name_string, time_stamp(), line, text);
	fclose(fs);
}
void LogErrMES(char * text, char *logfile, int line,int returnCode)
{
	if (returnCode != ITK_ok)
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
	char *error_message_string;
	char *time = time_stamp();
	EMH_ask_error_text(returnCode, &error_message_string);
	fs = fopen(file, "a+");
	fprintf(fs, "user: %s;  cas:%s; line: %d text: %s \n", user_name_string, time_stamp(), line, error_message_string);
	fclose(fs);
	}
}
char *time_stamp() {

	char *timestamp = (char *)malloc(sizeof(char) * 16);
	//char timestamp[10];
	time_t ltime;
	ltime = time(NULL);
	struct tm *tm;
	tm = localtime(&ltime);

	sprintf(timestamp, "%04d-%02d-%02d %02d:%02d:%02d", tm->tm_year + 1900, tm->tm_mon + 1,
		tm->tm_mday, tm->tm_hour, tm->tm_min, tm->tm_sec);


	return timestamp;
}
static void report_error(char *file, int line, char *function, int return_code)
{

	if (return_code != ITK_ok)
	{
		
		char *error_message_string;
		char *time = time_stamp();
		EMH_ask_error_text(return_code, &error_message_string);
		//EMH_ask_errors(NULLTAG, return_code, &error_message_string);
		/*ECHO((">>>>> %s \n", time));
		ECHO(("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string));
		ECHO(("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line));**/
		printf(">>>>> %s \n", time);
		printf("ERROR: %d ERROR MSG: %s.\n", return_code, error_message_string);
		printf("FUNCTION: %s\nFILE: %s LINE: %d\n", function, file, line);
		//LogErr(error_message_string, "report_error", line, time);

		if (error_message_string) MEM_free(error_message_string);
		//ECHO(("\nExiting program!\n <<<<<<<\n"));
		//exit(EXIT_FAILURE);
	}
}
bool is_release(tag_t obj)
{

	int is_released = 0;
	EPM_ask_if_released(obj, &is_released);

	if (is_released == 0)
		return false;

	return true;
}