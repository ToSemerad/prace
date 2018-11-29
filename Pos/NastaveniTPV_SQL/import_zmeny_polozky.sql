select * from vtp_chandes;
select * from vtp_tpvg_tc_nakupovane where atr_nazvu_3='UMRTVENO';
select * from vtp_tpvg_tc_nakupovane;

select * from tpv_c2t_import;

select * from tpv_c2t_chyb_hlas;
select * from tpvg_tc2tpv_config
delete tpvg_tc2tpv_config where klic_config=31;

select * from vtp_tpvg_tc_nakupovane where lastamenddate>'2018-04-18';
select * from vtp_tpvg_tc_nakupovane where klic_polozky=9960;
select * from tpv_c2t_cfg_postaveni;
insert into tpv_c2t_cfg_postaveni (klic_cfg, postaveni_cad, klic_postaveni, changetype, no_insert, pol_upd, zpus_poriz, typ_polozky_cad, no_del_pos, zam_pos)
select 2, 'F', 'F', 'K', 0, 0, '', 'S', 0, 0;
insert into tpv_c2t_cfg_postaveni (klic_cfg, postaveni_cad, klic_postaveni, changetype, no_insert, pol_upd, zpus_poriz, typ_polozky_cad, no_del_pos, zam_pos)
select 2, 'D', 'D', 'K', 0, 0, '', 'D', 0, 0;