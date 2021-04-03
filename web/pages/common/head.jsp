<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/1/22
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + "/";
    pageContext.setAttribute("basePath",basePath);
%>

<%-- 写动态 base 标签--%>
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="../../static/css/style.css" >
<script type="text/javascript" src="../../static/script/jquery-1.7.2.js"></script>
