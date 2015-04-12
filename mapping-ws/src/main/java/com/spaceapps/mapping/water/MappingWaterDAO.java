package com.spaceapps.mapping.water;

import java.util.List;

import com.spaceapps.mapping.object.DataPoint;

public interface MappingWaterDAO {
	
	public String registerUser(String userName, String password, String email);
	
	public String login(String userName, String password);
	
	public int addDataPoint(int userId, double latitude, double longitude, String category, String purpose); 

	public int modifyDataPoint(int userID, int dp_id, String category, String purpose); 

	public List<DataPoint> userDataPoints(int userID);

	public List<DataPoint> retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude,
			double minlongitude);
}
