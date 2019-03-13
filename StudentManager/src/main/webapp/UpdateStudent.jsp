<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/7
  Time: 0:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>修改页面</title>
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
            <h1>教学管理系统 <small>学生个人信息修改</small></h1>
        </div>
    </div>
    <div class="row">
        <c:if test="${flag == 3}">
            <script>
                window.alert("修改成功！！！");
                // 修改页面成功后，直接跳转回主页
                <%
                request.getRequestDispatcher("/login?flag=true").forward(request,response);
                %>
            </script>
        </c:if>
        <c:if test="${flag == 2}">
            <script>
                window.alert("学校没有该学院！！！");
            </script>
        </c:if>
        <c:if test="${flag == 1}">
            <script>
                window.alert("请输入学生姓名或学院名称！！！");
            </script>
        </c:if>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/updateStudent?stu_id=${stu_id}" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">编号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${student.stu_id}</p>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">学号</label>
                    <div class="col-sm-10">
                        <p class="form-control-static">${student.stu_number}</p>
                    </div>
                </div>

                <div class="form-group">
                    <label for="stu_name" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stu_name" name="stu_name" value="${student.stu_name}" placeholder="请输入学生姓名">
                    </div>
                </div>


                <div class="form-group">
                    <label for="stu_gender" class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="stu_gender" name="stu_gender" value="${student.stu_gender}" placeholder="请输入学生性别">
                    </div>
                </div>

                <%--<div class="form-group">--%>
                    <%--<label for="stu_birth" class="col-sm-2 control-label">出生日期</label>--%>
                    <%--<div class="col-sm-10">--%>
                        <%--<input type="text" class="form-control" id="stu_birth" name="stu_birth"--%>
                               <%--value="<fmt:formatDate value="${student.stu_birth}" pattern="yyyy-MM-dd"></fmt:formatDate>"--%>
                               <%--placeholder="请输入学生出生日期">--%>
                    <%--</div>--%>
                <%--</div>--%>
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
            <hr/>
                <%--<div class="form-group">--%>
                    <%--<label for="academy_name" class="col-sm-2 control-label">所属学院</label>--%>
                    <%--<div class="col-sm-10">--%>
                        <%--<input type="text" class="form-control" id="academy_name" name="academy_name" value="${academy.academy_name}" placeholder="请输入学院名称">--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label class="col-sm-2 control-label">所属学院</label>
                    <div class="col-sm-10">
                        <input list="academies" name="academies" value="${academy.academy_name}" class="form-control" />
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
            <hr/>
                <div class="form-group">
                    <c:if test="${courses != null}">
                        <c:forEach items="${courses}" var="course" varStatus="status">
                            <label class="col-sm-2 control-label">课程${status.index + 1}</label>
                            <div class="col-sm-10">
                                <p class="form-control-static">${course.cour_name}</p>
                                <p  style="margin-right: 10%;float: right">
                                    上课时间：&nbsp;&nbsp; <fmt:formatDate value="${course.teach_time}" pattern="yyyy-MM-dd"></fmt:formatDate>
                                </p>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default" id="login">提交</button>
                    <a href="${pageContext.request.contextPath}/login?flag=true" class="btn btn-default" style="float:right; margin-right: 20%">取消</a>
                </div>
            </div>
            </form>
        </div>
    </div>
    <div class="row">
        &nbsp;
    </div>
    <div class="row">
        &nbsp;
    </div>
</div>
</body>
</html>
