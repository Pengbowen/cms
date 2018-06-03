package com.zzsh.cms.mapper;

import com.zzsh.cms.pojo.Permission;
import com.zzsh.cms.pojo.Role;
import com.zzsh.cms.pojo.RoleExample;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleMapperTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void selectByExample() throws Exception {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andRidEqualTo(1);
        List<Role> roles = roleMapper.selectByExample(example);
        for(Role r:roles){
            HashSet<Permission> permissions = r.getPermissions();
            for(Permission p:permissions){
                System.out.println(p.getPermissionName());
            }
        }
        Assert.assertNotNull(roles);
    }
}