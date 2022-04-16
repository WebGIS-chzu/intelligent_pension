package com.query.mapper;

import com.query.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QueryMapper {
    List<QueryTypeNumber> queryNursingWorkerByCondition(@Param("name") String name, @Param("nursingId") String nursingId, @Param("orderNumberMin") Integer orderNumberMin, @Param("orderNumberMax") Integer orderNumberMax, @Param("evaluateMin") Integer evaluateMin, @Param("evaluateMax") Integer evaluateMax);

    List<NursingWorkerInformation> getNursingWorkerInformationByNursingId(@Param("nursingId") String nursingId);

    List<OrderInformation> getOrderInformationByNursingId(@Param("nursingId") String nursingId);

    List<ElderlyQueryAddress> getElderlyAddress();

    List<QueryTypeNumber> queryElderlyByCondition(@Param("name") String name,@Param("idCardNumber") String idCardNumber,
                                                  @Param("community") String community,@Param("building") String building,
                                                  @Param("houseNumber") String houseNumber,
                                                  @Param("heartRateMin") Double heartRateMin,
                                                  @Param("heartRateMax") Double heartRateMax,
                                                  @Param("bloodPressureMin") Double bloodPressureMin,
                                                  @Param("bloodPressureMax") Double bloodPressureMax);

    List<ElderlyInformation> getElderlyInformationByUserid(@Param("userid") String userid);

    List<ElderlyBraceletInformation> getWpgCostList(@Param("userid") String userid);
}
