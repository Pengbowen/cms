package com.zzsh.cms.configurations;

import com.zzsh.cms.interceptors.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: cms
 * @description: SpringBoot 主要配置
 * [注意] 实现此类需要重写设置静态资源拦截
 * @author: 彭博文
 * @create: 2018-05-18 23:25
 **/
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //设置不拦截静态资源
        excludePath.add("/");
        excludePath.add("/login");
        excludePath.add("/amaze/**");
        excludePath.add("/css/**");
        excludePath.add("/img/**");
        excludePath.add("/js/**");
        excludePath.add("/layer/**");
        excludePath.add("/layui/**");
        excludePath.add("/upload/**");
        excludePath.add("/error");
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
