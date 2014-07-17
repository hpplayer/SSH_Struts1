package com.zjy.dao;

import java.util.List;

import com.zjy.bean.Admin;
import com.zjy.bean.Teacher;


public interface ITeacherDao {
	public void save(Teacher a);
	public void update(Teacher a);
	public void delete(Teacher a);
	public void delete(int id);
	public Teacher findById(int id);
	public List<Teacher> getPage(int pageId);
	public Teacher findByNameAndPass(String username,String password);
	public List<Teacher> getAllTeacher();
	public Teacher getTeacherByTeacherName(String teachername);
}
