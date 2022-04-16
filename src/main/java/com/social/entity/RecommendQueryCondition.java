package com.social.entity;

import lombok.Data;

@Data
public class RecommendQueryCondition {
    private String userid;
    private String dateRange;
    private Integer radius;
    private Double resemble;
}
