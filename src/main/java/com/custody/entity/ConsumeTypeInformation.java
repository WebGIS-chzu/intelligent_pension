package com.custody.entity;

import lombok.Data;

@Data
public class ConsumeTypeInformation {

    private Integer userid;
    private String name;
    private Integer age;
    private String gender;
    //水费
    private Double waterrate;
    //水费类型
    private String waterType;
    //电费
    private Double powerrate;
    private String powerType;
    //燃气费
    private Double gascost;
    private String gasType;
    private String date;
    //解决状态
    private String state;
    //住址
    private String address;
    //位置
    private String location;
}
