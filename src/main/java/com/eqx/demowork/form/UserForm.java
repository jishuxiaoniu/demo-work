package com.eqx.demowork.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

/**
 * @Author duan
 * @Description:
 * @Date: Created in 下午3:10 2018/4/11
 */
@ApiModel(value = "user form", description = "用户对应的form")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserForm {

    @NotBlank(message = "姓名不能为空")
    @ApiModelProperty(value = "用户姓名", example = "张三")
    private String name;

    @Max(value = 100L, message = "年龄不能大于100岁")
    @Min(value = 0, message = "年龄不能小于0岁")
    @ApiModelProperty(value = "年龄", example = "12")
    private int age;

    @Size(min = 0, max = 50, message = "字符长度范围0~50")
    @ApiModelProperty(value = "地址", example = "北京市上地西里")
    private String address;

    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "email", example = "123445544@qq.com")
    private String email;
}
