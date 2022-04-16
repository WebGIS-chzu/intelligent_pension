package com.custody.service.impl;

import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersInformation;
import com.custody.mapper.MonitorMapper;
import com.custody.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {
    @Autowired
    private MonitorMapper monitorMapper;

    @Override
    public List<AbnormalTypeInformation> getMonitorAbnormalUserByAbnormal(String monitorAbnormal) {
        return monitorMapper.getMonitorAbnormalUserByAbnormal(monitorAbnormal);
    }

    @Override
    public List<CustodyAbnormalTypeNumber> getMonitorAbnormalTypeNumber() {
        return monitorMapper.getMonitorAbnormalTypeNumber();
    }

    @Override
    public List<UsersInformation> getMonitorAbnormalUserInformation(String monitorAbnormal) {
        return monitorMapper.getMonitorAbnormalUserInformation(monitorAbnormal);
    }
}
