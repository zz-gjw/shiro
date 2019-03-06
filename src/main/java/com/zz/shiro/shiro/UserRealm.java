package com.zz.shiro.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Author : zz-gjw
 * @Date : 2019/3/5 9:58
 * @Description: 自定义用户的Realm类
 *  实现登录许可方法和用户授权方法
 */
public class UserRealm extends AuthorizingRealm {
    //授权   查询登录用户的所有的权限，并返回
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    //认证  登录许可 标记是否登录成功
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取传递的令牌
        UsernamePasswordToken userToken= (UsernamePasswordToken) token;
        //验证令牌是否为空
        if(userToken.getUsername()!=null){
            //创建认证信息  参数说明：1、用户名 2、密码 3、realm的名字
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(userToken.getUsername(),userToken.getPassword(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
