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
	<!-- ��������ǩ�����ж����sessionScope��pageIdΪ��,
      ���������������û��pageId������������������ķ�ҳpageIdС�ڵ���1 ,
      ������sessionScope��pageIdֵΪ1-->
	<c:if
		test="${empty sessionScope.pageId or empty param.pageId or param.pageId<=1}">
		<c:set var="pageId" value="${1}" scope="session" />
	</c:if>
	<c:if test="${not empty param.pageId and param.pageId<=1}">
		<c:set var="pageId" value="${1}" scope="session" />
	</c:if>
	<!-- ��������ǩ�����ж������������е�pageId��Ϊ�գ�ͬʱ��������е�pageId��ֵ����1,
  �����������е�pageId��ֵ��ֵ��sesssion�������е�pageId -->
	<c:if test="${not empty param.pageId and param.pageId>1}">
		<c:set var="pageId" value="${param.pageId}" scope="session"></c:set>
	</c:if>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr id="headLine">
			<th height="34">���</th>
			<th>�û���</th>
			<th>����</th>
			<th colspan="2"></th>
		</tr>
		<!-- ��ѭ����ǩ�����������������е�page��������Ӧ�÷�ҳ���ݣ�ȡ������ʾ����,
        items����ָ�����ϻ�Listʵ����Ķ��� -->
		<tbody id="content">
			<c:forEach var="item" items="${requestScope.page}">
				<tr>
					<!-- c:out��ǩ���������� -->
					<td><c:out value="${item.id}" /></td>
					<!-- c:out��ǩ��������û��� -->
					<td><c:out value="${item.username}" /></td>
					<!-- c:out��ǩ����������� -->
					<td><c:out value="${item.password}" /></td>
					<!-- ������������µĳ������� -->
					<td><a
						href="update.jsp?id=${item.id}&username=${item.username}&password=${item.password}">����</td>
					<td><a href="deleteAction.do?id=${item.id}">ɾ��</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tr>
			<td><a href="insert.jsp">���</a></td>
		</tr>
		<tr>
			<td><a href="pageAction.do?pageId=${sessionScope.pageId-1}">��һҳ</a>
			</td>
			<td><a href="pageAction.do?pageId=${sessionScope.pageId+1}">��һҳ</a></td>
		</tr>

	</table>
	<img height="33" src="image/menu-bg1.gif" width="2">
</body>
</html:html>
