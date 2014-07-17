package com.zjy.test;

import java.util.List;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zjy.bean.Customer;
import com.zjy.dao.CustomerDao;

public class CustomerDaoTest extends TestCase {
	private ApplicationContext context;
	private CustomerDao dao;
	protected void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		dao = (CustomerDao) context.getBean("customerDao");
	}
	public void testSave() {
		Customer c=new Customer();
		c.setPassword("kkk");
		c.setUsername("kkk");
		//dao.save(c);
	}
	public void testUpdate(){
		/*Customer c=dao.findById(27);
		c.setUsername("hhh");
		c.setPassword("hhh");
		dao.update(c);*/
	}
	public void testDeleteById(){
		//dao.delete(27);
	}
	public void testDeleteByCustomer(){
	/*	Customer c=dao.findById(27);
		dao.delete(c);*/
	}
	public void testPage() {
		
		List<Customer> list = dao.getPage(2);
		for (Customer c : list) {
			System.out.println(c.getId());
		}
	}
	public void testFindByNameAndPass(){
		Customer c=dao.findByNameAndPass("zc","123456");
		System.out.println(c.getId());
	}
}
