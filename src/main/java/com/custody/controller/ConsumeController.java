package com.custody.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.custody.entity.*;
import com.custody.service.ConsumeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/custody/consume")
public class ConsumeController {

    @Autowired
    private ConsumeService consumeService;

    /** 
    * @Description: 获取水电费异常类型及数量
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.custody.entity.CustodyAbnormalTypeNumber>> 
    * @Author: dj
    * @Date: 2022/3/1 
    */
    @GetMapping("/getConsumeAbnormalTypeNumber")
    public Result<List<CustodyAbnormalTypeNumber>> getConsumeAbnormalTyoeNumber(){
        List<CustodyAbnormalTypeNumber> abnormalTypeInformationList = consumeService.getConsumeAbnormalTyoeNumber();
        return Result.OK(abnormalTypeInformationList);
    }

    /** 
    * @Description: 根据水电费异常类型获取对应的用户解决状态等用户信息
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.custody.entity.ConsumeTypeInformation>> 
    * @Author: dj
    * @Date: 2022/3/1 
    */
    @PostMapping("/getAbnormalUserInformationByType")
    public Result<List<ConsumeTypeInformation>> getAbnormalUserInformationByType(@RequestBody JSONObject jsonObject){
        String abnormalType = jsonObject.getString("abnormalType");
        List<ConsumeTypeInformation> consumeTypeInformationList = consumeService.getAbnormalUserInformationByType(abnormalType);
        return Result.OK(consumeTypeInformationList);
    }
    
    /** 
    * @Description: 获取用户的水电气费等信息
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.custody.entity.ConsumeTypeInformation>> 
    * @Author: dj
    * @Date: 2022/3/4 
    */
    @GetMapping("/getUserWpgInformation")
    public Result<List<ConsumeTypeInformation>> getUserWpgInformation(){
        List<ConsumeTypeInformation> userWpgInformationList = consumeService.getUserWpgInformation();
        return Result.OK(userWpgInformationList);
    }

    /**
    * @Description: 获取前七日的水电气异常及数量
    * @Param: []
    * @return: com.common.Result<java.util.List<com.custody.entity.ConsumeDateTypeNumber>>
    * @Author: dj
    * @Date: 2022/3/4
    */
    @GetMapping("/getAbnormalTypeNumberGroupByDate")
    public Result<List<ConsumeDateTypeNumber>> getAbnormalTypeNumberGroupByDate(){

        List<ConsumeDateTypeNumber> list = new ArrayList<>();
        List<ConsumeAbnormalTypeNumber> consumeAbnormalTypeList = consumeService.getAbnormalTypeNumberGroupByDate();
        //遍历consumeAbnormalTypeList，取出其中的的数据填入结果list
        for (int i = 0; i < consumeAbnormalTypeList.size(); i=i+4) {
            ConsumeDateTypeNumber consumeDateTypeNumber = new ConsumeDateTypeNumber();
            consumeDateTypeNumber.setName(consumeAbnormalTypeList.get(i).getDate());
            consumeDateTypeNumber.setValue(consumeAbnormalTypeList.subList(i,i+4));
            list.add(consumeDateTypeNumber);
        }
        return Result.OK(list);
    }

    /**
    * @Description: 获取异常情况的解决状态
    * @Param: []
    * @return: com.common.Result<java.util.List<com.custody.entity.CustodyAbnormalTypeNumber>>
    * @Author: dj
    * @Date: 2022/3/4
    */
    @GetMapping("/getSolveStateNumber")
    public Result<List<CustodyAbnormalTypeNumber>> getSolveStateNumber(){
        List<CustodyAbnormalTypeNumber> solveStateList = consumeService.getSolveStateNumber();
        return Result.OK(solveStateList);
    }

    /**
    * @Description: 获取家庭消费记录
    * @Param: []
    * @return: com.common.Result<java.util.List<com.custody.entity.ConsumeTypeInformation>>
    * @Author: dj
    * @Date: 2022/4/2
    */
    @GetMapping("/getWpgRecord")
    public Result<List<ConsumeTypeInformation>> getWpgRecord(){
        List<ConsumeTypeInformation> list = consumeService.getWpgRecord();
        return Result.OK(list);
    }

}
