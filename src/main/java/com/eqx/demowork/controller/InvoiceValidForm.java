package com.eqx.demowork.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author duan
 * @Description: 发票校验
 * @Date: Created in 下午3:44 2018/5/28
 */
@Data
@ApiModel(value = "发票校验")
public class InvoiceValidForm {

    @ApiModelProperty(value = "发票类型: 1-普票，2-专票", example = "1")
    private String type;

    @ApiModelProperty(value = "订单Id及订单地区")
    private List<OrderForm> orders;
}
