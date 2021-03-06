<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp" %>

<html>
<head>
<!-- css -->
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/card/customer/customCancel/displayCustomDeleteList.js"></script>
<title>单位客户销户</title>
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 63%">
		<TR>
			<TD width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<span class="pageFontStyle">单位客户销户</span>
				<hr class="lineColor">
				<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td style="height:30px;width:60px">主卡号</td>
						<td style="height:30px;width:100px">
							<input name="customerDeleteBean.cardNo"  id="cardNo" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="20">
						</td>
						<td style="height:30px;width:60px">客户编号</td>
						<td style="height:30px;width:100px">
							<input name="customerDeleteBean.guestNo"  id="guestNo" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="6">
						</td>
						<td style="height:30px;width:60px">单位名称</td>
						<td style="height:30px;width:50px">
							<input name="customerDeleteBean.guestName"  id="guestName" maxlength="10">
						</td>
						<td style="height:30px;width:60px">
							<input type="button" id="readCard" value="读卡" style="width:100%;">
						</td>
						<td style="height:30px;width:60px">
							<input type="button" id="search" value="查询" style="width:100%;">
						</td>
					</tr>
				</table>
				<hr class="lineColorAboveTable">
				<table class="tableButton">
					<tr>
						<td>
							<input type=button id="allCardDelete" value="单位注销">
						</td>
						<td style="display:none;">
							<select name="customerDeleteBean.cardStatus" id="cardStatus">
								<c:forEach var="cardStatus" items="${cardStatus}">
									<option value="${cardStatus.key}">
										${cardStatus.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td style="display:none;">
							<select name="customerDeleteBean.cardType" id="cardType">
								<c:forEach var="cardType" items="${cardType}">
									<option value="${cardType.key}">
										${cardType.value}
									</option>
								</c:forEach>
							</select>
						</td>
					</tr>
				</table>
				<br>
				<table id="dg" title="单位卡片一览" style="width: auto; height: auto;">
				</table>
			</TD>
		</TR>
	</TABLE>
	<div id="printCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 1000px; height: 450px;">
		<iframe scrolling="auto" id='printCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
</body>
</html>