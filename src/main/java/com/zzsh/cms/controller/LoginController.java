package com.zzsh.cms.controller;/**
 * @program: cms
 * @description:
 * @author: PengBowen
 * @create: 2018-05-21 19:03
 **/

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.HttpResponse;
import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @program: cms
 * @description:
 * @author: 彭博文
 * @create: 2018-05-21 19:03
 **/
@Controller
@RequestMapping("/login")
public class LoginController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping()
    @ResponseBody
    public Result login(String account, String password, HttpServletResponse response, HttpServletRequest request){
        Result result = null;
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        try {
            //获取当前的Subject
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            User user = (User) subject.getPrincipal();
            System.out.println(JSONObject.toJSONString(user));
            subject.getSession();
            result = Result.SUCCESS;
            //登录成功!
        } catch (UnknownAccountException uae) {
            //未知账户
            log.info("没有这个账户: " + token.getPrincipal());
            result = Result.FAIL;
        } catch (IncorrectCredentialsException ice) {
            //密码错误
            log.info("此账户: " + token.getPrincipal() + " 的密码错误!");
            result = Result.FAIL;
        } catch (LockedAccountException lae) {
            //账户被锁定
            log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
            result = Result.FAIL;
        }
        catch (AuthenticationException ae) {
            log.info("Login error,Plaease check your accout or password is corecct");
            result = Result.FAIL;
        }
        return  result;
    }
}
