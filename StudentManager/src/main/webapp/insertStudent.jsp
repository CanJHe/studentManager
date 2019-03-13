<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/8
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>添加学生信息</title>
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
            <h1>教学管理系统 <small>添加学生</small></h1>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="stu_number" class="col-sm-2 control-label">学号</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stu_number" name="stu_number" placeholder="请输入学生学号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="stu_name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stu_name" name="stu_name" placeholder="请输入学生姓名">
                    </div>
                </div>

                <%--<input class="control-label"type="radio" name="stu_gender" value="男" checked="true" style="float: left;margin-left: 5%;">男--%>
                <%--<br/>--%>
                <%--<input class="control-label" type="radio" name="stu_gender" value="女" style="float: left;margin-left: 5%">女--%>

                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <!-- 单选，默认为男生 -->
                    <ul style="list-style-type:none;">
                        <li style="float:left;margin-left: 10%"><input class="control-label"type="radio" name="stu_gender" value="男" checked="true" style="float: left;">男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                        <li style="float:left;"><input class="control-label" type="radio" name="stu_gender" value="女" style="float: left;">女</li>
                    </ul>
                </div>

                <div class="form-group">
                    <label for="stu_birth" class="col-sm-2 control-label">出生日期</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="stu_birth" name="stu_birth"
                               value="<fmt:formatDate value="${student.stu_birth}" pattern="yyyy-MM-dd"></fmt:formatDate>"
                               placeholder="请输入学生出生日期(yyyy-MM-dd)">
                    </div>
                </div>
                <div class="form-group">
                    <label for="stu_addr" class="col-sm-2 control-label">生源地</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stu_addr" name="stu_addr" value="${student.stu_addr}" placeholder="请输入学生生源地">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">所属学院</label>
                    <div class="col-sm-10">
                        <input list="academies" name="academies" class="form-control" />
                        <datalist id="academies">
                            <option value="计算机学院">
                            <option value="经济管理学院">
                            <option value="纺织学院">
                            <option value="土木建筑学院">
                            <option value="外国语学院">
                            <option value="马克思学院">
                            <option value="文学院">
                            <option value="信息工程学院">
                            <option value="机电学院">
                            <option value="数学与计算学院">
                        </datalist>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="button" class="btn btn-default" id="insert">提交</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<script>
    $("#insert").click(function () {
        $.ajax({
            url:"/insertStudent",
            type:"POST",
            dateType:"json",
            data:{
                stu_number:$("#stu_number").val(),
                stu_name:$("#stu_name").val(),
                stu_gender:$("input[name=stu_gender]").val(),
                stu_birth:$("#stu_birth").val(),
                stu_addr:$("#stu_addr").val(),
                academy_name:$("input[name=academies]").val()
            },
            success:function(result) {
                var flag = result.flag;
                var message = result.message;
                //alert(flag);
                if (flag == "true"){
                    window.alert(message);
                    window.location.href = '/login?flag=true';
                } else {
                    window.alert(message);
                }
            }
            // error:function(result) {
            //     JSON.stringify(result);
            //     alert(result);
            // }
        });
    });
</script>
</body>
</html>
