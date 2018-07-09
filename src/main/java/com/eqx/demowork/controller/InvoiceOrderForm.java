package com.eqx.demowork.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author duan
 * @Description: 开具发票 form
 * @Date: Created in 下午2:27 2018/5/23
 */
@ApiModel(value = "开具发票 form")
public class InvoiceOrderForm {

    @ApiModelProperty(value = "开具发票的类型-1:增值税纸质普票;2:增值税纸质普票;4:增值税电子普票", example = "1")
    private Integer invoiceType;

    @ApiModelProperty(value = "发票的用户类型: 0-个人；1-公司", example = "0")
    private Integer personal;

    @ApiModelProperty(value = "发票详情的Id", example = "123")
    private Long id;

    @ApiModelProperty(value = "订单")
    private List<Order> orders;

    @ApiModel(value = "订单")
    public class Order {
        @ApiModelProperty(value = "订单ID", example = "1")
        private Long orderId;

        @ApiModelProperty(value = "订单类型就：区分成都还是北京。1：北京。2：成都", example = "1")
        private Integer company;

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public Integer getCompany() {
            return company;
        }

        public void setCompany(Integer company) {
            this.company = company;
        }
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Integer getPersonal() {
        return personal;
    }

    public void setPersonal(Integer personal) {
        this.personal = personal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}


