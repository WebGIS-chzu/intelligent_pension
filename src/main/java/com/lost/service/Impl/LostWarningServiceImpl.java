package com.lost.service.Impl;

import com.lost.entity.BeLostUserInformation;
import com.lost.entity.LostFindInformation;
import com.lost.entity.LostTypeNumber;
import com.lost.mapper.LostWarningMapper;
import com.lost.service.LostWarningService;
import com.social.entity.ChainLinkList;
import com.social.entity.ChainNodeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LostWarningServiceImpl implements LostWarningService {

    @Autowired
    private LostWarningMapper lostWarningMapper;

    @Override
    public List<BeLostUserInformation> getBelostUserInformation() {
        return lostWarningMapper.getBelostUserInformation();
    }

    @Override
    public Boolean updateLostStateByUserid(String lostState, Integer userid) {
        return lostWarningMapper.updateLostStateByUserid(userid,lostState);
    }

    @Override
    public List<LostFindInformation> getLostFindInformation() {
        return lostWarningMapper.getLostFindInformation();
    }

    @Override
    public Boolean insertLostFindInformationByUserid(Integer userid, String name, Integer age, String date, String find_location,String lostState) {
        return lostWarningMapper.insertLostFindInformationByUserid(userid,name,age,date,find_location,lostState);
    }

    @Override
    public Boolean deleteLostInformation(Integer userid) {
        return lostWarningMapper.deleteLostInformation(userid);
    }

    @Override
    public String getUserInformationByUserid(Integer userid) {
        return lostWarningMapper.getUserInformationByUserid(userid);
    }

    @Override
    public Boolean insertUserLostInformation(Integer userid, String name, Integer age, String lostDate, String lostLocation) {
        return lostWarningMapper.insertUserLostInformation(userid,name,age,lostDate,lostLocation);
    }

    @Override
    public List<LostTypeNumber> getLostTypeInformation() {
        return lostWarningMapper.getLostTypeInformation();
    }

    @Override
    public List<ChainLinkList> getLinkList(Integer userid) {
        return lostWarningMapper.getLinkList(userid);
    }

    @Override
    public List<ChainNodeList> getNodeList(Integer userid) {
        return lostWarningMapper.getNodeList(userid);
    }
}
