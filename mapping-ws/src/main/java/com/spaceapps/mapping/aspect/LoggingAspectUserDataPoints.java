package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAspectUserDataPoints implements IAspectLogging{
	final static Logger logger = Logger.getLogger(LoggingAspectModify.class);

	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.userDataPoints(*))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("User data points method before execution");
	}

	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.userDataPoints(*))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("User data points method finished execution.");
	}
}
