// include guard
#ifndef __MYCLASS_H_INCLUDED__
#define __MYCLASS_H_INCLUDED__

#pragma once

char* Owner(tag_t object);

void Create(char hodnoty[50][256],int TypPolozky_num, tag_t owner, tag_t ownerGroup);

void SetProperty (int polozka_num,int num,tag_t object_type,char* value);

tag_t FindRev(char* itemId,char* revId);

char* CreateLink2TC(tag_t Targets, char* html_adres);

#endif