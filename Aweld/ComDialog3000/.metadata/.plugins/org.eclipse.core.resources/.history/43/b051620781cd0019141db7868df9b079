package com.tpv.tc4tpv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.List;

public class CSVUtils {

    private static final char DEFAULT_SEPARATOR = ';';

    public static void writeLine(Writer w, List<String> values) throws IOException {
        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
    }

    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
        writeLine(w, values, separators, ' ');
    }

    //https://tools.ietf.org/html/rfc4180
    private static String followCVSformat(String value) {

        String result = value;
        if (result.contains("\"")) {
            result = result.replace("\"", "\"\"");
        }
        return result;

    }
	public static boolean Kontrola_exportu (String pole)  {
		BufferedReader br = null;
		String line=null;
		try {
		br = new BufferedReader( new InputStreamReader(new FileInputStream("C:\\SPLM\\Apps\\Import\\importovano.csv"),"UTF8"));

		while ((line = br.readLine()) != null) {
		if (line.equals(pole))
		{
			return true;
		}
			
			
		}
	} catch (FileNotFoundException e) {
		System.out.println("Soubor neexistuje zakladam novy");
		CreateCSV("C:\\SPLM\\Apps\\Import\\importovano.csv");
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
		
		return false;
	}

    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

        boolean first = true;

        //default customQuote is empty

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuilder sb = new StringBuilder();
        for (String value : values) {
            if (!first) {
                sb.append(separators);
            }
            if (customQuote == ' ') {
                sb.append(followCVSformat(value));
            } else {
                sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
            }

            first = false;
        }
        sb.append("\n");
        w.append(sb.toString());


    }
	public static void CreateCSV(String csvFile) {
		// Use relative path for Unix systems
		File f = new File(csvFile);

		f.getParentFile().mkdirs();
		try {
			f.createNewFile();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}