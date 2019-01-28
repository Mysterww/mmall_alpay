package cn.vpclub.storage.mapper;

import cn.vpclub.model.ShippingModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShippingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShippingModel record);

    int insertSelective(ShippingModel record);

    ShippingModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShippingModel record);

    int updateByPrimaryKey(ShippingModel record);

    //同时根据用户Id和地址Id来删除地址，防止横向越权
    int deleteByShippingIdByUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippingId);

    //修改地址接口

    //查询收货地址接口
    ShippingModel selectByShippingIdByUserId(@Param("userId") Integer userId, @Param("shippingId") Integer shippongId);

    //查询所有收获地址接口
    List<ShippingModel> selectByUserId(Integer userId);
}
