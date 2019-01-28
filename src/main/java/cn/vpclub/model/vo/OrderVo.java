package cn.vpclub.model.vo;

import cn.vpclub.model.ShippingModel;
import lombok.Data;

import java.util.List;
@Data
public class OrderVo {
    private Integer orderNo;
    private Integer payment;
    private List<OrderItemVo> orderItemVoList;
    private ShippingModel shippingModel;

}
