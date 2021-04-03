<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/22
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上订餐会员登录页面</title>

    <%-- 静态包含 css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>

</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>网上订餐会员</h1>
                    <a href="../../pages/user/regist.jsp">立即注册</a>
                    <a href="../../pages/user/Slogin.jsp">商户登陆</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
<%--									表达式脚本--%>
<%--									<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
<%--									EL 表达式--%>
									${ empty requestScope.msg  ? "请输入用户名和密码":requestScope.msg }
								</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="login">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               autocomplete="off" tabindex="1" name="username"
                               value="${ requestScope.username }" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<%-- 静态包含页脚内容 --%>
<%@include file="/pages/common/footer.jsp"%>

</body>
</html>