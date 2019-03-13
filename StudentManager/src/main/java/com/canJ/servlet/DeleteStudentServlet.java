package com.canJ.servlet;

import com.canJ.dao.CourseDAO;
import com.canJ.dao.StudentDAO;
import com.canJ.pojo.Student;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAO();
    private CourseDAO courseDAO = new CourseDAO();

    private Logger logger = Logger.getLogger(DeleteStudentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String stu_id = request.getParameter("id");
        logger.info("获得学生id值为：" + stu_id);

        int i = courseDAO.deleteCoursesById(Integer.parseInt(stu_id));
        logger.info("删除的个数为:" + i);

        Student student = studentDAO.deleteStudentById(Integer.parseInt(stu_id));

        if (student == null){
            logger.info("删除成功");
        }

        request.getRequestDispatcher("/login?flag=true").forward(request,response);
    }
}
