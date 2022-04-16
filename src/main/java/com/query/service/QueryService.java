package com.query.service;

import com.query.entity.*;

import java.util.List;

public interface QueryService {
    List<QueryTypeNumber> queryNursingWorkerByCondition(String name, String nursingId, Integer orderNumberMin, Integer orderNumberMax, Integer evaluateMin, Integer evaluateMax);

    List<NursingWorkerInformation> getNursingWorkerInformationByNursingId(String nursingId);

    List<OrderInformation> getOrderInformationByNursingId(String nursingId);

    List<ElderlyQueryAddress> getElderlyAddress();

    List<QueryTypeNumber> queryElderlyByCondition(String name, String idCardNumber, String community, String building, String houseNumber, Double heartRateMin, Double heartRateMax, Double bloodPressureMin, Double bloodPressureMax);

    List<ElderlyInformation> getElderlyInformationByUserid(String userid);

    List<ElderlyBraceletInformation> getWpgCostList(String userid);
}
