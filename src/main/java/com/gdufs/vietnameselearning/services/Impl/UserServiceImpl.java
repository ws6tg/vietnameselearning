package com.gdufs.vietnameselearning.services.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.mapper.UserMapper;
import com.gdufs.vietnameselearning.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
