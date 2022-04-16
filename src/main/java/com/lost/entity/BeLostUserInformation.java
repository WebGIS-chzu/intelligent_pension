package com.lost.entity;

import com.social.entity.ChainLinkList;
import com.social.entity.ChainNodeList;
import lombok.Data;

import java.util.List;

@Data
public class BeLostUserInformation {

    private Integer userid;
    private String name;
    private String gender;
    private Integer age;
    private String head_portrait;
    //家庭住址
    private String address;
    //紧急联系人
    private String emergency_contact;
    //走失状态
    private String lostState;
    //走失时间
    private String lostDate;
    //走失位置
    private String lostLocation;
    //走失路径
    private String roadLocation;
    private List<ChainNodeList> nodeList;
    private List<ChainLinkList> linkList;
}
