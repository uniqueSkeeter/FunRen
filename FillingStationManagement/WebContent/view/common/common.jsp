<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="java.util.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":"
        + request.getServerPort() + path + "/";
%>


	<!-- css -->
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/demo.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/system/system.css">

	<!-- js -->
	<script type="text/javascript" src="<%=basePath%>js/system/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/system/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common/common.js"></script>
	<!-- localization -->
	<script type="text/javascript" src="<%=basePath%>js/system/locale/easyui-lang-zh_CN.js"></script>