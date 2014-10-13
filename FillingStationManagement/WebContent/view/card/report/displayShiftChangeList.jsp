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
<script type="text/javascript" src="<%=basePath%>js/card/report/displayShiftChangeList.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/report/displayCardStorageDetail.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/report/displayStationTradeDetail.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/report/displayInvoiceDetail.js"></script>
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 76%">
		<tr>
			<td width="70%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<span class="pageFontStyle">班结查询</span>
				<hr class="lineColor">
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="30px" width="70px">起始日期:</td>
						<td height="30px" width="250px" >
							<input name="classChangeBean.startDate" id="datepicker1" class="easyui-datebox" style="width:150px" editable="false" showSeconds="false">
						</td>
						<td height="30px" width="70px">结束日期:</td>
						<td height="30px" width="250px" >
							<input name="classChangeBean.endDate" id="datepicker2" class="easyui-datebox" style="width:150px" editable="false" showSeconds="false">
						</td>
						<td height="30px" width="70px">班结状态:</td>
						<td height="30px" width="150px" >
							<select name="classChangeBean.classStatus" id="classStatus" style="width:150px">
								<option selected>   </option>
								<c:forEach var="classStatus" items="${classStatus}">
									<option value="${classStatus.key}">
										${classStatus.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
						<a href="javascript:void(0)" class="easyui-linkbutton" id="shiftChangeList_search" iconCls="icon-search" style="padding-left: 20px;">搜索</a>
						</td>
					</tr>
					<tr style="display:none">
						<td>
							<select  id="cardType" style="width:150px">
								<option selected>   </option>
								<c:forEach var="cardType" items="${cardCategory}">
									<option value="${cardType.key}">
										${cardType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select  id="tradeType" style="width:150px">
								<option selected>   </option>
								<c:forEach var="tradeType" items="${chargeTradeType}">
									<option value="${tradeType.key}">
										${tradeType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td>
							<select  id="payType" style="width:150px">
								<option selected>   </option>
								<c:forEach var="payType" items="${operPayType}">
									<option value="${payType.key}">
										${payType.value}
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<hr class="lineColorAboveTable">
				<table class="tableButton">
					<tr>
						<td>
<!-- 							<a href="javascript:void(0)" class="easyui-linkbutton" id="stationTrade_detail" style="font-size:3px">网点交易明细</a> -->
							<input type='button' value='&nbsp;网点交易明细' id="stationTrade_detail"> 
						</td>
						<td></td>
						<td>
<!-- 							<a href="javascript:void(0)" class="easyui-linkbutton" id="cardStorage_detail" style="font-size:3px">卡片出入库明细</a> -->
							<input type='button' value='&nbsp;卡片出入库明细' id="cardStorage_detail" >
						</td>
						<td></td>
						<td>
<!-- 							<a href="javascript:void(0)" class="easyui-linkbutton" id="invoice_detail" style="font-size:3px">&nbsp;&nbsp;&nbsp;&nbsp;发票明细&nbsp;&nbsp;&nbsp;&nbsp;</a> -->
							<input type='button' value='&nbsp;发票明细' id="invoice_detail">
						</td>
					</tr>
				</table>
				<br>
				<table id="shiftChangeListTable"  style="width: auto;height: auto;">
				</table>
			</td>
		</tr>
	</TABLE>
	<script>
		
	</script>
	
	<div id="cardStorageDetailDialog" class="easyui-window" closed="true" modal="true" title="卡片出入库明细" style="width:668px;height:450px;"> 
    	<table id="cardAccountListTable"  style="width: auto;height: auto;">
		</table>
	</div> 
	
	<div id="stationTradeDetailDialog" class="easyui-window" closed="true" modal="true" title="网点交易明细" style="width:660px;height:450px;"> 
    	<table id="stationTradeListTable"  style="width: auto;height: auto;">
		</table>
	</div>
	
	<div id="InvoiceDetailDialog" class="easyui-window" closed="true" modal="true" title="发票明细" style="width:735px;height:450px;"> 
    	<table id="InvoiceListTable"  style="width: auto;height: auto;">
		</table>
	</div>
	<div id="classSummaryDialog" class="easyui-window" closed="true" modal="true" title="查看" style="width:715px;height:580px;"> 
    	<iframe  id='classSummaryIFrame' frameborder="0"  src="" style="width:100%;height:450px;"></iframe> 
	</div>
	<div id="exportClassSummaryDialog" class="easyui-window" closed="true" modal="true" title="选择路径" style="width:715px;height:580px;"> 
    	<input type="file" id="filePath">
	</div>  
</body>
</html>