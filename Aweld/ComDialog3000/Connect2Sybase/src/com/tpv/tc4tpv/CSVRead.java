package com.tpv.tc4tpv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;

import sqlImport.ImportSql;

public class CSVRead {

	public static String ReadCSV(String table, String arg, Connection conn) throws SQLException {
		String csvFile = "C:\\SPLM\\Apps\\Export\\csv\\" + arg;
		BufferedReader br = null;
		String line = "";
		boolean header = true;
		String cvsSplitBy = "#";
		String[] attr = new String[50];
		String value = null;
		String table_txt = table + " (";

		// String klic_imp_hlav=ImportSql.Import2TPV_hlav(conn, value);

		try {

			br = new BufferedReader( new InputStreamReader(new FileInputStream(csvFile),"UTF8"));

			while ((line = br.readLine()) != null) {
				attr = line.split(cvsSplitBy);
				if (header) {

					for (int i = 0; i < attr.length - 2; i++)// -2 protože poslední znak TYP do exportu nechci
						table_txt += (attr[i] + ", ");
					table_txt += (attr[attr.length-2] + ")");// -2 protože poslední znak TYP do exportu nechci
					System.out.println(table_txt);
					header = false;
				} else {
					// use comma as separator

					value = (" VALUES ( ");
					for (int i = 0; i < attr.length - 2; i++)// -2 protože poslední znak TYP do exportu nechci
						if(	i==0 ||
							//i==1 ||
							i==5 || 
							i==14 ||
							i==15 ||
							i==16 ||
							i==17) value += (attr[i]+", ");
						else value += ("'"+attr[i] + "', ");
						//value += (attr[i]+", ");
					value += ("'"+attr[attr.length-2] + "'"+")");// -2 protože poslední znak TYP do exportu nechci
					System.out.println(value);
					//ImportSql.SetIdentity_Insert(conn,table, true);
					ImportSql.Import2TPV(conn, table_txt, value);
					//ImportSql.SetIdentity_Insert(conn,table, false);
				}
			}
			System.out.println(table_txt);
			ImportSql.Import2TPV(conn, "D3000S.TC_D3000S (POZICE, IDV, ID, NAZEV, REVIZE, MNOZSTVI)", " VALUES (0, 'END', 'END', 'KONEC_IMPORTU', 'END',1)");

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
