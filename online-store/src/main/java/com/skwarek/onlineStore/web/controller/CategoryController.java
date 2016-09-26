package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.domain.product.Category;
import com.skwarek.onlineStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Controller
@RequestMapping(value = { "/categories" })
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String showCategories(Model model) {

        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "categories/list";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createCategory(Model model) {

        model.addAttribute("category", new Category());
        return "categories/categoryData";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addCategory(Category category) {

        categoryService.save(category);
        return "redirect:/categories/list";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.GET)
    public String getCategory(@PathVariable Long id, Model model) {

        Category category = categoryService.getById(id);
        model.addAttribute("category", category);
        return "categories/categoryData";
    }

    @RequestMapping(value = { "/edit/{id}" }, method = RequestMethod.POST)
    public String updateCategory(@PathVariable Long id, Category category) {

        categoryService.update(category);
        return "redirect:/categories/list";
    }

    @RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.GET)
    public String deleteCategory(@PathVariable Long id) {

        Category toDelete = categoryService.getById(id);
        categoryService.remove(toDelete);
        return "redirect:/categories/list";
    }
}
