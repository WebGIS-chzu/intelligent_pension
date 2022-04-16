package com.monitor.controller;



import com.common.Result;
import com.monitor.entity.UserLocationInfo;
import com.monitor.entity.WpgCost;
import com.monitor.service.LifeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/monitor")
public class LifeController {

    @Autowired
    private LifeService lifeService;

    /**
    * @Description: 查询所有人的水电费消费情况
    * @Param: []
    * @return: com.common.Result<java.util.List<com.monitor.entity.WpgCost>>
    * @Author: dj
    * @Date: 2022/1/16
    */
    @GetMapping("/getAllWpgCost")
    public Result<List<WpgCost>> getAllWpgCost(){
        List<WpgCost> list = lifeService.getAllWpgCost();
        return Result.OK(list);
    }

    /**
    * @Description: 获取老人的路径轨迹及位置信息
    * @Param: []
    * @return: com.common.Result<java.util.List>
    * @Author: dj
    * @Date: 2022/1/21
    */
    @GetMapping("/getUserLocationInfo")
    public Result<List<UserLocationInfo>> getUserLocation(){
        List<UserLocationInfo> list = lifeService.getUserLocationInfo();
        return Result.OK(list);
    }


}
