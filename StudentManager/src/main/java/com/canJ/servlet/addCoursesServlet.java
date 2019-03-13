package com.canJ.servlet;

import com.canJ.dao.CourseDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Course;
import com.canJ.pojo.Teacher;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/addCourse")
public class addCoursesServlet extends HttpServlet {

    private CourseDAO courseDAO = new CourseDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private Logger logger = Logger.getLogger(addCoursesServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Integer index = 0;
        String stu_id = request.getParameter("id");
        logger.info(stu_id);
        String cour_number = request.getParameter("cour_number");
        String cour_name = request.getParameter("cour_name");
        String cour_sort = request.getParameter("cour_sort");
        String cour_credit = request.getParameter("cour_credit");
        String teach_time = request.getParameter("teach_time");
        String teacher = request.getParameter("teacher");

        logger.info("数据加载完毕...");

        if ("".equals(cour_credit) || "".equals(cour_name) || "".equals(cour_number) || "".equals(cour_sort) || "".equals(teach_time)
                || "".equals(teacher)) {
            Integer flag = 2;
            request.setAttribute("flag", flag);
            request.getRequestDispatcher("addCourses.jsp").forward(request, response);
        } else {
            logger.info("准备加载所有的教师信息..");
            List<Teacher> teachers = teacherDAO.getTeachers();
            for (int i = 0; i < teachers.size(); i++) {
                if (teachers.get(i).getTeach_name().equals(teacher)) {
                    index = i + 1;
                    break;
                }
            }
            if (index == 0) {
                Integer flag = 3;
                request.setAttribute("flag", flag);
                request.getRequestDispatcher("addCourses.jsp").forward(request, response);
            } else {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Course course = new Course(Integer.parseInt(stu_id), index, cour_number, cour_name, cour_sort, Integer.parseInt(cour_credit), 0, simpleDateFormat.parse(teach_time));
                    int i = courseDAO.insertCourses(course);
                    if (i != 0) {
                        Integer flag = 1;
                        request.setAttribute("flag", flag);
                        request.getRequestDispatcher("addCourses.jsp").forward(request, response);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
