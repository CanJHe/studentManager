package com.canJ.dao;

import com.canJ.pojo.Teacher;
import com.canJ.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class TeacherDAO {

    private SqlSession sqlSession;
    private List<Teacher> teachers;
    private Teacher teacher;

    public SqlSession getSqlSession(){
        SqlSessionFactory factory = SqlSessionFactoryUtil.getFactory();
        sqlSession = factory.openSession();
        return sqlSession;
    }

    /**
     * 查询所有的教师的信息
     */
    public List<Teacher> getTeachers(){
        try {
            teachers = getSqlSession().selectList("findTeacher");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return teachers;
    }

    /**
     * 查询单个教师的信息
     */
    public Teacher getTeacherById(Integer id){
        try {
            teacher = getSqlSession().selectOne("findTeacher",new Teacher(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return teacher;
    }

    /**
     * 删除单个的教师的信息
     */
    public int deleteTeacher(Integer id){
        int k = 0;
        try {
           k = getSqlSession().delete("deleteTeacher",new Teacher(id));
           sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return k;
    }

    /**
     * 插入单个的教师的信息
     */
    public int insertTeacher(Teacher teacher){
        int k = 0;
        try {
            k = getSqlSession().insert("insertTeacher", teacher);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return k;
    }

    /**
     * 修改单个的教师的信息
     */
    public int updateTeacher(Teacher teacher){
        int k = 0;
        try {
             k = getSqlSession().update("updateTeacher", teacher);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return k;
    }

    /**
     * 模糊查询
     */
    public List<Teacher> searchTeacher(String str){
        try {
            teachers = getSqlSession().selectList("searchTeacher", str);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return teachers;
    }
}
