package com.spaceapps.mapping.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
 
@Aspect
@Component
public class LoggingAspectTest implements IAspectLogging {
	final static Logger logger = Logger.getLogger(LoggingAspectTest.class);
	
	@Before("execution(* com.spaceapps.mapping.water.MappingWaterController.test())")
	public void logBefore(JoinPoint joinPoint) {
		logger.info("Test method before execution");
	}
	
	@After("execution(* com.spaceapps.mapping.water.MappingWaterController.test())")
	public void logAfter(JoinPoint joinPoint) {
		logger.info("Test method finished execution.");
	}
 
}