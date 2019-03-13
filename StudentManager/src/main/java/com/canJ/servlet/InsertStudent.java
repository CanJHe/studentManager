package com.canJ.servlet;

import com.canJ.dao.AcademyDAO;
import com.canJ.dao.StudentDAO;
import com.canJ.pojo.Academy;
import com.canJ.pojo.Student;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/insertStudent")
public class InsertStudent extends HttpServlet {

    private StudentDAO studentDAO = new StudentDAO();
    private AcademyDAO academyDAO = new AcademyDAO();

    private Logger logger = Logger.getLogger(InsertStudent.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");

        String stu_number = request.getParameter("stu_number");
        String stu_name = request.getParameter("stu_name");
        String stu_gender = request.getParameter("stu_gender");
        String stu_birth = request.getParameter("stu_birth");
        String stu_addr = request.getParameter("stu_addr");
        String academy_name = request.getParameter("academy_name");

        logger.info(stu_addr);
        logger.info(stu_birth);
        logger.info(stu_gender);
        logger.info(stu_name);
        logger.info(stu_number);
        logger.info(academy_name);

        if (stu_number.equals("") || "".equals(stu_name) || "".equals(stu_birth) || "".equals(academy_name)) {
            logger.info("插入失败!!!");
            JSONObject jsonObject = new JSONObject();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json;charset=utf-8");
            jsonObject.put("flag","false");
            jsonObject.put("message","输入不能为空哦！！！");
            response.getWriter().write(jsonObject.toString());
            response.getWriter().flush();
        } else{

            Integer flag = 0;
            List<Student> students = studentDAO.findStudents();
            for (Student student: students
                 ) {
                if (student.getStu_number().equals(stu_number)){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                Academy academies = academyDAO.getAcademieByName(new Academy(academy_name));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //String stu_number, Integer academy_id, String stu_name, String stu_gender, Date stu_birth, String stu_addr
                try {
                    logger.info("正在插入中...");
                    Student student = new Student(stu_number, academies.getAcademy_id(), stu_name, stu_gender, sdf.parse(stu_birth), stu_addr);
                    Integer integer = studentDAO.insertStudent(student);
                    if (integer != 0) {
                        logger.info("插入成功!!!");
                        JSONObject jsonObject = new JSONObject();
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("application/json;charset=utf-8");
                        jsonObject.put("flag", "true");
                        jsonObject.put("message", "插入成功！！！");
                        response.getWriter().write(jsonObject.toString());
                        response.getWriter().flush();
                    } else {
                        logger.info("插入失败!!!");
                        JSONObject jsonObject = new JSONObject();
                        response.setCharacterEncoding("utf-8");
                        response.setContentType("application/json;charset=utf-8");
                        jsonObject.put("flag", "false");
                        jsonObject.put("message", "插入失败！！！");
                        response.getWriter().write(jsonObject.toString());
                        response.getWriter().flush();
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else {
                JSONObject jsonObject = new JSONObject();
                response.setContentType("Application/json;charset=utf-8");
                jsonObject.put("flag","false");
                jsonObject.put("message","该学号已经存在！！！");
                response.getWriter().write(jsonObject.toString());
                response.getWriter().flush();
            }
        }
    }
}
