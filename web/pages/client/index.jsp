<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上订餐首页</title>

    <%-- 静态包含 css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>


    <Script type="text/javascript">
        $(function () {
            // 给加入购物车按钮绑定单击事件
            $("button.addToCart").click(function () {
                /**
                 * 在事件响应的 function 函数 中，有一个 this 对象，这个 this 对象，是当前正在响应事件的 dom 对象
                 * @type {jQuery}
                 */
                var foodId = $(this).attr("foodId");
                // location.href = "cartServlet?action=addItem&id=" + foodId;

                $.getJSON("cartServlet","action=ajaxAddItem&id=" + foodId,function (data) {
                    $("#cartTotalCount").text("您的购物车中有 " + data.totalCount + " 件商品");
                    $("#cartLastName").text(data.lastName);
                })

            });
        });
    </Script>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px" >
    <span class="wel_word">网上订餐</span>
    <div>
        <%-- 如果用户还没有登陆，显示[登陆和注册的菜单]--%>
        <c:if test="${empty sessionScope.suser.username}">
            <a href="../../pages/user/login.jsp">登录</a>
            <a href="../../pages/user/regist.jsp">用户注册</a> |
            <a href="../../pages/user/Sregist.jsp">商户注册</a>&nbsp;&nbsp;
        </c:if>
        <%-- 如果用户已经登陆，则显示登陆成功之后的用户信息--%>
        <c:if test="${not empty sessionScope.suser.username}">
            <span>欢迎<span class="um_span">${sessionScope.suser.username}</span>光临网上订餐</span>
            <a href="orderServlet?action=showMyOrders">我的订单</a>
            <a href="userServlet?action=logout">注销</a>&nbsp;&nbsp;
        </c:if>
        <a href="../../pages/cart/cart.jsp">购物车</a>
        <a href="../../pages/manager/manager.jsp">后台管理</a>
    </div>
</div>
<div id="main">
    <div id="food">
        <div class="food_cond">
            <form action="client/foodServlet" method="get">
                <input type="hidden" name="action" value="pageByPrice">
                价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
                     <input id="max" type="text" name="max" value="${param.max}"> 元
                     <input type="submit" value="查询" />
            </form>
        </div>
        <div style="text-align: center">
            <c:if test="${empty sessionScope.cart.items}">
                <%--购物车为空的输出--%>
                <span id="cartTotalCount"> </span>
                <div>
                    <span id="cartLastName" style="color: red">当前购物车为空</span>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.cart.items}">
                <%--购物车非空的输出--%>
                <span id="cartTotalCount">您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
                <div>
                    您刚刚将<span id="cartLastName" style="color: red">${sessionScope.lastName}</span>加入到了购物车中
                </div>
            </c:if>
        </div>

        <c:forEach items="${requestScope.page.items}" var="food">
            <div class="b_list">
                <div class="img_div">
                    <img class="food_img" alt="" src="${food.imgPath}" />
                </div>
                <div class="food_info">
                    <div class="food_name">
                        <span class="sp1">菜名:</span>
                        <span class="sp2">${food.name}</span>
                    </div>
                    <div class="food_sid">
                        <span class="sp1">店名:</span>
                        <span class="sp2">${food.sid}</span>
                    </div>
                    <div class="food_price">
                        <span class="sp1">价格:</span>
                        <span class="sp2">${food.price}</span>
                    </div>
                    <div class="food_sales">
                        <span class="sp1">销量:</span>
                        <span class="sp2">${food.sales}</span>
                    </div>
                    <div class="food_amount">
                        <span class="sp1">库存:</span>
                        <span class="sp2">${food.stock}</span>
                    </div>
                    <div class="food_add">
                        <button foodId="${food.id}" class="addToCart">加入购物车</button>
                    </div>
                </div>
            </div>
        </c:forEach>


    </div>

    <%-- 静态包含分页条--%>
    <%@include file="/pages/common/page_nav.jsp"%>

</div>


<%-- 静态包含页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>