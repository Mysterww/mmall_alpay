package cn.vpclub.model;

import lombok.Data;

@Data
public class ShippingModel {
    private Integer id;
    private Integer userId;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
}
