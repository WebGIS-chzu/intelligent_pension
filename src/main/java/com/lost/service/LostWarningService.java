package com.lost.service;

import com.lost.entity.BeLostUserInformation;
import com.lost.entity.LostFindInformation;
import com.lost.entity.LostTypeNumber;
import com.social.entity.ChainLinkList;
import com.social.entity.ChainNodeList;

import java.util.List;

public interface LostWarningService {
    List<BeLostUserInformation> getBelostUserInformation();

    Boolean updateLostStateByUserid(String lostState, Integer userid);

    List<LostFindInformation> getLostFindInformation();

    Boolean insertLostFindInformationByUserid(Integer userid, String name, Integer age, String date, String find_location,String lostState);

    Boolean deleteLostInformation(Integer userid);

    String getUserInformationByUserid(Integer userid);

    Boolean insertUserLostInformation(Integer userid, String name, Integer age, String lostDate, String lostLocation);

    List<LostTypeNumber> getLostTypeInformation();

    List<ChainLinkList> getLinkList(Integer userid);

    List<ChainNodeList> getNodeList(Integer userid);
}
