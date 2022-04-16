package com.monitor.mapper;


import com.monitor.entity.DateTypeNumber;
import com.monitor.entity.ServiceDataTypeNumber;
import com.monitor.entity.TypeNumber;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DatapanelMapper {
    List<TypeNumber> getUserInformationState();

    List<TypeNumber> getServiceStructure();

    List<TypeNumber> getTreatmentValues();

    List<ServiceDataTypeNumber> getNursingWorkersEvaluate();

    List<TypeNumber> getAbnormalHealth();

    List<TypeNumber> getAgeGroup();
}
