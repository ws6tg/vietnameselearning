package com.gdufs.vietnameselearning.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdufs.vietnameselearning.entity.Signs;
import com.gdufs.vietnameselearning.services.Impl.SignsServiceImpl;
import com.gdufs.vietnameselearning.utils.ResultJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class SignsController {
    @Autowired
    private SignsServiceImpl signsService;

    @PostMapping("/sign")
    public ResultJson sign(HttpServletRequest request){
        Integer userId=(Integer) request.getSession().getAttribute("userId");
        try {
            return new ResultJson(1,signsService.sign(userId));
        }catch (Exception e){
            return new ResultJson(0,"重复打卡");
        }
    }

    @GetMapping("/signrecord")
    public List<Signs> getSignsRecord(HttpServletRequest request){
        Integer userId=(Integer) request.getSession().getAttribute("userId");
        return signsService.list(new QueryWrapper<Signs>().eq("user_id",userId));
    }
}
