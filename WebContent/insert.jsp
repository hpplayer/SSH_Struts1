<%@ page language="java" pageEncoding="GB18030"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html:html lang="true">
  <head>
    <html:base />
  </head>
  <body>
    <html:form action="/insertAction.do">
      <table>
        <tr>
          <td>�û���</td><td><html:text property="username"></html:text> </td>
        </tr>
        <tr>
          <td>����</td><td><html:text property="password"></html:text> </td>
        </tr>
        <tr>
          <td><html:submit value="���"/> </td>
        </tr>
      </table>
    </html:form>
  </body>
</html:html>
