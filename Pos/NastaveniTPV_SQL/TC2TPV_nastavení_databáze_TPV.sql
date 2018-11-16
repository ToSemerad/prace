IF NOT EXISTS (select top 1 1 from sys.sysobjects where name = 'tpvg_tc2tpv_config')
BEGIN
	CREATE TABLE dbo.tpvg_tc2tpv_config (
		klic_config int identity,
		nazev_pole_tpv varchar(255),
		nazev_pole_tc varchar(255),
		poznamka varchar(500),
		typ varchar(1),
		velikost int
	)

	GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.tpvg_tc2tpv_config TO PUBLIC

	-- alter table tpvg_tc2tpv_config add typ varchar(1)
	-- alter table tpvg_tc2tpv_config add velikost int
END

-- select * from tpvg_tc2tpv_config

GO

IF NOT EXISTS (select top 1 1 from sys.sysobjects where name = 'tpvg_c2t_import_ext')
BEGIN
	
	CREATE TABLE dbo.tpvg_c2t_import_ext (
		klic_import_ext int identity,
		klic_import int,
		s1 varchar(30),
		s2 varchar(30),
		s3 varchar(60),
		s4 varchar(60),
		s5 varchar(100),
		s6 varchar(100),
		s7 varchar(100),
		s8 varchar(100),
		s9 varchar(255),
		s10 varchar(255),
		s11 varchar(1024),
		s12 varchar(1024),
		i1 int,
		i2 int,
		i3 int,
		i4 int,
		i5 int,
		i6 int,
		i7 int,
		i8 int,
		i9 int,
		i10 int,
		f1 float,
		f2 float,
		f3 float,
		f4 float,
		f5 float,
		f6 float,
		f7 float,
		f8 float,
		f9 float,
		f10 float
	)

	GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.tpvg_c2t_import_ext TO PUBLIC

END

GO

-- select * from tpv_c2t_import
GO

delete from tpvg_tc2tpv_config
-- sp_help tpv_c2t_import
-- select * from tpvg_tc2tpv_config
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'atr_nazvu_1', 'tpv4_polotovar', 'Atribut názvu položky 1', 'S', 30
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'atr_nazvu_2', 'tpv4_material', 'Atribut názvu položky 2', 'S', 30
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'atr_nazvu_3', 'klic_maxu', 'Atribut názvu položky 3', 'S', 30
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user1', '', 'Uživatelské pole 1', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user2', '', 'Uživatelské pole 2', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user3', '', 'Uživatelské pole 3', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user4', '', 'Uživatelské pole 4', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user5', '', 'Uživatelské pole 5', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user6', '', 'Uživatelské pole 6', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user7', '', 'Uživatelské pole 7', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user8', '', 'Uživatelské pole 8', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user9', '', 'Uživatelské pole 9', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user10', 'tpv4_stav', 'Uživatelské pole 10', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user11', '', 'Uživatelské pole 11', 'S', 60
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user12', '', 'Uživatelské pole 12', 'S', 60
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user13', 'ID_TC', 'Uživatelské pole 13', 'S', 60
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user14', '', 'Uživatelské pole 14', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user1s', '', 'Uživatelské pole struktury 1', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user2s', '', 'Uživatelské pole struktury 2', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user3s', '', 'Uživatelské pole struktury 3', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'user4s', '', 'Uživatelské pole struktury 4', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'plocha', '', 'Plocha', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'objem', '', 'Objem', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'poznamka', '', 'Poznámka položky', 'S', 200
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'tisteny_popis', 'tpv4_poznamka_tpv', 'Tištìný popis', 'S', 500
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'poznamkas', '', 'Poznámka struktury', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'hmotnost_mj', 'tpv4_hmotnost', 'Èistá hmotnost MJ', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'trida', 'tpv4_skupina', 'Tøída', 'S', 30

insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s1', '', 'Parametr String 1', 'S', 30
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s2', '', 'Parametr String 2', 'S', 30
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s3', '', 'Parametr String 3', 'S', 60
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s4', '', 'Parametr String 4', 'S', 60
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s5', '', 'Parametr String 5', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s6', '', 'Parametr String 6', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s7', '', 'Parametr String 7', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s8', '', 'Parametr String 8', 'S', 100
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s9', '', 'Parametr String 9', 'S', 255
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s10', '', 'Parametr String 10', 'S', 255
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s11', '', 'Parametr String 11', 'S', 1024
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_s12', '', 'Parametr String 12', 'S', 1024

insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i1', '', 'Parametr Integer 1', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i2', '', 'Parametr Integer 2', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i3', '', 'Parametr Integer 3', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i4', '', 'Parametr Integer 4', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i5', '', 'Parametr Integer 5', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i6', '', 'Parametr Integer 6', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i7', '', 'Parametr Integer 7', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i8', '', 'Parametr Integer 8', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i9', '', 'Parametr Integer 9', 'I', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_i10', '', 'Parametr Integer 10', 'I', 0

insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f1', '', 'Parametr Float 1', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f2', '', 'Parametr Float 2', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f3', '', 'Parametr Float 3', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f4', '', 'Parametr Float 4', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f5', '', 'Parametr Float 5', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f6', '', 'Parametr Float 6', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f7', '', 'Parametr Float 7', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f8', '', 'Parametr Float 8', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f9', '', 'Parametr Float 9', 'F', 0
insert into tpvg_tc2tpv_config (nazev_pole_tpv, nazev_pole_tc, poznamka, typ, velikost) select 'ext_f10', '', 'Parametr Float 10', 'F', 0

