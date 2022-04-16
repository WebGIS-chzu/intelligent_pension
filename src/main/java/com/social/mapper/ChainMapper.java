package com.social.mapper;

import com.social.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ChainMapper {
    List<ChainTypeNumber> getElderlyLocation();

    List<ChainUserInfor> getUserInformationByUserId(@Param("userid") String userid);

    List<ChainNodeList> getChainNodeListByCondition(@Param("userid") String userid,@Param("name") String name);

    List<ChainLinkList> getChainLinkListByCondition(@Param("userid") String userid,@Param("name") String name);

    String getUserId(@Param("name") String name);

    ChainTypeNumber getElderlyLocationById(@Param("userid") String userid);
}
