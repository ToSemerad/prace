#include <tc\folder.h>
#include <tccore/aom_prop.h>
#include <tccore/aom.h>
#include <qry\qry.h>

void MoveTPToFolder(tag_t folder,tag_t object)
{ 
   //insert to folder
	ITK_set_bypass(true);
    AOM_refresh( folder, TRUE);
    FL_insert(folder, object, 0);
    AOM_save(folder);
    AOM_refresh( folder, TRUE);
	ITK_set_bypass(false);
	//printf("vlozeno!!!!!!!!!!!\n");
}

void IntoFolder(char* folderName,tag_t Item)
{
					tag_t query = NULLTAG,
				* folder=NULLTAG;
				QRY_find("General...", &query);
				printf("tag foldru Qry General je %d\n",query);
				// Find user's "Tasks to Perform" folder
				char *entries[2] = {"Name","Type"};
				char *values[2] =  {folderName,"Folder"};
				int n_folder = 0;
				//strcpy(values[0],folder);
				
							
				QRY_execute(query, 2, entries, values, &n_folder, &folder);
				printf("pocet nalezu %d\n",n_folder);

				//vloženi do folder TPianty
				MoveTPToFolder(*folder,Item);
}