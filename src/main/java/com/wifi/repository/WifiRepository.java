package com.wifi.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.entity.Wifi;

public class WifiRepository {
	static Connection connection;
	static String dbUrl = "jdbc:sqlite:/Users/chadongjun/Desktop/WifiDB/wifi.db";
	
	public static void save(List<Wifi> wifiList) {
		try {
			connection = DriverManager.getConnection(dbUrl);
			
			for (Wifi wifi: wifiList) {
				String query = "insert into wifi\r\n" + 
						"(X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM)\r\n" + 
						"values\r\n" + 
						"(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
				
				PreparedStatement statement = connection.prepareStatement(query);
				statement.setString(1, wifi.getX_SWIFI_MGR_NO());
				statement.setString(2, wifi.getX_SWIFI_WRDOFC());
				statement.setString(3, wifi.getX_SWIFI_MAIN_NM());
				statement.setString(4, wifi.getX_SWIFI_ADRES1());
				statement.setString(5, wifi.getX_SWIFI_ADRES2());
				statement.setString(6, wifi.getX_SWIFI_INSTL_FLOOR());
				statement.setString(7, wifi.getX_SWIFI_INSTL_TY());
				statement.setString(8, wifi.getX_SWIFI_INSTL_MBY());
				statement.setString(9, wifi.getX_SWIFI_SVC_SE());
				statement.setString(10, wifi.getX_SWIFI_CMCWR());
				statement.setInt(11, wifi.getX_SWIFI_CNSTC_YEAR());
				statement.setString(12, wifi.getX_SWIFI_INOUT_DOOR());
				statement.setString(13, wifi.getX_SWIFI_REMARS3());
				statement.setDouble(14,  wifi.getLNT());
				statement.setDouble(15, wifi.getLAT());
				statement.setString(16, wifi.getWORK_DTTM());	
				statement.execute();
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
		
	}
	
	public static void deleteAll() {
		try {
			connection = DriverManager.getConnection(dbUrl);
			String query = "delete from wifi;";
			PreparedStatement statement = connection.prepareStatement(query);
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
	
	public static List<Wifi> getAllWifi() {
		List<Wifi> wifiList = new ArrayList<>();
		
		try {
			connection = DriverManager.getConnection(dbUrl);
			String query = "select * from wifi;";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
				String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
				String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
				String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
				String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
				String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
				String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
				String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
				String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
				String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
				int X_SWIFI_CNSTC_YEAR = rs.getInt("X_SWIFI_CNSTC_YEAR");
				String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
				String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
				double LAT = rs.getDouble("LAT");
				double LNT = rs.getDouble("LNT");
				String WORK_DTTM = rs.getString("WORK_DTTM");
				
				wifiList.add(
						new Wifi(X_SWIFI_MGR_NO,
								X_SWIFI_WRDOFC,
								X_SWIFI_MAIN_NM,
								X_SWIFI_ADRES1,
								X_SWIFI_ADRES2,
								X_SWIFI_INSTL_FLOOR,
								X_SWIFI_INSTL_TY,
								X_SWIFI_INSTL_MBY,
								X_SWIFI_SVC_SE,
								X_SWIFI_CMCWR,
								X_SWIFI_CNSTC_YEAR,
								X_SWIFI_INOUT_DOOR,
								X_SWIFI_REMARS3,
								LAT,
								LNT,
								WORK_DTTM
						)
				);
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
		
		return wifiList;
	}
}
