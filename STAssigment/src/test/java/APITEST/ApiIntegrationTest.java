package APITEST;

import static org.junit.Assert.*;

import org.json.JSONException;
import org.junit.Test;

import API.APIdata;

public class ApiIntegrationTest {
	APIdata jsdata=new APIdata();
	
	@Test
	public void CountryCurrenciesInfoTest() throws JSONException {
	
		assertEquals(" Country's Currencies Name is Colombian peso of Code COP and It's Symbol is $", jsdata.GetCountryCurrenciesInfo());

	}
	

	 @Test
      public void CountryLocationTest() throws JSONException {

        assertEquals(" Country Reigon is Americas and It's SubReigon is South America", jsdata.GetCountryLocation());

    }
	@Test
    public void CountryInfoTest() throws JSONException {
	

        assertEquals(" Country Name is Colombia and It's Capital is Bogotá", jsdata.GetCountryInfo());


    }

    
}


