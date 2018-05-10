package com.exam.ssm.service.impl;

import com.exam.ssm.dao.AdminDao;
import com.exam.ssm.model.Admin;
import com.exam.ssm.service.IAdminsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminsServiceImpl implements IAdminsService {

    @Resource
    private  AdminDao adminDao;

    @Override
    public Admin adminsLogin(int aid, String password) {
        return adminDao.adminsLogin(aid,password);
    }

    @Override
    public Admin getadminsinfo(int aid) {
        return adminDao.getadminsinfo(aid);
    }
}
