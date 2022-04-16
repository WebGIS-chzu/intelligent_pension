package com.social.entity;

import lombok.Data;

import java.util.List;

@Data
public class ChainUserInformation {
    private String userid;
    private List<ChainNodeList> nodeList;
    private List<ChainLinkList> linkList;
    private List<ChainTypeNumber> typeNumberList;
}
