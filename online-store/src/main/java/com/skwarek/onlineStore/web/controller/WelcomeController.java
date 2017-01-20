package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.service.CategoryService;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Michal on 27.09.2016.
 */
@Controller
public class WelcomeController {

    private final static String VIEWS_HOME_PAGE = "homePage";

    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;
    private final ProductService productService;

    @Autowired
    public WelcomeController(CategoryService categoryService, ManufacturerService manufacturerService, ProductService productService) {
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
        this.productService = productService;
    }

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String showWelcomePage(Model model) {

        model.addAttribute("welcome", "Welcome to our online store!");

        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        List<Manufacturer> manufacturers = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturers);

        List products = productService.findRandomFewProducts();
        model.addAttribute("products", products);

        return VIEWS_HOME_PAGE;
    }
}

