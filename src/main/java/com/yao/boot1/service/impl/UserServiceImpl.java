package com.yao.boot1.service.impl;

import com.yao.boot1.entity.User;
import com.yao.boot1.mapper.UserMapper;
import com.yao.boot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer findUser(String username,String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return userMapper.findUser(user);
    }
}
