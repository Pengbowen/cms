package com.zzsh.cms.controller;

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

    @RequestMapping("add")
    public String addArticle(){
        return "add_article";
    }

}
