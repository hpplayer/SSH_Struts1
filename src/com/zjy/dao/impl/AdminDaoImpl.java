package com.zjy.dao.impl;

import java.util.List;
import com.zjy.bean.Admin;
import com.zjy.bean.Student;
import com.zjy.dao.BaseDao;
import com.zjy.dao.IAdminDao;

public class AdminDaoImpl extends BaseDao implements IAdminDao {

	@Override
	public void delete(Admin a) {
		// TODO Auto-generated method stub
		super.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Admin a=findById(id);
		super.delete(a);
		
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Admin as admin where  admin.id=?";
		List<Admin> list = super.executeQuery(hql, id);
		return list.get(0);
	}

	@Override
	public Admin findByNameAndPass(String username, String password) {
		// TODO Auto-generated method stub
		String hql = "from Admin as admin where  admin.name=? and admin.pwd=? ";
		List<Admin> list = super.executeQuery(hql, username,password);
		return list.get(0);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		String hql = "from Admin as admin ";
		List<Admin> list = super.executeQuery(hql);
		return list;
	}

	@Override
	public List<Admin> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Admin a) {
		// TODO Auto-generated method stub
		super.save(a);
	}

	@Override
	public void update(Admin a) {
		// TODO Auto-generated method stub
		super.update(a);
		
	}

	@Override
	public Admin getAdminByAdminName(String adminname) {
		// TODO Auto-generated method stub
		String hql = "from Admin as admin where  admin.name=?";
		List<Admin> list = super.executeQuery(hql, adminname);
		return list.get(0);
	}

}
