package com.social.mapper;

import com.social.entity.RecommendInfor;
import com.social.entity.RecommendInformation;
import com.social.entity.RecommendResemble;
import com.social.entity.RecommendSimplelyInfor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecommendMapper {
    List<RecommendInformation> getRecommendInformation(@Param("dateRange") String dateRange,@Param("radius") Integer radius);

    List<RecommendInformation> getRecommendInformationT(@Param("userid") String userid,@Param("dateRange") String dateRange);

    RecommendSimplelyInfor getRecommenSimplelyInformation(@Param("userid") String userid);

    List<RecommendResemble> getRecommendResemble(@Param("userid") String userid);
}
