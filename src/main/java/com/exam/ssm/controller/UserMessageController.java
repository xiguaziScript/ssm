package com.exam.ssm.controller;

import java.util.List;
import com.exam.ssm.model.Admin;
import com.exam.ssm.model.Message;
import com.exam.ssm.model.Students;
import com.exam.ssm.model.Teachers;
import com.exam.ssm.service.IMessageService;
import com.exam.ssm.service.IStudentscourseService;
import com.exam.ssm.service.ITeachersCourseService;
import com.exam.ssm.tools.Message.ResponseMessage;
import com.exam.ssm.tools.jwtutils.JWTHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;


@Controller
@RequestMapping("/Usermessage")
public class UserMessageController {
    @Resource
    private  IMessageService iMessageService;
    @Resource
    private IStudentscourseService iStudentscourseService;
    @Resource
    private ITeachersCourseService iTeachersCourseService;
    @RequestMapping("/getstudentsmessage")
    @ResponseBody
    public ResponseMessage getstudentmessage(HttpServletRequest request){

      /*  String token =request.getParameter("token");
        Admin admin = JWTHelper.unsign(token,Admin.class);
        if (admin==null){
            return ResponseMessage.badRequest();
        }*/
        int messagetarget = Integer.parseInt(request.getParameter("messagetarget"));
        List<Message> MessageList=iMessageService.getMessagesBytarget(messagetarget);
       /* for(Message message:MessageList){
            System.out.println(message.toString());
        }
*/
       return ResponseMessage.ok().putDataValue("messagelist",MessageList);
    }

    @RequestMapping("/getmessagesize")
    @ResponseBody
    public ResponseMessage getmessagesize(HttpServletRequest request){

        String startline = request.getParameter("startline");
        String endline = request.getParameter("endline");
        String token = request.getParameter("token");
        if (startline.isEmpty()||startline==null||endline.isEmpty()||endline==null||token.isEmpty()||token==null){
            return ResponseMessage.badRequest();
        }
        int start = Integer.parseInt(startline);
        int end=Integer.parseInt(endline);
        if (start>end||start<0||end<0){
            return ResponseMessage.badRequest();
        }
        Admin admin = JWTHelper.unsign(token,Admin.class);
        if (admin==null){
            return ResponseMessage.badRequest();
        }
        List<Message> messageslist=iMessageService.getMessageAll(start,end);

        return ResponseMessage.ok().putDataValue("messagelist",messageslist);
    }

    @PostMapping("/addMessage")
    @ResponseBody
    public ResponseMessage addmessage(HttpServletRequest request){
        String messagetarget=request.getParameter("messagetarget");
        String  messagetype =request.getParameter("messagetype");
        String  messagetitle =request.getParameter("messagetitle");
        String messagetime =request.getParameter("messagetime");
        String messagecontent=request.getParameter("messagecontent");
        Message message =new Message();
        message.setMessagetype(messagetype);
        message.setMessagecontent(messagecontent);
        message.setMessagetitle(messagetitle);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(messagetime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        message.setMessagetime(date);
        String[] messagelist=messagetarget.split(",");
        for(int i=0;i<messagelist.length;i++){
            System.out.println(messagelist[i]);
            int messagetargetinfo=Integer.parseInt(messagelist[i]);
            message.setMessagetarget(messagetargetinfo);
            try{
                iMessageService.addmessage(message);
            }catch (Exception e){
                e.printStackTrace();
                return ResponseMessage.badRequest();
            }
        }
        return ResponseMessage.ok();
    }


    @RequestMapping("/getstudentsCourses")
    @ResponseBody
    public ResponseMessage getstudentsCourse(HttpServletRequest request){
        String token =request.getParameter("token");
        Students students=JWTHelper.unsign(token,Students.class);
        //Admin admin =JWTHelper.unsign(token,Admin.class);
        if (students==null){
            return ResponseMessage.badRequest();
        }
        Map<String,Object> courselist=iStudentscourseService.getBasecourseinfo(2014090);
        return ResponseMessage.ok().putDataValue("courselist",courselist);

    }


    @RequestMapping("/getteachersCourse")
    @ResponseBody
    public ResponseMessage getteachersCourse(HttpServletRequest request){

        String token =request.getParameter("token");
        Teachers teachers=JWTHelper.unsign(token,Teachers.class);
        //Admin admin =JWTHelper.unsign(token,Admin.class);
        if (teachers==null){
            return ResponseMessage.badRequest();
        }
        Map<String,Object> courselist = iTeachersCourseService.getteacherscourse(541236);
        return ResponseMessage.ok().putDataValue("teachersCourse",courselist);
    }










}

