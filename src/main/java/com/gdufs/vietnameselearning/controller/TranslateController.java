package com.gdufs.vietnameselearning.controller;

import com.gdufs.vietnameselearning.entity.Translate;
import com.gdufs.vietnameselearning.services.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranslateController {
    @Autowired
    private TranslateService translateService;

    @RequestMapping("/translate")
    public List<Translate> getTranslate(){
        return translateService.list();
    }


}
