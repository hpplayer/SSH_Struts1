package com.zjy.bean;

import java.io.Serializable;

public class Stuclass implements Serializable{
	private int id;
	private int stuID;
	private int classID;
	private int grade;
	private int score;
	public Stuclass()
	{
		
	}
	public Stuclass(int id)
	{
		this.id=id;
	}
	public int getStuID() {
		return stuID;
	}
	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public int getClassID() {
		return classID;
	}
	public void setClassID(int classID) {
		this.classID = classID;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
