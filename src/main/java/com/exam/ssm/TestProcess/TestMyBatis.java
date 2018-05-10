package com.exam.ssm.TestProcess;

import com.exam.ssm.dao.MessageDao;
import com.exam.ssm.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestExecutionListeners;
import com.exam.ssm.tools.getWeeks;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TestMyBatis {
    @Resource
    private MessageDao messageDao;
    @Test
    public void getAlluser(){
        String week=new getWeeks().getweeksbyint(1);
        System.out.println(week);

    }
}
