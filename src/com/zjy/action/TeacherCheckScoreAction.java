package com.zjy.action;

import java.util.ArrayList;
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

public class TeacherCheckScoreAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		HttpSession session = request.getSession();
		Teacher st = (Teacher)session.getAttribute( "teacher");
		 request.setCharacterEncoding("UTF-8");
		ServletContext sc = session.getServletContext();
		IClassService service = WebUtil.getClassService(sc);
		IStuClassService service1=WebUtil.getStuClassService(sc);
		List<Classes> classlist=service.getClassByTacherId(st.getId());
		List<StudentScore> retlist=new ArrayList<StudentScore>();
		for(Classes cla:classlist)
		{
			List<StudentScore> studentscorelist=service1.getClassScoreByClassId(cla.getClassid());
			for(StudentScore ss:studentscorelist)
			{
				retlist.add(ss);
			}
		}
		
//		String classidstring=request.getParameter("classid");
//		int classid=Integer.parseInt(classidstring);
//		String studentidstring = request.getParameter("studentid");
//		int studentid=Integer.parseInt(studentidstring);
//		String gradestring=request.getParameter("studentid");
//		int grade=Integer.parseInt(gradestring);
//		
//		
//		
//		
//		
//		System.out.println(classid+":asdf");
//		List<StudentScore> studentscorelist=service1.getClassScoreByClassId(classid);
//		System.out.println(studentscorelist.size()+":tyu");
		request.setAttribute("studentscorelist", retlist);
		
//		for(StudentScore ss:studentscorelist)
//		{
//			if(studentid==ss.getStudentid()&&grade==ss.getGrade())
//			{
//				request.setAttribute("studentscore", ss);
//				break;
//			}
//		}
		
		return mapping.findForward("getClassScore");
	}

}