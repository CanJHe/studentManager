package com.canJ.servlet;

import com.canJ.dao.StudentDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Student;
import com.canJ.pojo.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findStudents")
public class FindStudents extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<Student> students = studentDAO.findStudents();
        List<Teacher> teachers = teacherDAO.getTeachers();

        request.setAttribute("students",students);
        request.setAttribute("teachers",teachers);
        request.getRequestDispatcher("/Functiondetail.jsp").forward(request,response);
    }
}
