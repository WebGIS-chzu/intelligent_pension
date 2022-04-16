package com.lost.entity;

import lombok.Data;

@Data
public class LostFindInformation {

    private Integer userid;
    private String name;
    private Integer age;
    private String date;
    private String find_location;
    private String lostState;
}
