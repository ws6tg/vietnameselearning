package com.gdufs.vietnameselearning.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

/**
 * t_user
 * @author 
 */
@Data
@ToString
@TableName("t_user")
public class User implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 昵称
     */
    private String username;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 密码
     */
    @JsonIgnore
    private String password;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像
     */
    private String head;

    /**
     * 经验
     */
    private Integer experience;

    /**
     * 总学习时间
     */
    private Integer totaltime;

    /**
     * 总打卡天数
     */
    private Integer datecount;

    /**
     * 当前学习词库id
     */
    private Integer thesaurusId;

    private static final long serialVersionUID = 1L;
}