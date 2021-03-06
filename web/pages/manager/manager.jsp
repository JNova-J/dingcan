<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>后台管理</title>

	<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 -->
	<%@ include file="/pages/common/head.jsp" %>

	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}
	</style>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px">

	<!-- 这是manager管理模块的共同菜单  -->
	<%@ include file="/pages/common/manager_menu.jsp" %>


</div>

<div id="main">
	<h1>欢迎管理员进入后台管理系统</h1>
</div>


<!-- 这是页脚的引入 -->
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>