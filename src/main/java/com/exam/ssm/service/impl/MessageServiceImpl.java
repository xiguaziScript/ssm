package com.exam.ssm.service.impl;

import com.exam.ssm.dao.MessageDao;
import com.exam.ssm.model.Message;
import com.exam.ssm.service.IMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {
    @Resource
    private MessageDao messageDao;

    @Override
    public List<Message> getMessageAll(int startline, int endline) {

        return messageDao.getMessageAll(startline,endline);
    }

    @Override
    public List<Message> getMessagesBytarget(int messagetarget) {
        return messageDao.getMessagesBytarget(messagetarget);
    }

    @Override
    public int addmessage(Message message) {
        return messageDao.addmessage(message);
    }
}
