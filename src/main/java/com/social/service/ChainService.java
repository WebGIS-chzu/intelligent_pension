package com.social.service;

import com.social.entity.*;

import java.util.List;

public interface ChainService {
    List<ChainTypeNumber> getElderlyLocation();

    List<ChainUserInfor> getUserInformationByUserId(String userid);

    List<ChainNodeList> getChainNodeListByCondition(String userid, String name);

    List<ChainLinkList> getChainLinkListByCondition(String userid, String name);

    String getUserId(String name);

    ChainTypeNumber getElderlyLocationById(String userid);
}
