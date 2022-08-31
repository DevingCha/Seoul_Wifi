package com.wifi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.LocationHistory;
import com.entity.Wifi;

public class LocationHistoryRepository {
	static Connection connection;
	static String dbUrl = "jdbc:sqlite:/Users/chadongjun/Desktop/WifiDB/wifi.db";
	
	public static void saveHistory(double myLat, double myLnt) {
		try {
			connection = DriverManager.getConnection(dbUrl);
			String query = "insert into location_history (LAT, LNT, INQUIRY_DTTM)\r\n"
					+ "VALUES (?, ?, datetime('now', 'localtime'));";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setDouble(1, myLat);
			statement.setDouble(2,  myLnt);
			statement.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static List<LocationHistory> getAllHistory() {
		List<LocationHistory> histories = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(dbUrl);
			
			String query = "select * from location_history order by INQUIRY_DTTM desc;";
			PreparedStatement statement = connection.prepareStatement(query);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				double lat = rs.getDouble("LAT");
				double lnt = rs.getDouble("LNT");
				String datetime = rs.getString("INQUIRY_DTTM");
				
				histories.add(new LocationHistory(id, lat, lnt, datetime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return histories;
	}
}
