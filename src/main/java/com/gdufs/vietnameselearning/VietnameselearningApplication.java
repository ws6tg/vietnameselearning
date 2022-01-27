package com.gdufs.vietnameselearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.gdufs.vietnameselearning.mapper")
public class VietnameselearningApplication {

    public static void main(String[] args) {
        SpringApplication.run(VietnameselearningApplication.class, args);
    }

}
