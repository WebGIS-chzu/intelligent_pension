package com.monitor.service.impl;

import com.monitor.entity.UserLocationInfo;
import com.monitor.entity.WpgCost;
import com.monitor.mapper.LifeMapper;
import com.monitor.service.LifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LifeServiceImpl implements LifeService {

    @Autowired
    private LifeMapper lifeMapper;

    @Override
    public List<WpgCost> getAllWpgCost() {
        return lifeMapper.getAllWpgCost();
    }

    @Override
    public List<UserLocationInfo> getUserLocationInfo() {
        return lifeMapper.getUserLocationInfo();
    }
}
