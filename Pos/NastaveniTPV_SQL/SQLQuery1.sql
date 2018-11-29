select * from tpvg_tc2tpv_config;
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'trida', 'tpv4_skupina', 'Tøída', 'S', 30;
delete from tpvg_tc2tpv_config where klic_config=30;