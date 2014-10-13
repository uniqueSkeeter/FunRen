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

	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/system/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/system/jquery.easyui.min.js"></script>

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
<body id ="customAdd-body" >

	<p style="color:#2874ff;font-size: 14px;text-align: right">当前站点:12515544 江阴新奥加气站 当前班次 :2014051501</p>
	<hr style="color: #ff8000">
	<form id= "emplAdd-form" method="post" action="saveUser">
		<table style="font-size: 12px;widht:100px; height: 50px">
			<tr>
				<td height="3px" width="85px">员工名称:</td>
				<td height="30px" width="50px">
					<input name="employeeBean.employeeName" style="width:140px" id="emplName" value="${employeeBean.employeeName}"></input>
					
				</td>
				<td height="40px" width="85px"><p>员工密码:</p></td>
				<td height="30px" width="50px">
					<input name="employeeBean.employeePass" style="width:140px" id="emplPass" value="123"></input>
				</td>
				<td height="40px" width="85px"><p>岗位类型:</p></td>
				<td height="30px" width="50px">
					<select name="employeeBean.shiftType" id="shiftType" style="width:140px" >
						<s:set var="shiftKey" value="employeeBean.shiftType">
						</s:set>
						<option value="${shiftKey}">${shiftType[shiftKey]}</option>
						<c:forEach var="shifType" items="${shiftType}">
							<option value="${shifType.key}">
								${shifType.value}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td height="40px" width="85px"><p>文化程度:</p></td>
				<td height="30px" width="50px">
					<select name="employeeBean.education" id="eduStatus" style="width:140px" id="eduStatus" >
						<s:set var="educationKey" value="employeeBean.education">
						</s:set>
						<option value="${educationKey}">${education[educationKey]}</option>
						<c:forEach var="eduStatus" items="${education}">
							<option value="${eduStatus.key}">
								${eduStatus.value}
							</option>
						</c:forEach>
					</select>
				</td>
				
				<td height="40px" width="85px"><p>政治面貌:</p></td>
				<td height="30px" width="50px">
					<select name="employeeBean.political" id="shiftType" style="width:140px">
						<s:set var="politicalKey" value="employeeBean.political">
						</s:set>
						<option value="${politicalKey}">${politicalStatus[politicalKey]}</option>
						<c:forEach var="political" items="${politicalStatus}">
							<option value="${political.key}">
								${political.value}
							</option>
						</c:forEach>
					</select>
				</td>
				
				<td height="40px" width="85px"><p>证件号码:</p></td>
				<td height="30px" width="50px">
					<input name="employeeBean.identity" style="width:140px" maxlength = "20" 
					onkeyup="value=value.replace(/[^\d]/g,'')" id="emplIdentity" value="${employeeBean.identity}"></input>
				</td>
				
			</tr>
			<tr>
				<td height="40px" width="85px"><p>地址:</p></td>
				<td height="30px" width="50px" colspan="3">
					<input name="employeeBean.address" style="width:300px" id="emplAddr" maxlength="40" value="${employeeBean.address}"></input>
				</td>
				
				<td height="40px" width="80px"><p>联系电话:</p></td>
				<td height="30px" width="50px">
					<input name="employeeBean.telephone" maxlength="11" style="width:140px" onkeyup="value=value.replace(/[^\d]/g,'')" id="emplTel" value="123456878" ></input>
				</td>
			</tr>
			<tr>
				<td height="40px" width="85px"><p>班次:</p></td>
				<td height="30px" width="50px">
					<input name="employeeBean.shiftNum" style="width:140px" id="emplShiftNum" value="12"></input>
				</td>
				<td height="40px" width="80px"><p>银行类型:</p></td>
				<td height="30px" width="50px">
					<select name="employeeBean.bankType" id="bankType" style="width:140px">
						<s:set var="bankKey" value="employeeBean.bankType">
						</s:set>
						<option value="${bankKey}">${bankType[bankKey]}</option>
						<c:forEach var="bankType" items="${bankType}">
							<option value="${bankType.key}">
								${bankType.value}
							</option>
						</c:forEach>
					</select>
				</td>
				<td height="40px" width="80px" ><p>银行账号:</p></td>
				<td height="30px" width="50px">
					<input name="employeeBean.bankAccount" style="width:140px" onkeyup="value=value.replace(/[^\d]/g,'')" id="emplBankAcc" maxlength="20"></input>
				</td>
			</tr>
			<tr>
				<td height="40px" width="85px"><p>邮政编码:</p></td>
				<td height="30px" width="50px">
					<input name="employeeBean.zipCode" style="width:140px" id="emplZip" value="111" maxlength="6"></input>
				</td>
				<td></td>
				<td height="40px" width="180px"></td>
				<td></td>
				<td height="40px" width="160px"></td>
			</tr>
		</table>
	</form>
<hr style="color: #ff8000">
</body>