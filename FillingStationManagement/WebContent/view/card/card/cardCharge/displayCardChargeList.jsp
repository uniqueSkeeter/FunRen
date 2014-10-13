<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp" %>

<html>
<!-- css -->
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/card/card/cardCharge/displayCardChargeList.js"></script>
<head>
<title>卡充值</title>
</head>
<body>
	<span class="pageFontStyle">卡信息</span>
	<hr class="lineColor">
	<TABLE style="width:100%;">
	<TR>
	<TD>
		<s:form id="cardAccount_form" method="post" action="showCardAccountInfo">
		<table style="font-size: 12px; width: 100%; height: 40px; font-weight:bold;">
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">卡号</td>
				<td style="height: 30px; width: 150px">
					<input name="cardChargeBean.cardNo" id="cardNo" value="${cardChargeBean.cardNo}" style="width:150px" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="20">
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">客户编号</td>
				<td style="height: 30px; width: 150px">
					<input name="cardChargeBean.guestNo" id="guestNo" value="${cardChargeBean.guestNo}"  onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="6">
				</td>
				<td style="height: 30px; width: 90px">
					<input type="button" id="readCard" value="读卡" style="width:60px;">
				</td>
				<td style="height: 30px; width: 150px">
					<input type="button" id="search" value="查询" style="width:60px;">
				</td>
			</tr>
		</table>
		<span class="pageFontStyle">卡帐信息</span>
		<hr class="lineColor">
		<table style="font-size: 12px; width: 100%; height: 40px; font-weight:bold;">
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">卡号</td>
				<td style="height: 30px; width: 150px">
					<span id="cardNum" style="width: 150px;">${cardChargeBean.cardNo}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">卡类型</td>
				<td style="height: 30px; width: 150px">
					<span id="cardType" style="width: 150px;">${cardType[cardChargeBean.cardType]}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">卡状态</td>
				<td style="height: 30px; width: 150px">
					<span id="cardStatus" style="width: 150px;">${cardStatus[cardChargeBean.cardStatus]}</span>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">是否主卡</td>
				<td style="height: 30px; width: 150px">
					<span id="mainCardFlag" style="width: 150px;">${cardChargeBean.mainCardFlag}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">证件类型</td>
				<td style="height: 30px; width: 150px">
					<span id="guestType" style="width: 150px;">${guestType[cardChargeBean.guestType]}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">证件号</td>
				<td style="height: 30px; width: 150px">
					<span id="guestNum" style="width: 150px;">${cardChargeBean.guestNum}</span>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">客户编号</td>
				<td style="height: 30px; width: 150px">
					<span id="customerNo" style="width: 150px;">${cardChargeBean.guestNo}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">持卡人</td>
				<td style="height: 30px; width: 150px">
					<span id="guestName" style="width: 150px;">${cardChargeBean.guestName}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">充值总和</td>
				<td style="height: 30px; width: 150px">
					<span id="rechargeAmount" style="width: 150px;">${cardChargeBean.rechargeAmount}</span>
				</td>
				<td style="height: 30px; width: 150px; display: none;">
					<input name="cardChargeBean.id" id="cardAccId" value="${cardChargeBean.id}">
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">卡内余额</td>
				<td style="height: 30px; width: 150px">
					<span id="cardAccount" style="width: 150px;">${cardChargeBean.cardAccount}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">卡备用金</td>
				<td style="height: 30px; width: 150px">
					<span id="cardPre" style="width: 150px;">${cardChargeBean.cardPre}</span>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">消费总和</td>
				<td style="height: 30px; width: 150px">
					<span id="consumeSum" style="width: 150px;">${cardChargeBean.consumeSum}</span>
				</td>
			</tr>
		</table>
		<span class="pageFontStyle">交易信息</span>
		<hr class="lineColor">
		<table style="font-size: 12px; width: 100%; height: 40px; font-weight:bold;">
			<tr>
				<td style="height: 30px; width: 90px; text-align: left;">交易额</td>
				<td style="height: 30px; width: 150px">
					<input name="cardChargeBean.chargeAmount" id="chargeAmount" style="width:150px;" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="8">
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">支付方式</td>
				<td style="height: 30px; width: 150px">
					<select name="cardChargeBean.payType" id="payType" style="width:150px;">
						<c:forEach var="payType" items="${payType}">
							<option value="${payType.key}">${payType.value}</option>
						</c:forEach>
					</select>
				</td>
				<td style="height: 30px; width: 90px; text-align: left;">交易类型</td>
				<td style="height: 30px; width: 150px">
					<select name="cardChargeBean.tradeType" id="tradeType" style="width:150px;">
						<c:forEach var="chargeTradeType" items="${chargeTradeType}">
							<option value="${chargeTradeType.key}">${chargeTradeType.value}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td style="height: 30px; width: 90px; text-align: left; display:none;" id="serialNumLabel">交易流水号</td>
				<td style="height: 30px; width: 150px" colspan="4">
					<input name="cardChargeBean.bankSerialNum" id="bankSerialNum" style="width:150px; display:none;" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="20">
				</td>
			</tr>
		</table>
		</s:form>
		<div style="width: 100%; height: 40px; text-align:center;">
			<input type="button" id="charge" value="充值" style="width: 60px;">
			<input type="button" id="reset" value="重置" style="width: 60px;">
			<input type="button" id="cancel" value="扣款" style="width: 60px;">
		</div>
	</TD>
	</TR>
	</TABLE>
	<div id="printCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 450px;">
		<iframe scrolling="auto" id='printCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
</body>
</html>