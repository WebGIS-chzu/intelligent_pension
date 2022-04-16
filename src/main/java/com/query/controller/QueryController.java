package com.query.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.query.entity.*;
import com.query.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/query")
public class QueryController {
    @Autowired
    private QueryService queryService;

    /**
    * @Description: 根据条件查询护工所在的位置信息
    * @Param: [nursingQueryInformation]
    * @return: com.common.Result<java.util.List<com.query.entity.QueryTypeNumber>>
    * @Author: dj
    * @Date: 2022/3/20
    */
    @PostMapping("/queryNursingWorkerByCondition")
    public Result<List<QueryTypeNumber>> queryNursingWorkerByCondition(@RequestBody NursingWorkerQueryInformation nursingQueryInformation){
        String name = nursingQueryInformation.getName();
        String nursingId = nursingQueryInformation.getNursingId();
        Integer orderNumberMin = nursingQueryInformation.getOrderNumberMin();
        Integer orderNumberMax = nursingQueryInformation.getOrderNumberMax();
        Integer evaluateMin = nursingQueryInformation.getEvaluateMin();
        Integer evaluateMax = nursingQueryInformation.getEvaluateMax();
        List<QueryTypeNumber> list = queryService.queryNursingWorkerByCondition(name,nursingId,orderNumberMin,orderNumberMax,evaluateMin,evaluateMax);
        return Result.OK(list);
    }

    /**
    * @Description: 根据条件查询老人所在位置信息
    * @Param: [elderlyQueryInformation]
    * @return: com.common.Result<java.util.List<com.query.entity.QueryTypeNumber>>
    * @Author: dj
    * @Date: 2022/3/26
    */
    @PostMapping("/queryElderlyByCondition")
    public Result<List<QueryTypeNumber>> queryElderlyByCondition(@RequestBody ElderlyQueryInformation elderlyQueryInformation){
        String name = elderlyQueryInformation.getName();
        String idCardNumber = elderlyQueryInformation.getIdCardNumber();
        String[] address = elderlyQueryInformation.getAddress().split(",");
        String community = "";
        String building = "";
        String houseNumber = "";
        if (address.length>2){
            community = address[0];
            building = address[1];
            houseNumber = address[2];
        }
        Double heartRateMin = elderlyQueryInformation.getHeartRateMin();
        Double heartRateMax = elderlyQueryInformation.getHeartRateMax();
        Double bloodPressureMin = elderlyQueryInformation.getBloodPressureMin();
        Double bloodPressureMax= elderlyQueryInformation.getBloodPressureMax();
        List<QueryTypeNumber> list = queryService.queryElderlyByCondition(name,idCardNumber,community,building,houseNumber,heartRateMin,heartRateMax,bloodPressureMin,bloodPressureMax);
        return Result.OK(list);
    }

    /** 
    * @Description: 根据nursingId获取护工的基本信息、能力、订单信息
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.query.entity.NursingWorkerInformation>> 
    * @Author: dj
    * @Date: 2022/3/21
    */
    @PostMapping("/getNursingWorkerInformationByNursingId")
    public Result<List<NursingWorkerInformation>> getNursingWorkerInformationByNursingId(@RequestBody JSONObject jsonObject){
        String nursingId = jsonObject.getString("nursingId");
        List<NursingWorkerInformation> list = queryService.getNursingWorkerInformationByNursingId(nursingId);
        List<OrderInformation> orderInformationList = queryService.getOrderInformationByNursingId(nursingId);
        //给list的OrderInformation赋orderInformationList值
        list.forEach(list1 -> {
            list1.setOrderInformation(orderInformationList);
        });
        return Result.OK(list);
    }

    /** 
    * @Description: 根据userid获取老人的基本信息、身体健康数据、消费情况等数据
    * @Param: [jsonObject] 
    * @return: com.common.Result<java.util.List<com.query.entity.ElderlyInformation>> 
    * @Author: dj
    * @Date: 2022/3/26 
    */
    @PostMapping("/getElderlyInformationByUserid")
    public Result<List<ElderlyInformation>> getElderlyInformationByUserid(@RequestBody JSONObject jsonObject){
        String userid = jsonObject.getString("userid");
        List<ElderlyInformation> list = queryService.getElderlyInformationByUserid(userid);
        List<ElderlyBraceletInformation> wpgCostList = queryService.getWpgCostList(userid);
        list.forEach(list1 ->{
            list1.setWpgCostList(wpgCostList);
        });
        return Result.OK(list);
    }

    /**
    * @Description: 获取地址列表
    * @Param: []
    * @return: com.common.Result<java.util.List<com.query.entity.ElderlyQueryAddress>>
    * @Author: dj
    * @Date: 2022/3/23
    */
    @GetMapping("/getElderlyAddress")
    public Result<List<ElderlyQueryAddress>> getElderlyAddress(){
        List<ElderlyQueryAddress> list = queryService.getElderlyAddress();
        return Result.OK(list);
    }
}
