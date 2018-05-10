package com.exam.ssm.service.impl;

import com.exam.ssm.dao.TeacherscourseDao;
import com.exam.ssm.model.TeachersCourseBaseInfo;
import com.exam.ssm.model.Teacherscourse;
import com.exam.ssm.service.IGradeclassService;
import com.exam.ssm.service.ITeachersCourseService;
import com.exam.ssm.tools.getWeeks;
import com.exam.ssm.tools.getnode.GetNode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


@Service
public class TeachersCourseServiceImpl implements ITeachersCourseService {
    @Resource
    private TeacherscourseDao teacherscourseDao;
    @Resource
    private IGradeclassService iGradeclassService;
    @Override
    public Map<String, Object> getteacherscourse(int tid) {
        List<Teacherscourse> teacherscourseList = teacherscourseDao.getTeacherscoursebytid(tid);
        Map<String,Object> resultmap = new TreeMap<>();
        for(int i=1;i<6;i++){
            List<TeachersCourseBaseInfo> teachersCourseBaseInfoList =new ArrayList<>();
            for (int j =0;j<teacherscourseList.size();j++){
                System.out.println(j);
                System.out.println(i);
                if (teacherscourseList.get(j).getWeeks().equals(new getWeeks().getweeksbyint(i).trim())){
                    System.out.println(teacherscourseList.get(j).getWeeks());
                    System.out.println(new getWeeks().getweeksbyint(i).trim());


                    TeachersCourseBaseInfo teachersCourseBaseInfo = new TeachersCourseBaseInfo();
                    teachersCourseBaseInfo.setCoursename(teacherscourseList.get(j).getCoursename());
                    teachersCourseBaseInfo.setWeeks(teacherscourseList.get(j).getWeeks());
                    teachersCourseBaseInfo.setTimes(teacherscourseList.get(j).getTimes());
                    String[] nodelist=teacherscourseList.get(j).getNodes().split(",");
                    teachersCourseBaseInfo.setNodes(nodelist);
                    teachersCourseBaseInfo.setLocation(teacherscourseList.get(j).getClasslocationnum());
                    String[] classidlist =teacherscourseList.get(j).getClassid().split(",");
                    List<String> classnamelist = iGradeclassService.getclassname(classidlist);
                    teachersCourseBaseInfo.setClassnum(classnamelist);
                    teachersCourseBaseInfoList.add(teachersCourseBaseInfo);
                }
            }
            resultmap.put(String.valueOf(i).toString(),teachersCourseBaseInfoList);

        }


        return resultmap;
    }
}
