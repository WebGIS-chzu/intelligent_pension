package com.query.entity;

import lombok.Data;

@Data
public class ElderlyQueryInformation {

    private String name;
    //身份证
    private String idCardNumber;
    //居住地址
    private String address;
    //心率下限
    private Double heartRateMin;
    //心率上限
    private Double heartRateMax;
    //血压下限
    private Double bloodPressureMin;
    //血压上限
    private Double bloodPressureMax;
}
