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

    private final static String VIEWS_PRODUCTS_LIST = "products/list";
    private final static String VIEWS_PRODUCT_SPECIFICATIONS = "products/specifications";
    private final static String VIEWS_ERROR = "error";

    private final ProductService productService;
    private final CategoryService categoryService;
    private final ManufacturerService manufacturerService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, ManufacturerService manufacturerService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.manufacturerService = manufacturerService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return VIEWS_PRODUCTS_LIST;
    }

    @RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
    public String showProductsByCategory(Model model, @PathVariable String category) {

        List products = productService.findProductsByCategory(category);
        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return VIEWS_PRODUCTS_LIST;
    }

    @RequestMapping(value = {"/list", "/category/**"}, method = RequestMethod.POST)
    public String showProductsByFilter(Model model, @RequestParam(value = "category", required = false) String[] categories,
                               @RequestParam(value = "manufacturer", required = false) String[] manufacturers,
                               @RequestParam(value = "fromPriceRange") String lowPrice,
                               @RequestParam(value = "toPriceRange") String highPrice,
                               @RequestParam String priceOrder) {

        List<Product> products = productService.findProductsByFilter(categories, manufacturers, lowPrice, highPrice, priceOrder);

        if (products == null || products.isEmpty()) {
            return VIEWS_ERROR;
        }

        model.addAttribute("products", products);
        addAllCategoriesAndManufacturersToModel(model);
        return VIEWS_PRODUCTS_LIST;
    }

    @RequestMapping(value = "/{id}")
    public String showProduct(Model model, @PathVariable Long id) {

        model.addAttribute("product", productService.read(id));
        return VIEWS_PRODUCT_SPECIFICATIONS;
    }

    private void addAllCategoriesAndManufacturersToModel(Model model) {

        List<Category> categoriesAll = categoryService.findAll();
        model.addAttribute("categories", categoriesAll);
        List<Manufacturer> manufacturersAll = manufacturerService.findAll();
        model.addAttribute("manufacturers", manufacturersAll);
    }
}