package com.tpv.conect;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.tpv.conect.ReadProperty;
import com.tpv.conect.LogFile;
import com.tpv.tc4tpv.CSVUtils;
import com.tpv.tc4tpv.CSVRead;
import sql.ImportSql;
import java.io.*;
import java.util.Arrays;

public class DbConn {
	static String basePath = new File("").getAbsolutePath();
	//  private static String String test_v;

	public static void main(String[] args) throws Exception
	     {
		    String path = new File("src/main/resources/conf.properties").getAbsolutePath();
		    System.out.println(path);
		  String pole=""; 
		  Connection con; 
	    	String timeStamp =new SimpleDateFormat("yyyy-MM-dd").format(new Timestamp(System.currentTimeMillis()));
		  //args[0]="tets";
	    	String timelast=ReadProperty.LastDateMod(timeStamp,basePath);
	    	timeStamp=new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Timestamp(System.currentTimeMillis()));
	    	timeStamp="import"+timeStamp;
		  ReadProperty.GetProperty("java_ReadProperty.csv");
	        try
	        {    
	        	Class.forName("net.sourceforge.jtds.jdbc.Driver");
	        	String connectionUrl = "jdbc:jtds:sqlserver://" +ReadProperty.attr[0] + "/" + ReadProperty.attr[1];
	        	DriverManager.setLoginTimeout(10);
	        	//System.out.println(connectionUrl+" "+ReadProperty.attr[2]+" "+ ReadProperty.attr[3]);
	        	
	        	Connection connection = DriverManager.getConnection(connectionUrl, ReadProperty.attr[2], ReadProperty.attr[3]);
	        	System.out.println("Connect");
	        	LogFile.makelog(timeStamp, "Connection Complete");
	        	
	      if (args.length==0 )
	        {
	    	  Import2TC(connection,pole,timeStamp,timelast);
	        	CallImportTC(pole,timeStamp) ;
	    	 
	        }
	        	
	        else
        	{
	        	 CallImportTPV(connection,"tpv_c2t_import",args[0],timelast);
        	}
	        

	         } 
	         catch (Exception e) 
	         {
	            System.err.println("Got an exception! ");
	            System.err.println(e.getMessage());
	            System.out.print(e);
	            
	          } finally {
	        	  
			}
	        	
	      //  CallImportTC(pole) ;
	        
	      }



	private static void CallImportTPV(Connection conn, String table,String filecsv,String timeLast) throws SQLException {
		CSVRead.ReadCSV(table,filecsv, conn);
		
	}



	private static void Import2TC(Connection conn,String pole,String timeStamp,String timeLast) throws SQLException, FileNotFoundException {
		//PreparedStatement ps = connection.prepareStatement("select * from tpvcode");
    	PreparedStatement ps = conn.prepareStatement("select * from "+ReadProperty.attr[4]+" WHERE lastamenddate>="+"'"+timeLast+"'");

    	//ps.setString(1, "F");
    	//ResultSet rs = ps.executeQuery();
    	System.out.println("select * from "+ReadProperty.attr[4]+" WHERE lastamenddate>"+"'"+timeLast+"'");
    	ResultSet rs= ps.executeQuery();
    	System.out.println(rs.getRow());
    	while (rs.next()) {
    		//System.out.println(rs.getString(2));
    		int klic=rs.getInt(ReadProperty.attr[5]);
    		pole=pole+klic+";";
    		for (int i=6;i<ReadProperty.num_attr;i++)
    		{
    			String temp =rs.getString(ReadProperty.attr[i]);
    			if(temp==null)
    				 pole=pole+" ;";
    			else{
    				if(temp.length()>0)
    					pole=pole+temp+";";
    				else pole=pole+" ;";
    			}
    		}

    		//pole=pole+System.lineSeparator();
    		Send2CSV(pole,timeStamp);
    		pole="";
    		
    		}
    	System.out.println(pole);
    
    	
    	
    	pole=pole+"/0";
        System.out.println("Connection Succesfull");
        LogFile.makelog(timeStamp, " CreteaCSV_File: Complete");
    	
		
	}

	
	

	
	private static void Send2CSV(String pole, String csv) throws FileNotFoundException  {
		
		String csvFile = basePath +"\\cvs\\"+csv+".csv";
		OutputStream os = new FileOutputStream(csvFile,true);
        PrintWriter writer;
		
			try {
				writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
			

        CSVUtils.writeLine(writer, Arrays.asList(pole));

        

        CreateCSV(csvFile);
        writer.flush();
        writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				CreateCSV(csvFile);
				
				  try {
					  writer = new PrintWriter(new OutputStreamWriter(os, "UTF-8"));
					//CSVUtils.writeLine(writer, Arrays.asList("T", "o", "m", "s"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		
	}

	private static void CreateCSV(String csvFile) {
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

	private static void CallImportTC(String pole,String name) throws IOException {
		
		
		try {
		    // Execute command
		    String command = "cmd /c start "+basePath+"\\ImportTC.bat ";
		    Process child =Runtime.
		   getRuntime().
		   exec(command+name);

		    // Get output stream to write from it
		    OutputStream out = child.getOutputStream();

		    out.write("cd C:/ /r/n".getBytes());
		    out.flush();
		    out.write("dir /r/n".getBytes());
		    out.close();
		   // child.destroy();
		} catch (IOException e) {
		}
	}

}
