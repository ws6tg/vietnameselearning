package com.gdufs.vietnameselearning.controller;

import com.gdufs.vietnameselearning.entity.Experience;
import com.gdufs.vietnameselearning.services.Impl.ExperienceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ExperienceController {
    @Autowired
    ExperienceServiceImpl experienceService;


    @RequestMapping("/experience")
    public List<Experience> selectExperience(HttpServletRequest request){
        Integer userId=(Integer) request.getSession().getAttribute("userId");
        return experienceService.selectListById(userId);
    }

}
