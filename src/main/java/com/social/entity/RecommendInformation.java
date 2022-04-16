package com.social.entity;

import lombok.Data;

import java.util.List;

@Data
public class RecommendInformation {
    private String userid;
    private String name;
    private Integer radius;
    private String date_range;
    private List<RecommendPlace> recommendPlace;
}
