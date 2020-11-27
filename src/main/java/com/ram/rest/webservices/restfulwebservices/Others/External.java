package com.ram.rest.webservices.restfulwebservices.Others;

public class External {
	
	private String country_name;
	private String region_name;
	private String city;
	
	protected External() {}
	public External(String country_name, String region_name, String city) {
		super();
		this.country_name = country_name;
		this.region_name = region_name;
		this.city = city;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
