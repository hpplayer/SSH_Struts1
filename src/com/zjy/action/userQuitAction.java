package com.zjy.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zjy.bean.Admin;
import com.zjy.form.ChangePassForm;
import com.zjy.service.IAdminService;
import com.zjy.util.WebUtil;

public class userQuitAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		session. removeAttribute("admin");
		session. removeAttribute("student");
		session. removeAttribute("teacher");
		//Admin st = (Admin)session.getAttribute( "admin");
		 request.setCharacterEncoding("UTF-8");
		 
		// 该语句用来获取会话中所绑定的分页编号
		//request.setAttribute("stulist", stulist);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("userlogin");
	}
}