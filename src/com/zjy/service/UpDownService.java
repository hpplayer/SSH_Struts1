package com.zjy.service;
import java.util.List;

import com.zjy.bean.UpDown;

public interface UpDownService {
  public void saveUpDown(UpDown upDown);

  public List<UpDown> getAllUpDown();

  public UpDown getUpDown(Integer id);

}

