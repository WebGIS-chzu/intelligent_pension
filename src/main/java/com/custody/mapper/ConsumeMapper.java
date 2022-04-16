package com.custody.mapper;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.ConsumeAbnormalTypeNumber;
import com.custody.entity.ConsumeTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ConsumeMapper {
    List<CustodyAbnormalTypeNumber> getConsumeAbnormalTyoeNumber();

    List<ConsumeTypeInformation> getAbnormalUserInformationByType(@Param("abnormalType") String abnormalType);

    List<ConsumeTypeInformation> getUserWpgInformation();

    List<ConsumeAbnormalTypeNumber> getAbnormalTypeNumberGroupByDate();

    List<CustodyAbnormalTypeNumber> getSolveStateNumber();

    List<ConsumeTypeInformation> getWpgRecord();
}
