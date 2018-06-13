package com.zzsh.cms.service;

import com.zzsh.cms.commons.pojo.Result;
import com.zzsh.cms.pojo.Article;

/**
 * 文章操作服务
 */
public interface ArticleService {

    /**
     * 新增文章
     * @param article
     * @return
     */
    Result addArticle(Article article);

    /**
     * 根据文章类别查询文章
     * @param cid
     * @return
     */
    Result listArticleByCId(int cid);

    /**
     * 修改文章
     * @param article
     * @return
     */
    Result updateArticle(Article article);
}
