package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * t_experience
 * @author 
 */
@Data
@TableName("t_experience")
public class Experience implements Serializable {
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 获取经验途径（1签到 2背单词）
     */
    private Integer type;

    /**
     * 日期
     */
    private Date datetime;

    /**
     * 经验值
     */
    private Integer experience;

    private static final long serialVersionUID = 1L;

    public Experience(Integer userId, int i, Date date, int experience) {
        this.datetime=date;
        this.userId=userId;
        this.experience=experience;
        this.type=i;
    }
}