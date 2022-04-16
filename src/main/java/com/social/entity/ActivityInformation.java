package com.social.entity;

import lombok.Data;

import java.util.List;

@Data
public class ActivityInformation {
    private Integer activityId;
    //活动名称
    private String activityName;
    //活动地址
    private String location;
    //活动日期
    private String date;
    //活动类型
    private String label;
    //活动状态
    private String state;
    //活动负责人
    private String director;
    //参与人员
    private String participants;
    private List<String> participantList;
}
