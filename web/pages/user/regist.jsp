<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/21
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>网上订餐会员注册页面</title>

    <%-- 静态包含 css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>

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

                // 获取确认密码
                var repwdValue = $("#repwd").val();
                // 验证确认密码和密码一致
                if (passwordValue != repwdValue) {
                    // 提示用户
                    $("span.errorMsg").text("确认密码和密码不一致！");
                    return false;
                }

                // 获取用户名
                var emailValue = $("#email").val();
                // 验证邮件输入是否合法。
                var emailReg = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;

                if (!emailReg.test(emailValue)) {
                    // 提示用户
                    $("span.errorMsg").text("邮件输入不合法！");
                    return false;
                }
                var addressValue = $("#address").val();
                var phoneValue = $("#phone").val();



                return true;
            });

        });

    </script>
    <style type="text/css">
        .login_form{
            height:420px;
            margin-top: 25px;
        }

    </style>
</head>
<body>
<div id="login_header">
    <img class="logo_img" alt="" src="../../static/img/login1.jpg" height="90px" width="90px" >
</div>

<div class="login_banner">

    <div id="l_content">
        <span class="login_word">欢迎注册</span>
    </div>

    <div id="content">
        <div class="login_form">
            <div class="login_box">
                <div class="tit">
                    <h1>注册网上订餐会员</h1>
                    <span class="errorMsg">
<%--									<%=request.getAttribute("rst")==null?"":request.getAttribute("rst")%>--%>
									${ requestScope.rst }
								</span>
                </div>
                <div class="form">
                    <form action="userServlet" method="post">
                        <input type="hidden" name="action" value="register">
                        <label>用户名称：</label>
                        <input class="itxt" type="text" placeholder="请输入用户名"
                               value="${ requestScope.username }"
                               autocomplete="off" tabindex="1" name="username" id="username" />
                        <br />
                        <br />
                        <label>用户密码：</label>
                        <input class="itxt" type="password" placeholder="请输入密码"
                               autocomplete="off" tabindex="1" name="password" id="password" />
                        <br />
                        <br />
                        <label>确认密码：</label>
                        <input class="itxt" type="password" placeholder="确认密码"
                               autocomplete="off" tabindex="1" name="repwd" id="repwd" />
                        <br />
                        <br />
                        <label>电子邮件：</label>
                        <input class="itxt" type="text" placeholder="请输入邮箱地址"
                               value="${ requestScope.email }"
                               autocomplete="off" tabindex="1" name="email" id="email" />
                        <br />
                        <br />
                        <label>送餐地址：</label>
                        <input class="itxt" type="text" placeholder="请输入送餐地址" autocomplete="off" tabindex="1" name="address" id="address" />
                        <br />
                        <br />
                        <label>联系电话：</label>
                        <input class="itxt" type="text" placeholder="请输入联系电话"
                               autocomplete="off" tabindex="1" name="phone" id="phone" />
                        <br />
                        <br />
                        <input type="submit" value="注册" id="sub_btn" />

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