<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="https://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#login").click(function(){
                var $userName = $('#userName').val();
                var $userPwd = $('#userPwd').val();
                var $checkcodeId = $('#checkcodeId').val();
                if($userName!=null&&$userName!=''&&$userPwd!=null&&$userPwd!=''){
                    $.getJSON('/LoginServlet',
                        {
                            "userName": $userName,
                            "userPwd": $userPwd,
                            "checkcode":$checkcodeId
                        },function(result)    {
                            if(result.code==200){
                                alert("登陆成功");
                                window.location.href = "welcome.jsp";
                            }else{
                                alert(result.msg);
                            }
                        });
                }else{
                    alert("用户名和密码不能为空");
                }
            })
        })
        //刷新验证码
        function reloadCheckImg($img){
            $img.attr("src","img.jsp?t="+(new Date().getTime()));
        }
    </script>
</head>
<body>
<form>
    账号：<input type="text" name="userName" id="userName"/><br>
    密码：<input type="password" name="userPwd" id="userPwd"/><br>
    验证码：<input  type="text" name="checkcode" id="checkcodeId" size="4"/><a href = "javascript:reloadCheckImg($('img'))"><img src="img.jsp"/></a><span>看不清？点击图片更换验证码</span><br>
    <input type="button" id="login" value="登陆" id="login"/>
</form>
</body>
</html>