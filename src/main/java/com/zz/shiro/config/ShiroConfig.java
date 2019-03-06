package com.zz.shiro.config;

import com.zz.shiro.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : zz-gjw
 *  * @Date : 2019/3/5 9:56
 *  * @Description:
 */
@Configuration//标记这是一个配置
public class ShiroConfig {

    //1、生成Realm对象
    @Bean
    public UserRealm createRealm(){
        return new UserRealm();
    }
    //2、生成权限管理器
    @Bean
    public DefaultWebSecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        webSecurityManager.setRealm(userRealm);
        return webSecurityManager;
    }
    //3、配置过滤器工厂
    @Bean
    public ShiroFilterFactoryBean createShiroFilter(DefaultWebSecurityManager webSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置三个路径 一个管理器
        factoryBean.setLoginUrl("login.html");//登录页面
        factoryBean.setSuccessUrl("index.html");//成功页面
        factoryBean.setUnauthorizedUrl("error.html");//失败页面
        factoryBean.setSecurityManager(webSecurityManager);//设置管理器

        //设置放行和拦截的资源
        Map<String, String> map = new HashMap<>();
        //放行静态资源 css、js、图片 最好都在同一个文件夹中
        //anon 表示不用登录就可以访问
        //authc  必须登录之后才可以访问
        map.put("/media/**","anon");
        map.put("/login.html","anon");
        map.put("/userlogin.do","anon");
        //剩下全部拦截
        map.put("/**","authc");

        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }
}
