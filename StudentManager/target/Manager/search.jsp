<%--
  Created by IntelliJ IDEA.
  User: CanJ
  Date: 2018/12/9
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>查找信息</title>
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
            <h1>教学管理系统 <small>查找</small></h1>
        </div>
    </div>

    <div class="row">
        <%--<div class="col-lg-6">--%>
        <form class="form-horizontal" action="${pageContext.request.contextPath}/search" method="post">
        <div class="col-md-8 col-md-offset-2">
            <div class="input-group">
                <input type="text" class="form-control" id="content" name="content" placeholder="请输入查询学生内容....">
                <span class="input-group-btn">
        <button class="btn btn-default" type="submit" id="search">Go!</button>
      </span>
            </div><!-- /input-group -->
        </div><!-- /.col-lg-6 -->
        </form>
    </div>
        <c:if test="${students != null}">
            <div class="row">
                <div>
                    <span style="font-style: italic;font-weight: bold;font-size: 25px">学生信息列表</span>
                </div>
            </div>
            <div class="row">
                <table class="table table-hover table-striped">
                    <tr>
                        <th>编号</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>出生日期</th>
                        <th>生源地</th>
                        <th>所在学院</th>
                        <th>操作</th>
                    </tr>
                        <c:forEach var="student" items="${students}">
                    <tr>
                        <td>${student.stu_id}</td>
                        <td>${student.stu_number}</td>
                        <td>${student.stu_name}</td>
                        <td>${student.stu_gender}</td>
                        <td>
                            <fmt:formatDate value="${student.stu_birth}" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </td>
                        <td>${student.stu_addr}</td>
                        <c:if test="${student.academy_id == 1}">
                        <td>计算机学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 2}">
                        <td>经济管理学院</td>
                            </c:if><c:if test="${student.academy_id == 3}">
                        <td>纺织学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 4}">
                        <td>土木建筑学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 5}">
                        <td>外国语学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 6}">
                        <td>马克思学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 7}">
                        <td>文学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 8}">
                        <td>信息工程学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 9}">
                        <td>机电学院</td>
                        </c:if>
                        <c:if test="${student.academy_id == 10}">
                        <td>数学与计算学院</td>
                        </c:if>
                        <td>
                            <a href="${pageContext.request.contextPath}/studentDetail?flag=1&id=${student.stu_id}">查看</a>
                            <a href="${pageContext.request.contextPath}/studentDetail?flag=2&id=${student.stu_id}">修改</a>
                            <a href="addCourses.jsp?stu_id=${student.stu_id}">添加课程</a>
                            <a href="${pageContext.request.contextPath}/deleteStudent?id=${student.stu_id}">删除</a>
                        </td>
                    </tr>
                   </c:forEach>
                </table>
            </div>
        </c:if>
    </div><!-- /.row -->

</div>

       <%--<script type="text/javascript">--%>
           <%--$("#search").click(function () {--%>
               <%--$.ajax({--%>
                   <%--url:"/search",--%>
                   <%--type:"post",--%>
                   <%--dataType:"json",--%>
                   <%--data:$("#context").val(),--%>
                   <%--success:function (result) {--%>
                       <%--alert("aaaa");--%>
                   <%--},--%>
                   <%--error:function (result) {--%>
                       <%--alert("bbbb");--%>
                   <%--}--%>
               <%--});--%>
           <%--});--%>
       <%--</script>--%>
</body>
</html>
