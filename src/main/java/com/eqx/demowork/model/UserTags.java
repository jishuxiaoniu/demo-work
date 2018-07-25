package com.eqx.demowork.model;

import lombok.Data;

import java.util.Date;

/**
 * @description 用户标签Entity
 * @author duan
 * @date 2017年6月22日
 */
@Data
public class UserTags {
	
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
