package com.spaceapps.mapping.water;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spaceapps.mapping.object.DataPoint;
import com.spaceapps.mapping.object.User;

public class DataPointDAOImpl implements DataPointDAO {

	
	
	PreparedStatement stmt = null;;
	ResultSet rs = null;
	int dp_id = 0, s_id = 0;

	DataPointDAOImpl() {

	}

	public int addDataPoint(int userId, double latitude, double longitude,
			String category, String purpose, Connection con) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String query = "INSERT INTO DATAPOINT(latitude, longitude, discovery_date, purpose, user_id) VALUES ('"
				+ latitude
				+ "', '"
				+ longitude
				+ "', '"
				+ sdf.format(new Date()).toString()
				+ "', '"
				+ purpose
				+ "', '"
				+ userId + "')";
		try {
			stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				dp_id = rs.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		query = "INSERT INTO SAMPLE_INFO(ph) VALUES ('0')";
		try {
			stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				s_id = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		query = "INSERT INTO HISTORY(monitor_date, category, purpose, s_id, user_id, dp_id) VALUES ('"
				+ sdf.format(new Date()).toString()
				+ "', '"
				+ category
				+ "', '"
				+ purpose
				+ "', '"
				+ s_id
				+ "', '"
				+ userId
				+ "', '"
				+ dp_id + "')";
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		return s_id;
	}

	public int modifyDataPoint(int userID, int dp_id, String category,
			String purpose, Connection con) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// new entry in history and sample table
		String query = "INSERT INTO SAMPLE_INFO(ph) VALUES ('0')";
		try {
			stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			while (rs.next()) {
				s_id = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		query = "INSERT INTO HISTORY(monitor_date, category, purpose, s_id, user_id, dp_id) VALUES('"
				+ sdf.format(new Date()).toString()
				+ "', '"
				+ category
				+ "', '"
				+ purpose
				+ "', '"
				+ s_id
				+ "', '"
				+ userID
				+ "', '"
				+ dp_id + "')";
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return s_id;
	}

	public List<DataPoint> userDataPoints(int userID, Connection con) {

		List<DataPoint> list = new ArrayList<DataPoint>();
		String query = "SELECT * FROM DATAPOINT DP, HISTORY H WHERE DP.dp_id = H.dp_id AND DP.user_id = H.user_id AND DP.user_id = '"
				+ userID + "'";
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DataPoint dp = new DataPoint(rs.getInt("dp_id"),
						rs.getDouble("latitude"), rs.getDouble("longitude"),
						rs.getString("discovery_date"),
						rs.getString("category"), rs.getString("purpose"));
				list.add(dp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

	public List<DataPoint> retrieveDataPoints(double maxlatitude,
			double minlatitude, double maxlongitude, double minlongitude, Connection con) {

		List<DataPoint> list = new ArrayList<DataPoint>();
		String query = "SELECT * FROM DATAPOINT DP, HISTORY H WHERE DP.dp_id = H.dp_id AND DP.user_id = H.user_id AND latitude >"
				+ minlatitude
				+ " AND latitude < "
				+ maxlatitude
				+ "AND longitude > "
				+ minlongitude
				+ "AND longitude < "
				+ maxlongitude;
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DataPoint dp = new DataPoint(rs.getInt("dp_id"),
						rs.getDouble("latitude"), rs.getDouble("longitude"),
						rs.getString("discovery_date"),
						rs.getString("category"), rs.getString("purpose"));  
				list.add(dp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
