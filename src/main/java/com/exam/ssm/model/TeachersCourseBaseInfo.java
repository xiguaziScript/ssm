package com.exam.ssm.model;

import java.util.List;

public class TeachersCourseBaseInfo {
    private String coursename;
    private String   weeks;
    private String[] nodes;
    private List<String> classnum;
    private String location;
    private String times;

    public List<String> getClassnum() {
        return classnum;
    }

    public void setClassnum(List<String> classnum) {
        this.classnum = classnum;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    public String[] getNodes() {
        return nodes;
    }

    public void setNodes(String[] nodes) {
        this.nodes = nodes;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
