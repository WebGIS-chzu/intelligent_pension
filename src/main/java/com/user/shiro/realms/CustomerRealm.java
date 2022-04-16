package com.user.shiro.realms;
import com.user.entity.Perms;
import com.user.entity.User;
import com.user.service.UserService;
import com.user.shiro.salt.MyByteSource;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

//自定义realm
public class CustomerRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        //获取身份信息
        String principal = principalCollection.getPrimaryPrincipal().toString();
        System.out.printf("调用授权验证" +principal);
        //根据主身份信息获取角色和权限信息
        User user = userService.findRolesByUserName(principal);
        //授权角色信息
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            user.getRoles().forEach(role -> {
                simpleAuthorizationInfo.addRole(role.getName());
                //权限信息
                List<Perms> perms = userService.findPermsByRoleId(role.getId());
                if(!CollectionUtils.isEmpty(perms)){
                    perms.forEach(perm -> {
                        simpleAuthorizationInfo.addStringPermission(perm.getName());
                    });
                }
            });
            return simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取身份信息
        String principal = authenticationToken.getPrincipal().toString();
        System.out.println(authenticationToken.getPrincipal());
        System.out.println(authenticationToken.getCredentials());
//        //在工厂中获取service对象
//        UserService userService = (UserService) ApplicationContextUtil.getBean("UserService");
        User user = userService.findByUserName(principal);
//        String password = new SimpleHash("md5",user.getPassword(),user.getSalt(),1024).toString();
        if (!ObjectUtils.isEmpty(user)){
            return new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),
                    new MyByteSource(user.getSalt()),this.getName());
        }
         return null;
    }
}
