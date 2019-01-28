package cn.vpclub.services;

import cn.vpclub.model.CateGoryModel;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface CategoryService {
    public List<CateGoryModel> listCategory();

    public CateGoryModel listCategoryByid(Integer id);

    public CateGoryModel listCategoryByid2(Integer id);

    public List<CateGoryModel> listCategoryBypid(Integer pid);

    public CateGoryModel hierarchicalAccessMenu(Integer id);//层级菜单获取,方法一

    public List<CateGoryModel> getAllCategory(Integer pid);//层级菜单获取,方法二

    public String getParentCategoryInfo(Integer id);//得到子分类的父分类信息

    public List<Integer> fingAllChildsId(Integer id, List<Integer> lsts);

}
