<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/15
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String id=request.getParameter("teacher_id");
%>
<html>
<head>
    <title>添加课程页面</title>
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
            <h1>教学管理系统 <small>添加课程</small></h1>
        </div>
    </div>
    <div class="row">
        <c:if test="${flag == 1}">
            <script>
                window.alert("添加成功！！！");
                <%
                response.sendRedirect("/login?flag=true");
                %>
            </script>
        </c:if>
        <c:if test="${flag == 2}">
            <script>
                window.alert("请先把有关选项填完！！！");
            </script>
        </c:if>
        <c:if test="${flag == 3}">
            <script>
                window.alert("该教师不存在！！！");
            </script>
        </c:if>
    </div>
    <div class="row" style="margin-top: 3%">
        <div class="col-md-8 col-md-offset-2">
            <form class="form-horizontal" action="${pageContext.request.contextPath}/addTeacherCourse" method="post">
                <input type="hidden" name="teacher_id" value="<%=id%>">
                <div class="form-group">
                    <label for="cour_number" class="col-sm-2 control-label">课程号<span class="tip" style="color:red;font-size:12px"></span></label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="cour_number" name="cour_number" placeholder="请输入课程号">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cour_name" class="col-sm-2 control-label">课程名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="cour_name" id="cour_name" placeholder="请输入课程名">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cour_sort" class="col-sm-2 control-label">类别</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="cour_sort" id="cour_sort" placeholder="请输入课程类别">
                    </div>
                </div>
                <div class="form-group">
                    <label for="cour_credit" class="col-sm-2 control-label">学分</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="cour_credit" id="cour_credit" placeholder="请输入课程学分">
                    </div>
                </div>
                <%--<div class="form-group">--%>
                <%--<label for="teach_time" class="col-sm-2 control-label">开课时间</label>--%>
                <%--<div class="col-sm-10">--%>
                <%--<input type="text" class="form-control" name="teach_time" id="teach_time" placeholder="请输入课程开课时间(yyyy-MM-dd)">--%>
                <%--</div>--%>
                <%--</div>--%>
                <div class="form-group">
                    <label for="teach_time" class="col-sm-2 control-label">授课时间</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="teach_time" name="teach_time" placeholder="请输入授课时间(yyyy-MM-dd)">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default" id="login">提交</button>

                        <a href="${pageContext.request.contextPath}/login?flag=true" class="btn btn-default" style="float:right; margin-right: 80%">取消</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>