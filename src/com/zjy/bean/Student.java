package com.zjy.bean;

import java.io.Serializable;

public class Student implements Serializable{
	private int id;
	private String name;
	private String pwd;
	private String homeAdd;
	private int majorID;
	private int grade;
	public Student()
	{
		
	}
	public Student(String username,String password)
	{
		this.name=username;
		this.pwd=password;
	}
	public Student(int id)
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
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
