package com.canJ.servlet;

import com.canJ.dao.AcademyDAO;
import com.canJ.dao.CourseDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Academy;
import com.canJ.pojo.Student;
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

@WebServlet("/updateTeacher")
public class UpdateTeacherServlet extends HttpServlet {
    private TeacherDAO teacherDAO = new TeacherDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private AcademyDAO academyDAO = new AcademyDAO();
    private Logger logger = Logger.getLogger(UpdateTeacherServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Integer index = 0;
        String teacher_id = request.getParameter("teacher_id");
        logger.info(teacher_id);
        String teach_name = request.getParameter("teach_name");
        String gender = request.getParameter("gender");
        String nickname = request.getParameter("nickname");
        String academy_name = request.getParameter("academies");

        if (teach_name.equals("") || "".equals(academy_name)){
            logger.info("输入有误");
            //请输入学生姓名或者学院名称
            Integer flag = 1;
            request.setAttribute("flag",flag);
            request.getRequestDispatcher("UpdateTeacher.jsp").forward(request,response);
        }else {
            List<Academy> academies = academyDAO.getAcademies();
            for (Integer i = 0 ; i < academies.size();i++){
                logger.info("##########"+academies.get(i).getAcademy_name());
                if (academies.get(i).getAcademy_name().equals(academy_name)){
                    logger.info("找到输入的学院");
                    index = i+1;
                    break;
                }
            }
            if (index == 0){
                logger.info("找不到该学院");
                //找不到该学院
                Integer flag = 2;
                request.setAttribute("flag",flag);
                request.getRequestDispatcher("UpdateStudent.jsp").forward(request,response);
            }else {
                //Integer stu_id, Integer academy_id, String stu_name, String stu_gender, Date stu_birth, String stu_addr
                try {
                    logger.info("更新教师信息中");
                  //  Integer teacher_id,  Integer academy_id, String teach_name, String gender, String nickname
                    Teacher teacher = new Teacher(Integer.parseInt(teacher_id), index, teach_name, gender, nickname);
                    Integer integer = teacherDAO.updateTeacher(teacher);

                    if (integer != 0){
                        logger.info("更新成功");
                        Integer flag = 3;
                        request.setAttribute("flag",flag);
                        request.getRequestDispatcher("UpdateTeacher.jsp").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
