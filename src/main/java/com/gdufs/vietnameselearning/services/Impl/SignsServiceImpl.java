package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Experience;
import com.gdufs.vietnameselearning.entity.Signs;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.mapper.ExperienceMapper;
import com.gdufs.vietnameselearning.mapper.SignsMapper;
import com.gdufs.vietnameselearning.mapper.UserMapper;
import com.gdufs.vietnameselearning.services.SignsService;
import com.gdufs.vietnameselearning.utils.DateUtil;
import com.gdufs.vietnameselearning.utils.GetExperienceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SignsServiceImpl extends ServiceImpl<SignsMapper, Signs> implements SignsService {
    @Autowired
    private SignsMapper signsMapper;

    @Autowired
    private ExperienceMapper experienceMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public String sign(int userId){
        Signs signs=signsMapper.selectOne(new QueryWrapper<Signs>().
                eq("user_id",userId).orderByDesc("date").last("limit 1"));

        Date today = new Date();//获取今天的日期
        if(signs==null){
            signs=new Signs(userId, today,1);
        }
        else if (DateUtil.dateToString(signs.getDate()).equals(DateUtil.getYestoday(today))){
            signs.setDate(today);
            signs.setContinuousdays(signs.getContinuousdays()+1);
        }
        else {
            signs.setDate(today);
            signs.setContinuousdays(1);
        }

        signsMapper.insert(signs);
        int ex= GetExperienceUtil.getExperience(signs.getContinuousdays());
        experienceMapper.insert(new Experience(userId,1,new Date(), ex));
        User user=userMapper.selectById(userId);
        user.setExperience(user.getExperience()+ex);
        user.setDatecount(user.getDatecount()+1);
        userMapper.updateById(user);

        return String.format("连续打卡%d天,经验值+%d", signs.getContinuousdays(),ex);

    }

}
