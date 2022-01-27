package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Translate;
import com.gdufs.vietnameselearning.mapper.TranslateMapper;
import com.gdufs.vietnameselearning.services.TranslateService;
import org.springframework.stereotype.Service;

@Service
public class TranslateServiceImpl extends ServiceImpl<TranslateMapper, Translate> implements TranslateService {
}
