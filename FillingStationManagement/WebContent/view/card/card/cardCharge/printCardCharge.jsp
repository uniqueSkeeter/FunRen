<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path
			+ "/";
%>
<html>
<head>
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/common/print.js"></script>
<title>卡交易打印</title>
<style   media=print>
.Noprint{display:none;}
.PageNext{page-break-after:   always;}
</style>
</head>
<body id="printCardCharge_body">
	<div id ="noPrintArea" class= "NOPRINT ">
	<hr color="red">
	<span><b>交易凭证</b></span>  
	<span style="margin-left:650px;">
	<input type="button" value="打印" id="print" onclick="javascript:window.print();">
	</span>
	<hr color="red">
	</div>
	<div style="text-align:center">
	<b>中国石油加油卡交易凭证</b>
	</div>
	<table style="font-size: 15px;width:100%">
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务流水号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="businessNum"><%Date businessNum= new Date(); 
			SimpleDateFormat formatterNum = new SimpleDateFormat("yyyyMMddHHmmss");
			out.println(formatterNum.format(businessNum)); 
			%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">站点名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="stationName">${stationName}</span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">卡号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardNo"><%= request.getParameter("cardNo")%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡片类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardType"><%= java.net.URLDecoder.decode(request.getParameter("cardType"),"utf-8")%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡片状态</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardStatus"><%= java.net.URLDecoder.decode(request.getParameter("cardStatus"),"utf-8")%></span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">客户编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestNo"><%= request.getParameter("guestNo")%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户姓名</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestName"><%= java.net.URLDecoder.decode(request.getParameter("guestName"),"utf-8")%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">交易类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="tradeType"><%= java.net.URLDecoder.decode(request.getParameter("tradeType"),"utf-8")%></span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">交易额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="chargeAmount"><%= request.getParameter("chargeAmount")%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">支付类型</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="payType"><%= java.net.URLDecoder.decode(request.getParameter("payType"),"utf-8")%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">账户余额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardAccount"><%= request.getParameter("cardAccount")%></span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务发生时间</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="time"><%Date currentTime = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(formatter.format(currentTime)); 
			%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">操作员编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="operatorNo">${operatorNo}</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户签字</td>
	</tr>
	</table>
</body>