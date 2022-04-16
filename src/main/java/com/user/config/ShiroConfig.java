package com.user.config;

import com.user.shiro.realms.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 用来整合shiro相关的配置类
 * */
@Configuration
public class ShiroConfig {



    //1.创建shiroFilter   //负责拦截所有请求
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //配置系统受限资源
        Map<String,String> map = new HashMap<>();
        map.put("/user/**","anon");
//        map.put("/userInfo/**","anon");
//        map.put("/register.jsp","anon");//anon 设置为公共资源
//        map.put("/**","anon");//anon 设置为公共资源
//        map.put("/**","authc");//authc 请求这个资源需要认证和授权

        LinkedHashMap<String, Filter> map1 = new LinkedHashMap<>();
        map1.put("authc",new MyFormAuthenticationFilter());

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setFilters(map1);

        //默认认证界面路径
//        shiroFilterFactoryBean.setLoginUrl("/login.jsp");

        //配置系统公共资源
        return shiroFilterFactoryBean;
    }

    //2.创建安全管理器
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();

        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);
        defaultWebSecurityManager.setSessionManager(sessionManager());

        return defaultWebSecurityManager;
    }

    //3.创建自定义realm
    @Bean
    public Realm getRealm(){
        CustomerRealm customerRealm = new CustomerRealm();
        //修改凭证校验匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法为MD5
        credentialsMatcher.setHashAlgorithmName("md5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);
        customerRealm.setCredentialsMatcher(credentialsMatcher);
        //开启缓存管理
//        customerRealm.setCacheManager(new RedisCacheManger());
        customerRealm.setCacheManager(new EhCacheManager());
        customerRealm.setCachingEnabled(true);//开启全局缓存
        customerRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        customerRealm.setAuthenticationCacheName("authenticationCache");
        customerRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        customerRealm.setAuthorizationCacheName("authorizationCache");


        return customerRealm;
    }

    public DefaultWebSessionManager sessionManager() {
        CustomSessionManager sessionManager = new CustomSessionManager();
        return sessionManager;
    }
//    public RedisSessionDAO redisSessionDAO() {
//        RedisSessionDAO sessionDAO = new RedisSessionDAO();
//        sessionDAO.setRedisManager(redisManager());
//        return sessionDAO;
//    }
//
//
//    public DefaultWebSessionManager sessionManager() {
//        CustomSessionManager sessionManager = new CustomSessionManager();
//        sessionManager.setSessionDAO(redisSessionDAO());
//        return sessionManager;
//    }


}
