package com.exam.ssm.dao;

import com.exam.ssm.model.Studentscourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentscourseDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Studentscourse record);


    int insertSelective(Studentscourse record);


    Studentscourse selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Studentscourse record);


    int updateByPrimaryKey(Studentscourse record);


    List<Studentscourse> getstudentcoursebysid(@Param("sid") int sid);
}