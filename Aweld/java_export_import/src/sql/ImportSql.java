package sql;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.tpv.tc4tpv.CSVRead;

public class ImportSql {

	public static String Import2TPV_hlav(Connection conn, String string) {
		
	
		System.out.println("Test");
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO tpv_c2t_import_hlav (nazev, soubor, klic_cfg, stav,changenum)" +
				"VALUES ('TC2TPV','neco',2,'N','01')");
		//stringBuilder.append(table);
		String sql;
		sql = stringBuilder.toString();
		
	
		Statement statement;
		try {
			statement = conn.createStatement();
	
			int rs =statement.executeUpdate(sql);
		System.out.println(rs);
		//System.out.println(rs);
	String key = null;
		/*if ( rs.next() ) {
		    // Retrieve the auto generated key(s).
		     key = rs.getString("klic_imp_hlav");
		}*/
		return key=GetIdentity(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
private static String GetIdentity(Connection conn) throws SQLException {
		String key=null;
		
		
		PreparedStatement ps = conn.prepareStatement("SELECT @@IDENTITY");
    	//ps.setString(1, "F");
    	//ResultSet rs = ps.executeQuery();
    	ResultSet rs= ps.executeQuery();
    	
    	while (rs.next()) {
    		//System.out.println(rs.getString(2));
    		int klic=rs.getInt(1);
    
		
    		System.out.println("klic_imp_hlav="+klic);
    		key=String.valueOf(klic);
    		
    	}

		return key;
	}


	
	public static void Import2TPV(Connection conn,String table, String Value) throws SQLException {
		
		
		System.out.println("Test");
	/*	StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("INSERT INTO ");
		stringBuilder.append(table);*/
		String sql="INSERT INTO "+table+" (klic_imp_hlav,alter_nazev_v, alter_nazev,changenum,stav)"+
		Value;
		//sql = stringBuilder.toString();
		
		Statement statement = conn.createStatement();
		int rs =statement.executeUpdate(sql);
		System.out.println(rs);
	}
	
}
