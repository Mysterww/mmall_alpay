package cn.vpclub.model;

import lombok.Data;

@Data
public class OrderModel {
    private Integer id;
    private Integer orderNo;
    private Integer userId;
    private Integer shippingId;
    private Integer payment;
}
