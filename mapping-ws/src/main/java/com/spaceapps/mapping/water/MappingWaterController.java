package com.spaceapps.mapping.water;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spaceapps.mapping.object.DataPoint;
import com.spaceapps.mapping.object.User;

@RestController
public class MappingWaterController {

	@RequestMapping("/test")
	public String test(	) {
			
		return "The test is successful";
	} 
	
	
	@RequestMapping("/mapping/water/register")
	public String registerUser(			
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "eamil") String email) {
		String result = "";
		try {
			MappingWaterDAO dao = new MappingWaterDAOImpl();
			result = dao.registerUser(userName, password, email);
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		}
		return result;
	}
	
	@RequestMapping("/mapping/water/login")
	public User login(
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password) {
		User user = null;
		try {
			MappingWaterDAO dao = new MappingWaterDAOImpl();
			user = dao.login(userName, password);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@RequestMapping("/mapping/water/addDataPoint")
	public int addDataPoint(@RequestParam(value = "userID") int userID,
			@RequestParam(value = "latitude") double latitude,
			@RequestParam(value = "longitude") double longitude,
			@RequestParam(value = "category") String category,
			@RequestParam(value = "purpose") String purpose) {
		int result = 0;
		try {
			MappingWaterDAO dao = new MappingWaterDAOImpl();
			result = dao.addDataPoint(userID, latitude,longitude, category, purpose);
		} catch (Exception e) {

		}
		return result;
	}

	@RequestMapping("/mapping/water/modifyDataPoint")
	public int modifyDataPoint(@RequestParam(value = "userID") int userID,
			@RequestParam(value = "dpid") int dp_id,
			@RequestParam(value = "category") String category,
			@RequestParam(value = "purpose") String purpose) {
		int s_id = 0;
		try {
			MappingWaterDAO dao = new MappingWaterDAOImpl();
			s_id = dao.modifyDataPoint(userID, dp_id,category, purpose);
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
			MappingWaterDAO dao = new MappingWaterDAOImpl();
			list = dao.userDataPoints(userID);
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
			MappingWaterDAO dao = new MappingWaterDAOImpl();
			list = dao.retrieveDataPoints(maxlatitude,minlatitude, maxlongitude, minlongitude);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
