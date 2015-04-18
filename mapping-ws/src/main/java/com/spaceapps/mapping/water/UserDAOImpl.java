package com.spaceapps.mapping.water;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.spaceapps.mapping.object.User;

public class UserDAOImpl implements UserDAO {

	
	PreparedStatement stmt = null;;
	ResultSet rs = null;
	public User login(String userName, String password, Connection con) {
		String query = "SELECT * FROM USERS WHERE password ='" + password
				+ "' and name='" + userName + "'";
		User u = null;
		try {
			stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			u = new User(rs.getInt("user_id"), rs.getString("name"), rs.getString("email"));
			
			}catch(Exception e){
				System.out.println(e);
			}
		
		return u;
	}

	public String registerUser(String userName, String password, String email, Connection con) {
		String query = "INSERT INTO USERS (password, name, email) VALUES('"
				+ password + "','" + userName + "','" + email + "')";
		String result = "";
		try {
			stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			result = "success";
		} catch (Exception e) {
			System.out.println(e);
			result = "failure";
		}

		return result;
	}

}
