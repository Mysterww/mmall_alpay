package cn.vpclub.services;

import cn.vpclub.model.ShippingModel;
import cn.vpclub.storage.mapper.ShippingMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImp implements ShippingService {
    @Autowired
    private ShippingMapper shippingMapper;
    //收货地址添加方法
    public int add(ShippingModel shipping)
    {
        return shippingMapper.insertSelective(shipping);

    }

    public int del(Integer shippingId)
    {
       return shippingMapper.deleteByPrimaryKey(shippingId);
    }

    public int update(ShippingModel shipping)
    {
        return shippingMapper.updateByPrimaryKey(shipping);
    }

    public ShippingModel select(Integer shippingId)
    {
        return shippingMapper.selectByPrimaryKey(shippingId);
    }

    public PageInfo list(int userId,int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum,pageSize);
        List<ShippingModel> shippingMapperList=shippingMapper.selectByUserId(userId);
        PageInfo pageInfo=new PageInfo(shippingMapperList);
        return  pageInfo;
    }
}
