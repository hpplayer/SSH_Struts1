package com.zjy.bean;

import java.io.Serializable;

public class Teacher implements Serializable{
	private int id;
	private String name;
	private String pwd;
	private String homeAdd;
	private int majorID;
	public Teacher()
	{
	}
	public Teacher(String username,String password)
	{
		this.name=username;
		this.pwd=password;
	}
	public Teacher(int id)
	{
		this.id=id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getHomeAdd() {
		return homeAdd;
	}
	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}
	public int getMajorID() {
		return majorID;
	}
	public void setMajorID(int majorID) {
		this.majorID = majorID;
	}
	
	
}
