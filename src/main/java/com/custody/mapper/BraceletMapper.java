package com.custody.mapper;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersAbnormalInformation;
import com.custody.entity.UsersInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface BraceletMapper {
    List<AbnormalTypeInformation> getAbnormalUserByAbnormal(@Param("abnormalName") String abnormalName);

    List<UsersAbnormalInformation> getUsersInformation();

    List<UsersInformation> getUserInformationByUserId(@Param("userid") Integer userid);

    List<CustodyAbnormalTypeNumber> getBraceletAbnormalTypeNumber();
}
