package com.monitor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDataTypeNumber {

    private String name;
    private Double evaluate;
    private List<TypeNumber> value;
}
