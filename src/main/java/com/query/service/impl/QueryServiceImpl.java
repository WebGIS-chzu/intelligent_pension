package com.query.service.impl;

import com.query.entity.*;
import com.query.mapper.QueryMapper;
import com.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryMapper queryMapper;

    @Override
    public List<QueryTypeNumber> queryNursingWorkerByCondition(String name, String nursingId, Integer orderNumberMin, Integer orderNumberMax, Integer evaluateMin, Integer evaluateMax) {
        return queryMapper.queryNursingWorkerByCondition(name,nursingId,orderNumberMin,orderNumberMax,evaluateMin,evaluateMax);
    }

    @Override
    public List<NursingWorkerInformation> getNursingWorkerInformationByNursingId(String nursingId) {
        return queryMapper.getNursingWorkerInformationByNursingId(nursingId);
    }

    @Override
    public List<OrderInformation> getOrderInformationByNursingId(String nursingId) {
        return queryMapper.getOrderInformationByNursingId(nursingId);
    }

    @Override
    public List<ElderlyQueryAddress> getElderlyAddress() {
        return queryMapper.getElderlyAddress();
    }

    @Override
    public List<QueryTypeNumber> queryElderlyByCondition(String name, String idCardNumber, String community, String building, String houseNumber, Double heartRateMin, Double heartRateMax, Double bloodPressureMin, Double bloodPressureMax) {
        return queryMapper.queryElderlyByCondition(name,idCardNumber,community,building,houseNumber,heartRateMin,heartRateMax,bloodPressureMin,bloodPressureMax);
    }

    @Override
    public List<ElderlyInformation> getElderlyInformationByUserid(String userid) {
        return queryMapper.getElderlyInformationByUserid(userid);
    }

    @Override
    public List<ElderlyBraceletInformation> getWpgCostList(String userid) {
        return queryMapper.getWpgCostList(userid);
    }
}
