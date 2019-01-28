package cn.vpclub.services;

import cn.vpclub.model.CateGoryModel;
import cn.vpclub.model.ProductModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProductService {
    //查询产品信息
    public PageInfo<ProductModel> getProductDetail(int pageNum,int pageSize);
    //修改或更新产品信息
    public String saveOrUpdateProduct(ProductModel product);
    //由产品id输出产品所在的所有父级分类信息
    public String findParentPath(Integer id);
    public List<ProductModel> searchAllProduct(Integer id);//输入该类别下的所有产品
}
