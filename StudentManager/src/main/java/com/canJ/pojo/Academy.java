package com.canJ.pojo;

public class Academy {
    private Integer academy_id;
    private String academy_number;
    private String academy_name;

    public Academy() {
    }

    public Academy(Integer academy_id, String academy_number, String academy_name) {
        this.academy_id = academy_id;
        this.academy_number = academy_number;
        this.academy_name = academy_name;
    }

    public Integer getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(Integer academy_id) {
        this.academy_id = academy_id;
    }

    public String getAcademy_number() {
        return academy_number;
    }

    public void setAcademy_number(String academy_number) {
        this.academy_number = academy_number;
    }

    public String getAcademy_name() {
        return academy_name;
    }

    public void setAcademy_name(String academy_name) {
        this.academy_name = academy_name;
    }

    public Academy(Integer academy_id) {
        this.academy_id = academy_id;
    }

    public Academy(String academy_name) {
        this.academy_name = academy_name;
    }
}
