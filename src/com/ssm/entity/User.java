package com.ssm.entity;

public class User {

	private int id;
	private String userName;
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	
	//重写toString方法
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "user对象"+id+"--"+userName+"--"+password;
	}
}
