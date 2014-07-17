package com.zjy.action;

import java.io.File;
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
import com.zjy.bean.Student;
import com.zjy.form.ExcelForm;
import com.zjy.service.IClassService;
import com.zjy.service.IStudentService;
import com.zjy.util.WebUtil;
import com.zjy.vo.WaitingClass;

import jxl.*;

public class ExcelProcessAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ExcelForm ef=(ExcelForm)form;
		String filename = ef.getExcelFilePath();
		System.out.println("filename"+filename);
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		IStudentService service = WebUtil.getStudentService(sc);
		
		if (filename != null && !filename.equals("")) {

			try {
				filename = filename.replaceAll("\\\\", "\\\\\\\\");
				Workbook rwb = Workbook.getWorkbook(new File(filename));
				Sheet rs = rwb.getSheet(0);

				for (int i = 0; i < rs.getRows(); i++) {
					Cell[] cell = rs.getRow(i);
					
					String col_1 = cell[0].getContents();
					String col_2 = cell[1].getContents();
					String col_3 = cell[2].getContents();
					String col_4 = cell[3].getContents();
					String col_5 = cell[4].getContents();
					
					Student st=new Student();
					st.setName(col_1);
					st.setPwd(col_2);
					st.setHomeAdd(col_3);
					st.setMajorID(Integer.parseInt(col_4));						
					st.setGrade(Integer.parseInt(col_5));
					service.save(st);					
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		request.setAttribute("message","上傳成功！");
		return mapping.findForward("loadExcelOver");
	}
}