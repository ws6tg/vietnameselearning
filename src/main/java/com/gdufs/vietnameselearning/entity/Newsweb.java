package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * t_newsweb
 * @author 
 */
@Data
@TableName("t_newsweb")
public class Newsweb implements Serializable {
    private Integer id;

    /**
     * 网站名
     */
    private String webname;

    /**
     * url
     */
    private String weburl;

    /**
     * 是否有效
     */
    private Integer effective;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}