package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.lang.Nullable;

/**
 * t_words
 * @author 
 */
@Data
@ToString
@TableName("t_words")
public class Words implements Serializable {
    private Integer id;

    /**
     * 越南语
     */
    private String vnword;

    /**
     * 汉语
     */
    private String cnword;

    /**
     * 音频
     */
    private String audio;

    /**
     * 词性
     */
    private String property;

    /**
     * 中文词性
     */
    private String cnproperty;

    /**
     * 词频
     */
    private Integer frequency;

    /**
     * 难度
     */
    private Integer hard;

    @TableField(exist = false)
    private List<Sentences> sentences;

    /**
     * 所属词库
     */
    private String thesaurus;

    private static final long serialVersionUID = 1L;
}