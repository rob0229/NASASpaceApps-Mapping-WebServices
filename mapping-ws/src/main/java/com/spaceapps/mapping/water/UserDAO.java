package com.spaceapps.mapping.water;

import java.sql.Connection;

import com.spaceapps.mapping.object.User;

public interface UserDAO {
	public String registerUser(String userName, String password, String email, Connection con);

	public User login(String userName, String password, Connection con);
}
