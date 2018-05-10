package com.exam.ssm.service.impl;

import com.exam.ssm.dao.StudentsDao;
import com.exam.ssm.dao.StudentscourseDao;
import com.exam.ssm.dao.TeachersDao;
import com.exam.ssm.model.CourseBaseInfo;
import com.exam.ssm.model.Studentscourse;
import com.exam.ssm.model.Teachers;
import com.exam.ssm.service.IStudentscourseService;
import com.exam.ssm.tools.getnode.GetNode;
import org.springframework.stereotype.Service;
import com.exam.ssm.tools.getWeeks;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class StudentcourseServiceImpl implements IStudentscourseService {
    @Resource
    private StudentscourseDao studentscourseDao;

    @Resource
    private TeachersDao teachersDao;

    @Override
    public Map<String, Object> getBasecourseinfo(int sid) {

        List<Studentscourse> studentscourseList = studentscourseDao.getstudentcoursebysid(sid);
        Map <String,Object> resultmap = new TreeMap<>();
        for(int i=1;i<6;i++){
            List<CourseBaseInfo> courseBaseInfoList =new ArrayList<>();
            for (int j=0;j< studentscourseList.size();j++){
                if (studentscourseList.get(j).getWeeks().equals(new getWeeks().getweeksbyint(i).trim())){
                    CourseBaseInfo courseBaseInfo = new CourseBaseInfo();
                    courseBaseInfo.setCoursename(studentscourseList.get(j).getCoursename());//得到课程名
                    courseBaseInfo.setWeeks(studentscourseList.get(j).getTimes());
                    String[]  nodes = studentscourseList.get(j).getNodes().split(",");
                    courseBaseInfo.setNodes(nodes);
                    courseBaseInfo.setLocation(studentscourseList.get(j).getClasslocationnum());
                    courseBaseInfo.setTeachername(teachersDao.getteachersinfo(studentscourseList.get(j).getTid()).getName());
                    courseBaseInfoList.add(courseBaseInfo);
                }
            }
            resultmap.put(new getWeeks().getweeksbyint(i).trim().toString(),courseBaseInfoList);

        }

        return resultmap;


    }
}
