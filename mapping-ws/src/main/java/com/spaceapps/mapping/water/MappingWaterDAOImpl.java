package com.spaceapps.mapping.water;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class MappingWaterDAOImpl implements MappingWaterDAO{
	 
	DBConnection con; 
	PreparedStatement stmt = null;;
	ResultSet rs = null;

	MappingWaterDAOImpl(){
		
		con = new DBConnection("jdbc:mysql://localhost:3306/mapping_water", "root", "");
		
	}
	
	public int addDataPoint(int userId, double latitude, double longitude, String category) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		int dp_id=0, s_id=0;
		
		String query ="INSERT INTO DATAPOINT(latitude, longitude, discovery_date, user_id) VALUES ('"+ latitude+"', '"+longitude+"', '"+ sdf.format(new Date())+ "', '" + userId+"')";
		try{
			stmt = con.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			while(rs.next()){
				dp_id=rs.getInt(1);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		query ="INSERT INTO SAMPLE_INFO(ph) VALUES ('0')";
		try{
			stmt = con.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			while(rs.next()){
				s_id=rs.getInt(1);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		query ="INSERT INTO HISTORY(monitorDate, category, s_id, u_id, dp_id) VALUES ('"+ sdf.format(new Date())+"', '"+category+"', '"+ s_id+ "', '" + userId+"', '" + dp_id+"')";
		try{
			stmt = con.getConnection().prepareStatement(query);
			stmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return s_id;
	}

	public void modifyDataPoint(int userID, int dpid, String category) {
		
		
	}

	public void recentUserDataPoints(int userID) {
		// TODO Auto-generated method stub
		
	}

	public void retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude, double minlongitude) {
		
	 
		String query = "SELECT * FROM DataPoint WHERE latitude >"+ minlatitude +" AND latitude < "+maxlatitude + "AND longitude > " + minlongitude + "AND longitude < " + maxlongitude;
		try{
		stmt = con.getConnection().prepareStatement(query);
		rs = stmt.executeQuery();
		
		}catch(Exception e){
			System.out.println(e);
		}
	}

	

	

}
