<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/15
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查看页面</title>
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
            <h1>教学管理系统 <small>教师个人信息</small></h1>
        </div>
    </div>
    <div class="row">

    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">编号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${teacher.teacher_id}</p>
                    </div>
                </div><div class="form-group">
                <label class="col-sm-2 control-label">教师代号</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${teacher.teach_number}</p>
                </div>
            </div><div class="form-group">
                <label class="col-sm-2 control-label">姓名</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${teacher.teach_name}</p>
                </div>
            </div>
                <div class="form-group">
                <label class="col-sm-2 control-label">性别</label>
                <div class="col-sm-10">
                    <p class="form-control-static">${teacher.gender}</p>
                </div>
            </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">教师称号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${teacher.nickname}</p>
                    </div>
                </div>
            </form>
            <div class="row"></div>
            <hr/>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">所在学院</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${academy.academy_name}</p>
                    </div>
                </div>
            </form>
            <hr/>
            <form class="form-horizontal">
                <div class="form-group">
                    <c:if test="${courses != null}">
                        <c:forEach items="${courses}" var="course" varStatus="status">
                            <!-- status是当前所在的位置，然后status.index就是获取当前的下标 -->
                            <label class="col-sm-2 control-label">课程${status.index + 1}</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${course.cour_name}</p>
                                <p  style="margin-right: 10%;float: right">
                                    授课时间：&nbsp;&nbsp; <fmt:formatDate value="${course.teach_time}" pattern="yyyy-MM-dd"></fmt:formatDate>
                                </p>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>

