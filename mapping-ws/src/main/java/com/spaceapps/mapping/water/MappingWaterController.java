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

	@RequestMapping("/mapping/water/addDataPoint")
	public int addDataPoint(@RequestParam(value = "userID") int userID,
			@RequestParam(value = "latitude") double latitude,
			@RequestParam(value = "longitude") double longitude,
			@RequestParam(value = "category") String category) {
		int result = 0;
		try {
			result = new MappingWaterDAOImpl().addDataPoint(userID, latitude, longitude,
					category);
		} catch (Exception e) {
			
		}
		return result;
	}

	@RequestMapping("/mapping/water/modifyDataPoint")
	public String addDataPoint(@RequestParam(value = "userID") int userID,
			@RequestParam(value = "dpid") int dpid,
			@RequestParam(value = "category") String category) {

		try {
			new MappingWaterService().modifyDataPoint(userID, dpid, category);
		} catch (Exception e) {
			return "Failure";
		}
		return "Success";
	}

	@RequestMapping("/mapping/water/recentUserDataPoints")
	public String recentUserDataPoints(
			@RequestParam(value = "userID") int userID) {

		try {
			new MappingWaterService().recentUserDataPoints(userID);
		} catch (Exception e) {
			return "Failure";
		}
		return "Success";
	}

	@RequestMapping("/mapping/water/retrieveDataPoints")
	public List<DataPoint> retrieveDataPoints(
			@RequestParam(value = "maxlatitude") double maxlatitude,
			@RequestParam(value = "minlatitude") double minlatitude,
			@RequestParam(value = "maxlongitude") double maxlongitude,
			@RequestParam(value = "minlongitude") double minlongitude) {
		List<DataPoint> list = null;
		try {
			list = new MappingWaterDAOImpl().retrieveDataPoints(maxlatitude, minlatitude, maxlongitude,
					 minlongitude);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
