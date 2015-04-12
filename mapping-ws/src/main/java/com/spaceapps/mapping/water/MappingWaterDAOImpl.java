package com.spaceapps.mapping.water;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.spaceapps.mapping.object.DataPoint;

public class MappingWaterDAOImpl implements MappingWaterDAO{
	 
	DBConnection con; 
	PreparedStatement stmt = null;;
	ResultSet rs = null;

	MappingWaterDAOImpl(){
		
		con = new DBConnection("jdbc:mysql://localhost:3306/mapping_water", "root", "");
		
	}
	
	public int addDataPoint(int userId, double latitude, double longitude, String category) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int dp_id=0, s_id=0;
		
		String query ="INSERT INTO DATAPOINT(latitude, longitude, discovery_date, user_id) VALUES ('"+ latitude+"', '"+longitude+"', '"+ sdf.format(new Date()).toString()+ "', '" + userId+"')";
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
		
		
		query ="INSERT INTO HISTORY(monitor_date, category, s_id, user_id, dp_id) VALUES ('"+ sdf.format(new Date()).toString()+"', '"+category+"', '"+ s_id+ "', '" + userId+"', '" + dp_id+"')";
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

	public List<DataPoint> retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude, double minlongitude) {
		
		List<DataPoint> list = new ArrayList<DataPoint>();
		String query = "SELECT * FROM DATAPOINT DP, HISTORY H WHERE DP.dp_id = h.dp_id AND DP.user_id = H.user_id AND latitude >"+ minlatitude +" AND latitude < "+maxlatitude + "AND longitude > " + minlongitude + "AND longitude < " + maxlongitude;
		try{
		stmt = con.getConnection().prepareStatement(query);
		rs = stmt.executeQuery();
		while(rs.next()){
			//DataPoint dp = new DataPoint(rs.getNString("dp_id"), rs.getNString("latitude"), rs.getNString("longitude"), rs.getNString("discovery_date"), rs.getNString("category"));
			DataPoint dp = new DataPoint(rs.getNString("dp_id"), rs.getNString("discovery_date"), rs.getNString("category"));
			list.add(dp);
		}
		}catch(Exception e){
			System.out.println(e);
		}
		return list;
	}

	

	

}
