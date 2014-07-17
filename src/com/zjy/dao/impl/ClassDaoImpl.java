package com.zjy.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjy.bean.Admin;
import com.zjy.dao.BaseDao;
import com.zjy.dao.IAdminDao;
import com.zjy.dao.IClassDao;
import com.zjy.bean.Classes;

public class ClassDaoImpl extends BaseDao implements IClassDao {

	@Override
	public void delete(Classes a) {
		// TODO Auto-generated method stub
		super.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Classes a=findById(id);
		super.delete(a);
	}

	@Override
	public Classes findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Classes as classes where  classes.classid=?";
		List<Classes> list = super.executeQuery(hql, id);
		return list.get(0);
	}

	@Override
	public List<Classes> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Classes a) {
		// TODO Auto-generated method stub
		super.save(a);
	}

	@Override
	public void update(Classes a) {
		// TODO Auto-generated method stub
		super.update(a);
	}

	@Override
	public void AgreeApply(int classid) {
		// TODO Auto-generated method stub
		Classes a=findById(classid);
		a.setCanupload("true");
		super.update(a);
		
	}

	@Override
	public void ApplyUploadScore(int classid) {
		// TODO Auto-generated method stub
		Classes a=findById(classid);
		a.setCanupload("waiting");
		super.update(a);
	}

	@Override
	public void RefuseApply(int classid) {
		// TODO Auto-generated method stub
		Classes a=findById(classid);
		a.setCanupload("false");
		super.update(a);
	}

	@Override
	public List<Classes> getClassByTeacherId(int teacherid) {
		// TODO Auto-generated method stub
		String hql = "from Classes as classes where  classes.teacherID=?";
		List<Classes> list = super.executeQuery(hql,teacherid);
		return list;
	}

	@Override
	public List<Classes> getAllWaitingClass() {
		// TODO Auto-generated method stub
		String hql = "from Classes as classes where  classes.canupload=?";
		List<Classes> list = super.executeQuery(hql,"waiting");
		return list;
	}


}
