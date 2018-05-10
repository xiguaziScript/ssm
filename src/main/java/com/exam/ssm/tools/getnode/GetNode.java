package com.exam.ssm.tools.getnode;

public class GetNode {

    public static String  getcourenodebyint(int id){
        String result =null;
        if (id>=1&&id<=11){
            switch (id){
                case 1:result="第一节课 ";break;
                case 2:result="第二节课 ";break;
                case 3:result="第三节课 ";break;
                case 4:result="第四节课 ";break;
                case 5:result="第五节课 ";break;
                case 6:result="第六节课 ";break;
                case 7:result="第七节课 ";break;
                case 8:result="第八节课 ";break;
                case 9:result="第九节课 ";break;
                case 10:result="第十节课 ";break;
                default :result="第十一节课 ";break;
            }
            return result;
        }
        return result;
    }


}
