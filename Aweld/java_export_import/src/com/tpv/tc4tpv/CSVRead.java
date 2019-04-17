package com.tpv.tc4tpv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import sql.ImportSql;

public class CSVRead {
	
	public static String ReadCSV(String table,String arg,Connection conn) throws SQLException {
		 String csvFile = "C:\\SPLM\\Apps\\Import\\csv\\"+arg;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	        String[] attr=new String [50];
	        String value=null;
	       
	       String klic_imp_hlav=ImportSql.Import2TPV_hlav(conn, value);

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                 attr = line.split(cvsSplitBy);

	              
	                value=("VALUES ("+klic_imp_hlav+", '"+attr[1]+"', '"+attr[2]+"', '"+attr[3]+"', 'N')");
	                System.out.println(value);
	                ImportSql.Import2TPV(conn, table, value);
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		return value;
	}

}
