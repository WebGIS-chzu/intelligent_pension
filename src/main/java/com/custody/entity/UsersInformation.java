package com.custody.entity;

import lombok.Data;

@Data
public class UsersInformation {

    private Integer userid;
    private String name;
    private String gender;
    private String headurl;
    private Double heartrate;
    private Double temperature;
    private Double bloodpressure;
    private Double tilt;
    private String posture;
    private String state;
    private String emotion;
    private String date;
    private String location;
    private String roadlocation;
}
