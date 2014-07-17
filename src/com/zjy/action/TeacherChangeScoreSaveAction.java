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

import com.zjy.bean.Teacher;
import com.zjy.form.LoginForm;
import com.zjy.form.NewScoreForm;
import com.zjy.service.IClassService;
import com.zjy.service.IStuClassService;
import com.zjy.service.ITeacherService;
import com.zjy.util.WebUtil;
import com.zjy.vo.StudentScore;

public class TeacherChangeScoreSaveAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Teacher st = (Teacher)session.getAttribute( "teacher");
		 request.setCharacterEncoding("UTF-8");
		ServletContext sc = session.getServletContext();
		IClassService service = WebUtil.getClassService(sc);
		IStuClassService service1=WebUtil.getStuClassService(sc);
		ITeacherService service2=WebUtil.getTeacherService(sc);
		NewScoreForm scoreform=(NewScoreForm)form;
		
		
		String classidstring=request.getParameter("classid");
		int classid=Integer.parseInt(classidstring);
		String studentidstring = request.getParameter("studentid");
		int studentid=Integer.parseInt(studentidstring);
		String gradestring=request.getParameter("studentid");
		int grade=Integer.parseInt(gradestring);
		System.out.println("save"+classid);
		System.out.println("save"+studentid);
		System.out.println("save"+grade);
		System.out.println("save"+scoreform.getNewscore());
		int newscore=Integer.parseInt(scoreform.getNewscore());

		service2.changeScoreByStudentIdAndClassId(classid,studentid,newscore);

		List<StudentScore> studentscorelist=service1.getClassScoreByClassId(classid);
		
		// 该语句用来通过委托Customer对象的delete方法来删除编号所对应的记录
		//System.out.println(changepassForm.getPassword2());
		//st.setPwd(changepassForm.getPassword2());
		//service.update(st);
		// 该语句用来获取会话中所绑定的分页编号
		request.setAttribute("studentscorelist", studentscorelist);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("teachergetclassscore");
	}
}