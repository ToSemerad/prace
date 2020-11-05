//// include guard
//#ifndef __MYCLASS_H_INCLUDED__
//#define __MYCLASS_H_INCLUDED__

#pragma once



//#include "Gtac_err_reports.h"

 void create_dataset(char *type_name, char *name, tag_t item, tag_t rev, tag_t *dataset);//create_dataset("PDF", dataset_name, Item,  Rev, &dataset);

void importDatates(tag_t dataset,char* way,char *ref,char *fileName); //importDatates(dataset,way,"PDF_Reference",fileName);


//
//#endif