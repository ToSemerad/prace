/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Položka
 *
 * @author TPV
 */
public class TPVItem {

    public final static int TYPE_ASSEMBLY = 1; // Sestava
    public final static int TYPE_SEMI = 2;     // Polotovar
    public final static int TYPE_NORM = 3;     // Normalie (nakupovaná položka)
    public final static int TYPE_FINAL = 4;     // Finál


    private final int itemType;
    private final String itemId;
    private final String itemName;
    private final HashMap<String, Object> parameters;
    private final List<TPVBOMLine> bomLines;
    private final String itemRevision;
    private final List<File> files;
    
    private final String a1;
    private final String a2;
    private final String a3;
    private final boolean fourName;

    private boolean hasMaterial;
    private String materialID;
    private String materialA1;
    private String materialA2;
    private String materialA3;
    private String materialName;
    private String changenum;
    private int materialKey;
    private float materialQuantity;

    private static int linno;

    /**
     * Konstruktor položky - Revize jako řetězec
     *
     * @param itemType Typ položky (konstanta z této třídy) - Sestava,
     * polotovar, nákup
     * @param itemId ID položky - pro TPV jednoznačný idetifikační údaj (String)
     * @param itemName Název položky - povinný údaj
     * @param itemRevision Index výkresu - povinný údaj
     * @throws tc2tpv.InvalidParameterTypeException Pokud délka id nebo názvu
     * neodpovídá maximální délce v TPV
     */
    public TPVItem(int itemType, String itemId, String itemName, String itemRevision) throws InvalidParameterTypeException {
        this.itemType = itemType;
        if (itemId.length() > 30) {
            throw new InvalidParameterTypeException("ID položky", "Text (" + itemId.length() + ")", "Text (30)");
        }
        this.itemId = itemId;
        if (itemId.length() > 50) {
            throw new InvalidParameterTypeException("Název položky", "Text (" + itemId.length() + ")", "Text (50)");
        }
        this.itemName = itemName;
        this.hasMaterial = false;
        this.parameters = new HashMap<>();
        this.bomLines = new ArrayList<>();
        this.files = new ArrayList<>();
        this.itemRevision = itemRevision;
        this.a1 = null;
        this.a2 = null;
        this.a3 = null;
        this.fourName = false;
    }
    
    /**
     * Konstruktor položky - Revize jako řetězec
     *
     * @param itemType Typ položky (konstanta z této třídy) - Sestava,
     * polotovar, nákup
     * @param itemName Název položky - povinný údaj
     * @param itemRevision Index výkresu - povinný údaj
     * @param a1 Atribut názvu 1 (pro 4-názvové položky)
     * @param a2 Atribut názvu 2 (pro 4-názvové položky)
     * @param a3 Atribut názvu 3 (pro 4-názvové položky)
     * @throws tc2tpv.InvalidParameterTypeException Pokud délka id nebo názvu
     * neodpovídá maximální délce v TPV
     */
    public TPVItem(int itemType, String itemName, String itemRevision, String a1, String a2, String a3) throws InvalidParameterTypeException {
        this.itemType = itemType;
        if (itemName.length() > 50) {
            throw new InvalidParameterTypeException("Název položky", "Text (" + itemName.length() + ")", "Text (50)");
        }
        this.itemName = itemName;
        this.hasMaterial = false;
        this.parameters = new HashMap<>();
        this.bomLines = new ArrayList<>();
        this.files = new ArrayList<>();
        this.itemRevision = itemRevision;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.itemId = null;
        this.fourName = true;
    }
    
