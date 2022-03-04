<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>信息填写</title>
</head>
<body>
    <form action="/UserControl" method="get">
        姓名：<input type="text" name="userName"><br/>
        性别：<input type="radio" name="userGender" value="1">男&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="userGender" value="0">女<br/>
        年龄：<input type="text" name="userAge"><br/>
        民族：<input type="text" name="userNation"><br/>
        邮箱：<input type="text" name="userEmail"><br/>
        电话：<input type="text" name="userPhone"><br/>
        家庭住址：<input type="text" name="userAddr"><br/>
        <input type="submit" value="提交">
    </form>
</body>
</html>