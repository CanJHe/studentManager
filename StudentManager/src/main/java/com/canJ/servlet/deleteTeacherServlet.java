package com.canJ.servlet;

import com.canJ.dao.TeacherDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteTeacher")
public class deleteTeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO = new TeacherDAO();
    private Logger logger = Logger.getLogger(deleteTeacherServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setCharacterEncoding("utf-8");

        String id = request.getParameter("id");

        int i = teacherDAO.deleteTeacher(Integer.parseInt(id));
        if (i != 0){
            logger.info("删除成功");
            response.sendRedirect("/login?flag=true");
        }else {
            logger.info("删除失败");
        }
    }
}
