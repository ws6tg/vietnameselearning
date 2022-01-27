package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.Experience;
import com.gdufs.vietnameselearning.mapper.ExperienceMapper;
import com.gdufs.vietnameselearning.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl extends ServiceImpl<ExperienceMapper,Experience> implements ExperienceService {
    @Autowired
    ExperienceMapper experienceMapper;

    public List<Experience> selectListById(Integer userId){
        return experienceMapper.selectList(new QueryWrapper<Experience>().eq("user_id",userId));
    }

}
