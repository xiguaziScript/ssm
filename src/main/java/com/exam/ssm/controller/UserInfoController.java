package com.exam.ssm.controller;

import com.exam.ssm.model.Admin;
import com.exam.ssm.model.Students;
import com.exam.ssm.model.Teachers;
import com.exam.ssm.service.IAdminsService;
import com.exam.ssm.service.IStudentsService;
import com.exam.ssm.service.ITeachersService;
import com.exam.ssm.tools.Message.ResponseMessage;
import com.exam.ssm.tools.jwtutils.JWTHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
    @Resource
    private ITeachersService iTeachersService;
    @Resource
    private IStudentsService iStudentsService;
    @Resource
    private IAdminsService iAdminsService;

    @RequestMapping("/getStudentinfo")
    @ResponseBody
    public ResponseMessage getstudentinfo(HttpServletRequest request) {
        String token = request.getParameter("token");
        Students students = JWTHelper.unsign(token, Students.class);
        if (students != null) {
            students.setPassword("************");
            return ResponseMessage.ok().putDataValue("students", students);

        } else {
            return ResponseMessage.badRequest();
        }
    }


     @RequestMapping("/getTeacherinfo")
     @ResponseBody
     public  ResponseMessage getteacherinfo(HttpServletRequest request){
            String token = request.getParameter("token");
            if(token.isEmpty()||token==null){
               return ResponseMessage.badRequest();
            }
            Teachers teachers =JWTHelper.unsign(token,Teachers.class);
            if (teachers==null){
                return ResponseMessage.badRequest();
            }
            teachers.setPassword("**********");
            return ResponseMessage.ok().putDataValue("teacher",teachers);
        }

     @RequestMapping("/getAdmininfo")
     @ResponseBody
    public  ResponseMessage getadmininfo(HttpServletRequest request, HttpServletResponse response){
        String token =request.getParameter("token");
        if (token.isEmpty()||token==null){
          return ResponseMessage.badRequest();
        }
         Admin admin =JWTHelper.unsign(token,Admin.class);
        if (admin==null){
            return ResponseMessage.badRequest();
        }
        admin.setPassword("***********");
        return ResponseMessage.ok().putDataValue("admin",admin);
    }




}
