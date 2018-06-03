package com.zzsh.cms.service;

import com.zzsh.cms.pojo.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: cms
 * @description: Shiro自定义验证域
 * @author: 彭博文
 * @create: 2018-05-20 22:56
 **/
public class ShiroRealm  extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 身份验证(定义验证规则)
     * 验证规则:
     *         1.获取用户输入的账号
     *         2.定义加密规则为 MD5,加盐,加密1024次
     *         3.从数据库中获取用户信息
     *         4.交给shiro进行验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录用户名
        String account = (String) authenticationToken.getPrincipal();
        User userInfo = userService.getUserByAccount(account);
        //如果用户不存在 return null
//        if(Objects.isNull(userInfo)){
//            return  null;
//        }
        //获取用户密码和加密盐
        //String pwd = userInfo.getPassword();
        //String salt = userInfo.getSalt();
        String pwd = "2e03053c99bc4fe462ea9c05485cdc3e";
        String username = "111";
        String salt = "pbw";
        ByteSource criendiatalSalt = ByteSource.Util.bytes(salt);
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username,pwd,criendiatalSalt,getName());
        return info;
    }

    public static void main(String[] args) {
        int hashIterations = 100;//加密的次数
        Object salt = "pbw";//盐值
        Object credentials = "222";//密码
        String hashAlgorithmName = "MD5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
                salt, hashIterations);
        System.out.println("加密后的值----->" + simpleHash);
    }
}
