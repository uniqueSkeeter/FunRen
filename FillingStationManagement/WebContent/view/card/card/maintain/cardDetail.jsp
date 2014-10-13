<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp"%>

<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/cardDetail.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/stationLimit.js"></script>
</head>
<body>
	<s:form name="myForm" action="showCardDetail">
		<tr>
			<td width="86%" valign="top"><span class="pageFontSubStyle">持卡人基本信息:</span>		
			</td>
		</tr>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td height="30px" style="width: 90px">卡号:</td>
				<td height="30px" style="width: 150px">
				    <input name="updateCardInfoBean.cardNo" value="${updateCardInfoBean.cardNo}" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" maxlength="20" style="width: 150px" id="cardNo"></input>
				</td>
				<td height="30px" style="width: 90px">客户名称:</td>
				<td height="30px" style="width: 150px">
				    <input name="updateCardInfoBean.guestName" value="${updateCardInfoBean.guestName}" style="width: 150px" id="guestName"></input>
				</td>
				<td height="30px" style="width: 90px">联系电话:</td>
				<td height="30px" style="width: 150px">
				    <input name="updateCardInfoBean.guestTel"  value="${updateCardInfoBean.guestTel}" style="width: 150px" id="guestTel"></input>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">证件类型:</td>
				<td height="30px" style="width: 150px">
				    <select name="updateCardInfoBean.guestType" style="width: 150px" id="guestType">
						<s:set var="guestTypeKey" value="updateCardInfoBean.guestType">
						</s:set>
						<option value="${guestTypeKey}">${guestType[guestTypeKey]}</option>
						<c:forEach var="guestType" items="${guestType}">
							<c:if test="${guestType.key!=guestTypeKey}">
							<option value="${guestType.key}">${guestType.value}</option>
							</c:if>
						</c:forEach>
				    </select>
				</td>
				<td height="30px" style="width: 90px">证件号:</td>
				<td height="30px" style="width: 150px">
				    <input name="updateCardInfoBean.guestNum"onkeyup="value=value.replace(/[^(\d)]/g,'')" value="${updateCardInfoBean.guestNum}" style="width: 150px" id="guestNum"></input>
				</td>
				<td height="30px" style="width: 90px">邮编:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="zipCode">${updateCardInfoBean.zipCode}</span>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">电子邮箱:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="email">${updateCardInfoBean.email}</span>
				</td>
				<td height="30px" style="width: 90px">联系地址:</td>
				<td height="30px" style="width: 150px" colspan='2'>
				    <span style="width: 200px" id="guestAdd">${updateCardInfoBean.guestAdd}</span>
				</td>
			</tr>
		</table>
		<hr class="lineColor">
			<tr>
				<td width="86%" valign="top"><span class="pageFontSubStyle">卡片基本信息:</span>		
				</td>
			</tr>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td height="30px" style="width: 90px">卡片类型:</td>
				<td height="30px" style="width: 150px">
				   <s:set var="cardTypeKey" value="updateCardInfoBean.cardType">
				   </s:set>
				   <span style="width: 150px">${cardType[cardTypeKey]}</span>
				</td>
				<td height="30px" style="width: 90px">卡状态:</td>
				<td height="30px" style="width: 150px">
				   <s:set var="cardStakey" value="updateCardInfoBean.cardStatus">
				   </s:set>
				   <span style="width: 150px">${cardStatus[cardStakey]}</span>
				</td>
				<td height="30px" style="width: 90px">印刷号:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="printNumber">${updateCardInfoBean.printNumber}</span>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">卡余额:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="cardAmount">${updateCardInfoBean.cardAmount}</span>
				</td>
				<td height="30px" style="width: 90px">备付账户余额:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="pre">${updateCardInfoBean.pre}</span>
				</td>
				<td height="30px" style="width: 90px">卡内积分:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="score">${updateCardInfoBean.score}</span>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">启用日期:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="createDate">${updateCardInfoBean.createDate}</span>
				</td>
				<td height="30px" style="width: 90px">停用日期:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="updateDate">${updateCardInfoBean.updateDate}</span>
			    </td>
			</tr>
		</table>
			<hr class="lineColor">
			<tr>
				<td width="86%" valign="top"><span class="pageFontSubStyle">卡片限制信息:</span>		
				</td>
			</tr>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td height="30px" style="width: 90px">油品限制:</td>
				<td height="30px" style="width: 150px">
					<s:set var="oilTypeLimitkey" value="updateCardInfoBean.oilTypeLimit">
					</s:set>
					<span style="width: 150px">${oilTypeLimit[oilTypeLimitkey]}</span>
				</td>
				<td height="30px" style="width: 90px">每次加油限量:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="refuelLimit">${updateCardInfoBean.refuelLimit}</span>
				</td>
				<td height="30px" style="width: 90px">每天加油次数:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="refuelTimes">${updateCardInfoBean.refuelTimes}</span>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">限每天总金额:</td>
				<td height="30px" style="width: 150px">
			        <span style="width: 150px" id="consumeAmount">${updateCardInfoBean.consumeAmount}</span>
				</td>
				<td height="30px" style="width: 90px">限车号:</td>
				<td height="30px" style="width: 150px">
				    <span style="width: 150px" id="carNoConstr">${updateCardInfoBean.carNoConstr}</span>
				</td>
		    </tr>
		</table>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td style="height: 30px; width: 88px;">限站信息</td>
				<td style="height: 30px; width: 390px" >
					<table>
						<tr>
							<td>
								<select multiple="multiple" name="updateCardInfoBean.stationInfoLimit" id="stationInfoLimit" style="width: 100px;height:100px;">
									<c:forEach var="stationNumber" items="${updateCardInfoBean.stationInfoLimit}" >
                					<option value="${stationNumber}">${stationList[stationNumber]}</option>
        							</c:forEach>
								</select>
							</td>
						</tr>
					</table>
				</td>
				<td width="240px" valign="top">
					<input type='button' value='读卡' id="cardMaintain_readonly" onclick="alert('读卡')" style="width: 40px">
					<input type='button' value='查询' id="cardMaintain_searchfor" style="width: 40px">
					<input type='button' value='重置' id="cardMaintain_clear" style="width: 40px">		
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>