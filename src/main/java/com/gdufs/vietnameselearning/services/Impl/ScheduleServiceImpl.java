package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Schedule;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.mapper.ScheduleMapper;
import com.gdufs.vietnameselearning.mapper.UserMapper;
import com.gdufs.vietnameselearning.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int addSchedule(User user,Schedule schedule){
        schedule.setUserId(user.getId());
        schedule.setStartdate(new Date());
        user.setThesaurusId(schedule.getThesaurusId());
        int count=userMapper.updateById(user);
        if(count==1){
            count=scheduleMapper.insert(schedule);
            return count;
        }else {
            return count;
        }
    }

    public List<Schedule> getScheduleByIndex(Integer userId, Integer thesaurusId){
        return scheduleMapper.selectList(new QueryWrapper<Schedule>().
                eq("user_id",userId).
                eq("thesaurus_id",thesaurusId));
    }

    public void updateSchedule(Integer userId, Schedule schedule){
        User user=userMapper.selectById(userId);
        schedule.setUserId(userId);
        if(!user.getThesaurusId().equals(schedule.getThesaurusId())){
            user.setThesaurusId(schedule.getThesaurusId());
            userMapper.updateById(user);
        }
        scheduleMapper.updateById(schedule);
    }


}
