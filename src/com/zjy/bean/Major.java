package com.zjy.bean;

import java.io.Serializable;

public class Major implements Serializable{
	private int majorid;
	private String majorname;
	public Major()
	{
		
	}
	public Major(int majorid)
	{
		this.majorid=majorid;
	}

	public int getMajorid() {
		return majorid;
	}
	public void setMajorid(int majorid) {
		this.majorid = majorid;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}

	
	
}
