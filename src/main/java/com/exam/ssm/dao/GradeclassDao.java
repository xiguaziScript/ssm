package com.exam.ssm.dao;

import com.exam.ssm.model.Gradeclass;

public interface GradeclassDao {

    int deleteByPrimaryKey(Integer classid);


    int insert(Gradeclass record);


    int insertSelective(Gradeclass record);


    Gradeclass getbaseinfobyclassid(Integer classid);


    int updateByPrimaryKeySelective(Gradeclass record);


    int updateByPrimaryKey(Gradeclass record);
}