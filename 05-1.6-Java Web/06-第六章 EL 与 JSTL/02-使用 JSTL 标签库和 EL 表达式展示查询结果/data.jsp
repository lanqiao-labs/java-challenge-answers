<%@ page import="org.lanqiao.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入 JSTL 标签库--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 打开 EL 表达式 --%>
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
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.userName}</td>
                <td>
                    <c:choose>
                        <c:when test="${user.userGender==0}">
                            女
                        </c:when>
                        <c:otherwise>
                            男
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${user.userAge}</td>
                <td>${user.userNation}</td>
                <td>${user.userEmail}</td>
                <td>${user.userPhone}</td>
                <td>${user.userAddr}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>