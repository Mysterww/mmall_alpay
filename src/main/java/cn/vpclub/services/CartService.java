package cn.vpclub.services;

import cn.vpclub.model.vo.CartVo;

import java.util.List;

public interface CartService {
    //添加商品到购物车
    public CartVo add(Integer userId, Integer productId, Integer count);

    //更新商品
    public CartVo update(Integer userId, Integer productId, Integer count);

    //删除购物车中的商品
    public CartVo deleteProduct(Integer userId, List<Integer> productIds);

    //查询购物车中的商品
    public CartVo list(Integer userId);

    //获取用户购物车中的商品数量
    public Integer getCartProductCount(Integer userId);
}
