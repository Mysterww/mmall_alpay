package cn.vpclub.storage.mapper;

import cn.vpclub.model.ProductModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ProductMapper {
    public int deleteByPrimaryKey(Integer id);

    public int insert(ProductModel record);

    public int insertSelective(ProductModel record);

    public ProductModel selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(ProductModel record);

    public int updateByPrimaryKey(ProductModel record);

    public List<ProductModel> selectList();

    public List<ProductModel> selectByNameAndProductId(String productName, Integer id);

    public List<ProductModel> selectByNameAndCategoryIds(String name, List<Integer> categoryIds);

    public List<ProductModel> selectByCategoryId(List<Integer> lsts);
}
