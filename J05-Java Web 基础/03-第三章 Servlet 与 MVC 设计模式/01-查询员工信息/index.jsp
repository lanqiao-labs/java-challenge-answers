<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询员工信息</title>
</head>
<body>
    <form action="/findEmpByEid" method="get">
        工号：<input type="text" name="empId"><input type="submit" value="搜索">
    </form>
</body>
</html>
