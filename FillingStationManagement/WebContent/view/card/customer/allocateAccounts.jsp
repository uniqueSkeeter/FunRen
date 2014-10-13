<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>
<%@include file="../../common/common.jsp" %>
	<style   media=print>
		.Noprint{display:none;}
		.PageNext{page-break-after:   always;}
	</style>
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
<body>
<div style="height:200px">
	<p style="color:#2874ff;font-size: 14px;text-align: right">当前站点:${stationNo} ${stationName} 当前班次 :${classNo}</p>
	<hr class="subLineColor">
	<form  method="post">
		<span class="pageFontSubStyle">主卡信息</span>
		<table style="font-size: 10px;width:700px; height: 90px">
			<tr>
				<td height="10px" width="70px">姓名：</td>
				<td  height="10px" width="150px">${transferAccountsBean.mainCardGuestName}</td>
				<td height="10px" width="90px">单位证件号：</td>
				<td  height="10px" width="150px">${transferAccountsBean.mainCardIDNum}</td>
				<td height="10px" width="90px">客户状态：</td>
				<td  height="10px" width="100px">
					<s:set var="mainCardGuestStatusKey" value="transferAccountsBean.mainCardGuestStatus ">
					</s:set>
					${guestStatus[mainCardGuestStatusKey]}
				</td>
				
			</tr>
			<tr>
				<td height="10px" width="70px">卡状态：</td>
				<td  height="10px" width="150px">
					<s:set var="mainCardStatusKey" value="transferAccountsBean.mainCardStatus ">
					</s:set>
					${cardStatus[mainCardStatusKey]}
				</td>
				<td height="10px" width="90px">备付账户余额：</td>
				<td  height="10px" width="150px">${transferAccountsBean.mainCardProvisionAccount}</td>
				<td height="10px" width="90px">积分余额</td>
				<td height="10px" width="100px">${transferAccountsBean.mainCardPoint}</td>
			</tr>
			<tr>
				<td height="10px" width="70px"></td>
				<td height="10px" width="150px">
					<input type= "hidden" name="transferAccountsBean.guestNo" id="guestNo" value="${transferAccountsBean.guestNo}">
				</td>
				<td style="display:none">
					<input type= "hidden" name="transferAccountsBean.mainCardGuestName" id="mainCardGuestName" value="${transferAccountsBean.mainCardGuestName}">
					<input type= "hidden" name="transferAccountsBean.mainCardProvisionAccount" id="mainCardProvisionAccount" value="${transferAccountsBean.mainCardProvisionAccount}">
					<input type= "hidden" name="transferAccountsBean.mainCardNo" id="mainCardNo" value="${transferAccountsBean.mainCardNo}">
					<input type= "hidden" name="transferAccountsBean.mainCardPoint" id="mainCardPoint" value="${transferAccountsBean.mainCardPoint}">
				</td>
			</tr>
		</table>
		<br>
		<span class="pageFontSubStyle">副卡信息</span>
		<table style="font-size: 10px;width:700px; height: 90px">
			<tr>
				<td height="10px" width="70px">卡号：</td>
				<td  height="10px" width="150px">${transferAccountsBean.viceCardNo}</td>
				<td height="10px" width="90px">司机姓名：</td>
				<td  height="10px" width="160px">${transferAccountsBean.viceCardGuestName}</td>
				<td height="10px" width="90px">部门名称：</td>
				<td  height="10px" width="100px">${transferAccountsBean.viceCardDepName}</td>
			</tr>
			<tr>
				<td height="10px" width="70px">卡状态：</td>
				<td height="10px" width="150px">
					<s:set var="viceCardStatusKey" value="transferAccountsBean.viceCardStatus ">
					</s:set>
					${cardStatus[viceCardStatusKey]}
				</td>
				<td height="10px" width="90px">余额：</td>
				<td  height="10px" width="160px">${transferAccountsBean.viceCardProvisionAccount}</td>
				<td height="10px" width="90px">分配类型：</td>
				<td  height="10px" width="100px">
					<select name="transferAccountsBean.allocateType" id="allocateType" style="width:100px">
						<option selected></option>
						<c:forEach var="allocateType" items="${allocateType}">
							<option value="${allocateType.key}">
								${allocateType.value }
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td height="10px" width="70px">有效日期：</td>
				<td height="10px" width="150px">${transferAccountsBean.viceCardEffectiveDate}</td>
				<td height="10px" width="90px">积分余额：</td>
				<td height="10px" width="160px">${transferAccountsBean.viceCardPoint}</td>
				<td height="10px" width="90px">分配数额：</td>
				<td  height="10px" width="100px">
					<input type="text" name="transferAccountsBean.allocateAmount" id="allocateAmount" style="width:100px" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')">
				</td>
			</tr>
			<tr style="display:none">
				<td height="10px" width="80px"></td>
				<td height="10px" width="100px">
					<input type= "hidden" name="transferAccountsBean.viceCardNo" id="viceCardNo" value="${transferAccountsBean.viceCardNo}">
					<input type= "hidden" name="transferAccountsBean.viceCardProvisionAccount" id="viceCardProvisionAccount" value="${transferAccountsBean.viceCardProvisionAccount}">
					<input type= "hidden" name="transferAccountsBean.viceCardPoint" id="viceCardPoint" value="${transferAccountsBean.viceCardPoint}">
				</td>
			</tr>
		</table>
	</form>
	
</div>
<hr class="subLineColor">
</body>
</html>