package com.zjy.bean;
import java.io.Serializable;

public class UpDown implements Serializable {
  private static final long serialVersionUID = 1L;

  private Integer id;
  private String name;
  private String path;

  public Integer getId() {
  return id;
  }

  public void setId(Integer id) {
  this.id = id;
  }

  public String getName() {
  return name;
  }

  public void setName(String name) {
  this.name = name;
  }

  public String getPath() {
  return path;
  }

  public void setPath(String path) {
  this.path = path;
  }

}
