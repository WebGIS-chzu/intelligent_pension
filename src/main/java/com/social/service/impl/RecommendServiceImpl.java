package com.social.service.impl;

import com.social.entity.RecommendInfor;
import com.social.entity.RecommendInformation;
import com.social.entity.RecommendResemble;
import com.social.entity.RecommendSimplelyInfor;
import com.social.mapper.RecommendMapper;
import com.social.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendServiceImpl implements RecommendService {
    @Autowired
    private RecommendMapper recommendMapper;

    @Override
    public List<RecommendInformation> getRecommendInformation(String dateRange, Integer radius) {
        return recommendMapper.getRecommendInformation(dateRange,radius);
    }

    @Override
    public List<RecommendInformation> getRecommendInformationT(String userid, String dateRange) {
        return recommendMapper.getRecommendInformationT(userid,dateRange);
    }

    @Override
    public RecommendSimplelyInfor getRecommenSimplelyInformation(String userid) {
        return recommendMapper.getRecommenSimplelyInformation(userid);
    }

    @Override
    public List<RecommendResemble> getRecommendResemble(String userid) {
        return recommendMapper.getRecommendResemble(userid);
    }
}
