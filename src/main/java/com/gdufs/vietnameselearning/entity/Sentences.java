package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * t_sentences
 * @author 
 */
@Data
@TableName("t_sentences")
public class Sentences implements Serializable {
    private Integer id;

    /**
     * 越南语例句
     */
    private String vnsentence;

    /**
     * 汉语翻译
     */
    private String cnsentence;

    /**
     * 出处
     */
    private String origin;

    private static final long serialVersionUID = 1L;
}