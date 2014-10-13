<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>

<html>
<%@include file="../../common/common.jsp" %>
<!--<script type="text/javascript" src="js/card/employee/employee.js"></script>
<script type="text/javascript" src="js/card/employee/emplRole.js"></script>
<script type="text/javascript" src="js/card/employee/emplAdd.js"></script>-->
</head>
<body>

	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 79%">
		<tr>
			<td width="86%" valign="top"
				style="border-left: #7BAED5 solid 0px; padding-left: 2px">

				<div class="title">卡片一览</div>
				<hr>
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="3px" width="10px">卡片类型:
						<td height="30px" width="50px">
							<select name="cardBean.cardType" id="cardType" style="width:140px">
								<c:forEach var="cardType" items="${cardType }">
									<option value="${cardType.key }">
										${cardType.value }
									</option>
								</c:forEach>
							</select>
						</td>
						<td height="30px" width="50px">单据类型:</td>
						<td height="30px" width="50px">
							<!-- should be corrected!!!!! -->
							<select name="cardBean.cardType" id="cardType" style="width:140px">
								<c:forEach var="cardType" items="${cardType }">
									<option value="${cardType.key }">
										${cardType.value }
									</option>
								</c:forEach>
							</select>
						</td>
						<td height="30px" width="80px">单据状态:</td>
						<td height="30px" width="50px">
							<!-- should be corrected!!!!! -->
							<select name="employeeBean.shiftType" id="shiftType" style="width:140px">
								<option selected>   </option>
								<c:forEach var="shifType" items="${shiftType}">
									<option value="${shifType.key}">
										${shifType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<td hidden="true">
							<select name="employeeBean.shiftStatus" id="shiftStatus" style="width:140px">
								<option selected>   </option>
								<c:forEach var="shifSta" items="${shiftStatus}">
									<option value="${shifSta.key}">
										${shifSta.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<!-- <td height="30px" width="80px">
						<td><input type='button' value='检&nbsp;索' id="empl_search"></td> -->
					</tr>
					<tr>
						<td height="30px" width="80px">起始日期:</td>
						<td height="30px" width="80px" style="width:30px">
							<input name="cardListBean.startDate" id="datepicker1" class="easyui-datetimebox" style="width:140px" editable="false" showSeconds="false"/>
						<td height="30px" width="80px">结束日期:</td>
						<td height="30px" width="80px" style="width:30px">
							<input name="shiftChangeBean.shiftDate" id="datepicker1" class="easyui-datetimebox" style="width:140px" editable="false" showSeconds="false"/>
						</td>

						<td height="30px" width="80px">
						<td><input type='button' value='&nbsp;查&nbsp;询' id="cardList_search"></td>
					</tr>
					<tr>
						<td height="30px" width="80px"></td>
						<td height="30px" width="80px"></td>
						<td height="30px" width="80px"></td>
						<td height="30px" width="80px"></td>
						<td height="30px" width="80px">
						<td><input type='button' value='&nbsp;申&nbsp;请' id="card_apply"></td>
						<td height="30px" width="80px">
						<td><input type='button' value='&nbsp;编&nbsp;辑' id="card_edit"></td>
						
				</table>
				<hr />
				<div class="btArea">
					<c:forEach var="item" items="${topNaviMenuMap['EMPLOYEE_NAVI_MENU']}" varStatus="status">
						<c:if test="${status.index == 0}">
							<input icon='icon-add' type='button' value='${item.text}' id='${item.url}'>
						</c:if>
						<c:if test="${status.index == 1}">
							<input icon='icon-edit' type='button' value='${item.text}' id='${item.url}'>
						</c:if>
						<c:if test="${status.index == 2}">
							<input type='button' value='${item.text}' id='${item.url}'>
						</c:if>
					</c:forEach>
				</div><br />
				<table id="dg" title="卡片一览"
					data-options="rownumbers:true,singleSelect:true,pagination:true,refresh:false,remoteSort:false,columns:employeecolumns">
				</table>
				
			</td>
		</tr>

	</TABLE>
</body>