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
#include <tccore\grm.h>

#include <cstdio>
#include <iostream>
#include <memory>
#include <stdexcept>
#include <string>
#include <array>

#define ECHO(X)  printf X; TC_write_syslog X

extern "C" DLLAPI int TPV_CallImport_TC14_register_callbacks();
extern "C" DLLAPI int TPV_CallImport_TC14_init_module(int *decision, va_list args);
int TPV_CallImport_TC14(EPM_action_message_t msg);
//EPM_decision_t RhTest(EPM_rule_message_t msg);

extern "C" DLLAPI int TPV_CallImport_TC14_register_callbacks()
{
    ECHO(("Registruji Handler-TPV_CallImport_TC14.dll\n"));
    CUSTOM_register_exit("TPV_CallImport_TC14", "USER_init_module",TPV_CallImport_TC14_init_module);

    return ITK_ok;
}

extern "C" DLLAPI int TPV_CallImport_TC14_init_module(int *decision, va_list args)
{
    *decision = ALL_CUSTOMIZATIONS;  // Execute all customizations

    // Registrace action handleru
    int Status = EPM_register_action_handler("TPV_CallImport_TC14", "",TPV_CallImport_TC14);
    if(Status == ITK_ok) ECHO(("Handler pro pridani TP do targetu %s byl registrován\n", "TPV_CallImport_TC14"));

    // Registrace rule handleru
    /*Status = EPM_register_rule_handler("RhTest", "", RhTest);
    if(Status == ITK_ok) ECHO(("Rule handler %s byl registrován\n", "RhTest");
	*/
    return ITK_ok;
}

std::string exec(const char* cmd) {
	std::array<char, 128> buffer;
	std::string result;
	std::unique_ptr<FILE, decltype(&_pclose)> pipe(_popen(cmd, "r"), _pclose);
	if (!pipe) {
		throw std::runtime_error("popen() failed!");
		ECHO(("L:%d \n", __LINE__));
	}
	while (fgets(buffer.data(), buffer.size(), pipe.get()) != nullptr) {
		result += buffer.data();
		ECHO(("L:%d \n", __LINE__));
	}
	return result;
}

int TPV_CallImport_TC14(EPM_action_message_t msg)
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
		ECHO(("value property %s %s\n", Value, Flag));
		if (strcmp("RunBat", Flag) == 0 && Value != nullptr)
		{
			// …
			ECHO(("value property %s \n", Value));
			//system(Value);
			exec(Value);
			//strcpy(Vlastnost, Value);
		}
	
		
	}
    return ITK_ok;
}