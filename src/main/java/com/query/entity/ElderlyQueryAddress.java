package com.query.entity;

import lombok.Data;

import java.util.List;

@Data
public class ElderlyQueryAddress {
    private String name;
    private List<ElderlyQueryAddress> value;
}
