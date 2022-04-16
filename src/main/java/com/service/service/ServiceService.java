package com.service.service;

import com.service.entity.ServiceInformation;
import com.service.entity.ServiceMaxTypeNumber;
import com.service.entity.ServiceTypeNumber;

import java.util.List;

public interface ServiceService {
    List<ServiceInformation> getServiceOrderInformation(String serviceType);

    List<ServiceTypeNumber> getNursingWorkersServiceNumber(String serviceType);

    List<ServiceMaxTypeNumber> getNursingWorkersLevelNumber(String serviceType);

    List<ServiceTypeNumber> getServiceWordsNumber(String serviceType);

}
