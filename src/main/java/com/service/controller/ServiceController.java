package com.service.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.service.entity.ServiceInformation;
import com.service.entity.ServiceMaxTypeNumber;
import com.service.entity.ServiceTypeNumber;
import com.service.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService service;

    /** 
    * @Description: 根据服务类型获取服务订单详情
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.service.entity.ServiceInformation>> 
    * @Author: dj
    * @Date: 2022/3/6 
    */
    @PostMapping("/getServiceOrderInformationByServiceType")
    public Result<List<ServiceInformation>> getServiceOrderInformation(@RequestBody JSONObject jsonObject){
        String serviceType = jsonObject.getString("serviceType");
        List<ServiceInformation> list = service.getServiceOrderInformation(serviceType);
        return Result.OK(list);
    }

    /** 
    * @Description: 根据服务类型获取护工在线数量和服务数量
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.service.entity.ServiceTypeNumber>> 
    * @Author: dj
    * @Date: 2022/3/6
    */
    @PostMapping("/getNursingWorkersServiceNumber")
    public Result<List<ServiceTypeNumber>> getNursingWorkersServiceNumber(@RequestBody JSONObject jsonObject){
        String serviceType = jsonObject.getString("serviceType");
        List<ServiceTypeNumber> list = service.getNursingWorkersServiceNumber(serviceType);
        return Result.OK(list);
    }

    /** 
    * @Description: 根据服务类型获取护工评价等级及数量
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.service.entity.ServiceTypeNumber>> 
    * @Author: dj
    * @Date: 2022/3/6 
    */
    @PostMapping("/getNursingWorkersLevelNumber")
    public Result<List<ServiceMaxTypeNumber>> getNursingWorkersLevelNumber(@RequestBody JSONObject jsonObject){
        String serviceType = jsonObject.getString("serviceType");
        List<ServiceMaxTypeNumber> list = service.getNursingWorkersLevelNumber(serviceType);
        return Result.OK(list);
    }

    /**
    * @Description: 根据服务类型获取词云数据
    * @Param: [jsonObject]
    * @return: com.common.Result<java.util.List<com.service.entity.ServiceTypeNumber>>
    * @Author: dj
    * @Date: 2022/3/7
    */
    @PostMapping("/getServiceWordsNumber")
    public Result<List<ServiceTypeNumber>> getServiceWordsNumber(@RequestBody JSONObject jsonObject){
        String serviceType = jsonObject.getString("serviceType");
        List<ServiceTypeNumber> list = service.getServiceWordsNumber(serviceType);
        return Result.OK(list);
    }
}
