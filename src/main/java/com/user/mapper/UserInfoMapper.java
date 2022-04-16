package com.user.mapper;

import com.user.entity.Bracelet;
import com.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {
    Boolean updateInfoByUserId(UserInfo userInfo);

    Integer getUserIdByUserName(@Param("username") String username);

    Boolean UpdataHeadpByUserId(@Param("userid") Integer userid, @Param("headportrait") String headSculptureUrl,
                                @Param("filename") String realFileName);

    String selectFilenameByUserName(@Param("username") String username);

    UserInfo getInfoByUserName(@Param("username") String username);

    String getHeadCupptureByUserName(@Param("username") String username);

    Bracelet getUserBraceletInfoByUserName(@Param("username") String username);
}
