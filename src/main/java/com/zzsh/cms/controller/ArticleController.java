package com.zzsh.cms.controller;

import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.pojo.Article;
import com.zzsh.cms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: cms
 * @description:
 * @author: 彭博文
 * @create: 2018-06-09 11:27
 **/
@Controller
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("add")
    public String addArticle(){
        return "add_article";
    }

    @RequestMapping("publish")
    @ResponseBody
    public Result publishArticle(Article article){
        return  articleService.addArticle(article);
    }

}
