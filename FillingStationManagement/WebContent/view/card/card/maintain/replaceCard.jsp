<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>

<%@include file="../../../common/common.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/replaceCard.js"></script>
</head>
<body>
	<s:form>
	<p style="color:#2874ff;font-size: 14px;text-align:right">当前站点:${stationNo} ${stationName} 当前班次 :${classNo}</p>
		<hr class="subLineColor">
		<TABLE style="font-size: 9px; width: 100%; height: 79%">
			<tr>
				<td width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
					<div class="title"><span class="pageFontSubStyle" style="font-size: 12px;">旧卡信息</span></div>
					<table style="font-size: 18px; width: 100%; height: 50px; font-weight: bold;">
						<tr>
							<td height="3px" width="90px">旧卡卡号:</td>
							<td height="30px" width="140px">
								<span style="width: 140px" id="cardNo" >${cardMaintainBean.cardNo}</span>
							</td>
							<td height="40px" width="90px">证件类型:</td>
							<td height="30px" width="140px">
								<input name="cardMaintainBean.guestType" value="${cardMaintainBean.guestType}" style="display: none;" id="guestType"></input>
								<s:set var="guestTypeKey" value="cardMaintainBean.guestType">
								</s:set>
								<span style="width: 140px">${guestType[guestTypeKey]}</span>
							</td>
							<td height="40px" width="90px">加油次数限制:</td>
							<td height="30px" width="140px">
							    <span style="width: 140px" id="refuelTimes" >${cardMaintainBean.refuelTimes}</span>
							</td>
						</tr>
						<tr>
							<td height="40px" width="90px">客户名称:</td>
							<td height="30px" width="140px">
								<span style="width: 140px" id="guestName" >${cardMaintainBean.guestName}</span>
							</td>
							
							<td height="40px" width="90px">证件号:</td>
							<td height="30px" width="140px">
								<span style="width: 140px" id="guestNum" >${cardMaintainBean.guestNum}</span>
							</td>
							<td height="40px" width="90px">单次加油限制:</td>
							<td height="30px" width="140px">
							    <span style="width: 140px" id="refuelLimit" >${cardMaintainBean.refuelLimit}</span>
							</td>
						</tr>
						<tr>
							<td height="40px" width="90px">客户编号:</td>
							<td height="30px" width="140px">
								<span style="width: 140px" id="guestNo" >${cardMaintainBean.guestNo}</span>
							</td>
							<td height="40px" width="90px">车辆牌照:</td>
							<td height="30px" width="140px">
							    <span style="width: 140px" id="carNo" >${cardMaintainBean.carNo}</span>
							</td>
							<td height="40px" width="90px">备付账户余额:</td>
							<td height="30px" width="140px">
							    <span style="width: 140px" id="provisionAccount" >${cardMaintainBean.provisionAccount}</span>
							</td>
			       		</tr>
				</table>
				<hr class="subLineColor">
					<div class="title"><span class="pageFontSubStyle" style="font-size: 12px;">新卡信息</span></div>
					<table style="font-size: 18px; width: 100%; height: 50px; font-weight: bold;">
						<tr>
							<td height="40px" width="90px">新卡卡号:</td>
							<td height="30px" width="140px">
							    <input name="cardMaintainBean.newCardNo" style="width: 100px"  maxlength="20" id="newCardNo">${cardMaintainBean.newCardNo}</input>
							</td>
							<td height="40px" width="90px">新卡押金:</td>
							<td height="30px" width="140px">
							    <input name="cardMaintainBean.newCardPreAccount" style="width: 100px" id="newCardPreAccount" >${cardMaintainBean.newCardPreAccount}</input>
							</td>
							<td height="40px" width="90px">新卡印刷号:</td>
							<td height="30px" width="140px">
							    <input name="cardMaintainBean.newPrintNumber" style="width: 100px" id="newPrintNumber" >${cardMaintainBean.newPrintNumber}</input>
							</td>
						</tr>
						<!-- 隐藏-->
							<tr style="display:none">
							<td height="40px" width="90px">旧卡类型:</td>
							<td height="30px" width="140px">
							   <input name="cardMaintainBean.cardType" value="${cardMaintainBean.cardType}" style="display: none;" id="cardType"></input>
							   <s:set var="cardTypeKey" value="cardMaintainBean.cardType">
							   </s:set>
							   <span style="width: 140px">${cardType[cardTypeKey]}</span>
							</td>
							<td><input name="cardMaintainBean.cardStatus" style="display: none;" id="cardStatus" value="${cardMaintainBean.cardStatus}"></td>
							<td height="40px" width="90px">新卡类型:</td>
							<td height="30px" width="140px">
							   <s:set var="cardTypeKey" value="cardMaintainBean.newCardType">
							   </s:set>
							   <span style="width: 140px">${cardType[cardTypeKey]}</span>
							</td>
						    <td>
							    <input name="cardMaintainBean.deposit" value="${cardMaintainBean.deposit}" style="width:140px;display:none;" id="deposit"></input>
							    <input name="cardMaintainBean.cardStatus" value="${cardMaintainBean.cardStatus}" style="width:140px;display:none;" id="cardStatus"></input>
							    <input name="cardMaintainBean.lostTimeFlag" value="${cardMaintainBean.lostTimeFlag}" style="width:140px;display:none;" id="lostTimeFlag"></input>
						    </td>
						</tr>
					</table>
		</TABLE>
	</s:form>
</body>