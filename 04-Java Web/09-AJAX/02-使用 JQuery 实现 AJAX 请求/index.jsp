<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
    <script src="https://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>

<body>
<input type="text" name="username" id="username"><input type="button" value="搜索" id="search">
<div id="data">

</div>
</body>
<script type="text/javascript">
    var search = $("#search");
    search.click(()=>{
        console.log(11+21);
        var $username = $("#username").val();
        var $data = $("#data");
        $.get(
            "UserServlet",
            "username="+$username,
            (data,status)=>{
                if(status == "success"&&data!="[]"){
                    $data.html(data);
                }else{
                    $data.html("<span style='color: red'>查无此人</span>");
                }
            }
        )
    })
</script>
</html>