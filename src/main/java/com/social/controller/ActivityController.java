package com.social.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.social.entity.ActivityAbnormalInformation;
import com.social.entity.ActivityInformation;
import com.social.entity.ActivityTypeList;
import com.social.entity.ActivityTypeNumber;
import com.social.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/social/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /** 
    * @Description: 发布活动
    * @Param: [activityInformation] 
    * @return: com.common.Result<?> 
    * @Author: dj
    * @Date: 2022/3/21 
    */
    @PostMapping("/addActivity")
    public Result<?> addActivity(@RequestBody ActivityInformation activityInformation){
        String activityName = activityInformation.getActivityName();
        if (activityName == null || activityName.equals(""))
            return Result.error("提交失败，activityName不能为空","提交失败，activityName不能为空");
        String label = activityInformation.getLabel();
        if (label == null || label.equals(""))
            return Result.error("提交失败，label不能为空","提交失败，label不能为空");
        String location = activityInformation.getLocation();
        if (location == null || location.equals(""))
            return Result.error("提交失败，location不能为空","提交失败，location不能为空");
        String[] strArr = activityInformation.getDate().split("~");
        if (strArr[0] == null || strArr[0].equals(""))
            return Result.error("提交失败，date不能为空","提交失败，date不能为空");
        String beginTime = strArr[0];
        String endTime = strArr[1];
        String director = activityInformation.getDirector();
        if (director == null || director.equals(""))
            return Result.error("提交失败，director不能为空","提交失败，director不能为空");
        //获取当前时间
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String creatTime = simpleFormat.format(now);
        Boolean res = activityService.addActivity(activityName,label,location,beginTime,endTime,director,creatTime);
        return Result.OK(res);
    }

    /** 
    * @Description: 分页查询活动信息
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.social.entity.ActivityInformation>> 
    * @Author: dj
    * @Date: 2022/3/21 
    */
    @PostMapping("/getActivityInformation")
    public Result<List<ActivityInformation>> getActivityInformation(@RequestBody JSONObject jsonObject){
        Integer page = jsonObject.getInteger("page");
        Integer number = jsonObject.getInteger("number");
        page--;
        page = page * number;
        List<ActivityInformation> list = activityService.getActivityInformation(page,number);
//        String s = "";

        list.forEach(list1 -> {
            String participant = "";
            for (int i = 0; i < list1.getParticipantList().size(); i++) {
               String s = list1.getParticipantList().get(i);
               participant = participant + s;
            }
            if (participant.length() != 0){
            participant = participant.substring(0,participant.length()-1);
            }
            list1.setParticipants(participant);
        });
        return Result.OK(list);
    }

    /** 
    * @Description: 获取活动举办统计
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.social.entity.ActivityTypeList>> 
    * @Author: dj
    * @Date: 2022/3/23
    */
    @GetMapping("/getActivityTypeNumber")
    public Result<List<ActivityTypeList>> getActivityTypeNumber(){
        List<String> list1 = new ArrayList();
        list1.add("体育竞技");
        list1.add("社会公益");
        list1.add("文化娱乐");
        list1.add("主题教育");
        list1.add("组织活动");
        List<ActivityTypeList> list = activityService.getActivityTypeNumber();
        //判断获取的结果中是否不包含某活动种类
        list.forEach(activityTypeList -> {
            for(int j = 0; j< list1.size(); j++) {
                int m = 0;
                for (int i = 0; i < activityTypeList.getValueList().size(); i++) {
                    if (!list1.get(j).equals(activityTypeList.getValueList().get(i).getName())) {
                        m++;
                    }
                }
                if (m == activityTypeList.getValueList().size())
                    activityTypeList.getValueList().add(new ActivityTypeNumber(list1.get(j), 0));
            }
        });
        return Result.OK(list);
    }

    /**
    * @Description: 获取异常活跃用户
    * @Param: []
    * @return: com.common.Result<java.util.List<com.social.entity.ActivityAbnormalInformation>>
    * @Author: dj
    * @Date: 2022/3/23
    */
    @GetMapping("/getAbnormalInformation")
    public Result<List<ActivityAbnormalInformation>> getAbnormalInformation(){
        List<ActivityAbnormalInformation> list1 = activityService.getActivityNumber();
        List<ActivityAbnormalInformation> list2 = activityService.getActivityAverageNumber();
        list1.forEach(listAll ->{
            for (int i = 0; i < list1.size(); i++) {
                if (list2.get(i).getName().equals(listAll.getName()))
                    list2.get(i).setActivityNumber(listAll.getActivityNumber());
            }
        });
        return Result.OK(list2);
    }


}
