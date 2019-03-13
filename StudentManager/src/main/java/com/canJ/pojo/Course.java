package com.canJ.pojo;

import java.util.Date;

public class Course {
    private Integer cour_id;
    private Student student;
    private Integer stu_id;
    private Integer teacher_id;
    private String cour_number;
    private String cour_name;
    private String cour_sort;
    private Integer cour_credit;
    private Integer cour_grade;
    private Date teach_time;

    public Course(Integer stu_id, Integer teacher_id, String cour_number, String cour_name, String cour_sort, Integer cour_credit, Integer cour_grade, Date teach_time) {
        this.stu_id = stu_id;
        this.teacher_id = teacher_id;
        this.cour_number = cour_number;
        this.cour_name = cour_name;
        this.cour_sort = cour_sort;
        this.cour_credit = cour_credit;
        this.cour_grade = cour_grade;
        this.teach_time = teach_time;
    }

    public Course() {
    }
    public Course(Integer cour_id, String cour_number, String cour_name, String cour_sort, Integer cour_credit, Integer cour_grade, Date teach_time) {
        this.cour_id = cour_id;
        this.cour_number = cour_number;
        this.cour_name = cour_name;
        this.cour_sort = cour_sort;
        this.cour_credit = cour_credit;
        this.cour_grade = cour_grade;
        this.teach_time = teach_time;
    }
    public Course(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public Integer getStu_id() {
        return stu_id;
    }

    public void setStu_id(Integer stu_id) {
        this.stu_id = stu_id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getCour_id() {
        return cour_id;
    }

    public void setCour_id(Integer cour_id) {
        this.cour_id = cour_id;
    }

    public String getCour_number() {
        return cour_number;
    }

    public void setCour_number(String cour_number) {
        this.cour_number = cour_number;
    }

    public String getCour_name() {
        return cour_name;
    }

    public void setCour_name(String cour_name) {
        this.cour_name = cour_name;
    }

    public String getCour_sort() {
        return cour_sort;
    }

    public void setCour_sort(String cour_sort) {
        this.cour_sort = cour_sort;
    }

    public Integer getCour_credit() {
        return cour_credit;
    }

    public void setCour_credit(Integer cour_credit) {
        this.cour_credit = cour_credit;
    }

    public Integer getCour_grade() {
        return cour_grade;
    }

    public void setCour_grade(Integer cour_grade) {
        this.cour_grade = cour_grade;
    }

    public Date getTeach_time() {
        return teach_time;
    }

    public void setTeach_time(Date teach_time) {
        this.teach_time = teach_time;
    }
}
