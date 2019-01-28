package cn.vpclub.model;

import lombok.Data;

@Data
public class CartModel {
    public Integer id;
    public Integer productId;
    public Integer quantity;
    public Integer userId;
}
