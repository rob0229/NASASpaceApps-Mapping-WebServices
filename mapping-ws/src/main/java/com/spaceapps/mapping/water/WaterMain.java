package com.spaceapps.mapping.water;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class WaterMain extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(WaterMain.class);
	}
	
	public static void main(String[] args) {
		//config
		
		SpringApplication.run(WaterMain.class, args);
	}
}
