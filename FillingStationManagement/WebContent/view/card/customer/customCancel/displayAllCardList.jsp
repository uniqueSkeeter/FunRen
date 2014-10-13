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
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/card/deleteCustomer.css">
<!-- js -->
<script type="text/javascript" src="<%=basePath%>js/card/customer/customCancel/displayAllCardList.js"></script>
<title>所有卡片信息</title>
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 63%">
		<TR>
		<TD>
		<s:set var="resultCustomerBeanVar" value="#session.resultCustomerBean"></s:set>
		<table border = "0" style="width:100%; " id="customerList">
		<caption>
      		<b>单位信息</b>
        </caption>
		<tr class="demo-info">
            <th class="customerListTh">客户编号</th>
            <th class="customerListTh">单位名称</th>
            <th class="customerListTh">客户状态</th>
            <th class="customerListTh">单位账户</th>
            <th class="customerListTh">单位积分</th>
		</tr>
		<tr>
		 	<td class="customerListTd">
                <s:set var="guestNoVal" value="#resultCustomerBeanVar.guestNo"></s:set>
             	<span id="guestNo">${guestNoVal}</span>
            </td>
            <td class="customerListTd">
                <s:set var="companyNameVal" value="#resultCustomerBeanVar.companyName"></s:set>
             	<span id="companyName">${companyNameVal}</span>
            </td>
             <td class="customerListTd">
             	<s:set var="guestStatusVal" value="#resultCustomerBeanVar.guestStatus"></s:set>
             	<span id="guestStatus">${guestStatus[guestStatusVal]}</span>
            </td>
			<td class="customerListTd">
                <s:set var="spareAccountVal" value="#resultCustomerBeanVar.spareAccount"></s:set>
             	<span id="spareAccount">${spareAccountVal}</span>
            </td>
            <td class="customerListTd">
                <s:set var="guestScoreVal" value="#resultCustomerBeanVar.guestScore"></s:set>
             	<span id="guestScore">${guestScoreVal}</span>
            </td>
		</tr>
		</table>
		<table border = "0" style="width:100%; " id="cardList">
		<caption>
      		<b>卡片信息</b>
        </caption>
        <tbody>  
		<tr>
		   <th class="cardListTh">卡号</th>
           <th class="cardListTh">持卡人</th>
           <th class="cardListTh">卡片类型</th>
           <th class="cardListTh">卡状态</th>
           <th class="cardListTh">是否主卡</th>
           <th class="cardListTh">卡押金</th>
           <th class="cardListTh">卡余额</th>
           <th class="cardListTh">卡备用金</th>
           <th class="cardListTh">卡积分</th>
		</tr>
        <s:iterator var="cu" value="#resultCustomerBeanVar.customerDeleteList" status="statu">
        <tr>
        		<td class="cardListTd">
                	<s:property value="#cu.cardNo" />
                </td>
                <td class="cardListTd">
                	<s:property value="#cu.guestName" />
                </td>
                 <td class="cardListTd">
             		<s:set var="cardTypeVal" value="#cu.cardType"></s:set>
             		<s:if test="#cardTypeVal=='11'">
             			<span>单用户</span>
             		</s:if>
             		<s:elseif test="#cardTypeVal=='12'">
						<span>多用户</span>
					</s:elseif>
					<s:elseif test="#cardTypeVal=='13'">
						<span>不记名用户卡</span>
					</s:elseif>
					<s:elseif test="#cardTypeVal=='10'">
						<span>其他用户卡</span>
					</s:elseif>
					<s:elseif test="#cardTypeVal=='20'">
						<span>本单位</span>
					</s:elseif>
					<s:elseif test="#cardTypeVal=='90'">
						<span>特别用户</span>
					</s:elseif>
					<s:else>
						<span>未识别</span>
					</s:else>
           		 </td>
                <td class="cardListTd">
                	<s:set var="cardStatusVal" value="#cu.cardStatus"></s:set>
                	<s:if test="#cardStatusVal==0">
             			<span>未启用</span>
             		</s:if>
             		<s:elseif test="#cardStatusVal==1">
						<span>启用</span>
					</s:elseif>
					<s:elseif test="#cardStatusVal==2">
						<span>挂失</span>
					</s:elseif>
					<s:elseif test="#cardStatusVal==3">
						<span>作废</span>
					</s:elseif>
					<s:elseif test="#cardStatusVal==4">
						<span>注销</span>
					</s:elseif>
					<s:elseif test="#cardStatusVal==5">
						<span>灰卡</span>
					</s:elseif>
					<s:else>
						<span>未识别</span>
					</s:else>
                </td>
                <td class="cardListTd">
                	<s:set var="cardFlagVal" value="#cu.mainCardFlag"></s:set>
                	<s:if test="#cardFlagVal">
             			<span>是</span>
             		</s:if>
             		<s:else>
             			<span>否</span>
             		</s:else>
                </td>
                <td class="cardListTd">
                	<s:property value="#cu.deposit" />
                </td>
                <td class="cardListTd">
                	<s:property value="#cu.cardAccount" />
                </td>
                 <td class="cardListTd">
                	<s:property value="#cu.preAccount" />
                </td>
                 <td class="cardListTd">
                	<s:property value="#cu.cardScore" />
                </td>
	    </tr>
		</s:iterator>
		<tr>
	    	<th colspan="6">合计</th>
	    	<th class="cardListTh">
				<s:set var="accountSumVal" value="#resultCustomerBeanVar.accountSum"></s:set>
             	<span id="accountSum">
             		${accountSumVal}
             	</span>
	    	</th>
	    	<th class="cardListTh">
	    		<s:set var="preSumVal" value="#resultCustomerBeanVar.preSum"></s:set>
             	<span id="preSum">
             		${preSumVal}
             	</span>
	    	</th>
	    	<th class="cardListTh">
	    		<s:set var="scoreSumVal" value="#resultCustomerBeanVar.scoreSum"></s:set>
             	<span id="scoreSum">
             		${scoreSumVal}
             	</span>
	    	</th>
	    </tr>
	    </tbody>
		</table>
		<div style="width:100%; text-align:right;">
			<input type="button" value = "有卡销户" id="haveCardDelete">
			<input type="button" value = "无卡销户" id="noHaveCardDelete">
		</div>
		</TD>
		</TR>
	</TABLE>
	<div id="printCardDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width: 850px; height: 350px;">
		<iframe scrolling="auto" id='printCardIFrame' frameborder="0" src="" style="width: 100%; height: 100%;"></iframe>
	</div>
</body>
</html>