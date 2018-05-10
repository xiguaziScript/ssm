package com.exam.ssm.service;

import com.exam.ssm.model.CourseBaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IStudentscourseService {
  Map<String,Object> getBasecourseinfo(@Param("sid") int sid);
}
