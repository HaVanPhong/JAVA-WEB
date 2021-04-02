package com.hithaui;

public class Country {
	private String Country_Region;
	private String Confirmed;
	private String Deaths;
	private String Recovered;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}
	
	public Country(Object object, Object object2, Object object3, Object object4) {
		super();
		this.Country_Region = object.toString();
		this.Confirmed = object2.toString();
		this.Deaths = object3.toString();
		this.Recovered = object4.toString();
	}

	public String getCountryRegion() {
		return Country_Region;
	}

	public void setCountryRegion(String countryRegion) {
		this.Country_Region = countryRegion;
	}

	public String getConfirmed() {
		return Confirmed;
	}

	public void setConfirmed(String confirmed) {
		this.Confirmed = confirmed;
	}

	public String getDeaths() {
		return Deaths;
	}

	public void setDeaths(String deaths) {
		this.Deaths = deaths;
	}

	public String getRecovered() {
		return Recovered;
	}

	public void setRecovered(String recovered) {
		this.Recovered = recovered;
	}

	@Override
	public String toString() {
		return "Country [countryRegion=" + Country_Region + ", confirmed=" + Confirmed + ", deaths=" + Deaths
				+ ", recovered=" + Recovered + "]";
	}
	
	
	

}
