package cn.vpclub.model.vo;

import lombok.Data;

@Data
public class OrderItemVo {
    private Integer orderNo;
    private Integer productId;
    private String productName;
    private Integer quantity;
    private Integer totalPrice;
}
