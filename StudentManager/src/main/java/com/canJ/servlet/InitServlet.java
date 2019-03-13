package com.canJ.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 映射url是必备的配置元素
 */
@WebServlet(loadOnStartup = 1,urlPatterns = "/")
public class InitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminname = "";
        String adpassword = "";
        //获取当前站点的所有Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies == null){
            response.sendRedirect("index.jsp");
            return;
        }
        for (int i = 0; i < cookies.length; i++) {
            if ("adminname".equals(cookies[i].getName())) {
                adminname = cookies[i].getValue();
            } else if ("adpassword".equals(cookies[i].getName())) {
                adpassword = cookies[i].getValue();
            }
        }
        request.setAttribute("adminname",adminname);
        request.setAttribute("adpassword",adpassword);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
