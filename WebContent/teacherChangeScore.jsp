<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="com.zjy.vo.*"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
StudentScore classlist=(StudentScore)request.getAttribute("studentscore");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'teacherApplyLoad.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1 align="center">教师修改成绩</h1>
	<html:form
		action="/teacherchangeScoresave.do?classid=<%=classlist.getClassid()%>&studentid=<%=classlist.getStudentid()%>&grade=<%=classlist.getGrade()%>">
		<table width="408" height="142" border="1" align="center">
			<tr align="center">
				<td width="98">课程名称</td>
				<td width="98">学生</td>
				<td width="92">年级</td>
				<td width="92">原始成绩</td>
				<td width="92">新成绩</td>
				<td width="92">确定修改</td>
			</tr>
			<tr>
				<td align="center"><%=classlist.getClassname()%></td>
				<td align="center"><%=classlist.getStudentname()%></td>
				<td align="center"><%=classlist.getGrade()%></td>
				<td align="center"><%=classlist.getScore()%></td>
				<td align="center" width="92"><html:text property="newscore"></html:text></td>
				<td align="center"><a
					href="teacherchangeScoresave.do?classid=<%=classlist.getClassid()%>&studentid=<%=classlist.getStudentid()%>&grade=<%=classlist.getGrade()%>"
					target="main">确定修改</td>-->
				<td align="center" width="92"><html:submit value="确定" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html>
