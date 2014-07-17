package com.zjy.dao;

import java.util.List;

import com.zjy.bean.UpDown;


public interface UpDownDao {
  public UpDown findById(Integer id);

  public void save(UpDown upDown);

  public List<UpDown> findAll();

}
