package com.zjy.form;

import org.apache.struts.action.ActionForm;

public class ExcelForm extends ActionForm{
	//该属性用来保存所要删除记录的编号
	private String excelFilePath;

	public void setExcelFilePath(String excelFilePath) {
		this.excelFilePath = excelFilePath;
	}

	public String getExcelFilePath() {
		return excelFilePath;
	}
}

