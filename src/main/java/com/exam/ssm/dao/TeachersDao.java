package com.exam.ssm.dao;

import com.exam.ssm.model.Teachers;
import org.apache.ibatis.annotations.Param;

public interface TeachersDao {
    Teachers teacherslogin(@Param("tid") int tid,@Param("password") String password);
    Teachers getteachersinfo(@Param("tid") int tid );

}