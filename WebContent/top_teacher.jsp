<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page contentType="text/html" pageEncoding="UTF-8"
	import="com.zjy.bean.*"%>
<head>
<title>管理页面</title>
<script language=JavaScript>
	function logout() {
		if (confirm("您确定要退出管理页面吗？"))
			top.location = "userquit.do";
		return false;
	}
</script>
<script language=JavaScript1.2>
	function showsubmenu(sid) {
		var whichEl = eval("submenu" + sid);
		var menuTitle = eval("menuTitle" + sid);
		if (whichEl.style.display == "none") {
			eval("submenu" + sid + ".style.display=\"\";");
		} else {
			eval("submenu" + sid + ".style.display=\"none\";");
		}
	}
</script>
<meta http-equiv=Content-Type content=text/html;charset=gb2312>
	<meta http-equiv="refresh" content="60" />
	<base target="main" />
	<link href="images/skin.css" rel="stylesheet" type="text/css" />
</head>
<%
		Teacher ta = (Teacher)session.getAttribute("teacher");
	%>
<body leftmargin="0" topmargin="0">
	<table width="100%" height="64" border="0" cellpadding="0"
		cellspacing="0" class="admin_topbg">
		<tr>
			<td width="61%" height="64"><img src="images/logo-2.gif"
				width="262" height="64"></td>
			<td width="39%" valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="74%" height="38" class="admin_txt">教师：<%=ta.getName()%>
							<b></b> 您好,感谢登陆使用！
						</td>
						<td width="22%"><a href="#" target="_self" onClick=logout();;><img
								src="images/out.gif" alt="安全退出" width="46" height="20"
								border="0"></a></td>
						<td width="4%">&nbsp;</td>
					</tr>
					<tr>
						<td height="19" colspan="3">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
