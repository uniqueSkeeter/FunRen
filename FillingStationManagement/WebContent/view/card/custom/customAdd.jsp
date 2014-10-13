<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<html>
<head>
<title>富仁高科加油站管理系统</title>
<base href="<%=basePath%>" />


<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>images/favicon.ico" />
<%-- <script src="<%=basePath%>js/cookies.js" type="text/javascript"></script> --%>
<!-- common -->
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/commonDialog.css" rel="stylesheet" type="text/css" />




<script type="text/javascript">
</script>
<style>

</style>
<script type="text/javascript">

</script>
</head>
<body id ="customAdd-body" >

	<p style="color:#2874ff;font-size: 14px;text-align: right">当前站点:12515544 江阴新奥加气站 当前班次 :2014051501</p>
	<hr color="#ff8000">
	<form id= "customAdd-form" method="post" action="customAdd?process=2">
<table 
		style="font-size: 12px;widht:100%;">
		<tr>
			<td height="40px" width="85px"><p>用户类型:</p>
			<td height="40px" width="160px"><s:select list="userTypeCom" theme="simple" name="fkTGuest.usertype"
					cssClass="preselect"></s:select></td>
			<td height="40px" width="85px"><p>单位类型:</p></td>
			<td height="40px"  width="180px"><s:select list="company" theme="simple" name="fkTGuest.guesttype"
					cssClass="preselect"></s:select></td>
			<td height="40px" width="85px"><p>单位名称:</p></td>
			<td height="40px" width="16px"><s:textfield name="fkTGuest.guestname" theme="simple" size="30" maxlength="30"></s:textfield></td>
		</tr>
		<tr>
			<td height="40px" width="85px"><p>证件类型:</p></td>
			<td height="40px" width="160px"><s:select list="credType" theme="simple" name="fkTGuest.idcardType"
					cssClass="preselect"></s:select></td>
			<td height="40px" width="85px"><p>证件号码:</p></td>
			<td height="40px" width="180px"><s:textfield onkeyup="value=value.replace(/[^\d]/g,'')" size="20" maxlength="20" name="fkTGuest.idcardNum" theme="simple" cssStyle="width:160px"></s:textfield></td>
			<td height="40px" width="85px"><p>姓名:</p></td>
			<td height="40px" width="160px"><s:textfield name="fkTGuest.name" theme="simple" size="16" maxlength="16"></s:textfield></td>
		</tr>
		<tr>
			<td height="40px" width="85px"><p>地址:</p></td>
			<td height="40px" width="400px" colspan="3"><s:textfield name="fkTGuest.add" theme="simple" size="40" maxlength="40" cssStyle="width:398px"></s:textfield></td>
			<td height="40px" width="80px"><p>电话:</p></td>
			<td height="40px" width="160px"><s:textfield name="fkTGuest.tel" theme="simple" size="13" maxlength="13"></s:textfield></td>
		</tr>
		<tr>
			<td height="40px" width="85px"><p>邮件:</p></td>
			<td height="40px" width="160px"><s:textfield name="fkTGuest.email" theme="simple" size="24" maxlength="28"></s:textfield></td>
			<td height="40px" width="80px"><p>邮编:</p></td>
			<td height="40px" width="180px"><s:textfield name="fkTGuest.post" onkeyup="value=value.replace(/[^\d]/g,'')" theme="simple" size="8" maxlength="8"></s:textfield></td>
			
		</tr>
		<tr>
			<td height="40px" width="85px"><p>银行编号:</p></td>
			<td height="40px" width="160px"><s:select list="bank" theme="simple" name="fkTGuest.bankno"
					cssClass="preselect"></s:select></td>
			<td height="40px" width="85px"><p>银行账号:</p></td>
			<td height="40px" width="180px"><s:textfield name="fkTGuest.bankacc" size="20" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" theme="simple" cssStyle="width:160px"></s:textfield></td>
			<td height="40px" width="85px"><p>税号:</p></td>
			<td height="40px" width="160px"><s:textfield name="fkTGuest.taxno" size="20" maxlength="20" onkeyup="value=value.replace(/[^\d]/g,'')" theme="simple"></s:textfield></td>
		</tr>
		<tr>
			<td height="40px" width="85px">备注:</td>
			<td height="40px" colspan="2" width="200px"><s:textarea name="fkTGuest.beizhu" cols="40" rows="2" maxlength="25"/></td>
		</tr>
	</table>
	</form>
	<div style="widht:100%;align:left;padding-top:5px">
    <s:checkbox theme="simple" name="paymoney" value="true" />是否交费
    </div>
<hr color="#ff8000">
</body>