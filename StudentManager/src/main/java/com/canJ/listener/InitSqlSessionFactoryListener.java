package com.canJ.listener;

import com.canJ.utils.SqlSessionFactoryUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

/**
 * 使用监听器一定要注册，可以使用注解的形式
 */
@WebListener
public class InitSqlSessionFactoryListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器加载中...");

        //初始化SqlSessionFactory
        SqlSessionFactoryUtil.initSqlSessionFactory();

    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁中");
    }
}
