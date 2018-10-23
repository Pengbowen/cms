package com.zzsh.cms.controller;

import com.zzsh.cms.pojo.Article;
import com.zzsh.cms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program: cms
 * @description: 后台管理页面跳转控制器
 * @author: 彭博文
 * @create: 2018-06-19 20:42
 **/
@RequestMapping("admin")
@Controller
public class AdminViewController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("articles")
    public String articlesManage(Model model){
            List<Article> articleList = articleService.listArticleByCId(1);
            model.addAttribute("articles",articleList);
            return "admin/articleslist";
    }
}
