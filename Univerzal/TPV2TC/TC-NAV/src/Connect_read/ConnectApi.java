package Connect_read;

import java.util.Arrays;
import java.util.Date;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@SuppressWarnings("unused")
public class ConnectApi {



	/*public String getWeather(String city) throws MalformedURLException,
	IOException {
	 
		//Code to make a webservice HTTP request
		String responseString = "";
		String outputString = "";
		String wsURL = "http://www.deeptraining.com/webservices/weather.asmx";
		URL url = new URL(wsURL);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection)connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		String xmlInput =
		" <soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://litwinconsulting.com/webservices/\">\n" +
		" <soapenv:Header/>\n" +
		" <soapenv:Body>\n" +
		" <web:GetWeather>\n" +
		" <!--Optional:-->\n" +
		" <web:City>" + city + "</web:City>\n" +
		" </web:GetWeather>\n" +
		" </soapenv:Body>\n" +
		" </soapenv:Envelope>";
		 
		byte[] buffer = new byte[xmlInput.length()];
		buffer = xmlInput.getBytes();
		bout.write(buffer);
		byte[] b = bout.toByteArray();
		String SOAPAction =
		"http://litwinconsulting.com/webservices/GetWeather";
		// Set the appropriate HTTP parameters.
		httpConn.setRequestProperty("Content-Length",
		String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		//Write the content of the request to the outputstream of the HTTP Connection.
		out.write(b);
		out.close();
		//Ready with sending the request.
		 
		//Read the response.
		InputStreamReader isr =
		new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		 
		//Write the SOAP message response to a String.
		while ((responseString = in.readLine()) != null) {
		outputString = outputString + responseString;
		}
		//Parse the String output to a org.w3c.dom.Document and be able to reach every node with the org.w3c.dom API.
		Document document = parseXmlFile(outputString);
		NodeList nodeLst = document.getElementsByTagName("GetWeatherResult");
		String weatherResult = nodeLst.item(0).getTextContent();
		System.out.println("Weather: " + weatherResult);
		 
		//Write the SOAP message formatted to the console.
		String formattedSOAPResponse = formatXML(outputString);
		System.out.println(formattedSOAPResponse);
		return weatherResult;
	}*/

}