package com.social.service.impl;

import com.social.entity.ActivityAbnormalInformation;
import com.social.entity.ActivityInformation;
import com.social.entity.ActivityTypeList;
import com.social.entity.ActivityTypeNumber;
import com.social.mapper.ActivityMapper;
import com.social.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public Boolean addActivity(String activityName, String label, String location, String beginTime, String endTime, String director,String creatTime) {
        return activityMapper.addActivity(activityName,label,location,beginTime,endTime,director,creatTime);
    }

    @Override
    public List<ActivityInformation> getActivityInformation(Integer page,Integer number) {
        return activityMapper.getActivityInformation(page,number);
    }

    @Override
    public List<ActivityTypeList> getActivityTypeNumber() {
        return activityMapper.getActivityTypeNumber();
    }

    @Override
    public List<ActivityAbnormalInformation> getActivityNumber() {
        return activityMapper.getActivityNumber();
    }

    @Override
    public List<ActivityAbnormalInformation> getActivityAverageNumber() {
        return activityMapper.getActivityAverageNumber();
    }
}
