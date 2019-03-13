package com.canJ.servlet;

import com.canJ.dao.CourseDAO;
import com.canJ.dao.StudentDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Course;
import com.canJ.pojo.Student;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/addTeacherCourse")
public class addTeacherCourse extends HttpServlet {

    private CourseDAO courseDAO = new CourseDAO();
    private StudentDAO studentDAO = new StudentDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private Logger logger = Logger.getLogger(addTeacherCourse.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");

        String teacher_id = request.getParameter("teacher_id");
        String cour_number = request.getParameter("cour_number");
        String cour_name = request.getParameter("cour_name");
        String cour_sort = request.getParameter("cour_sort");
        String cour_credit = request.getParameter("cour_credit");
        String teach_time = request.getParameter("teach_time");

        logger.info("数据加载完毕...");

        if ("".equals(cour_credit) || "".equals(cour_name) || "".equals(cour_number) || "".equals(cour_sort) || "".equals(teach_time)){
            Integer flag = 2;
            request.setAttribute("flag",flag);
            request.getRequestDispatcher("addTeaCoures.jsp").forward(request,response);
        }else {
            List<Student> students = studentDAO.findStudents();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            for (Integer i = 0 ; i < students.size();i++){
                if (students.get(i).getAcademy_id() == teacherDAO.getTeacherById(Integer.parseInt(teacher_id)).getAcademy_id()){
                    //Integer cour_id, String cour_number, String cour_name, String cour_sort, Integer cour_credit, Integer cour_grade, Date teach_time
                    try {
                        logger.info("正在添加课程");
                        Course course = new Course(i+1,Integer.parseInt(teacher_id),cour_number,cour_name,cour_sort,Integer.parseInt(cour_credit),0,simpleDateFormat.parse(teach_time));
                        Integer integer = courseDAO.insertCourses(course);
                        if (integer != 0){
                            logger.info("添加课程成功！！");
                            Integer flag = 1;
                            request.setAttribute("flag",flag);
                            request.getRequestDispatcher("addTeaCoures.jsp").forward(request,response);
                        }else {
                            logger.info("添加失败！！！");
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
