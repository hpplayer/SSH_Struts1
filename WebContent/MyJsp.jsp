<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="jxl.*,java.io.*,jxl.read.biff.BiffException,java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

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
	<form name="form1" method="get" action="">
		选择一个可以读取的页面 <input type="file" name="xls_filename"
			onChange="form1.submit()">
	</form>
	<%
			String filename = request.getParameter("xls_filename");
			if (filename != null && !filename.equals("")) {
				try {
					filename = filename.replaceAll("\\\\", "\\\\\\\\");
					Workbook rwb = Workbook.getWorkbook(new File(filename));
					Sheet rs = rwb.getSheet(0);
					for (int i = 0; i < rs.getRows(); i++) {
						Cell[] cell = rs.getRow(i);
						String name = cell[0].getContents();
						String message = cell[1].getContents();
						System.out.println(name);
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		%>
	<br> 你选择的文件是<%=filename%>
</body>
</html>
