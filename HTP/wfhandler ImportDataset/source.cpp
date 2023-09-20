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
#include <ae\ae.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <tccore\aom.h>

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
	char* test = "fsdhgf";
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
		ECHO(("L:%d result %s \n", __LINE__,result));
	}
	return result;
}

tag_t create_relation(char relation_type[GRM_relationtype_name_size_c + 1], tag_t primary_object_tag, tag_t secondary_object_tag)
{
	ECHO(("L:%d partrev %d design %d \n", __LINE__, primary_object_tag, secondary_object_tag));
	tag_t relation_type_tag = NULLTAG;
	GRM_find_relation_type(relation_type, &relation_type_tag);
	ECHO(("realtion type_%d \n -primary_object_tag %d \n -secondary_object_tag %d \n", relation_type_tag, primary_object_tag, secondary_object_tag));
	tag_t relation_tag = NULLTAG;
	GRM_create_relation(primary_object_tag, secondary_object_tag, relation_type_tag, NULLTAG, &relation_tag);

	GRM_save_relation(relation_tag);
	return relation_tag;
}

static void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset)
{
	char
		format_name[AE_io_format_size_c + 1] = "BINARY_REF";
	tag_t
		datasettype,
		tool;

	AE_find_datasettype2(type_name, &datasettype);
	if (datasettype == NULLTAG)
	{
		//ECHO(("Dataset Type %s not found!\n", type_name);
		exit(EXIT_FAILURE);
	}

	AE_ask_datasettype_def_tool(datasettype, &tool);

	//ECHO(("Creating Dataset: %s\n", name);
	AE_create_dataset_with_id(datasettype, name, "", "", "", dataset);
	//verze TC11  AE_create_dataset(datasettype, name, "", dataset);

	AE_set_dataset_tool(*dataset, tool);
	if (strcmp(type_name, "PDF")) strcpy(format_name, "PDF");

	AE_set_dataset_format2(*dataset, format_name);
	//ECHO(("Saving Dataset: %s\n", name);
	AOM_save_with_extensions(*dataset);

	/*attach dataset to item revision */
	create_relation("IMAN_specification", rev, *dataset);
	// ITEM_attach_rev_object(rev, *dataset, ITEM_specification_atth);
   //  ITEM_save_item(item);

}
void importDatates(tag_t dataset, char* way, char *ref, char *fileName)
{
	/*  AE_find_dataset finds latest revision of dataset */

	//IFERR_ABORT(AE_find_dataset("6667776-A", &dataset));
	//ECHO("\n dataset: %u \n", dataset);
	AOM_lock(dataset);
	AOM_refresh(dataset, TRUE);
	//  ECHO(("\n dataset=%d) \n ref=%s) \n way=%s) \n filename=%s) \n",dataset, ref, way, fileName);
	  /* the fourth argument must be a unique name in the volume */
	AE_import_named_ref(dataset, ref, way, fileName, SS_BINARY);
	// AE_import_named_ref(dataset, "UG-QuickAccess-Binary", "W:\\images_preview.qaf", "6667776-A_binary.qaf",  SS_BINARY);

	AOM_save_with_extensions(dataset);
	AOM_refresh(dataset, FALSE);
	AOM_unlock(dataset);
	AOM_unload(dataset);
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
		if (strcmp("importFile", Flag) == 0 && Value != nullptr)
		{
			// …
			ECHO(("value property %s \n", Value));
			//system(Value);
			//exec(Value);
			//strcpy(Vlastnost, Value);
		}

	
		
	}

	create_dataset("PDF", dataset_name, Item, Rev, &dataset);
	
    return ITK_ok;
}