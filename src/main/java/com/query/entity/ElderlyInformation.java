package com.query.entity;

import lombok.Data;

import java.util.List;

@Data
public class ElderlyInformation {

    private String name;
    //性别
    private String gender;
    //年龄
    private Integer age;
    //身份证
    private String idCardNumber;
    //住址
    private String address;
    //手机号
    private String phoneNumber;
    //子女姓名
    private String childrenName;
    //子女联系方式
    private String childrenPhoneNumber;
    //头像
    private String headPortrait;
    //健康数据
    private List<ElderlyBraceletInformation> braceletInformationList;
    //消费数据
    private List<ElderlyBraceletInformation> wpgCostList;
}
