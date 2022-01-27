package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * t_thesaurus
 * @author 
 */
@Data
@TableName("t_thesaurus")
public class Thesaurus implements Serializable {
    private Integer id;

    /**
     * 词库类型
     */
    private String type;

    /**
     * 总词数
     */
    private Integer count;

    private static final long serialVersionUID = 1L;
}