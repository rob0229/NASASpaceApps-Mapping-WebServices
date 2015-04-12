package com.spaceapps.mapping.water;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spaceapps.mapping.object.DataPoint;

@RestController
public class MappingWaterController {

	
	@RequestMapping("/mapping/water/register")
	public String registerUser(			
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "eamil") String email) {
		String result = "";
		try {
			result = new MappingWaterDAOImpl().registerUser(userName, password, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/mapping/water/login")
	public String login(
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		String result = "";
		try {
			result = new MappingWaterDAOImpl().login(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/mapping/water/addDataPoint")
	public int addDataPoint(@RequestParam(value = "userID") int userID,
			@RequestParam(value = "latitude") double latitude,
			@RequestParam(value = "longitude") double longitude,
			@RequestParam(value = "category") String category) {
		int result = 0;
		try {
			result = new MappingWaterDAOImpl().addDataPoint(userID, latitude,
					longitude, category);
		} catch (Exception e) {

		}
		return result;
	}

	@RequestMapping("/mapping/water/modifyDataPoint")
	public int modifyDataPoint(@RequestParam(value = "userID") int userID,
			@RequestParam(value = "dpid") int dp_id,
			@RequestParam(value = "category") String category) {
		int s_id = 0;
		try {
			s_id = new MappingWaterDAOImpl().modifyDataPoint(userID, dp_id,
					category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s_id;
	}

	@RequestMapping("/mapping/water/userDataPoints")
	public List<DataPoint> userDataPoints(
			@RequestParam(value = "userID") int userID) {
		List<DataPoint> list = null;
		try {
			list = new MappingWaterDAOImpl().userDataPoints(userID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@RequestMapping("/mapping/water/retrieveDataPoints")
	public List<DataPoint> retrieveDataPoints(
			@RequestParam(value = "maxlatitude") double maxlatitude,
			@RequestParam(value = "minlatitude") double minlatitude,
			@RequestParam(value = "maxlongitude") double maxlongitude,
			@RequestParam(value = "minlongitude") double minlongitude) {
		List<DataPoint> list = null;
		try {
			list = new MappingWaterDAOImpl().retrieveDataPoints(maxlatitude,
					minlatitude, maxlongitude, minlongitude);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
