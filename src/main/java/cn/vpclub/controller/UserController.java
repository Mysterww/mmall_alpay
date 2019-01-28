package cn.vpclub.controller;

import cn.vpclub.common.ServerResponse;
import cn.vpclub.model.UserModel;
import cn.vpclub.services.UserService;
import cn.vpclub.storage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    //登录
    @RequestMapping("/login.do")
    public ServerResponse<UserModel> login(String username, String password, HttpSession session)
    {
        ServerResponse<UserModel> response=userService.login(username,password);
        if(response.isSuccess())
        {
            session.setAttribute(username,response.getData());
        }
        return response;
    }
    @RequestMapping("/ss")
    public UserModel selectLogin(String username,String password)
    {
        return userMapper.selectLogin(username,password);
    }



}
