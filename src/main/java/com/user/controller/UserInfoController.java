package com.user.controller;


import com.common.Result;
import com.user.entity.Bracelet;
import com.user.entity.UserInfo;
import com.user.service.UserInfoService;
import io.minio.MinioClient;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.InputStream;



@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Value("${intelligent.minio.minio_url}")
    private String miniourl;

    @Value("${intelligent.minio.minio_accessKey}")
    private String accessKey;

    @Value("${intelligent.minio.minio_secretKey}")
    private String secretKey;

    private String bucketName = "headsculpture";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserInfoService userInfoService;
    /**
    * @Description: 修改用户资料
    * @Param: [userInfo]
    * @return: com.common.Result<java.lang.Boolean>
    * @Author: dj
    * @Date: 2021/11/30
    */
    @PostMapping("/updateInfoByUserId")
    public Result<Boolean> updateInfoByUserId(@RequestBody UserInfo userInfo){
        //按id修改数据
       Boolean updateResult =  userInfoService.updateInfoByUserId(userInfo);
        if (updateResult){
            return Result.OK(updateResult);
        }else {
            return Result.error("修改失败",false);
        }

    }


    /**
    * @Description: 获取用户资料
    * @Param: [session]
    * @return: com.common.Result<com.user.entity.UserInfo>
    * @Author: dj
    * @Date: 2021/12/5
    */
    @GetMapping("/getInfoByUserId")
    public Result<UserInfo> getInfoByUserId(){
        String principal = SecurityUtils.getSubject().getPrincipal().toString();
        System.out.println(principal);
        UserInfo getUserInfo = userInfoService.getInfoByUserName(principal);
        return Result.OK(getUserInfo);
    }

    /**
    * @Description: 上传头像
    * @Param: [file]
    * @return: com.common.Result<?>
    * @Author: dj
    * @Date: 2021/11/30
    */
    @PostMapping("/uploadUserHeadCulpture")
    public Result<?> uploadUserHeadCulpture(@RequestParam MultipartFile file, HttpSession session){
        if (file == null)
            return Result.error("上传失败，请上传图片",false);
        String contentType = file.getContentType();
        if (!"image/jpeg".equals(contentType)&&!"image/tiff".equals(contentType)&&!"image/png".equals(contentType))
            return Result.error("上传失败，请上传图片",false);
        InputStream inputStream = null;
        try {
            //获取userid
//            Integer userid = (Integer) session.getAttribute("userid");
            String username = SecurityUtils.getSubject().getPrincipal().toString();
            MinioClient minioClient = new MinioClient(miniourl,accessKey,secretKey);

            String fileName = username + file.getOriginalFilename();
             inputStream = file.getInputStream();
             //上传头像文件
            minioClient.putObject(bucketName,fileName,inputStream,contentType);
            //根据username获取filename
            String filename = userInfoService.selectFilenameByUserName(username);
            //如果filename不为空就删除对应的文件
            if (filename!=null){
                minioClient.removeObject("headsculpture",filename);
            }
            //根据username获取userid
            Integer userid = userInfoService.getUserIdByUserName(username);
            //修改userinfo中的文件地址
           Boolean result = userInfoService.UpdataHeadpByUserId(userid,miniourl+"headsculpture/"+fileName,fileName);

           if (result){
            return Result.OK("上传头像成功");
           }else {
               return Result.error("上传失败",false);
           }
        }catch (Exception e){
            e.printStackTrace();
            return Result.error("上传失败",false);
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return Result.error("文件流关闭失败");
            }
        }
    }

    /**
    * @Description: 获取头像
    * @Param: [session]
    * @return: com.common.Result<java.lang.String>
    * @Author: dj
    * @Date: 2021/12/5
    */
    @GetMapping("/getUserHeadCulpture")
    public Result<String> getUserHeadCulpture(HttpSession session){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        String headCulpture = userInfoService.getHeadCupptureByUserName(username);
        return Result.OK(headCulpture);
    }

    /**
    * @Description: 获取手环数据
    * @Param: [session]
    * @return: com.common.Result<com.user.entity.Bracelet>
    * @Author: dj
    * @Date: 2021/12/8
    */
    @GetMapping("/getUserBraceletInfo")
    public Result<Bracelet> getUserBraceletInfo(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        Bracelet bracelet = userInfoService.getUserBraceletInfoByUserName(username);
        return Result.OK(bracelet);
    }
}
