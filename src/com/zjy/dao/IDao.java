package com.zjy.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.criterion.DetachedCriteria;


public interface IDao {
	/** 
     * Save object
     * @param o 
     * @return 
     */ 
    public abstract Object save(Object o);
    
    /** 
     * Delete object
     * @param o 
     */ 
    public abstract void delete(Object o);
    
    /** 
     * find by PK
     * @param entityClass 
     * @param id 
     * @return 
     */ 
    public abstract Object get(Class entityClass,Serializable id);
    
    /** 
     * execute the query
     * @param hql 
     * @param params 
     * @return 
     */ 
    public abstract List executeQuery (String hql, Object ... params);
    
    public abstract List executeQuery(String hql);
    
    public abstract SQLQuery executeSQLQuery(String hql);
    
    public abstract int executeUpdate(String hql);
    
    /** 
     * Update query
     * @param hql 
     * @param params 
     * @return 
     */ 
    public abstract int executeUpdate(String hql, Object ... params);
    
    /** 
     * Find by a unique field
     * @param persistentClass 
     * @param propertyName 
     * @param value 
     * @return 
     */ 
    public abstract Object findUniqueBy(Class persistentClass,String propertyName, Object value) ;
    
    /** 
     * QBC query
     * @param detachedCriteria 
     * @return 
     */ 
    public abstract List findByCriteria( 
                    final DetachedCriteria detachedCriteria);
    


}
