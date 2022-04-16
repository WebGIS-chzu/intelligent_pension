package com.query.entity;

import lombok.Data;

@Data
public class OrderInformation {
    private Integer orderId;
    private String serviceName;
    private Integer evaluate;
    private String date;
}
