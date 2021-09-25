package com.reconnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reconnect.dao.util.CityDaoInterface;
import com.reconnect.model.City;
import com.reconnect.utility.DBUtils;

public class CityDao implements CityDaoInterface{

	Connection conn = null;

	public CityDao() {
		conn = DBUtils.getConnection();
	}

	//Returns the city Id according to (city, state, country) else details will be inserted into the table.
	public int getCityId(City c) {
		int cityId = checkCity(c);
		if(cityId == 0)
			return insertCity(c);
		else
			return cityId;
	}

	//Insert the city details (city, state, country) into the table
	public int insertCity(City c) {
		PreparedStatement pstmt = null;
		String sql = "insert into city_details(city, state, country) values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCity());
			pstmt.setString(2, c.getState());
			pstmt.setString(3, c.getCountry());
			int rs = pstmt.executeUpdate();
			if (rs > 0) 
			{
				return checkCity(c);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try 
			{
				pstmt.close();
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		return 0;
	}

	//Checks whether the combination of (city, state, country) already exists into the table.
	public int checkCity(City c) {
		PreparedStatement pstmt = null;
		String sql = "select city_id from city_details where city=? and state=? and country=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getCity());
			pstmt.setString(2, c.getState());
			pstmt.setString(3, c.getCountry());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
}
