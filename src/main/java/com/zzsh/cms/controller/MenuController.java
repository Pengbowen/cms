package com.zzsh.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzsh.cms.pojo.Menu;
import com.zzsh.cms.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: cms
 * @description: 菜单管理（操作）
 * @author: 彭博文
 * @create: 2018-06-03 15:43
 **/
@RequestMapping("menu")
@Controller
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    @RequestMapping
    public String viewMenuList(Model model){
        List<Menu> allMenus = menuService.getAllMenus();
        model.addAttribute("menus", JSONObject.toJSONString(allMenus));
        return "menuslist";
    }
}
