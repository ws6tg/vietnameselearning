package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Newsweb;
import com.gdufs.vietnameselearning.mapper.NewswebMapper;
import com.gdufs.vietnameselearning.services.NewswebService;
import org.springframework.stereotype.Service;

@Service
public class NewswebServiceImpl extends ServiceImpl<NewswebMapper,Newsweb> implements NewswebService {
}
