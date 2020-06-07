package API;

import org.json.JSONException;
import org.json.JSONObject;

public class APIdata {
	private JSONObject JSO;
	private JSONObject currncyInfo;
	public APIdata(){
		try {
			this.JSO=new JSONObject("{\"currencies\":[{\"code\":\"COP\",\"name\":\"Colombian peso\",\"symbol\":\"$\"}],\"name\":\"Colombia\",\"callingCodes\":[\"57\"],\"capital\":\"Bogotá\",\"region\":\"Americas\",\"subregion\":\"South America\",\"population\":48759958,\"nativeName\":\"Colombia\"}");
			this.currncyInfo=new JSONObject("{\"symbol\":\"$\",\"code\":\"COP\",\"name\":\"Colombian peso\"}");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String cuurname() {
		APIdata ap=new APIdata();
		JSONObject js=ap.getCurrncyInfo();
		return (String) js.get("name");
	}
	public String cuurcode() {
		APIdata ap=new APIdata();
		JSONObject js=ap.getCurrncyInfo();
		return (String) js.get("code");
	}

	public String cuursymbol() {
		APIdata ap=new APIdata();
		JSONObject js=ap.getCurrncyInfo();
		return (String) js.get("symbol");
	}


	public String GetCountryCurrenciesInfo() throws JSONException {

		String Name = this.cuurname();

		String Code = this.cuurcode();

		String Symbol = this.cuursymbol();

		String CurrenciesInfo = " Country's Currencies Name is " + Name + " of Code " + Code + " and It's Symbol is "  + Symbol;

		return CurrenciesInfo;
	}

	public JSONObject getJSO() {
		return JSO;
	}



	public JSONObject getCurrncyInfo() {
		return currncyInfo;
	}
	public String GetCountryLocation() throws JSONException {

		APIdata ap=new APIdata();
		JSONObject js=ap.getJSO();
		String Reigon =(String) js.get("region");

		String SubReigon= (String) js.get("subregion");

		String Location = " Country Reigon is " + Reigon + " and It's SubReigon is " + SubReigon ;

		return Location;
	}


public String GetCountryInfo() throws JSONException {
		APIdata ap=new APIdata();
		JSONObject js=ap.getJSO();
		String Name = (String) js.get("name");
		String Capital=(String) js.get("capital");

		String CountryInfo = " Country Name is " + Name + " and It's Capital is " + Capital ;

		return CountryInfo;
	}

}
