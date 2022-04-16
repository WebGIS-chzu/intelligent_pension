package com.user.mapper;

import com.user.entity.Perms;
import com.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    void save(User user);

    User findByUserName(@Param("username") String username);

    //根据用户名查询所有角色
    User findRolesByUserName(@Param("username") String username);

    //根据角色id查询权限信集合
    List<Perms> findPermsByRoleId(@Param("id") String id);
}
