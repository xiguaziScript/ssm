package com.exam.ssm.service.impl;

import com.exam.ssm.dao.TeachersDao;
import com.exam.ssm.model.Teachers;
import com.exam.ssm.service.ITeachersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TeachersServiceImpl implements ITeachersService {
    @Resource
    private TeachersDao teachersDao;
    @Override
    public Teachers teacherslogin(int tid, String password) {return teachersDao.teacherslogin(tid,password); }

    @Override
    public Teachers getteachersinfo(int tid) {return teachersDao.getteachersinfo(tid); }



}
