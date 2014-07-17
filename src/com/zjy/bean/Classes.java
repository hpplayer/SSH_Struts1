package com.zjy.bean;

import java.io.Serializable;

public class Classes implements Serializable{
	private int classid;
	private String classname;
	private int majorID;
	private int grade;
	private int teacherID;
	private String canupload;
	public Classes()
	{
		
	}
	public Classes(int id)
	{
		this.classid=id;
	}
	public int getClassid() {
		return classid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
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
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacherID) {
		this.teacherID = teacherID;
	}
	public String getCanupload() {
		return canupload;
	}
	public void setCanupload(String canupload) {
		this.canupload = canupload;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}

	
	
}
