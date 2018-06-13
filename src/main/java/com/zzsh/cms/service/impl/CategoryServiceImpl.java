package com.zzsh.cms.service.impl;

import com.zzsh.cms.mapper.CategoryMapper;
import com.zzsh.cms.pojo.Category;
import com.zzsh.cms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: cms
 * @description: 文章类别服务实现
 * @author: 彭博文
 * @create: 2018-06-13 08:10
 **/
@Service("categoryService")
public class CategoryServiceImpl  implements CategoryService{

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAllCategory() {
        return mapper.selectAllCategorys();
    }
}
