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
import com.zjy.service.IStuClassService;
import com.zjy.util.WebUtil;
import com.zjy.vo.StudentScore;

public class TeacherGetClassScoreAction extends Action{
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
		IStuClassService stuclassService=WebUtil.getStuClassService(sc);
		//System.out.println(classid);
//		String[] classids = request.getParameterValues("classid");
//		for(int i=0;i<classids.length;i++)
//		{
//			System.out.println(classids[i]);
//		}
//		for(int i=0;i<classids.length;i++)
//		{
//			System.out.println(classids[i] );
//			if(classids[i]!=null&&classids[i].length()>0&&!classids[i].equals("0"))
//			{
//				service.ApplyUpload(Integer.parseInt(classids[i]));
//				break;
//			}
//		}		
		String classidstring=request.getParameter("classid");
		System.out.println("classId:"+classidstring);
		int classid=Integer.parseInt(classidstring);
		System.out.println(classid);
		List<StudentScore> studentscorelist=stuclassService.getClassScoreByClassId(classid);
			
		// 该语句用来通过委托Customer对象的delete方法来删除编号所对应的记录
		//System.out.println(changepassForm.getPassword2());
		//st.setPwd(changepassForm.getPassword2());
		//service.update(st);
		// 该语句用来获取会话中所绑定的分页编号
		request.setAttribute("studentscorelist", studentscorelist);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("getClassScore");
	}

}