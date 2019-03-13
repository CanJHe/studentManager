package com.canJ.servlet;

import com.canJ.dao.ManagerDAO;
import com.canJ.pojo.Admin;
import org.apache.log4j.Logger;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private ManagerDAO managerDAO = new ManagerDAO();

    private Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");

       //获取用户登录的账号和密码,以及判断是否选上了记住密码
        String adminname = request.getParameter("adminname");
        String adpassword = request.getParameter("adpassword");
        String flag = request.getParameter("flag");
        HttpSession session = request.getSession();
        if ("true".equals(flag)){
            String adminname1 = (String) session.getAttribute("adminname");
            String adpassword1 = (String) session.getAttribute("adpassword");

            //从数据库中获取所有的管理员的信息，进行匹配
            List<Admin> admins = managerDAO.getAdmins();
            for (Admin admin: admins) {
                System.out.println(admin);
                if(admin.getAdminname().equals(adminname1) && admin.getAdpassword().equals(adpassword1)){
                    // JSONObject jsonObject = new JSONObject("{flag:true}");
                    response.sendRedirect("middle.jsp");
                    break;
                }
            }
            flag = null;
        }else{
            session.setAttribute("adminname",adminname);
            session.setAttribute("adpassword",adpassword);

            //判断是否勾选上了记住密码
            String password = request.getParameter("password");

            if (password != null){
                Cookie cookie = new Cookie("adminname",adminname);
                Cookie cookie2 = new Cookie("adpassword",adpassword);
                //保存的有效期为7天
                cookie.setMaxAge(60*60*24*7);
                cookie2.setMaxAge(60*60*24*7);
                //把它添加进去
                response.addCookie(cookie);
                response.addCookie(cookie2);
            }

            Cookie[] cookies = request.getCookies();
            logger.info(cookies);

            //输出一些获取的信息
            logger.info("账号："+adminname);
            logger.info("密码："+adpassword);
            // logger.info("是否选中："+numbers.toString());

            //从数据库中获取所有的管理员的信息，进行匹配
            List<Admin> admins = managerDAO.getAdmins();
            Integer flag1 = 0;
            for (Admin admin: admins) {
                System.out.println(admin);
                if(admin.getAdminname().equals(adminname) && admin.getAdpassword().equals(adpassword)){
                    String kaptcha = request.getParameter("kaptcha");
                    logger.info("验证码----->" +  kaptcha );
                    String kaptchaExpected = (String) session.getAttribute("code");
                    System.out.println(kaptcha +"......"+kaptchaExpected);
                    if (kaptcha.equalsIgnoreCase(kaptchaExpected)) {
                          flag1=2;
                    }else {
                        flag1 = 1;
                    }
                    break;
                }
            }
            if (flag1 == 0){
                JSONObject jsonObject = new JSONObject();
                response.setContentType("application/json;charset=utf-8");
                jsonObject.put("flag","false");
                jsonObject.put("message","用户名或密码有误！！！！");
                response.getWriter().write(jsonObject.toString());
                response.getWriter().flush();
            }else if (flag1 == 1){
                JSONObject jsonObject = new JSONObject();
                response.setContentType("application/json;charset=utf-8");
                jsonObject.put("flag","false");
                jsonObject.put("message","验证码有误！！！！");
                response.getWriter().write(jsonObject.toString());
                response.getWriter().flush();
            }else {
                JSONObject jsonObject = new JSONObject();
                response.setContentType("application/json;charset=utf-8");
                jsonObject.put("flag","true");
                jsonObject.put("message","登陆成功！！！！");
                response.getWriter().write(jsonObject.toString());
                response.getWriter().flush();
            }
        }
    }
}
