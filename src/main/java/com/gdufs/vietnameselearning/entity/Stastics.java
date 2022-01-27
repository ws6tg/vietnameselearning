package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;
import java.util.Date;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

/**
 * t_stastics
 * @author 
 */
@Data
@TableName("t_stastics")
public class Stastics implements Serializable {

    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 学习词数
     */
    private Integer learncount;

    /**
     * 复习词数
     */
    private Integer reviewcount;

    /**
     * 记忆率
     */
    private Double memoryrate;

    /**
     * 学习时长
     */
    private Integer learntime;

    /**
     * 日期
     */
    private Date date;

    private static final long serialVersionUID = 1L;
}