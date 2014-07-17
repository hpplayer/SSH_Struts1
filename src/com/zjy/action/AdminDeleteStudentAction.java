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

import com.zjy.bean.Admin;
import com.zjy.service.IStudentService;
import com.zjy.util.WebUtil;
import com.zjy.vo.StudentByGrade;

public class AdminDeleteStudentAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Admin st = (Admin)session.getAttribute( "admin");
		 request.setCharacterEncoding("UTF-8");
		 int studentid=Integer.parseInt(request.getParameter("studentid"));
		 //ChangePassForm changepassForm=(ChangePassForm)form;
		// 该语句用来通过HttpSession对象来获取ServletContext对象
		ServletContext sc = session.getServletContext();
		IStudentService service = WebUtil.getStudentService(sc);
		service.deleteStudentByGrade(studentid);
		List<StudentByGrade> list= service.getAllGraduate();
		request.setAttribute("waitinglist",list);
		return mapping.findForward("graduatepage");
	}
}
