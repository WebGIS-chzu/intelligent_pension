package com.monitor.service.impl;


import com.monitor.entity.DateTypeNumber;
import com.monitor.entity.ServiceDataTypeNumber;
import com.monitor.entity.TypeNumber;
import com.monitor.mapper.DatapanelMapper;
import com.monitor.service.DatapanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatapanelServiceImpl implements DatapanelService {
    @Autowired
    DatapanelMapper datapanelMapper;
    @Override
    public List<TypeNumber> getUserInformationState() {
        return datapanelMapper.getUserInformationState();
    }

    @Override
    public List<TypeNumber> getServiceStructure() {
        return datapanelMapper.getServiceStructure();
    }

    @Override
    public List<TypeNumber> getTreatmentValues() {
        return datapanelMapper.getTreatmentValues();
    }

    @Override
    public List<ServiceDataTypeNumber> getNursingWorkersEvaluate() {
        return datapanelMapper.getNursingWorkersEvaluate();
    }

    @Override
    public List<TypeNumber> getAbnormalHealth() {
        return datapanelMapper.getAbnormalHealth();
    }

    @Override
    public List<TypeNumber> getAgeGroup() {
        return datapanelMapper.getAgeGroup();
    }
}
