package com.zzsh.cms.interceptors;

import com.zzsh.cms.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @program: cms
 * @description: 登录权限拦截器
 * @author: 彭博文
 * @create: 2018-08-10 20:52
 **/
public class LoginInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(!Objects.isNull(user)){
            return  true;
        }
        response.sendRedirect("/toLogin");
        return false;
    }


}
