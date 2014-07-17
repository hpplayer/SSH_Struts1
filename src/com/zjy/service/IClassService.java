package com.zjy.service;

import java.util.List;

import com.zjy.bean.Customer;
import com.zjy.bean.Student;
import com.zjy.bean.Classes;
import com.zjy.vo.WaitingClass;

public interface IClassService {
	public void save(Classes c);
	//该方法用来更新Customer对象
	public void update(Classes c);
	//该方法用来删除Customer对象
	public void delete(Classes c);
	//该方法用来删除外界所传递过来id所有对应的记录
	public void delete(int id);
	//该方法用来查找外界所传递过来的id所对应的记录，并封装到对象中去
	public Classes findById(int id);
	//该方法用来外界所传递过来的分页编号，并返回该分页编号的内容，并以List对象的形式返回
	public List<Classes> getPage(int pageId);
	//该方法用来根据外界所传递来Customer对象，并检查该对象中的用户名和密码在数据库是否存在
	//public boolean checkLogin(Student c);
	public List<WaitingClass> getAllWaitingClass();
	public void ApplyUpload(int classid);
	public void RefuseUpload(int classid);
	public void AgreeUpload(int classid);
	public List<Classes> getClassByTacherId(int teacherid);
}
