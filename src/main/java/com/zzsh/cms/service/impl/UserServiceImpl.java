package com.zzsh.cms.service.impl;/**
 * @program: cms
 * @description: 用户Service实现类
 * @author: PengBowen
 * @create: 2018-05-20 23:13
 **/

import com.zzsh.cms.pojo.User;
import com.zzsh.cms.pojo.UserExample;
import com.zzsh.cms.service.UserService;
import com.zzsh.cms.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cms
 *
 * @description: 用户Service实现类
 *
 * @author: 彭博文
 *
 * @create: 2018-05-20 23:13
 **/
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User getUserByAccount(String account) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        //添加查询条件()
        criteria = criteria.andAccountEqualTo(account);
        List<User> users = mapper.selectByExample(example);
        if(!users.isEmpty()){
            return  users.get(0);
        }
        return null;
    }

}
