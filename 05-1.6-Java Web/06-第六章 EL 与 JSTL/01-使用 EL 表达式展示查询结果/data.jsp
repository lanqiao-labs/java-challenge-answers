<%@ page import="org.lanqiao.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>所有用户信息</title>
</head>
<body>
<table border="1">
    <thead>
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>民族</td>
            <td>邮箱</td>
            <td>电话</td>
            <td>地址</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>${requestScope.user.userId}</td>
            <td>${requestScope.user.userName}</td>
            <td>${requestScope.user.userGender}</td>
            <td>${requestScope.user.userAge}</td>
            <td>${requestScope.user.userNation}</td>
            <td>${requestScope.user.userEmail}</td>
            <td>${requestScope.user.userPhone}</td>
            <td>${requestScope.user.userAddr}</td>
        </tr>
    </tbody>
</table>
</body>
</html>