package com.custody.entity;

import lombok.Data;

@Data
public class AbnormalTypeInformation {
    private Integer userid;
    private  String name;
    private String headurl;
    private String date;
    //心率
    private Double heartrate;
    private String heartrateRange;
    //体温
    private Double temperature;
    private String temperatureRange;
    //血压
    private Double bloodpressure;
    private String bloodpressureRange;
    //倾斜速率
    private Double tilt;
    private String tiltRange;
    //手环数据异常类型
    private String type;
    //姿态异常
    private  String posture;
    //情绪异常
    private  String emotion;
    //路径
    private String roadlocation;
    //位置
    private String location;
}
