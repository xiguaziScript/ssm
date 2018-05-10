package com.exam.ssm.tools.token;

import java.util.UUID;

public  class getToken{
  public static String GetGuid(){
      return UUID.randomUUID().toString().replace("-","");
  }
}

