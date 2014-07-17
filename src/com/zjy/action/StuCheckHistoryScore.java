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

import com.zjy.bean.Student;
import com.zjy.service.IStuClassService;
import com.zjy.util.WebUtil;
import com.zjy.vo.StudentScore;

public class StuCheckHistoryScore extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Student st = (Student)session.getAttribute( "student");
		System.out.println("st.getName():"+st.getName());
		// 该语句用来通过HttpSession对象来获取ServletContext对象
		ServletContext sc = session.getServletContext();
		// 该语句用来通过WebUtil的getCustomerService静态方法，来获取CustomerService
		IStuClassService service = WebUtil.getStuClassService(sc);
		// 该语句用来通过委托Customer对象的delete方法来删除编号所对应的记录
		List<StudentScore> stulist= service.getAllScoreByStudentId(st.getId());
		
		// 该语句用来获取会话中所绑定的分页编号
		request.setAttribute("stulist", stulist);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("allScore");
	}
}
