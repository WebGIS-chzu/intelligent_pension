package com.custody.entity;

import lombok.Data;

import java.util.List;

@Data
public class ConsumeDateTypeNumber {
    private String name;
    private List<ConsumeAbnormalTypeNumber> value;
}
