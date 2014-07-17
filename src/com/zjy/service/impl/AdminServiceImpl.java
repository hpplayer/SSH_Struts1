package com.zjy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zjy.bean.Admin;
import com.zjy.bean.Major;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IAdminDao;
import com.zjy.dao.IMajorDao;
import com.zjy.dao.IStudentDao;
import com.zjy.dao.ITeacherDao;
import com.zjy.service.IAdminService;
import com.zjy.service.IStudentService;
import com.zjy.vo.StudentByGrade;

public class AdminServiceImpl implements IAdminService{
	private IAdminDao adminDao;
	private IStudentDao studentDao;
	private ITeacherDao teacherDao;
	private IMajorDao majorDao;

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public ITeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public IMajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public IAdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public boolean checkLogin(Admin c) {
		// TODO Auto-generated method stub
		Admin s=this.adminDao.findByNameAndPass(c.getName(), c.getPwd());
		if(s==null)
			return false;
		else 
			return true;
	}

	@Override
	public void delete(Admin c) {
		// TODO Auto-generated method stub
		this.adminDao.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.adminDao.delete(id);
	}

	@Override
	public Admin findById(int id) {
		// TODO Auto-generated method stub
		return this.adminDao.findById(id);
	}

	@Override
	public List<Admin> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Admin c) {
		// TODO Auto-generated method stub
		this.adminDao.save(c);
	}

	@Override
	public void update(Admin c) {
		// TODO Auto-generated method stub
		this.adminDao.update(c);
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return this.studentDao.getAllStudent();
		
	}

	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return this.teacherDao.getAllTeacher();
	}

	@Override
	public boolean deleteStudentsByGrade(int grade) {
		// TODO Auto-generated method stub
		return this.studentDao.deleteStudentsByGrade(grade);
	}

	@Override
	public List<StudentByGrade> getAllStudentByGrade(int grade) {
		// TODO Auto-generated method stub
		List<Student> studentlist = this.studentDao.getAllStudentByGrade(grade);
		List<StudentByGrade> sbglist= new ArrayList<StudentByGrade>();
		if(studentlist==null||studentlist.size()<=0)
			return null;
		else
		{
			for(Student s:studentlist)
			{
				StudentByGrade sbg=new StudentByGrade();
				sbg.setGrade(s.getGrade());
				sbg.setMajorID(s.getMajorID());
				Major m=this.majorDao.findById(s.getMajorID());
				sbg.setMajorname(m.getMajorname());
				sbg.setStudentid(s.getId());
				sbg.setStudentname(s.getName());
				sbglist.add(sbg);
			}
			return sbglist;
			
		}
		
	}

	@Override
	public Admin getAdminByAdminName(String adminname) {
		// TODO Auto-generated method stub
		return this.adminDao.getAdminByAdminName(adminname);
	}

	

}
