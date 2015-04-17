package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAspectRetrieve implements IAspectLogging {
	final static Logger logger = Logger.getLogger(LoggingAspectRetrieve.class);

	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.retrieveDataPoints(*))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Retrieve data points method before execution");
	}

	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.retrieveDataPoints(*))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Retrieve data points method finished execution.");
	}

}
