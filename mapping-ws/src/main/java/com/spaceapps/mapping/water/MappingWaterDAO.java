package com.spaceapps.mapping.water;

import java.util.List;

import com.spaceapps.mapping.object.DataPoint;

public interface MappingWaterDAO {
	public int addDataPoint(int userId, double latitude, double longitude, String category); 

	public void modifyDataPoint(int userID, int dpid, String category); 

	public void recentUserDataPoints(int userID);

	public List<DataPoint> retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude,
			double minlongitude);
}
