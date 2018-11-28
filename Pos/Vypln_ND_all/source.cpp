#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <epm/epm.h>
#include <ict/ict_userservice.h>
#include <tc/tc.h>
#include <user_exits/user_exits.h>
#include <tc/tc.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <ps/ps.h>
#include <bom/bom.h>

#define ERROR_CHECK(X) (report_error( __FILE__, __LINE__, #X, (X)))

extern "C" DLLAPI int TPV_Call_vypln_ND_TC11_register_callbacks();
extern "C" DLLAPI int TPV_Call_vypln_ND_TC11_init_module(int *decision, va_list args);
int TPV_Call_vypln_ND(EPM_action_message_t msg);
EPM_decision_t RhTest(EPM_rule_message_t msg);
int ListBomLine(tag_t BomLine, int Level, int decision, char* ItemId);
extern "C" DLLAPI int TPV_Call_vypln_ND_TC11_register_callbacks()
{
    printf("Registruji TPV_Call_vypln_ND_TC11.dll\n");
    CUSTOM_register_exit("TPV_Call_vypln_ND_TC11", "USER_init_module", TPV_Call_vypln_ND_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_Call_vypln_ND_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

   //Registrace action handleru
    int Status = EPM_register_action_handler("TPV_Call_vypln_ND", "", TPV_Call_vypln_ND);
    if(Status == ITK_ok) printf("Action handler %s byl registrován\n", "TPV_Call_vypln_ND");

    //// Registrace rule handleru
    // int Status = EPM_register_rule_handler("RhTest", "", RhTest);
    //if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");

    return ITK_ok;
}



int TPV_Call_vypln_ND(EPM_action_message_t msg)
{

    tag_t

		RootTask=NULLTAG;


	//int BomsCount = 0;
        //tag_t *Boms = NULLTAG;

	EPM_ask_root_task ( msg.task, &RootTask );

        system("C:\\SPLM\\TC\\bin\\VyplnND.exe");



    return ITK_ok;
}