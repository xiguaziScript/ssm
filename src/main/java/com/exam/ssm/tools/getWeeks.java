package com.exam.ssm.tools;

public class getWeeks {

    public static String  getweeksbyint(int id){
        String result =null;
        if (id>=1&&id<=7){
            switch (id){
                case 1:result="星期一 ";break;
                case 2:result="星期二 ";break;
                case 3:result="星期三 ";break;
                case 4:result="星期四 ";break;
                case 5:result="星期五 ";break;
                case 6:result="星期六 ";break;
                default :result="星期天 ";break;
            }
            return result;
        }
        return result;
    }

}
