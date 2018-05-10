package com.exam.ssm.service.impl;

import com.exam.ssm.dao.StudentsDao;
import com.exam.ssm.model.Students;
import com.exam.ssm.service.IStudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentsServiceImpl implements IStudentsService {

    @Resource
    private  StudentsDao studentsDao;

    @Override
    /**
     * 学生登陆
     */
    public Students studentsLogin(int sid, String password) {
        return studentsDao.studentsLogin(sid,password);
    }

    @Override
    public Students getStudents(int sid) {
        return  studentsDao.getStudents(sid);
    }
}
