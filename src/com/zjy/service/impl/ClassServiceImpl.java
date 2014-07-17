package com.zjy.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.zjy.bean.Classes;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IClassDao;
import com.zjy.dao.IStudentDao;
import com.zjy.dao.ITeacherDao;
import com.zjy.service.IClassService;
import com.zjy.service.IStudentService;
import com.zjy.vo.WaitingClass;

public class ClassServiceImpl implements IClassService{
	private IClassDao classDao;
	private ITeacherDao teacherDao;
	public ITeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public IClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(IClassDao classDao) {
		this.classDao = classDao;
	}

	@Override
	public void delete(Classes c) {
		// TODO Auto-generated method stub
		this.classDao.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.classDao.delete(id);
	}

	@Override
	public Classes findById(int id) {
		// TODO Auto-generated method stub
		return this.classDao.findById(id);
	}

	@Override
	public List<Classes> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Classes c) {
		// TODO Auto-generated method stub
		this.classDao.save(c);
	}

	@Override
	public void update(Classes c) {
		// TODO Auto-generated method stub
		this.classDao.update(c);
	}

	@Override
	public void AgreeUpload(int classid) {
		// TODO Auto-generated method stub
		this.classDao.AgreeApply(classid);
		
	}

	@Override
	public void ApplyUpload(int classid) {
		// TODO Auto-generated method stub
		this.classDao.ApplyUploadScore(classid);
	}

	@Override
	public void RefuseUpload(int classid) {
		// TODO Auto-generated method stub
		this.classDao.RefuseApply(classid);
		
	}

	@Override
	public List<WaitingClass> getAllWaitingClass() {
		// TODO Auto-generated method stub
		List<Classes> clalist=this.classDao.getAllWaitingClass();
		if(clalist==null||clalist.size()<=0)
			return null;
		List<WaitingClass> wclist=new ArrayList<WaitingClass>();
		for(Classes cla:clalist)
		{
			WaitingClass wc=new WaitingClass();
			Teacher t=teacherDao.findById(cla.getTeacherID());
			Classes c=this.classDao.findById(cla.getClassid());
			wc.setCanupload(cla.getCanupload());
			wc.setClassid(cla.getClassid());
			wc.setClassname(c.getClassname());
			wc.setTeacherid(cla.getTeacherID());
			wc.setTeachername(t.getName());
			wclist.add(wc);
		}
		return wclist;
		
	}

	@Override
	public List<Classes> getClassByTacherId(int teacherid) {
		// TODO Auto-generated method stub
		return this.classDao.getClassByTeacherId(teacherid);
		
	}
	
	

}
