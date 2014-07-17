<%@ page language="java" pageEncoding="GB18030"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
<head>
<html:base />
</head>

<body>
	<html:form action="/updateAction.do">
		<table>
			<tr>
				<td>编号</td>
				<td><html:text property="id" readonly="true"
						value="${param.id}"></html:text></td>
			</tr>
			<tr>
				<td>用户名</td>
				<td><html:text property="username" value="${param.username}"></html:text>
				</td>
			</tr>
			<tr>
				<td>密码</td>
				<td><html:text property="password" value="${param.password}"></html:text>
				</td>
			</tr>
			<tr>
				<td><html:submit value="更新" /></td>
			</tr>
		</table>
	</html:form>
</body>
</html:html>
