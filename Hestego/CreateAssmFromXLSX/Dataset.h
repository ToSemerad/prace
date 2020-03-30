#include <tccore\aom.h>
#include <ae\ae.h>
#include <tccore\grm.h>
#include <epm/epm.h>


void importDatates(tag_t dataset,char* way,char *ref,char *fileName) //importDatates(dataset,way,"PDF_Reference",fileName);
{
    /*  AE_find_dataset finds latest revision of dataset */
    
    //IFERR_ABORT(AE_find_dataset("6667776-A", &dataset));
    //ECHO("\n dataset: %u \n", dataset);
	AOM_lock(dataset);
    AOM_refresh(dataset, TRUE);
  //  printf("\n dataset=%d) \n ref=%s) \n way=%s) \n filename=%s) \n",dataset, ref, way, fileName);
    /* the fourth argument must be a unique name in the volume */
   AE_import_named_ref(dataset, ref, way, fileName,  SS_BINARY);
  

    AOM_save(dataset); 
    AOM_refresh(dataset, FALSE);
	AOM_unlock(dataset);
    AOM_unload(dataset);
}