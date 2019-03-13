package com.canJ.dao;

import com.canJ.pojo.Course;
import com.canJ.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CourseDAO {
    private SqlSession sqlSession;
    private List<Course> courses;

    public SqlSession getSqlSession(){
        SqlSessionFactory factory = SqlSessionFactoryUtil.getFactory();
        sqlSession = factory.openSession();
        return sqlSession;
    }

    /**
     * 用来查询课程的信息
     */
    public List<Course> getCourses() {
        try {
            courses  = getSqlSession().selectList("findCourse");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return courses;
    }

    /**
     * 用来查询单个学生的课程的信息
     */
    public List<Course> getCoursesById(Integer id) {
        try {
            courses  = getSqlSession().selectList("findCourse",new Course(id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return courses;
    }

    /**
     * 用来删除单个学生的课程的信息
     */
    public int deleteCoursesById(Integer id) {
        int deleteCourse = 0;
        try {
            deleteCourse = getSqlSession().delete("deleteCourse", new Course(id));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return deleteCourse;
    }

    /**
     * 用来插入单个学生的课程的信息
     */
    public int insertCourses(Course course) {
        int deleteCourse = 0;
        try {
            deleteCourse = getSqlSession().insert("insertCourse",course);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return deleteCourse;
    }
}
