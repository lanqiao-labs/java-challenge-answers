<%@ page import="org.lanqiao.entity.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工信息</title>
</head>
<body>
<table border="1">
    <thead>
        <tr>
            <td>工号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>邮箱地址</td>
            <td>家庭住址</td>
        </tr>
    </thead>
    <tbody>
        <%
            Employee employee = (Employee) request.getAttribute("employee");
        %>
        <tr>
            <td><%=employee.getEmployeeId()%></td>
            <td><%=employee.getEmployeeName()%></td>
            <td><%=employee.getEmployeeGender()==1?"男":"女"%></td>
            <td><%=employee.getEmployeePhone()%></td>
            <td><%=employee.getEmployeeEmail()%></td>
            <td><%=employee.getEmployeeAddr()%></td>
        </tr>
    </tbody>
</table>
</body>
</html>