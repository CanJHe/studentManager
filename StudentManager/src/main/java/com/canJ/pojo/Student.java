package com.canJ.pojo;

import java.util.Date;
import java.util.List;

public class Student {
    private Integer stu_id;
    private String stu_number;
 //   private Integer cour_id;
    private Integer academy_id;
    private String stu_name;
    private String stu_gender;
    private Date stu_birth;
    private String stu_addr;
    private List<Student> students;
    private List<Course> courses;

    public Student(Integer stu_id, Integer academy_id, String stu_name, String stu_gender, Date stu_birth, String stu_addr) {
        this.stu_id = stu_id;
        this.academy_id = academy_id;
        this.stu_name = stu_name;
        this.stu_gender = stu_gender;
        this.stu_birth = stu_birth;
        this.stu_addr = stu_addr;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

//    public Integer getCour_id() {
//        return cour_id;
//    }
//
//    public void setCour_id(Integer cour_id) {
//        this.cour_id = cour_id;
//    }

    public Integer getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(Integer academy_id) {
        this.academy_id = academy_id;
    }



    public Student() {
    }

    public Student(Integer stu_id, String stu_number, String stu_name, String stu_gender, Date stu_birth, String stu_addr) {
        this.stu_id = stu_id;
        this.stu_number = stu_number;
        this.stu_name = stu_name;
        this.stu_gender = stu_gender;
        this.stu_birth = stu_birth;
        this.stu_addr = stu_addr;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_number() {
        return stu_number;
    }

    public void setStu_number(String stu_number) {
        this.stu_number = stu_number;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_gender() {
        return stu_gender;
    }

    public void setStu_gender(String stu_gender) {
        this.stu_gender = stu_gender;
    }

    public Date getStu_birth() {
        return stu_birth;
    }

    public void setStu_birth(Date stu_birth) {
        this.stu_birth = stu_birth;
    }

    public String getStu_addr() {
        return stu_addr;
    }

    public void setStu_addr(String stu_addr) {
        this.stu_addr = stu_addr;
    }

    public Student(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public Student(String stu_number) {
        this.stu_number = stu_number;
    }

    public Student(String stu_number, Integer academy_id, String stu_name, String stu_gender, Date stu_birth, String stu_addr) {
        this.stu_number = stu_number;
        this.academy_id = academy_id;
        this.stu_name = stu_name;
        this.stu_gender = stu_gender;
        this.stu_birth = stu_birth;
        this.stu_addr = stu_addr;
    }
}
