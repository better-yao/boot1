package com.yao.boot1.mapper;

import com.yao.boot1.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Integer findUser(User user);
}
