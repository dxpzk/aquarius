package com.aquarius.config;

import com.aquarius.interceptor.CustomRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zk
 * @since 2020-03-23
 */
@Configuration
public class ShiroConfig {
    /**
     * shiro的过滤器，可以设置登录页面（setLoginUrl）、权限不足跳转页面（setUnauthorizedUrl）、具体某些页面的权限控制或者身份认证
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //需要登录的接口:如果访问某个接口,需要登录却没有登录,则调用此接口,如果前端后端不分离,则跳转到html页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        //登录成功,但是没有权限,未授权就会调用这个接口,如果不是前后端分离,则跳转到403页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/notRole");

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/login", "anon");
        //登录用户才可以访问
        filterChainDefinitionMap.put("/authc/**", "authc");

        //管理员角色才可以访问
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");

        //有编辑权限才可以访问
        filterChainDefinitionMap.put("/video/update", "perms[video_update]");

        //坑二:过滤器是顺序执行,从上而下,一般来说/** 放到最下面

        //authc: url定义必须通过认证才可以访问
        //anno:  url可以匿名访问
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截 剩余的都需要认证
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;

    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();
        defaultSecurityManager.setRealm(customRealm());
        return defaultSecurityManager;
    }

    /**
     * 数据域
     * @return
     */
    @Bean
    public CustomRealm customRealm() {
        CustomRealm customRealm = new CustomRealm();
        return customRealm;
    }
}
