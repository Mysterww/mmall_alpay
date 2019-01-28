package cn.vpclub.services;

import cn.vpclub.model.ShippingModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ShippingService {
    //收货地址添加方法
    int add(ShippingModel shipping);

    //删除收货地址方法
    int del(Integer shippingId);

    //修改地址接口
    int update(ShippingModel shipping);

    //查询收货地址的方法
    ShippingModel select(Integer shippingId);

    //查询所有收货地址的方法
    PageInfo list(int userId,int pageNum, int pageSize);
}
