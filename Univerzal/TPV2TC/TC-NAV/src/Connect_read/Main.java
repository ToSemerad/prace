package Connect_read;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.Base64;
import java.util.Scanner;
 
import cdata.jdbc.dynamicsnav.*;








import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

public class Main {
	
	 public static void main(String[] args) {
	
	/*	 CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
		 HttpClient httpClient = HttpClientBuilder.create()
		                 .setDefaultCredentialsProvider(credentialsProvider)
		                 .build();

		 
			 
		 credentialsProvider.setCredentials(AuthScope.ANY, new NTCredentials("tpvgroup", "tpvgroup", null, "Adast"));
    */
	
		 
}
	 
//	 public static final ODataClient client = ODataClientFactory.getClient();
	// odataClient.getConfiguration().setDefaultPubFormat(ContentType.APPLICATION_JSON);
	 
	 
	 @SuppressWarnings("unused")
	private static void sendPOST(String POST_URL, String USER_AGENT, String POST_PARAMS) throws IOException {
			URL obj = new URL(POST_URL);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);

			// For POST only - START
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			// For POST only - END

			int responseCode = con.getResponseCode();
			System.out.println("POST Response Code :: " + responseCode);

			if (responseCode == HttpURLConnection.HTTP_OK) { //success
				BufferedReader in = new BufferedReader(new InputStreamReader(
						con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// print result
				System.out.println(response.toString());
			} else {
				System.out.println("POST request not worked");
			}
		}
	 
}


