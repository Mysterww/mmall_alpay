package cn.vpclub.controller;

import cn.vpclub.model.ProductModel;
import cn.vpclub.services.ProductServiceImp;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    @RequestMapping("/getProductDetail")
    public PageInfo<ProductModel> getProductDetail(int pageNum, int pageSize) {
        return productServiceImp.getProductDetail(pageNum, pageSize);
    }

    @RequestMapping("/findParentPath")
    public String findParentPath(Integer id) {
        return productServiceImp.findParentPath(id);
    }

    @RequestMapping("/searchAllProduct")
    public List<ProductModel> searchAllProduct(Integer id)
    {
        return productServiceImp.searchAllProduct(id);
    }
}
