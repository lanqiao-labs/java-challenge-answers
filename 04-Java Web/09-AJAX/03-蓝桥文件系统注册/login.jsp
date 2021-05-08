<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="static/css/login.css" />

    <title>登录注册表</title>
</head>
<body>
<div class="htmleaf-container">
    <div id="wrapper" class="login-page">
        <div  class="form">
            <form class="register-form" id="register_form">
                <span id="r_error" class="error_message" ></span>
                <input type="text" placeholder="用户名" id="r_user_name" name="r_user_name"/>
                <input type="password" placeholder="密码" id="r_password" name="r_password"/>
                <input type="text" placeholder="电子邮件" id="r_email" name="r_email"/>
                <input type="hidden" name="myrequest"  value="regestUser">
                <button id="create">创建账户</button>
                <p class="message">已经有了一个账户? <a href="#">立刻登录</a></p>
            </form>
            <form class="login-form" id="login_form">
                <span id="l_error" class="error_message" ></span>
                <input type="text" placeholder="用户名" name="user_name" id="user_name"/>
                <input type="password" placeholder="密码" name="user_pass" id="user_pass"/>
                <input type="hidden" name="myrequest"  value="login">
                <button id="login">登　录</button>
                <p class="message">还没有账户? <a href="#">立刻创建</a></p>
            </form>
        </div>
    </div>
</div>
<script src="static/js/jquery.min.js"></script>
<script type="text/javascript">
    var registUrl = "fileUserServlet";
    var loginUrl = "fileUserServlet";
    /**
     * 登录
     */
    function login()
    {
        $.ajax({
            cache: true,
            type: "POST",
            url:loginUrl,
            data:$('#login_form').serialize(),// 你的formid
            async: false,
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
                var data=jQuery.parseJSON(data);
                if(data.status==0){
                    location.href = "fileListServlet?myrequest=queryByPage";
                } else{
                    $("#l_error").html(data.msg)
                }
            }
        });
    }

        /**
         * 创建用户
         */
    function register(){
        $.ajax({
            cache: true,
            type: "POST",
            url:registUrl,
            data:$('#register_form').serialize(),// 你的formid
            async: false,
            error: function(request) {
                alert("Connection error");
            },
            success: function(data) {
                var data=jQuery.parseJSON(data);
               if(data.status==0){
                   $('form').animate({
                       height: 'toggle',
                       opacity: 'toggle'
                   }, 'slow');
                  alert(data.msg)
               }else{
                   $("#r_error").html(data.msg)
               }
            }
        });

    }

    $(function(){
        //创建用户
        $("#create").click(function(){
            register();
            return false;
        })
        //登录
        $("#login").click(function(){
            login();
            return false;
        })
        //切换登录注册表单
        $('.message a').click(function () {
            $('form').animate({
                height: 'toggle',
                opacity: 'toggle'
            }, 'slow');
        });
    })
</script>
</body>
</html>