package com.example.dxpzk.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zk
 * @since 2020-03-14
 */
/**
 * 登录配置
 */
@Configuration
public class MvcConfigure implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry){

    }
}
