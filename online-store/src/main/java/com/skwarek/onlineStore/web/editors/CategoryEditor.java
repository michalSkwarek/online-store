package com.skwarek.onlineStore.web.editors;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.service.CategoryService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Michal on 28.09.2016.
 */
public class CategoryEditor extends PropertyEditorSupport {

    private CategoryService categoryService;

    public CategoryEditor(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        long id = Long.parseLong(text);
        Category category = categoryService.getById(id);
        setValue(category);
    }
}
