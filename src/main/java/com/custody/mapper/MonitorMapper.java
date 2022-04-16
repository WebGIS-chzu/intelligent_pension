package com.custody.mapper;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MonitorMapper {
    List<AbnormalTypeInformation> getMonitorAbnormalUserByAbnormal(@Param("monitorAbnormal") String monitorAbnormal);

    List<CustodyAbnormalTypeNumber> getMonitorAbnormalTypeNumber();

    List<UsersInformation> getMonitorAbnormalUserInformation(@Param("monitorAbnormal") String monitorAbnormal);
}