    /**
     * Konstruktor položky - Revize jako řetězec, polozka klicem
     *
     * @param itemType Typ položky (konstanta z této třídy) - Sestava,
     * polotovar, nákup
     * @param itemKey Klic polozky v TPV
     * @param fourName Jedna so o 4mistnou polozku (Nazev + 3 atributy)
     * @param itemRevision Index výkresu - povinný údaj
     * @throws tc2tpv.InvalidParameterTypeException Pokud délka id nebo názvu
     * neodpovídá maximální délce v TPV
     */
    public TPVItem(int itemType, int itemKey, String itemRevision, boolean fourName) throws InvalidParameterTypeException, SQLException, ItemNotFoundException {
        String sql = "SELECT alter_nazev, nazev_polozky, atr_nazvu_1, atr_nazvu_2, atr_nazvu_3 FROM vtp_polozka WHERE klic_polozky = ?";
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, itemKey);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()) {
            this.itemId = rs.getString(1);
            this.itemName = rs.getString(2);
            this.a1 = rs.getString(3);
            this.a2 = rs.getString(4);
            this.a3 = rs.getString(5);
        } else {
            throw new ItemNotFoundException(String.valueOf(itemKey));
        }        
        this.itemType = itemType;
        this.hasMaterial = false;
        this.parameters = new HashMap<>();
        this.bomLines = new ArrayList<>();
        this.files = new ArrayList<>();
        this.itemRevision = itemRevision;
        this.fourName = fourName;
    }

    /**
     * Umožňuje nastavit hutní materiál na základě ID materiálu
     *
     * @param id Jednoznačné ID materiálu
     * @param quantity Množství
     * @throws SQLException Pokud selže nějaká SQL úloha
     * @throws MaterialNotFoundException Pokud není ID materiálu nalezeno
     */
    public void setMaterial(String id, float quantity) throws SQLException, MaterialNotFoundException {
        this.materialID = id;
        this.materialQuantity = quantity;
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT klic_polozky, nazev_polozky, atr_nazvu_1, atr_nazvu_2, atr_nazvu_3 FROM vtp_polozka WHERE alter_nazev = ?");
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.materialKey = rs.getInt(1);
            this.materialName = rs.getString(2);
            this.materialA1 = rs.getString(3);
            this.materialA2 = rs.getString(4);
            this.materialA3 = rs.getString(5);
            this.hasMaterial = true;
        } else {
            throw new MaterialNotFoundException(id);
        }
        rs.close();
        ps.close();
    }

    /**
     * Umožňuje nastavit hutní materiál na základě číselného klíče
     *
     * @param key Primární klíč (identita) z tabulky položek
     * @param quantity Množství
     * @throws SQLException Pokud selže nějaká SQL úloha
     * @throws MaterialNotFoundException Pokud není ID materiálu nalezeno
     */
    public void setMaterial(int key, float quantity) throws SQLException, MaterialNotFoundException {
        this.materialKey = key;
        this.materialQuantity = quantity;
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT alter_nazev, nazev_polozky, atr_nazvu_1, atr_nazvu_2, atr_nazvu_3 FROM vtp_polozka WHERE klic_polozky = ?");
        ps.setInt(1, key);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.materialID = rs.getString(1);
            this.materialName = rs.getString(2);
            this.materialA1 = rs.getString(3);
            this.materialA2 = rs.getString(4);
            this.materialA3 = rs.getString(5);
            this.hasMaterial = true;
        } else {
            throw new MaterialNotFoundException(key);
        }
        rs.close();
        ps.close();
    }

    /**
     * Umožňuje nastavit materiál na základě čtyřmístného názvu položky
     *
     * @param name Název položky
     * @param a1 Atribut 1
     * @param a2 Atribut 2
     * @param a3 Atribut 3
     * @param quantity Množství
     * @throws SQLException Pokud selže nějaká SQL úloha
     * @throws MaterialNotFoundException Pokud není ID materiálu nalezeno
     */
    public void setMaterial(String name, String a1, String a2, String a3, float quantity) throws SQLException, MaterialNotFoundException {
        this.materialName = name;
        this.materialA1 = a1;
        this.materialA2 = a2;
        this.materialA3 = a3;
        this.materialQuantity = quantity;
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT klic_polozky, alter_nazev FROM vtp_polozka WHERE nazev_polozky = ? AND atr_nazvu_1 = ? AND atr_nazvu_2 = ? AND atr_nazvu_3 = ?");
        ps.setString(1, name);
        ps.setString(2, a1);
        ps.setString(3, a2);
        ps.setString(4, a3);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            this.materialKey = rs.getInt(1);
            this.materialID = rs.getString(2);
            this.hasMaterial = true;
        } else {
            throw new MaterialNotFoundException(name, a1, a2, a3);
        }
        rs.close();
        ps.close();
    }

    /**
     * Nastaví libovolný parameztr dle názvu parametru v TC Parametr musí být
     * definován a přiřazek k poli TPV v tabulce tpvg_tc2tpv_config
     *
     * @param TCName Jméno parametru v TC
     * @param value Hodnota parametru (String)
     * @throws SQLException Pokud něco skončí SQL chybou
     * @throws InvalidParameterException Pokud jméno parametru není nalezeno v
     * konfiguraci
     * @throws InvalidParameterTypeException Pokud neodpovídá datový typ
     * parametru s typem sloupce v TPV
     */
    public void setParameter(String TCName, String value) throws SQLException, InvalidParameterException, InvalidParameterTypeException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT nazev_pole_tpv, typ, velikost FROM tpvg_tc2tpv_config WHERE nazev_pole_tc = ?");
        ps.setString(1, TCName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String nameTPV = rs.getString(1);
            String typTPV = rs.getString(2);
            int velikost = rs.getInt(3);
            if (!typTPV.equals("S")) {
                String typTPVStr;
                if (typTPV.equals("F")) {
                    typTPVStr = "Desetinné číslo";
                } else {
                    typTPVStr = "Celé číslo";
                }
                throw new InvalidParameterTypeException(TCName, "VARCHAR(" + velikost + ")", typTPVStr);
            }
            if (value.length() > velikost) {
                throw new InvalidParameterTypeException(TCName, "VARCHAR(" + value.length() + ")", "VARCHAR(" + velikost + ")");
            }
            this.parameters.put(nameTPV, value);
        } else {
            throw new InvalidParameterException(TCName);
        }
    }

    /**
     * Nastaví libovolný parameztr dle názvu parametru v TC Parametr musí být
     * definován a přiřazek k poli TPV v tabulce tpvg_tc2tpv_config
     *
     * @param TCName Jméno parametru v TC
     * @param value Hodnota parametru (Celé číslo)
     * @throws SQLException Pokud něco skončí SQL chybou
     * @throws InvalidParameterException Pokud jméno parametru není nalezeno v
     * konfiguraci
     */
    public void setParameter(String TCName, int value) throws SQLException, InvalidParameterException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT nazev_pole_tpv, typ, velikost FROM tpvg_tc2tpv_config WHERE nazev_pole_tc = ?");
        ps.setString(1, TCName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String nameTPV = rs.getString(1);
            this.parameters.put(nameTPV, value);
        } else {
            throw new InvalidParameterException(TCName);
        }
    }

    /**
     * Nastaví libovolný parameztr dle názvu parametru v TC Parametr musí být
     * definován a přiřazek k poli TPV v tabulce tpvg_tc2tpv_config
     *
     * @param TCName Jméno parametru v TC
     * @param value Hodnota parametru (Desetinné číslo)
     * @throws SQLException Pokud něco skončí SQL chybou
     * @throws InvalidParameterException Pokud jméno parametru není nalezeno v
     * konfiguraci
     * @throws InvalidParameterTypeException Pokud neodpovídá datový typ
     * parametru s typem sloupce v TPV
     */
    public void setParameter(String TCName, float value) throws SQLException, InvalidParameterException, InvalidParameterTypeException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT nazev_pole_tpv, typ, velikost FROM tpvg_tc2tpv_config WHERE nazev_pole_tc = ?");
        ps.setString(1, TCName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String nameTPV = rs.getString(1);
            String typTPV = rs.getString(2);
            this.parameters.put(nameTPV, value);
            if (typTPV.equals("I")) {
                throw new InvalidParameterTypeException(TCName, "desetinné číslo", "celé číslo");
            }
        } else {
            throw new InvalidParameterException(TCName);
        }
    }

    /**
     * Nastaví libovolný parameztr dle názvu parametru v TC - datový typ bude
     * určen dle nastavení Parametr musí být definován a přiřazek k poli TPV v
     * tabulce tpvg_tc2tpv_config
     *
     * @param TCName Jméno parametru v TC
     * @param value Hodnota parametru (Obecná)
     * @throws SQLException Pokud něco skončí SQL chybou
     * @throws InvalidParameterException Pokud jméno parametru není nalezeno v
     * konfiguraci
     * @throws InvalidParameterTypeException Pokud neodpovídá datový typ
     * parametru s typem sloupce v TPV
     */
    public void setParameter(String TCName, Object value) throws SQLException, InvalidParameterException, InvalidParameterTypeException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT nazev_pole_tpv, typ, velikost FROM tpvg_tc2tpv_config WHERE nazev_pole_tc = ?");
        ps.setString(1, TCName);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            String nameTPV = rs.getString(1);
            String typTPV = rs.getString(2);
            if (typTPV.equals("S")) {
                this.parameters.put(nameTPV, String.valueOf(value));
            }
            if (typTPV.equals("I")) {
                try {
                    this.parameters.put(nameTPV, Integer.valueOf(value.toString().replace(",", ".")));
                } catch (NumberFormatException ex) {
                    throw new InvalidParameterTypeException(TCName, "Obecný objekt", "Celé číslo");
                }
            }
            if (typTPV.equals("F")) {
                try {
                    this.parameters.put(nameTPV, Float.valueOf(value.toString().replace(",", ".")));
                } catch (NumberFormatException ex) {
                    throw new InvalidParameterTypeException(TCName, "Obecný objekt", "Desetinné číslo");
                }
            }
        } else {
            throw new InvalidParameterException(TCName);
        }
    }

    public void setChangenum(String changenum) {
        this.changenum = changenum;
    }

    /**
     * Vloží řádek kusovníku
     *
     * @param item Nižší položka
     * @param quantity Množství v kusovníku
     */
    public void addBomLine(TPVItem item, float quantity) {
        TPVBOMLine bl = new TPVBOMLine(item, quantity);
        bl.setPosition((this.bomLines.size() + 1) * 10);
        this.bomLines.add(bl);
    }

    /**
     * Vloží řádek kusovníku
     *
     * @param item Nižší položka
     * @param quantity Množství v kusovníku
     * @param position Pozice v kusovníku
     */
    public void addBomLine(TPVItem item, float quantity, int position) {
        TPVBOMLine bl = new TPVBOMLine(item, quantity, position);
        this.bomLines.add(bl);
    }

    /**
     * Vytiskne strom (rozpad) položky
     */
    public void printTree() {
        printRecursive(1);
    }

    /**
     * Rekurzivní funkce pro tist stromu - NEPOUŽÍVAT
     *
     * @param level
     */
    public void printRecursive(int level) {
        String act = "";
        for (int i = 0; i < level; i++) {
            act += "\t";
        }
        act += String.valueOf(level) + ": " + this.itemId + " / " + this.itemName;
        if (hasMaterial) {
            act += "\t Material: (" + materialID + " - " + materialName + ") - Mnozstvi: " + materialQuantity;
        }
        System.out.println(act);
        for (TPVBOMLine line : bomLines) {
            TPVItem lowerItem = line.getItem();
            lowerItem.printRecursive(level + 1);
        }
    }

    /**
     * Vloží položku s jejím rozpadem do importních tabulek TPV
     *
     * @return klíč hlavičky importu, pod kterým byly záznamy vloženy
     * @throws SQLException Pokud nastane nějáka SQL chyba
     * @throws tc2tpv.ConfigurationNotFoundException Pokud není nastavená
     * kofigurace na TC v databázi TPV
     */
    public int insertItemToTPV() throws SQLException, ConfigurationNotFoundException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement psKlicCfg = conn.prepareStatement("SELECT klic_cfg FROM tpv_c2t_cfg WHERE nazev = 'Team Center'");
        int klicCfg;
        ResultSet rsKlicCfg = psKlicCfg.executeQuery();
        if (rsKlicCfg.next()) {
            klicCfg = rsKlicCfg.getInt(1);
        } else {
            throw new ConfigurationNotFoundException();
        }

        rsKlicCfg.close();
        psKlicCfg.close();

        PreparedStatement ps = conn.prepareStatement("INSERT INTO tpv_c2t_import_hlav (nazev, klic_cfg, stav, soubor) SELECT ?, ?, ?, ?");
        ps.setString(1, itemId);
        ps.setInt(2, klicCfg);
        ps.setString(3, "N");
        ps.setString(4, "Import " + itemName + " z TeamCenter");
        ps.execute();
        ps.close();
        PreparedStatement psId = conn.prepareStatement("SELECT @@IDENTITY");
        ResultSet rs = psId.executeQuery();
        if (rs.next()) {
            int klicImportu = rs.getInt(1);
            TPVItem.linno = 0;
            insertItem(klicImportu, 0, "", 1, 1);
            return klicImportu;
        }
        return 0;
    }

    /**
     * Rekurzivní funkce pro vkládání do struktury importu - NEPOUŽÍVAT !!
     *
     * @param importId
     * @param linno_v
     * @param id_v
     * @param level
     * @param mnozstvi
     * @throws SQLException
     */
    public void insertItem(int importId, int linno_v, String id_v, int level, float mnozstvi) throws SQLException {
        TPVItem.linno++;
        String qIns = "INSERT INTO tpv_c2t_import (klic_imp_hlav, stav, linno, linno_v, uroven, alter_nazev_v, mnozstvi, alter_nazev, nazev_polozky, postaveni, index_vykresu, ";
        if (changenum != null && !changenum.equals("")) {
            qIns = "INSERT INTO tpv_c2t_import (klic_imp_hlav, stav, linno, linno_v, uroven, alter_nazev_v, mnozstvi, alter_nazev, nazev_polozky, postaveni, index_vykresu, changenum, ";
        }
        for (String key : parameters.keySet()) {
            qIns += key + ", ";
        }
        if (changenum != null && !changenum.equals("")) {
            qIns = qIns.substring(0, qIns.length() - 2) + ") SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ";
        } else {
            qIns = qIns.substring(0, qIns.length() - 2) + ") SELECT ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ";
        }
        for (String key : parameters.keySet()) {
            qIns += "?, ";
        }
        qIns = qIns.substring(0, qIns.length() - 2);
        //System.out.println(qIns);
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement(qIns);
        ps.setInt(1, importId);
        ps.setString(2, "N");
        ps.setInt(3, TPVItem.linno);
        ps.setInt(4, linno_v);
        ps.setInt(5, level);
        ps.setString(6, id_v);
        ps.setFloat(7, mnozstvi);
        ps.setString(8, this.itemId);
        ps.setString(9, this.itemName);
        switch (itemType) {
            case TYPE_ASSEMBLY:
                ps.setString(10, "S");
                break;
            case TYPE_NORM:
                ps.setString(10, "N");
                break;
            case TYPE_SEMI:
                ps.setString(10, "D");
                break;
            case TYPE_FINAL:
                ps.setString(10, "F");
                break;
        }
        ps.setString(11, this.itemRevision);
        int i = 12;
        for (String key : parameters.keySet()) {
            Object value = parameters.get(key);
            // Na zaklade typu zadat do dotazu
            if (value instanceof String) {
                ps.setString(i, value.toString());
                i++;
            }
            if (value instanceof Float) {
                ps.setFloat(i, Float.valueOf(value.toString()));
                i++;
            }
            if (value instanceof Integer) {
                ps.setInt(i, Integer.valueOf(value.toString()));
                i++;
            }
        }
        ps.execute();

        PreparedStatement psKlic = conn.prepareStatement("SELECT @@IDENTITY");
        ResultSet rs = psKlic.executeQuery();
        rs.next();
        int klicImportu = rs.getInt(1);
        if (hasMaterial) {
            PreparedStatement psMat = conn.prepareStatement("UPDATE tpv_c2t_import SET klic_materialu = ?, id_materialu = ? WHERE klic_imp_hlav = ? AND linno = ?");
            psMat.setInt(1, materialKey);
            psMat.setString(2, materialID);
            psMat.setInt(3, importId);
            psMat.setInt(4, linno);
            psMat.execute();
        }
        if (!this.files.isEmpty()) {
            // Vlozeni cesty k priloham pro import
            int radek = 1;
            for (File f : files) {
                PreparedStatement psf = conn.prepareStatement("INSERT INTO tpv_c2t_import_dok (klic_importu, rad_importu, soubor, extenze, stav) SELECT ?, ?, ?, ?, ?");
                psf.setInt(1, klicImportu);
                psf.setInt(2, radek);
                psf.setString(3, f.getAbsolutePath());
                psf.setString(4, f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf(".") + 1, f.getAbsolutePath().length()));
                psf.setString(5, "N");
                psf.execute();
                radek++;
            }
        }
        int lnv = TPVItem.linno;
        for (TPVBOMLine line : bomLines) {
            TPVItem lowerItem = line.getItem();
            lowerItem.insertItem(importId, lnv, this.itemId, level + 1, line.getQuantity());
        }
    }

    /**
     * Přidá k položce přílohu
     *
     * @param url Cesta k souboru (musí být přístupná ze serveru, kde běží TPV)
     * @throws tc2tpv.DocumentURLOverflowException Pokud je absolutní cesta
     * delší než 255 znaků
     * @throws tc2tpv.DocumentExtensionNotFoundException Pokud je přípona
     * souboru nevyhovující
     */
    public void addFile(String url) throws DocumentURLOverflowException, DocumentExtensionNotFoundException, FileNotFoundException {
        File f = new File(url);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        if (f.getAbsolutePath().length() > 255) {
            throw new DocumentURLOverflowException(f.getAbsolutePath());
        }
        if (f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("."), f.getAbsolutePath().length()).length() > 5) {
            throw new DocumentExtensionNotFoundException(f.getAbsolutePath());
        }
        this.files.add(f);
    }
    
    /*
    public void addFile(String url, String uloziste) throws DocumentURLOverflowException, DocumentExtensionNotFoundException, FileNotFoundException {
        if (url.contains("\\")) {
            url = url.substring(url.lastIndexOf("\\"), url.length());
            url = url.replace("\\", "/");
            url = url.substring(url.lastIndexOf("/") + 1, url.length());
        }
        File f = new File(uloziste + "\\" + url);
        if (!f.exists()) {
            throw new FileNotFoundException();
        }
        if (f.getAbsolutePath().length() > 255) {
            throw new DocumentURLOverflowException(f.getAbsolutePath());
        }
        if (f.getAbsolutePath().substring(f.getAbsolutePath().lastIndexOf("."), f.getAbsolutePath().length()).length() > 5) {
            throw new DocumentExtensionNotFoundException(f.getAbsolutePath());
        }
        this.files.add(f);
    }
    */

    public String getItemId() {
        return itemId;
    }

}
