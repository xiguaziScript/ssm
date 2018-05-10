package com.exam.ssm.model;

import java.io.PrintStream;
import java.io.Serializable;

public class CourseBaseInfo implements Serializable{
    private String coursename;
    private String weeks;
    private String Location;
    private String teachername;
    private String nodes[];

    public String[] getNodes() {
        return nodes;
    }

    public void setNodes(String[] nodes) {
        this.nodes = nodes;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
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

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }




}
