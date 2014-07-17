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
<script type="text/javascript" src="page.js"></script>
<link href="mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
	<!-- 该条件标签用来判断如果sessionScope中pageId为空,
      或者在请求参数中没有pageId参数，或者请求参数的分页pageId小于等于1 ,
      则设置sessionScope的pageId值为1-->
	<c:if
		test="${empty sessionScope.pageId or empty param.pageId or param.pageId<=1}">
		<c:set var="pageId" value="${1}" scope="session" />
	</c:if>
	<c:if test="${not empty param.pageId and param.pageId<=1}">
		<c:set var="pageId" value="${1}" scope="session" />
	</c:if>
	<!-- 该条件标签用来判断如果请求参数中的pageId不为空，同时请求参数中的pageId的值大于1,
  则把请求参数中的pageId的值赋值给sesssion作用域中的pageId -->
	<c:if test="${not empty param.pageId and param.pageId>1}">
		<c:set var="pageId" value="${param.pageId}" scope="session"></c:set>
	</c:if>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr id="headLine">
			<th height="34">编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th colspan="2"></th>
		</tr>
		<!-- 该循环标签用来把请求作用域中的page属性所对应得分页内容，取出并显示出来,
        items用来指定集合或List实现类的对象 -->
		<tbody id="content">
			<c:forEach var="item" items="${requestScope.page}">
				<tr>
					<!-- c:out标签用来输出编号 -->
					<td><c:out value="${item.id}" /></td>
					<!-- c:out标签用来输出用户名 -->
					<td><c:out value="${item.username}" /></td>
					<!-- c:out标签用来输出密码 -->
					<td><c:out value="${item.password}" /></td>
					<!-- 列用来输出更新的超级连接 -->
					<td><a
						href="update.jsp?id=${item.id}&username=${item.username}&password=${item.password}">更新</td>
					<td><a href="deleteAction.do?id=${item.id}">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td><a href="insert.jsp">添加</a></td>
		</tr>
		<tr>
			<td><a href="pageAction.do?pageId=${sessionScope.pageId-1}">上一页</a>
			</td>
			<td><a href="pageAction.do?pageId=${sessionScope.pageId+1}">下一页</a></td>
		</tr>

	</table>
	<img height="33" src="image/menu-bg1.gif" width="2">
</body>
</html:html>
