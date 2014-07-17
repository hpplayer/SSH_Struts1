package com.zjy.util;

import com.zjy.bean.Admin;
import com.zjy.bean.Customer;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.form.InsertForm;
import com.zjy.form.LoginForm;
import com.zjy.form.NewLoginForm;
import com.zjy.form.UpdateForm;
//该类用来把表单对象转换成值对象
public class FormBeanToVoUtil {
	//该方法用来把LoginForm表单对象转换成Customer对象
	 public static Customer convertToVo(LoginForm form){
		 Customer c=new Customer();
		 System.out.println(form.getId()+"yujianbo");
		 c.setId(form.getId());
		 c.setUsername(form.getUsername());
		 c.setPassword(form.getPassword());
		 return c;
	 }
	//该方法用来把UpdateForm表单对象转换成Customer对象
     public static Customer convertToVo(UpdateForm form){
    	 Customer c=new Customer();
		 c.setId(form.getId());
		 c.setUsername(form.getUsername());
		 c.setPassword(form.getPassword());
		 return c;
     }
   //该方法用来把InsertForm表单对象转换成Customer对象
     public static Customer convertToVo(InsertForm form){
    	 Customer c=new Customer();
		 c.setUsername(form.getUsername());
		 c.setPassword(form.getPassword());
		 return c;
     }
     public static Student convertToVo(NewLoginForm form)
     {
    	 Student s=new Student();
    	 s.setName(form.getUsername());
    	 s.setPwd(form.getPassword());
    	 return s;
     }
     public static Teacher convertToVoTeacher(NewLoginForm form)
     {
    	 Teacher s=new Teacher();
    	 s.setName(form.getUsername());
    	 s.setPwd(form.getPassword());
    	 return s;
     }
     public static Admin convertToVoAdmin(NewLoginForm form)
     {
    	 Admin s=new Admin();
    	 s.setName(form.getUsername());
    	 s.setPwd(form.getPassword());
    	 return s;
     }
	
 
}
