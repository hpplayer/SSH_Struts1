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
import com.zjy.service.IClassService;
import com.zjy.util.WebUtil;
import com.zjy.vo.WaitingClass;

public class AdminProcessApplyAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Admin st = (Admin)session.getAttribute( "admin");
		 request.setCharacterEncoding("UTF-8");
		 //ChangePassForm changepassForm=(ChangePassForm)form;
		// 该语句用来通过HttpSession对象来获取ServletContext对象
		 int classid=Integer.parseInt(request.getParameter("classid"));
		 String result=request.getParameter("result");
		 
		ServletContext sc = session.getServletContext();
		IClassService service = WebUtil.getClassService(sc);
		
		if(result.equals("yes"))
		{
			service.AgreeUpload(classid);
		}
		else {
			service.RefuseUpload(classid);
		}
		List<WaitingClass> list= service.getAllWaitingClass();
		request.setAttribute("waitinglist",list);
		return mapping.findForward("waitingpage");
	}
}