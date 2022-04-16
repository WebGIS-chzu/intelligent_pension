package com.monitor.entity;

import lombok.Data;

@Data
public class WpgCost {
    private String userid;
    private String date;
    //电费
    private String powerrate;
    //水费
    private String waterrate;
    //燃气费
    private String gascost;
}
