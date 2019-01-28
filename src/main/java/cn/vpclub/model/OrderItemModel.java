package cn.vpclub.model;

import lombok.Data;

@Data
public class OrderItemModel {
    private Integer id;
    private Integer userId;
    private String orderNo;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Integer totalPrice;
}
