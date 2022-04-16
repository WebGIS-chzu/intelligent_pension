package com.social.service.impl;

import com.social.entity.*;
import com.social.mapper.ChainMapper;
import com.social.service.ChainService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChainServiceImpl implements ChainService {
    @Autowired
    private ChainMapper chainMapper;
    @Override
    public List<ChainTypeNumber> getElderlyLocation() {
        return chainMapper.getElderlyLocation();
    }

    @Override
    public List<ChainUserInfor> getUserInformationByUserId(String userid) {
        return chainMapper.getUserInformationByUserId(userid);
    }

    @Override
    public List<ChainNodeList> getChainNodeListByCondition(String userid, String name) {
        return chainMapper.getChainNodeListByCondition(userid,name);
    }

    @Override
    public List<ChainLinkList> getChainLinkListByCondition(String userid, String name) {
        return chainMapper.getChainLinkListByCondition(userid,name);
    }

    @Override
    public String getUserId(String name) {
        return chainMapper.getUserId(name);
    }

    @Override
    public ChainTypeNumber getElderlyLocationById(String userid) {
        return chainMapper.getElderlyLocationById(userid);
    }

}
