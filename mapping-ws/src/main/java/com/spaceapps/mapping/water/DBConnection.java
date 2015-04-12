package com.spaceapps.mapping.water;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static Connection con;
	private static DBConnection instance = null;
	
	//private constructor
	private DBConnection(String host, String username, String password){
		try{
			this.con = DriverManager.getConnection(host, username, password);
		}catch(Exception e){
			System.out.println("Result is: "+ e);
		}
	}
	
	//public getter
	public static DBConnection getInstance(String host, String username, String password){
		if(instance == null){
			instance = new DBConnection(host, username, password);
			return instance;
		}
		else{	
			return instance;
		}
	}

	public Connection getCon() {
		return con;
	}
	
}
