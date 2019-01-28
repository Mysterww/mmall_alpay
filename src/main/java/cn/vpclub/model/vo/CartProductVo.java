package cn.vpclub.model.vo;

import lombok.Data;

@Data
public class CartProductVo {
    private Integer id;
    private Integer userId;
    private Integer productId;
    private Integer quantity;
    private String productName;
    private Integer totalPrice;
}
