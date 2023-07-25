select * from tpvg_tc2tpv_config;
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'trida', 'tpv4_skupina', 'Tøída', 'S', 30;
delete from tpvg_tc2tpv_config where klic_config=30;

select * from vtp_priloha_objekt where klic_objektu = 83415
select * from tpv_priloha_objekt where klic_objektu = 83415

select *  from partmod where klic_polozky = 100272

BEGIN TRAN
delete from tpv_priloha_objekt where klic_priloha_objekt = 19686
delete from tpv_priloha_objekt where klic_priloha_objekt = 19687
ROLLBACK