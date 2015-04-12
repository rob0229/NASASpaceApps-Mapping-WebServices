package com.spaceapps.mapping.water;

import java.util.List;

import com.spaceapps.mapping.object.DataPoint;

public interface MappingWaterDAO {
	public int addDataPoint(int userId, double latitude, double longitude, String category); 

	public int modifyDataPoint(int userID, int dp_id, String category); 

	public List<DataPoint> userDataPoints(int userID);

	public List<DataPoint> retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude,
			double minlongitude);
}
