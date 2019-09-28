package com.yao.boot1.service;

import com.yao.boot1.entity.User;

public interface UserService {
    public Integer findUser(String username,String password);
}
