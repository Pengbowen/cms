package com.zzsh.cms.mapper;

import com.zzsh.cms.pojo.Role;
import com.zzsh.cms.pojo.Permission;
import com.zzsh.cms.pojo.User;
import com.zzsh.cms.pojo.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserMapperTest {
    @Autowired
    private UserMapper dao;
    @Test
    public void test1(){
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(1);
        List<User> users = dao.selectByExample(example);
        User user = users.get(0);
        for (Role r: user.getRoles()) {
            System.out.println(r.getRoleName());
            Set<Permission> permissions = r.getPermissions();
            for (Permission p:permissions) {
                System.out.println(p.getPermissionName());
            }

        }
        }

}