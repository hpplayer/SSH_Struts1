package com.zjy.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.zjy.bean.Customer;
import com.zjy.form.LoginForm;
import com.zjy.service.CustomerService;
import com.zjy.util.FormBeanToVoUtil;
import com.zjy.util.WebUtil;

public class LoginAction extends Action{
    
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//该语句用来把ActionForm对象强制转换成DeleteForm对象
		LoginForm loginForm=(LoginForm)form;
		//该语句用来通过FormBeanToVoUtil类的convertToVo静态方法把loginForm转换成
		//Customer类的对象
	    Customer c=FormBeanToVoUtil.convertToVo(loginForm);
	  //该语句用来通过HttpSession对象来获取ServletContext对象
	    ServletContext sc=request.getSession().getServletContext();
	  //该语句用来通过WebUtil的getCustomerService静态方法，来获取CustomerService
    	CustomerService service=WebUtil.getCustomerService(sc);
    	//该语句用来通过CustomerService类的对象，来检查所对应的用户名和密码是否存在
    	boolean res=service.checkLogin(c);
	    if(res==false){//该条件语句用来判断如果，返回值为假，则意味着不存在
	    	//如果用户不存在，则跳转到failure所对应的路径
	    	return mapping.findForward("failure");
	    }else{
	    	//该语句用来设置所要显示的分页的编号为1
	    	int pageId=1;
	    	//该语句用来通过委托CustomerService对象的getPage方法来
	    	//获取变量pageId所指定的分页编号所对应的分页内容
	    	List<Customer> page=service.getPage(pageId);
	    	//该语句用来把所得到的分页内容，存放到request对象中去
			//并设置属性名为page
	    	request.setAttribute("page", page);
	    	//该语句用来获取跳转名page所对应的跳转路径
	    	return mapping.findForward("page");
	    }
	    
		
	}
	

}
