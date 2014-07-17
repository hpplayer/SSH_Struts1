package com.zjy.bean;

import java.io.Serializable;

public class Admin implements Serializable{
	private int id;
	private String name;
	private String pwd;
	public Admin()
	{
		
	}
	public Admin(String username,String password)
	{
		this.name=username;
		this.pwd=password;
	}
	public Admin(int id)
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
}
