package com.zjy.dao;

import java.util.List;

import com.zjy.bean.Major;


public interface IMajorDao {
	public void save(Major a);
	public void update(Major a);
	public void delete(Major a);
	public void delete(int id);
	public Major findById(int id);
	public List<Major> getPage(int pageId);
	public List<Major> getAllMajor();
}
