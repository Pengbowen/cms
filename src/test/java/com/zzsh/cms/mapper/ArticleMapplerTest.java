package com.zzsh.cms.mapper;

import com.zzsh.cms.pojo.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArticleMapplerTest {
    @Autowired
    private ArticleMapper articleMapper;

    @Test
    public void selectByExample() throws Exception {
        Article article = articleMapper.selectByPrimaryKey(17);
        System.out.println(article.getCategory().getCategoryName());
    }
}