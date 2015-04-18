package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAspectRegister implements IAspectLogging {

	final static Logger logger = Logger.getLogger(LoggingAspectRegister.class);

	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.registerUser(*))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Register method before execution");
	}

	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.registerUser(*))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Register method finished execution.");
	}

}
