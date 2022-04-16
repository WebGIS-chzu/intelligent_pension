package com.custody.entity;

import lombok.Data;

@Data
public class UsersAbnormalInformation {

    private Integer userid;
    private String name;
    private String gender;
    private String headurl;
    private Double heartrate;
    private String heartrateRange;
    private Double temperature;
    private String temperatureRange;
    private Double bloodpressure;
    private String bloodpressureRange;
    private Double tilt;
    private String tiltRange;
    private String posture;
    private String state;
    private String emotion;
    private String date;
    private String location;
    private String roadlocation;
}
