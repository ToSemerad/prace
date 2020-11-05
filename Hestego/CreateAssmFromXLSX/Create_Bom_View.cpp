#define  _CRT_SECURE_NO_WARNINGS 1

#include <stdio.h>
#include <tccore/custom.h>
#include <tc\tc.h>
#include <tccore/item.h>
#include <tccore/aom_prop.h>
#include <tccore/aom.h>
#include <ps/ps.h>
#include <ps\gcr.h>
#include <ps\gcr_errors.h>
#include <epm/epm.h>
#include <error.h>
#include <time.h>

#include "Gtac_err_reports.h"
#include "Log_file.h"
#include "Global_var.h"

static void report_error(char *file, int line, int return_code)
{
	if (return_code != ITK_ok)
	{
		char *error_message_string;

		EMH_get_error_string(NULLTAG, return_code, &error_message_string);
		printf("\nFILE: %s LINE: %d\n ERROR: %s\n", file, line, error_message_string);
		InfoLog( LogFileName, "Kusuvnik Err: ",error_message_string,"");
		if (error_message_string) MEM_free(error_message_string);
	}
}

void  Add_occ(tag_t bvr,tag_t Child_rev,char* seq_no ,char* qnt )
{
	ITK_set_bypass(true);
	AOM_lock(bvr);
	AOM_lock(Child_rev);
	tag_t *Occ;
		printf ("vlozit dalsi radek\n");
	int Status;
	printf(">>>qnt %s \n",qnt);
	double quantity=atof(qnt);
	if(quantity<1)printf ("nastavujz 0 ->1 \n"),quantity=1;
	printf(">>>quattity %f \n",quantity);
	printf("bvr %d, Child_rev %d \n",bvr, Child_rev);
		Status=PS_create_occurrences(bvr, Child_rev,NULLTAG,1,&Occ);
		if(Status ==ITK_ok)EMH_clear_last_error(Status);
		printf("line %d \n",__LINE__);
		
		Status=PS_set_occurrence_qty( bvr, *Occ, quantity );
		if(Status ==ITK_ok)EMH_clear_last_error(Status);
		printf("line %d \n",__LINE__);
		//Sets the sequence number of an occurrence.
		if(strcmp(seq_no,"0")!=0)
		Status=PS_set_seq_no( bvr, *Occ,seq_no);
		if(Status !=ITK_ok)	report_error(__FILE__, __LINE__, Status);
		printf("line %d \n",__LINE__);
		AOM_save(bvr);
		AOM_save(Child_rev);
		AOM_unlock(Child_rev);
		AOM_unlock(bvr);
		AOM_refresh(bvr,FALSE);	
		printf("line %d \n",__LINE__);
}
int Crete_Tech_Kus(tag_t Parent, tag_t Parent_rev, tag_t Child_rev,char* seq_no,char* qnt)
{
	ITK_set_bypass(true);
		tag_t BomView = NULLTAG;
		tag_t TopBomLineTP =NULLTAG;

		tag_t query = NULLTAG;
		tag_t bvr =NULLTAG;


		char rev_id[ITEM_id_size_c+1];
		//tag_t BomViewType =NULLTAG;

		// BomView Type
	tag_t BomViewType= NULLTAG;
	PS_ask_default_view_type( &BomViewType);
	printf("BomViewType %d \n",BomViewType);			

	printf(" Parent %d \n Parent_re %d \n Child_Rev %d \n",Parent,Parent_rev,Child_rev);
	int Status=PS_create_bom_view (BomViewType, NULL, NULL, Parent, &BomView);
	if(Status !=ITK_ok)	report_error(__FILE__, __LINE__, Status);
	
	printf("BomView %d \n",BomView);
	AOM_save (BomView);
	ITEM_save_item(Parent);
	
	ITEM_ask_rev_id( Parent_rev,rev_id);
	printf("\n rev_id %s \n", rev_id);
    
	Status=PS_create_bvr (BomView, NULL, NULL,  true, Parent_rev, &bvr);
	if(Status !=ITK_ok)	report_error(__FILE__, __LINE__, Status);
	printf("bvr %d \n",bvr);
    AOM_save (bvr);
    AOM_save(Parent_rev);


	//tag_t *Occ=NULLTAG;	
							
	ITEM_ask_rev_id( Child_rev,rev_id);
	printf("rev_id %s \n", rev_id);
	//	AOM_lock(bvr);
		printf("line %d \n",__LINE__);				
		Add_occ(bvr,Child_rev,seq_no,qnt);				
	//	int Status=PS_create_occurrences(bvr, Child_rev,NULLTAG,1,&Occ);
	//	printf(" status %d \n",Status);
					
	//	printf("tag Occ %d \n",*Occ);
	/*	AOM_save(bvr);
		AOM_save(Parent_rev);
		AOM_unlock(bvr);*/
		AOM_refresh(bvr,FALSE);
		//ITK_set_bypass(false);
		//MEM_free(Occ);
		printf("line %d \n",__LINE__);
		printf(" BomView %d \n",BomView);
return BomView;

}

void Make_View  (tag_t Parent_rev,tag_t Parent, tag_t rev, tag_t *BomWindow_part, char* seq_no, char* qnt)
{
	ITK_set_bypass(true);
	printf("line=%d \n",__LINE__);
	printf("tag_t Parent_rev %d \n",Parent_rev);
	//printf("tag_t Parent_rev %d,tag_t Parent %d, tag_t rev %d,tag_t design_view %d,tag_t design_bomline %d, tag_t *BomWindow_part %d, char* seq_no %s, char* qnt  %s\n",Parent_rev, Parent, rev, design_view, design_bomline, *BomWindow_part, seq_no, qnt);
	int n_bvrs = 0;
								tag_t *bvrs = NULLTAG;
								int Status=AOM_refresh(Parent_rev,TRUE);
								if(Status !=ITK_ok)	report_error(__FILE__, __LINE__, Status);

								printf("Parent_rev %d \n",Parent_rev);
								Status=ITEM_rev_list_bom_view_revs(Parent_rev, &n_bvrs, &bvrs);
								if(Status !=ITK_ok)	report_error(__FILE__, __LINE__, Status);

								printf(" n_bvrs %d \n bvrs %d\n",n_bvrs);
								if(n_bvrs==0)
								{
									printf("zadny kusovnik \n");
									InfoLog( LogFileName, "Zakladam novy kusovnik ","","");
									tag_t tech_View=Crete_Tech_Kus( Parent, Parent_rev, rev,seq_no,qnt);
									InfoLog( LogFileName, "Vytvoreni noveho radku ","","");
									//Vytvoø relace mezi kusovniky Link Associate 
									tag_t relation_type;
								//	GRM_find_relation_type("Fnd0DesignToBomLink", &relation_type);
									
									
									printf(" relation_type %d tech_View %d\n",relation_type,tech_View);
									*BomWindow_part=tech_View;
									printf("line %d \n",__LINE__);
								
									
									
								}else if(n_bvrs==1)
								{
									printf("jeden kusovník %d \n",bvrs[0]);
									InfoLog( LogFileName, "Vkladani  do existujiciho","","");
									 Add_occ(bvrs[0],rev,seq_no,qnt);
									 printf("line %d \n",__LINE__);
									 *BomWindow_part=bvrs[0];
								}
								if(bvrs)MEM_free(bvrs);
						ITK_set_bypass(false);
}