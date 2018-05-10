package com.exam.ssm.dao;

import com.exam.ssm.model.Teacherscourse;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface TeacherscourseDao {

    int deleteByPrimaryKey(Integer id);


    int insert(Teacherscourse record);


    int insertSelective(Teacherscourse record);


    Teacherscourse selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Teacherscourse record);


    int updateByPrimaryKey(Teacherscourse record);

    List<Teacherscourse> getTeacherscoursebytid(@Param("tid") int tid);
}