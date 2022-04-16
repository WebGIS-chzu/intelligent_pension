package com.custody.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersAbnormalInformation;
import com.custody.entity.UsersInformation;
import com.custody.service.BraceletService;
import com.monitor.service.LifeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custody/bracelet")
public class BraceletController {

    @Autowired
    private BraceletService braceletService;

    /** 
    * @Description: 根据异常情况获取对应的用户手环及位置信息
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.custody.entity.AbnormalTypeInformation>> 
    * @Author: dj
    * @Date: 2022/2/25 
    */
    @PostMapping("/getAbnormalUserByAbnormal")
    public Result<List<AbnormalTypeInformation>> getAbnormalUserByAbnormal(@RequestBody JSONObject jsonObject){
        String abnormalName = jsonObject.getString("abnormalName");
        List<AbnormalTypeInformation> abnormalList = braceletService.getAbnormalUserByAbnormal(abnormalName);
        return Result.OK(abnormalList);
    }

//    /**
//    * @Description: 获取右侧滚动的用户手环头像等资料
//    * @Param: []
//    * @return: com.common.Result<java.util.List<com.custody.entity.UsersInformation>>
//    * @Author: dj
//    * @Date: 2022/2/25
//    */
//    @GetMapping("/getUsersInformation")
//    public Result<List<UsersAbnormalInformation>> getUsersInformation(){
//        List<UsersAbnormalInformation> usersInformationList = braceletService.getUsersInformation();
//        usersInformationList.remove(0);
//        return Result.OK(usersInformationList);
//    }

    /**
    * @Description: 根据用户id获取用户资料
    * @Param: [jsonObject]
    * @return: com.common.Result<com.custody.entity.UsersInformation>
    * @Author: dj
    * @Date: 2022/2/25
    */
    @PostMapping("/getUserInformationByUserId")
    public Result<List<UsersInformation>> getUserInformationByUserId(@RequestBody JSONObject jsonObject){
        Integer userid = jsonObject.getInteger("userid");
        List<UsersInformation> userInformationList = braceletService.getUserInformationByUserId(userid);
        return Result.OK(userInformationList);
    }

    /** 
    * @Description: 获取手环异常类型及其数量
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.custody.entity.CustodyAbnormalTypeNumber>> 
    * @Author: dj
    * @Date: 2022/3/8 
    */
    @GetMapping("/getBraceletAbnormalTypeNumber")
    public Result<List<CustodyAbnormalTypeNumber>> getBraceletAbnormalTypeNumber(){
        List<CustodyAbnormalTypeNumber> list = braceletService.getBraceletAbnormalTypeNumber();
        return Result.OK(list);
    }
}
