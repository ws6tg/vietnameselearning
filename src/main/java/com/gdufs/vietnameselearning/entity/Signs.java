package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * t_signs
 * @author 
 */
@Data
@TableName("t_signs")
@AllArgsConstructor
public class Signs implements Serializable {
    /**
     * 用户id
     */
    @TableId
    private Integer userId;

    /**
     * 打卡日期
     */
    private Date date;

    /**
     * 连续打卡天数
     */
    private Integer continuousdays;

    private static final long serialVersionUID = 1L;
}