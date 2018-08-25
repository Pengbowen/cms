package com.zzsh.cms.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzsh.cms.commons.pojo.PageData;
import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.mapper.ArticleMapper;
import com.zzsh.cms.pojo.Article;
import com.zzsh.cms.pojo.ArticleExample;
import com.zzsh.cms.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: cms
 * @description: 文章操作服务实现类
 * @author: 彭博文
 * @create: 2018-06-13 07:46
 **/
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper mapper;

    @Override
    public Result addArticle(Article article) {
        mapper.insertSelective(article);
        return Result.SUCCESS;
    }

    @Override
    public Result listResultArticleByCId(int cid) {
        List<Article> articles = listArticleByCId(cid);
        Result result =Result.SUCCESS;
        result.setData(articles);
        return result;
    }

    @Override
    public List<Article> listArticleByCId(int cid) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        PageHelper.startPage(1,10);
        List<Article> articles = mapper.selectByExample(example);
        return articles;
    }

    @Override
    public PageData<Article> listPageArticleByCId(int cid) {
        ArticleExample example = new ArticleExample();
        ArticleExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(cid);
        PageHelper.startPage(1,3);
        List<Article> articles = mapper.selectByExample(example);
        return null;
    }

    @Override
    public Article getArticleById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Result updateArticle(Article article) {
        mapper.updateByPrimaryKeyWithBLOBs(article);
        return Result.SUCCESS;
    }
}
