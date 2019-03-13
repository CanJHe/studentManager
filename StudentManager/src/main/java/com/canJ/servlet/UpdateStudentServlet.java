package com.canJ.servlet;

import com.canJ.dao.AcademyDAO;
import com.canJ.dao.StudentDAO;
import com.canJ.pojo.Academy;
import com.canJ.pojo.Student;
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

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAO();
    private AcademyDAO academyDAO = new AcademyDAO();

    private Logger logger = Logger.getLogger(UpdateStudentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Integer index = 0;
        String stu_id = request.getParameter("stu_id");
        logger.info(stu_id);
        String stu_name = request.getParameter("stu_name");
        String stu_gender = request.getParameter("stu_gender");
        String stu_birth = request.getParameter("stu_birth");
        String stu_addr = request.getParameter("stu_addr");
        String academy_name = request.getParameter("academies");

        if (stu_name.equals("") || "".equals(academy_name)){
            logger.info("输入有误");
            //请输入学生姓名或者学院名称
         Integer flag = 1;
         request.setAttribute("flag",flag);
         request.getRequestDispatcher("UpdateStudent.jsp").forward(request,response);
        }else {
            List<Academy> academies = academyDAO.getAcademies();
           for (Integer i = 0 ; i < academies.size();i++){
                       logger.info("###########"+academies.get(i).getAcademy_name());
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
               SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
               //Integer stu_id, Integer academy_id, String stu_name, String stu_gender, Date stu_birth, String stu_addr
               try {
                   logger.info("更新学生信息中");
                   Student student = new Student(Integer.parseInt(stu_id),index,stu_name,stu_gender,simpleDateFormat.parse(stu_birth),stu_addr);
                   Integer integer = studentDAO.updateStudent(student);
                   if (integer != null){
                       logger.info("更新成功");
                       Integer flag = 3;
                       request.setAttribute("flag",flag);
                       request.getRequestDispatcher("UpdateStudent.jsp").forward(request,response);
                   }
               } catch (ParseException e) {
                   e.printStackTrace();
               }

           }
        }

    }
}
