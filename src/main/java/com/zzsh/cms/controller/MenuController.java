package com.zzsh.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.pojo.Menu;
import com.zzsh.cms.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: cms
 * @description: 菜单管理（操作）
 * @author: 彭博文
 * @create: 2018-06-03 15:43
 **/
@RequestMapping("/admin/menu")
@Controller
public class MenuController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    /**
     * 进入菜单管理页面
     * @param model
     * @return
     */
    @RequestMapping
    public String viewMenuList(Model model){
        List<Menu> allMenus = menuService.getAllMenus();
        model.addAttribute("menus", JSONObject.toJSONString(allMenus));
        return "admin/menuslist";
    }

    /**
     * 添加菜单
     * @param menu
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result addMenu(Menu menu){
        return   menuService.addMenu(menu);
    }

    /**
     * 删除菜单
     * @param mid
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Result delMenu( int  mid){
        logger.info("菜单id:[{}]",mid);
        return   menuService.deleteMenu(mid);
    }

    /**
     * 更新菜单信息
     * @param menu
     * @return
     */
    @RequestMapping("update")
    @ResponseBody
    public Result updateMenu( Menu menu){
        return   menuService.updateMenu(menu);
    }



}
