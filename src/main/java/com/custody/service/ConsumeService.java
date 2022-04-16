package com.custody.service;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.ConsumeAbnormalTypeNumber;
import com.custody.entity.ConsumeTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;

import java.util.List;

public interface ConsumeService {
    List<CustodyAbnormalTypeNumber> getConsumeAbnormalTyoeNumber();

    List<ConsumeTypeInformation> getAbnormalUserInformationByType(String abnormalType);

    List<ConsumeTypeInformation> getUserWpgInformation();

    List<ConsumeAbnormalTypeNumber> getAbnormalTypeNumberGroupByDate();

    List<CustodyAbnormalTypeNumber> getSolveStateNumber();

    List<ConsumeTypeInformation> getWpgRecord();
}
