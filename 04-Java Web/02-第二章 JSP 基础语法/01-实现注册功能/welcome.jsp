<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <%
        String uname = new String(request.getParameter("uname").getBytes("iso-8859-1"), "utf-8");
        String upwd = new String(request.getParameter("upwd").getBytes("iso-8859-1"), "utf-8");
        String realname = new String(request.getParameter("realname").getBytes("iso-8859-1"), "utf-8");
        String tel = new String(request.getParameter("tel").getBytes("iso-8859-1"), "utf-8");
    %>
    <p>用户名：<%=uname%></p>
    <p>密码：<%=upwd%></p>
    <p>真实姓名：<%=realname%></p>
    <p>电话号码：<%=tel%></p>
</body>
</html>