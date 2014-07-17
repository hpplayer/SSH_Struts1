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

public class TeacherCheckStudentScore extends Action{
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
		String classidstring=request.getParameter("classid");
		int classid=Integer.parseInt(classidstring);
		service.ApplyUpload(classid);
		List<Classes> classlist=service.getClassByTacherId(st.getId());
		// 该语句用来通过委托Customer对象的delete方法来删除编号所对应的记录
		//System.out.println(changepassForm.getPassword2());
		//st.setPwd(changepassForm.getPassword2());
		//service.update(st);
		// 该语句用来获取会话中所绑定的分页编号
		request.setAttribute("classlist", classlist);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("teacherclasses");
	}

}
