package com.zjy.service.impl;

import java.util.List;

import com.zjy.dao.UpDownDao;
import com.zjy.bean.UpDown;
import com.zjy.service.UpDownService;

public class UpDownServiceImpl implements UpDownService {
  private UpDownDao upDownDao;

  public void setUpDownDao(UpDownDao upDownDao) {
  this.upDownDao = upDownDao;
  }

  public List<UpDown> getAllUpDown() {
  return upDownDao.findAll();
  }

  public UpDown getUpDown(Integer id) {
  return upDownDao.findById(id);
  }

  public void saveUpDown(UpDown upDown) {
  upDownDao.save(upDown);
  }

}