package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.dao.CategoryDao;
import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.service.CategoryService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michal on 27.09.2016.
 */
@Service("categoryService")
public class CategoryServiceImpl extends GenericServiceImpl<Category, Long> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;
}
