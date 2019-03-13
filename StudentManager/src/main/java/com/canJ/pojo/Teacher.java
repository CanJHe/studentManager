package com.canJ.pojo;

public class Teacher {
    private Integer teacher_id;
    private String teach_number;
    private Integer academy_id;
 //   private Integer cour_id;

    public Integer getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(Integer academy_id) {
        this.academy_id = academy_id;
    }

//    public Integer getCour_id() {
//        return cour_id;
//    }
//
//    public void setCour_id(Integer cour_id) {
//        this.cour_id = cour_id;
//    }

    private String teach_name;
    private String gender;
    private String nickname;

    public Teacher() {
    }

    public Teacher(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Teacher(Integer teacher_id, String teach_number, String teach_name, String gender, String nickname) {
        this.teacher_id = teacher_id;
        this.teach_number = teach_number;
        this.teach_name = teach_name;
        this.gender = gender;
        this.nickname = nickname;
    }

    public Teacher(Integer teacher_id, Integer academy_id, String teach_name, String gender, String nickname) {
        this.teacher_id = teacher_id;
        this.academy_id = academy_id;
        this.teach_name = teach_name;
        this.gender = gender;
        this.nickname = nickname;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeach_number() {
        return teach_number;
    }

    public void setTeach_number(String teach_number) {
        this.teach_number = teach_number;
    }

    public String getTeach_name() {
        return teach_name;
    }

    public void setTeach_name(String teach_name) {
        this.teach_name = teach_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Teacher(String teach_number, Integer academy_id, String teach_name, String gender, String nickname) {
        this.teach_number = teach_number;
        this.academy_id = academy_id;
        this.teach_name = teach_name;
        this.gender = gender;
        this.nickname = nickname;
    }
}

