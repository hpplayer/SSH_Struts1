package com.zjy.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import com.zjy.bean.UpDown;
import com.zjy.form.UploadForm;
import com.zjy.service.UpDownService;

public class UpDownAction extends DispatchAction {
  private UpDownService upDownService;

  public void setUpDownService(UpDownService upDownService) {
  this.upDownService = upDownService;
  }

  // 显示下载页面
  public ActionForward show(ActionMapping mapping, ActionForm form,
  HttpServletRequest request, HttpServletResponse response)
  throws Exception {
  List<UpDown> upDownList = upDownService.getAllUpDown();
  request.setAttribute("upDownList", upDownList);
  return mapping.findForward("success");
  }

  // 转到上传页面
  public ActionForward toUpload(ActionMapping mapping, ActionForm form,
  HttpServletRequest request, HttpServletResponse response)
  throws Exception {
  return mapping.findForward("success");

  }

  // 上传文件
  public ActionForward upload(ActionMapping mapping, ActionForm form,
  HttpServletRequest request, HttpServletResponse response)
  throws Exception {

  UploadForm uploadForm = (UploadForm) form;
  FormFile file = uploadForm.getMyFile();
  FileOutputStream fos = null;
  String realPath = null;
  try {
  String name = file.getFileName();
  byte[] fileData = file.getFileData();

  // 获得upfile目录的绝对路径
  // ServletContext sc = this.getServlet().getServletContext();
  // String realPath = sc.getRealPath("/xxx/");//webapp路径

  realPath = new File("\\.").getCanonicalFile().toString();// 得到当前磁盘路径

  fos = new FileOutputStream(realPath + "/" + name);
  fos.write(fileData);
  } catch (Exception e) {
  e.printStackTrace();
  } finally {
  try {
  fos.flush();
  fos.close();
  } catch (IOException e) {
  e.printStackTrace();
  }
  
  }

  UpDown upDown = new UpDown();
  upDown.setName(file.getFileName());
  upDown.setPath(realPath);
  upDownService.saveUpDown(upDown);

  return mapping.findForward("success");
  }

  // 下载文件
  public ActionForward download(ActionMapping mapping, ActionForm form,
  HttpServletRequest request, HttpServletResponse response)
  throws Exception {
  Integer id = new Integer(request.getParameter("id"));// 根据id下载文件
  UpDown upDown = upDownService.getUpDown(id);

  String fileName = upDown.getName();

  File file = new File(upDown.getPath() + "/" + fileName);// 下载路径

  InputStream is = new FileInputStream(file);
  OutputStream os = response.getOutputStream();
  BufferedInputStream bis = new BufferedInputStream(is);
  BufferedOutputStream bos = new BufferedOutputStream(os);

  response.reset();
  response.setCharacterEncoding("UTF-8");
  response.setContentType("application/x-msdownload");// 下载属性
  response.setHeader("Content-Disposition", "attachment;filename="
  + URLEncoder.encode(upDown.getName(), "utf-8"));// 下载的文件名转换成utf-8

  int bytesRead = 0;
  byte[] buffer = new byte[1024 * 8];
  while ((bytesRead = bis.read(buffer)) != -1) {
  bos.write(buffer, 0, bytesRead);
  }

  bos.flush();
  bis.close();
  bos.close();
  is.close();
  os.close();

  return null;
  }

}
