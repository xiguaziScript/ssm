package com.exam.ssm.service;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ITeachersCourseService {
    Map<String,Object> getteacherscourse(@Param("tid") int tid);
}
