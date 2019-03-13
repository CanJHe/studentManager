<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/1
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登陆页面</title>
    <!--引入bookstrap文件-->
    <link rel="stylesheet" href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <!--引入bookstrap文件还依赖于JQuery文件，所以也要导入JQuery文件-->
    <script src="lib/2.2.4/jquery-2.2.4.min.js"></script>
    <script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
     <div class="row">
    <div class="page-header">
    <h1>教学管理系统 <small>管理员登录</small></h1>
      </div>
     </div>
      <div class="row">
          <c:if test="${flag == 1}">
              <script>
                  window.alert("注册成功");
              </script>
          </c:if>
      </div>
     <div class="row" style="margin-top: 3%">
         <div class="col-md-8 col-md-offset-2">
             <form class="form-horizontal" method="post" id="loginform">
                 <div class="form-group">
                     <label for="adminname" class="col-sm-2 control-label">用户名<span class="tip" style="color:red;font-size:12px"></span></label>
                     <div class="col-sm-10">
                         <input type="text" class="form-control" id="adminname" name="adminname" value="${requestScope.adminname}" placeholder="请输入用户名">
                     </div>
                 </div>
                 <div class="form-group">
                     <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
                     <div class="col-sm-10">
                         <input type="password" class="form-control" name="adpassword" value="${requestScope.adpassword}" id="inputPassword3"  placeholder="请输入密码">
                     </div>
                 </div>
                 <div class="form-group">
                     <label for="kaptcha" class="col-sm-2 control-label">验证码<span class="tip" style="color:red;font-size:12px"></span></label>
                     <div class="col-sm-10">
                         <input type="text" class="form-control" id="kaptcha" name="kaptcha" placeholder="请输入验证码">
                         <span class="login-w"><img id="kaptchaImage" src="kaptcha"></span>
                     </div>
                 </div>
                 <div class="form-group">
                     <div class="col-sm-offset-2 col-sm-10">
                         <div class="checkbox">
                             <label>
                                 <input type="checkbox" name="number" value="记住密码" id="password" checked> 记住密码
                             </label>
                         </div>
                     </div>
                 </div>
                 <div class="form-group">
                     <div class="col-sm-offset-2 col-sm-10">
                         <button type="button" class="btn btn-default" id="login">登录</button>

                         <a href="Register.jsp" class="btn btn-default" style="float:right; margin-right: 80%">注册</a>
                     </div>
                 </div>
             </form>
         </div>
     </div>
  </div>

    <script type="text/javascript">

            //点击图片验证码进行更新
            $(function(){
                $('#kaptchaImage').click(function () { $(this).attr('src', 'kaptcha?' + Math.floor(Math.random()*100) ); })
            });

           $("#login").click(function () {
               $.ajax({
                   cache: true,
                   url:"/login",
                   type:"post",
                   // data:{
                   //     adminname:$("input[name=adminname]").val(),
                   //     adpassword:$("input[name=adpassword]").val(),
                   //     password:$("#password").val(),
                   //     kaptcha:$("#kaptchaImage").val()
                   // },

                   //把整个表单数据提交过去，然后getParameter表单的name属性来获取。
                   data:$("#loginform").serialize(),
                   dataType:"json",
                   success:function (result) {
                       var flag = result.flag;
                       var message = result.message;
                       if (flag == "true"){
                           //如果登录成功则跳转到成功页面
                           window.location.href="middle.jsp";
                       }else {
                          alert(message);
                       }
                   }
               });
           });


    </script>

</body>
</html>
