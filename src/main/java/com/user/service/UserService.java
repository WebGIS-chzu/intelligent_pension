package com.user.service;

import com.user.entity.Perms;
import com.user.entity.User;

import java.util.List;

public interface UserService {
    //注册用户
    void register(User user);

    //根据用户名查询用户信息
    User findByUserName(String username);
    //根据用户名查询所有角色
    User findRolesByUserName(String username);
    //根据角色id查询权限集合
    List<Perms> findPermsByRoleId(String id);
}
