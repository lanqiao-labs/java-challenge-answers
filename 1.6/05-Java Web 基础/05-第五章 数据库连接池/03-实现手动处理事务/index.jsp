<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>工资发放</title>
</head>
<body>
    <form method="get" action="/UserSalaryServlet">
        员工号：<input type="text" name="userId"><br>
        工资：<input type="text" name="salary" placeholder="请输入要转账的工资数"><br>
        <input type="reset" value="重置">&nbsp;&nbsp;<input type="submit" value="提交">
    </form>
</body>
</html>