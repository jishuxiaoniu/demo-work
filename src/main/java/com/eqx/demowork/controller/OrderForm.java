package com.eqx.demowork.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单")
public class OrderForm {
    @ApiModelProperty(value = "订单ID", example = "1")
    private Long orderId;

    @ApiModelProperty(value = "订单类型就：区分成都还是北京。1：北京。2：成都", example = "1")
    private Integer company;
}