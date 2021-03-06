package com.skwarek.onlineStore.data.dao.impl;

import com.skwarek.onlineStore.data.dao.CategoryDao;
import com.skwarek.onlineStore.data.dao.generic.GenericDaoImpl;
import com.skwarek.onlineStore.data.entity.product.Category;
import org.springframework.stereotype.Repository;

/**
 * Created by Michal on 20/01/2017.
 */
@Repository("categoryDao")
public class CategoryDaoImpl extends GenericDaoImpl<Category, Long> implements CategoryDao {

}
