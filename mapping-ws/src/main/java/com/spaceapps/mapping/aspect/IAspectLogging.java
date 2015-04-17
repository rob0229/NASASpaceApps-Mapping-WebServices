package com.spaceapps.mapping.aspect;

import org.aspectj.lang.JoinPoint;

public interface IAspectLogging {
	public void logBefore(JoinPoint joinPoint);
	public void logAfter(JoinPoint joinPoint);
}
