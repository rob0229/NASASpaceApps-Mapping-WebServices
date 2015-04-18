package com.spaceapps.mapping.water;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("spring-aspect.xml")
@SpringBootApplication
public class WaterMain extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
			SpringApplication.run(WaterMain.class, args);
	}
}
