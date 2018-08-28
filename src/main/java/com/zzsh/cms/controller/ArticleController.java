package com.zzsh.cms.controller;

import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.pojo.Article;
import com.zzsh.cms.pojo.Category;
import com.zzsh.cms.service.ArticleService;
import com.zzsh.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("add")
    public String addArticle(Model model){

        List<Category> categoryList = categoryService.getAllCategory();
        model.addAttribute("categoryList",categoryList);
        return "add_article";
    }

    @RequestMapping("publish")
    @ResponseBody
    public Result publishArticle(Article article){
        //TODO 设置作者id
        article.setAuthorId(1);
        return  articleService.addArticle(article);
    }

    @GetMapping("read/{articleId}")
    public String readArticle(@PathVariable("articleId") Integer articleId,Model model){
        Article article = articleService.getArticleById(articleId);
        model.addAttribute("article",article);
        return "blog/lw-article-fullwidth";

    }
    @PostMapping("del")
    @ResponseBody
    public Result<String> delArticle(int id){
        return articleService.delArticle(id);
    }

}
