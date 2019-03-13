package com.canJ.dao;

import com.canJ.pojo.Academy;
import com.canJ.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AcademyDAO {

    private SqlSession sqlSession;
    private List<Academy> academies;
    private Academy academy;

    public SqlSession getSqlSession(){
        SqlSessionFactory factory = SqlSessionFactoryUtil.getFactory();
        sqlSession = factory.openSession();
        return sqlSession;
    }

    /**
     * 用来查询学院的信息
     */
    public List<Academy> getAcademies() {
        try {
            academies  = getSqlSession().selectList("findAcademy");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return academies;
    }

    /**
     * 用来单查询个学生学院的信息
     */
    public Academy getAcademieById(Integer id) {
        try {
            academy = getSqlSession().selectOne("findAcademy",new Academy(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return academy;
    }

    /**
     * 用来单查询个学生学院的信息
     */
    public Academy getAcademieByName(Academy academy) {
        try {
            academy = getSqlSession().selectOne("findAcademy",academy);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return academy;
    }
}
