package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAspectModify implements IAspectLogging {

	final static Logger logger = Logger.getLogger(LoggingAspectModify.class);

	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.modifyDataPoint(*))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Modify data point method before execution");
	}

	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.modifyDataPoint(*))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Modify data point method finished execution.");
	}

}
