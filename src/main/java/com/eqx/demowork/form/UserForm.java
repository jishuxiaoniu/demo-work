package com.eqx.demowork.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:10 2018/4/11
 */
@ApiModel(value = "user form", description = "用户对应的form")
@Data
public class UserForm {

    @ApiModelProperty(value = "用户姓名", required = true, example = "张三")
    private String name;
    @ApiModelProperty(value = "年龄", example = "12")
    private int age;
    @ApiModelProperty(value = "地址", example = "北京市上地西里")
    private String address;
}
