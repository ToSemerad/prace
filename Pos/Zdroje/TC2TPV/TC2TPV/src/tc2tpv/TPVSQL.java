/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tc2tpv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Ovladač připojení do MS SQL
 * 
 * @author TPV
 */
public class TPVSQL {
    
    private static Connection connection;
    
    /**
     * Připojení k databázi - nastaví connection object, který aplikace využívá
     * 
     * @param server                        Jméno (adresa) instance SQL serveru
     * @param database                      Jméno databáze
     * @param user                          Jméno uživatele
     * @param password                      Heslo
     * @throws ClassNotFoundException       Pokud není dosupný ovladač pro MS SQL Server
     * @throws SQLException                 Pokud nastane chyba při připojování
     */
    public TPVSQL (String server, String database, String user, String password) throws ClassNotFoundException, SQLException {
        Class.forName("net.sourceforge.jtds.jdbc.Driver");
        String connectionUrl = "jdbc:jtds:sqlserver://" + server + "/" + database;
        connection = DriverManager.getConnection(connectionUrl, user, password);
        connection.setAutoCommit(false);
    }
    
    /**
     * Vrací objekt, držící připojení k MS SQL Serveru
     * 
     * @return objekt s připojením
     */
    public static Connection getConnection() {
        return connection;
    }
        
}
