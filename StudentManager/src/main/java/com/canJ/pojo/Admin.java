package com.canJ.pojo;

import java.util.Date;

public class Admin {
    private Integer id;
    private String adminname;
    private String adpassword;
    private String adnickname;
    private String gender;
    private Integer age;
    private String adphone;
    private String ademail;
    private Date adcreatetime;
    private String adremark;

    public Admin(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdphone() {
        return adphone;
    }

    public void setAdphone(String adphone) {
        this.adphone = adphone;
    }

    public String getAdemail() {
        return ademail;
    }

    public void setAdemail(String ademail) {
        this.ademail = ademail;
    }

    public Date getAdcreatetime() {
        return adcreatetime;
    }

    public void setAdcreatetime(Date adcreatetime) {
        this.adcreatetime = adcreatetime;
    }

    public String getAdremark() {
        return adremark;
    }

    public void setAdremark(String adremark) {
        this.adremark = adremark;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdpassword() {
        return adpassword;
    }

    public void setAdpassword(String adpassword) {
        this.adpassword = adpassword;
    }

    public String getAdnickname() {
        return adnickname;
    }

    public void setAdnickname(String adnickname) {
        this.adnickname = adnickname;
    }




    public Admin(String adminname, String adpassword, String nickname, String gender, Integer age, String phone, String email, Date adcreatetime, String remark) {
        this.adminname = adminname;
        this.adpassword = adpassword;
        this.adnickname = nickname;
        this.gender = gender;
        this.age = age;
        this.adphone = phone;
        this.ademail = email;
        this.adcreatetime = adcreatetime;
        this.adremark = remark;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", adminname='" + adminname + '\'' +
                ", adpassword='" + adpassword + '\'' +
                ", adnickname='" + adnickname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", adphone='" + adphone + '\'' +
                ", ademail='" + ademail + '\'' +
                ", adcreatetime=" + adcreatetime +
                ", adremark='" + adremark + '\'' +
                '}';
    }
}
