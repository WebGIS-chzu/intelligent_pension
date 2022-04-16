package com.user.service.impl;

import com.user.entity.Perms;
import com.user.entity.User;
import com.user.mapper.UserMapper;
import com.user.service.UserService;
import com.common.SortUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        //明文密码MD5+salt+hash散列
        String salt = SortUtil.getSalt();
        user.setSalt(salt);
        SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();// 获取当前时间
        user.setCreate_time(sdf.format(date));
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
//        String password = new SimpleHash("md5",user.getPassword(),salt,1024).toString();
        user.setPassword(md5Hash.toString());
//        user.setPassword(password);
        userMapper.save(user);
    }

    @Override
    public User findByUserName(String username) {
        return userMapper.findByUserName(username);
    }

    @Override
    public User findRolesByUserName(String username) {
        return userMapper.findRolesByUserName(username);
    }

    @Override
    public List<Perms> findPermsByRoleId(String id) {
        return userMapper.findPermsByRoleId(id);
    }
}
