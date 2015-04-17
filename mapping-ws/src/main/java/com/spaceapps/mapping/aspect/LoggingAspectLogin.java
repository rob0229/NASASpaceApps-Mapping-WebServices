package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;

public class LoggingAspectLogin implements IAspectLogging {

	final static Logger logger = Logger.getLogger(LoggingAspectLogin.class);

	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.login(*))")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Login method before execution");
	}
	
	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.login(*))")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Login method after execution");
	}

}
