

<%--
    Document   : login
    Created on : 2009-12-6, 14:52:02
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<title>网站用户登陆</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #1D3647;
}
-->
</style>
<script language="javascript">
    function mycheck(myform){
        if (myform.textfield.value=="")
        {alert("请输入管理员！");myform.Manager.focus();return;}
        if(myform.textfield2.value=="")
        {alert("请输入密码！");myform.PWD.focus();return;}
        myform.submit();
    }
</script>


<link href="images/skin.css" rel="stylesheet" type="text/css">
<body>
	<table width="100%" height="166" border="0" cellpadding="0"
		cellspacing="0">
		<tr>
			<td height="42" valign="top">
				<table width="100%" height="42" border="0" cellpadding="0"
					cellspacing="0" class="login_top_bg">
					<tr>
						<td width="1%" height="21">&nbsp;</td>
						<td height="42">&nbsp;</td>
						<td width="17%">&nbsp;</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td valign="top">
				<table width="100%" height="532" border="0" cellpadding="0"
					cellspacing="0" class="login_bg">
					<tr>
						<td width="49%" align="right">
							<table width="91%" height="532" border="0" cellpadding="0"
								cellspacing="0" class="login_bg2">
								<tr>
									<td height="138" valign="top">
										<table width="89%" height="427" border="0" cellpadding="0"
											cellspacing="0">
											<tr>
												<td height="149">&nbsp;</td>
											</tr>
											<tr>
												<td height="80" align="center" valign="top"><img
													src="images/logo.png" width="279" height="68"></td>
											</tr>
											<tr>
												<td height="198" align="right" valign="top">
													<table width="100%" border="0" cellpadding="0"
														cellspacing="0">
														<tr>
															<td width="35%">&nbsp;</td>
															<td height="25" colspan="2" class="left_txt">
																<p>1- 操作简洁明了，使用方便...</p>
															</td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td height="25" colspan="2" class="left_txt">
																<p>2- 适合所有学校的信息管理平台...</p>
															</td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td height="25" colspan="2" class="left_txt">
																<p>3- 强大的后台系统，管理内容易如反掌...</p>
															</td>
														</tr>
														<tr>
															<td>&nbsp;</td>
															<td width="30%" height="40"><img
																src="images/icon-demo.gif" width="16" height="16">
																<a href="#" target="_blank" class="left_txt3"> 使用说明</a>
															</td>
															<td width="35%"><img
																src="images/icon-login-seaver.gif" width="16"
																height="16"> <a href="#" class="left_txt3">
																	在线帮助</a></td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
								</tr>

							</table>
						</td>
						<td width="1%">&nbsp;</td>
						<td width="50%" valign="bottom">
							<table width="100%" height="59" border="0" align="center"
								cellpadding="0" cellspacing="0">
								<tr>
									<td width="4%">&nbsp;</td>
									<td width="96%" height="38"><span class="login_txt_bt">用户登录平台</span>
									</td>
								</tr>
								<tr>
									<td>&nbsp;</td>
									<td height="21">

										<table cellSpacing="0" cellPadding="0" width="100%" border="0"
											id="table211" height="328">
											<tr>
												<td height="164" colspan="2" align="center"><html:form
														action="/newloginAction.do">
														<table cellSpacing="0" cellPadding="0" width="100%"
															border="0" height="143" id="table212">
															<tr>
																<td width="13%" height="38" class="top_hui_text"><span
																	class="login_txt">用户名：&nbsp;&nbsp; </span></td>
																<td><html:text property="username"></html:text> <html:select
																		property="selectPerson">
																		<html:option value="one">学生</html:option>
																		<html:option value="two">教师</html:option>
																		<html:option value="three">管理员</html:option>
																	</html:select></td>
															</tr>
															<tr>
																<td width="13%" height="35" class="top_hui_text"><span
																	class="login_txt"> 密 码： &nbsp;&nbsp; </span></td>
																<td><html:password size="30" property="password"></html:password>
																</td>
															</tr>
															<tr>
																<td><html:submit value="登录" /></td>
															</tr>
														</table>
													</html:form> <br></td>
											</tr>
											<tr>
												<td width="433" height="164" align="right" valign="bottom">
													<img src="images/login-wel.gif" width="242" height="138">
												</td>
												<td width="57" align="right" valign="bottom">&nbsp;</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="20">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="login-buttom-bg">
					<tr>
						<td align="center"><span class="login-buttom-txt">Copyright
								&copy; 2009-2010 www.865171.cn</span></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>