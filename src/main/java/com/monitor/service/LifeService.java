package com.monitor.service;

import com.monitor.entity.UserLocationInfo;
import com.monitor.entity.WpgCost;
import com.user.entity.Perms;
import com.user.entity.User;

import java.util.List;

public interface LifeService {

    List<WpgCost> getAllWpgCost();

    List<UserLocationInfo> getUserLocationInfo();

}
