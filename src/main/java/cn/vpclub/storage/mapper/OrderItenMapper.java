package cn.vpclub.storage.mapper;

import cn.vpclub.model.OrderItemModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItemModel record);

    int insertSelective(OrderItemModel record);

    OrderItemModel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItemModel record);

    int updateByPrimaryKey(OrderItemModel record);

    //根据用户的Id和订单号获取订单详情
    List<OrderItemModel> getByOrderNoUserId(@Param("orderNo") Long orderNo, @Param("userId") Integer userId);

    //根据用户的Id和订单号获取订单详情(管理员查询)
    List<OrderItemModel> getAllByOrderNo(Long orderNo);

    //批量插入订单中的商品信息
    void batchInsert(List<OrderItemModel> orderItemList);
}
