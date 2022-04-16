package com.user.service;

import com.user.entity.Bracelet;
import com.user.entity.UserInfo;

public interface UserInfoService {
    Boolean updateInfoByUserId(UserInfo userInfo);

    Integer getUserIdByUserName(String username);

    Boolean UpdataHeadpByUserId(Integer userid, String headSculptureUrl,String realFileName);

    String selectFilenameByUserName(String username);

    UserInfo getInfoByUserName(String username);

    String getHeadCupptureByUserName(String username);

    Bracelet getUserBraceletInfoByUserName(String username);
}
