package com.zzsh.cms.controller;/**
 * @program: cms
 * @description:
 * @author: PengBowen
 * @create: 2018-05-21 19:03
 **/

import com.zzsh.cms.commons.pojo.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public Result login(String account, String password){
        Result result = null;
        UsernamePasswordToken token = new UsernamePasswordToken(account,password);
        try {
            //获取当前的Subject
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.login(token);
            result = Result.SUCCESS;
        } catch (UnknownAccountException uae) {
            //未知账户
            log.info("There is no user with username of " + token.getPrincipal());
            result = Result.FAIL;
        } catch (IncorrectCredentialsException ice) {
            //密码错误
            log.info("Password for account " + token.getPrincipal() + " was incorrect!");
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
