package com.zzsh.cms.service;

import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.pojo.Menu;

import java.util.List;

/**
 * 菜单
 * @date 2018年6月3日 2018年6月3日
 * @author 彭博文的计算机
 */
public interface MenuService {

    /**
     * 获取所有的父级菜单
     * @return
     */
    List<Menu> getAllMenus();

}
