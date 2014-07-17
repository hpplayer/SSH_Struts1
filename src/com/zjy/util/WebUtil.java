package com.zjy.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zjy.service.CustomerService;
import com.zjy.service.IAdminService;
import com.zjy.service.IClassService;
import com.zjy.service.IMajorService;
import com.zjy.service.IStuClassService;
import com.zjy.service.IStudentService;
import com.zjy.service.ITeacherService;

public class WebUtil {
	//该方法用来获取获取在applicationContext.xml配置文件中所配置的customerService对象
	public static CustomerService getCustomerService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (CustomerService)context.getBean("customerService");
	}
	public static IStudentService getStudentService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (IStudentService)context.getBean("studentService");
	}
	public static ITeacherService getTeacherService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (ITeacherService)context.getBean("teacherService");
	}
	public static IAdminService getAdminService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (IAdminService)context.getBean("adminService");
	}
	public static IStuClassService getStuClassService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (IStuClassService)context.getBean("stuclassService");
	}
	public static IMajorService getMajorService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (IMajorService)context.getBean("majorService");
	}
	public static IClassService getClassService(ServletContext sc){
		WebApplicationContext context=WebApplicationContextUtils.getWebApplicationContext(sc);
		return (IClassService)context.getBean("classService");
	}
}
