package com.zjy.dao;

import java.util.List;

import com.zjy.bean.Admin;
import com.zjy.bean.Major;

public interface IAdminDao {
	public void save(Admin a);
	public void update(Admin a);
	public void delete(Admin a);
	public void delete(int id);
	public Admin findById(int id);
	public List<Admin> getPage(int pageId);
	public Admin findByNameAndPass(String username,String password);
	public List<Admin> getAllAdmin();
	public Admin getAdminByAdminName(String adminname);
}
