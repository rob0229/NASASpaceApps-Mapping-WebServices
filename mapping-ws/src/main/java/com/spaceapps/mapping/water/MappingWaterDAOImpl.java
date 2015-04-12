package com.spaceapps.mapping.water;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spaceapps.mapping.object.DataPoint;
import com.spaceapps.mapping.object.User;

public class MappingWaterDAOImpl implements MappingWaterDAO {

	DBConnection instance = DBConnection.getInstance(
			"jdbc:mysql://localhost:3306/mapping_water", "root", "");
	Connection con = instance.getCon();
	PreparedStatement stmt = null;;
	ResultSet rs = null;
	int dp_id = 0, s_id = 0;

	MappingWaterDAOImpl() {

	}

	public int addDataPoint(int userId, double latitude, double longitude,
			String category, String purpose) {
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
			String purpose) {
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

	public List<DataPoint> userDataPoints(int userID) {

		List<DataPoint> list = new ArrayList<DataPoint>();
		String query = "SELECT * FROM DATAPOINT DP, HISTORY H WHERE DP.dp_id = h.dp_id AND DP.user_id = H.user_id AND DP.user_id = '"
				+ userID + "'";
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			while (rs.next()) {
				DataPoint dp = new DataPoint(rs.getInt("dp_id"),
						rs.getDouble("latitude"), rs.getDouble("longitude"),
						rs.getNString("discovery_date"),
						rs.getNString("category"), rs.getNString("purpose"));
				list.add(dp);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public List<DataPoint> retrieveDataPoints(double maxlatitude,
			double minlatitude, double maxlongitude, double minlongitude) {

		List<DataPoint> list = new ArrayList<DataPoint>();
		String query = "SELECT * FROM DATAPOINT DP, HISTORY H WHERE DP.dp_id = h.dp_id AND DP.user_id = H.user_id AND latitude >"
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
						rs.getNString("discovery_date"),
						rs.getNString("category"), rs.getNString("purpose"));
				list.add(dp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public User login(String userName, String password) {
		String query = "SELECT * FROM USERS WHERE password ='" + password
				+ "' and name='" + userName + "'";
		User u = null;
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			u = new User(rs.getInt("user_id"), rs.getString("name"),
					rs.getString("email"));

		} catch (Exception e) {
			System.out.println(e);
		}

		return u;
	}

	public String registerUser(String userName, String password, String email) {
		String query = "INSERT INTO USERS (password, name, email) VALUES('"
				+ password + "','" + userName + "','" + email + "')";
		String result = "";
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			result = "success";
		} catch (Exception e) {
			System.out.println(e);
			result = "failure";
		}

		return result;
	}
}
