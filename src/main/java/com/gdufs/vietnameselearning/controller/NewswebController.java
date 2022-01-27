package com.gdufs.vietnameselearning.controller;

import com.gdufs.vietnameselearning.entity.Newsweb;
import com.gdufs.vietnameselearning.services.NewswebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewswebController {
    @Autowired
    private NewswebService newswebService;

    @RequestMapping("/getNewsweb")
    public List<Newsweb> getNewsweb(){
        return newswebService.list();
    }
}
