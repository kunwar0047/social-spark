package com.socialspark.main.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class Users {
	public String username;
	String password;
	int uid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Users() {
		super();
	}
	public Users(int uid,String username ) {
		super();
		this.username = username;
		this.uid = uid;

	}
	public Users(String username ) {
		super();
		this.username = username;
		
	}
}
