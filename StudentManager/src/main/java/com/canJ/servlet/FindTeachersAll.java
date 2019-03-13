package com.canJ.servlet;

import com.canJ.dao.AcademyDAO;
import com.canJ.dao.CourseDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Academy;
import com.canJ.pojo.Course;
import com.canJ.pojo.Student;
import com.canJ.pojo.Teacher;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findTeachers")
public class FindTeachersAll extends HttpServlet {
    private CourseDAO courseDAO = new CourseDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private AcademyDAO academyDAO = new AcademyDAO();
    private List<Course> courses;

    private Logger logger = Logger.getLogger(FindTeachersAll.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String teacher_id = request.getParameter("id");
        String flag = request.getParameter("flag");

        request.setAttribute("teacher_id",teacher_id);
        Teacher teacher = teacherDAO.getTeacherById(Integer.parseInt(teacher_id));
        request.setAttribute("teacher",teacher);

//        for (Course c: student.getCourses()
//             ) {
//            System.out.println(c.getCour_name());
//        }
        courses = courseDAO.getCoursesById(Integer.parseInt(teacher_id));
        request.setAttribute("courses",courses);

        Academy academy = academyDAO.getAcademieById(teacher.getAcademy_id());
        request.setAttribute("academy",academy);

        if ("1".equals(flag)){
            request.getRequestDispatcher("TeacherDetail.jsp").forward(request,response);
        }else if ("2".equals(flag)){
            request.getRequestDispatcher("UpdateTeacher.jsp").forward(request,response);
        }
    }
}
