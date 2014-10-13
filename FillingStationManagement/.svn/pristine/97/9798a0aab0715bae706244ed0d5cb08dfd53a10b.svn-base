<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
        + request.getServerPort() + path + "/";
%>

<html>
<head>
<title>富仁高科加油站管理系统</title>
<base href="<%=basePath%>" />


<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>images/favicon.ico" />
<link href="css/common.css" rel="stylesheet" type="text/css" />

<!-- 基本Jquery -->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" />


<link rel="stylesheet" type="text/css"
	href="grid/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="grid/themes/icon.css">
<script type="text/javascript" src="grid/jquery.easyui.min.js"></script>

<!-- button -->
<link rel="STYLESHEET" type="text/css" href="css/button/button.css">
<link rel="STYLESHEET" type="text/css" href="css/button/icon.css">
<script type="text/javascript" src="js/button/button.js"></script>
<link rel="STYLESHEET" type="text/css" href="css/button/icon.css">



<link href="css/custom/customList.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/common/gridcomm.js"></script>
<script type="text/javascript" src="js/card/custom/customList.js"></script>

</head>
<body>

	<TABLE style="font-size: 12px; font-family: Arial; table-layout: fixed; width: 100%; height: 79%">

		<tr>

			<td width="14%" valign="top"><jsp:include
					page="../../common/left.jsp" flush="false"></jsp:include></td>
			<td width="86%" valign="top"
				style="border-left: #7BAED5 solid 2px; padding-left: 2px">
				<div class="title">客户一览</div>

				<hr>
				<table style="font-size: 12px; width: 100%; height: 50px; font-weight: bold;">
					<tr>
						<td height="30px" width="80px"><p>用户类型：</p>
						<td height="30px" width="80px"><s:select list="userTypeCom"
								name="userType" theme="simple" cssClass="preselect"></s:select></td>
						<td height="30px" width="80px"><p>证件类型：</p></td>
						<td height="30px" width="80px"><s:select list="credType"
								name="idcardType"
								onchange="credselect(this.options[this.options.selectedIndex].value)"
								theme="simple" cssClass="preselect"></s:select></td>
						<td height="30px" width="80px"><p>证件号码：</p></td>
						<td height="30px" width="80px"><s:textfield id="idcardNum"
								onkeyup="value=value.replace(/[^\d]/g,'')" name="idcardNum"
								disabled="true" size="20" maxlength="20" theme="simple"
								cssStyle="width:140px"></s:textfield></td>
						<td width="85px"><input icon='icon-search' type='button'
							value='检&nbsp;索' id="cus_search"></td>
					</tr>
					<tr>


						<td height="30px" width="40px"><p>状态：</p></td>
						<td height="30px" width="80px"><s:select list="customStats"
								name="stats" theme="simple" cssClass="preselect"></s:select></td>
						<td height="30px" width="80px"><p>开始时间：</p></td>
						<td height="30px" width="80px"><input type="text"
							name="beginDate" readonly=true id="datepicker1"
							style="width: 80px"></td>

						<td height="30px" width="80px"><p>结束时间：</p></td>
						<td height="30px" width="80px"><input type="text"
							name="endDate" readonly=true id="datepicker2" style="width: 80px"></td>
						<td width="85px"><input icon='icon-excel' type='button'
							value='导&nbsp;出' id="cus_report"></td>
					</tr>
				</table>
				<hr>
				<div class="btArea">
					<input icon='icon-add' type='button' value='注&nbsp;册' id="cus_add">
					<input icon='icon-cmp' type='button' value='发&nbsp;卡'> <input
						icon='icon-org' id="cus_pay"  type='button' value='交&nbsp;费'> <input
						icon='icon-edit' type='button' value='编&nbsp;辑' id="cus_modify"> <input
						type='button' value='预分配'> <input icon='icon-delete'
						type='button' value='注销/退费'>
				</div> <br>
				<table id="dg" title="客户一览"
					data-options="rownumbers:true,singleSelect:true,pagination:true,refresh:false,remoteSort:false,columns:customcolumns">

				</table>

			</td>
		</tr>

	</TABLE>
</body>