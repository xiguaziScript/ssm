package com.exam.ssm.service;

import com.exam.ssm.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface IAdminsService {
    public Admin adminsLogin(@Param("aid") int aid,@Param("password") String password);
    public Admin getadminsinfo(@Param("aid") int aid);
}
