<%@ page contentType="text/html;charset=UTF-8" language="java" import="org.lanqiao.entity.User,java.util.List,org.lanqiao.entity.Page" %>
<html>
<head>
    <title>学生信息显示列表</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>民族</th>
        <th>邮箱</th>
        <th>电话</th>
        <th>家庭住址</th>
    </tr>

    <%
        // 获取带数据的分页帮助类对象
        Page pages = (Page) request.getAttribute("pages");
        // 总页数
        int totalPages = pages.getTotalPage();
        //当前页的页码
        int pageIndex = pages.getCurrentPage();
        //获取当前页中的学生数据集合
        List<User> users = pages.getUsers();
        if (users != null) {
            for (User user : users) {
    %>
    <tr>
        <td><%=user.getUserId() %></td>
        <td><%=user.getUserName() %></td>
        <td><%=user.getUserGender()==0?"女":"男" %></td>
        <td><%=user.getUserAge() %></td>
        <td><%=user.getUserNation() %></td>
        <td><%=user.getUserEmail()%></td>
        <td><%=user.getUserPhone()%></td>
        <td><%=user.getUserAddr()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
当前页数：[<%= pageIndex%>/<%=totalPages%>]
<%
    //只要不是首页，则都可以单击“首页”和“上一页”
    if (pageIndex > 1) {
%>
    <%-- 通过用户点击超链接，将页码传递给Servlet --%>
    <a href="UserControl?myrequest=queryByPage&currentPage=1">首页</a>&nbsp;<a href="UserControl?myrequest=queryByPage&currentPage=<%= pageIndex -1%>">上一页</a>
<% }
    //只要不是末页，则都可以单击“下一步”和“末页”
    if (pageIndex < totalPages) {
%>
<%-- 通过用户点击超链接，将页码传递给Servlet --%>
    <a href="UserControl?myrequest=queryByPage&currentPage=<%= pageIndex +1%>">下一页</a>
    <a href="UserControl?myrequest=queryByPage&currentPage=<%=totalPages%>">末页</a>
<%
    }
%>
</body>
</html>