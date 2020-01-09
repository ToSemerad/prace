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
#include <tccore\grm.h>

extern "C" DLLAPI int TPV_CallImport_TC11_register_callbacks();
extern "C" DLLAPI int TPV_CallImport_TC11_init_module(int *decision, va_list args);
int TPV_CallImport_TC11(EPM_action_message_t msg);
//EPM_decision_t RhTest(EPM_rule_message_t msg);
void ListBomLine(tag_t BomLine, int Level, tag_t RootTask);
extern "C" DLLAPI int TPV_CallImport_TC11_register_callbacks()
{
    printf("Registruji Handler-TPV_CallImport_TC11.dll\n");
    CUSTOM_register_exit("TPV_CallImport_TC11", "USER_init_module",TPV_CallImport_TC11_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_CallImport_TC11_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_CallImport_TC11", "",TPV_CallImport_TC11);
    if(Status == ITK_ok) printf("Handler pro pridani TP do targetu %s byl registrován\n", "TPV_CallImport_TC11");

    // Registrace rule handleru
    /*Status = EPM_register_rule_handler("RhTest", "", RhTest);
    if(Status == ITK_ok) printf("Rule handler %s byl registrován\n", "RhTest");
	*/
    return ITK_ok;
}


int TPV_CallImport_TC11(EPM_action_message_t msg)
{
	tag_t RevisionClassTag = NULLTAG;
	char *Argument = nullptr;
	char*Flag = nullptr;
	char*Value = nullptr;
	logical and = false;
	logical or = false;
	char import_path [30];

	int ArgumentCount = TC_number_of_arguments(msg.arguments);

	while (ArgumentCount-- > 0)
	{
		Argument = TC_next_argument(msg.arguments);
		ITK_ask_argument_named_value((const char*)Argument, &Flag, &Value);
		printf("value property %s %s\n", Value, Flag);
		if (strcmp("RunBat", Flag) == 0 && Value != nullptr)
		{
			// …
			printf("value property %s \n", Value);
			system(Value);
			//strcpy(Vlastnost, Value);
		}
	
		
	}
    return ITK_ok;
}