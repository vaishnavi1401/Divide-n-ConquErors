package com.reconnect.dao;

import com.reconnect.model.City;

public interface CityDaoInterface {

	public int getCityId(City c);
	public int insertCity(City c);
	public int checkCity(City c);
}
