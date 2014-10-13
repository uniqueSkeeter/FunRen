<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 1.0 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>" />
		<%@include file="common/public.jsp"%>
		<title>富仁高科加油站管理系统</title>
		<link rel="shortcut icon" type="image/x-icon"
			href="<%=basePath%>images/favicon.ico" />
		<script src="<%=basePath%>js/cookies.js" type="text/javascript"></script>
		<style type="text/css">
.yzm {
	background: url("images/field_text_bg.jpg") repeat scroll left center
		transparent;
	border: 1px solid #C5C5C5;
	padding: 6px;
	width: 98px;
}

#weweima {
	position: fixed;
	top: 350px;
	left: 1100px;
}
</style>
		<script type="text/javascript">
		<!--
			if(this != top){
				top.location.href = this.location.href;
			}
			
			$(function(){
				$("#selectStyle").val("<%=systemstyle%>");
			});
			
			function changest(obj){
				document.getElementById("st").href="<%=basePath%>css/"+$("#selectStyle").val()+".css";
				setCookie("systemstyle", obj.options[obj.selectedIndex].getAttribute("id"));
			}
			
			//验证码的加载
			function showCode(){
			    document.getElementById("codeId").src="<%=basePath%>view/common/image.jsp?id="+Math.random();
			}
		//-->
		</script>
	</head>
	<body class="body">
			<div class="header">
				<div class="logo">
				</div>
			</div>

			<div class="page">
				<div class="form_info">
				<div class="ts_mess">
						<font color="red" style="padding-left: 30px;"><s:property
								value="message" /> </font>
					</div>
					<font color="red"><s:fielderror /></font>
					<form  method="post" action="<%=basePath%>userLogin">
						<div class="left">
						<div class="field">
							<span class="title">用户名</span> 
							<input type="text" name="userName" value=""
								class="text" size="22">
						</div>
						<div class="field">
							<span class="title">密　码</span>
							<input type="password" name="userPass" value=""
								class="text" size="22">
						</div>
						<div class="field">
							<span class="title">验证码</span>
							<input type="text" title="验证码不能为空" maxlength="4" name="checkCode" id="yzm" class="yzm">
							<img id="codeId" name="codeId" height="28" width="60"
								style="vertical-align: bottom; cursor: pointer;" title="点我换下张图"
								border=0 onClick="javascript:showCode();"
								src="<%=basePath%>view/common/image.jsp">
						</div>
						</div>
						<div class="right">
							<button type="submit" class="button"></button>
						</div>
					</form>
				</div>
			</div>
		<div class="footer">
			<p>
				&copy;2014 FNST
			</p>
		</div>
	</body>
</html>
