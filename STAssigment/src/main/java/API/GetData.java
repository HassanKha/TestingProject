package API;

public class GetData {
   private String country;
   	private String Data;
	private boolean checkedincached;
	private boolean establishconnectionwithapi;

	
	public GetData(String country) {
		super();
		this.country = country;
		establishconnectionwithapi=false;
	}
	
	public boolean checkdataincach() {
		 cacheddatabase db=cacheddatabase.getInstance();
		 CachedDate cd=new CachedDate("", country);
		 this.checkedincached=db.checkExistence(cd);
		 return this.checkedincached;
	  
	        
	}
	
	public String getdata() {
		 establishconnectionwithapi=false;
		 cacheddatabase db=cacheddatabase.getInstance();
		if(checkdataincach()) {
			 CachedDate cd=new CachedDate("", country);
			 this.Data=(db.getdata(cd)).getJSO();
			 return this.Data;
		}
		else{
			String n1="https://restcountries.eu/rest/v2/name/";
		    String n2="?fields=name;capital;currencies";
		    String ap=n1+country+n2;
			APIConnection api=new APIConnection(ap);
			this.Data=api.getCountryInfoFromOnlineApi();
			CachedDate cd=new CachedDate(this.Data, country);
			db.addToDatabase(cd);
			establishconnectionwithapi=true;
			 return this.Data;
			
		}
	     	
	}
	
	
	
	 public String getCountry() {
		 return country;
	 }
	 public String getData() {
	 	return Data;
	 }
	 public void setCountry(String country) {
		this.country = country;
	}
	 public void setData(String data) {
		Data = data;
	}

	public boolean isCheckedincached() {
		return checkedincached;
	}

	public boolean isEstablishconnectionwithapi() {
		return establishconnectionwithapi;
	}
	

	
	 
   
   	
   	
}
