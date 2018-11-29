UPDATE tpv_event set aktivni = 1,procedura = 'up_TPVg_event_polozka' where objekt=  'polozka' and event = 'post_insert'
UPDATE tpv_event set aktivni = 1,procedura = 'up_TPVg_event_polozka' where objekt=  'polozka' and event = 'post_update'
UPDATE tpv_event set aktivni = 1,procedura = 'up_TPVg_event_polozka' where objekt=  'polozka' and event = 'post_update_all'


DROP Procedure dbo.up_TPVg_event_polozka
go
Create Procedure dbo.up_TPVg_event_polozka
@Objekt Varchar(255),
@Event Varchar(255),
@klic Int,
@param Varchar(255) = NULL
As
BEGIN
SET NOCOUNT ON
DECLARE @user10 Varchar(20),
		@klic_opmod INT,
		@klic_alt_post INT,
		@alter_nazev Varchar(30),
		@trida Varchar(40),
		@tpv_priznaky varchar(32),
		@klic_postaveni char(1),
		@atr_nazvu_3 Varchar(30),
		@atr_nazvu_2 Varchar(30),
		@atr_nazvu_1 Varchar(30),
		@znaku INT,
		@nazev_polozky Varchar(50),
		@min_vyrob_davka FLOAT,
		@user3 Varchar(30),
		@user4 Varchar(30)
		
		
		
	IF @Objekt = 'polozka' and @Event = 'post_insert'
	BEGIN
		SELECT TOP 1 @user10 = isnull(B.user10,''),
					 @klic_opmod = C.klic_opmod,
					 @alter_nazev = alter_nazev,
					 @trida = isnull(trida,''), --obor )
					 @tpv_priznaky = A.tpv_priznaky,
					 @klic_postaveni = klic_postaveni,					 
					 @atr_nazvu_3 = atr_nazvu_3, --klic MAX uživatelské tøídìní
					 @atr_nazvu_2 = atr_nazvu_2,
					 @atr_nazvu_1 = atr_nazvu_1,
					 @nazev_polozky = nazev_polozky,
					 @min_vyrob_davka = min_vyrob_davka,
					 @user3 = isnull(B.user3,''),
					 @user4 = isnull(B.user4,'')
		from POLOZKA A (NOLOCK)
		JOIN tpv_polozka_ext B (NOLOCK) ON A.klic_polozky = B.klic_polozky
		LEFT OUTER JOIN OPMOD C (NOLOCK) ON A.klic_polozky = C.klic_polozky
		WHERE A.klic_polozky = @klic
		
		IF @klic_postaveni IN ('N') AND (@user3 = '' OR @user4 = '')
		BEGIN
			EXEC up_BB_raiserror 'API: U Objednávky musí být vyplnìn ATEST a Prohl. o shodì!',16,-1
			RETURN(-1)
		END
		
		
		
		UPDATE polozka set evid_cena_pol = 0 ,					
						   tpv_priznaky = CASE WHEN isnull(tpv_priznaky,'++++++++++++++++ ') = '++++++++++++++++' THEN 'T+R+++++++++++++++++++++++++++++'
											   ELSE tpv_priznaky END,
											   
							atr_zakaz_pouziti =  CASE when substring(@tpv_priznaky,3,1) in ('M','N') THEN 1 ELSE 0 END,
							trida = CASE WHEN klic_postaveni IN ('N') AND pouze_tpv = 2 AND isnull(trida,'') = '' THEN '222' ELSE trida END --REQ-002785 
						   	
		where klic_polozky = @klic
		
		UPDATE tpv_polozka_ext set sklad_mnozstvi = 0 WHERE klic_polozky = @klic and sklad_mnozstvi <> 0
		
		IF @user10 NOT IN ('OS','ZAK','VYR','VYRA') AND @klic_postaveni not in ('N')
		BEGIN
			EXEC up_BB_raiserror 'API: Preferovaná alternativa u položky musí být OS, ZAK, VYR nebo VYRA',16,-1
			RETURN(-1)
		END
		
		IF @trida = ''
		BEGIN
			EXEC up_BB_raiserror 'API: Není zadán hodnota v poli Obor, nelze uložit !',16,-1
			RETURN(-1)
		END
		
		IF @trida = '414' AND @klic_postaveni <> '2'
		BEGIN
			EXEC up_BB_raiserror 'API: Pro Obor 414 použijte postavení Speciální náøadí !',16,-1
			RETURN(-1)
		END
		
		IF len(@alter_nazev) > 15
		BEGIN
			EXEC up_BB_raiserror 'API: Èíslo výkresu muže mít pro IS MAX nejvíce 15 znakù !',16,-1
			RETURN(-1)
		END
		
		IF LEN(@nazev_polozky) > 33 --and @vyr_pom <> 'A' 
		BEGIN
			SELECT @znaku = LEN(@nazev_polozky)
			EXEC up_BB_raiserror 'API: Název položky mùže mít pro MAX maximálnì 33 znakù, má %d!',16,-1,@znaku
			RETURN(-1)
		END
		
		IF Charindex(' ',rtrim(@alter_nazev)) > 0
		BEGIN
			EXEC up_BB_raiserror 'API: Èíslo výkresu nemùže pro IS MAX obsahovat mezeru !',16,-1
			RETURN(-1)
		END
		
		
		IF (LEN(@atr_nazvu_3) =  0 OR LEN(@atr_nazvu_3) > 8) AND @klic_postaveni not in ('N')
		BEGIN
			EXEC up_BB_raiserror 'API: Hodnota v poli Klíè Maxu (atribut3) musí být pro IS MAX vyplenìna a mùže mít maximálnì 8 znakù!',16,-1
			RETURN(-1)
		END
		
		IF LEN(@atr_nazvu_2) > 20
		BEGIN
			EXEC up_BB_raiserror 'API: Hodnota v poli Vyk/Mater.(atribut2) musí mít pro IS MAX maximálnì 20 znakù!',16,-1
			RETURN(-1)
		END
		
		IF LEN(@atr_nazvu_1) > 20
		BEGIN
			EXEC up_BB_raiserror 'API: Hodnota v poli Rozmìr.norma (atribut1) musí mít pro IS MAX maximálnì 20 znakù!',16,-1
			RETURN(-1)
		END
		
		
		IF @min_vyrob_davka = 0 AND @klic_postaveni not in ('N') AND user_name() <> 'teamcenter'--'POS\teamcenter' --pro import z TC nekontrolovat
		BEGIN
			EXEC up_BB_raiserror 'API: U vyrábìné položky musí být vyplnìna výrobní dávka!',16,-1
			RETURN(-1)
		END
		
		
		IF @klic_opmod IS NULL
		BEGIN
		--EXEC up_BB_raiserror 'zde OS, ZAK',16,-1
				RETURN(-1)
			
			SELECT TOP 1 @klic_alt_post = klic_alt from tpv_alt (NOLOCK)
			WHERE zkrac_nazev_alt = @user10
			
			/*CASE WHEN @user5 = 0 THEN 'OS'
										 WHEN @user5 = 1 THEN 'ZAK'
										 WHEN @user5 = 2 THEN 'VYR'
										 WHEN @user5 = 3 THEN 'VYRA'
										 END*/
			
			EXEC  up_BB_insert_opmod 	@kliczmeny = 1,
													@klicpolozky = @klic,
													@klicalt = -1,
													@popis = 'JO',
													@zamknout = NULL,
													@prava = 'IM',
													@ret_select = 0
			--po rozjezdu provedou kopii z VYR, ale pak u položky nasavují ZAK
			--jenže toto nastaví u postupu, a oni si pak toho nevšimnou.
			--ale nevím jak to mám udqìlt, tohle se zøejmì nevolá pøi insert nebo nìjak divnì
			UPDATE OPMOD set klic_alt = @klic_alt_post	where klic_polozky = @klic AND klic_alt = 1 and modno = 1 and stdalt = 'A'							
			--UPDATE OPMOD set klic_alt = 1	where klic_polozky = @klic AND  modno = 1 --and stdalt = 'A' --AND klic_alt = 1 and							
		 
		END
		

		--export do zásobníku na zpracování
		/*INSERT INTO [dbo].[TPVg_schval_postup_alt]([alter_nazev],[klic_polozky], [klic_partmod], [modno_r], [priroz_r], 
			         [klic_opmod], [modno], [klic_alt], [priroz], [Zdroj],zkrac_nazev_projektu,serie)
		SELECT top 1 alter_nazev,klic_polozky,klic_modifikace,modno,priroz,
		                    klic_opmod,modno,klic_alt,priroz, 
				    @Objekt,
				    null,null
		from vtp_opmod (NOLOCK)
		WHERE klic_polozky = @klic and lastmod = 1 and stdalt = 'A'
		*/
		
	END
	
		IF @Objekt = 'polozka' and @Event = 'post_update'
		BEGIN
			SELECT TOP 1 @user10 = B.user10,
						 @klic_opmod = C.klic_opmod,
						 @tpv_priznaky = A.tpv_priznaky,
						 @atr_nazvu_3 = atr_nazvu_3, --klic MAX uživatelské tøídìní
						 @nazev_polozky = A.nazev_polozky 
			from POLOZKA A (NOLOCK)
			JOIN tpv_polozka_ext B (NOLOCK) ON A.klic_polozky = B.klic_polozky
			LEFT JOIN vtp_OPMOD C (NOLOCK) ON A.klic_polozky = C.klic_polozky AND zkrac_nazev_alt IN ('VYR','VYRA') AND stdalt = 'A' -- napø. 23302850 má nìjak blbì hist. vyr
			WHERE A.klic_polozky = @klic
			
			IF @user10 IN ('OS','ZAK') AND @klic_opmod IS NOT NULL
			BEGIN
				EXEC up_BB_raiserror 'API: Pro položku už existuje alternativa postupu VYR, VYRA - nelze ji nastavit preferovaný postup OS, ZAK',16,-1
				RETURN(-1)
			END
			
			
			IF (LEN(@atr_nazvu_3) =  0 OR LEN(@atr_nazvu_3) > 8) AND @klic_postaveni not in ('N')
		BEGIN
			EXEC up_BB_raiserror 'API: Hodnota v poli Klíè Maxu (atribut3) musí být pro IS MAX vyplenìna a mùže mít maximálnì 8 znakù!',16,-1
			RETURN(-1)
		END
			
			IF LEN(@nazev_polozky) > 33 --and @vyr_pom <> 'A' 
			BEGIN
				SELECT @znaku = LEN(@nazev_polozky)
				EXEC up_BB_raiserror 'API: Název položky mùže mít pro MAX maximálnì 33 znakù, má %d!',16,-1,@znaku
				RETURN(-1)
			END
			
			UPDATE polozka set atr_zakaz_pouziti = CASE WHEN substring(@tpv_priznaky,3,1) in ('M','N') THEN 1
												   ELSE 0 END
			where klic_polozky = @klic									   	
		
		
		--položka se bude exportovat pouze pøi UPDAte, A POUZE POKUD BUDE EXISTOVAT SCHVÁLENá rozpiska, tedy došlo k exportu do MAXu
		
		DELETE TPVg_schval_postup_alt WHERE klic_polozky = @klic AND zdroj = 'POLOZKA' AND priznak_export = 0
		INSERT INTO TPVg_schval_postup_alt (alter_nazev,klic_polozky,zdroj,priznak_export)
		SELECT TOP 1 alter_nazev,klic_polozky,'POLOZKA',0 from vtp_partmod A (NOLOCK)
		WHERE klic_polozky = @klic AND priroz NOT IN ('P','R') AND -- 
		NOT EXISTS (SELECT TOP 1 1 from TPVg_schval_postup_alt B (NOLOCK) WHERE A.klic_polozky = B.klic_polozky
		AND priznak_export = 0) --pokud tøeba schválí rozpisku a pak by ještì šáhl na položku, bude problém s duplicitou
		

		END
		
		--select * from TPVg_schval_postup_alt
		
		--DLE REQ-002624 požadavek na export zamìnitelných materiálù z TPV do MAX
		--volá se z upravené procedury up_BB_zamena_pol - event z klienta je nepoužitelný
		IF @objekt = 'POLOZKA' AND @event = 'post_update_all' AND @param IN ('ZAM_POL') --'Aktualizace/Výbìr položky'
		BEGIN
			--select * into MAX_xzmsal from openquery(MAXostra,"SELECT * from xzmsal")
			--ALTER TABLE MAX_xzmsal ADD ID_tran INT, klic_polozky INT
			/*IF EXISTS (SELECT TOP 1 1 from tpv_polozka_ext (NOLOCK)
			 where lastamendid is not null AND lastamendid = user_id() AND  
			 lastamenddate between getdate()-0.00002 AND getdate()+0.00001)
				RETURN(0)
				
				--pøi založení položky se to také posílalo
			IF 	EXISTS (SELECT TOP 1 1 from tpv_polozka_ext (NOLOCK) where lastamendid is null)
				RETURN(0)
			*/
			DELETE MAX_xzmsal WHERE klic_polozky = @klic AND ID_tran is null -- pøi export do MAXu si jej zapíšu dle akt. pøenosu, a takto si defakto uchovám historii
			
			INSERT INTO MAX_xzmsal (xzmsa_prefitem, xzmsa_lineno, xzmsa_restrict,
			 xzmsa_rescode, xzmsa_exchange,xzmsa_aremarks,xzmsa_lud,xzmsa_lui, xzmsa_altitem,klic_polozky)
			 
		SELECT ZZ.alter_nazev, 
		CASE WHEN Z.klic_polozky is null THEN 0 ELSE ROW_NUMBER() over (order by P.alter_nazev) *10 END priorita,
		isnull(V.alter_nazev,''),
		CASE WHEN Z.klic_polozky_vyssi IS null THEN 'N' ELSE 'P' END as rescode, --N - ekvivalent, P - nadøazená položka, W – výrobní pøíkaz.
		ROUND(isnull(koef_mnoz,1),2),isnull(pozn_polozka_zam,''),GETDATE()--Convert(DATE,isnull(Z.adddatetime,''))
		,'gracias',
		isnull(P.alter_nazev,'') --,RTRIM(LTRIM(Z.alter_nazev)) + '/' + CONVERT(Varchar(10),priorita)
		,ZZ.klic_polozky
		FROM m1_polozka ZZ
		left outer JOIN tpv_polozka_zamena Z ON ZZ.klic_polozky = Z.klic_polozky
		LEFT JOIN m1_polozka P ON (P.klic_polozky = Z.klic_polozky_zam)
		LEFT OUTER JOIN m1_polozka V ON (V.klic_polozky = Z.klic_polozky_vyssi)
		LEFT OUTER JOIN tpv_projekt R (NOLOCK) ON (R.klic_projektu = Z.klic_projektu)
		LEFT OUTER JOIN users U ON (Z.adduser = U.uid and
						 U.platnost_od <= Z.adddatetime and U.platnost_do > Z.adddatetime)
		where ZZ.klic_polozky  =  @klic

		END  --IF @objekt = 'POLOZKA' AND @event = 'post_update_all'
		
	

END --procedura
go
GRANT EXEC ON dbo.up_TPVg_event_polozka TO PUBLIC
go