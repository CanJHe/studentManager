package com.canJ.servlet;

import com.canJ.dao.AcademyDAO;
import com.canJ.dao.StudentDAO;
import com.canJ.dao.TeacherDAO;
import com.canJ.pojo.Academy;
import com.canJ.pojo.Student;
import com.canJ.pojo.Teacher;
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

@WebServlet("/insertTeacher")
public class insertTeacherServlet extends HttpServlet {

    private TeacherDAO teacherDAO = new TeacherDAO();
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

        String teach_number = request.getParameter("teach_number");
        String teach_name = request.getParameter("teach_name");
        String gender = request.getParameter("gender");
        String nickname = request.getParameter("nickname");
        String academy_name = request.getParameter("academies");

        logger.info(teach_number);
        logger.info(teach_name);
        logger.info(gender);
        logger.info(nickname);
        logger.info(academy_name);

        if (teach_number.equals("") || "".equals(teach_name) || "".equals(gender) || "".equals(academy_name)) {
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
            List<Teacher> teachers = teacherDAO.getTeachers();
            /**
             * 判断该教师的代号是否已经存在
             */
            for (Teacher teacher: teachers
            ) {
                if (teacher.getTeach_number().equals(teach_number)){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                Academy academies = academyDAO.getAcademieByName(new Academy(academy_name));

                //String stu_number, Integer academy_id, String stu_name, String stu_gender, Date stu_birth, String stu_addr
                try {
                    logger.info("正在插入中...");
                    //String teach_number, Integer academy_id, String teach_name, String gender, String nickname
                    Teacher teacher = new Teacher(teach_number, academies.getAcademy_id(), teach_name, gender, nickname);
                    Integer integer = teacherDAO.insertTeacher(teacher);

                    logger.info("影响的行数 ：" + integer);

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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                JSONObject jsonObject = new JSONObject();
                response.setContentType("Application/json;charset=utf-8");
                jsonObject.put("flag","false");
                jsonObject.put("message","该教师代号已经存在！！！");
                response.getWriter().write(jsonObject.toString());
                response.getWriter().flush();
            }
        }
    }

}
