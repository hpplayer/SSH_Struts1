package com.zjy.form;

import org.apache.struts.action.ActionForm;

public class ChangePassForm extends ActionForm{
	private int id;//该属性用来保存编号
	private String password1;//用户新密码
	private String password2;//用户确认密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
}
