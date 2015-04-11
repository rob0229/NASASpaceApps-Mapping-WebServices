package com.spaceapps.mapping.water;

public interface MappingWaterDAO {
	public int addDataPoint(int userId, double latitude, double longitude, String category); 

	public void modifyDataPoint(int userID, int dpid, String category); 

	public void recentUserDataPoints(int userID);

	public void retrieveDataPoints(double maxlatitude, double minlatitude, double maxlongitude,
			double minlongitude);
}
