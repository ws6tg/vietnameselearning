package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * t_translate
 * @author 
 */
@Data
@TableName("t_translate")
public class Translate implements Serializable {
    private Integer id;

    /**
     * 接口名称
     */
    private String apiname;

    /**
     * 接口
     */
    private String api;

    /**
     * 更新日期
     */
    private Date updatetime;

    private static final long serialVersionUID = 1L;
}