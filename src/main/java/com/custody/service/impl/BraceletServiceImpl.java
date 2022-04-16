package com.custody.service.impl;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersAbnormalInformation;
import com.custody.entity.UsersInformation;
import com.custody.mapper.BraceletMapper;
import com.custody.service.BraceletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BraceletServiceImpl implements BraceletService {
    @Autowired
    private BraceletMapper braceletMapper;

    @Override
    public List<AbnormalTypeInformation> getAbnormalUserByAbnormal(String abnormalName) {
        return braceletMapper.getAbnormalUserByAbnormal(abnormalName);
    }

    @Override
    public List<UsersAbnormalInformation> getUsersInformation() {
        return braceletMapper.getUsersInformation();
    }

    @Override
    public List<UsersInformation> getUserInformationByUserId(Integer userid) {
        return braceletMapper.getUserInformationByUserId(userid);
    }

    @Override
    public List<CustodyAbnormalTypeNumber> getBraceletAbnormalTypeNumber() {
        return braceletMapper.getBraceletAbnormalTypeNumber();
    }
}
