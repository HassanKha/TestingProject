package API;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;
public class APIConnection {


	private static HttpsURLConnection connection; 
	private	BufferedReader Reader ;
	private	String Line;
	private	StringBuffer responcecontent=new StringBuffer();
	private String spec;
	private String res;


	public APIConnection(String spec) {
		super();
		this.spec = spec;
	}


	public String getCountryInfoFromOnlineApi() {

		try {
			URL url=new URL(this.spec);
			connection=(HttpsURLConnection) url.openConnection();


			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int status=connection.getResponseCode();
			//System.out.println(status);
			if(status>299) {
				Reader=new BufferedReader(new InputStreamReader(connection.getErrorStream()));
				//while((Line=Reader.readLine()) != null) {
				Line=Reader.readLine();	   
				responcecontent.append(Line);

				//}
				Reader.close();

			}else {
				Reader= new BufferedReader(new InputStreamReader(connection.getInputStream()));
				//while((Line=Reader.readLine())!=null) {
				Line=Reader.readLine();	   
				responcecontent.append(Line);

				// }
				Reader.close();

			}

			String ox=responcecontent.toString();
			this.res=ox;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;


	}

}


