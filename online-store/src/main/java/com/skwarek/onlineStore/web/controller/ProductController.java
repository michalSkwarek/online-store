package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.data.entity.product.Category;
import com.skwarek.onlineStore.data.entity.product.Manufacturer;
import com.skwarek.onlineStore.data.entity.product.Product;
import com.skwarek.onlineStore.service.CategoryService;
import com.skwarek.onlineStore.service.ManufacturerService;
import com.skwarek.onlineStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Michal on 26.09.2016.
 */
@Controller
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return "products/list";
    }

    @RequestMapping(value = {"/list", "/category/**"}, method = RequestMethod.POST)
    public String showProducts(Model model, @RequestParam(value = "category", required = false) String[] categories,
                               @RequestParam(value = "manufacturer", required = false) String[] manufacturers,
                               @RequestParam(value = "fromPriceRange") String low,
                               @RequestParam(value = "toPriceRange") String high,
                               @RequestParam String priceOrder) {

        List<Product> products = productService.findProductsByFilter(categories, manufacturers, low, high, priceOrder);
        if (products == null || products.isEmpty()) {
            return "/error";
        }
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return "/products/list";
    }

    @RequestMapping(value = "/{id}")
    public String getProductById(Model model, @PathVariable Long id) {

        model.addAttribute("product", productService.read(id));
        return "products/specifications";
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public String showProductsByCategory(Model model, @PathVariable String category) {

        List products = productService.findProductsByCategory(category);
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return "/products/list";
    }

    private void addAllCategoriesAndManufacturersToModel(Model model) {
        List<Category> categoriesAll = categoryService.getAll();
        model.addAttribute("categories", categoriesAll);
        List<Manufacturer> manufacturersAll = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturersAll);
    }
}