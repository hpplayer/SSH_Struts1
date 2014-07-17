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
import com.zjy.form.UpdateForm;
import com.zjy.service.CustomerService;
import com.zjy.util.FormBeanToVoUtil;
import com.zjy.util.WebUtil;

public class UpdateAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 该语句用来把ActionForm对象强制转换成UpdateForm对象
		UpdateForm updateForm = (UpdateForm) form;
		// 该语句用来通过request对象来获取HttpSession对象
		HttpSession session = request.getSession();
		// 该语句用来通过HttpSession对象来获取ServletContext对象
		ServletContext sc = session.getServletContext();
		// 该语句用来通过WebUtil的getCustomerService静态方法，来获取CustomerService
		CustomerService service = WebUtil.getCustomerService(sc);
		// 该语句用来通过FormBeanToVoUtil类的convertToVo静态方法把insertForm转换成Customer类的对象
		Customer c = FormBeanToVoUtil.convertToVo(updateForm);
		// 该语句用来通过委托CustomerService对象的update方法来更新Customer对象
		service.update(c);
		// 该语句用来获取HttpSession对象中绑定的分页编号
		String pageId = (String) session.getAttribute("pageId");
		// 该语句用来委托CustomerService对象,CustomerService对象根据分页编号来获取所对应的分页内容
		List<Customer> page = service.getPage(Integer.parseInt(pageId));
		// 该语句用来把所得到的分页内容，存放到request对象中去
		// 并设置属性名为page
		request.setAttribute("page", page);
		// 该语句用来获取跳转名page所对应的跳转路径
		return mapping.findForward("page");
	}

}
