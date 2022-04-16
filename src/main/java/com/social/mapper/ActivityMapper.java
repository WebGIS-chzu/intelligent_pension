package com.social.mapper;

import com.social.entity.ActivityAbnormalInformation;
import com.social.entity.ActivityInformation;
import com.social.entity.ActivityTypeList;
import com.social.entity.ActivityTypeNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityMapper {
    Boolean addActivity(@Param("activityName") String activityName,
                        @Param("label") String label,
                        @Param("location") String location,
                        @Param("beginTime") String beginTime,
                        @Param("endTime") String endTime,
                        @Param("director") String director,
                        @Param("creatTime") String creatTime);

    List<ActivityInformation> getActivityInformation(@Param("page") Integer page,@Param("number") Integer number);

    List<ActivityTypeList> getActivityTypeNumber();

    List<ActivityAbnormalInformation> getActivityNumber();

    List<ActivityAbnormalInformation> getActivityAverageNumber();
}
