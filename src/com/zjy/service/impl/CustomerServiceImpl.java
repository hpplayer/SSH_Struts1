package com.zjy.service.impl;

import java.util.List;

import com.zjy.bean.Customer;
import com.zjy.dao.CustomerDao;
import com.zjy.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	//该语句用来声明一个属性，该属性的类型为CustomerDao,
	//对于CustomerDao类是专门用来负责对数据库中的表的增删改查操作，以及分页操作
    private CustomerDao customerDao;
    //该方法用来获取CustomerDao的对象
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	//该方法用来设置CustomerDao对象
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//该方法用来根据外界所传递来Customer对象，并检查该对象中的用户名和密码在数据库是否存在
	public boolean checkLogin(Customer c) {
		//该语句用来通过委托CustomerDao类的对象来查找所给定的用户名和密码是否存在
		Customer ccc=customerDao.findByNameAndPass(c.getUsername(),c.getPassword());
		return ccc==null?false:true;
	}
	//该方法用来删除Customer对象
	public void delete(Customer c) {
		//该语句用来通过委托CustomerDao类的对象来完成删除外界所给定的对象
		this.customerDao.delete(c);
	}
	//该方法用来删除外界所传递过来id所有对应的记录
	public void delete(int id) {
		//该语句用来通过委托CustomerDao类的对象来完成删除外界所传递过来id所有对应的记录
	    this.customerDao.delete(id);
	}
	//该方法用来查找外界所传递过来的id所对应的记录，并封装到对象中去
	public Customer findById(int id) {
		//该语句用来通过委托CustomerDao类的对象外界所传递过来的id,所对应的记录，并以对象方式返回
		return this.customerDao.findById(id);
	}
	//该方法用来外界所传递过来的分页编号，并返回该分页编号的内容，并以List对象的形式返回
	public List<Customer> getPage(int pageId) {
		//该语句用来通过委托CustomerDao对象来获取外界所传递过来的分页编号,所对应的分页的内容
		return this.customerDao.getPage(pageId);
	}
	//该方法用来保存Customer对象
	public void save(Customer c) {
		//该语句用来通过委托CustomerDao对象来完成保存操作
		this.customerDao.save(c);
	}
	//该方法用来更新Customer对象
	public void update(Customer c) {
		//该语句用来通过委托CustomerDao对象来完成更新操作
		this.customerDao.update(c);
	}
}
