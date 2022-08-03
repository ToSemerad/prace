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
#include <tc/folder.h>
#include <tccore/aom.h>
#include <ctype.h>
#include <tc\folder.h>
#include <lov\lov.h>
#include <error.h>


#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define IFERR_ABORT(X)  (report_error( __FILE__, __LINE__, #X, X, TRUE))
#define IFERR_REPORT(X) (report_error( __FILE__, __LINE__, #X, X, FALSE))

extern "C" DLLAPI int TPV_Create_I_TP_TC10_register_callbacks();
extern "C" DLLAPI int TPV_Create_I_TP_TC10_init_module(int *decision, va_list args);
int TPV_Create_I_TP(EPM_action_message_t msg);
EPM_decision_t A_TPV_Create_I_TP(EPM_rule_message_t msg);


	

   

	
void Add_S_ToTP(char* povrch1, char* povrch2, char* povrch3, tag_t TPrev, tag_t TP)
{
		tag_t BomWindowTP = NULLTAG;
	
		tag_t* P1 = NULLTAG;
		tag_t* P2 = NULLTAG;
		tag_t* P3 = NULLTAG;
	
		tag_t bvr =NULLTAG;
		tag_t P1rev=NULLTAG;
		tag_t P2rev=NULLTAG;
		tag_t P3rev=NULLTAG;

		char rev_id[ITEM_id_size_c+1];
		//tag_t BomViewType =NULLTAG;

		// BomView Type
tag_t BomViewType= NULLTAG;
PS_ask_default_view_type( &BomViewType);
		
							const char *entries1[1] = {ITEM_ITEM_ID_PROP};
							const char *values1[1] =  {povrch1};
							int n_folder1 = 0;
   
							ITEM_find_items_by_key_attributes(1, entries1, values1, &n_folder1, &P1);
							
							ITEM_ask_latest_rev(*P1,&P1rev);
							

							const char *entries2[1] = {ITEM_ITEM_ID_PROP};
							const char *values2[1] =  {povrch2};
							int n_folder2 = 0;
   
							ITEM_find_items_by_key_attributes(1, entries2, values2, &n_folder2, &P2);
							

							const char *entries3[1] = {ITEM_ITEM_ID_PROP};
							const char *values3[1] =  {povrch3};
							int n_folder3 = 0;
   
							ITEM_find_items_by_key_attributes(1, entries3, values3, &n_folder3, &P3);
							


							PS_create_bom_view (BomViewType, NULL, NULL, TP, &BomWindowTP);
							AOM_save (BomWindowTP);
							ITEM_save_item(TP);

							PS_create_bvr (BomWindowTP, NULL, NULL,  true, TPrev, &bvr);
							AOM_save (bvr);
							AOM_save(TPrev);	
							//PS_set_bvr_imprecise(bvr);
							//PS_set_bvr_precise(bvr);
							
							
							//pridani potomku do kusovniku
							tag_t *Occ=NULLTAG;	
							// printf("tag BW %d tag bvr %d \n",BomWindowTP,bvr);
							ITEM_ask_rev_id(P1rev,rev_id);
							printf("rev_id %s \n", rev_id);
							 AOM_lock(bvr);
							 PS_create_occurrences(bvr,*P1,NULLTAG,1,&Occ);
							PS_create_occurrences(bvr,P1rev,NULLTAG,1,&Occ);
							 if (n_folder2 !=0)
							 {
								 printf ("povrch2 vlozit \n");
								ITEM_ask_latest_rev(*P2,&P2rev);
								PS_create_occurrences(bvr,P2rev,NULLTAG,1,&Occ);
							 }
							 if (n_folder3 !=0)
							 {
								 printf("povrch3 vlozit \n");
								 ITEM_ask_latest_rev(*P3,&P3rev);
								PS_create_occurrences(bvr,P3rev,NULLTAG,1,&Occ);
							 }
							 //printf("tag Occ %d \n",*Occ);
							 AOM_save(bvr);
							 AOM_unlock(bvr);

							 MEM_free(Occ);


}