GO
-- select * from vtp_polozka
-- select * from tpvg_tc2tpv_config
-- select * from tpv_c2t_cfg
-- select * from tpv_c2t_import_hlav order by klic_imp_hlav desc
-- select * from tpv_c2t_import where klic_imp_hlav = 23
-- delete from tpv_c2t_import where klic_imp_hlav = 22
-- delete from tpv_c2t_import_hlav where klic_imp_hlav = 22
-- sp_help tpv_c2t_import
-- select * from tpv_c2t_import_dok
-- select * from tpv_c2t_import
-- select * from sys.sysobjects where name like '%dok%' and xtype = 'U'
-- sp_help tpv_c2t_import_dok
-- select * from tpv_tmp_c2t_import_dok

/*
-- DELETE testovacich dat
-- select * from alternazev

declare @k table (klic int)

insert into @k (klic) select klic_polozky from polozka where alter_nazev like 'DA%'

delete from structur where klic_polozky in (select klic from @k)
delete from structur where klic_komponenty in (select klic from @k)
delete from partmod where klic_polozky in (select klic from @k)
delete from opmod where klic_polozky in (select klic from @k)
delete from porizeni_pol where klic_polozky in (select klic from @k)
delete from tpv_polozka_ext where klic_polozky in (select klic from @k)
delete from alternazev where alter_nazev like 'DA%'
delete from polozka where klic_polozky in (select klic from @k)
*/

/*
-- Enable xp cmdshell pro import priloh

-- To allow advanced options to be changed.
EXEC sp_configure 'show advanced options', 1
GO
-- To update the currently configured value for advanced options.
RECONFIGURE
GO
-- To enable the feature.
EXEC sp_configure 'xp_cmdshell', 1
GO
-- To update the currently configured value for this feature.
RECONFIGURE
GO

*/

-- Nastavení konfigurace

-- select * from tpv_c2t_cfg

declare @klic_cfg int

IF EXISTS (select top 1 1 from tpv_c2t_cfg where nazev = 'Team Center')
BEGIN
	select @klic_cfg = klic_cfg from tpv_c2t_cfg where nazev = 'Team Center'

	update tpv_c2t_cfg set
		typ_importu = 1,
		rad_zahl = 1,
		gen_zmena = 1,
		pol_upd = 1,
		str_upd = 1,
		zme_upd = 1,
		naz_vyk = 1,
		priroz = 'R', 
		del_i = 1,
		kont_pril = 0,
		akce_dok_pred = 0,
		aut_ident = 1
	where klic_cfg = @klic_cfg
END
ELSE
BEGIN
	insert into tpv_c2t_cfg (uid, nazev, extenze, typ_importu, oddel_sl, rad_zahl, gen_zmena, pol_upd, str_upd, zme_upd, naz_vyk, priroz, del_i, kont_pril, akce_dok_pred, aut_ident)
	select 0, 'Team Center', 'str', 1, '~', 1, 1, 1, 1, 1, 1, 'R', 1, 0, 0, 1

	select @klic_cfg = @@IDENTITY
END

-- select * from tpv_c2t_cfg_postaveni
delete from tpv_c2t_cfg_postaveni where klic_cfg = @klic_cfg

insert into tpv_c2t_cfg_postaveni (klic_cfg, postaveni_cad, klic_postaveni, changetype, no_insert, pol_upd, zpus_poriz, typ_polozky_cad, no_del_pos, zam_pos)
select @klic_cfg, 'D', 'D', 'K', 0, 0, '', 'D', 0, 0

insert into tpv_c2t_cfg_postaveni (klic_cfg, postaveni_cad, klic_postaveni, changetype, no_insert, pol_upd, zpus_poriz, typ_polozky_cad, no_del_pos, zam_pos)
select @klic_cfg, 'N', 'N', 'K', 0, 0, '', 'N', 0, 0

insert into tpv_c2t_cfg_postaveni (klic_cfg, postaveni_cad, klic_postaveni, changetype, no_insert, pol_upd, zpus_poriz, typ_polozky_cad, no_del_pos, zam_pos)
select @klic_cfg, 'S', 'S', 'K', 0, 0, '', 'S', 0, 0

insert into tpv_c2t_cfg_postaveni (klic_cfg, postaveni_cad, klic_postaveni, changetype, no_insert, pol_upd, zpus_poriz, typ_polozky_cad, no_del_pos, zam_pos)
select 2, 'F', 'F', 'K', 0, 0, '', 'S', 0, 0;

update tpv_c2t_cfg_postaveni set typ_polozky_cad = 'S' where klic_cfg = 2 and klic_postaveni = 'D'
-----------------------------------------------------------------
------------------ SPUSTIT ODSUD DÁL !!!!!-----------------------
-----------------------------------------------------------------

GO

IF NOT EXISTS (select top 1 1 from sys.sysobjects where name = 'tpvg_c2t_import_dok')
BEGIN
	
	-- sp_help tpv_c2t_import_dok
	CREATE TABLE dbo.tpvg_c2t_import_dok (
		klic_import_priloha int identity,
		klic_importu int not null,
		rad_importu int,
		soubor varchar(255),
		extenze varchar(50),
		stav char(1)
	)
	
	GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.tpvg_c2t_import_dok TO PUBLIC
	
END

GO

GRANT SELECT ON dbo.tpv_c2t_cfg TO PUBLIC
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.tpv_c2t_import_hlav TO PUBLIC
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.tpv_c2t_import TO PUBLIC
GRANT SELECT, INSERT, UPDATE, DELETE ON dbo.tpv_priloha_objekt TO PUBLIC