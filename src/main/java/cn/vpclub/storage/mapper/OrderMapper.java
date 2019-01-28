package cn.vpclub.storage.mapper;

import cn.vpclub.model.OrderModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderModel record);

    int insertSelective(OrderModel record);

    OrderModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderModel record);

    int updateByPrimaryKey(OrderModel record);

    //根据订单号和用户的Id来查询订单
    OrderModel selectByUserIdAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    //根据订单号来查询订单是否存在
    OrderModel selectByOrderNo(Long orderNo);

    //根据用户Id来查询订单列表(一个用户可能有多个订单)
    List<OrderModel> getOrderListByUserId(Integer userId);

    //管理员查看订单列表实现
    List<OrderModel> selectAllOrder();
}
