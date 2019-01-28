package cn.vpclub.services;

import cn.vpclub.model.CateGoryModel;
import cn.vpclub.model.ProductModel;
import cn.vpclub.services.CategoryServiceImp;
import cn.vpclub.services.ProductService;
import cn.vpclub.storage.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImp implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    public PageInfo<ProductModel> getProductDetail(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductModel> lists = productMapper.selectList();
        PageInfo<ProductModel> pageInfo = new PageInfo<>(lists);
        return pageInfo;
    }

    public String saveOrUpdateProduct(ProductModel product) {
        if (product != null) {
            if (product.getId() != null) {
                //表示更新产品
                //动态更新
                int rowCount = productMapper.updateByPrimaryKeySelective(product);
                if (rowCount > 0) return "修改商品信息成功";
                else return "修改商品信息失败";
            }
        } else //表示增加新的商品
        {
            int rowCount = productMapper.insertSelective(product);
            if (rowCount > 0) return "插入商品成功";
            else return "增加商品成功";

        }
        return "参数不正确";
    }

    public String findParentPath(Integer id) {
        return categoryServiceImp.getParentCategoryInfo(id) + productMapper.selectByPrimaryKey(id).getName();
    }

    public List<ProductModel> searchAllProduct(Integer id)
    {
        List<Integer> liss=new ArrayList<>();

        List<Integer> lists=categoryServiceImp.fingAllChildsId(id,liss);
        System.out.println(lists);
        return productMapper.selectByCategoryId(lists);
    }
}
