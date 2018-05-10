package com.exam.ssm.service;

import com.exam.ssm.model.Students;
import org.apache.ibatis.annotations.Param;

public interface IStudentsService {
    public Students getStudents(@Param("sid") int sid);
    public Students studentsLogin(@Param("sid") int name, @Param("password") String password);
}
