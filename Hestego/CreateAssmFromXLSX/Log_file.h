#define  _CRT_SECURE_NO_WARNINGS 1

void InfoLog(char *logfile,char * text1,char * text2,char * text3);

void Crete_InfoLog( char *logfile, char* time_stamp);

void InfoLogInt(char *logfile,char * text1,int print_int,char * text3);

void Konec_infoLog( char *logfile, char* time_stamp);

void Import_infoLog(tag_t Vrchol,char *logfile,char* time_stamp);