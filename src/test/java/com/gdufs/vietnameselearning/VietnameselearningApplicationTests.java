package com.gdufs.vietnameselearning;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdufs.vietnameselearning.entity.Newsweb;
import com.gdufs.vietnameselearning.entity.Sentences;
import com.gdufs.vietnameselearning.entity.User;
import com.gdufs.vietnameselearning.entity.Words;
import com.gdufs.vietnameselearning.mapper.SentenceMapper;
import com.gdufs.vietnameselearning.mapper.UserMapper;
import com.gdufs.vietnameselearning.mapper.WordsMapper;
import com.gdufs.vietnameselearning.services.Impl.WordsServiceImpl;
import com.gdufs.vietnameselearning.services.NewswebService;
import com.gdufs.vietnameselearning.utils.PhoneCodeUtil;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@SpringBootTest
@MapperScan(value = "com.gdufs.vietnameselearning.mapper")
class VietnameselearningApplicationTests {
    @Autowired
    private NewswebService newswebService;

    @Test
    public void getNewsweb(){
         newswebService.list().forEach(System.out::println);
    }


}
