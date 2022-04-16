package com.service.entity;

import lombok.Data;

@Data
public class ServiceInformation {

    //订单id
    private Integer orderId;
    //护工id
    private Integer nursingId;
    //护工姓名
    private String nursingName;
    //护工手机号
    private String nursingPhoneNumber;
    //服务类型id
    private Integer serviceId;
    //服务类型名称
    private String serviceName;
    //用户id
    private Integer userid;
    //用户名称
    private String userName;
    //用户评价
    private String serviceDescribe;
    //用户评分
    private Integer evaluate;
    //服务状态
    private String serviceState;
    //服务时间
    private String date;
    //服务地点
    private String location;
    //服务时间类型
    private String dateType;
}
