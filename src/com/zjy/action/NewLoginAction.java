package com.zjy.action;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zjy.bean.Admin;
import com.zjy.bean.Customer;
import com.zjy.bean.Student;
import com.zjy.bean.Teacher;
import com.zjy.form.LoginForm;
import com.zjy.form.NewLoginForm;
import com.zjy.service.CustomerService;
import com.zjy.service.IAdminService;
import com.zjy.service.IStudentService;
import com.zjy.service.ITeacherService;
import com.zjy.util.FormBeanToVoUtil;
import com.zjy.util.WebUtil;

public class NewLoginAction extends Action{
	public IStudentService studentService;
	public ITeacherService teacherService;
	public IAdminService adminService;
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 request.setCharacterEncoding("UTF-8");
		NewLoginForm loginForm=(NewLoginForm)form;
		if(loginForm.getSelectPerson().equals("one"))
		{
			Student s=FormBeanToVoUtil.convertToVo(loginForm);
			ServletContext sc=request.getSession().getServletContext();
			this.studentService=WebUtil.getStudentService(sc);
			if(studentService.checkLogin(s))
			{
				Student ss=this.studentService.getStudentByUsername(s.getName());
				HttpSession hs = request.getSession();				
				hs.setAttribute("student",ss);
				return mapping.findForward("studentlogin");
			}
			else {
				return mapping.findForward("failure");
			}
		}
		else if(loginForm.getSelectPerson().equals("two"))
		{
			Teacher s=FormBeanToVoUtil.convertToVoTeacher(loginForm);
			System.out.println(s.getName());
			ServletContext sc=request.getSession().getServletContext();
			this.teacherService=WebUtil.getTeacherService(sc);
			if(teacherService.checkLogin(s))
			{
				Teacher ss=this.teacherService.getTeacherByTeacherName(s.getName());
				HttpSession hs = request.getSession();				
				hs.setAttribute("teacher",ss);
				return mapping.findForward("teacherlogin");

			}
			else {
				return mapping.findForward("failure");
			}
		}
		else
		{
			Admin s=FormBeanToVoUtil.convertToVoAdmin(loginForm);
			ServletContext sc=request.getSession().getServletContext();
			
			this.adminService=WebUtil.getAdminService(sc);
			if(adminService.checkLogin(s))
			{
				
				Admin ss=this.adminService.getAdminByAdminName(s.getName());
				HttpSession hs = request.getSession();				
				hs.setAttribute("admin",ss);
				return mapping.findForward("adminlogin");
			}
			else {
				return mapping.findForward("failure");
			}
		}

		
	}
}
