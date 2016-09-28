package com.skwarek.onlineStore.web.controller;

import com.skwarek.onlineStore.domain.product.Category;
import com.skwarek.onlineStore.domain.product.Manufacturer;
import com.skwarek.onlineStore.domain.product.Product;
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
@RequestMapping(value = { "/products" })
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String showProducts(Model model) {

        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        return "products/list";
    }

    @RequestMapping("/{id}")
    public String getProductById(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.getById(id));
        return "products/specifications";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.GET)
    public String createProduct(Model model) {

        model.addAttribute("product", new Product());
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "products/productData";
    }

    //TODO
    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String addProduct(Product product) {

//        product.getManufacturer().setBrand(manufacturer);
        productService.save(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.GET)
    public String getProduct(@PathVariable Long id, Model model) {

        Product product = productService.getById(id);
        model.addAttribute("product", product);
        List<Manufacturer> manufacturers = manufacturerService.getAll();
        model.addAttribute("manufacturers", manufacturers);
        return "products/productData";
    }

    //TODO
    @RequestMapping(value = {"/edit/{id}"}, method = RequestMethod.POST)
    public String updateProduct(@PathVariable Long id, Product product) {

        productService.update(product);
        return "redirect:/products/list";
    }

    @RequestMapping(value = {"/delete/{id}"}, method = RequestMethod.GET)
    public String deleteProduct(@PathVariable Long id) {

        productService.removeProduct(id);
        return "redirect:/products/list";
    }

    @RequestMapping(value = {"/list/manufacturer/{manufacturer}"}, method = RequestMethod.GET)
    public String showProductsByManufacturer(@PathVariable String manufacturer, Model model) {

        List products = productService.getProductsByManufacturer(manufacturer);
        if (products == null || products.isEmpty()) {
            // TODO: 25.09.2016 Create alert
        }
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/list/category/{category}"}, method = RequestMethod.GET)
    public String showProductsByCategory(@PathVariable String category, Model model) {

        List products = productService.getProductsByCategory(category);
        if (products == null || products.isEmpty()) {
            // TODO: 25.09.2016 Create alert
        }
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/list/price/ascending"}, method = RequestMethod.GET)
    public String showSortedProductsOrderByUnitPriceAscending(Model model) {

        List products = productService.getSortedProductsOrderByUnitPriceAscending();
        model.addAttribute("products", products);
        return "/products/list";
    }

    @RequestMapping(value = {"/list/price/descending"}, method = RequestMethod.GET)
    public String showSortedProductsOrderByUnitPriceDescending(Model model) {

        List products = productService.getSortedProductsOrderByUnitPriceDescending();
        model.addAttribute("products", products);
        return "/products/list";
    }
}