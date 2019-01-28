package cn.vpclub.services;

import cn.vpclub.common.ServerResponse;
import cn.vpclub.model.UserModel;

public interface UserService {
    //登录
    public ServerResponse<UserModel> login(String username,String password);
}
