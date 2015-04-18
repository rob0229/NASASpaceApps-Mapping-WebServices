package com.spaceapps.mapping.water;

import java.sql.Connection;
import java.util.List;

import com.spaceapps.mapping.object.DataPoint;
import com.spaceapps.mapping.object.User;

public interface DataPointDAO {
	
	public int addDataPoint(int userId, double latitude, double longitude, String category, String purpose, Connection con); 

	public int modifyDataPoint(int userID, int dp_id, String category, String purpose, Connection con); 

	public List<DataPoint> userDataPoints(int userID, Connection con);

	public List<DataPoint> retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude,
			double minlongitude, Connection con);
}
