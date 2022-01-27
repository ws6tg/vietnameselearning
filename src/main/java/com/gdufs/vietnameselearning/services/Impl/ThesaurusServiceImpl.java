package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Thesaurus;
import com.gdufs.vietnameselearning.mapper.ThesaurusMapper;
import com.gdufs.vietnameselearning.services.ThesaurusService;
import org.springframework.stereotype.Service;

@Service
public class ThesaurusServiceImpl extends ServiceImpl<ThesaurusMapper, Thesaurus> implements ThesaurusService {
}
