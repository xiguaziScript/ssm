package com.exam.ssm.service;

import com.exam.ssm.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface IMessageService {
    public List<Message> getMessagesBytarget(@Param("messagetarget") int messagetarget);
    List<Message>getMessageAll(@Param("startline") int startline,@Param("endline") int endline);
    int addmessage(@Param("message") Message message);
}
