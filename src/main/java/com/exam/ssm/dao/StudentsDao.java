package com.exam.ssm.dao;

import com.exam.ssm.model.Students;
import org.apache.ibatis.annotations.Param;

public interface StudentsDao {
    Students getStudents(int sid);
    Students studentsLogin(@Param("sid") int sid, @Param("password") String password);



}
