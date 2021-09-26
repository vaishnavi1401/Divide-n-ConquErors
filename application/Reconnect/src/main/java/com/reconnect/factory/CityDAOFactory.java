package com.reconnect.factory;

import com.reconnect.dao.CityDao;
import com.reconnect.dao.util.CityDaoInterface;

public class CityDAOFactory {

	public CityDAOFactory()
	{

	}

	public static CityDaoInterface createCityDaoObject()
	{
		return new CityDao();
	}

}
