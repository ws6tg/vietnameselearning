package com.gdufs.vietnameselearning.controller;

import com.gdufs.vietnameselearning.entity.Schedule;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.services.Impl.ScheduleServiceImpl;
import com.gdufs.vietnameselearning.services.UserService;
import com.gdufs.vietnameselearning.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleServiceImpl scheduleService;

    @Autowired
    private UserService userService;

    @PostMapping("/addSchedule")
    public ResultJson addSchedule(HttpServletRequest request, Schedule schedule){
        Integer userId=(Integer) request.getSession().getAttribute("userId");
        User user=userService.getById(userId);
        try{
            int count=scheduleService.addSchedule(user,schedule);
            if (count==0)
                return new ResultJson(0,"修改用户表失败");
            else
                return new ResultJson(1,"添加成功");
        }catch (Exception e){
            return new ResultJson(0,"重复添加");
        }
    }

    @RequestMapping("/getSchedule")
    public ResultJson getSchedule(HttpServletRequest request){
        Integer userId=(Integer) request.getSession().getAttribute("userId");
        Integer thesaurusId=userService.getById(userId).getThesaurusId();
        if(thesaurusId==null){
            return new ResultJson(0,"当前没有计划");
        }
        try{
            return new ResultJson(1,scheduleService.getScheduleByIndex(userId,thesaurusId));
        }catch (Exception e){
            return new ResultJson(0,"error");
        }
    }

    @PostMapping("/updateSchedule")
    public ResultJson updateSchedule(HttpServletRequest request, Schedule schedule){
        Integer userId=(Integer) request.getSession().getAttribute("userId");
        try{
            scheduleService.updateSchedule(userId,schedule);
            return new ResultJson(1,"更新成功");
        }catch (Exception e){
            e.printStackTrace();
            return new ResultJson(0,"error");
        }
    }
}
