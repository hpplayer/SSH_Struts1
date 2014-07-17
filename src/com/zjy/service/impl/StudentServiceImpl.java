package com.zjy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zjy.bean.Major;
import com.zjy.bean.Student;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IMajorDao;
import com.zjy.dao.IStudentDao;
import com.zjy.service.IStudentService;
import com.zjy.vo.StudentByGrade;

public class StudentServiceImpl implements IStudentService{
	private IStudentDao studentDao;
	private IMajorDao majorDao;
	public IMajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(IMajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public boolean checkLogin(Student c) {
		// TODO Auto-generated method stub
		Student s=this.studentDao.findByNameAndPass(c.getName(), c.getPwd());
		if(s==null)
			return false;
		else 
			return true;
	}

	@Override
	public void delete(Student c) {
		// TODO Auto-generated method stub
		this.studentDao.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.studentDao.delete(id);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		return this.studentDao.findById(id);
	}

	@Override
	public List<Student> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Student c) {
		// TODO Auto-generated method stub
		this.studentDao.save(c);
	}

	@Override
	public void update(Student c) {
		// TODO Auto-generated method stub
		this.studentDao.update(c);
	}

	@Override
	public Student getStudentByUsername(String username) {
		// TODO Auto-generated method stub
		return this.studentDao.getStudentByStudentName(username);
	}

	@Override
	public void deleteStudentByGrade(int studentid) {
		// TODO Auto-generated method stub
		this.studentDao.deleteStudentsByGrade(studentid);
		
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		this.studentDao.upgrade();
	}

	@Override
	public List<StudentByGrade> getAllGraduate() {
		// TODO Auto-generated method stub
		List<Student> list=this.studentDao.getAllStudentByGrade(4);
		List<StudentByGrade> retlist=new ArrayList<StudentByGrade>();
		if(list!=null&&list.size()>0)
		{
			for(Student s:list)
			{
				StudentByGrade sbg=new StudentByGrade();
				sbg.setStudentid(s.getId());
				sbg.setStudentname(s.getName());
				sbg.setMajorID(s.getMajorID());
				Major m=majorDao.findById(s.getMajorID());
				sbg.setMajorname(m.getMajorname());
				sbg.setGrade(s.getGrade());
				retlist.add(sbg);
			}
		}
		return retlist;
		
	}

}
