package com.zjy.dao;

import java.util.List;
import com.zjy.bean.Classes;



public interface IClassDao {
	public void save(Classes a);
	public void update(Classes a);
	public void delete(Classes a);
	public void delete(int id);
	public Classes findById(int id);
	public List<Classes> getPage(int pageId);
	public void ApplyUploadScore(int classid);//申请上传
	public void RefuseApply(int classid);//拒绝申请
	public void AgreeApply(int classid);//同意申请
	public List<Classes> getClassByTeacherId(int teacherid);
	public List<Classes> getAllWaitingClass();//获得所有申请中的课程
	
}
