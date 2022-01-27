package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Words;
import com.gdufs.vietnameselearning.mapper.WordsMapper;
import com.gdufs.vietnameselearning.services.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsServiceImpl extends ServiceImpl<WordsMapper, Words> implements WordsService {

    @Autowired
    private WordsMapper wordsMapper;

    public List<Words> getWordsByThId(int id){
        return wordsMapper.getWordsAndSentencesByThesaurusId(id);
    }


}
