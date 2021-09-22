package com.reconnect.utility;

import com.reconnect.dao.CityDao;
import com.reconnect.dao.CityDaoInterface;

public class CityDAOFactory {
	
	private CityDAOFactory()
	{
		
	}
	
	public static CityDaoInterface createCityDaoObject()
	{
		return new CityDao();
	}

}
