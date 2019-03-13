package com.canJ.servlet;

import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Teacher;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchTeacher")
public class searchTeacher extends HttpServlet {
    private TeacherDAO teacherDAO = new TeacherDAO();
    private Logger logger = Logger.getLogger(searchTeacher.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String content = request.getParameter("content");
        logger.info("查找内容："+content);

        List<Teacher> teachers = teacherDAO.searchTeacher(content);
        request.setAttribute("teachers",teachers);
        request.getRequestDispatcher("SearchTeacher.jsp").forward(request,response);
    }
}
