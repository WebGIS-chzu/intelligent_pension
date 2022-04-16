package com.social.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.social.entity.*;
import com.social.service.ChainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/social/chain")
public class ChainController {

    @Autowired
    private ChainService chainService;

    /**
    * @Description: 获取所有老人的位置
    * @Param: []
    * @return: com.common.Result<java.util.List<com.social.entity.ChainTypeNumber>>
    * @Author: dj
    * @Date: 2022/4/2
    */
    @GetMapping("/getElderlyLocation")
    public Result<List<ChainTypeNumber>> getElderlyLocation(){
        List<ChainTypeNumber> list = chainService.getElderlyLocation();
        return Result.OK(list);
    }


    /**
    * @Description: 根据userid获取用户信息
    * @Param: [jsonObject]
    * @return: com.common.Result<java.util.List<com.social.entity.ChainUserInfor>>
    * @Author: dj
    * @Date: 2022/4/2
    */
    @PostMapping("/getUserInformationByUserId")
    public Result<List<ChainUserInfor>> getUserInformationByUserId(@RequestBody JSONObject jsonObject){
        String userid = jsonObject.getString("userid");
        List<ChainUserInfor> list = chainService.getUserInformationByUserId(userid);
        return Result.OK(list);
    }

    /**
    * @Description: 根据用户名或userid获取用户的社交图谱
    * @Param: [jsonObject]
    * @return: com.common.Result<java.lang.Object>
    * @Author: dj
    * @Date: 2022/4/2
    */
    @PostMapping("/getUserChainByCondition")
    public Result<Object> getUserChainByCondition(@RequestBody JSONObject jsonObject){
        String userid = jsonObject.getString("userid");
        String name = jsonObject.getString("name");
        String userids = userid;
        if (name.equals("") && userid.equals(""))
            return Result.error("必要的参数值缺失，请检查","必要的参数值缺失，请检查");
        if (!name.equals(""))
        userids = chainService.getUserId(name);
        if ("".equals(userids) || userids == null)
            return Result.error("该用户不存在", "该用户不存在");
        ChainUserInformation chainUserInformation = new ChainUserInformation();
        List<ChainNodeList> chainNodeList = chainService.getChainNodeListByCondition(userid,name);
        List<ChainLinkList> chainLinkList = chainService.getChainLinkListByCondition(userid,name);
        List<ChainTypeNumber> chainTypeNumberList = new ArrayList<>();
        chainNodeList.forEach(chainNodeList1 -> {
            chainTypeNumberList.add(chainService.getElderlyLocationById(chainNodeList1.getUserid()));
        });
        chainUserInformation.setUserid(userids);
        chainUserInformation.setNodeList(chainNodeList);
        chainUserInformation.setLinkList(chainLinkList);
        chainUserInformation.setTypeNumberList(chainTypeNumberList);
        return Result.OK(chainUserInformation);
    }

}
