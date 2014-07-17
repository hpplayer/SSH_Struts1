package com.zjy.dao;

import java.util.List;

import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;


public interface IStuClassDao {
	public void save(Stuclass a);
	public void update(Stuclass a);
	public void delete(Stuclass a);
	public void delete(int id);
	public Stuclass findById(int id);
	public List<Stuclass> getPage(int pageId);
	public List<Stuclass> getAllStuclass();
	public List<Stuclass> getStuclassListByStudentIDAndGrade(String studentid,String grade);//本学年成绩
	public List<Stuclass> getAllStuclassByStudentID(int studentid);//所有成绩
	public List<Stuclass> getCurrentStuclassByStudentId(Student s);//本学年成绩
	public List<Stuclass> getStudentsByClassId(int classid);
	public List<Stuclass> getScoreByStudentIdAndGrade(int studentid,int grade);
	public boolean deleteStuclassByStudentId(int studentid);
	public Stuclass getStuclassbyStudentIdAndClassIdAndGrade(int studentid,int classid,int grade);
	
	
}
