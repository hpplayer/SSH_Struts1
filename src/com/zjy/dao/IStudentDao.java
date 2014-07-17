package com.zjy.dao;

import java.util.List;

import com.zjy.bean.Admin;
import com.zjy.bean.Student;


public interface IStudentDao {
	public void save(Student a);
	public void update(Student a);
	public void delete(Student a);
	public void delete(int id);
	public Student findById(int id);
	public List<Student> getPage(int pageId);
	public Student findByNameAndPass(String username,String password);
	public List<Student> getAllStudent();
	public List<Student> getAllStudentByGrade(int grade);
	public boolean deleteStudentsByGrade(int grade);
	public Student getStudentByStudentName(String studentname);
	public void upgrade();
	
}
