package com.zjy.service.impl;

import java.util.ArrayList;
import java.util.List;


import com.zjy.bean.Classes;
import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IClassDao;
import com.zjy.dao.IStuClassDao;
import com.zjy.dao.IStudentDao;
import com.zjy.dao.ITeacherDao;
import com.zjy.service.IStudentService;
import com.zjy.service.ITeacherService;
import com.zjy.vo.StudentListByClass;
import com.zjy.vo.StudentScore;

public class TeacherServiceImpl implements ITeacherService{
	private ITeacherDao teacherDao;
	private IStuClassDao stuclassDao;
	private IStudentDao studentDao;
	private IClassDao classDao;
	
	public IClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(IClassDao classDao) {
		this.classDao = classDao;
	}

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public IStuClassDao getStuclassDao() {
		return stuclassDao;
	}

	public void setStuclassDao(IStuClassDao stuclassDao) {
		this.stuclassDao = stuclassDao;
	}

	public ITeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(ITeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}



	@Override
	public boolean checkLogin(Teacher c) {
		// TODO Auto-generated method stub
		Teacher s=this.teacherDao.findByNameAndPass(c.getName(), c.getPwd());
		if(s==null)
			return false;
		else 
			return true;
	}

	@Override
	public void delete(Teacher c) {
		// TODO Auto-generated method stub
		this.teacherDao.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.teacherDao.delete(id);
	}

	@Override
	public Teacher findById(int id) {
		// TODO Auto-generated method stub
		return this.teacherDao.findById(id);
	}

	@Override
	public List<Teacher> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Teacher c) {
		// TODO Auto-generated method stub
		this.teacherDao.save(c);
	}

	@Override
	public void update(Teacher c) {
		// TODO Auto-generated method stub
		this.teacherDao.update(c);
	}

	@Override
	public boolean changeScoreByStudentIdAndClassId(int studentid, int classid,
			int score) {
		// TODO Auto-generated method stub
		Student st=this.studentDao.findById(studentid);
		Stuclass sc=this.stuclassDao.getStuclassbyStudentIdAndClassIdAndGrade(studentid,classid,st.getGrade());
		sc.setScore(score);
		this.stuclassDao.update(sc);
		return true;
		
	}

	@Override
	public List<StudentListByClass> getStudentsByClassId(int classid) {
		List<Stuclass> stuclass=this.stuclassDao.getStudentsByClassId(classid);
		List<StudentListByClass> slbc=new ArrayList<StudentListByClass>();
		if(stuclass==null||stuclass.size()<=0)
			return null;
		else
		{
			for(Stuclass st:stuclass)
			{
				Student stu=this.studentDao.findById(st.getStuID());
				Classes cl= this.classDao.findById(st.getClassID());
				if(stu.getGrade()!=st.getGrade())
				{
					continue;
				}
				StudentListByClass ss=new StudentListByClass();
				ss.setClassid(st.getClassID());
				ss.setClassname(cl.getClassname());
				ss.setGrade(st.getGrade());
				ss.setScore(st.getScore());
				ss.setStudentid(st.getStuID());
				ss.setStudentname(stu.getName());
				slbc.add(ss);
			}
		}
		return slbc;
	}

	@Override
	public Teacher getTeacherByTeacherName(String tachername) {
		// TODO Auto-generated method stub
		return this.teacherDao.getTeacherByTeacherName(tachername);
	}
	
}
