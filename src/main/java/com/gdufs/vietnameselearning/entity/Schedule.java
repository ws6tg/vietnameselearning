package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;

/**
 * t_schedule
 * @author 
 */
@Data
@TableName("t_schedule")
public class Schedule implements Serializable {

    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 词库id
     */
    private Integer thesaurusId;

    /**
     * 计划天数
     */
    private Integer plandays;

    /**
     * 当前学习天数
     */
    private Integer nowlearning;

    /**
     * 每天学习词数
     */
    private Integer daylearncount;

    /**
     * 开始日期
     */
    private Date startdate;

    private static final long serialVersionUID = 1L;
}