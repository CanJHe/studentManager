package com.canJ.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {

    private static String resource = "mybatis.xml";

    private static SqlSessionFactory factory;

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /**
     * 初始化SqlSessionFactory,只需创建一次，作用域相当于application来使用
     * @throws IOException
     */
    public static void initSqlSessionFactory(){
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(is);
    }

    /**
     * 返回工厂对象
     */
    public static SqlSessionFactory getFactory(){
        return factory;
    }

    /**
     * 用来关闭SqlSession的方法,
     * 做一下标记，对ThreadLocal不了解。
     */
    public static void close(){
        SqlSession session = threadLocal.get();
        if(session != null){
            session.close();
            threadLocal.set(null);
        }
    }
}
