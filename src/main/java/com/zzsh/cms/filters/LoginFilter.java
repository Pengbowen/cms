package com.zzsh.cms.filters;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @program: cms
 * @description: 登录权限拦截器
 * @author: 彭博文
 * @create: 2018-08-10 21:21
 **/
public class LoginFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        String successUrl = "/blog/index";
        WebUtils.issueRedirect(request,response,successUrl);
        return false;
    }
}
