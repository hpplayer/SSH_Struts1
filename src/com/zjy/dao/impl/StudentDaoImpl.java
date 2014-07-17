package com.zjy.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.zjy.bean.Customer;
import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;
import com.zjy.dao.BaseDao;
import com.zjy.dao.IAdminDao;
import com.zjy.dao.IStuClassDao;
import com.zjy.dao.IStudentDao;

public class StudentDaoImpl extends BaseDao implements IStudentDao {
	private IStuClassDao stuclassDao;
	public IStuClassDao getStuclassDao() {
		return stuclassDao;
	}

	public void setStuclassDao(IStuClassDao stuclassDao) {
		this.stuclassDao = stuclassDao;
	}

	@Override
	public void delete(Student a) {
		// TODO Auto-generated method stub
		super.delete(a);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Student c=findById(id);
		//该语句用来删除对象
		super.delete(c);
	}

	@Override
	public Student findById(int id) {
		// TODO Auto-generated method stub
		String hql = "from Student as student where  student.id=?";
		List<Student> list = super.executeQuery(hql, id);
		return list.get(0);
	}

	@Override
	public Student findByNameAndPass(String username, String password) {
		String hql = "from Student as student where  student.name=? and student.pwd=?";
		List<Student> list = super.executeQuery(hql, username,password);
		return list.get(0);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		String hql = "from Student as student";
		List<Student> list = super.executeQuery(hql);
		return list;
	}

	@Override
	public List<Student> getPage(int pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Student a) {
		// TODO Auto-generated method stub
		super.save(a);
		
	}

	@Override
	public void update(Student a) {
		// TODO Auto-generated method stub
		super.update(a);
		
	}

	@Override
	public boolean deleteStudentsByGrade(int studentid) {
		// TODO Auto-generated method stub
		List<Student> studentlist=this.getAllStudentByGrade(4);
		if(studentlist==null||studentlist.size()<=0)
			return true;
		else
		{
			for(Student s:studentlist)
			{
				if(s.getId()==studentid){
				List<Stuclass> stuclasslist= stuclassDao.getAllStuclassByStudentID(s.getId());
				if(stuclasslist!=null&&stuclasslist.size()>0)
				for(Stuclass stu:stuclasslist)
				{
					stuclassDao.delete(stu.getId());
				}
				this.delete(s);
				break;
				}
				else {
					continue;
				}
			}
			return true;
		}
	}

	@Override
	public List<Student> getAllStudentByGrade(int grade) {
		// TODO Auto-generated method stub
		String hql = "from Student as student where  student.grade=?";
		List<Student> list = super.executeQuery(hql,grade);
		return list;
	}

	@Override
	public Student getStudentByStudentName(String studentname) {
		// TODO Auto-generated method stub
		String hql = "from Student as student where  student.name=?";
		List<Student> list = super.executeQuery(hql,studentname);
		return list.get(0);
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		String hql = "from Student as student";
		List<Student> list = super.executeQuery(hql);
		if(list!=null&&list.size()>0)
		{
			for(Student s:list)
			{
				s.setGrade(s.getGrade());
				super.update(s);
			}
		}
		
	}

}
