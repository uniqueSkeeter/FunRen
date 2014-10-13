<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>

<html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<script type="text/javascript" src="<%=basePath%>js/system/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/system/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/card/employee/employee.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/card/employee/emplAdd.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/card/employee/emplModify.js"></script>
	
</head>
<body>
	<TABLE style="font-size: 9px; font-family: Arial; table-layout: fixed; width: 100%; height: 79%">
		<tr>
			<td width="86%" valign="top" style="border-left: #7BAED5 solid 0px; padding-left: 2px">
				<div class="title">员工一览</div>
				<hr>
				<table style="font-size: 12px;width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="3px" style="width:80px">员工名称:
						<td height="30px" >
							<input name="employeeBean.employeeName" style="width:140px" id="emplName"></input>
						</td>
						<td height="30px" width="80px">员工编号:</td>
						<td height="30px" width="80px">
							<input name="employeeBean.employeeNum" style="width:140px" id="emplNum"></input>
						</td>
						<td height="30px" width="80px">岗位类型:</td>
						<td height="30px" width="50px">
							<select name="employeeBean.shiftType" id="shiftType" style="width:140px">
								<option selected>   </option>
								<c:forEach var="shifType" items="${shiftType}">
									<option value="${shifType.key}">
										${shifType.value}
									</option>
								</c:forEach>
							</select>
						</td>
						<!--  
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
						-->
						<td height="30px" width="80px">
						<td><input type='button' value='检&nbsp;索' id="empl_search"></td>
					</tr>
					<tr>
						<td height="30px" width="80px">开始时间:</td>
						<td height="30px" width="80px">
							<input name="employeeBean.startDate" id="datepicker1" readonly="readonly"/>
						<td height="30px" width="80px">结束时间:</td>
						<td height="30px" width="80px">
							<input name="employeeBean.endDate" id="datepicker2" readonly="readonly"/>
						</td>
						<td height="30px" width="80px">所在班次:</td>
						<td height="30px" width="80px">
							<input name="employeeBean.shiftNum" style="width:140px" id="shiftNum"/>
						</td>
						<td height="30px" width="80px">
						<td><input type='button' value='&nbsp;导&nbsp;出' id="cus_report"></td>
					</tr>
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
				<table id="dg" title="员工一览">
					<!-- data-options="rownumbers:true,singleSelect:true,pagination:true,refresh:false,remoteSort:false,columns:employeecolumns"> -->
				</table>
				
			</td>
		</tr>
	</TABLE>
<!-- 	<div id="d2" class="easyui-dialog" title="Another Dialog" style="width:400px;height:200px;left:100px;top:150px;padding:10px" -->
<!-- 			toolbar="#dlg-toolbar" buttons="#dlg-buttons" resizable="true"> -->
<!-- 		Dialog toolbar and buttons are created from existing HTML nodes. -->
<!-- 	</div> -->
	<div id="addEmployeeDialog" class="easyui-window" closed="true" modal="true" title="标题" style="width:800px;height:350px;"> 
    	<iframe scrolling="auto" id='addEmployeeIFrame' frameborder="0"  src="" style="width:100%;height:100%;"></iframe> 
	</div>   
</body>