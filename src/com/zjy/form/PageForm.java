package com.zjy.form;

import org.apache.struts.action.ActionForm;

public class PageForm extends ActionForm{
	  private int pageId=1;//该属性用来保存分页编号，并设置分页号的默认值为1

	public int getPageId() {
		return pageId;
	}

	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	  

}
