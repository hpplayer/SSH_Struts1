package com.zjy.dao.impl;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.zjy.dao.UpDownDao;
import com.zjy.bean.UpDown;
import com.zjy.service.UpDownService;

public class UpDownDaoImpl implements UpDownDao {
  protected HibernateTemplate hibernate;

  public void setHibernate(HibernateTemplate hibernate) {
  this.hibernate = hibernate;
  }

  public UpDown findById(Integer id) {
  String hql = "from UpDown ud where ud.id=?";
  List<UpDown> list = (List<UpDown>) hibernate.find(hql, new Object[] { id });
  if (list == null || list.size() == 0)
  return null;
  return list.get(0);
  }

  public List<UpDown> findAll() {
  String hql = "from UpDown";
  List<UpDown> list = (List<UpDown>) hibernate.find(hql);
  return list;
  }

  public void save(UpDown upDown) {
  hibernate.save(upDown);
  }
}
