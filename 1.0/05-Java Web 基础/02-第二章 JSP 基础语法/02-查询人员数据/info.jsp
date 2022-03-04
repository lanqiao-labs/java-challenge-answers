<%@ page import="java.util.ArrayList" %>
<%@ page import="org.lanqiao.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
    <table border="1"  style="width: 300px;text-align: center;">
        <thead>
            <tr>
                <td>用户名</td>
                <td>密码</td>
                <td>真实姓名</td>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
                for(User u : users){
            %>
            <tr>
                <td><%=u.getUserName() %></td>
                <td><%=u.getUserPwd() %></td>
                <td><%=u.getNickName() %></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>