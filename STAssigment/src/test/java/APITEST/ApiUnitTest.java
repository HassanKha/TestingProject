package APITEST;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import API.APIdata;

public class ApiUnitTest {

	APIdata jsdata=new APIdata();
	JSONObject api=jsdata.getJSO();
	JSONObject apicurrinfo=jsdata.getCurrncyInfo();
	@Test
	public void test() throws JSONException {


		assertEquals("Colombia", api.get("name"));

	}

	@Test
	public void Callingcodestest() throws JSONException {


		assertNotEquals("[\"57\"]", api.get("callingCodes"));

	}

	@Test
	public void Capitaltest() throws JSONException {
		
		assertEquals("Bogotá", api.get("capital"));

	}

	@Test
	public void Reigontest() throws JSONException {

		assertEquals("Americas", api.get("region"));

	}

	@Test
	public void SubReigontest() throws JSONException {
		APIdata jsdata=new APIdata();
		JSONObject api=jsdata.getJSO();
		assertEquals("South America", api.get("subregion"));

	}

	@Test
	public void NativeNametest() throws JSONException {

		assertEquals("Colombia", api.get("nativeName"));

	}

	@Test
	public void CurrenciesCodeTest() throws JSONException   {

		assertEquals("COP",apicurrinfo.get("code"));

	}

	@Test
	public void CurrenciesSymbolTest() throws JSONException {

		assertEquals("$", apicurrinfo.get("symbol"));

	}

	@Test
	public void GetCurrenciesNameTest() throws JSONException {

		assertEquals("Colombian peso", apicurrinfo.get("name"));

	}

	
}
