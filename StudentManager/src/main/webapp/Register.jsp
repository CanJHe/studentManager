<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/2
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册页面</title>
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
            <h1>教学管理系统 <small>管理员注册</small></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" action="${PageContext.request.contextPath}/register" method="post">
                <div class="form-group">
                    <label for="adminname" class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adminname" name="adminname" placeholder="请输入管理员的用户名">
                    </div>
                </div><div class="form-group">
                    <label for="adpassword" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" id="adpassword" name="adpassword" placeholder="请输入管理员密码">
                    </div>
                </div>
                <div class="form-group">
                    <label for="adnickname" class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adnickname" name="adnickname" placeholder="请输入管理员昵称">
                    </div>
                </div>
                <%--<div class="form-group">--%>
                    <%--<label for="gender" class="col-sm-2 control-label">性别</label>--%>
                    <%--<div class="col-sm-10">--%>
                        <%--<input type="text" class="form-control" id="gender" name="gender" placeholder="请输入管理员性别">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <!-- 单选，默认为男生 -->
                    <ul style="list-style-type:none;">
                        <li style="float:left;margin-left: 10%"><input class="control-label"type="radio" name="gender" value="男" checked="true" style="float: left;">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                        <li style="float:left;"><input class="control-label" type="radio" name="gender" value="女" style="float: left;">女</li>
                    </ul>
                </div>
                <div class="form-group">
                    <label for="age" class="col-sm-2 control-label">年龄</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="age" name="age" placeholder="请输入管理员年龄">
                    </div>
                </div>
                <div class="form-group">
                    <label for="adphone" class="col-sm-2 control-label">联系方式</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adphone" name="adphone" placeholder="请输入联系方式">
                    </div>
                </div><div class="form-group">
                    <label for="ademail" class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="ademail" name="ademail" placeholder="请输入邮箱账号">
                    </div>
                </div><div class="form-group">
                    <label for="remark" class="col-sm-2 control-label">备注</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="remark" name="remark" placeholder="请输入备注信息">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">注册</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
