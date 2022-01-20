<%@ page import="org.lanqiao.jdbc.JdbcUtil" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="org.lanqiao.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        // 获取链接
        Connection conn = JdbcUtil.getConn();
        // 准备sql
        String sql = "select * from users";
        // 获取 prepareStatement 对象
        PreparedStatement ps = conn.prepareStatement(sql);
        try {
            // 获取结果集
            ResultSet resultSet = ps.executeQuery();
            // 创建集合
            ArrayList users = new ArrayList<User>();
            // 循环创建对象
            while (resultSet.next()){
                // 创建对象
                User user  = new User(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
                // 将对象存入集合中
                users.add(user);
            }
            request.setAttribute("users",users);
            request.getRequestDispatcher("info.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    %>
</body>
</html>