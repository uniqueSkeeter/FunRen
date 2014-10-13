<%@ page language="java" pageEncoding="UTF-8"%>
<%
	String path2 = request.getContextPath();
	String basePath2 = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path2 + "/";
	//取得所有的cookies
	Cookie[] cookieArray = request.getCookies();
	String systemstyle = "css1";//默认是第一套皮肤
	if(cookieArray != null && cookieArray.length > 0)
	{
		for (Cookie cookie : cookieArray) {
		   if (cookie.getName().equals("systemstyle")) {
		   	systemstyle = cookie.getValue();
		   }
	  	}
	}
  	out.print("<link rel='stylesheet' type='text/css' id='st' href='"+basePath2+"css/"+systemstyle+".css' />");
%>
<script type="text/javascript" src="<%=basePath2%>js/jquery.js"></script>

