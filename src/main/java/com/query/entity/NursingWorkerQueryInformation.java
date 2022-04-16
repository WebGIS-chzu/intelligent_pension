package com.query.entity;

import lombok.Data;

@Data
public class NursingWorkerQueryInformation {
    private String name;
    //护工id
    private String nursingId;
    //单量下限
    private Integer orderNumberMin;
    //单量上限
    private Integer orderNumberMax;
    //评分下限
    private Integer evaluateMin;
    //评分下限
    private Integer evaluateMax;
}
