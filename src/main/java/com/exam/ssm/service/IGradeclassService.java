package com.exam.ssm.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IGradeclassService {
    List<String> getclassname(@Param("String[]") String[] classidlist);
}
