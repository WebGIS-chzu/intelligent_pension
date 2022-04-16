package com.query.entity;

import lombok.Data;

import java.util.List;

@Data
public class ElderlyBraceletInformation {
    private String name;
    private List<QueryTypeNumber> value;
}
