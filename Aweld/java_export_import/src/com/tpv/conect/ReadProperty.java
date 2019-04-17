package com.tpv.conect;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import sql.ImportSql;
public class ReadProperty {
	public static int num_attr=0;
	public static String[] attr=new String [50];
	
	private static String readFile(String file) throws IOException {
	    BufferedReader reader = new BufferedReader(new FileReader (file));
	    String         line = null;
	    StringBuilder  stringBuilder = new StringBuilder();
	   // String         ls = System.getProperty("line.separator");

	    try {
	        while((line = reader.readLine()) != null) {
	            stringBuilder.append(line);
	           // stringBuilder.append(ls);
	        }

	        return stringBuilder.toString();
	    } finally {
	        reader.close();
	    }
	}

	public static String GetProperty(String arg) throws SQLException {
		 String csvFile = arg;
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	      //  String[] attr=new String [50];
	        String value=null;
	       
	     

	        try {

	            br = new BufferedReader(new FileReader(csvFile));
	            while ((line = br.readLine()) != null) {

	                // use comma as separator
	                 attr = line.split(cvsSplitBy);
	                 num_attr=attr.length;	
	                 value=("VALUES  "+0+", '"+attr[0]);
	              for (int i=1;i<attr.length;i++)
	              { 
	                value=(value+" VALUES  "+i+", '"+attr[i]);
	               
	              }
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
	public static String LastDateMod(String now, String basePath) throws IOException
	{
		//String path= basePath+"\\LastImport.txt";
		boolean check = new File(basePath,"LastImport.txt").exists();
		File FwJm=new File("LastImport.txt");
		String Get_time_import = "";
		//Get_time_import =readFile("LastImport.txt");
		//System.out.println(Get_time_import);
		
		if(check)
		{
			Get_time_import =readFile("LastImport.txt");
			System.out.println(Get_time_import);
			if(Get_time_import.length()!=10)
				Get_time_import="1990-01-01";
		}
		else
		{
			Get_time_import="1990-01-01";
			
		}
		//now=now+";";
		FileWriter fw=new FileWriter(FwJm);
		fw.write(now);
		fw.close();
			
		return Get_time_import;
	}

}
