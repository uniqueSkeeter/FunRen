<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*"%>
<%@include file="../../../common/common.jsp"%>
<script type="text/javascript" src="<%=basePath%>js/card/card/maintain/updateSubCard.js"></script>
<script type="text/javascript" src="<%=basePath%>js/card/customer/stationLimit.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common/validation.js"></script>
</head>
<body>
	<s:form name="driverForm" action="loadDriver">
		<p style="color:#2874ff;font-size: 14px;text-align:right">当前站点:${stationNo} ${stationName} 当前班次 :${classNo}</p>
		<hr class="subLineColor">
		<tr>
			<td width="86%" valign="top"><span class="pageFontSubStyle">司机卡:</span>		
			</td>
		</tr>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td height="30px" style="width: 90px">卡号:</td>
				<td height="30px" style="width: 130px">
					<!-- 隐藏ID -->
					<input name="updateCardInfoBean.id" value="${updateCardInfoBean.id}" style="display:none" id="id"></input>
				    <input name="updateCardInfoBean.cardNo" readonly="readonly" value="${updateCardInfoBean.cardNo}" maxlength="20" style="width: 130px" id="cardNo"></input>
				</td>
				<td height="30px" style="width: 90px">卡片类型:</td>
				<td height="30px" style="width: 130px">
				   <s:set var="cardTypeKey" value="updateCardInfoBean.cardType">
				   </s:set>
				   <input value="${cardType[cardTypeKey]}" disabled="disabled" style="width: 130px">
				</td>
				<td height="30px" style="width: 90px">押金:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.deposit" value="${updateCardInfoBean.deposit}" disabled="disabled" style="width: 130px" id="deposit"></input>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">有效期:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.disEffectiveDate" value="${updateCardInfoBean.disEffectiveDate}" disabled="disabled" style="width: 130px" id="disEffectiveDate"></input>
				</td>
				<td height="30px" style="width: 90px">卡片状态:</td>
				<td height="30px" style="width: 130px">
				   <s:set var="cardStakey" value="updateCardInfoBean.cardStatus">
				   </s:set>
				   <input value="${cardStatus[cardStakey]}" disabled="disabled" style="width: 130px">
				</td>
			</tr>
		</table>
			<hr class="subLineColor">
		    <tr>
		    	<td width="86%" valign="top"><span class="pageFontSubStyle">客户档案:</span>	
			    </td>
		   	</tr>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td height="30px" style="width: 90px">姓名:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.guestName" value="${updateCardInfoBean.guestName}" maxlength="20" style="width: 130px" id="guestName"></input>
				</td>
				<td height="30px" style="width: 90px">证件类型:</td>
				<td height="30px" style="width: 130px">
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
				<td height="30px" style="width: 90px">证件号码:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.guestNum" value="${updateCardInfoBean.guestNum}" maxlength="18" style="width: 130px" id="guestNum"></input>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">电话:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.guestTel" onkeyup="value=value.replace(/[^(\d)]/g,'')" value="${updateCardInfoBean.guestTel}" maxlength="30" style="width: 130px" id="guestTel"></input>
				</td>
				<td style="height: 40px; width: 85px; ">性别</td>
				<td width="130px">
					男<input name="updateCardInfoBean.gender" type=radio id="genderMale" value="男" ${(updateCardInfoBean.gender=="男")?'checked' : ''}>
					&nbsp;&nbsp;&nbsp;
					女<input name="updateCardInfoBean.gender" type=radio id="genderFemale" value="女" ${(updateCardInfoBean.gender=="女")?'checked' : ''}>
				</td>
				<td height="30px" style="width: 90px">电子邮箱:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.email"  value="${updateCardInfoBean.email}" maxlength="30" style="width: 130px" id="email"></input>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">邮政编码:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.zipCode"  onkeyup="value=value.replace(/[^(\d)]/g,'')" value="${updateCardInfoBean.zipCode}" maxlength="6" style="width: 130px" id="zipCode"></input>
				</td>
				<td height="30px" style="width: 90px">卡密码</td>
				<td height="30px" style="width: 130px" >
					启用<input name="updateCardInfoBean.passFlag" type=radio id="passEnable" value="Y" ${(updateCardInfoBean.passFlag=='Y')?'checked' : ''} >
					停用<input name="updateCardInfoBean.passFlag" type=radio id="passDisenable" value="N" ${(updateCardInfoBean.passFlag=='N')?'checked' : ''}>
				</td>
				<td height="30px" style="width: 90px">初始日期:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.createDate" disabled="disabled" value="${updateCardInfoBean.createDate}" style="width: 130px" id="createDate"></input>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">备注:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.remark"  value="${updateCardInfoBean.remark}" maxlength="1" style="width: 130px" id="remark"></input>
				</td>
				<td height="30px" style="width: 90px">联系地址:</td>
				<td height="30px" style="width: 180px" colspan="2">
				    <input name="updateCardInfoBean.customerAddr" value="${updateCardInfoBean.customerAddr}" maxlength="40" style="width: 180px" id="customerAddr"></input>
				</td>
			</tr>
		</table>
			<hr class="subLineColor">
			<tr>
				<td width="86%" valign="top"><span class="pageFontSubStyle">加油限制:</span>	
			    </td>
		    </tr>
		<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
			<tr>
				<td height="30px" style="width: 90px">车牌号:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.carNoConstr" value="${updateCardInfoBean.carNoConstr}" maxlength="20" style="width: 130px" id="carNoConstr"></input>
				</td>
				<td height="30px" style="width: 90px">每天加油次数:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.refuelTimes"  value="${updateCardInfoBean.refuelTimes}" maxlength="2" style="width: 130px" id="refuelTimes"></input>
				</td>
				<td height="30px" style="width: 90px">每天消费金额:</td>
				<td height="30px" style="width: 130px">
			        <input name="updateCardInfoBean.consumeAmount" value="${updateCardInfoBean.consumeAmount}" style="width: 130px" id="consumeAmount"></input>
				</td>
			</tr>
			<tr>
				<td height="30px" style="width: 90px">每次加油限量:</td>
				<td height="30px" style="width: 130px">
				    <input name="updateCardInfoBean.refuelLimit"  value="${updateCardInfoBean.refuelLimit}" maxlength="5" style="width: 130px" id="refuelLimit"></input>
				</td>	
				<td height="30px" style="width: 90px">油品限制:</td>
				<td height="30px" style="width: 130px">
					<select name="updateCardInfoBean.oilTypeLimit" style="width: 130px" id="oilTypeLimit">
						<s:set var="oilTypeLimitkey" value="updateCardInfoBean.oilTypeLimit">
						</s:set>
						<option value="${oilTypeLimitkey}">${oilTypeLimit[oilTypeLimitkey]}</option>
						<c:forEach var="oilTypeLimit" items="${oilTypeLimit}">
							<c:if test="${oilTypeLimit.key!=oilTypeLimitkey}">
							<option value="${oilTypeLimit.key}">${oilTypeLimit.value}</option>
							</c:if>
						</c:forEach>
				    </select>
				</td>
				<td height="30px" style="width: 90px">开票类型</td>
				<td height="30px" style="width: 130px">
					<select name="updateCardInfoBean.billType" style="width: 130px" id="billType">
						<s:set var="billTypekey" value="updateCardInfoBean.billType">
						</s:set>
						<option value="${billTypekey}">${billType[billTypekey]}</option>
						<c:forEach var="billType" items="${billType}">
							<c:if test="${billType.key!=billTypekey}">
							<option value="${billType.key}">${billType.value}</option>
							</c:if>
						</c:forEach>
				    </select>
				</td>
			</tr>
		</table>
		<table style="font-size: 12px; width: 500px; height: 50px; font-weight: bold;">
			<tr>
				<td style="height: 20px; width: 90px;">限站信息</td>
				<td style="height: 20px; width: 130px" >
					<table>
						<tr>
							<td>
								<select multiple="multiple" name="updateCardInfoBean.stationInfoLimit" id="stationInfoLimit" style="width: 100px;height:100px;">
									<c:forEach var="stationNumber" items="${updateCardInfoBean.stationInfoLimit}" >
                					<option value="${stationNumber}">${stationList[stationNumber]}</option>
        							</c:forEach>
								</select>
							</td>
							<td>
								<p><span id="addStationInforButton" style="font-size:30px">+</span></p>
								<p><span id="removeStationInforButton" style="font-size:30px">-</span></p>
							</td>
						</tr>
					</table>
				<td>
					<select multiple="multiple" id="alternativeStationList" style="width:100px;height:100px;display:none">
						<c:forEach var="stationList" items="${stationList}">
							<option value="${stationList.key}">${stationList.value}
							</option>
						</c:forEach>
					</select>
				</td>
		</table>
		</s:form>
</body>
</html>