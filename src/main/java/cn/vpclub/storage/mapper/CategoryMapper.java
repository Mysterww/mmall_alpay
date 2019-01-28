package cn.vpclub.storage.mapper;

import cn.vpclub.model.CateGoryModel;
import org.apache.ibatis.annotations.Mapper;

import javax.sql.rowset.CachedRowSet;
import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CategoryMapper {

    public int insertValue(List<CateGoryModel> lists);

    public int updateCategory(CateGoryModel model);

    public int batchDeleteCategory(int[] id);

    public List<CateGoryModel> listCategory();

    public CateGoryModel listCategoryByid(Integer id);

    public List<CateGoryModel> listCategoryBypid(Integer pid);

    public List<CateGoryModel> getAllCategory(Integer pid);

    public CateGoryModel listCategoryByid2(Integer id);

}
