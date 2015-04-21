package com.spaceapps.mapping.water;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spaceapps.mapping.object.DataPoint;
import com.spaceapps.mapping.object.User;

@RestController
public class MappingWaterController {
	@Autowired
	DAOFactory daoFactory;
	
	@RequestMapping("/test")
	public String test(	) {
			return "The test is successful";
	} 
	
	
	@RequestMapping("/mapping/water/register")
	public String registerUser(			
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "email") String email) {
		String result = "";
		try {
			daoFactory.beginConnectionFactory();
			UserDAO dao = daoFactory.createUserDAO();
			result = dao.registerUser(userName, password, email, daoFactory.getInstance().getCon());
			daoFactory.closeConnectionFactory();
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
			daoFactory.beginConnectionFactory();
			UserDAO dao = daoFactory.createUserDAO();
			user = dao.login(userName, password, daoFactory.getInstance().getCon());
			daoFactory.closeConnectionFactory();
		
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
			daoFactory.beginConnectionFactory();
			DataPointDAO dao = daoFactory.createDataPointDAO();
			result = dao.addDataPoint(userID, latitude,longitude, category, purpose, daoFactory.getInstance().getCon());
			daoFactory.closeConnectionFactory();
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
			daoFactory.beginConnectionFactory();
			DataPointDAO dao =  daoFactory.createDataPointDAO();
			s_id = dao.modifyDataPoint(userID, dp_id,category, purpose, daoFactory.getInstance().getCon());
			daoFactory.closeConnectionFactory();
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
			daoFactory.beginConnectionFactory();
			DataPointDAO dao = daoFactory.createDataPointDAO();
			list = dao.userDataPoints(userID, daoFactory.getInstance().getCon());
			daoFactory.closeConnectionFactory();
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
			daoFactory.beginConnectionFactory();
			DataPointDAO dao = daoFactory.createDataPointDAO();
			list = dao.retrieveDataPoints(maxlatitude,minlatitude, maxlongitude, minlongitude, daoFactory.getInstance().getCon());
			daoFactory.closeConnectionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
