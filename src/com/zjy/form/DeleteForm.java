package com.zjy.form;

import org.apache.struts.action.ActionForm;
//该类的对象用来保存，在删除请求中参数
public class DeleteForm extends ActionForm{
	//该属性用来保存所要删除记录的编号
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
   

}
