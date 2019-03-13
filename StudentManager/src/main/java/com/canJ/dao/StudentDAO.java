package com.canJ.dao;

import com.canJ.pojo.Student;
import com.canJ.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StudentDAO {
    private SqlSession sqlSession;
    private List<Student> studentList;
    private Student student;

    public SqlSession getSqlSession(){
        SqlSessionFactory factory = SqlSessionFactoryUtil.getFactory();
        sqlSession = factory.openSession();
        return sqlSession;
    }

    /**
     * 查询学生信息
     */
    public List<Student> findStudents(){
        try {
            studentList = getSqlSession().selectList("findStudent");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return studentList;
    }

    /**
     * 查询单个学生信息
     */
    public Student findStudentById(Integer id){
        try {
           student = getSqlSession().selectOne("findStudent",new Student(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return student;
    }

    /**
     * 删除单个学生信息
     */
    public Student deleteStudentById(Integer id){
        try {
            getSqlSession().delete("deleteStudent",new Student(id));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return student;
    }

    /**
     * 修改单个学生信息
     */
    public Integer updateStudent(Student student){
        Integer k = 0;
        try {
            k  = getSqlSession().update("updateStudent",student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return k;
    }

    /**
     * 插入单个学生信息
     */
    public Integer insertStudent(Student student){
        Integer k = 0;
        try {
           k = getSqlSession().insert("insertStudent",student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return k;
    }

    /**
     * 模糊查询学生信息
     */
    public List<Student> searchStudents(String str){
        try {
            studentList = getSqlSession().selectList("search",str);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return studentList;
    }
}
