package com.canJ.servlet;

import com.canJ.dao.ManagerDAO;
import com.canJ.pojo.Admin;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/register")
public class RegistServet extends HttpServlet {

    private Logger logger = Logger.getLogger(RegistServet.class);

    private ManagerDAO managerDAO = new ManagerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String adminname = request.getParameter("adminname");
        String adpassword = request.getParameter("adpassword");
        String adnickname = request.getParameter("adnickname");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String adphone = request.getParameter("adphone");
        String ademail = request.getParameter("ademail");
        String remark = request.getParameter("remark");

        Admin admin = new Admin(adminname,adpassword,adnickname,gender,Integer.parseInt(age),adphone,ademail,new Date(),remark);

        logger.info("新建的管理员信息——》"+admin);

        admin = managerDAO.addAdmins(admin);

        logger.info("执行添加操作后在数据库中管理员信息——》" + admin);

        //转发页面回到主页，然后提示注册成功
        Integer flag = 1;
        request.setAttribute("flag",flag);
        request.getRequestDispatcher("index.jsp").forward(request,response);

    }
}
