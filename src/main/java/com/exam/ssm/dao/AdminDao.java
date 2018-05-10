package com.exam.ssm.dao;

import com.exam.ssm.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {

    int deleteByPrimaryKey(Integer aid);


    int insert(Admin record);


    int insertSelective(Admin record);


    Admin selectByPrimaryKey(Integer aid);


    int updateByPrimaryKeySelective(Admin record);


    int updateByPrimaryKey(Admin record);

    Admin adminsLogin(@Param("aid") int aid , @Param("password") String password);

    Admin getadminsinfo(@Param("aid") int aid);

}