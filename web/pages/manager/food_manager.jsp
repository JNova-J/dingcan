<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/30
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>菜单管理</title>
    <%-- 静态包含 css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>

    <script type="text/javascript">
        $(function () {
            //在事件的 function 函数中，有一个 this 对象。这个 this 对象是当前正在响应的 dom 对象。
            //给删除的 a 标签绑定单击事件，用于删除的确认提示操作
            $("a.deleteClass").click(function () {
                /*
                confirm 是确认提示框函数
                参数是它的提示内容
                它有两个按钮，一个确认，一个是取消。
                返回 true 表示点击了确认，返回 false 表示点击取消。
                 */
                return confirm("您确定要删除 " + $(this).parent().parent().find("td:first").text() +" 吗？");
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/login1.jpg" height="90px" width="90px">
    <span class="wel_word">菜单管理系统</span>

    <%-- 静态包含 manager 管理模块的菜单 --%>
    <%@include file="/pages/common/manager_menu.jsp"%>

</div>


<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>店家</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>


<c:if test="${not empty requestScope.page}">
        <c:forEach items="${requestScope.page.items}" var="food">
            <tr>
                <td>${food.name}</td>
                <td>${food.price}</td>
                <td>${food.sid}</td>
                <td>${food.sales}</td>
                <td>${food.stock}</td>
                <td>${food.suid}</td>
                <td><a href="manage/foodServlet?action=getFood&id=${food.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteClass" href="manage/foodServlet?action=delete&id=${food.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>
</c:if>
        <c:if test="${empty requestScope.page}">
            <td colspan="4"><a href="/pages/manager/food_edit.jsp">当前没有菜单信息，过去添加界面进行添加吧！</a></td>
        </c:if>
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/food_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加菜品</a></td>
        </tr>
    </table>
    <%-- 静态包含分页条--%>
    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<div id="bottom">
		<span>
			网上订餐 快乐生活
		</span>
</div>
</body>
</html>
