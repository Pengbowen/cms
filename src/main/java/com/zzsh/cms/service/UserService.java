package com.zzsh.cms.service;

import com.zzsh.cms.pojo.User;

/**
 * @program: cms
 * @description: 用户Service
 * @author: PengBowen
 * @create: 2018-05-20 23:05
 **/
public interface UserService {
    /**
    * @description:根据账号查询用户
    *
    * @params: account 用户账号（唯一）
    * 
    * @return:  User实例
    *
    * @author: PengBowen
    *
    * @date: 2018/5/20 23:20
    **/
    User getUserByAccount(String account);
}
