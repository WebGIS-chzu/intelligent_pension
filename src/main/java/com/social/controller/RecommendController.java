package com.social.controller;

import com.alibaba.druid.util.StringUtils;
import com.common.Result;
import com.social.entity.RecommendInfor;
import com.social.entity.RecommendInformation;
import com.social.entity.RecommendQueryCondition;
import com.social.entity.RecommendResemble;
import com.social.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/social/recommend")
public class RecommendController {

    @Autowired
    private RecommendService recommendService;


    /** 
    * @Description: 按条件智能推荐
    * @Param: [recommendQueryCondition] 
    * @return: com.common.Result<?> 
    * @Author: dj
    * @Date: 2022/4/3 
    */
    @PostMapping("/getRecommendElderlyByCondition")
    public Result<?> getRecommendElderlyByCondition(@RequestBody RecommendQueryCondition recommendQueryCondition){
        String userid= recommendQueryCondition.getUserid();
        String dateRange = recommendQueryCondition.getDateRange();
        Integer radius = recommendQueryCondition.getRadius();
        Double resemble = recommendQueryCondition.getResemble();
        List<RecommendInformation> list = recommendService.getRecommendInformation(dateRange,radius);
        final int[] i = {0};
        final int[] m = {0};
        List<RecommendInformation> list5 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.forEach(list1 -> {
            i[0]++;
            if (list1.getUserid().equals(userid)){
                list2.add(i[0]-1);
            }
        });
        if (list2.size() == 0)
            return Result.error("未找到合适的人选，请尝试调整匹配条件","未找到合适的人选，请尝试调整匹配条件");
        if (list2.get(0)!=0){
            for (int l = list2.size()-1; l >=0; l--) {
                list.remove(list2.get(l).intValue());
            }
        }
        List<RecommendInformation> list1 = recommendService.getRecommendInformationT(userid,dateRange);
        Double a = Math.ceil(list1.get(0).getRecommendPlace().size() * resemble);
        list.forEach(list3 ->{
            final int[] n = {0};
            m[0]++;
            list3.getRecommendPlace().forEach(list4 ->{
                for (int j = 0; j < list1.get(0).getRecommendPlace().size(); j++) {
                    if(list4.getPlace_id().equals(list1.get(0).getRecommendPlace().get(j).getPlace_id())){
                        n[0]++;
                    }
                }
            });
            if (n[0] >= a)
                list5.add(list.get(m[0]-1));
        });
        if (list5.size()==0)
            return Result.error("未找到合适的人选，请尝试调整匹配条件","未找到合适的人选，请尝试调整匹配条件");
        List<RecommendInfor> recommendInforList = new ArrayList<>();
        list5.forEach(list6 ->{
            recommendInforList.add(
                    new RecommendInfor(recommendService.getRecommenSimplelyInformation(list6.getUserid()),
                            recommendService.getRecommendResemble(list6.getUserid())
                            )
            );
        });
        recommendInforList.forEach(list6 -> {
            Double d = 0.0;
            for (int j = 0; j < list6.getRecommendResemble().size(); j++) {
                d = d + list6.getRecommendResemble().get(j).getValue();
            }
            list6.getRecommendResemble().add(new RecommendResemble("匹配度",d/3));
        });
        Collections.sort(recommendInforList);
        return Result.OK(recommendInforList);
    }
}
