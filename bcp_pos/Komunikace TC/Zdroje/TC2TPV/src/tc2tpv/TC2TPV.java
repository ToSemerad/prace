/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Třída, která provádí kontrolu a spouští import
 * 
 * @author TPV
 */
public class TC2TPV {
    /**
     * Spustí kontrolu
     * 
     * @param klicImportu       klíč hlavičky importu (získá se z mětody na TPVItem po vložení do importních tabulek)
     * @return                  prázdný řetězec pokud je kontrola OK, jinak výpis chyb
     * @throws SQLException     při selhání nějáké SQL úlohy
     */
    public static String provedKontrolu(int klicImportu) throws SQLException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("exec up_bb_import_c2t 'K', 'N', 1, ?");
        ps.setInt(1, klicImportu);
        ResultSet rs = ps.executeQuery();
        String text = "";
        if (rs.next()) {
            if (rs.getString(6).equals("E")) {
                text += rs.getInt(4) + ". " + rs.getString(5) + "\n";
            }
        }
        return text;
    }
    
    /**
     * Pokud je kontrola OK, lze spustit import
     * 
     * @param klicImportu       klíč hlavičky importu (získá se z mětody na TPVItem po vložení do importních tabulek)
     * @throws SQLException     při selhání nějáké SQL úlohy
     */
    public static void provedImport(int klicImportu) throws SQLException {
        Connection conn = TPVSQL.getConnection();
        PreparedStatement ps = conn.prepareStatement("exec up_bb_import_c2t 'I', 'N', 1, ?");
        ps.setInt(1, klicImportu);
        ResultSet rs = ps.executeQuery();
    }
    
}
