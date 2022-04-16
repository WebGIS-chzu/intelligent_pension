package com.user.config;

import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.filter.authc.UserFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setHeader( "Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        // 允许请求的方法
        httpServletResponse.setHeader( "Access-Control-Allow-Methods", "POST,GET,OPTIONS,DELETE,PUT" );
        // 多少秒内，不需要再发送预检验请求，可以缓存该结果
        httpServletResponse.setHeader( "Access-Control-Max-Age", "3600" );
        // 表明它允许跨域请求包含xxx头
        httpServletResponse.setHeader( "Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
        //是否允许浏览器携带用户身份信息（cookie）
        httpServletResponse.setHeader( "Access-Control-Allow-Credentials", "true" );
        httpServletResponse.setHeader( "Access-Control-Expose-Headers", "*" );


        PrintWriter out = httpServletResponse.getWriter();
        JSONObject json = new JSONObject();
        json.put("state","403");
        json.put("msg","登录已失效，请重新登录！");
        out.println(json);
        out.flush();
        out.close();
        return false;
    }

}
