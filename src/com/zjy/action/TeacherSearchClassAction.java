package com.zjy.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zjy.bean.Classes;
import com.zjy.bean.Teacher;
import com.zjy.service.IClassService;
import com.zjy.util.WebUtil;

public class TeacherSearchClassAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Teacher st = (Teacher)session.getAttribute( "teacher");
		 request.setCharacterEncoding("UTF-8");
		 //ChangePassForm changepassForm=(ChangePassForm)form;
		// 该语句用来通过HttpSession对象来获取ServletContext对象
		ServletContext sc = session.getServletContext();
		// 该语句用来通过WebUtil的getCustomerService静态方法，来获取CustomerService
		IClassService service = WebUtil.getClassService(sc);
		List<Classes> classlist=service.getClassByTacherId(st.getId());
		request.setAttribute("classlist", classlist);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("teacherclasses");
	}

}
