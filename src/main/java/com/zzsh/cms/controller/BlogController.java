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
 * @description:
 * @author: 彭博文
 * @create: 2018-06-17 09:38
 **/
@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("index")
    public String toBlogIndex(Model model){
        List<Article> articles = articleService.listArticleByCId(1);
        model.addAttribute("articles",articles);
        return "blog/lw-index";
    }
}
