package com.spaceapps.mapping.water;

import java.awt.Point;

public class MappingWater {
	private double latitude;
	private double longitude;
	private int distance;
	private int userID;
	private String category;
	private int dataPointID;
	
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getDataPointID() {
		return dataPointID;
	}
	public void setDataPointID(int dataPointID) {
		this.dataPointID = dataPointID;
	}
	
	
}
