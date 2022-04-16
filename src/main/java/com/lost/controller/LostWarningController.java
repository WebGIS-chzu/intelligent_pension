package com.lost.controller;

import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.lost.entity.BeLostUserInformation;
import com.lost.entity.LostFindInformation;
import com.lost.entity.LostTypeNumber;
import com.lost.service.LostWarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lost/lostWarning")
public class LostWarningController {

    @Autowired
    private LostWarningService lostWarningService;

    /**
    * @Description: 查看走失人员信息
    * @Param: []
    * @return: com.common.Result<java.util.List<com.lost.entity.BeLostUserInformation>
    * @Author: dj
    * @Date: 2022/2/26
    */
    @GetMapping("/getBelostUserInformation")
    public Result<List<BeLostUserInformation>> getBelostUserInformation(){
        List<BeLostUserInformation> beLostUserInformationList = lostWarningService.getBelostUserInformation();
        for (BeLostUserInformation list : beLostUserInformationList){
            list.setNodeList(lostWarningService.getNodeList(list.getUserid()));
            list.setLinkList(lostWarningService.getLinkList(list.getUserid()));
        }
        return Result.OK(beLostUserInformationList);
    }

//    /**
//    * @Description: 根据userid修改其找回状态
//    * @Param: [jsonObject]
//    * @return: com.common.Result<java.lang.Boolean>
//    * @Author: dj
//    * @Date: 2022/3/13
//    */
//    @PostMapping("/updateLostState")
//    public Result<Object> updateLostStateByUserid(@RequestBody JSONObject jsonObject){
//        String lostState = jsonObject.getString("lostState");
//        Integer userid = jsonObject.getInteger("userid");
//        if (lostState.equals(null) ||lostState.equals("") || userid == null || userid.equals(""))
//            return Result.error("lostState或userid不能为空");
//        Boolean result = lostWarningService.updateLostStateByUserid(lostState,userid);
//        return Result.OK(result);
//    }

    /** 
    * @Description: 获取走失老人的寻找情况
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.lost.entity.LostFindInformation>> 
    * @Author: dj
    * @Date: 2022/3/13 
    */
    @GetMapping("/getLostFindInformation")
    public Result<List<LostFindInformation>> getLostFindInformation(){
        List<LostFindInformation> list = lostWarningService.getLostFindInformation();
        return Result.OK(list);
    }

    /** 
    * @Description: 插入走失老人寻找情况
    * @Param: [lostFindInformation] 
    * @return: com.common.Result<java.lang.Object> 
    * @Author: dj
    * @Date: 2022/3/13 
    */
    @PostMapping("/insertLostFindInformationByUserid")
    public Result<Object> insertLostFindInformationByUserid(@RequestBody LostFindInformation lostFindInformation){
        Integer userid = lostFindInformation.getUserid();
        String name = lostFindInformation.getName();
        Integer age = lostFindInformation.getAge();
        String date = lostFindInformation.getDate();
        String lostState = lostFindInformation.getLostState();
        String find_location = lostFindInformation.getFind_location();
        Boolean deleteResult = true;
        if (lostState == null || lostState.equals(""))
            return Result.error("lostState不能为空","lostState不能为空");
        if (lostState.equals("是"))
             deleteResult = lostWarningService.deleteLostInformation(userid);
        if (!deleteResult)
            return Result.error("删除对象失败，请重新尝试提交","删除对象失败，请重新尝试提交");
        if (userid == null || userid.equals("") ||name.equals("") || name.equals(null) || age == null || age.equals("null") || date.equals("") || date.equals(null) || find_location.equals("") || find_location.equals(null))
        return Result.error("所需字段不能为空","所需字段不能为空");
        Boolean result = lostWarningService.insertLostFindInformationByUserid(userid,name,age,date,find_location,lostState);
        return Result.OK(result);
    }

//    /**
//    * @Description: 走失老人登记
//    * @Param: [beLostUserInformation]
//    * @return: com.common.Result<java.lang.Object>
//    * @Author: dj
//    * @Date: 2022/3/13
//    */
//    @PostMapping("/insertUserLostInformationByUserid")
//    public Result<Object> insertUserLostInformation(@RequestBody BeLostUserInformation beLostUserInformation){
//        Integer userid = beLostUserInformation.getUserid();
//        String name = beLostUserInformation.getName();
//        Integer age = beLostUserInformation.getAge();
//        String lostDate = beLostUserInformation.getLostDate();
//        String lostLocation = beLostUserInformation.getLostLocation();
//        String resultName = lostWarningService.getUserInformationByUserid(userid);
//        if (resultName == null || resultName.equals(""))
//            return Result.error("该用户ID不存在，请检查","该用户ID不存在，请检查");
//        if (!name.equals(resultName))
//            return Result.error("输入的用户姓名与用户ID不一致，请检查","输入的用户姓名与用户ID不一致，请检查");
//        Boolean result = lostWarningService.insertUserLostInformation(userid,name,age,lostDate,lostLocation);
//        if (!result)
//            return Result.error("插入失败，请重新尝试","插入失败，请重新尝试");
//        return Result.OK(result);
//    }

    /** 
    * @Description: 获取上方标签及其数量
    * @Param: [] 
    * @return: com.common.Result<java.util.List<com.lost.entity.LostTypeNumber>> 
    * @Author: dj
    * @Date: 2022/3/16 
    */
    @GetMapping("/getLostTypeInformation")
    public Result<List<LostTypeNumber>> getLostTypeInformation(){
        List<LostTypeNumber> list = lostWarningService.getLostTypeInformation();
        return Result.OK(list);
    }


}
