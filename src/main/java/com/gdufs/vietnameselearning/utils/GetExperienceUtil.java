package com.gdufs.vietnameselearning.utils;

public class GetExperienceUtil {
//    根据登录天数返回经验值
    public static int getExperience(int days){
        if(days<=4) return 50;
        else if(days>5&&days<8) return 75;
        else return 100;
    }
}
