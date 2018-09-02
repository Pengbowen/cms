package com.zzsh.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.zzsh.cms.mapper.MenuMapper;
import com.zzsh.cms.pojo.Article;
import com.zzsh.cms.pojo.Menu;
import com.zzsh.cms.service.ArticleService;
import com.zzsh.cms.service.MenuService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private ArticleService articleService;
    /**
     * 进入后台主页
     * @return
     */
    @RequestMapping("admin")
    public String toAdminIndex(Model model){
        List<Menu> menuList = menuService.getAllMenus();
        model.addAttribute("menus", JSONObject.toJSONString(menuList));
        return "admin/index";
    }

    /**
     * 进入默认登陆页面
     * @return
     */
    @RequestMapping()
    public String toIndex(Model model){
        List<Article> articles = articleService.listArticleByCId(1);
        model.addAttribute("articles",articles);
        return "blog/lw-index";
    }
    /**
     * 进入登陆页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(Model model){
        List<Menu> menuList = menuService.getAllMenus();
        model.addAttribute("menus", JSONObject.toJSONString(menuList));
        return "login";
    }


    @RequestMapping(value ="blog/{pageName}")
    public String toBlogPage(@PathVariable("pageName") String pageName){
        return  "blog/"+pageName;
    }
    @GetMapping("blog/read/{articleId}")
    public String readArticle(@PathVariable("articleId") Integer articleId,Model model){
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article",article);
        return "blog/lw-article-fullwidth";
    }


}
