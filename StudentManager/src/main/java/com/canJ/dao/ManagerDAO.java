package com.canJ.dao;

import com.canJ.pojo.Admin;
import com.canJ.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ManagerDAO {
      private static SqlSession sqlSession;

      //定义一个集合，用来存放返回的数据集合
     private List<Admin> admins;

     private static Admin admin;

    /**
     * 封装一个方法，用它来获取SQLSessionFactory
     */
    public  SqlSession getSqlSession() {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getFactory();

        sqlSession = sqlSessionFactory.openSession();

        return sqlSession;
    }

    /**
     * 用来获得管理员信息的方法
     */
    public  List<Admin> getAdmins(){
        try {
            admins  = getSqlSession().selectList("allAdmin");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return admins;
    }

    /**
     * 用来添加管理员信息的方法
     */
    public Admin addAdmins(Admin admin){
        try {
            int addAdmin = getSqlSession().insert("insertAdmin", admin);
            //记得要提交
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return admin;
    }
}
