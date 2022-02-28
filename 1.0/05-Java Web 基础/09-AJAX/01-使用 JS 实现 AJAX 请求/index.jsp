<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询用户</title>
</head>
<body>
<input type="text" name="username" id="username"><input type="button" value="搜索" id="search"><span style="color: #ff0000" id="info"></span>
<div id="data">

</div>

</body>
<script type="text/javascript">
    var search = document.getElementById(`search`);
    search.addEventListener("click",()=>{
        // 获取搜索框内容
        var $username =  document.getElementById(`username`).value;
        //（注意：xmlHttpRequest 前没有 var，所以是一个全局变量）
        xmlHttpRequest = new XMLHttpRequest();
        // 2.设置回调函数（注意：回调函数的名字后面没有小括号“()”）
        xmlHttpRequest.onreadystatechange = callBack;
        // 3.初始化 XMLHttpRequest 对象的参数值
        var url = "UserServlet";
        var data = "username=" + $username;
        xmlHttpRequest.open("get", url+"?"+data, true);
        // 4.发送 HTTP 请求
        xmlHttpRequest.send(data);
    })
    // AJAX 回调函数
    function callBack() {
        // 判断请求结果
        if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
            var $tip = document.getElementById("tip");
            // 获取异步调用返回的数据
            var data = xmlHttpRequest.responseText;
            // 判断响应回来的数据是否为空
            if(data.trim()!=""||data.trim()!=null){
                document.getElementById("info").innerHTML = "";
                // 使用 JavaScript 或 jQuery 等实现局部刷新，添加表格数据
                var tableDiv = document.getElementById("data");
                tableDiv.innerHTML = data.trim();
            }
        }
    }
</script>
</html>