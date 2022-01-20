<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>使用 AJAX 传输 Json 数据模拟登陆</title>
    <script src="https://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript">
    $(document).ready(function(){
        $("#login").click(function(){
            var $userName = $('#userName').val();
            var $userPwd = $('#userPwd').val();
            if($userName!=null&&$userName!=''&&$userPwd!=null&&$userPwd!=''){
                $.getJSON('/AJAXJSONLoginServlet',
                    {
                        "userName": $userName,
                        "userPwd": $userPwd
                    },function(result)    {
                        if(result.code==200){
                            alert("登陆成功");
                            window.location.href = "welcome.jsp";
                        }else{
                            alert("登陆失败，用户名密码错误");
                        }
                    });
            }else{
                alert("用户名和密码不能为空");
            }
        })
    })
    </script>
</head>
<body>
 <form>
     账号：<input type="text" name="userName" id="userName"/><br>
     密码：<input type="password" name="userPwd" id="userPwd"/><br>
     <input type="button" id="login" value="登陆" id="login"/>
 </form>
</body>
</html>