package com.custody.service;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersInformation;

import java.util.List;

public interface MonitorService {
    List<AbnormalTypeInformation> getMonitorAbnormalUserByAbnormal(String monitorAbnormal);

    List<CustodyAbnormalTypeNumber> getMonitorAbnormalTypeNumber();

    List<UsersInformation> getMonitorAbnormalUserInformation(String monitorAbnormal);
}
