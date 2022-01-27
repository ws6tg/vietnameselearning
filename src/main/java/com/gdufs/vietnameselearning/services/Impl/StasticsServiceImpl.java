package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Stastics;
import com.gdufs.vietnameselearning.mapper.StasticsMapper;
import com.gdufs.vietnameselearning.services.StasticsService;
import org.springframework.stereotype.Service;

@Service
public class StasticsServiceImpl extends ServiceImpl<StasticsMapper, Stastics> implements StasticsService {
}
