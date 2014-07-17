package com.zjy.service.impl;

import java.util.List;

import com.zjy.bean.Customer;
import com.zjy.bean.Major;
import com.zjy.bean.Student;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IMajorDao;
import com.zjy.dao.IStudentDao;
import com.zjy.service.IMajorService;
import com.zjy.service.IStudentService;

public class MajorServiceImpl implements IMajorService{
	private IMajorDao majorDao;
	public IMajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	@Override
	public void delete(Major c) {
		// TODO Auto-generated method stub
		this.majorDao.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.majorDao.delete(id);
	}

	@Override
	public Major findById(int id) {
		// TODO Auto-generated method stub
		return this.majorDao.findById(id);
	}

	@Override
	public List<Major> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Major c) {
		// TODO Auto-generated method stub
		this.majorDao.save(c);
	}

	@Override
	public void update(Major c) {
		// TODO Auto-generated method stub
		this.majorDao.update(c);
	}
	

}
