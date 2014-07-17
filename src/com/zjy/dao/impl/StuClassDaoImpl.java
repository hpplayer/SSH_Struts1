package com.zjy.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zjy.bean.Major;
import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;
import com.zjy.dao.BaseDao;
import com.zjy.dao.IAdminDao;
import com.zjy.dao.IStuClassDao;

public class StuClassDaoImpl extends BaseDao implements IStuClassDao {

	@Override
	public void delete(Stuclass a) {
		// TODO Auto-generated method stub
		super.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Stuclass a=findById(id);
		super.delete(a);
		
	}

	@Override
	public Stuclass findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.id=?";
		List<Stuclass> list = super.executeQuery(hql, id);
		return list.get(0);
	}

	@Override
	public List<Stuclass> getAllStuclass() {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass";
		List<Stuclass> list = super.executeQuery(hql);
		return list;
	}

	@Override
	public List<Stuclass> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Stuclass a) {
		// TODO Auto-generated method stub
		super.save(a);
	}

	@Override
	public void update(Stuclass a) {
		// TODO Auto-generated method stub
		super.update(a);
	}

	@Override
	public List<Stuclass> getAllStuclassByStudentID(int studentid) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.stuID=?";
		List<Stuclass> list = super.executeQuery(hql, studentid);
		return list;
	}

	@Override
	public List<Stuclass> getCurrentStuclassByStudentId(Student s) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.stuID=? and stuclass.grade=?";
		List<Stuclass> list = super.executeQuery(hql, s.getId(),s.getGrade());
		return list;
	}

	@Override
	public List<Stuclass> getScoreByStudentIdAndGrade(int studentid,
			int grade) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.stuID=? and stuclass.grade=?";
		List<Stuclass> list = super.executeQuery(hql, studentid,grade);
		return list;
	}

	@Override
	public List<Stuclass> getStudentsByClassId(int classid) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.classID=?";
		List<Stuclass> list = super.executeQuery(hql,classid);
		return list;
	}

	@Override
	public List<Stuclass> getStuclassListByStudentIDAndGrade(String studentid,
			String grade) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.stuID=? and stuclass.grade=?";
		List<Stuclass> list = super.executeQuery(hql, studentid,grade);
		return list;
	}

	@Override
	public boolean deleteStuclassByStudentId(int studentid) {
		// TODO Auto-generated method stub
		List<Stuclass> stuclassList=this.getAllStuclassByStudentID(studentid);
		if(stuclassList==null||stuclassList.size()<=0)
			return true;
		else{
			for(Stuclass s:stuclassList)
			{
				this.delete(s);
			}
			return true;
		}
	}

	@Override
	public Stuclass getStuclassbyStudentIdAndClassIdAndGrade(int studentid,
			int classid, int grade) {
		// TODO Auto-generated method stub
		String hql = "from Stuclass as stuclass where  stuclass.stuID=? and stuclass.grade=? and stuclass.classID=?";
		List<Stuclass> list = super.executeQuery(hql, studentid,grade,classid);
		return list.get(0);
	}



}
