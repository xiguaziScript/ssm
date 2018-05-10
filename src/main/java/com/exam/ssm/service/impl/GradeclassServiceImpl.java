package com.exam.ssm.service.impl;

import com.exam.ssm.dao.GradeclassDao;
import com.exam.ssm.model.Gradeclass;
import com.exam.ssm.service.IGradeclassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class GradeclassServiceImpl implements IGradeclassService {
    @Resource
    private GradeclassDao gradeclassDao;

    @Override
    public List<String> getclassname(String[] classidlist) {
        List<String> classnamelist = new ArrayList<>();
        for (int i =0;i<classidlist.length;i++){
            Gradeclass gradeclass = gradeclassDao.getbaseinfobyclassid(Integer.parseInt(classidlist[i]));
            String classname=gradeclass.getGrade()+"级"+gradeclass.getMajor()+gradeclass.getClassnum();
            classnamelist.add(classname);
        }
        return classnamelist;
    }
}
