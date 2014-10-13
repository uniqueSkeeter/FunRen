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
<title>密码修改打印</title>
<style   media=print>
.Noprint{display:none;}
.PageNext{page-break-after:   always;}
</style>
</head>
<body id="printAnonymousCard_body">
	<div id ="noPrintArea" class= "NOPRINT ">
	<hr color="red">
	<span><b>密码修改</b></span>  
	<span style="margin-left:650px;">
	<input type="button" value="打印" id="print" onclick="javascript:window.print();">
	</span>
	<hr color="red">
	</div>
	<div style="text-align:center">
	<b>中国石油加油卡修改密码凭证</b>
	</div>
	<table style="font-size: 15px;width:100%">
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务流水号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="busnessNum">100244</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">交易网点</td>
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
		<td style="height: 50px; width: 100px; text-align: center;">客户名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestName"><%= request.getParameter("guestName")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="cardNo"><%= request.getParameter("cardNo")%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户编号</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="guestNo"><%= request.getParameter("guestNo")%>
			</span>
		</td>
		</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">业务名称</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="busnissName"><%= "密码修改"%>
			</span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">卡押金</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="deposit"><%= request.getParameter("deposit")%>
			</span>
		</td>
			</tr>
	<tr>
	</tr>
	<tr>
		<td colspan="6">
			<hr color="black">
		</td>
	</tr>
	<tr>
		<td style="height: 50px; width: 100px; text-align: center;">挂失时间</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="time"><%Date currentTime = new Date(); 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(formatter.format(currentTime)); 
			%></span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">操作员</td>
		<td style="height: 50px; width: 100px; text-align: center;">
			<span id="operatorNo">${operatorNo}
			 </span>
		</td>
		<td style="height: 50px; width: 100px; text-align: center;">客户签字</td>
	</tr>
	</table>
</body>