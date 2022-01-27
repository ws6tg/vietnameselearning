package com.gdufs.vietnameselearning.controller;


import com.gdufs.vietnameselearning.entity.Words;
import com.gdufs.vietnameselearning.mapper.WordsMapper;
import com.gdufs.vietnameselearning.services.Impl.WordsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/getwords")
public class WordsController {
    @Autowired
    private WordsServiceImpl wordsService;

    @RequestMapping("/{thid}")
    @ResponseBody
    public List<Words> getWordsByThid(@PathVariable String thid) throws Exception{
        return wordsService.getWordsByThId(Integer.parseInt(thid));
    }





}
