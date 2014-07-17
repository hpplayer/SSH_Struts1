package com.zjy.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjy.bean.Admin;
import com.zjy.bean.Major;
import com.zjy.dao.BaseDao;
import com.zjy.dao.IAdminDao;
import com.zjy.dao.IMajorDao;

public class MajorDaoImpl extends BaseDao implements IMajorDao {

	@Override
	public void delete(Major a) {
		// TODO Auto-generated method stub
		super.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Major a = findById(id);
		super.delete(a);
	}

	@Override
	public Major findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Major as major where  major.id=?";
		List<Major> list = super.executeQuery(hql, id);
		return list.get(0);
	}

	@Override
	public List<Major> getAllMajor() {
		// TODO Auto-generated method stub
		String hql = "from Major as major";
		List<Major> list = super.executeQuery(hql);
		return list;
	}

	@Override
	public List<Major> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Major a) {
		// TODO Auto-generated method stub
		super.save(a);
		
	}

	@Override
	public void update(Major a) {
		// TODO Auto-generated method stub
		super.update(a);
	}

}
