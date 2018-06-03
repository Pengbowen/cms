package com.zzsh.cms.mapper;

import com.alibaba.fastjson.JSONObject;
import com.zzsh.cms.pojo.*;
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
public class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    @Test
    public void selectByExample() throws Exception {
        Menu menu = menuMapper.selectByPrimaryKey(1);
        System.out.println(JSONObject.toJSONString(menu));
    }
}