package com.zjy.dao;

import java.util.List;

import com.zjy.bean.Customer;

public interface CustomerDao {
	//该方法用来保存Customer对象
	public void save(Customer c);
	//该方法用来更新Customer对象
	public void update(Customer c);
	//该方法用来删除Customer对象
	public void delete(Customer c);
	//该方法用来根据外界所传递过来的id,并删除该id所对应的记录
	public void delete(int id);
	//该方法用来根据外界所传递过来的id,并返回该id所相对应的记录，并把记录封装到Customer对象中去
	public Customer findById(int id);
	//该方法用来外界所传递过来的分页编号，并返回该分页编号的内容，并以List对象的形式返回
	public List<Customer> getPage(int pageId);
	//该方法用来根据外界所传递来的用户名和密码，并返回该用户名和密码所相对应的记录，并把记录封装到Customer对象中去
	public Customer findByNameAndPass(String ...con);

}
