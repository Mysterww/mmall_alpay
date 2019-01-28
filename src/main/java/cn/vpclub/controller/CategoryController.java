package cn.vpclub.controller;

import cn.vpclub.model.CateGoryModel;
import cn.vpclub.services.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cateGory")
public class CategoryController {
    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @RequestMapping("/listCategoryByid2")
    public CateGoryModel listCategoryByid2(Integer id) {
        return categoryServiceImp.listCategoryByid2(id);
    }

    @RequestMapping("/hierarchicalAccessMenu")
    public CateGoryModel hierarchicalAccessMenu(Integer id) {
        return categoryServiceImp.hierarchicalAccessMenu(id);
    }

    @RequestMapping("/listCategory")
    public List<CateGoryModel> listCategory() {
        return categoryServiceImp.listCategory();
    }

    @RequestMapping("/getAllCategory")
    public List<CateGoryModel> getAllCategory(Integer pid) {
        return categoryServiceImp.getAllCategory(pid);
    }

    @RequestMapping("/getParentCategoryInfo")
    public String getParentCategoryInfo(Integer id) {
        return categoryServiceImp.getParentCategoryInfo(id);
    }


}
