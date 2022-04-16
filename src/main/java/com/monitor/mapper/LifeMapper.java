package com.monitor.mapper;

import com.monitor.entity.UserLocationInfo;
import com.monitor.entity.WpgCost;
import com.user.entity.Perms;
import com.user.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LifeMapper {
    List<WpgCost> getAllWpgCost();

    List<UserLocationInfo> getUserLocationInfo();
}
