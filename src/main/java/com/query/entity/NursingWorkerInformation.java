package com.query.entity;

import lombok.Data;

import java.util.List;

@Data
public class NursingWorkerInformation {
    private String nursingId;
    private String nursingName;
    private String gender;
    private Integer age;
    private String idCardNumber;
    private String phoneNumber;
    private String headPortrait;
    private String location;
    private List<QueryTypeNumber> queryTypeNumber;
    private List<OrderInformation> orderInformation;
}
