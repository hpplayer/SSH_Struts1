package com.zjy.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjy.bean.Customer;
import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.dao.CustomerDao;
import com.zjy.dao.IClassDao;
import com.zjy.dao.IStuClassDao;
import com.zjy.dao.IStudentDao;
import com.zjy.dao.ITeacherDao;
import com.zjy.service.IClassService;
import com.zjy.service.IStuClassService;
import com.zjy.service.IStudentService;
import com.zjy.vo.StudentScore;
import com.zjy.vo.WaitingClass;

import junit.framework.TestCase;

public class StudentDaoTest  extends TestCase{
	private ApplicationContext context;
	private IStudentDao dao;
	private ITeacherDao teacherdao;
	private IStuClassService stuclassService;
	private IClassDao classDao;
	private IStudentService studentService;
	private IStuClassDao stuclassDao;
	private IClassService classService;
	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (IStudentDao) context.getBean("studentDao");
		teacherdao=(ITeacherDao) context.getBean("teacherDao");
		stuclassService = (IStuClassService)context.getBean("stuclassService");
		classDao = (IClassDao)context.getBean("classDao");
		studentService = (IStudentService)context.getBean("studentService");
		stuclassDao = (IStuClassDao)context.getBean("stuclassDao");
		classService = (IClassService)context.getBean("classService");
		
	}
//	public void testSave() {
//		Student c=new Student();	
//		c.setName("kkk");
//		c.setPwd("kkk");
//		c.setHomeAdd("kkk");
//		c.setMajorID(1);
//		c.setGrade(1);
//		dao.save(c);
//	}
//	public void testdelete() {
//		// TODO Auto-generated method stub
//		dao.delete(3);
//	}
//	public void testfind()
//	{
//		Student s=dao.findById(1);
//		System.out.println(s.getName());
//	}
//	public void testfindByNameAndPass()
//	{
//		Student s=dao.findByNameAndPass("zc", "123456");
//		System.out.println(s.getHomeAdd());
//	}
//	public void testgetAllStudent()
//	{
//		List<Student> s=dao.getAllStudent();
//		System.out.println(s.size());
//	}
//	public void testTeacher()
//	{
//		Teacher t=this.teacherdao.findByNameAndPass("榛勫悜闃�","1");
//		System.out.println(t.getName());
//	}
//	public void testService()
//	{
//		List<StudentScore> stulist= stuclassService.getCurrentScoreByStudentId(1);
//		
//	}
//	public void testService2()
//	{
//		List<StudentScore> stulist= stuclassService.getAllScoreByStudentId(1);
//		System.out.print(stulist.get(0).getStudentname());
//		System.out.print(stulist.size());
//	}
//	public void testClassDao()
//	{
//		classDao.findById(1);
//	}
//	public void testStudentservice()
//	{
//		Student t= studentService.findById(4);
//		t.setPwd("1");
//		studentService.update(t);
//	}
//	public void testStuservice()
//	{
//		List<StudentScore> studentscorelist=stuclassService.getClassScoreByClassId(1);
//		
//		List<Stuclass> list= stuclassDao.getStudentsByClassId(1);
//		System.out.println(list.size());
//	}
//	public void testClassService()
//	{
//		
//		List<WaitingClass> list= this.classService.getAllWaitingClass();
//		System.out.println(list.size());
//	}
	public void testStudentService()
	{
		Student st=new Student();
		st.setName("a2");
		st.setPwd("a2");
		st.setHomeAdd("a2");
		st.setMajorID(Integer.parseInt("22"));						
		st.setGrade(Integer.parseInt("22"));
		studentService.save(st);
	}
}
