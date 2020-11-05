#pragma once
//#include "Radek.h"

#define  item_id      "item_id"
#define  id_stredisko      "h4_TP_stredisko"
#define CHUNK 1024 /* read 1024 bytes at a time */

extern char QueryExistenece[10][128];
extern char EntryExistenece[10][128];
extern char AttryExistenece[10][128];
extern char Attr [10][30][128];
extern char Attr_type [10][30][128];
extern char Attr_tpv [10][30][128];
extern char attr_set[10][128];
extern char value_set[10][128];
extern char LogFileName[50];

extern int Type_num;
extern int Add_num[10];
extern int Add_d_num[10];
extern int Attr_num;
extern int Remove_line;
extern int Attr_Typ_polozky;
extern tag_t Zalozeny[20];
//tag_t Schval_Item=NULLTAG;
extern tag_t Schval_Rev;
extern tag_t Schval_Bwr;
extern tag_t Vrchol;
extern tag_t owner;
extern tag_t ownerGrup;
extern int zalozeny_num;



extern char login[20],
	password[30],
	import_file[50],
	group[20],
	from_copy[20],
	from_add[20][20],
	to_add[20],
	to_copy[20];

 struct Uzel{
	char uzel_name[20];
	char obj_id[20];
	tag_t uzelRev;
	tag_t uzelItem;
};
extern int poradi_seznam;
extern Uzel *seznam;