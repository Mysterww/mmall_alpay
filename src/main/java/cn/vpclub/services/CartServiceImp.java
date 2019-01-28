package cn.vpclub.services;

import cn.vpclub.model.CartModel;
import cn.vpclub.model.ProductModel;
import cn.vpclub.model.vo.CartProductVo;
import cn.vpclub.model.vo.CartVo;
import cn.vpclub.services.CartService;
import cn.vpclub.storage.mapper.CartMapper;
import cn.vpclub.storage.mapper.ProductMapper;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;

    //封装返回到前台的购物车模块,仅供当前模块使用
    private CartVo getCartVoLimit(Integer userId) {
        CartVo cartVo = new CartVo();
        //找到该用户的所有购物车
        List<CartModel> cartList = cartMapper.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = new ArrayList<>();
        Integer cartTotalPrice = 0;//购物车总价
        if (cartList != null)
            for (CartModel c : cartList) {
                CartProductVo cartProductVo = new CartProductVo();
                cartProductVo.setId(c.getId());
                cartProductVo.setUserId(userId);
                cartProductVo.setProductId(c.getProductId());
                ProductModel product = productMapper.selectByPrimaryKey(c.getProductId());
                if (product != null) {
                    cartProductVo.setProductName(product.getName());
                    int quantity = 0;
                    cartProductVo.setQuantity(c.getQuantity());//获得该产品的数量
                    //计算该类产品的总价格
                    cartProductVo.setTotalPrice(product.getPrice() * cartProductVo.getQuantity());
                }
                cartProductVoList.add(cartProductVo);
                cartTotalPrice += cartProductVo.getTotalPrice();
            }
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setCartTotalPrice(cartTotalPrice);
        return cartVo;


    }

    //查询购物车中的商品
    public CartVo list(Integer userId) {
        return this.getCartVoLimit(userId);
    }

    //获取用户购物车中的商品数量
    public Integer getCartProductCount(Integer userId) {
        if (userId == null)
            return 0;
        return cartMapper.selectProductCountByUserId(userId);

    }

    //添加商品到购物车,返回该用户增加商品后的发回信息
    public CartVo add(Integer userId, Integer productId, Integer count) {
        CartModel cartModel = cartMapper.selectCatByUserIdProductId(userId, productId);
        if (cartModel == null)//说明该用户购物车里没有该产品
        {
            CartModel citem = new CartModel();
            citem.setUserId(userId);
            citem.setProductId(productId);
            citem.setQuantity(count);
            cartMapper.insert(citem);
        } else//已有该产品，直接更改数量即可
        {
            count += cartModel.getQuantity();
            cartModel.setQuantity(count);
            cartMapper.updateByPrimaryKeySelective(cartModel);
        }
        return this.list(userId);
    }

    //更新商品
    public CartVo update(Integer userId, Integer productId, Integer count) {
        CartModel cartModel = cartMapper.selectCatByUserIdProductId(userId, productId);
        cartModel.setQuantity(count);
        cartMapper.updateByPrimaryKeySelective(cartModel);
        return this.list(userId);
    }

    //删除购物车中的商品
    public CartVo deleteProduct(Integer userId, List<Integer> productIds) {
        cartMapper.deleteByUserIdProductIds(userId, productIds);
        return this.list(userId);
    }


}
