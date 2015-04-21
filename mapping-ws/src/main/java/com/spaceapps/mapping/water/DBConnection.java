package com.spaceapps.mapping.water;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {

	private static Connection con;
	private static DBConnection instance = null;
	private String dbUsername;
	private String dbPassword;
	private String dbServer;
	private String dbPort;
	private String dbName;
	
	//private constructor
	private DBConnection(){
		Properties props = new Properties();
		InputStream inputStream = getClass().getResourceAsStream("database.properties");
		try {
			props.load(inputStream);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		dbUsername = props.getProperty("dbusername");
		dbPassword = props.getProperty("dbpassword");
		dbServer = props.getProperty("dbserver");
		dbPort = props.getProperty("dbport");
		dbName = props.getProperty("dbname");
		
		try{
			this.con = DriverManager.getConnection("jdbc:mysql://" + dbServer + ":" + dbPort + "/" + dbName, dbUsername, dbPassword);
		}catch(Exception e){
			System.out.println("Result is: "+ e);
		}
	}
	
	//public getter
	public static DBConnection getInstance(){
		if(instance == null){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} 
			instance = new DBConnection();
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