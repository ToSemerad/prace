#include <stdio.h>
#include <tc/tc.h>
#include <tc/emh.h>
#include <tccore/item.h>

int main(int argc, char *argv[])
{
    // ITK initialization
    if(ITK_ok != ITK_init_from_cpp(argc, argv))
    {
        fprintf(stderr, "ERROR: Inicializace ITK selhala\n");
        return 1;
    }

    ITK_initialize_text_services(0);

    // Login
    int ReturnCode = TC_init_module("konstrukter_se", "konstrukter_se", "");
    if(ReturnCode != ITK_ok)
    {
        char *Message;
        EMH_ask_error_text(ReturnCode, &Message);
        fprintf(stderr, "ERROR: %s\n", Message);
    }
    printf("Login OK\n");

    // Vyhledání položek
    const char *AttrNames[1] = { ITEM_ITEM_ID_PROP };
    const char *AttrValues[1] = { "*10" };
    int ItemsCount = 0;
    tag_t *Items = NULLTAG;
    ITEM_find_items_by_key_attributes(1, AttrNames, AttrValues, &ItemsCount, &Items);

    if(ItemsCount == 0)
        printf("Nenalezena žádná položka\n");
    else
        printf("Nalezeno %d položek\n", ItemsCount);

    // Výpis položek
    char Id[ITEM_id_size_c + 1];
    char Name[ITEM_name_size_c + 1];
    for(int i = 0; i < ItemsCount; i++)
    {
        ITEM_ask_id(Items[i], Id);
        ITEM_ask_name(Items[i], Name);
        printf("%s %s\n", Id, Name);
    }
    MEM_free(Items);

    // ITK exit
    ITK_exit_module(true);
    return 0;
}