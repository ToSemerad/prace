____________________________________________________________________________
|--------------------------------------------------------------------------|
|----------------------------TPV2TC----------------------------------------|
|-sada importn�ch n�stroju pro import nakupovan�ch polo�ek z TPV2000 do TC-|
|--------------------------------------------------------------------------|
|__________________________________________________________________________|
Nastaven� prost�en�d se skl�d� z 2 konfikura�n�ch soubor�:


>>java_Readpropery:
		=nastaven� �ten� z DB pomoc�.
		-v souboru je d�le�it�
		-server,databaze,user,pasword,view,
		-dale nasleduji atributy pro �ten� libovoln� po�ad� i po�et
		-posledn� nazev p�enosov� tabulky, kter� se s ka�d�m p�enosem p�episuje

>>TPV2TC.xml:
		=nasteven� z�pisu do TC
		-v xml struktu�e u�ivatelsk� udaje - tento u�ivatel bude vlastn�k dat
		-<importFolder> folder do kter� se ukl�daj� komunika�ni tabulky
		-pole mezi <polozka> a </polozka> jsou attributy pro z�pis
		-po�ad� atributu stejn� jako v csv poze vertik�ln� se�azen� nav�c je <ItemType> co� ur�uje typ polo�ky
		-pro ka�d� atribut lze zvolit datov� typ (<string>, <double>,<date>,<int>)
		-lze urcit folder pro uklad�n� pommov� <folder>
		-lze tak� vyu�it mo�nost kopirovat string do dvou pol� jedn� polo�ky <copy_string> kde nezy taky je ur�en� zdroj a c�l kam se m� kop�rovat (nap�: <copy_string>object_name#tpv4_nazev_erp#</copy_string>)
		-