package com.zjy.action;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.zjy.bean.Stuclass;
import com.zjy.bean.Student;
import com.zjy.form.ExcelForm;
import com.zjy.service.IStuClassService;
import com.zjy.service.IStudentService;
import com.zjy.util.WebUtil;

public class TeacherLoadScoreAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ExcelForm ef=(ExcelForm)form;
		String filename = ef.getExcelFilePath();
		System.out.println("filename"+filename);
		HttpSession session = request.getSession();
		ServletContext sc = session.getServletContext();
		
		IStuClassService service = WebUtil.getStuClassService(sc);
		
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
					
					Stuclass scl=new Stuclass();
					scl.setStuID(Integer.parseInt(col_1));
					scl.setClassID(Integer.parseInt(col_2));
					scl.setGrade(Integer.parseInt(col_3));
					scl.setScore(Integer.parseInt(col_4));						
					service.save(scl);					
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
		request.setAttribute("message","上傳成功！");
		return mapping.findForward("teacherloadExcelOver");
	}
}
