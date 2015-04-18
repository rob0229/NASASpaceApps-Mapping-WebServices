package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAspectAdd implements IAspectLogging {
	final static Logger logger = Logger.getLogger(LoggingAspectAdd.class);

	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.addDataPoint(*))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Add data point method before execution");
	}

	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.addDataPoint(*))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Add data point method finished execution.");
	}

}
