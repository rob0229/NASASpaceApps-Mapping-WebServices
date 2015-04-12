package com.spaceapps.mapping.object;



public class DataPoint {
	private double latitude;
	private double longitude;
	private String discDate;	
	private String category;
	private String purpose;
	private int dataPointID;

	public DataPoint(int dp_id, double lat, double lon, String disc, String category, String purpose ) {
		this.latitude = lat;
		this.longitude = lon;
		this.category = category;
		this.purpose = purpose;
		this.discDate = disc;
		this.dataPointID = dp_id;
	}

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

	public String getDiscDate() {
		return discDate;
	}

	public void setDiscDate(String discDate) {
		this.discDate = discDate;
	}

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getpurpose() {
		return purpose;
	}

	public void setpurpose(String purpose) {
		this.purpose = purpose;
	}

	public int getDataPointID() {
		return dataPointID;
	}

	public void setDataPointID(int dataPointID) {
		this.dataPointID = dataPointID;
	}

}
