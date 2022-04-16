package com.monitor.service;

import com.monitor.entity.DateTypeNumber;
import com.monitor.entity.ServiceDataTypeNumber;
import com.monitor.entity.TypeNumber;
import java.util.List;

public interface DatapanelService {
    List<TypeNumber> getUserInformationState();

    List<TypeNumber> getServiceStructure();

    List<TypeNumber> getTreatmentValues();

    List<ServiceDataTypeNumber> getNursingWorkersEvaluate();

    List<TypeNumber> getAbnormalHealth();

    List<TypeNumber> getAgeGroup();
}
