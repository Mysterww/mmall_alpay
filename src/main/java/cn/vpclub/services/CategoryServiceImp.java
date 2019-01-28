package cn.vpclub.services;

import cn.vpclub.model.CateGoryModel;
import cn.vpclub.storage.mapper.CategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImp implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    private List<CateGoryModel> getChildList(Integer id, List<CateGoryModel> menuList) {
        List<CateGoryModel> childList = new ArrayList<>();
        for (CateGoryModel menu : menuList)
            if (menu.getPid() == id)
                childList.add(menu);

        //递归增加子菜单
        for (CateGoryModel m : childList)
            m.setChilds(getChildList(m.getId(), menuList));
        if (childList.size() == 0) return null;

        return childList;

    }

    public CateGoryModel listCategoryByid2(Integer id) {
        return categoryMapper.listCategoryByid2(id);
    }

    public List<CateGoryModel> listCategory() {
        return categoryMapper.listCategory();
    }

    public CateGoryModel listCategoryByid(Integer id) {
        return categoryMapper.listCategoryByid(id);
    }

    public List<CateGoryModel> listCategoryBypid(Integer pid) {
        return categoryMapper.listCategoryBypid(pid);
    }

    public CateGoryModel hierarchicalAccessMenu(Integer id) {
        //获取数据库中的所有菜单
        List<CateGoryModel> menuList = categoryMapper.listCategory();
        //找到parent_id==pid的所有顶级菜单
       /* List<CateGoryModel> mList = new ArrayList<>();
        for (int i = 0; i < menuList.size(); i++) {
            if (menuList.get(i).getPid() == categoryMapper.listCategoryByid(id).getPid())
                mList.add(menuList.get(i));
        }*/
        //取得所有子菜单
        CateGoryModel pmenu = categoryMapper.listCategoryByid(id);
        pmenu.setChilds(getChildList(id, menuList));

        return pmenu;

    }

    public List<CateGoryModel> getAllCategory(Integer pid) {
        return categoryMapper.getAllCategory(pid);
    }

    public String getParentCategoryInfo(Integer id) {
        if (categoryMapper.listCategoryByid2(id).getPid() != 0)
            return getParentCategoryInfo(categoryMapper.listCategoryByid2(id).getPid()) + categoryMapper.listCategoryByid2(id).getName() + ":";
        else return "";


    }

    public List<Integer> fingAllChildsId(Integer id,List<Integer> lsts)//查询某一节点下的叶子节点（即商品）
    {
        List<CateGoryModel> cateGoryModel=hierarchicalAccessMenu(id).getChilds();
        if(cateGoryModel==null) {
            lsts.add(id);
            return lsts;
        }
        for(CateGoryModel c:cateGoryModel)
            fingAllChildsId(c.getId(),lsts);
        return lsts;

    }



}
