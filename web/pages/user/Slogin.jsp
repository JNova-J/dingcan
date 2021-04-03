<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/22
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上订餐会员登录页面</title>

    <script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        // 页面加载完成之后
        $(function(){

            // 给注册按钮添加事件
            $("#sub_btn").click(function(){

                // 获取用户名
                var usernameValue = $("#username").val();
                // 验证用户名是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
                var usernameReg = /^\w{5,15}$/;
                // 验证用户信息
                if (!usernameReg.test(usernameValue)) {
                    // 提示用户
                    $("span.errorMsg").text("用户名不合法！");
                    return false;
                }

                // 获取密码
                var passwordValue = $("#password").val();
                // 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
                var passwordReg = /^\w{5,15}$/;
                // 验证用户信息
                if (!passwordReg.test(passwordValue)) {
                    // 提示用户
                    $("span.errorMsg").text("密码不合法！");
                    return false;
                }

                // 阻止表单提交
                return true;
            });

        });

    </script>

    <link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px" >
    <span class="login_header">民以食为天</span>
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎登录</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>商户会员</h1>
                    <a href="../../pages/user/Sregist.jsp">立即注册</a>
                </div>
                <div class="msg_cont">
                    <b></b>
                    <span class="errorMsg">
                        <%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>
                    </span>
                </div>
                <div class="form">
                    <form action="suserServlet" method="post">
                        <input type="hidden" name="action" value="login" />
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off"
                               tabindex="1" name="username" id="username" value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
                               tabindex="1" name="password" id="password"
                        />
                        <br />
                        <br />
                        <input type="submit" value="登录" id="sub_btn" />
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="bottom">
			<span>
				网上订餐 装操快乐
			</span>
</div>
</body>
</html>