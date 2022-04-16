package com.monitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLocationInfo {

    private String userid;
    private String name;
    private Integer age;
    private String gender;
    private String idcardnumber;
    private String phonenumber;
    private String personalprofile;
    private String address;
    private String nickname;
    private String birthday;
    private Integer height;
    private Integer weight;
    private String date;
    private String roadlocation;
    private String location;
}
