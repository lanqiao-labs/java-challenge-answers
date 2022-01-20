<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="org.lanqiao.entity.User"%>
<%@page import="org.lanqiao.control.LoginControl"%>
<html>
<head>
    <title>登录校验</title>
</head>
<body>
    <%
        // 获取登陆输入的数据
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        
        // 封装登录数据，调用登陆控制器对应方法，校验登陆
        User user = new User(userName,userPwd);
        System.out.println(user);
        LoginControl lc = new LoginControl();
        User loginUser = lc.Login(user);
        System.out.println(loginUser);
        // 若返回的对象为 null 则表示用户名密码错误，若对象不为 null 则表示用户登录成功。
        if(loginUser == null){
            // 登陆失败跳转错误页面。
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }else{
            // 登陆成功将对象存入 session 并跳转成功页面。
            session.setAttribute("loginUser",loginUser);
            request.getRequestDispatcher("successful.jsp").forward(request,response);
        }
    %>
</body>
</html>