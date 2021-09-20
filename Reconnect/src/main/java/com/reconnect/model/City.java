package com.reconnect.model;

import com.reconnect.dao.CityDao;

public class City {
<<<<<<< Updated upstream

	private String city;
	private String state;
	private String country;

=======
	
	private int cityId;
	private String city;
	private String state;
	private String country; 
	
	CityDao cd = new CityDao();
	
	public int getCityId() {
		return cd.getCityId(c);
	}
>>>>>>> Stashed changes
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


}
