package cn.vpclub.services;

import cn.vpclub.common.ServerResponse;
import cn.vpclub.model.UserModel;
import cn.vpclub.storage.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;


    public ServerResponse<UserModel> login(String username, String password) {

        int resultCount =userMapper.checkUsername(username);
        //System.out.println(resultCount);
        if(resultCount==0)
            return ServerResponse.createByErrorMessage("用户名不存在");
        UserModel user=userMapper.selectLogin(username,password);
        if(user==null)
            return ServerResponse.createByErrorMessage("密码错误");
        return ServerResponse.createBySuccess("登录成功",user);

    }
}
