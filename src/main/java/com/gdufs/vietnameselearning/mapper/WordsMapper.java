package com.gdufs.vietnameselearning.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdufs.vietnameselearning.entity.Words;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;



public interface WordsMapper extends BaseMapper<Words> {

    public List<Words> getWordsAndSentencesByThesaurusId(int id);

}