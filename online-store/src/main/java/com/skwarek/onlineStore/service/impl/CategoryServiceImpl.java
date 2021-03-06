package com.skwarek.onlineStore.service.impl;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.service.CategoryService;
import com.skwarek.onlineStore.service.generic.GenericServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Michal on 27.09.2016.
 */
@Service("categoryService")
@Transactional(propagation = Propagation.REQUIRED)
public class CategoryServiceImpl extends GenericServiceImpl<Category, Long> implements CategoryService {

}
