package com.service.service.impl;

import com.service.entity.ServiceInformation;
import com.service.entity.ServiceMaxTypeNumber;
import com.service.entity.ServiceTypeNumber;
import com.service.mapper.ServiceMapper;
import com.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public List<ServiceInformation> getServiceOrderInformation(String serviceType) {
        return serviceMapper.getServiceOrderInformation(serviceType);
    }

    @Override
    public List<ServiceTypeNumber> getNursingWorkersServiceNumber(String serviceType) {
        return serviceMapper.getNursingWorkersServiceNumber(serviceType);
    }

    @Override
    public List<ServiceMaxTypeNumber> getNursingWorkersLevelNumber(String serviceType) {
        return serviceMapper.getNursingWorkersLevelNumber(serviceType);
    }

    @Override
    public List<ServiceTypeNumber> getServiceWordsNumber(String serviceType) {
        return serviceMapper.getServiceWordsNumber(serviceType);
    }
}
