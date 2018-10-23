package com.zzsh.cms.configurations;

import com.zzsh.cms.commons.util.OsUtil;
import com.zzsh.cms.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
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
@PropertySource("classpath:blog_setting.properties")
public class WebAppConfig implements WebMvcConfigurer {


    @Value("${file.windows.uploadfolder}")
    private String  windowsSavePath;

    @Value("${file.linux.uploadfolder}")
    private String  linuxSavePath;

    @Value("${accesss_path}")
    private String accessPath;

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        //设置不拦截静态资源
        excludePath.add("/");
        excludePath.add("/toLogin");
        excludePath.add("/login");
        excludePath.add("/amaze/**");
        excludePath.add("/css/**");
        excludePath.add("/img/**");
        excludePath.add("/js/**");
        excludePath.add("/layer/**");
        excludePath.add("/layui/**");
        excludePath.add("/upload/**");
        excludePath.add("/error");
        excludePath.add("/blog/**");
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(excludePath);
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //根据不同的操作系统配置文件路径
        if(OsUtil.onWindows()){
            registry.addResourceHandler(accessPath+"**").addResourceLocations("file:"+windowsSavePath);
        }else{
            registry.addResourceHandler(accessPath+"**").addResourceLocations("file:"+linuxSavePath);
        }
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
