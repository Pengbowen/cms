package com.zzsh.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzsh.cms.mapper.MenuMapper;
import com.zzsh.cms.pojo.Menu;
import com.zzsh.cms.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: cms
 * @description: 视图跳转控制器
 * @author: 彭博文
 * @create: 2018-05-17 20:38
 **/
@Controller
@RequestMapping("/")
public class ViewController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    /**
     * 进入默认登陆页面
     * @return
     */
    @RequestMapping()
    public String toLogin(){
        return "login";
    }

    /**
     * 进入主页
     * @return
     */
    @RequestMapping("index")
    public String toIndex(Model model){
        List<Menu> menuList = menuService.getAllMenus();
        model.addAttribute("menus", JSONObject.toJSONString(menuList));
        return "/index";
    }

    /**
     * 进入默认登陆页面
     * @return
     */
    @RequestMapping("test")
    public String toTest(@Param("title") String title, Model model){
        model.addAttribute("title",title);
        logger.info("title=[{}]",title);
        return "test";
    }


}
