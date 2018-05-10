package com.exam.ssm.controller;

import com.exam.ssm.model.Admin;
import com.exam.ssm.model.Students;
import com.exam.ssm.model.Teachers;
import com.exam.ssm.service.IAdminsService;
import com.exam.ssm.service.IStudentsService;
import com.exam.ssm.service.ITeachersService;
import com.exam.ssm.tools.jwtutils.JWTHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.exam.ssm.tools.md5.Md5;
import com.exam.ssm.tools.Message.ResponseMessage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import java.security.NoSuchAlgorithmException;


@Controller
@RequestMapping("/userLogin")
public class UserLoginController {
    @Resource
    private IStudentsService iStudentsService;
    @Resource
    private ITeachersService iTeachersService;
    @Resource
    private IAdminsService iAdminsService;

    @PostMapping("/studentsLogin")
    @ResponseBody
    public ResponseMessage studentslogin(HttpServletRequest request) throws NoSuchAlgorithmException {
        int sid = Integer.parseInt(request.getParameter("sid"));
        String password=request.getParameter("password");
        if(password.isEmpty()||password == null ||String.valueOf(sid).isEmpty()||String.valueOf(sid)==null ){
            return ResponseMessage.passwordorusernamenotnull();
        }
        System.out.println(sid+":"+password);
        String md5stringPassword = new Md5().getMd5(password);
        System.out.println(md5stringPassword);
        Students students=iStudentsService.studentsLogin(sid,md5stringPassword);
        //HashMap<String, String> testObj = new HashMap <String, String>();

        if (students==null){
            System.out.println("error:login faild");
            return ResponseMessage.passwordorusernameerror();

        }else {

            System.out.println("success:welcome  "+students.getName());
            String token = JWTHelper.sign(students,30L*24L*3600L);
            return ResponseMessage.ok().putDataValue("token",token);

        }

    }

    @PostMapping("/teachersLogin")
    @ResponseBody
    public ResponseMessage teacherslogin(HttpServletRequest request) throws NoSuchAlgorithmException{

        int tid =Integer.parseInt(request.getParameter("tid"));
        String password=request.getParameter("password");
        if(password.isEmpty()||password == null ||String.valueOf(tid).isEmpty()||String.valueOf(tid)==null ){
            return ResponseMessage.passwordorusernamenotnull();
        }
        String md5String = new Md5().getMd5(password);
        System.out.println("tid->>>>>>>>>>"+"       "+tid);
        System.out.println("password->>>>>>>>>>"+"       "+md5String);
        Teachers teachers = iTeachersService.teacherslogin(tid,md5String);
        if (teachers==null){
            return ResponseMessage.passwordorusernameerror();
        }else {
            String token =JWTHelper.sign(teachers,30L*24L*3600L);//过期时间为30天
            return ResponseMessage.ok().putDataValue("token",token);
        }

    }

    @PostMapping("/adminsLogin")
    @ResponseBody
    public ResponseMessage adminislogn(HttpServletRequest request) throws  NoSuchAlgorithmException{

        int aid = Integer.parseInt(request.getParameter("aid"));
        String password = request.getParameter("password");
        if(password.isEmpty()||password == null ||String.valueOf(aid).isEmpty()||String.valueOf(aid)==null ){
            return ResponseMessage.passwordorusernamenotnull();
        }
        String md5string = new Md5().getMd5(password);

        Admin admin = iAdminsService.adminsLogin(aid,md5string);

        if (admin==null){
            return ResponseMessage.passwordorusernameerror();
        }
        String token =JWTHelper.sign(admin,30L*24L*3600L);

        return ResponseMessage.ok().putDataValue("token",token);

    }
}
