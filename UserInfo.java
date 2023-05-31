package com.beans;

public class UserInfo {
	private Integer id;
	private String userName;
	private String password;
	private String type;
	
	public UserInfo(int id, String userName, String password, String type) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.type=type;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
