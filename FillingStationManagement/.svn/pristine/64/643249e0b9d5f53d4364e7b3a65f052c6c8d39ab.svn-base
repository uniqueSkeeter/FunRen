<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*" %>

<html>

<head>
<%@include file="../../common/common.jsp" %>
<script type="text/javascript" src="<%=basePath%>js/card/report/displayDayExchangeList.js"></script>

</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 76%">
		<tr>
			<td width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<span class="pageFontStyle">日结查询</span>
				<hr class="lineColor">
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="30px" width="70px">起始日期:</td>
						<td height="30px" width="150px" >
							<input name="dayExchangeBean.startDate" id="datepicker1" class="easyui-datebox" style="width:150px" >
						</td>
						<td height="30px" width="70px">结束日期:</td>
						<td height="30px" width="150px" >
							<input name="dayExchangeBean.endDate" id="datepicker2" class="easyui-datebox" style="width:150px" >
						</td>
						<td height="30px" width="100px"><input type='button' value='&nbsp;查&nbsp;询' id="dayExchangeList_search"></td>
					</tr>
				</table>
				<hr class="lineColor">
				<table id="dayExchangeListTable" title="日结表" style="width: auto;height: auto;">
				</table>
			</td>
		</tr>
	</TABLE>
</body>
</html>