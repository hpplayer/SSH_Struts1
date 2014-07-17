package com.zjy.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjy.bean.Admin;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.dao.BaseDao;
import com.zjy.dao.IAdminDao;
import com.zjy.dao.ITeacherDao;
public class TeacherDaoImpl extends BaseDao implements ITeacherDao {

	@Override
	public void delete(Teacher a) {
		// TODO Auto-generated method stub
		super.delete(a);
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Teacher a=findById(id);
		super.delete(a);
		
	}

	@Override
	public Teacher findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Teacher as teacher where  teacher.id=?";
		List<Teacher> list = super.executeQuery(hql, id);
		return list.get(0);
	}

	@Override
	public Teacher findByNameAndPass(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from Teacher as teacher where  teacher.name=? and teacher.pwd=?";
		List<Teacher> list = super.executeQuery(hql, username,password);
		return list.get(0);
	}

	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		String hql = "from Teacher as student";
		List<Teacher> list = super.executeQuery(hql);
		return list;
	}

	@Override
	public List<Teacher> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Teacher a) {
		// TODO Auto-generated method stub
		super.save(a);
	}

	@Override
	public void update(Teacher a) {
		// TODO Auto-generated method stub
		super.update(a);
	}

	@Override
	public Teacher getTeacherByTeacherName(String teachername) {
		// TODO Auto-generated method stub
		String hql = "from Teacher as teacher where  teacher.name=?";
		List<Teacher> list = super.executeQuery(hql, teachername);
		return list.get(0);
	}

}
