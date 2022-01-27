package com.gdufs.vietnameselearning.controller;

import com.gdufs.vietnameselearning.entity.Thesaurus;
import com.gdufs.vietnameselearning.mapper.ThesaurusMapper;
import com.gdufs.vietnameselearning.services.Impl.ThesaurusServiceImpl;
import com.gdufs.vietnameselearning.services.ThesaurusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class ThesaurusController {
    @Autowired
    private ThesaurusServiceImpl thesaurusService;

    @ResponseBody
    @RequestMapping("/thesaurus")
    public List<Thesaurus> getThesaurus(){
        return thesaurusService.list();
    }



}
