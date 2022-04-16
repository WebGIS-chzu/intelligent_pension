package com.social.entity;

import lombok.Data;

import java.util.List;

@Data
public class RecommendInfor implements Comparable<RecommendInfor>{

    private RecommendSimplelyInfor simplelyInfor;
    private List<RecommendResemble> recommendResemble;
    public RecommendInfor(RecommendSimplelyInfor recommendSimplelyInfor,List<RecommendResemble> recommendResemble){
        this.simplelyInfor = recommendSimplelyInfor;
        this.recommendResemble = recommendResemble;
    }

    @Override
    public int compareTo(RecommendInfor o) {
        return o.getRecommendResemble().get(3).getValue().compareTo(this.getRecommendResemble().get(3).getValue());
    }
}
