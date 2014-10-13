<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!-- common -->
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/commonDialog.css" rel="stylesheet" type="text/css" />

</head>
<body id ="employeePermission-body" >

	<p style="color:#2874ff;font-size: 14px;text-align: right">当前站点:12515544 江阴新奥加气站 当前班次 :2014051501</p>
	<hr color="#ff8000">
	<form id= "emplPermission-form" method="post" action="employeeAdd">
		<table style="font-size: 12px;widht:100%;">
			<tr>
				<td height="3px" width="10px">员工名称:</td>
				<td height="30px" width="50px">
					<input name="employeeBean.employeeName" style="width:140px" id="emplName" value="<s:property value="employeeBean.employeeName"/>"></input>
				</td>
			</tr>
			<tr>
				<td height="3px" width="10px">员工号:</td>
				<td height="30px" width="50px">
					<input name="employeeBean.employeeNum" style="width:140px" id="emplId" value="<s:property value="employeeBean.employeeNum"/>"></input>
				</td>
			</tr>
			<tr>
				<td height="3px" width="10px">当前角色:</td>
				<td height="30px" width="50px">
					<input name="employeeBean.currentShiftType" style="width:140px" id="currentShiftType" value="<s:property value="employeeBean.shiftType"/>"></input>
				</td>
			</tr>
			<tr>
			<td height="40px" width="85px"><p>可选角色:</p></td>
				<td height="30px" width="50px">
					<select name="employeeBean.shiftType" id="shiftType" style="width:140px" >
						<option selected="selected">   </option>
						<c:forEach var="shifType" items="${shiftType}">
							<option value="${shifType.key}">
								${shifType.value}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>
<hr color="#ff8000">
</body>