<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>编辑菜品</title>

	<!-- 头部共享信息的引入。包含jquery，base标签，以及css样式 -->
	<%@ include file="/pages/common/head.jsp" %>

	<style type="text/css">
		h1 {
			text-align: center;
			margin-top: 200px;
		}

		h1 a {
			color:red;
		}

		input {
			text-align: center;
		}
	</style>
</head>
<body>

<div id="header">
	<img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px">
	<span class="wel_word">编辑菜品</span>

	<!-- 这是manager管理模块的共同菜单  -->
	<%@ include file="/pages/common/manager_menu.jsp" %>

</div>

<div id="main">
	<form action="${pageContext.request.contextPath}manage/foodServlet" method="post">
		<input type="hidden" name="action" value="${empty param.id ? "add" : "update"}" />
		<input type="hidden" name="id" value="${empty requestScope.food.id}" />
		<input type="hidden" name="suid" value="${empty requestScope.food.suid}" />
		<c:choose>
			<c:when test="${ empty food }">
				<input type="hidden" name="action" value="add" />
			</c:when>
			<c:otherwise>
				<input type="hidden" name="action" value="update" />
				<input type="hidden" name="id" value="${ food.id }" />
			</c:otherwise>
		</c:choose>

		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>商家</td>
				<td>销量</td>
				<td>库存</td>
				<td>商家id</td>
				<td colspan="2">操作</td>
			</tr>
			<tr>

				<td><input name="name" type="text" value="${ requestScope.food.name }"/></td>
				<td><input name="price" type="text" value="${ requestScope.food.price }"/></td>
				<td><input name="sid" type="text" value="${ sessionScope.suser.pusername }"/></td>
				<td><input name="sales" type="text" value="${ requestScope.food.sales }"/></td>
				<td><input name="stock" type="text" value="${ requestScope.food.stock }"/></td>
				<td><input name="suid" type="text" value="${ sessionScope.suser.id }"/></td>
				<td><input type="submit" value="提交"/></td>
			</tr>
		</table>

	</form>
</div>

<!-- 这是页脚的引入 -->
<%@ include file="/pages/common/footer.jsp" %>

</body>
</html>