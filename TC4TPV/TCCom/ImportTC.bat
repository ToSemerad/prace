rem @echo off
set arg1=%1
call C:\SPLM\TC\tc_menu\TC_HESTEGO_import.bat
C:\SPLM\TC\bin\TPV2TC.exe -u=%1
pause
exit
