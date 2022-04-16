package com.service.mapper;

import com.service.entity.ServiceInformation;
import com.service.entity.ServiceMaxTypeNumber;
import com.service.entity.ServiceTypeNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ServiceMapper {
    List<ServiceInformation> getServiceOrderInformation(@Param("serviceType") String serviceType);

    List<ServiceTypeNumber> getNursingWorkersServiceNumber(@Param("serviceType") String serviceType);

    List<ServiceMaxTypeNumber> getNursingWorkersLevelNumber(@Param("serviceType") String serviceType);

    List<ServiceTypeNumber> getServiceWordsNumber(@Param("serviceType") String serviceType);
}
