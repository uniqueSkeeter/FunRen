<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<html>
	<%@include file="../../common/common.jsp" %>
	<script type="text/javascript" src="<%=basePath%>js/card/chart/refuelRecordsJfree.js"></script>
	<script type="text/javascript">
	$(function(){
	    $('#button').click(function(){
	    	var stime = $("#datepicker1").datebox("getValue");
	    	if(stime == ''){
	    		$.messager.alert('错误','开始时间结束时间-不可为空!');
	    		return false;
	    	}
	    });
    });
	</script>
	
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 79%">
		<tr>
			<td width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<div class="pageFontStyle">油气交易分析一览</div>
				<hr class="lineColor">
				<form action="<%=basePath%>refuelDiagram/redirectRefuelLogChart" method="post">
					<table style="font-size: 12px;width: 100%; height: 40px; font-weight: bold;">
						<tr>
							<td height="30px" width="70px">油气类型:</td>
							<td height="30px" width="150px">
								<select name="shiftChangeBean.oilCode" id="gasType" style="width:120px">
									<option selected>   </option>
									<c:forEach var="vGasType" items="${oilType}">
										<option value="${vGasType.key}">
											${vGasType.value}
										</option>
									</c:forEach>
								</select>
							</td>
							<td height="30px" width="70px">报表类型:</td>
							<td height="30px" width="150px">
								<select name="shiftChangeBean.reportType" id="reportType" style="width:120px">
									<option value="1">日报表</option>
									<option value="2">月报表</option>
								</select>
							</td>
							<td height="30px" width="70px">开始时间:</td>
							<td height="30px" width="150px">
								<input name="shiftChangeBean.startDate" class="easyui-datebox" required="true" id="datepicker1" readonly="readonly" style="width: 120px;"/>
							<td height="30px" width="70px">结束时间:</td>
							<td height="30px" width="185px">
								<input name="shiftChangeBean.endDate" class="easyui-datebox" required="true" id="datepicker2" readonly="readonly" style="width: 120px;"/>
							</td>
							<td><input type="submit" id="button" value="统计分析"/>
						</tr>
					</table>
				</form>
				<hr class="lineColor">
				<h2 class="pageFontStyle">油气销售记录汇总</h2>
			</td>
		</tr>
		<tr>
			<td>
			<s:if test="%{shiftChangeBean.displayFlag}"> 
				<img src="<%=basePath%>refuelDiagram/refuelDiagramAnalisys?shiftChangeBean.startDate=<s:property value="shiftChangeBean.startDate"/>
				 		&shiftChangeBean.endDate=<s:property value="shiftChangeBean.endDate"/>
				 		&shiftChangeBean.reportType=<s:property value="shiftChangeBean.reportType"/>
				 		&shiftChangeBean.stationNum=<s:property value="shiftChangeBean.stationNum"/>
				 		&shiftChangeBean.oilCode=<s:property value="shiftChangeBean.oilCode"/>"><br/>
			</s:if>
			</td>
		</tr>
	</TABLE>
</body>
</body>