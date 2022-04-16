package com.social.service;

import com.social.entity.ActivityAbnormalInformation;
import com.social.entity.ActivityInformation;
import com.social.entity.ActivityTypeList;
import com.social.entity.ActivityTypeNumber;

import java.util.List;

public interface ActivityService {
    Boolean addActivity(String activityName, String label, String location, String beginTime, String endTime, String director,String creatTime);

    List<ActivityInformation> getActivityInformation(Integer page,Integer number);

    List<ActivityTypeList> getActivityTypeNumber();

    List<ActivityAbnormalInformation> getActivityNumber();

    List<ActivityAbnormalInformation> getActivityAverageNumber();
}
