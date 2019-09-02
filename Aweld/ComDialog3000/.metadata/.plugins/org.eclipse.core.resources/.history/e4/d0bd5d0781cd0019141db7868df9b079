import java.io.*;
import java.sql.*;
import java.util.Arrays;

import com.tpv.connect.ReadProperty;
import com.tpv.tc4tpv.CSVRead;
import com.tpv.tc4tpv.CSVUtils;

import sqlImport.ImportSql;

import java.text.SimpleDateFormat;

public class Connect {
	static String basePath = "C:\\SPLM\\Apps\\Import";

	public static void main(String args[]) throws IOException, SQLException {
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
							+ "D3000S.TPVView_NakupovanePolozky.VARIANTA = D3000S.TPVView_NakupPolDodavatele.VARIANTA");
					int poradi = 0;
					while (rs.next()) {
						poradi++;
						String pole = "" + poradi + ";";
						pole = GetSQLAttr(rs, pocetSloupcu);
						pole = pole + rs.getString("JMENO_DODAVATELE");

						System.out.println(pole);
						Send2CSV(pole, timeStamp, "\\Nakup\\csv\\");
					}

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
				}
			} else if (args[0].equals("-import")) {

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
		if (!CSVUtils.Kontrola_exportu(pole))// kontrola zdali již bylo importováno true - stejný øetìzec již bylo
											// importováno
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

				// nebo importováno vùbec nebo se nìco zmìnilo
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

			for (int i = 5; i < pocetSloupcu; i++)// - 6 protože prvních 5 atributù je pro
			// pøipojení // databázi
			{
				String temp;

				temp = rs.getString(ReadProperty.attr[i]);

				if (temp == null)
					pole = pole + " ;";
				else {
					if (temp.length() > 0)
						pole = pole + temp + ";";
					else
						pole = pole + ";";
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pole;

	}

	private static void CallImportD3000(Connection conn, String table, String filecsv) throws SQLException {
		CSVRead.ReadCSV(table, filecsv, conn);

	}

}
