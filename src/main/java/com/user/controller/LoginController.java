package com.user.controller;



import com.alibaba.fastjson.JSONObject;
import com.common.Result;
import com.user.entity.User;
import com.user.service.UserInfoService;


import com.user.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.*;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Value("${intelligent.minio.minio_url}")
    private String miniourl;

//    @Value("${spring.redis.host}")
//    private String redishost;
//
//    @Value("${spring.redis.port}")
//    private Integer redisport;


    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTemplate redisTemplate;


//    /**
//    * @Description: 验证码方法
//    * @Param: [session]
//    * @return: void
//    * @Author: dj
//    * @Date: 2021/11/23
//    */
//    @GetMapping("/getCode")
//    public Result<Object> getCode(HttpSession session, HttpServletRequest request,HttpServletResponse response) throws IOException {
//        //生成验证码
////         String code = "abcd";
//
//        SetOperations setOperations = redisTemplate.opsForSet();
////        String key = SecurityUtils.getSubject().getPrincipal()+"code";
//        ValueOperations valueOperations = redisTemplate.opsForValue();
//
//        valueOperations.set("cd","aaaaaa");
//
//        return Result.OK();
//    }

    /**
     * @Description: 注册
     * @Param: [user]
     * @return: com.common.Result<?>
     * @Author: dj
     * @Date: 2021/11/28
     */
    @PostMapping("/register")
    public Result<?> register(@RequestBody User user) {
        User resultUser = userService.findByUserName(user.getUsername());
        if (!ObjectUtils.isEmpty(resultUser)) {
            return Result.error("注册失败，用户已存在");
        }
        try {
            userService.register(user);
            System.out.println("用户:" + user.getUsername() + "注册成功");
            return Result.OK("注册成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("注册失败", false);
        }
    }

    /**
     * @Description: 退出登录
     * @Param: []
     * @return: com.common.Result<?>
     * @Author: dj
     * @Date: 2021/11/28
     */
    @GetMapping("/logout")
    public Result<?> logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return Result.OK("退出成功");
    }

    /**
     * @Description: 登录
     * @Param: [jsonObject, session]
     * @return: com.common.Result<?>
     * @Author: dj
     * @Date: 2021/11/29
     */
    @PostMapping("/login")
    public Result<?> login(@RequestBody JSONObject jsonObject, HttpServletResponse httpServletResponse, HttpSession session) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
//        String requestCode = jsonObject.getString("code");
//        //比较验证码
//        String codes = "1";
//        codes = request.getHeader("code");
//        codes = session.getAttribute("code").toString();
        try {
            //获取主体对象
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
            System.out.println(httpServletResponse.getHeaderNames());
            System.out.println(httpServletResponse.getHeader("Set-Cookie"));
            String a = subString(httpServletResponse.getHeader("Set-Cookie"), "=", ";");
//            String a = httpServletResponse.getHeader("Set-Cookie").substring(0,httpServletResponse.getHeader("Set-Cookie").indexOf(";"));
            httpServletResponse.setHeader("JSESSIONID",a);
            System.out.println(a);
//                response.setHeader("username",username);
//                response.setHeader("userid",userInfoService.selectUserIdByUserName(username).toString());
//                request.getSession(false).setAttribute("username",username);
//                request.getSession(false).setAttribute("userid",userInfoService.selectUserIdByUserName(username));
            System.out.println("用户：" + username + "登陆成功");
            Result result = new Result();
            result.setMessage(a);
            result.setCode(200);
            result.setResult("登陆成功");
            return result;
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return Result.error("账号错误", false);
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            return Result.error("密码错误", false);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error("未知错误", false);
        }
    }

    public static String subString(String str, String strStart, String strEnd) {

        /* 找出指定的2个字符在 该字符串里面的 位置 */
        int strStartIndex = str.indexOf(strStart);
        int strEndIndex = str.indexOf(strEnd);

        /* index 为负数 即表示该字符串中 没有该字符 */
        if (strStartIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strStart + ", 无法截取目标字符串";
        }
        if (strEndIndex < 0) {
            return "字符串 :---->" + str + "<---- 中不存在 " + strEnd + ", 无法截取目标字符串";
        }

        /* 开始截取 */
        String result = str.substring(strStartIndex, strEndIndex).substring(strStart.length());
        return result;
    }
}
