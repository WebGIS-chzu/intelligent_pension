package com.custody.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.custody.entity.AbnormalTypeInformation;
import com.custody.entity.CustodyAbnormalTypeNumber;
import com.custody.entity.UsersInformation;
import com.custody.service.MonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/custody/monitor")
public class MonitorController {

    @Autowired
    private MonitorService monitorService;
    /** 
    * @Description: 根据监控异常类型获取用户位置等信息
    * @Param: [jsonObject] 
    * @return: com.common.Result<?> 
    * @Author: dj
    * @Date: 2022/2/25 
    */
    @PostMapping("/getMonitorAbnormalUserByAbnormal")
    public Result<?> getMonitorAbnormalUserByAbnormal(@RequestBody JSONObject jsonObject){
        String monitorAbnormal = jsonObject.getString("abnormalName");
        List<AbnormalTypeInformation> monitorAbnormalList = monitorService.getMonitorAbnormalUserByAbnormal(monitorAbnormal);
        return Result.OK(monitorAbnormalList);
    }

    /** 
    * @Description: 获取监控的异常类型及数量
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.custody.entity.MonitorAbnormalTypeNumber>> 
    * @Author: dj
    * @Date: 2022/2/25
    */
    @GetMapping("/getMonitorAbnormalTypeNumber")
    public Result<List<CustodyAbnormalTypeNumber>> getMonitorAbnormalTypeNumber(){
        List<CustodyAbnormalTypeNumber> list = monitorService.getMonitorAbnormalTypeNumber();
        return Result.OK(list);
    }

    /** 
    * @Description: 获取监控异常的用户信息
    * @Param: [] 
    * @return: com.common.Result<?> 
    * @Author: dj
    * @Date: 2022/2/25 
    */
    @PostMapping("/getMonitorAbnormalUserInformation")
    public Result<?> getMonitorAbnormalUserInformation(@RequestBody JSONObject jsonObject){
        String monitorAbnormal = jsonObject.getString("abnormalName");
        List<UsersInformation> list = monitorService.getMonitorAbnormalUserInformation(monitorAbnormal);
        return Result.OK(list);
    }
}
