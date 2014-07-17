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

import com.zjy.bean.Customer;
import com.zjy.form.DeleteForm;
import com.zjy.service.CustomerService;
import com.zjy.util.WebUtil;

//该类用来负责删除请求
public class DeleteAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 该语句用来把ActionForm对象强制转换成DeleteForm对象
		DeleteForm deleteForm = (DeleteForm) form;
		// 该语句用来通过request对象来获取HttpSession对象
		HttpSession session = request.getSession();
		// 该语句用来通过HttpSession对象来获取ServletContext对象
		ServletContext sc = session.getServletContext();
		// 该语句用来通过WebUtil的getCustomerService静态方法，来获取CustomerService
		CustomerService service = WebUtil.getCustomerService(sc);
		// 该语句用来通过委托Customer对象的delete方法来删除编号所对应的记录
		service.delete(deleteForm.getId());
		// 该语句用来获取会话中所绑定的分页编号
		Object id = session.getAttribute("pageId");
		// 该语句用来通过委托CustomerService对象的getPage方法
		// 来获取分页编号所对应的分页内容
		List<Customer> list = service.getPage(Integer.parseInt(id.toString()));
		// 该语句用来把所得到的分页内容，存放到request对象中去
		// 并设置属性名为page
		request.setAttribute("page", list);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("page");
	}

}
