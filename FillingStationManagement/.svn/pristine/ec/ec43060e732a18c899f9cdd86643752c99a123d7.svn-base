<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<title>富仁高科加油站管理系统</title>

<link rel="shortcut icon" type="image/x-icon"
	href="<%=basePath%>images/favicon.ico" />
<%-- <script src="<%=basePath%>js/cookies.js" type="text/javascript"></script> --%>
<!-- common -->
<link href="css/common.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.2.custom.js"></script>
<link type="text/css" href="css/ui-lightness/jquery-ui-1.9.2.custom.css"
	rel="stylesheet" />
<!-- tree -->
<link rel="stylesheet" href="css/tree/demoStyle/demo.css"
	type="text/css">
<link rel="stylesheet" href="css/tree/zTreeStyle/zTreeStyle.css"
	type="text/css">
<link rel="stylesheet" href="css/tree/zTreeStyle/zTreeIcons.css"
	type="text/css">
<script type="text/javascript" src="js/tree/jquery-ztree-2.0.js"></script>
<script type="text/javascript" src="js/tree/demo.js"></script>


<!-- grid -->
<link href="css/grid/themes/redmond/ui.css" type="text/css"
	rel="stylesheet" />
<link href="css/grid/grid.css" type="text/css" rel="stylesheet" />
<script src="js/grid/grid.js" type="text/javascript"></script>

<!-- dialog -->
<script type="text/javascript" src="dialog/artDialog.js?skin=blue"></script>
<link rel="STYLESHEET" type="text/css" href="css/dialog/default.css">
<script type="text/javascript" src="dialog/iframeTools.source.js"></script>

<!-- button -->
<link rel="STYLESHEET" type="text/css" href="css/button/button.css">
<link rel="STYLESHEET" type="text/css" href="css/button/icon.css">
<script type="text/javascript" src="js/button/button.js"></script>
<link rel="STYLESHEET" type="text/css" href="css/button/icon.css">

<script type="text/javascript">
	$(function() {
		$("#tabs").tabs();
	});
</script>
<style type="text/css">
</style>
</head>
<body onload="reloadTree('1')">

	<jsp:include page="common/head.jsp" flush="true"></jsp:include>

	<div id="tabs">
		<ul style="padding-left: 15%">

			<li><a href="#tabs-custom">客户管理</a></li>
			<li><a href="#tabs-card">卡片管理</a></li>
			<li><a href="#tabs-datacenter">数据中心</a></li>
			<li><a href="#tabs-sysmanger">系统管理</a></li>
			<li><a href="#tabs-report">报表</a></li>
		</ul>
		<div>Technical error,Please Contant The System Manager</div>
	</div>

</body>