package cn.vpclub.model.vo;

import lombok.Data;

import java.util.List;
@Data
public class CartVo {
    private Integer cartTotalPrice;
    private List<CartProductVo> cartProductVoList;
}
