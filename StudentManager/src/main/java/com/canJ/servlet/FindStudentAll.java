package com.canJ.servlet;

import com.canJ.dao.AcademyDAO;
import com.canJ.dao.CourseDAO;
import com.canJ.dao.StudentDAO;
import com.canJ.pojo.Academy;
import com.canJ.pojo.Course;
import com.canJ.pojo.Student;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentDetail")
public class FindStudentAll extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAO();
    private AcademyDAO academyDAO = new AcademyDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private List<Course> courses;

    private Logger logger = Logger.getLogger(FindStudentAll.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String stu_id = request.getParameter("id");
        String flag = request.getParameter("flag");

        request.setAttribute("stu_id",stu_id);
        Student student = studentDAO.findStudentById(Integer.parseInt(stu_id));
        request.setAttribute("student",student);

//        for (Course c: student.getCourses()
//             ) {
//            System.out.println(c.getCour_name());
//        }
        courses = courseDAO.getCoursesById(Integer.parseInt(stu_id));
        request.setAttribute("courses",courses);

        for (Course c: courses
             ) {
            System.out.println(c.getCour_name());
        }

        Academy academy = academyDAO.getAcademieById(student.getAcademy_id());
        request.setAttribute("academy",academy);
        if ("1".equals(flag)){
            request.getRequestDispatcher("studentDetail.jsp").forward(request,response);
        }else if ("2".equals(flag)){
            request.getRequestDispatcher("UpdateStudent.jsp").forward(request,response);
        }
    }
}
