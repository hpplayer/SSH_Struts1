<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	import="com.zjy.bean.*"%>
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

<title>My JSP 'adminInfoCheck.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	<link href="css/css001.css" rel="stylesheet" type="text/css">
	-->

</head>
<%
		Student st = (Student)session.getAttribute("student");
	%>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #999999;
}
-->
</style>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>
<!--
-->
<script language="JavaScript" type="text/JavaScript">
<!--
function MM_preloadImages() { //v3.0
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

function MM_swapImgRestore() { //v3.0
  var i,x,a=document.MM_sr; for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}

function MM_findObj(n, d) { //v4.01
  var p,i,x;  if(!d) d=document; if((p=n.indexOf("?"))>0&&parent.frames.length) {
    d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);}
  if(!(x=d[n])&&d.all) x=d.all[n]; for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
  for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
  if(!x && d.getElementById) x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  var i,j=0,x,a=MM_swapImage.arguments; document.MM_sr=new Array; for(i=0;i<(a.length-2);i+=3)
   if ((x=MM_findObj(a[i]))!=null){document.MM_sr[j++]=x; if(!x.oSrc) x.oSrc=x.src; x.src=a[i+2];}
}
//-->
</script>
<body
	onLoad="MM_preloadImages('images/tworoad-gif001-2.gif','images/tworoad-gif002-2.gif','images/tworoad-gif003-2.gif','images/tworoad-gif004-2.gif','images/tworoad-gif005-2.gif','images/tworoad-gif006-2.gif','images/tworoad-gif007-2.gif','images/tworoad-gif008-2.gif','images/tworoad-gif009-2.gif')">
	<table width="750" border="0" align="center" cellpadding="0"
		cellspacing="0" bgcolor="#FFFFFF">
		<tr>
			<td width="10"></td>
			<td width="730"><img src="images/tworoad-jpg001.jpg" width="730"
				height="170"></td>
			<td width="10"></td>
		</tr>
		<tr>
			<td></td>
			<td><table width="100%" border="0" cellspacing="0"
					cellpadding="0">
				</table></td>
			<td></td>
		</tr>
	</table>
	<table width="750" border="0" align="center" cellpadding="0"
		cellspacing="0" bgcolor="#FFFFFF">
		<tr>
			<td width="10"></td>
			<td width="730">&nbsp;</td>
			<td width="10"></td>
		</tr>
		<tr>
			<td></td>
			<td><img src="images/tworoad-gif016.gif" width="730" height="29"></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="10" class="l-r-b-1pxline">
					<tr>
						<td width="75%"><table width="100%" height="150" border="0"
								cellpadding="0" cellspacing="0"
								background="images/tworoad-gif014.gif">
								<tr>
									<td width="12%" align="right">学生学号：</td>
									<td width="38%">&nbsp;</td>
									<td width="38%" align="left"><%=st.getId()%></td>
									<td width="12%" align="left"></td>

								</tr>
								<tr>
									<td align="right">学生姓名：</td>
									<td>&nbsp;</td>
									<td align="left"><%=st.getName()%></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="right">家庭住址：</td>
									<td>&nbsp;</td>
									<td align="left"><%=st.getHomeAdd()%></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="right">学生专业：</td>
									<td>&nbsp;</td>
									<td align="left"><%=st.getMajorID()%></td>
									<td>&nbsp;</td>
								</tr>
								<tr>
									<td align="right">学生年级：</td>
									<td>&nbsp;</td>
									<td align="left"><%=st.getGrade()%></td>
									<td>&nbsp;</td>
								</tr>
							</table></td>
					</tr>
				</table></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td height="30">&nbsp;</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td><table width="100%" border="0" cellpadding="0"
					cellspacing="0" class="r-t-b1pxline">
					<tr>
						<td width="16%"><img src="images/logo.png" width="128"
							height="38"></td>
						<td width="84%"><font color="973423">&nbsp;学生信息界面&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img
								src="images/29.gif" width="20" height="20" border="0"></font></td>
					</tr>
				</table></td>
			<td></td>
		</tr>
		<tr>
			<td height="10"></td>
			<td height="10"></td>
			<td height="10"></td>
		</tr>
	</table>
</body>
</html>
