import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.tpv.connect.LogFile;
import com.tpv.connect.ReadProperty;
import com.tpv.tc4tpv.CSVRead;
import com.tpv.tc4tpv.CSVUtils;
import sqlImport.ImportSql;


import java.text.SimpleDateFormat;

public class Connect {
	static String basePath = "C:\\SPLM\\Apps\\Import";
	

	public static void main(String args[]) throws IOException, SQLException, InterruptedException {
		/*
		 * String host = "192.168.108.41"; String url = "jdbc:sybase:Tds:"+host+":5000";
		 * String username = "teamcenter"; String password ="TPVgroup01";
		 */
		// args[0] = "-zak";//nastaveni pro testovani
		Driver sybDriver = null;
		Connection conn;
		String timeStamp;
		String timelast;

		if (args[1].equals("-nakup") || args[1].equals("-zak")) {
			ReadProperty.GetProperty(basePath + "\\java_ReadProperty" + args[1] + ".csv");
		} else if (args[1].length() > 3)
			ReadProperty.GetProperty("C:\\SPLM\\Apps\\Export\\java_ReadProperty.csv");
		else {
			System.out.println("Unexpected arg  :" + args.toString());
			System.exit(1);
		}
		try {
			sybDriver = (Driver) Class.forName("com.sybase.jdbc4.jdbc.SybDriver").newInstance();
			System.out.println("Driver Loaded");
			String url = "jdbc:sybase:Tds:" + ReadProperty.attr[0];
			conn = DriverManager.getConnection(url, ReadProperty.attr[2], ReadProperty.attr[3]);
			int pocetSloupcu = ReadProperty.num_attr;
			Statement stmt = conn.createStatement();
			if (args[0].equals("-export")) {
				timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Timestamp(System.currentTimeMillis()));
				timeStamp = "import" + timeStamp;

				if (args[1].equals("-nakup")) {

					ResultSet rs = stmt.executeQuery("select * from " + ReadProperty.attr[4] 						
							+ " left join D3000S.TPVView_NakupPolDodavatele ON D3000S.TPVView_NakupovanePolozky.CISLO_ARTIKLU = D3000S.TPVView_NakupPolDodavatele.CISLO_ARTIKLU and "
							+ "D3000S.TPVView_NakupovanePolozky.VARIANTA = D3000S.TPVView_NakupPolDodavatele.VARIANTA"
							+ " where D3000S.TPVView_NakupovanePolozky.NO_SKLADU != 'MA09' and D3000S.TPVView_NakupovanePolozky.NO_SKLADU != 'MA03' and D3000S.TPVView_NakupovanePolozky.NO_SKLADU != 'MA04'"
							);
					int poradi = 0;
					while (rs.next()) {
						poradi++;
						String pole = "" + poradi + "#";
						pole = GetSQLAttr(rs, pocetSloupcu);
						pole = pole + rs.getString("JMENO_DODAVATELE");

						System.out.println(pole);
				//if(pole.compareTo("0000001095#Sp�na� pr�tokov� SIKA VHS15M01171131, varianta 3, DN 15, G 1/2\" vnit�n�#ks#Sp�na� pr�tokov� SIKA VHS15M01171131, varianta 3, DN 15, G 1/2\" vnit�n�# # # # #0# # # # # # #MA01#OST# #JSP, s.r.o.")==0 )//| (pole.length()==202)
						Send2CSV(pole, timeStamp, "\\Nakup\\");
						
						
					}
					//Send2CSV("0000001095#Sp�na� pr�tokov� SIKA VHS15M01171131, varianta 3, DN 15, G 1/2\"\" vnit�n�#ks#Sp�na� pr�tokov� SIKA VHS15M01171131, varianta 3, DN 15, G 1/2\"\" vnit�n�# # # # #0# # # # # # #MA01#OST# #JSP, s.r.o.", timeStamp, "\\Nakup\\");
					CallImportTC( timeStamp);
				} else if (args[1].equals("-zak")) {
					ResultSet rs = stmt.executeQuery("select * from " + ReadProperty.attr[4]);
					int poradi = 0;
					while (rs.next()) {
						poradi++;
						String pole = "" + poradi + ";";
						pole = GetSQLAttr(rs, pocetSloupcu);

						System.out.println(pole);
						Send2CSV(pole, timeStamp, "\\Zak\\csv\\");
						
					}
					//CallImportTC( timeStamp);
				}
			} else if (args[0].equals("-import")) {
				if (args[1].equals("-artikl")) {
					CallGetArtikl(conn, "D3000S.TC_WF_ARTIKLY", args[2]);
				}else
					CallImportD3000(conn, "D3000S.TC_D3000S", args[1]);
				
				
			} else {
				System.out.println("Unexpected arg  :" + args.toString());
				System.exit(1);
			}

			// rs.close();

		} catch (

		InstantiationException ex) {
			System.out.println("Unexpected exception : " + ex.toString());
			System.exit(1);
		} catch (IllegalAccessException ex) {
			System.out.println("Unexpected exception : " + ex.toString());
			System.exit(1);
		} catch (ClassNotFoundException ex) {
			System.out.println("Unexpected exception : " + ex.toString());
			System.exit(1);
		} catch (SQLException ex) {
			System.out.println("Unexpected exception : " + ex.toString() + ", sqlstate = " + ex.getSQLState());
			System.exit(1);
		}

	}

	private static void Send2CSV(String pole, String csv, String location) throws FileNotFoundException {

		String csvFile = basePath + location + csv + ".csv";
		String kontrola_file=basePath+"\\importovano.csv";
		OutputStream os = new FileOutputStream(csvFile, true);
		PrintWriter writer;
		if (CSVUtils.Kontrola_exportu(pole)==false)// kontrola zdali ji� bylo importov�no true - stejn� �et�zec ji� bylo
											// neimportov�no
		{

			OutputStream kontrola = new FileOutputStream(kontrola_file, true);
			//PrintWriter w_kontrolu;
			try {
				writer = new PrintWriter(new OutputStreamWriter(kontrola, "UTF-8"));
				CSVUtils.writeLine(writer, Arrays.asList(pole));
				
				writer.flush();
				writer.close();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));

				CSVUtils.writeLine(writer, Arrays.asList(pole));

				CSVUtils.CreateCSV(csvFile);
				writer.flush();
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				CSVUtils.CreateCSV(csvFile);

				try {
					writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
					// CSVUtils.writeLine(writer, Arrays.asList("T", "o", "m", "s"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

	}

	private static String GetSQLAttr(final ResultSet rs, int pocetSloupcu) {
		String pole = "";
		try {

			for (int i = 5; i < pocetSloupcu; i++)// - 6 proto�e prvn�ch 5 atribut� je pro
			// p�ipojen� // datab�zi
			{
				String temp;

				temp = rs.getString(ReadProperty.attr[i]);

				if (temp == null)
					pole = pole + " #";
				else {
					if (temp.length() > 0)
						pole = pole + temp + "#";
					else
						pole = pole + "#";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pole;

	}

	private static void CallImportD3000(Connection conn, String table, String filecsv) throws SQLException {
		CSVRead.ReadCSV(table, filecsv, conn,false);

	}
	private static void CallImportTC( String name)
		    throws IOException
		  {
		    try
		    {
		      Process child = 
		    		  Runtime.getRuntime()
		    		  .exec("cmd /c start \"\"call C:\\SPLM\\Apps\\Import\\Nakup\\ImportTC.bat ");
		      
		      OutputStream out = child.getOutputStream();
		      out.write("cd C:/ /r/n".getBytes());
		      out.flush();
		      out.write("dir /r/n".getBytes());
		      out.close();
		    }
		    catch (IOException localIOException) {}
		  }
	
	private static void CallGetArtikl(Connection conn, String table, String filecsv) throws SQLException, InterruptedException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		//String TC_TS=formatter.format(date).toString();
		System.out.println(formatter.format(date));
		CSVRead.ReadCSV(table, filecsv, conn,true);
		TimeUnit.SECONDS.sleep(40);
		date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select PORADI,ID,REVIZE,C_ARTIKLU from " +table+" WHERE TC_STATUS=0");
		
		String ID="";
		String Rev="";
		String C_artiklu="";
		int n_update=0;

		List<String> row = new ArrayList<>();
		
		while (rs.next()) {
			n_update++;
			String pole = "" + n_update + "#";
			//pole = GetSQLAttr(rs, pocetSloupcu);
			pole = pole +" - "+ rs.getString("ID")+"; "+rs.getString("REVIZE")+"; "+rs.getString("C_ARTIKLU");

			System.out.println(pole);
			
			ID=ID+rs.getString("ID")+"_";
			Rev=Rev+rs.getString("REVIZE")+"_";
			C_artiklu=C_artiklu+rs.getString("C_ARTIKLU")+"_";
			row.add(rs.getString("PORADI"));
			
		}
		if(UpdateC_Artiklu_TC(ID, Rev,C_artiklu,n_update ))
		{
			while (n_update>0) {
				
				ImportSql.UpdateC_Artiklu(conn, table, "1",row.remove(n_update-1));
				
				n_update--;
			}
			
		}else
			{
			LogFile.makelog("Import Dialog", "Chyba update cisel");
			LogFile.expoertlog("Import Tc do Dialog3000 nebyl uspesny: \n","Nepodarilo se updatetova cisla artiklu do TC");
			}	
	}
	
	static boolean UpdateC_Artiklu_TC(String ID, String Rev, String C_Artiklu, int n)
	{
		try {
			Process run = Runtime.getRuntime()
  		  .exec("cmd /c start \"\"call C:\\SPLM\\Apps\\Import\\C_Artiklu\\Set_c_artiklu.bat "+ID+" "+Rev+" "+C_Artiklu+" "+n);
			OutputStream out = run.getOutputStream();
		      /*out.write("cd C:/ /r/n".getBytes());
		      out.flush();
		      out.write("dir /r/n".getBytes());
		      
		     // out.close();*/
		      return true;
			
		} catch (IOException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return false;
		} 
	}

}