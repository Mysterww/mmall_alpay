package cn.vpclub.storage.mapper;

import cn.vpclub.model.CartModel;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface CartMapper {
    public int deleteByPrimaryKey(Integer id);

    public int insert(CartModel record);

    public int insertSelective(CartModel record);

    public CartModel selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(CartModel record);

    public int updateByPrimaryKey(CartModel record);

    public CartModel selectCatByUserIdProductId(Integer userId, Integer productId);

    public List<CartModel> selectCartByUserId(Integer userId);

    public int deleteByUserIdProductIds(Integer userId,List<Integer> productIdList);

    public int selectProductCountByUserId(Integer userId);


}
