package com.social.service;

import com.social.entity.RecommendInfor;
import com.social.entity.RecommendInformation;
import com.social.entity.RecommendResemble;
import com.social.entity.RecommendSimplelyInfor;

import java.util.List;

public interface RecommendService {
    List<RecommendInformation> getRecommendInformation(String dateRange, Integer radius);

    List<RecommendInformation> getRecommendInformationT(String userid, String dateRange);

    RecommendSimplelyInfor getRecommenSimplelyInformation(String userid);

    List<RecommendResemble> getRecommendResemble(String userid);
}
