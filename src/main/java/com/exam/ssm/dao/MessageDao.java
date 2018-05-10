package com.exam.ssm.dao;

import com.exam.ssm.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MessageDao {

    int deleteByPrimaryKey(Integer messageid);

    /**
     * Message添加
     * @param record
     * @return
     */
    int addmessage(Message record);


    int insertSelective(Message record);


    Message selectByPrimaryKey(Integer messageid);


    int updateByPrimaryKeySelective(Message record);


    int updateByPrimaryKeyWithBLOBs(Message record);


    int updateByPrimaryKey(Message record);

    List<Message> getMessagesBytarget(@Param("messagetarget") int messagetarget);

    /**
     *  默认以时间降序排列
     * @param startline 开始记录数
     * @param endline  结束结论数
     * @return
     */
    List<Message>getMessageAll(@Param("startline") int startline,@Param("endline") int endline);
}