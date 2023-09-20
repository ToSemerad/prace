#pragma once

void LogErr(char * text, char *logfile, int line);
void LogErrMES(char * text, char *logfile, int line, int returnCode);
static void report_error(char *file, int line, char *function, int return_code);
