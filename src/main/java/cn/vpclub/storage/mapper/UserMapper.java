package cn.vpclub.storage.mapper;

import cn.vpclub.model.UserModel;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public int deleteByPrimaryKey(Integer id);
    public int insert(UserModel record);
    public UserModel selectByPrimaryKey(Integer id);;
    public int updateByPrimaryKeySelective(UserModel record);
    public int updateByPrimaryKey(UserModel record);
    public UserModel selectLogin (@Param("username") String username,@Param("password") String password);
    public int insertSelective(UserModel record);
    public int checkUsername(String username);//查询是否存在该用户

}
