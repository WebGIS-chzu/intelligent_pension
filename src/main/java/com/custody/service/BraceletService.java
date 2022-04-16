package com.custody.service;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersAbnormalInformation;
import com.custody.entity.UsersInformation;
import org.springframework.stereotype.Service;

import java.util.List;


public interface BraceletService {
    List<AbnormalTypeInformation> getAbnormalUserByAbnormal(String abnormalName);

    List<UsersAbnormalInformation> getUsersInformation();

    List<UsersInformation> getUserInformationByUserId(Integer userid);

    List<CustodyAbnormalTypeNumber> getBraceletAbnormalTypeNumber();
}
