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
<title>客户注销打印</title>
<style   media=print>
.Noprint{display:none;}
.PageNext{page-break-after:   always;}
</style>
</head>
<body id="printCardCharge_body">
	<div id ="noPrintArea" class= "NOPRINT ">
	<hr color="red">
	<span><b>注销凭证</b></span>  
	<span style="margin-left:650px;">
	<input type="button" value="打印" id="print" onclick="javascript:window.print();">
	</span>
	<hr color="red">
	</div>
	<div style="text-align:center">
	<b>单位注销凭证</b>
	</div>
	<table style="font-size: 13px;width:100%">
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
			<span id="stationName">${stationName}
			</span>
		</td>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">客户编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestNo"><%= request.getParameter("guestNo")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">单位名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestName"><%=java.net.URLDecoder.decode(request.getParameter("guestName"),"utf-8")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户账户</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="spareAccount"><%= request.getParameter("spareAccount")%>
			</span>
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">总卡卡余额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="accountSum"><%= request.getParameter("accountSum")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">总卡备用金余额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="preSum"><%= request.getParameter("preSum")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">退款总额</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="refundAmount"><%= request.getParameter("refundAmount")%>
			</span>
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
			<span id="operatorNo">${operatorNo}
			 </span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户签字</td>
	</tr>
	</table>
</body>