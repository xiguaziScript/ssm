package com.exam.ssm.service;

import com.exam.ssm.model.Teachers;
import org.apache.ibatis.annotations.Param;

public interface ITeachersService {
    public Teachers getteachersinfo(int tid);
    public Teachers teacherslogin(@Param("tid") int tid,@Param("password") String password);
}
