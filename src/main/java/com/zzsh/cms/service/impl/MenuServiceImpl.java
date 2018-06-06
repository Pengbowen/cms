package com.zzsh.cms.service.impl;

import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.mapper.MenuMapper;
import com.zzsh.cms.pojo.Menu;
import com.zzsh.cms.pojo.MenuExample;
import com.zzsh.cms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cms
 * @description: 菜单操作实现类
 * @author: 彭博文
 * @create: 2018-06-03 15:05
 **/
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private static final Integer DEFAULT_PARENT_ID = 0;

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getAllMenus() {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        //添加查询条件--只查询父id为0的菜单信息
        criteria.andPidEqualTo(DEFAULT_PARENT_ID);
        List<Menu> menus = menuMapper.selectByExample(example);
        return menus;
    }

    @Override
    public Result addMenu(Menu menu) {
        int r = menuMapper.insertSelective(menu);
        Result result = r > 0 ? Result.SUCCESS : Result.FAIL;
        return result;
    }

    @Transactional
    @Override
    public Result deleteMenu(int mid) {
        int r = menuMapper.deleteByPrimaryKey(mid);
        Result result = r > 0 ? Result.SUCCESS : Result.FAIL;
        return result;
    }

    @Transactional
    @Override
    public Result updateMenu(Menu menu) {
        int r = menuMapper.updateByPrimaryKeySelective(menu);
        Result result = r > 0 ? Result.SUCCESS : Result.FAIL;
        return result;
    }
}
