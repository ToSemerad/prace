____________________________________________________________________________
|--------------------------------------------------------------------------|
|----------------------------TPV2TC----------------------------------------|
|-sada importních nástroju pro import nakupovaných položek z TPV2000 do TC-|
|--------------------------------------------------------------------------|
|__________________________________________________________________________|
Nastavení prostøeníd se skládá z 2 konfikuraèních souborù:


>>java_Readpropery:
		=nastavení ètení z DB pomocí.
		-v souboru je dùležité
		-server,databaze,user,pasword,view,
		-dale nasleduji atributy pro ètení libovolné poøadí i poèet
		-poslední nazev pøenosové tabulky, která se s každým pøenosem pøepisuje

>>TPV2TC.xml:
		=nastevení zápisu do TC
		-v xml struktuøe uživatelské udaje - tento uživatel bude vlastník dat
		-<importFolder> folder do které se ukládají komunikaèni tabulky
		-pole mezi <polozka> a </polozka> jsou attributy pro zápis
		-poøadí atributu stejné jako v csv poze vertikálnì seøazené navíc je <ItemType> což urèuje typ položky
		-pro každý atribut lze zvolit datový typ (<string>, <double>,<date>,<int>)
		-lze urcit folder pro ukladání pommoví <folder>
		-lze také využit možnost kopirovat string do dvou polí jedné položky <copy_string> kde nezy taky je urèený zdroj a cíl kam se má kopírovat (napø: <copy_string>object_name#tpv4_nazev_erp#</copy_string>)
		-