package com.user.service.impl;

import com.user.entity.Bracelet;
import com.user.entity.UserInfo;
import com.user.mapper.UserInfoMapper;
import com.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public Boolean updateInfoByUserId(UserInfo userInfo) {
        return userInfoMapper.updateInfoByUserId(userInfo);
    }

    @Override
    public Integer getUserIdByUserName(String username) {
        return userInfoMapper.getUserIdByUserName(username);
    }

    @Override
    public Boolean UpdataHeadpByUserId(Integer userid, String headSculptureUrl,String realFileName) {
        return userInfoMapper.UpdataHeadpByUserId(userid,headSculptureUrl,realFileName);
    }

    @Override
    public String selectFilenameByUserName(String username) {
        return userInfoMapper.selectFilenameByUserName(username);
    }

    @Override
    public UserInfo getInfoByUserName(String username) {
        return userInfoMapper.getInfoByUserName(username);
    }

    @Override
    public String getHeadCupptureByUserName(String username) {
        return userInfoMapper.getHeadCupptureByUserName(username);
    }

    @Override
    public Bracelet getUserBraceletInfoByUserName(String username) {
        return userInfoMapper.getUserBraceletInfoByUserName(username);
    }
}
