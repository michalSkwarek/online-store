package com.skwarek.onlineStore.dao.impl;

import com.skwarek.onlineStore.dao.CategoryDao;
import com.skwarek.onlineStore.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.domain.product.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 27.09.2016.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category, Long> implements CategoryDao {

}
