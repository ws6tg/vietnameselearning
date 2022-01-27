package com.gdufs.vietnameselearning.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdufs.vietnameselearning.entity.Stastics;
import com.gdufs.vietnameselearning.services.StasticsService;
import com.gdufs.vietnameselearning.utils.DateUtil;
import com.gdufs.vietnameselearning.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StasticsController {
    @Autowired
    private StasticsService stasticsService;

    @PostMapping("/addStastics")
    public ResultJson addStastics(HttpServletRequest request, Stastics stastics) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        stastics.setUserId(userId);
        try {
            stasticsService.save(stastics);
            return new ResultJson(1, "添加成功");
        } catch (Exception e) {
            return new ResultJson(0, "添加失败");
        }

    }

    @RequestMapping("/getStastics")
    public ResultJson getStastics(HttpServletRequest request, @RequestParam int day) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        QueryWrapper<Stastics> queryWrapper = new QueryWrapper<Stastics>().
                eq("user_id", userId).
                orderByDesc("date").
                last(String.format("limit %d", day));
        try {
            return new ResultJson(1, stasticsService.list(queryWrapper));
        } catch (Exception e) {
            return new ResultJson(0, "查询失败");
        }

    }

    @PostMapping("/updateStastics")
    public ResultJson updateStastics(HttpServletRequest request, Stastics stastics) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        stastics.setUserId(userId);
        QueryWrapper<Stastics> queryWrapper = new QueryWrapper<Stastics>().
                eq("user_id", userId).
                eq("date", DateUtil.dateToString(stastics.getDate()));
        try {
            stasticsService.update(stastics, queryWrapper);
            return new ResultJson(1, "更新成功");
        } catch (Exception e) {
            return new ResultJson(0, "更新失败");
        }

    }
}
