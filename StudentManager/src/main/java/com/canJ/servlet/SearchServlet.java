package com.canJ.servlet;

import com.canJ.dao.StudentDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Student;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();

    private Logger logger = Logger.getLogger(SearchServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //获得前端进来的关键字
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String content = request.getParameter("content");
        logger.info("输入内容:" + content);

        List<Student> students = studentDAO.searchStudents(content);
        logger.info("查询到的学生信息:" + students);

        request.setAttribute("students",students);
        request.getRequestDispatcher("search.jsp").forward(request,response);
    }
}
