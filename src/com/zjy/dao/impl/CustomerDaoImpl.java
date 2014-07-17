package com.zjy.dao.impl;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.zjy.bean.Customer;
import com.zjy.dao.CustomerDao;
//该类用来实现对数据库中customer表的增删改查以及分页的操作
//如果使用Spring来整合Hibernate,则在Spring中提供了HiberanteDaoSupport来操纵Hibernate
//对于用户可以直接继承HibernateDaoSupport类
public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao{
	//该方法用来删除外界所指定的对象
	public void delete(Customer c) {
		//该语句用来通过父类的getHibernateTemplate方法，来获取HibernateTemplate对象
		HibernateTemplate template= getHibernateTemplate();
		//该语句用来通过Hibernate对象的delete方法来删除对象
		template.delete(c);
	}
	//该方法用来根据外界所传递过来的id,并删除该id所对应的记录
	public void delete(int id) {
		//该语句用来根据外界所传递过来的id,并返回该id所对应的记录，并封装到对象中去
		Customer c=findById(id);
		//该语句用来删除对象
		delete(c);
	}
	//该方法用来根据外界所传递过来的id,并返回该id所对应的记录，并把记录封装到Customer对象
	public Customer findById(int id) {
		//该语句用来通过父类的getHibernateTemplate方法，来获取HibernateTemplate对象
		HibernateTemplate template= getHibernateTemplate();
		//该语句用来通过Hibernate对象的get方法,同时也依赖外界所传递过来的记录编号
		//来获取该编号所对应的记录，并以对象的方式返回 
		return (Customer)template.get(Customer.class, id);
	}
	//该方法用来外界所传递过来的分页编号，并返回该分页编号的内容，并以List对象的形式返回
	public List<Customer> getPage(int pageId) {
		//该语句用来通过父类的getHibernateTemplate方法，来获取HibernateTemplate对象
		HibernateTemplate template= getHibernateTemplate();
		//该语句用来通过HibernateTemplate对象来会话工厂SessionFactory对象
		SessionFactory factory=template.getSessionFactory();
		//该语句用来通过SessionFactory对象来获取会话Session对象
		Session session=factory.openSession();
		//该语句用来通过session来创建Criteria类的对象
		Criteria criteria=session.createCriteria(Customer.class);
		//该语句用来声明pageSize变量，该变量用来保存分页大小
		int pageSize=5;
		//该语句用来根据外界所传递过来的分页编号和分页的大小，来确定分页的开始位置
		int start=(pageId-1)*pageSize;
		//该语句用来通过Criteria对象的setFirstResult方法来设置查询结果的开始位置
		criteria.setFirstResult(start);
		//该语句用来通过Criteria对象的setMaxResults方法来设置查询结果记录中的最大数
		criteria.setMaxResults(pageSize);
		return (List<Customer>)criteria.list();
	}
	//该方法用来保存外界所传递过来的对象
	public void save(Customer c) {
		//该语句用来通过父类的getHibernateTemplate方法，来获取HibernateTemplate对象
		HibernateTemplate template= getHibernateTemplate();
		//该语句用来通过委托HibernateTemplate对象的save方法来保存对象 
		template.save(c);
	}
	//该方法用来更新外界所传递来的对象
	public void update(Customer c) {
		HibernateTemplate template= getHibernateTemplate();
		//该语句用来通过委托HibernateTemplate对象的saveOrUpdate方法来更新对象 
		template.saveOrUpdate(c);
	}
	//该方法用来根据外界所传递来的用户名和密码，并返回该用户名和密码所相对应的记录，并把记录封装到Customer对象中去
	public Customer findByNameAndPass(String... con) {
		//该语句用来获取用户名
		String username=con[0];
		//该语句用来获取密码
		String password=con[1];
		//该语句用来通过父类的getSessionFactory方法获取SessionFactory对象
		SessionFactory factory=this.getSessionFactory();
		//该语句用来通过SessionFactory对象来打开一个Session会话对象
		Session session=factory.openSession();
		//该语句用来通过Session会话对象来创建Criteria类对象
		Criteria criteria= session.createCriteria(Customer.class);
		//该语句用来设置Criteria对象的查询条件，在该语句用来设置用户名为变量username的值
		criteria.add(Expression.eq("username", username));
		//该语句用来设置Criteria对象的查询条件，在该语句用来设置密码为变量password的值
		criteria.add(Expression.eq("password", password));
		//该语句用来获取查询结果中的对象
		return (Customer)criteria.uniqueResult();
	}
}
