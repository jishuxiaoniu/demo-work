package com.eqx.demowork.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午6:11 2018/4/4
 */
@Getter
@Setter
@ToString
public class Order implements Serializable {

    private int id;

    private String title;

    private Integer userId;

}
