package API;

import java.io.Serializable;

import org.json.JSONObject;

public class CachedDate implements Serializable{
	private String JSO;
	private String countryinfo;
	public CachedDate(String jSO, String countryinfo) {
		super();
		JSO = jSO;
		this.countryinfo = countryinfo;
	}
	public CachedDate() {
		// TODO Auto-generated constructor stub
	}
	public String getJSO() {
		return JSO;
	}
	public String getCountryinfo() {
		return countryinfo;
	}
	public void setJSO(String jSO) {
		JSO = jSO;
	}
	public void setCountryinfo(String countryinfo) {
		this.countryinfo = countryinfo;
	}

	
	
	

}
