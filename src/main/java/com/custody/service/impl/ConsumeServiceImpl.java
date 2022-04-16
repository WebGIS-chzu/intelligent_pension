package com.custody.service.impl;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.ConsumeAbnormalTypeNumber;
import com.custody.entity.ConsumeTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.mapper.ConsumeMapper;
import com.custody.service.ConsumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumeServiceImpl implements ConsumeService {

    @Autowired
    private ConsumeMapper consumeMapper;
    @Override
    public List<CustodyAbnormalTypeNumber> getConsumeAbnormalTyoeNumber() {
        return consumeMapper.getConsumeAbnormalTyoeNumber();
    }

    @Override
    public List<ConsumeTypeInformation> getAbnormalUserInformationByType(String abnormalType) {
        return consumeMapper.getAbnormalUserInformationByType(abnormalType);
    }

    @Override
    public List<ConsumeTypeInformation> getUserWpgInformation() {
        return consumeMapper.getUserWpgInformation();
    }

    @Override
    public List<ConsumeAbnormalTypeNumber> getAbnormalTypeNumberGroupByDate() {
        return consumeMapper.getAbnormalTypeNumberGroupByDate();
    }

    @Override
    public List<CustodyAbnormalTypeNumber> getSolveStateNumber() {
        return consumeMapper.getSolveStateNumber();
    }

    @Override
    public List<ConsumeTypeInformation> getWpgRecord() {
        return consumeMapper.getWpgRecord();
    }
}
