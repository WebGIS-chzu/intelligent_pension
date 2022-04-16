package com.monitor.controller;

import com.common.Result;
import com.monitor.entity.DateTypeNumber;
import com.monitor.entity.ServiceDataTypeNumber;
import com.monitor.entity.TypeNumber;
import com.monitor.service.DatapanelService;
import com.social.entity.ActivityTypeNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dataPanel")
public class DatapanelController {

    @Autowired
    DatapanelService datapanelService;

    /**
    * @Description: 获取老人的状态（自理、半自理、失能）
    * @Param: []
    * @return: com.common.Result<java.util.List<com.monitor.entity.UserState>>
    * @Author: dj
    * @Date: 2022/2/20
    */
    @GetMapping("/getUserInformationState")
    public Result<List<TypeNumber>> getUserInformationState(){
        List<TypeNumber> typeNumberList = datapanelService.getUserInformationState();
        return Result.OK(typeNumberList);
    }

    /** 
    * @Description: 获取上周服务结构及其数值
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.monitor.entity.TypeNumber>> 
    * @Author: dj
    * @Date: 2022/2/20 
    */
    @GetMapping("/getServiceStructure")
    public Result<List<TypeNumber>> getServiceStructure(){
        List<TypeNumber> serviceStructure = datapanelService.getServiceStructure();
        return Result.OK(serviceStructure);
    }

    /** 
    * @Description: 获取医疗服务的具体结构及其数值
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.monitor.entity.TypeNumber>> 
    * @Author: dj
    * @Date: 2022/2/20 
    */
    @GetMapping("/getTreatmentValues")
    public Result<List<TypeNumber>> getTreatmentValues(){
        List<TypeNumber> treatmentList = datapanelService.getTreatmentValues();
        return Result.OK(treatmentList);
    }

    /** 
    * @Description: 获取护工评价排名
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.monitor.entity.TypeNumber>>
    * @Author: dj
    * @Date: 2022/2/21 
    */
    @GetMapping("/getNursingWorkersEvaluate")
    public Result<List<ServiceDataTypeNumber>> getNursingWorkersEvaluate(){
        List<ServiceDataTypeNumber> evaluateList = datapanelService.getNursingWorkersEvaluate();
        List<String> list = new ArrayList();
        list.add("休闲娱乐");
        list.add("家庭便利");
        list.add("家政服务");
        list.add("心理慰藉");
        list.add("医疗服务");
        evaluateList.forEach(evaluateListT ->{
            for(int j = 0; j< list.size(); j++) {
                int m = 0;
                for (int i = 0; i < evaluateListT.getValue().size(); i++) {
                    if (!list.get(j).equals(evaluateListT.getValue().get(i).getName())) {
                        m++;
                    }
                }
                if (m == evaluateListT.getValue().size())
                    evaluateListT.getValue().add(new TypeNumber(list.get(j), 0));
            }
        });
        return Result.OK(evaluateList);
    }

    /**
    * @Description: 获取健康异常类型及数目
    * @Param: []
    * @return: com.common.Result<java.util.List<com.monitor.entity.TypeNumber>>
    * @Author: dj
    * @Date: 2022/2/21
    */
    @GetMapping("/getAbnormalHealth")
    public Result<?> getAbnormalHealth(){
        List<DateTypeNumber> list = new ArrayList();
        DateTypeNumber dateTypeNumber = new DateTypeNumber();
        DateTypeNumber dateTypeNumber2 = new DateTypeNumber();
        //获取本周和上周的异常数据
        List<TypeNumber> typeNumberList = datapanelService.getAbnormalHealth();
        //获取本周的异常数据
        dateTypeNumber.setValue(typeNumberList.subList(0,6));
        dateTypeNumber.setName("本周");
        list.add(dateTypeNumber);
        //获取上周的异常数据
        dateTypeNumber2.setValue(typeNumberList.subList(6,12));
        dateTypeNumber2.setName("上周");
        list.add(dateTypeNumber2);

        return Result.OK(list);
    }

    /**
    * @Description: 获取年龄组情况
    * @Param: []
    * @return: com.common.Result<java.util.List<com.monitor.entity.TypeNumber>>
    * @Author: dj
    * @Date: 2022/2/21
    */
    @GetMapping("/getAgeGroup")
    public Result<List<TypeNumber>> getAgeGroup(){
        List<TypeNumber> ageGroupList = datapanelService.getAgeGroup();
        return Result.OK(ageGroupList);
    }

}
