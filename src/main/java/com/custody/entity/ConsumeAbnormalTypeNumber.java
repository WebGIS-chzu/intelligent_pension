package com.custody.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class ConsumeAbnormalTypeNumber {

    private String name;
    private Integer value;
    private String date;
}
