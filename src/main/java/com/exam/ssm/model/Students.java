package com.exam.ssm.model;

public class Students {

    private int sid;


    private String name;


    private String sex;


    private String grade;


    private String major;


    private String classinfo;


    private String idCard;


    private String tel;


    private String password;


    public Integer getSid() {
        return sid;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getGrade() {
        return grade;
    }


    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getMajor() {
        return major;
    }


    public void setMajor(String major) {
        this.major = major;
    }


    public String getClassinfo() {
        return classinfo;
    }


    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
    }



    public String getIdCard() {
        return idCard;
    }


    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }


    public String getTel() {
        return tel;
    }


    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }
}