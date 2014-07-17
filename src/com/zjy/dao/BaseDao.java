package com.zjy.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDao extends HibernateDaoSupport implements IDao
{
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * Save object
	 * 
	 * @param o
	 * @return
	 */
	public Object save(Object o)
	{
		return this.getHibernateTemplate().merge(o);
	}

	public void save(Collection os)
	{
		this.getHibernateTemplate().saveOrUpdate(os);
	}

	public void saveOrUpdate(Object o)
	{
		this.getHibernateTemplate().saveOrUpdate(o);
		this.getHibernateTemplate().flush();
//	    Configuration cfg = new Configuration().configure();
//	    SessionFactory sessionFactory = cfg.buildSessionFactory();  	 
//	    Session session = sessionFactory.openSession();
//	    session.beginTransaction(); 
//	    session.save (o);
//	    session.getTransaction().commit(); 
//		if(session.isOpen()) 
//		{ 
//			session.close();         
//		} 

	}
	/**
	 * Delete object
	 * 
	 * @param o
	 */
	public void delete(Object o)
	{
		this.getHibernateTemplate().delete(o);
	}

	/**
	 * Delete object
	 * 
	 * @param o
	 */
	public void delete(Collection os)
	{
		this.getHibernateTemplate().deleteAll(os);
	}
	
	public void delete(String hql){
		this.executeUpdate(hql);
	}
	
	/**
	 * update
	 * 
	 * @param bo
	 *            *Sunny
	 */
	public void update(Object bo)
	{
		this.getHibernateTemplate().saveOrUpdate(bo);
	}

	/**
	 * find by PK
	 * 
	 * @param entityClass
	 * @param id
	 * @return
	 */
	public Object get(Class entityClass, Serializable id)
	{
		return this.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * execute the query
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public List executeQuery(String hql, Object... params)
	{
		return this.getHibernateTemplate().find(hql, params);
//	    Query query = this.createQuery(hql);
//	    if(params != null && params.length > 0)
//		{
//		    query.setParameterList(hql, params);
//		}
//	    //TODO 杩欎袱涓弬鏁拌浠庨〉闈紶杩囨潵銆�
//	    query.setFirstResult(0);
//        query.setMaxResults(100);
//	    return query.list();
	}

	public List executeQuery(String hql)
	{
		return this.executeQuery(hql, null);
	}

	public Query createQuery(String hql)
	{
	    return this.getSession().createQuery(hql);
	}
	
	public int executeUpdate(String hql)
	{
		return executeUpdate(hql, null);
	}

	public List findByPropertys(String hql, Object[] values) {
		return this.getHibernateTemplate().find(hql, values);
	}

	/**
	 * Update query
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String hql, Object... params)
	{
		return this.getHibernateTemplate().bulkUpdate(hql, params);
	}

	/**
	 * Find by a unique field
	 * 
	 * @param persistentClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public Object findUniqueBy(Class persistentClass, String propertyName,
			Object value)
	{
		Criteria criteria = getSession().createCriteria(persistentClass);
		return criteria.add(Restrictions.eq(propertyName, value))
				.uniqueResult();
	}

	/**
	 * QBC query
	 * 
	 * @param detachedCriteria
	 * @return
	 */
	public List findByCriteria(final DetachedCriteria detachedCriteria)
	{
		return (List) getHibernateTemplate().execute(new HibernateCallback()
		{
			public Object doInHibernate(Session session)
					throws HibernateException
			{
				Criteria criteria = detachedCriteria
						.getExecutableCriteria(session);
				List items = criteria.list();
				return items;
			}
		});
	}

	public SQLQuery executeSQLQuery(String hql)
	{
		return this.getSession().createSQLQuery(hql);
	}

}
