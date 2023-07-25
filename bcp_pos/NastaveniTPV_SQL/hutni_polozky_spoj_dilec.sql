IF EXISTS (select top 1 1 from sys.sysobjects where name = 'vtp_tpvg_tc_dilec_hutni')
       DROP VIEW dbo.vtp_tpvg_tc_dilec_hutni

GO

CREATE VIEW dbo.vtp_tpvg_tc_dilec_hutni AS
select 
       klic_polozky, alter_nazev_v, nazev_polozky_v, atr_nazvu_1_v, atr_nazvu_2_v, atr_nazvu_3_v, klic_komponenty, alter_nazev, nazev_polozky, atr_nazvu_1,
       atr_nazvu_2, atr_nazvu_3, mnozstvi, zkratka_mj,createdate
from 
(
       select
             row_number() over (partition by klic_polozky order by compseqno) cislo_radku, *
       from vtp_structur
       where left(alter_nazev, 3) in (
             '372', '425', '427', '500', '505', '506', '510', '514', '520', '522', '540', '550', '610', '615', '613',
             '732', '790', '791', '793', '794', '795', '796', '797', '761', '737', '738', '740', '741', '755', '754',
             '756', '777', '788'
       ) and klic_zpus_poriz = 'N' and offmodno = 32767
) t1
where cislo_radku = 1

GO

GRANT SELECT ON dbo.vtp_tpvg_tc_dilec_hutni TO PUBLIC

GO

SELECT * FROM vtp_tpvg_tc_dilec_hutni

GO
