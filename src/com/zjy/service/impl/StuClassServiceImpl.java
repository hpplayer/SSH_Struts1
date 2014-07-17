package com.zjy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.zjy.bean.Classes;
import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IClassDao;
import com.zjy.dao.IStuClassDao;
import com.zjy.dao.IStudentDao;
import com.zjy.service.IStuClassService;
import com.zjy.service.IStudentService;
import com.zjy.vo.StudentScore;

public class StuClassServiceImpl implements IStuClassService{
	private IStuClassDao stuclassDao;
	private IStudentDao studentDao;
	private IClassDao classDao;
	
	

	public IStudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public IClassDao getClassDao() {
		return classDao;
	}

	public void setClassDao(IClassDao classDao) {
		this.classDao = classDao;
	}




	@Override
	public void delete(Stuclass c) {
		// TODO Auto-generated method stub
		this.stuclassDao.delete(c);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		this.stuclassDao.delete(id);
	}

	@Override
	public Stuclass findById(int id) {
		// TODO Auto-generated method stub
		return this.findById(id);
	}

	@Override
	public List<Stuclass> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Stuclass c) {
		// TODO Auto-generated method stub
		this.stuclassDao.save(c);
	}

	@Override
	public void update(Stuclass c) {
		// TODO Auto-generated method stub
		this.stuclassDao.update(c);
	}

	@Override
	public List<StudentScore> getAllScoreByStudentId(int studentid) {
		// TODO Auto-generated method stub
		List<Stuclass> stuclass=this.stuclassDao.getAllStuclassByStudentID(studentid);
		List<StudentScore> studentscore=new ArrayList<StudentScore>();
		if(stuclass==null||stuclass.size()<=0)
			return null;
		else
		{
			for(Stuclass st:stuclass)
			{
				StudentScore ss=new StudentScore();
				ss.setClassid(st.getClassID());
				Student stu=this.studentDao.findById(st.getStuID());
				Classes cl= this.classDao.findById(st.getClassID());
				ss.setClassname(cl.getClassname());
				ss.setGrade(st.getGrade());
				ss.setScore(st.getScore());
				ss.setStudentid(st.getStuID());
				ss.setStudentname(stu.getName());
				studentscore.add(ss);
			}
		}
		return studentscore;
	}

	@Override
	public List<StudentScore> getClassScoreByClassId(int classid) {
		// TODO Auto-generated method stub
		List<Stuclass> stuclass=this.stuclassDao.getStudentsByClassId(classid);
		List<StudentScore> studentscore=new ArrayList<StudentScore>();
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
				StudentScore ss=new StudentScore();
				ss.setClassid(st.getClassID());
				ss.setClassname(cl.getClassname());
				ss.setGrade(st.getGrade());
				ss.setScore(st.getScore());
				ss.setStudentid(st.getStuID());
				ss.setStudentname(stu.getName());
				studentscore.add(ss);
			}
		}
		return studentscore;
	}

	@Override
	public List<StudentScore> getCurrentScoreByStudentId(int studentid) {
		// TODO Auto-generated method stub
		List<Stuclass> stuclass=this.stuclassDao.getAllStuclassByStudentID(studentid);
		List<StudentScore> studentscore=new ArrayList<StudentScore>();
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
				StudentScore ss=new StudentScore();
				ss.setClassid(st.getClassID());
				ss.setClassname(cl.getClassname());
				ss.setGrade(st.getGrade());
				ss.setScore(st.getScore());
				ss.setStudentid(st.getStuID());
				ss.setStudentname(stu.getName());
				studentscore.add(ss);
			}
		}
		return studentscore;
	}

	public IStuClassDao getStuclassDao() {
		return stuclassDao;
	}

	public void setStuclassDao(IStuClassDao stuclassDao) {
		this.stuclassDao = stuclassDao;
	}
	
}
