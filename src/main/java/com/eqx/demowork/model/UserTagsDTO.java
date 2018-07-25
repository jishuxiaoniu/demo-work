package com.eqx.demowork.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 上午11:40 2018/7/18
 */
@Data
public class UserTagsDTO implements Serializable{

    private Long id;

    /**
     * 样式名称
     */

    private String typeName;

    /**
     * 偏好标签
     */

    private String preferenceTag;

    /**
     * 状态（0：停用，1：开启）
     */

    private int status;

    /**
     * 排序
     */

    private int sort;

    /**
     * 创建者
     */

    private String createUser;

    /**
     * 创建时间
     */

    private Date createTime;


    /**
     * 标签来源
     */

    private int tagSource;
}
