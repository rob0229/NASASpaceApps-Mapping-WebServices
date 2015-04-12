package com.spaceapps.mapping.object;

import java.util.Date;

public class DataPoint {
	private String latitude;
	private String longitude;
	private String discDate;	
	private String category;
	private String dataPointID;

	public DataPoint(String dp_id, String lat, String lon, String disc, String category ) {
		this.latitude = lat;
		this.longitude = lon;
		this.category = category;
		this.discDate = disc;
		this.dataPointID = dp_id;
	}

	public DataPoint(String nString) {
		this.discDate = nString;
	}

	public DataPoint(String dp_id, String nString, String nString2) {
		this.dataPointID = dp_id;
		this.discDate = nString;
		this.category = nString2;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
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

	public String getDataPointID() {
		return dataPointID;
	}

	public void setDataPointID(String dataPointID) {
		this.dataPointID = dataPointID;
	}

}
