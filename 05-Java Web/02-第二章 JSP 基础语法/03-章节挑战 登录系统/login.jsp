<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form method="post" action="checkLogin.jsp">
        <label for="username">用户名：</label><input id="username" type="text" name="userName">
        <br>
        <label for="userpwd">密&nbsp;&nbsp;&nbsp;码：</label><input id="userpwd" type="password" name="userPwd">
        <br>
        <input type="submit" value="登录">
    </form>
</body>
</html>