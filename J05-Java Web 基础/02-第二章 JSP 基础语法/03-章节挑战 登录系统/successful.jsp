<%@ page import="org.lanqiao.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功</title>
</head>
<body>
    <%
        User loginUser = (User) session.getAttribute("loginUser");
    %>
    <p>登陆成功！欢迎<strong><%=loginUser.getNickName()%>!</strong></p>
</body>
</html>