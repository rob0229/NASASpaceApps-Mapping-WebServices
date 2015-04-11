package com.spaceapps.mapping.water;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private String host;
	private String username = "root";
	private String password = "";
	private Connection con;
	
	DBConnection( String host, String username, String password){
		this.host = host;
		this.username = username;
		this.password = password;
		
		try{
			con = DriverManager.getConnection(host, username, password);
		}catch(Exception e){
			System.out.println("Result is: "+ e);
		}
	}
	
	public Connection getConnection(){
		return con;
	}
	
}
