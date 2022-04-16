package com.lost.mapper;

import com.lost.entity.BeLostUserInformation;
import com.lost.entity.LostFindInformation;
import com.lost.entity.LostTypeNumber;
import com.social.entity.ChainLinkList;
import com.social.entity.ChainNodeList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LostWarningMapper {
    List<BeLostUserInformation> getBelostUserInformation();

    Boolean updateLostStateByUserid(@Param("userid") Integer userid,@Param("lostState") String lostState);

    List<LostFindInformation> getLostFindInformation();

    Boolean insertLostFindInformationByUserid(@Param("userid") Integer userid,
                                              @Param("name") String name,
                                              @Param("age") Integer age,
                                              @Param("date") String date,
                                              @Param("find_location") String find_location,
                                              @Param("lostState") String lostState);

    Boolean deleteLostInformation(@Param("userid") Integer userid);

    String getUserInformationByUserid(@Param("userid") Integer userid);

    Boolean insertUserLostInformation(@Param("userid") Integer userid,
                                      @Param("name") String name,
                                      @Param("age") Integer age,
                                      @Param("lostDate") String lostDate,
                                      @Param("lostLocation") String lostLocation);

    List<LostTypeNumber> getLostTypeInformation();

    List<ChainLinkList> getLinkList(@Param("userid") Integer userid);

    List<ChainNodeList> getNodeList(@Param("userid") Integer userid);
}
