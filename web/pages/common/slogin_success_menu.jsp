<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    
<div>
	<span>欢迎<span class="um_span">${ sessionScope.suser.username }</span>光临网上订餐系统</span>
	<input type="hidden" name="action" value="save" >
	<a href="pages/manager/food_edit.jsp">我的菜单</a>
	<a href="suserServlet?action=logout">注销</a>&nbsp;&nbsp;
	<a href="javascript:history.back()">返回</a>
</div>    