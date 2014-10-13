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
//支付方式和银行选择联动
function payTyselect(sValue) {
	if (sValue == '12') {
		document.getElementById("paybank1").style.display='';
		document.getElementById("paybank2").style.display='';
	} else {
		document.getElementById("paybank1").style.display='none';
		document.getElementById("paybank2").style.display='none';
	}
}

</script>
</head>
<body id ="customPay-body" onload="init()" >

	<p style="color:#2874ff;font-size: 14px;text-align: right">当前站点:12515544 江阴新奥加气站 当前班次 :2014051501</p>
	<hr color="#ff8000">
	<form id= "customPay-form" method="post" action="customPay?process=1">
<table 
		style="font-size: 12px;widht:100%;">
		<tr>
			<td height="40px" width="85px"><p>用户类型:</p>
			<td height="40px" width="160px"><s:property value="userTypeCom[fkTGuest.usertype]"/></td>
			<td height="40px" width="85px"><p>单位类型:</p></td>
			<td height="40px"  width="180px"><s:property value="company[fkTGuest.guesttype]"/></td>
			<td height="40px" width="85px"><p>单位名称:</p></td>
			<td height="40px" width="16px"><s:property value="fkTGuest.guestname"/></td>
		</tr>
		<tr>
			<td height="40px" width="85px"><p>证件类型:</p></td>
			<td height="40px" width="160px"><s:property value="credType[fkTGuest.idcardType]"/></td>
			<td height="40px" width="85px"><p>证件号码:</p></td>
			<td height="40px" width="180px"><s:property value="fkTGuest.idcardNum"/></td>
			<td height="40px" width="85px"><p>姓名:</p></td>
			<td height="40px" width="160px"><s:property value="fkTGuest.name"/></td>
		</tr>
		<tr>
			<td height="40px" width="85px"><p>客户账户余额:</p></td>
			<td height="40px" width="160px"><s:property value="fkTGuest.bal"/></td>
			<td height="40px" width="80px"><p>已分配金额:</p></td>
			<td height="40px" width="160px"><s:property value="fkTGuest.inUse"/></td>
			<td height="40px" width="80px"><p>钱包账户余额:</p></td>
			<td height="40px" width="160px"><s:property value="fkTGuest.cardacc"/></td>
		</tr>
		<tr>
			<td height="40px" width="85px"><p>支付方式:</p></td>
			<td height="40px" width="160px"><s:select list="payType" name="fkTGuest.payType" onchange="payTyselect(this.options[this.options.selectedIndex].value)" theme="simple"></s:select></td>
			<td height="40px" width="80px" id = "paybank1" style="display:none"><p>支付银行:</p></td>
			<td height="40px" width="180px"  id = "paybank2"  style="display:none"><s:select list="bank" theme="simple" name="fkTGuest.bankno" id="bank"
					cssClass="preselect"></s:select></td>
			<td height="40px" width="80px"><p>支付金额:</p></td>
			<td height="40px" width="180px"><s:textfield name="fkTGuest.paymoney" onkeyup="value=value.replace(/[^\d]/g,'')" theme="simple" size="8" maxlength="8"></s:textfield></td>
			
		</tr>
	</table>
	</form>
<hr color="#ff8000">
</body>