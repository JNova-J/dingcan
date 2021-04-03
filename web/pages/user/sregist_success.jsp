<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath =request.getScheme()
			+ "://"
			+ request.getServerName()
			+ ":"
			+ request.getServerPort()
			+ request.getContextPath()
			+"/";
%>
<%=basePath %>
<base href="<%=basePath %>">
<html>
<head>
	<meta charset="UTF-8">
	<title>网上订餐会员注册页面</title>
	<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}
	</style>
</head>
<body>
<div id="header">
	<img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px">
	<span class="wel_word"></span>
	<%@include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

	<h1>注册成功! <a href="../../index.jsp">转到主页</a></h1>

</div>

<%-- 静态包含页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>
</body>
</html>