package com.tpv.tc4tpv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.FileInputStream;

import sqlImport.ImportSql;
import com.tpv.connect.LogFile;;

public class CSVRead {

	public static String ReadCSV(String table, String arg, Connection conn, boolean GetArtikl) throws SQLException {
		String csvFile;
		if(GetArtikl)
			csvFile = "C:\\SPLM\\Apps\\Export\\Artikl_csv\\" + arg;
		else
			csvFile = "C:\\SPLM\\Apps\\Export\\csv\\" + arg;
						//C:\SPLM\Apps\Export\Artikl_csv
		BufferedReader br = null;
		String line = "";
		boolean header = true;
		String cvsSplitBy = "#";
		String[] attr = new String[50];
		String value = null;
		String table_txt = table + " (";

		// String klic_imp_hlav=ImportSql.Import2TPV_hlav(conn, value);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		String TC_TS=formatter.format(date).toString();

		try {

			br = new BufferedReader( new InputStreamReader(new FileInputStream(csvFile),"UTF8"));
			int radku=0;
			while ((line = br.readLine()) != null) {
				attr = line.split(cvsSplitBy);
				System.out.println(""+attr.length);
				
				if (header) {
					
					for (int i = 0; i < attr.length-1; i++)// -2 protože poslední znak TYP do exportu nechci
						table_txt += (attr[i] + ", ");
					if (GetArtikl)
						table_txt +=(attr[attr.length-1] + ", DIALOG_STATUS, TC_STATUS, TC_TS)");
					else
						table_txt += (attr[attr.length-1] + ")");// -2 protože poslední znak TYP do exportu nechci
					System.out.println(table_txt);
					header = false;
				} else {
					// use comma as separator
					radku++;
					value = (" VALUES ( ");
					
					for (int i = 0; i < attr.length-1; i++)// -2 protože poslední znak TYP do exportu nechci
						{
						if (attr[i].equals(" "))
							value +="null,";
						else if(GetArtikl)
						{
							if(i==3) value += (attr[i]+",");
							else value += ("'"+attr[i] + "',");
							}
						else
							{
							if(	i==0 ||
								//i==1 ||
								i==5 || 
								i==14 ||
								i==15 ||
								i==16 ||
								i==17 ||
								i==20||
								i==21||
								i==22||
								i==23) value += (attr[i]+",");
							else value += ("'"+attr[i] + "',");
							}
						
						}
						//value += (attr[i]+", ");
					if (GetArtikl)
						value += ("0,0,"+"'"+TC_TS+"'"+")");
					else
						value += ("'"+attr[attr.length-1] + "'"+")");// -2 protože poslední znak TYP do exportu nechci
					System.out.println(value);
					//ImportSql.SetIdentity_Insert(conn,table, true);
					ImportSql.Import2TPV(conn, table_txt, value);
					//ImportSql.SetIdentity_Insert(conn,table, false);
				}
			}
			System.out.println(table_txt);
			if (!GetArtikl)
				ImportSql.Import2TPV(conn, "D3000S.TC_D3000S (POZICE, IDV, ID,  NAZEV, REVIZE, MNOZSTVI)", " VALUES (0, 'END', 'END', 'KONEC_IMPORTU', 'END',1)");
		
				
			String mess="pocet naimportovanych radku je "+radku;
					
			LogFile.expoertlog("Import Tc do Dialog3000 probehl uspesne \n",mess );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			LogFile.expoertlog("Import Tc do Dialog3000 nebyl uspesny: \n",e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			LogFile.expoertlog("Import Tc do Dialog3000 nebyl uspesny: \n",e.getMessage());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					LogFile.expoertlog("Import Tc do Dialog3000 nebyl uspesny: \n",e.getMessage());
				}
			}
		}
		return value;
	}
	public static String ReadCSV4Artikl(String table, String arg, Connection conn) throws SQLException {
		return "null";
	}

}
